package com.hwadee.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwadee.common.R;
import com.hwadee.entity.SimulationEquipment;
import com.hwadee.entity.vo.SimulationEquipmentReq;
import com.hwadee.service.ISimulationEquipmentService;
import com.sun.deploy.net.URLEncoder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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
    @DeleteMapping("deleteSimulationEquipment")
    @ApiOperation("删除虚拟仿真设备")
    public R deleteSimulationEquipmentById(@RequestBody int simulationEquipmentId){
        int result = simulationEquipmentService.deleteSimulationEquipment(simulationEquipmentId);
        if(result > 0){
            return R.ok().message("删除成功");
        }
        else{
            return R.error().message("删除失败");
        }
    }

//    @GetMapping("export")
//    @ApiOperation("导出数据")
//    public R exportExcel(HttpServletResponse response){
//        try{
//            this.setExcelResponseProp(response, "虚拟仿真设备列表");
//        }
//    }
//
//    private void setExcelResponseProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        response.setCharacterEncoding("utf-8");
//        String fileName = URLEncoder.encode(rawFileName, "UTF-8").replaceAll("\+", "%20");
//        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//    }
}
