package com.hwadee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.entity.Dictionary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryMapper extends BaseMapper<Dictionary> {
    List<Dictionary> listByTypeCodeAndPid (String typeCode, Integer parentItemId);
    List<Dictionary> listDictionary();
}
