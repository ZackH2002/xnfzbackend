package com.hwadee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.entity.SimulationEquipment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
