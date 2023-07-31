package com.hwadee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.common.R;
import com.hwadee.entity.User;
import com.hwadee.mapper.UserMapper;
import com.hwadee.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户业务层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByAccountName(String accountName) {
        User user = null;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", accountName);
        user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public int register(User user) {
        System.out.println("用户注册成功");
        return 0;
    }
}
