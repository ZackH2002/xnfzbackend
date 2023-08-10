package com.hwadee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.SimulationEquipment;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ISimulationEquipmentService extends IService<SimulationEquipment> {
    Page<SimulationEquipment> getSimulationEquipmentPage(Page<SimulationEquipment> page);
    int updateSimulationEquipment(SimulationEquipment simulationEquipment);
    int addSimulationEquipment(SimulationEquipment simulationEquipment);
    int deleteSimulationEquipment(int simulationEquipmentId);
    void downloadSEExcel(HttpServletResponse response) throws IOException;
    List<SimulationEquipment> getSimulationEquipmentByNumber(String number);
    List<SimulationEquipment> getSimulationEquipmentByName(String name);
    List<SimulationEquipment> getSimulationEquipmentByNumberAndName(String number, String name);
    int getNumberSimulationEquipmentsByLaboratoryId(int laboratoryId);
    List<SimulationEquipment> getSEByLaboratoryId(int laboratoryId);
}
