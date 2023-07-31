package com.hwadee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("user")
@ApiModel(value = "user对象")
@Data
public class User implements Serializable {

    // 用户ID
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer UserId;

    // 姓名
    private  String name;

    // 账号
    private String account;

    // 邮箱
    private  String email;

    // 密码
    private String password;

    // 简介
    private String intro;

    // 手机号码
    private String phone;

    // 类型
    private String type;

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;
}
