package com.hwadee.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "req对象")
@Data
public class SimulationEquipmentReq {
    private int current;
    private int size;
}
