package com.chryl;

import com.chryl.dto.ChrOrder;
import com.chryl.dto.User;
import com.chryl.mapper.ChrOrderMapper;
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
    @Autowired
    private ChrOrderMapper chrOrderMapper;

    @Test
    public void selectPage() {

        System.out.println(
                userService.selectPage(1, 10)

        );
    }

    //查
    @Test
    public void selectList() {

        System.out.println(
                userService.selectList()

        );
    }

    //save
    @Test
    public void save() {

        User user = new User();
        user.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(1, 9));
        user.setAdmin(false);//false-0;true-1
        user.setUserName("找找中按照");
        user.setUserPassowrd("aaaaaaaa");
        userService.add(user);
    }


    //saveOrder
    @Test
    public void saveOrder() {
        ChrOrder chrOrder = new ChrOrder();
        //id自动生成策略
        chrOrder.setOrderName("我的订单1");
        chrOrderMapper.insert(chrOrder);
    }

    @Test
    public void updateOrderById() {
        ChrOrder chrOrder = new ChrOrder();
        //id自动生成策略
        chrOrder.setOrderId(2L);
        chrOrder.setOrderName("我的订单2");
        chrOrderMapper.updateById(chrOrder);
    }

}
