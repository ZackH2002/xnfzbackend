package com.hwadee.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwadee.common.R;
import com.hwadee.entity.SimulationEquipment;
import com.hwadee.entity.vo.SimulationEquipmentReq;
import com.hwadee.service.ISimulationEquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "虚拟仿真设备接口类", tags = "虚拟仿真设备接口")
@RequestMapping("/simulationEquipment")
public class SimulationEquipmentController {
    @Autowired
    private ISimulationEquipmentService simulationEquipmentService;
    /**
     * 获取虚拟仿真设备列表
     */
    @ApiOperation("获取虚拟仿真设备数据")
    @GetMapping("loadSimulationEquipmentData")
    public R loadSimulationEquipmentData(SimulationEquipmentReq req){
        System.out.println(req.getCurrent());
        Page<SimulationEquipment> page = new Page<>(req.getCurrent(), req.getSize());
        Page<SimulationEquipment> simulationEquipmentPage = simulationEquipmentService.getSimulationEquipmentPage(page);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", simulationEquipmentPage);
        return R.ok().message("获取虚拟仿真设备数据成功").data(resultMap);
    }

    /**
     * 添加虚拟仿真设备
     */
    @PostMapping("addSimulationEquipment")
    @ApiOperation("添加虚拟仿真设备")
    public R addSimulationEquipment(@RequestBody SimulationEquipment simulationEquipment){
        int number = simulationEquipmentService.addSimulationEquipment(simulationEquipment);
        if(number > 0){
            return R.ok().message("添加设备成功");
        }
        else{
            return R.error().message("添加设备失败");
        }
    }

    /**
     * 更新设备
     */
    @PostMapping("updateSimulationEquipment")
    @ApiOperation("更新虚拟仿真设备")
    public R updateSimulationEquipment(@RequestBody SimulationEquipment simulationEquipment){
        int result = simulationEquipmentService.updateSimulationEquipment(simulationEquipment);
        if(result > 0){
            return R.ok().message("更新成功");
        }
        else{
            return R.error().message("更新失败");
        }
    }

    /**
     * 删除设备
     */
    @PostMapping("deleteSimulationEquipment")
    @ApiOperation("删除虚拟仿真设备")
    public R deleteSimulationEquipmentById(int simulationEquipmentId){
        int result = simulationEquipmentService.deleteSimulationEquipment(simulationEquipmentId);
        if(result > 0){
            return R.ok().message("删除成功");
        }
        else{
            return R.error().message("删除失败");
        }
    }

    /**
     * 根据设备编号、设备名称查询
     */
    @ApiOperation("根据设备编号、设备名称查询")
    @GetMapping("getSimulationEquipment")
    public R getSimulationEquipmentByNumberOrName(String number, String name){
        Map<String, Object> resultMap = new HashMap<>();
        List<SimulationEquipment> data;
        if(number!=null && name!=null){
            data = simulationEquipmentService.getSimulationEquipmentByNumberAndName(number, name);
        }
        else if(number!=null){
            data = simulationEquipmentService.getSimulationEquipmentByNumber(number);
        }
        else if(name!=null){
            data = simulationEquipmentService.getSimulationEquipmentByName(name);
        }
        else {
            return R.error().message("查询失败，请输入数据");
        }
        resultMap.put("data", data);
        return R.ok().message("查询成功").data(resultMap);
    }


    /**
     * 将虚拟仿真设备数据导出为Excel
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "downloadExcel")
    @ApiOperation(value = "导出数据", notes = "export", produces = "application/octet-stream")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        simulationEquipmentService.downloadSEExcel(response);
    }

    /**
     * 根据实验室id 得到该实验室下的虚拟仿真设备的数量
     * @param laboratoryId
     * @return
     */
    @GetMapping(value = "getNumberOfSEByLabId")
    @ApiOperation(value = "获取实验室设备数量")
    public R getNumberSimulationEquipmentsByLaboratoryId(int laboratoryId){
        int number = simulationEquipmentService.getNumberSimulationEquipmentsByLaboratoryId(laboratoryId);
        if(number >= 0){
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", number);
            return R.ok().message("获取数量成功").data(resultMap);
        }
        else{
            return R.error().message("获取数量失败");
        }
    }

    /**
     * 根据实验室id获取实验室的设备列表
     * @param laboratoryId
     * @return
     */
    @GetMapping(value = "getSEByLaboratoryId")
    @ApiOperation(value = "获取实验室的设备")
    public R getSEByLaboratoryId(int laboratoryId){
        List<SimulationEquipment> simulationEquipments = simulationEquipmentService.getSEByLaboratoryId(laboratoryId);
        if(!simulationEquipments.isEmpty()){
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("data", simulationEquipments);
            return R.ok().message("获取设备成功").data(resultMap);
        }
        else{
            return R.ok().message("获取设备失败");
        }
    }
}
