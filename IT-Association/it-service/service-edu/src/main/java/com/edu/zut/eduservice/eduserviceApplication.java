package com.edu.zut.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lyl
 * @program: IT-Association
 * @package com.edu.zut.eduservice
 * @description: 教师管理启动类
 * @date 2021-01-09 15:54
 **/
@SpringBootApplication

@EnableSwagger2
//扫描配置类
@ComponentScan(basePackages = "com.edu.zut")
public class EduserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduserviceApplication.class,args);
    }
}
