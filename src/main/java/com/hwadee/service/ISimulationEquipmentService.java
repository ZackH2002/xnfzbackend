package com.hwadee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.SimulationEquipment;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ISimulationEquipmentService extends IService<SimulationEquipment> {
    Page<SimulationEquipment> getSimulationEquipmentPage(Page<SimulationEquipment> page);
    int updateSimulationEquipment(SimulationEquipment simulationEquipment);
    int addSimulationEquipment(SimulationEquipment simulationEquipment);
    int deleteSimulationEquipment(int simulationEquipmentId);
    void downloadSEExcel(HttpServletResponse response) throws IOException;
    Page<SimulationEquipment> getSimulationEquipmentByNumber(Page<SimulationEquipment> page, String number);
    Page<SimulationEquipment> getSimulationEquipmentByName(Page<SimulationEquipment> page, String name);
    int getNumberSimulationEquipmentsByLaboratoryId(int laboratoryId);
    Page<SimulationEquipment> getSEByLaboratoryId(Page<SimulationEquipment> page, int laboratoryId);
    List<Map<String, Integer>> getStatusCounts();

    List<Map<String, Integer>> getTypeCounts();

    int getEquipmentCount();
}
