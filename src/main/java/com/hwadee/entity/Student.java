package com.hwadee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@TableName("student")
@Data
@ApiModel(value = "student 对象")
public class Student implements Serializable {
    @TableId(value = "student_id", type = IdType.AUTO)
    private Integer studentId;

    // 外键关联到用户表
    private Integer userId;

    // 学号
    private String studentNumber;

    //
}
