package com.learn.mybatisplus.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.mybatisplus.demo.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyUserMapper extends BaseMapper<MyUser> {

}
