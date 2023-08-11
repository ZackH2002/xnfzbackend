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
    @TableId(value = "laboratoryId", type = IdType.AUTO)
    /**
     * 实验室Id
     */
    private int laboratoryId;
    /**
     * 实验室名称
     */
    private String laboratoryName;
    /**
     * 实验室地址
     */
    private String address;
    /**
     * 实验室面积
     */
    private Double area;
    /**
     * 实验室管理员
     */
    private String chargePerson;
    /**
     *  实验室详情
     */
    private String detail;
    /**
     * 设施价格
     */
    private Double facilitiesPrice;
    /**
     *  资源名称
     */
    private String resourceName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 实验室简介
     */
    private String profile;
    /**
     * 工位数量
     */
    private int stationNum;
    /**
     * 缩略图
     */
    private String thumbnail;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
