package com.hwadee.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwadee.entity.Laboratory;
import com.hwadee.entity.vo.LaboratoryReturn;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaboratoryMapper extends BaseMapper<Laboratory> {
    Page<LaboratoryReturn> selectPage(Page<LaboratoryReturn> page);
}
