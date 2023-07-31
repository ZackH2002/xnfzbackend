package com.hwadee.controller;

import com.hwadee.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "字典数据接口类", tags = "字典数据接口")
@RequestMapping("/dictionary")
public class DictionaryController {

    /**
     * 根据类型获取字典数据
     * @param type
     * @return
     */
    @ApiOperation("根据类型获取字典数据")
    @PostMapping
    public R loadDictionaryData(@RequestBody String type){
        System.out.println("获取到的字典类型为：" + type);
        return R.ok().message("获取数据成功");
    }
}
