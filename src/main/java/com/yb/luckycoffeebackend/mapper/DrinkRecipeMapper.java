package com.yb.luckycoffeebackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yb.luckycoffeebackend.entity.DrinkRecipe;
import org.apache.ibatis.annotations.Mapper;

@Mapper // ⚠️ 必须加这个注解，否则会出现你刚才看到的 WARN
public interface DrinkRecipeMapper extends BaseMapper<DrinkRecipe> {
    // BaseMapper 已经提供了增删改查的所有基础方法，不需要额外写 SQL
}