package com.hwadee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.SimulationEquipment;
import com.hwadee.entity.vo.SimulationEquipmentReq;

import java.util.List;

public interface ISimulationEquipmentService extends IService<SimulationEquipment> {
    Page<SimulationEquipment> getSimulationEquipmentPage(Page<SimulationEquipment> page);
    int updateSimulationEquipment(SimulationEquipment simulationEquipment);
    int addSimulationEquipment(SimulationEquipment simulationEquipment);
    int deleteSimulationEquipment(int simulationEquipmentId);
}
