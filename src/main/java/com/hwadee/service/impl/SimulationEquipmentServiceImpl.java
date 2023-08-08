package com.hwadee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.entity.SimulationEquipment;
import com.hwadee.entity.vo.SimulationEquipmentReq;
import com.hwadee.mapper.SimulationEquipmentMapper;
import com.hwadee.service.ISimulationEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SimulationEquipmentServiceImpl extends ServiceImpl<SimulationEquipmentMapper, SimulationEquipment> implements ISimulationEquipmentService {
    @Autowired
    private SimulationEquipmentMapper simulationEquipmentMapper;
    @Override
    public Page<SimulationEquipment> getSimulationEquipmentPage(Page<SimulationEquipment> page) {
        return simulationEquipmentMapper.selectPage(page, null);
    }

    @Override
    public int updateSimulationEquipment(SimulationEquipment simulationEquipment) {
        simulationEquipment.setUpdateTime(new Date());
        return simulationEquipmentMapper.updateById(simulationEquipment);
    }

    @Override
    public int addSimulationEquipment(SimulationEquipment simulationEquipment) {
        simulationEquipment.setCreateTime(new Date());
        return simulationEquipmentMapper.insert(simulationEquipment);
    }

    @Override
    public int deleteSimulationEquipment(int simulationEquipmentId) {
        return simulationEquipmentMapper.deleteById(simulationEquipmentId);
    }
}