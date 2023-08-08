package com.hwadee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.entity.SimulationEquipment;
import com.hwadee.mapper.SimulationEquipmentMapper;
import com.hwadee.service.ISimulationEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationEquipmentServiceImpl extends ServiceImpl<SimulationEquipmentMapper, SimulationEquipment> implements ISimulationEquipmentService {
    @Autowired
    private SimulationEquipmentMapper simulationEquipmentMapper;
    @Override
    public List<SimulationEquipment> listSimulationEquipment() {
        return simulationEquipmentMapper.listSimulationEquipment();
    }

    @Override
    public int updateSimulationEquipment(SimulationEquipment simulationEquipment) {
        return simulationEquipmentMapper.updateById(simulationEquipment);
    }

    @Override
    public int addSimulationEquipment(SimulationEquipment simulationEquipment) {
        return simulationEquipmentMapper.insert(simulationEquipment);
    }

    @Override
    public int deleteSimulationEquipment(int simulationEquipmentId) {
        return simulationEquipmentMapper.deleteById(simulationEquipmentId);
    }
}
