package com.chryl.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chryl.dto.User;
import com.chryl.service.UserService;
import com.chryl.util.PageParam;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.sql.Wrapper;
import java.util.Random;
import java.util.UUID;

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

    //亚米测试mybatis-plus,测试 @Valid
    @PostMapping("/valid")
    public Object zm(@Valid @RequestBody User user) {
        user.setId(UUID.randomUUID().toString().replace("-", "").substring(4, 15));
        userService.add(user);
        return "valid_success";
    }

    public static void main(String[] args) {
        User user = new User("chiyulin", "ppp123456");
        String s = JSON.toJSONString(user, true);
        System.out.println(s);
    }

}
