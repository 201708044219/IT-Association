package com.edu.zut.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.oss
 * @description: Oss启动类
 * @date 2021-03-10 17:28
 **/
//exclude = DataSourceAutoConfiguration.class  表示运行的时候不加载数据库
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.edu.zut"})
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}
