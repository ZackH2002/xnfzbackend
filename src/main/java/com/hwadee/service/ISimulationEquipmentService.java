package com.hwadee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.SimulationEquipment;

import java.util.List;

public interface ISimulationEquipmentService extends IService<SimulationEquipment> {
    List<SimulationEquipment> listSimulationEquipment();
    int updateSimulationEquipment(SimulationEquipment simulationEquipment);
    int addSimulationEquipment(SimulationEquipment simulationEquipment);
    int deleteSimulationEquipment(int simulationEquipmentId);
}
