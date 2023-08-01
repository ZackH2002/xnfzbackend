package com.hwadee.controller;

import com.hwadee.common.R;
import com.hwadee.entity.Dictionary;
import com.hwadee.service.IDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "字典数据接口类", tags = "字典数据接口")
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * 根据类型获取字典数据
     * @param type
     * @return
     */
    @ApiOperation("根据类型获取字典数据")
    @PostMapping
    public R loadDictionaryData(@RequestBody String type){
        System.out.println("获取到的字典类型为：" + type);
        List<Dictionary> dictionaries = dictionaryService.listByTypeCodeAndPid(type, 0);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", dictionaries);
        return R.ok().message("获取字典数据成功").data(resultMap);
    }
}
