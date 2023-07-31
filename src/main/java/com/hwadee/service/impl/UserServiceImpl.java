package com.hwadee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.entity.User;
import com.hwadee.mapper.UserMapper;
import com.hwadee.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 判断用户名是否存在
     * @param accountName
     * @return
     */
    @Override
    public User getUserByAccountName(String accountName) {
        User user = null;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", accountName);
        user = userMapper.selectOne(queryWrapper);
        return user;
    }

    /**
     * 注册用户
     * @param user
     * @param number
     * @return
     */
    @Override
    public int register(User user, String number) {
        // 插入数据到用户表中
        int insertNumber = userMapper.insert(user);
        if(insertNumber > 0){
            return insertNumber;
        }
        // 根据类型进行判断，用户类型为学生就往学生表插入数据，用户类型为学生就往学生表中插入数据

        return 0;
    }
}
