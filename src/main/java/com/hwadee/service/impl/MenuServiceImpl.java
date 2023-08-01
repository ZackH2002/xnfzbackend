package com.hwadee.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.entity.Menu;
import com.hwadee.mapper.MenuMapper;
import com.hwadee.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> listByUserId(Integer userId) {
        return menuMapper.listByUserId(userId);
    }
}
