package com.yb.luckycoffeebackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("drink_recipes") // 对应数据库表名
public class DrinkRecipe {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String productName;   // 饮品名称
    private String productGroup;  // 分组
    private String temperatureType; // 温度类型
    private String recipeFormula; // 配方
}