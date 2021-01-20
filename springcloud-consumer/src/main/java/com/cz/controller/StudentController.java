/*
 * 文件名：StudentController.java
 * 版权：Copyright by www.olo-home.com
 * 作者：陈铮
 * 日期：2021年1月20日
 */

package com.cz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cz.interfaces.StudentInterfaces;

@RestController
public class StudentController {
    @Autowired
    StudentInterfaces interfaces;
    @GetMapping("/consumer/student/get/{studentId}")
    public String select(@PathVariable("studentId") String studentId) {
        System.out.println(123);
        return  interfaces.GetStudent(studentId);
    }
}
