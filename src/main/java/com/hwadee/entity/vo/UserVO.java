package com.hwadee.entity.vo;

import com.hwadee.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "userVO对象")
@Data
public class UserVO extends User {
    /**
     * 用于存放教师编号或者学生编号
     */
    private String number;



}
