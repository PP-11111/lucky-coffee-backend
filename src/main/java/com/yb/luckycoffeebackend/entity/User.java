package com.yb.luckycoffeebackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor; // ⚠️ 如果有有参构造，加上这个
import lombok.Data;
import lombok.NoArgsConstructor;  // ⚠️ 强制生成无参构造

@Data
@NoArgsConstructor // ⚠️ 确保有这个注解
@AllArgsConstructor
@TableName("users")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String role;
}