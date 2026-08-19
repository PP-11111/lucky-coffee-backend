package com.yb.luckycoffeebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("com.yb.luckycoffeebackend.mapper")
@CrossOrigin(origins = "*") // ⚠️ 允许所有来源访问
public class LuckyCoffeeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckyCoffeeBackendApplication.class, args);
    }

}