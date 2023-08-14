package com.hwadee.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.entity.Laboratory;
import com.hwadee.mapper.LaboratoryMapper;
import com.hwadee.service.ILaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LaboratoryServiceImpl extends ServiceImpl<LaboratoryMapper, Laboratory> implements ILaboratoryService {
    @Autowired
    private LaboratoryMapper laboratoryMapper;

    @Override
    public Page<Laboratory> getLaboratoryPage(Page<Laboratory> page) {
        return laboratoryMapper.selectPage(page,null);
    }

    @Override
    public int addLaboratory(Laboratory laboratory) {
        return laboratoryMapper.insert(laboratory);
    }

    @Override
    public int deleteLaboratory(int laboratoryId) {
        return laboratoryMapper.deleteById(laboratoryId);
    }

    @Override
    public int updateLaboratory(Laboratory laboratory) {
        laboratory.setUpdateTime(new Date());
        return laboratoryMapper.updateById(laboratory);
    }

    @Override
    public List<Laboratory> listLaboratory() {
        return laboratoryMapper.selectList(null);
    }


}
