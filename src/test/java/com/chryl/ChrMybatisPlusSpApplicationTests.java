package com.chryl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chryl.dto.ChrOrder;
import com.chryl.dto.User;
import com.chryl.mapper.ChrOrderMapper;
import com.chryl.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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
        chrOrder.setOrderName("测试乐观锁1");
        chrOrderMapper.insert(chrOrder);
    }

    //updateOrderById
    @Test
    public void updateOrderById() {
        ChrOrder chrOrder = new ChrOrder();
        //id自动生成策略
        chrOrder.setOrderId(1389212424007241730L);
        chrOrder.setOrderName("我的订单2");
        chrOrderMapper.updateById(chrOrder);
    }


    //测试乐观锁
    @Test
    public void updateOptimisticLocker() {
        ChrOrder order = chrOrderMapper.selectById(1389219298249187330L);
        order.setOrderName("测试乐观锁2");
        chrOrderMapper.updateById(order);
        //version会改变
    }

    //多个id批量查询
    @Test
    public void queryIdList() {
        List<ChrOrder> chrOrderList = chrOrderMapper.selectBatchIds(Arrays.asList(1389219298249187330L, 1389149428753092609L));
        System.out.println(chrOrderList);
    }

    //简单条件查询
    @Test
    public void query() {
        Map<String, Object> map = new HashMap<>();
        //注意这里的key为db的字段列名字
        map.put("order_name", "我的订单2");
//        map.put("order_price", new BigDecimal(23.22).setScale(2, RoundingMode.HALF_UP));
        List<ChrOrder> chrOrderList = chrOrderMapper.selectByMap(map);
        System.out.println(chrOrderList);
    }


    //分页
    @Test
    public void queryPage() {
        Page<ChrOrder> page = new Page<>(1, 2);//当前页,每页显示的记录条数
        IPage<ChrOrder> chrOrderIPage = chrOrderMapper.selectPage(page, null);//第二个参数为查询条件
        System.out.println(chrOrderIPage.getCurrent());//当前页
        System.out.println(chrOrderIPage.getRecords());//数据
        System.out.println(chrOrderIPage.getSize());//每页几条
        System.out.println(chrOrderIPage.getTotal());//总记录数
        System.out.println(chrOrderIPage.getPages());//总页数
        System.out.println(page.hasPrevious());//是否有上页
        System.out.println(page.hasNext());//是否有下页
    }

}
