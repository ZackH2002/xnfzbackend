package com.hwadee.controller;

import com.hwadee.common.R;
import com.hwadee.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@Api(tags = "登录接口管理")
public class LoginController {

    /**
     * 登录方法
     * @param user
     * @param session
     * @return
     */
    @PostMapping("login")
    @ApiOperation("登录接口")
    public R login(@RequestBody User user, HttpSession session){
        // 1. 获取参数
        Map<String, Object> params = new HashMap<>();
        params.put("account", user.getAccount());
        params.put("password", user.getPassword());
        System.out.println("用户名：" + params.get("account"));
        System.out.println("密码：" + params.get("password"));
        // 2. 调用业务层方法，根据用户名查询用户是否存在

        // 3. 根据用户名和密码查询用户是否匹配
        return R.ok();
    }
}
