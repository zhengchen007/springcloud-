/*
 * 文件名：StudentInterfaces.java
 * 版权：Copyright by www.olo-home.com
 * 作者：陈铮
 * 日期：2021年1月20日
 */

package com.cz.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("springcloud-provider-dept")
public interface StudentInterfaces {
    @GetMapping("/provide/student/get/{studentId}")
    public String GetStudent(@PathVariable("studentId") String studentId);
}
