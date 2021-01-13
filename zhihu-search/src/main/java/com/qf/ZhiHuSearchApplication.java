package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by lenovo on 2021/1/5.
 */
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class ZhiHuSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhiHuSearchApplication.class);
    }

}
