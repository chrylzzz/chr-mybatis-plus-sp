package com.chryl.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MP自动填充:自定义实现类 MyMetaObjectHandler,配合fill = FieldFill.INSERT
 * Created by Chr.yl on 2021/5/3.
 *
 * @author Chr.yl
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //使用MP 添加 操作时执行
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        //第一个参数:属性名称,javaBean field name
        //第二个参数:属性值
        //第三个参数:元数据
        this.setFieldValByName("orderCreateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("orderUpdateTime", LocalDateTime.now(), metaObject);

    }

    //使用MP 修改 操作时执行
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("orderUpdateTime", LocalDateTime.now(), metaObject);
    }

}
