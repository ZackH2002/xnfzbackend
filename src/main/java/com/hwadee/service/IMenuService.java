package com.hwadee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {
    List<Menu> listByUserId(Integer userId);
}
