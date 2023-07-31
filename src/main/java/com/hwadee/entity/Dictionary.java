package com.hwadee.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Dictionary implements Serializable {
    /**
     * 字典ID
     */
    private int dicItemId;
    /**
     * 字段名称
     */
    private String codeName;
    /**
     * 字典值
     */
    private String codeValue;
    /**
     * 是排序值
     */
    private int isRanked;
    /**
     * 字典类型
     */
    private String typeCode;
    /**
     * 父级ID
     */
    private int parentItemId;
    /**
     * 注释
     */
    private String remark;
    /**
     * 逻辑删除值
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private Date creatTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
