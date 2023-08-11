package com.hwadee.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("laboratory")
public class Laboratory implements Serializable {
    @TableId(value = "laboratory_id", type = IdType.AUTO)
    /**
     * 实验室Id
     */
    private int laboratoryId;
    /**
     * 设备编号
     */
    private String laboratoryNumber;
    /**
     * 实验室名称
     */
    private String laboratoryName;
    /**
     * 工位数量
     */
    private int stationNum;
    /**
     * 实验室面积
     */
    private Double area;
    /**
     * 设施价格
     */
    private Double facilitiesPrice;
    /**
     * 实验室地址
     */
    private String address;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 概要介绍
     */
    private String profile;
    /**
     * 简介
     */
    private String detail;
}
