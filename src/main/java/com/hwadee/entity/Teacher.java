package com.hwadee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
@ApiModel("教师实体类")
public class Teacher {
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    private Integer userId;

    private String teacherNumber;
}
