package com.hwadee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.entity.SimulationEquipment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface SimulationEquipmentMapper extends BaseMapper<SimulationEquipment> {
    List<SimulationEquipment> downLoadSEExcel();
    /**
     * 根据实验室id 获取该实验室下的设备数目
     * @param laboratoryId
     * @return
     */
    int getNumberSimulationEquipmentsByLaboratoryId(int laboratoryId);

    @Select("SELECT d.codeName AS name, COUNT(*) AS value " +
            "FROM simulation_equipment e " +
            "JOIN dictionary d ON e.status = d.codeValue AND d.typeCode = 'status' " +
            "GROUP BY e.status, d.codeName")
    List<Map<String, Integer>> getStatusCounts();

    @Select("SELECT d.codeName AS name, COUNT(*) AS value FROM simulation_equipment e JOIN dictionary d ON e.type = d.codeValue WHERE d.typeCode = 'simeqtype' GROUP BY e.type")
    List<Map<String, Integer>> getTypeCounts();

    @Select("SELECT COUNT(*) FROM simulation_equipment")
    int getEquipmentCount();
}
