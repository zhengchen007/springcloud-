/*
 * 文件名：ProviderApplication.java
 * 版权：Copyright by www.olo-home.com
 * 作者：陈铮
 * 日期：2021年1月20日
 */

package com.cz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
