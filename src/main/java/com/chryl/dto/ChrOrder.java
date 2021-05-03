package com.chryl.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Chr.yl on 2021/5/3.
 *
 * @author Chr.yl
 */
@Data
@ToString
public class ChrOrder implements Serializable {

    private static final long serialVersionUID = 1164407297829965009L;

    /**
     * MP提供的id类型
     * AUTO : 自动增长
     * ID_WORKER : mp自动的生成19位,数字类型
     * ID_WORKER_STR : 字符串类型19位
     * UUID : 生成随机uuid
     * INPUT : 自己设置
     * NONE  :  自己设置
     */
    @TableId(type = IdType.ID_WORKER)
    private Long orderId;

    private String orderName;

    @TableField(value = "order_price", jdbcType = JdbcType.DECIMAL)
    private BigDecimal orderPrice;

    /**
     * MP自动填充:创建时间和修改时间
     * INSERT : 添加时有值
     * UPDATE : 修改时有值
     * INSERT_UPDATE : 添加和修改时有值
     */
    @TableField(value = "order_create_time", fill = FieldFill.INSERT)
    private LocalDateTime orderCreateTime;

    @TableField(value = "order_update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime orderUpdateTime;

    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;//乐观锁版本号


}
