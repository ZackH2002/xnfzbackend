package com.hwadee.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwadee.entity.Laboratory;
import com.hwadee.entity.vo.LaboratoryReturn;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface LaboratoryMapper extends BaseMapper<Laboratory> {
    Page<LaboratoryReturn> selectPage(Page<LaboratoryReturn> page);

    @Select("SELECT COUNT(*) FROM laboratory")
    int getLaboratoryCount();
}
