package com.gabrielebonadiman.parent.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.gabrielebonadiman.parent")
public class FeignConfiguration {

}
