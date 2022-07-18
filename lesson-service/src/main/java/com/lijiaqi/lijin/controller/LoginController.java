package com.lijiaqi.lijin.controller;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.lijiaqi.lijin.api.users.bo.LjUserBO;
import com.lijiaqi.lijin.api.users.bo.UserBO;
import com.lijiaqi.lijin.api.users.service.LoginService;
import com.lijiaqi.lijin.api.users.service.UserCreateService;
import com.lijiaqi.lijin.api.wx.bo.MiniProgramsBO;
import com.lijiaqi.lijin.po.LjUserPO;
import com.ljq.plugins.base.exception.MyBusinessException;
import com.ljq.plugins.base.response.RspBO;
import com.ljq.plugins.base.security.jwt.LjqJwt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @描述： 登录相关入口
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    @Resource
    LoginService loginService;

    @Resource
    RestTemplate restTemplate;

    @Resource
    UserCreateService userCreateService;

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody UserBO userBO, HttpServletResponse response) {
        if (StringUtils.isEmpty(userBO.getUserName()) || StringUtils.isEmpty(userBO.getPassword())) {
            throw new MyBusinessException("用户名、密码不能为空！");
        }
        String token = loginService.login(userBO);
        if (token != null) {
            response.addHeader("token", token);
            response.addHeader("Access-Control-Expose-Headers", "token");
        }
        return token;
    }

    /**
     * wx.login 接口获取到的code换取openid
     *
     * @return
     */
    @PostMapping("/wx")
    @ResponseBody
    public Object wx(@RequestBody JSONObject params, HttpServletResponse response) {
        String appId = "wxe8a21ff9d547178c";
        String secret = "8da21bb561c8adac9255cd16fd7f6545";
        String urlTemplate = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
        String url = String.format(urlTemplate, appId, secret, params.getString("code"));
        ResponseEntity<MiniProgramsBO> forEntity = restTemplate.getForEntity(url, MiniProgramsBO.class);
        MiniProgramsBO resp = forEntity.getBody();
        if (resp == null || 0 != resp.getErrcode()) {
            return new RspBO(resp == null ? "-1" : resp.getErrcode() + "", "失败了,请稍后重试！");
        }
        //自动注册用户
        LjUserBO user = new LjUserBO();
        user.setNickName("暂不获取");
        user.setUserName(resp.getOpenid());
        user.setPassword("");
        user.setOpenid(resp.getOpenid());
        LjUserBO userIfNotExistsInWx = userCreateService.createUserIfNotExistsInWx(user);
        response.setHeader("token", LjqJwt.generateToken(userIfNotExistsInWx.getUserId() + "", userIfNotExistsInWx.getUserName()));
        return resp.getOpenid();
    }

}
