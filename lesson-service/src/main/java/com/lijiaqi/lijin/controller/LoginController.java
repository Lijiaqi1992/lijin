package com.lijiaqi.lijin.controller;

import com.lijiaqi.lijin.api.users.bo.UserBO;
import com.lijiaqi.lijin.api.users.service.LoginService;
import com.lijiaqi.lijin.api.wx.bo.MiniProgramsBO;
import com.ljq.plugins.base.exception.MyBusinessException;
import com.ljq.plugins.base.response.RspBO;
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
    public Object wx(@RequestParam("code") String code) {
        String appId = "xxx";
        String secret = "xxx";
        String urlTemplate = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
        String url = String.format(urlTemplate, appId, secret, code);
        ResponseEntity<MiniProgramsBO> forEntity = restTemplate.getForEntity(url, MiniProgramsBO.class);
        MiniProgramsBO resp = forEntity.getBody();
        if (resp == null || 0 != resp.getErrcode()) {
            return new RspBO(resp == null ? "-1" : resp.getErrcode() + "", "失败了,请稍后重试！");
        }
        return resp.getOpenid();
    }

}
