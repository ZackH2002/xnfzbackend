package com.hwadee.controller;

import com.alibaba.druid.util.StringUtils;
import com.hwadee.common.R;
import com.hwadee.entity.User;
import com.hwadee.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
     * @param user
     * @return
     */
    @PostMapping("register")
    @ApiOperation("注册用户")
    public R register(@RequestBody User user){
        if(StringUtils.isEmpty(user.getName())
                || StringUtils.isEmpty(user.getPhone())
                || StringUtils.isEmpty(user.getAccount())
                || StringUtils.isEmpty(user.getPassword())
                || StringUtils.isEmpty(user.getType())){
            return R.error().message("参数异常，请输入必填项。");
        }

        // 1. 通过用户名检查用户是否存在
        // 1.1 如果用户名存在，则提示用户请重新输入用户名
        // 1.2 如果不存在则调用业务层方法进行注册并加上创建时间和更新时间
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        Map<String, Object> result = new HashMap<>();
        result.put("user", user);

        return R.ok().data(result);
    }

    @PostMapping("accountExist")
    @ApiOperation("判断用户名是否存在")
    public R accountIsExist(@RequestBody String account){
        //通过账号获取对象是否存在
        User userByAccountName = userService.getUserByAccountName(account);
        if(Objects.isNull(userByAccountName)){
            System.out.println("用户名不存在，请继续操作。");
        }else {
            return R.error().message("账号已存在，请重新提交。");
        }
        return R.ok();
    }
}
