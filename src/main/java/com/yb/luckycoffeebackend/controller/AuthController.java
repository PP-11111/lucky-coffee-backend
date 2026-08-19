package com.yb.luckycoffeebackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yb.luckycoffeebackend.entity.User;
import com.yb.luckycoffeebackend.mapper.UserMapper;
import com.yb.luckycoffeebackend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> params) {
        Map<String, Object> result = new HashMap<>();

        // 从 Map 中获取用户名和密码
        String username = params.get("username");
        String password = params.get("password");

        if (username == null || password == null) {
            result.put("code", 400);
            result.put("msg", "参数缺失");
            return result;
        }

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(wrapper);

        if (user != null && user.getPassword().equals(password)) {
            String token = JwtUtil.createToken(user.getUsername());
            result.put("code", 200);
            result.put("msg", "登录成功");
            result.put("token", token);
            result.put("user", user);
        } else {
            result.put("code", 401);
            result.put("msg", "用户名或密码错误");
        }
        return result;
    }

    // ⚠️ 新增：获取当前用户信息接口
    // ... existing code ...
    @GetMapping("/info")
    public Map<String, Object> getUserInfo(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        Map<String, Object> result = new HashMap<>();

        if (authHeader == null || authHeader.isEmpty()) {
            result.put("code", 401);
            result.put("msg", "未提供认证令牌");
            return result;
        }

        try {
            String token = authHeader.replace("Bearer ", "");
            String username = JwtUtil.getUsernameFromToken(token);
// ... existing code ...


            if (username != null) {
                LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(User::getUsername, username);
                User user = userMapper.selectOne(wrapper);

                result.put("code", 200);
                result.put("data", user);
            } else {
                result.put("code", 401);
                result.put("msg", "Token 无效");
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "解析失败");
        }
        return result;
    }
}