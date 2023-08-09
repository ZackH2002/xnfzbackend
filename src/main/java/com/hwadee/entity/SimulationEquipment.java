package com.hwadee.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("simulation_equipment")
@ApiModel(value = "simulation_equipment对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulationEquipment {
    //设备id
    @TableId(value = "simulation_equipment_id", type = IdType.AUTO)
    @ExcelIgnore
    private Integer simulationEquipmentId;
    // 设备名称
    @ExcelProperty("设备名称")
    @ColumnWidth(20)
    private String name;
    // 设备编号
    @ExcelProperty("设备编号")
    @ColumnWidth(20)
    private String number;
    // 设备类型
    @ExcelProperty("设备类型")
    @ColumnWidth(20)
    private String type;
    // 软件系统
    @ExcelProperty("软件系统")
    @ColumnWidth(20)
    private String softwareSystem;
    // 版本号
    @ExcelProperty("版本号")
    @ColumnWidth(20)
    private String versionNumber;
    // 供应商
    @ExcelProperty("供应商")
    @ColumnWidth(20)
    private String supplier;
    //  状态
    @ExcelProperty(value = "设备状态")
    @ColumnWidth(20)
    private String status;
    // 设备用途
    @ExcelProperty("设备用途")
    @ColumnWidth(20)
    private String purpose;
    // 实验室id
    @ExcelProperty("所属实验室")
    @ColumnWidth(20)
    private Integer laboratoryId;
    // 缩略图
    @ExcelIgnore
    private String thumbnail;
    // 创建时间
    @ExcelProperty("创建时间")
    @ColumnWidth(20)
    @DateTimeFormat("yyyy-mm-dd hh:mm:ss")
    private Date createTime;
    // 更新时间
    @ExcelProperty("更新时间")
    @ColumnWidth(20)
    @DateTimeFormat("yyyy-mm-dd hh:mm:ss")
    private Date updateTime;
}
