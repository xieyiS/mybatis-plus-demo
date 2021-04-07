package com.learn.mybatisplus.demo;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.AbstractChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.mybatisplus.demo.entity.MyUser;
import com.learn.mybatisplus.demo.entity.User;
import com.learn.mybatisplus.demo.mapper.MyUserMapper;
import com.learn.mybatisplus.demo.mapper.UserMapper;
import com.learn.mybatisplus.demo.service.impl.MyUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Autowired
    private MyUserMapper myUserMapper;
    @Test
    public void test2() {
        System.out.println(("----- test2 ------"));
        List<MyUser> userList = myUserMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void test3() {
        System.out.println(("----- test3 ------"));
        Properties properties = System.getProperties();

        properties.forEach((k,v)->System.out.println(k + " : " + v));
    }

    @Autowired
    private MyUserServiceImpl myUserService;

    @Test
    public void test4() {
        System.out.println(("----- test4 ------"));
        MyUser byId = myUserService.getById(1);
        System.out.println(byId);
    }

    @Test
    public void test5() {
        System.out.println(("----- test5 ------"));
        System.out.println(myUserService.listByIds(Arrays.asList(1,2)));
    }

    @Test
    public void test6() {
        List<Map<String, Object>> maps = myUserService.listMaps();
        List<Object> objects = myUserService.listObjs();
        System.out.println(maps);
        System.out.println(objects);
    }

    @Test
    public void test7() {
        Page<MyUser> myUserPage = new Page<>();
        myUserPage.setSize(2);
        myUserPage.setCurrent(2);
        Page<MyUser> page = myUserService.page(myUserPage);
        System.out.println(page);
    }

    @Test
    public void test8() {
        QueryWrapper<MyUser> myUserQueryWrapper = new QueryWrapper<>();
        //myUserQueryWrapper.eq("my_name","a").eq(true,"my_id",1);

        myUserQueryWrapper.lambda().eq(MyUser::getMyId,2);
        //new LambdaQueryWrapper<MyUser>()

        List<MyUser> list = myUserService.list(myUserQueryWrapper);
        System.out.println(list);
    }

    @Test
    public void test9() {
        MyUser myUser = new MyUser();
        myUser.setMyId(4L);

        myUserService.saveOrUpdate(myUser);
    }

    @Test
    public void test10() {
        MyUser myUser = new MyUser();
        myUser.setMyId(7L);
        myUser.setMyName("g");

        myUserService.saveOrUpdate(myUser);

        //myUserService.removeById(6L);
        /*QueryWrapper<MyUser> myUserQueryWrapper = new QueryWrapper<>();
        myUserQueryWrapper.lambda().eq(MyUser::getMyId,6).eq(MyUser::getDeleted,1);
        myUserService.getOne(myUserQueryWrapper);*/
    }

    @Test
    public void testAR() {
        MyUser myUser = new MyUser();
        myUser.setMyId(3L);

        MyUser myUser1 = myUser.selectById(myUser);
        System.out.println(myUser1);
    }

    @Test
    public void testAR2() {
        MyUser myUser = new MyUser();
        myUser.setMyId(8L);
        myUser.setMyName("g1");
        myUser.setMyEmail(null);

        boolean b = myUser.insertOrUpdate();
    }

}
