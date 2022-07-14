package com.lijiaqi.lijin.api.wx.bo;

import lombok.Data;

/**
 * @author 李佳琪
 * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
 * 2022-07-14
 */
@Data
public class MiniProgramsBO {
    private String openid;//用户唯一标识
    private String session_key;//	会话密钥
    private String unionid;//用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID 机制说明。
    /**
     * -1	系统繁忙，此时请开发者稍候再试
     * 0	请求成功
     * 40029	code 无效
     * 45011	频率限制，每个用户每分钟100次
     * 40226	高风险等级用户，小程序登录拦截 。风险等级详见用户安全解方案
     */
    private int errcode; //错误码
    private String errmsg;//	错误信息


}
