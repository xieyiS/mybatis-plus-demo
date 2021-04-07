package com.learn.mybatisplus.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.mybatisplus.demo.entity.MyUser;
import com.learn.mybatisplus.demo.mapper.MyUserMapper;
import com.learn.mybatisplus.demo.service.IMyUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-03-15
 */
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUser> implements IMyUserService {

}
