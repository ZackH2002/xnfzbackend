package com.hwadee.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwadee.common.R;
import com.hwadee.entity.Laboratory;
import com.hwadee.entity.vo.LaboratoryReturn;
import com.hwadee.entity.vo.LaboratoryVo;
import com.hwadee.service.ILaboratoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "实验室接口类",tags="实验室接口")
@RequestMapping("/Laboratory")
public class LaboratoryController {
    @Autowired
    private ILaboratoryService laboratoryService;

    /**
     * 获取实验室信息列表
     */
    @ApiOperation("获取实验室数据")
    @GetMapping("listLaboratory")
    public R getLaboratoryPage(LaboratoryVo res){
        System.out.println(res.getCurrent());
        Page<LaboratoryReturn> page = new Page<>(res.getCurrent(), res.getSize());
        Page<LaboratoryReturn> laboratoryPage = laboratoryService.getLaboratoryPage(page);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", laboratoryPage);
        return R.ok().message("获取实验室设备成功!").data(resultMap);
    }
    /**
     * 添加实验室
     */
    @PostMapping("addLaboratory")
    @ApiOperation("添加实验室")
    public R addLaboratory(@RequestBody Laboratory laboratory){
        int number = laboratoryService.addLaboratory(laboratory);
        if(number > 0){
            return R.ok().message("添加实验室成功");
        }
        else{
            return R.error().message("添加实验室失败");
        }
    }

    /**
     * 更新设备
     */
    @PostMapping("updateLaboratory")
    @ApiOperation("更新实验室")
    public R updateSimulationEquipment(@RequestBody Laboratory laboratory){
        int result = laboratoryService.updateLaboratory(laboratory);
        if(result > 0){
            return R.ok().message("更新成功");
        }
        else{
            return R.error().message("更新失败");
        }
    }

    /**
     * 删除实验室
     */
    @PostMapping("deleteLaboratory")
    @ApiOperation("删除实验室")
    public R deleteLaboratory(int laboratoryId){
        int result = laboratoryService.deleteLaboratory(laboratoryId);
        if(result > 0){
            return R.ok().message("删除成功");
        }
        else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation("获取实验室数据(不分页）")
    @GetMapping("getList")
    public R getLaboratoryList(){
        List<Laboratory> list = new ArrayList<Laboratory>();
        list = laboratoryService.listLaboratory();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", list);
        return R.ok().message("获取实验室设备成功!").data(resultMap);
    }
}
