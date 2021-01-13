package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by lenovo on 2021/1/5.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZhiHuHelpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhiHuHelpApplication.class);
    }

}
