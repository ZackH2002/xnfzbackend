package com.hwadee.entity.vo;

import com.hwadee.entity.Laboratory;
import lombok.Data;

@Data
public class LaboratoryReturn extends Laboratory {
    //该实验室下的设备数量
    private int simulationEquipmentNum;
}
