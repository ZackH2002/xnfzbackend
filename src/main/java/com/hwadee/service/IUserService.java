package com.hwadee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwadee.entity.User;

public interface IUserService extends IService<User> {
    /**
     * 根据用户名查询用户是否存在
     * @param accountName
     * @return
     */
    User getUserByAccountName(String accountName);

    /**
     * 注册用户
     * @param user
     * @return
     */
    int register(User user, String number);

    /**
     * 根据用户名、账号查找用户
     * @param account
     * @param password
     * @return
     */
    User getUserByLoginInfo(String account, String password);
}
