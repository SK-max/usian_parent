package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 阿柯
 * @version 1.0
 * @date 2020/5/25 18:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ContentWebApp {
      public static void main(String[] args) {
        SpringApplication.run(ContentWebApp.class, args);
    }
}
