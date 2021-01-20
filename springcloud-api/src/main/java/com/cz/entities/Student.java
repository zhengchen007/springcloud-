/*
 * 文件名：Student.java
 * 版权：Copyright by www.olo-home.com
 * 作者：陈铮
 * 日期：2021年1月20日
 */

package com.cz.entities;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Student{
    @Setter
    @Getter
    private String studentId;
    @Setter
    @Getter
    private String studentName;
    @Setter
    @Getter
    private String gender;
    @Setter
    @Getter
    private String classId;
    @Setter
    @Getter
    private String teacherId;

}
