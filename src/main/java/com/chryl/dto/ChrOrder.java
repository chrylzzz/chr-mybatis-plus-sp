package com.chryl.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

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
}
