package com.hwadee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.Laboratory;
import com.hwadee.entity.vo.LaboratoryReturn;

import java.util.List;

public interface ILaboratoryService extends IService<Laboratory> {
    Page<LaboratoryReturn> getLaboratoryPage(Page<LaboratoryReturn> page);
    int addLaboratory (Laboratory laboratory);
    int deleteLaboratory (int laboratoryId);
    int updateLaboratory(Laboratory laboratory);
    List<Laboratory> listLaboratory();
    int getLaboratoryCount();

}
