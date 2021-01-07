package com.chryl;

import com.chryl.dto.User;
import com.chryl.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChrMybatisPlusSpApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void contextLoads() {

        System.out.println(
                userService.selectPage(1, 10)

        );
    }

    //查
    @Test
    public void contextLoads2() {

        System.out.println(
                userService.selectList()

        );
    }

    //add
    @Test
    public void contextLoads3() {

        User user = new User();
        user.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(1, 9));
        user.setAdmin(false);//false-0;true-1
        user.setUserName("找找中按照");
        user.setUserPassowrd("aaaaaaaa");

        userService.add(user);


    }

}
