package com.hwadee.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginVO implements Serializable {
    private String account;
    private String password;
}
