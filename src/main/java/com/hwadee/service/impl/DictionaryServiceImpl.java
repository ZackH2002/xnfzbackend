package com.hwadee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.entity.Dictionary;
import com.hwadee.mapper.DictionaryMapper;
import com.hwadee.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Override
    public List<Dictionary> listByTypeCodeAndPid(String typeCode, Integer parentItemId) {
        return dictionaryMapper.listByTypeCodeAndPid(typeCode, parentItemId);
    }
}
