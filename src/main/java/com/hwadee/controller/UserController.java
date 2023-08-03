package com.hwadee.controller;

import com.alibaba.druid.util.StringUtils;
import com.hwadee.common.MD5Util;
import com.hwadee.common.R;
import com.hwadee.entity.User;
import com.hwadee.entity.vo.UserVO;
import com.hwadee.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

/**
 * 用户的接口类
 */
@RequestMapping("user")
@RestController
@Api(tags = "用户管理接口")
public class UserController {

    @Autowired
    private IUserService userService;
    /**
     * 注册方法
     * @param userVO
     * @return
     */
    @PostMapping("register")
    @ApiOperation("注册用户")
    public R register(@RequestBody UserVO userVO){
        if(StringUtils.isEmpty(userVO.getName())
                || StringUtils.isEmpty(userVO.getPhone())
                || StringUtils.isEmpty(userVO.getAccount())
                || StringUtils.isEmpty(userVO.getPassword())
                || StringUtils.isEmpty(userVO.getType())
                || StringUtils.isEmpty(userVO.getNumber())){
            return R.error().message("参数异常，请输入必填项。");
        }

        // 1. 通过用户名检查用户是否存在
        User user = userService.getUserByAccountName(userVO.getAccount());
        if(user != null){
            // 1.1 如果用户名存在，则提示用户请重新输入用户名
            return R.error().message("用户名已存在，请重新输入用户名。");
        }
        else{
            user = new User();
        }

        // 将前端数据封装成实体对象
        user.setAccount(userVO.getAccount());
        user.setEmail(userVO.getEmail());
        user.setName(userVO.getName());
        user.setPassword(MD5Util.encryptMD5AndSalt(userVO.getPassword(), MD5Util.DEFAULT_SALT));
        user.setPhone(userVO.getPhone());
        user.setType(userVO.getType());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        // 保存数据
        try{
            int registerNumber = userService.register(user, userVO.getNumber());
            if(registerNumber > 0){
                return R.ok().message("用户注册成功");
            }else {
                return R.error().message("用户注册失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return R.error();
    }

    @PostMapping("accountIsExist")
    @ApiOperation("判断用户名是否存在")
    public R accountIsExist(@RequestBody String account){
        //通过账号获取对象是否存在
        User userByAccountName = userService.getUserByAccountName(account);
        if(Objects.isNull(userByAccountName)){
            System.out.println("用户名不存在，请继续操作。");
        }
        else{
            return R.error().message("账号已存在，请重新提交。");
        }
        return R.ok();
    }
}
