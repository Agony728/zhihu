package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by lenovo on 2021/1/5.
 */
@SpringBootApplication
@EnableEurekaServer
public class ZhiHuEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhiHuEurekaApplication.class);
    }

}
