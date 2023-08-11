package com.hwadee.entity.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("res返回对象")
@Data
public class LaboratoryVo implements Serializable {
    private int current;
    private int size;
}
