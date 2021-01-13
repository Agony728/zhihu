package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by lenovo on 2021/1/5.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ZhiHuConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhiHuConfigApplication.class);
    }

}
