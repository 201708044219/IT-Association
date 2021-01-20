package com.edu.zut.teachermanage.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.itassociation.config
 * @description: MP的配置类
 * @date 2021-01-04 16:31
 **/
@Configuration
@EnableTransactionManagement
//扫描mapper接口，因为没有实现类，所以sping扫描不到，加上该注解扫描mapper接口
@MapperScan("com.edu.zut.teachermanage.mapper")
public class MybatisPlusConfig {

    /**
     * @Description: 拦截器
     * @Param: []
     * @return: com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
     * @Author: lyl
     * @Date: 2021/1/4
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); // 乐观锁插件
        // DbType：数据库类型(根据类型获取应使用的分页方言)
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 分页插件

//        interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());  //sql性能规范

        return interceptor;
    }


//    @Bean
//    @Profile({"dev","test"})// 设置 dev test 环境开启
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        performanceInterceptor.setMaxTime(100);//ms，超过此处设置的ms则sql不执行
//        performanceInterceptor.setFormat(true);
//        return performanceInterceptor;
//    }
}
