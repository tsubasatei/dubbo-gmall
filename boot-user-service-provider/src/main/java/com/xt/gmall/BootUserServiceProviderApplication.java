package com.xt.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 导入依赖：
 *  1） 导入 dubbo-starter
 *  2)  导入 dubbo 的其他依赖
 */
@EnableDubbo // 开启基于注解的 dubbo 功能
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
