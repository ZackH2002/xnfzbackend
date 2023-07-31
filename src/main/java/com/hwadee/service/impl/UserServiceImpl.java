package com.hwadee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwadee.entity.User;
import com.hwadee.mapper.UserMapper;
import com.hwadee.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 用户业务层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getUserByAccountName(String accountName) {
        User user = null;
        if(accountName.equals("admin")){
            user = new User();
            user.setAccount(accountName);
        }
        return user;
    }

    @Override
    public int register(User user) {
        System.out.println("用户注册成功");
        return 0;
    }
}
