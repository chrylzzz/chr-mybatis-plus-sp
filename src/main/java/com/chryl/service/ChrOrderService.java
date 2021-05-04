package com.chryl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chryl.dto.ChrOrder;
import com.chryl.mapper.ChrOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MP复杂查询
 * Created by Chr.yl on 2021/5/4.
 *
 * @author Chr.yl
 */
@Service
public class ChrOrderService {

    @Autowired
    private ChrOrderMapper chrOrderMapper;


    /**
     * 查询list
     *
     * @param chrOrder
     * @return
     */
    public List<ChrOrder> mpQueryList(ChrOrder chrOrder) {
        QueryWrapper<ChrOrder> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("order_name", "我的订单1");
        map.put("order_price", new BigDecimal(1));

        queryWrapper
                /**
                 * ge>= gt> le<= lt<
                 */
//                .gt("order_price", chrOrder.getOrderPrice())
                /**
                 * isNull isNotNull
                 */
//                .isNull("version")
                /**
                 * eq= ne!=
                 */
//                .eq("order_name", chrOrder.getOrderName())
//                .ne("order_name", chrOrder.getOrderName())
                /**
                 * between、notBetween
                 */
//                .between("order_price", new BigDecimal(3), new BigDecimal(6))
                /**
                 * allEq
                 */
//                .allEq(map);
                /**
                 * like、notLike、likeLeft、likeRight
                 */
//                .like("order_name", "测试")
                /**
                 * in、notIn、inSql、notinSql、exists、notExists
                 */
//                .in("order_id", Arrays.asList(1L, 2L))
//                .inSql("order_id","select id from user")//子查询 order_id in (select id from user)
                /**
                 * or、and ,不调用or则默认为使用 and 连
                 */
//                .eq("order_name", "我的订单1")
//                .or()
//                .between("order_price", new BigDecimal(3), new BigDecimal(6))
//                .or(i -> i.eq("order_id", 1L))//or中的表达式最后翻译成sql时会被加上圆括号

                /**
                 * orderBy、orderByDesc、orderByAsc
                 */
//                .orderByDesc("order_price")
                /**
                 * last -> limit 注意：只能调用一次,多次调用以最后一次为准 有sql注入的风险,请谨慎使用
                 */
                .last("limit 2")
        /**
         * set、setSql:只有在 UpdateWrapper 才可以使用
         */
//                .like("name", "h")
//                .set("name", "老李头")//除了可以查询还可以使用set设置修改的字段
//                .setSql(" email = '123@qq.com'");//可以有子查询
        ;

        List<ChrOrder> chrOrders = chrOrderMapper.selectList(queryWrapper);
        return chrOrders;
    }


    /**
     * 查询 1 条
     *
     * @return
     */
    public ChrOrder mpQueryOne() {
        QueryWrapper<ChrOrder> queryWrapper = new QueryWrapper<>();
        return chrOrderMapper.selectOne(queryWrapper);
    }


    /**
     * 更新
     *
     * @return
     */
    public void mpUpdate() {
        ChrOrder chrOrder = new ChrOrder();
        UpdateWrapper<ChrOrder> updateWrapper = new UpdateWrapper<>();
        /**
         * set、setSql:只有在 UpdateWrapper 才可以使用
         */
        updateWrapper
                .like("order_name", "测试")
                .set("order_name", "老李头")//除了可以查询还可以使用set设置修改的字段
                .setSql(" order_price = '" + new BigDecimal(5) + "'");//可以有子查询
        chrOrderMapper.update(chrOrder, updateWrapper);
    }

    /**
     * 查询指定的列
     *
     * @return
     */
    public List<ChrOrder> selectListColumn() {
        QueryWrapper<ChrOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("order_id", "order_create_time", "order_update_time");
        return chrOrderMapper.selectList(queryWrapper);
    }


}
