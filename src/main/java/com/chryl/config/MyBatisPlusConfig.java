package com.chryl.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Chr.yl on 2020/4/14.
 *
 * @author Chr.yl
 */
@Configuration
//@MapperScan({"com.chryl.**.mapper"})
@MapperScan("com.chryl.mapper")
public class MyBatisPlusConfig {
    //分页详解
    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
//    IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

    /**
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     *
     * @param page         分页查询条件
     * @param queryWrapper 实体对象封装操作类
     */
//    IPage<Map<String, Object>> selectMapsPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

    /**
     * 分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
        return paginationInterceptor;
    }

    /**
     * 乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        OptimisticLockerInterceptor optimisticLockerInterceptor = new OptimisticLockerInterceptor();
        return optimisticLockerInterceptor;
    }

    /**
     * 逻辑删除插件
     *
     * @return LogicSqlInjector
     */
//    @Bean
//    @ConditionalOnMissingBean
//    public ISqlInjector sqlInjector() {
//        return new LogicSqlInjector();
//    }

}
