package com.hwadee.controller;

import com.hwadee.common.MD5Util;
import com.hwadee.common.R;
import com.hwadee.common.TokenUtil;
import com.hwadee.entity.Menu;
import com.hwadee.entity.User;
import com.hwadee.entity.vo.LoginVO;
import com.hwadee.entity.vo.UserVO;
import com.hwadee.service.IMenuService;
import com.hwadee.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Api(tags = "登录接口管理")
public class LoginController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IMenuService menuService;

    /**
     * 登录方法
     * @param loginVO
     * @param session
     * @return
     */
    @PostMapping("login")
    @ApiOperation("登录接口")
    public R login(@RequestBody LoginVO loginVO, HttpSession session){
        // 调用业务层方法，查看用户名是否存在
        User userEntity = userService.getUserByAccountName(loginVO.getAccount());
        if(userEntity == null){
            return R.error().message("用户名不存在，请重新输入");
        }
        else{
            // 根据用户名和密码查询用户名、密码是否匹配
            String password = MD5Util.encryptMD5AndSalt(loginVO.getPassword(), MD5Util.DEFAULT_SALT);
            User userByLoginInfo = userService.getUserByLoginInfo(loginVO.getAccount(), password);
            Map<String, Object> resultMap = new HashMap<>();
            if(userByLoginInfo != null){
                List<Menu> menus = menuService.listByUserId(userByLoginInfo.getUserId());
                String token = TokenUtil.sign(userByLoginInfo);
                resultMap.put("token", token);
                resultMap.put("menus", menus);
                resultMap.put("user", userByLoginInfo);
                session.setAttribute("user", userByLoginInfo);
                return R.ok().message("登录成功").data(resultMap);
            }
            else {
                return R.error().message("密码错误");
            }
        }
    }
}
