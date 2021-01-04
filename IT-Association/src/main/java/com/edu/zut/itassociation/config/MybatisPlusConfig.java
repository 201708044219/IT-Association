package com.edu.zut.itassociation.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
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
@MapperScan("com.edu.zut.itassociation.mapper")
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


        return interceptor;
    }

    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector()
                ;
    }
}
