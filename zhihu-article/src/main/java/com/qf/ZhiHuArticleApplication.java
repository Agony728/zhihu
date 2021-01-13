package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * Created by lenovo on 2021/1/5.
 */
@SpringBootApplication
@EnableDiscoveryClient
@FeignClient
@EnableCircuitBreaker
public class ZhiHuArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhiHuArticleApplication.class);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("400MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("400MB");
        return factory.createMultipartConfig();
    }

}
