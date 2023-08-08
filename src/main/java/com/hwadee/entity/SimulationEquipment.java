package com.hwadee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@TableName("simulation_equipment")
@ApiModel(value = "simulation_equipment对象")
@Data
public class SimulationEquipment {

    //设备id
    @TableId(value = "simulation_equipment_id", type = IdType.AUTO)
    private Integer simulationEquipmentId;
    // 设备名称
    private String name;
    // 设备编号
    private String number;
    // 设备类型
    private int type;
    // 软件系统
    private String softwareSystem;
    // 版本号
    private String versionNumber;
    // 供应商
    private String supplier;
    //  状态
    private int status;
    // 设备用途
    private String purpose;
    // 实验室id
    private Integer laboratoryId;
    // 缩略图
    private String thumbnail;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
}
