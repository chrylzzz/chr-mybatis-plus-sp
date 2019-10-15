package com.chryl.controller;

import com.chryl.dto.User;
import com.chryl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chryl on 2019/10/15.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/g1")
    public String add() {
        User user = new User();
        user.setId("889");
        user.setUserName("chtyy");
        user.setUserPassowrd("mqoo");
        userService.add(user);
        return "suc";
    }
}
