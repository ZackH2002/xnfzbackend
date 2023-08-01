package com.hwadee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.Dictionary;

import java.util.List;

public interface IDictionaryService extends IService<Dictionary> {
    /**
     * 根据typeCode 和 父级id查出数据
     * @param typeCode
     * @param parentItemId
     * @return
     */
    List<Dictionary> listByTypeCodeAndPid(String typeCode, Integer parentItemId);
}
