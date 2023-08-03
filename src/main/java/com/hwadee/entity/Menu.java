package com.hwadee.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Menu implements Serializable {

    private Integer menuId;
    private String cname;
    private String ename;
    private String path;
    private String component;
    private String icon;
    private Integer pid;
    private String sort;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
