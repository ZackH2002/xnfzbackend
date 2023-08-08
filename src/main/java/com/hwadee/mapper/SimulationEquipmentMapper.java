package com.hwadee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.entity.SimulationEquipment;

import java.util.List;

public interface SimulationEquipmentMapper extends BaseMapper<SimulationEquipment> {
    public List<SimulationEquipment> listSimulationEquipment();
}
