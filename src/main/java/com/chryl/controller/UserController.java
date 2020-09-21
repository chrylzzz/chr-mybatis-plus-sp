package com.chryl.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chryl.dto.User;
import com.chryl.service.UserService;
import com.chryl.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.Random;

/**
 * Created by Chryl on 2019/10/15.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //添加
    @GetMapping("/add")
    public String add() {
        User user = new User();
        user.setId("889" + Math.random() * 1000000);
        user.setUserName("chtyy");
        user.setUserPassowrd("mqoo");
        userService.add(user);
        return "suc";
    }

    //亚米测试mybatis-plus
    @GetMapping("/yami")
    public Object show() {
        PageParam<User> pageParam = new PageParam<>();
        QueryWrapper<User> wrapper = new QueryWrapper<>();//方法一
        wrapper.like("user_name", "a");
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();//方法二
        return userService.page(pageParam, wrapper);

    }
}
