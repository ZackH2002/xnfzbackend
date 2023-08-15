package com.hwadee.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.entity.SimulationEquipment;
import com.hwadee.entity.Dictionary;
import com.hwadee.mapper.DictionaryMapper;
import com.hwadee.mapper.SimulationEquipmentMapper;
import com.hwadee.service.ISimulationEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimulationEquipmentServiceImpl extends ServiceImpl<SimulationEquipmentMapper, SimulationEquipment> implements ISimulationEquipmentService {
    @Autowired
    private SimulationEquipmentMapper simulationEquipmentMapper;
    @Autowired
    private DictionaryMapper dictionaryMapper;
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

    @Override
    public void downloadSEExcel(HttpServletResponse response) throws IOException {
        String fileName = URLEncoder.encode("SimulationEquipments","utf-8");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SimulationEquipment.class).sheet("sheet1").doWrite(data());
    }

    private List<SimulationEquipment> data(){
        List<Dictionary> dictionaries = dictionaryMapper.listDictionary();
        Map<String, String> statusMap = new HashMap<>();
        Map<String, String> simeqtypeMap = new HashMap<>();
        Map<String, String> purposeMap = new HashMap<>();
        Map<String, String> supplierMap = new HashMap<>();

        for(Dictionary dictionary : dictionaries){
            if(dictionary.getTypeCode().equals("status")){
                statusMap.put(dictionary.getCodeValue(), dictionary.getCodeName());
            }
            else if(dictionary.getTypeCode().equals("simeqtype")) {
                simeqtypeMap.put(dictionary.getCodeValue(), dictionary.getCodeName());
            }
            else if(dictionary.getTypeCode().equals("purpose")){
                purposeMap.put(dictionary.getCodeValue(), dictionary.getCodeName());
            }
            else if(dictionary.getTypeCode().equals("supplier")){
                supplierMap.put(dictionary.getCodeValue(), dictionary.getCodeName());
            }
        }

        List<SimulationEquipment> simulationEquipments = simulationEquipmentMapper.downLoadSEExcel();
        for(SimulationEquipment simulationEquipment : simulationEquipments){
            simulationEquipment.setType(simeqtypeMap.get(simulationEquipment.getType()));
            simulationEquipment.setSupplier(supplierMap.get(simulationEquipment.getSupplier()));
            simulationEquipment.setStatus(statusMap.get(simulationEquipment.getStatus()));
            simulationEquipment.setPurpose(purposeMap.get(simulationEquipment.getPurpose()));
        }
        return simulationEquipments;
    }

    @Override
    public Page<SimulationEquipment> getSimulationEquipmentByNumber(Page<SimulationEquipment> page, String number) {
        QueryWrapper<SimulationEquipment> wrapper = new QueryWrapper<>();
        wrapper.likeRight("number", number);
        return simulationEquipmentMapper.selectPage(page, wrapper);
    }

    @Override
    public Page<SimulationEquipment> getSimulationEquipmentByName(Page<SimulationEquipment> page, String name) {
        QueryWrapper<SimulationEquipment> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        return simulationEquipmentMapper.selectPage(page, wrapper);
    }

    @Override
    public int getNumberSimulationEquipmentsByLaboratoryId(int laboratoryId) {
        return simulationEquipmentMapper.getNumberSimulationEquipmentsByLaboratoryId(laboratoryId);
    }

    @Override
    public List<SimulationEquipment> getSEByLaboratoryId(int laboratoryId) {
        QueryWrapper<SimulationEquipment> wrapper = new QueryWrapper<>();
        wrapper.eq("laboratory_id", laboratoryId);
        return simulationEquipmentMapper.selectList(wrapper);
    }

    @Override
    public List<Map<String, Integer>> getStatusCounts() {
        return simulationEquipmentMapper.getStatusCounts();
    }

    @Override
    public List<Map<String, Integer>> getTypeCounts() {
        return simulationEquipmentMapper.getTypeCounts();
    }

    @Override
    public int getEquipmentCount() {
        return simulationEquipmentMapper.getEquipmentCount();
    }
}
