package com.yb.luckycoffeebackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yb.luckycoffeebackend.entity.DrinkRecipe;
import com.yb.luckycoffeebackend.mapper.DrinkRecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/drink")
public class DrinkController {

    @Autowired
    private DrinkRecipeMapper drinkRecipeMapper;

    /**
     * 搜索饮品接口
     * 访问示例: http://localhost:8080/api/drink/search?q=拿铁
     */
    @GetMapping("/search")
    public List<DrinkRecipe> search(@RequestParam(defaultValue = "") String q) {
        QueryWrapper<DrinkRecipe> wrapper = new QueryWrapper<>();
        // 模糊查询：产品名称 或 配方中包含关键字
        wrapper.like("product_name", q).or().like("recipe_formula", q);
        return drinkRecipeMapper.selectList(wrapper);
    }
}