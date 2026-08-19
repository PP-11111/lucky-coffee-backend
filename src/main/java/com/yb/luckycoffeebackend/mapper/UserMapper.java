package com.yb.luckycoffeebackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yb.luckycoffeebackend.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}