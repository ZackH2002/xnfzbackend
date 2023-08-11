package com.hwadee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.Laboratory;

public interface ILaboratoryService extends IService<Laboratory> {
    Page<Laboratory> getLaboratoryPage(Page<Laboratory> page);
    int addLaboratory (Laboratory laboratory);
    int deleteLaboratory (int laboratoryId);
    int updateLaboratory(Laboratory laboratory);
}
