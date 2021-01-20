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

import com.cz.entities.Student;
@RestController
public class StudentController {
    
    @Autowired
    Student student; 
    @GetMapping("/provide/student/get/{studentId}")
    public Student findById(@PathVariable("studentId") String studentId) {
        student.setStudentId(studentId);
        student.setStudentName("张三");
        student.setClassId("4班");
        student.setTeacherId("13");
        return student;
    }
}
