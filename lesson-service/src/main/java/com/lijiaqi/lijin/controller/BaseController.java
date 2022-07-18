package com.lijiaqi.lijin.controller;

import com.ljq.plugins.base.exception.MyBusinessException;
import com.ljq.plugins.base.security.jwt.LjqJwt;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 李佳琪
 * 2022-07-18
 */
@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    public Integer getCurrentUserId() {
        try {
            return Integer.parseInt(request.getAttribute("userId").toString());
        } catch (Exception e) {
            throw new MyBusinessException(HttpStatus.UNAUTHORIZED.value(), "请登录后使用！");
        }
    }
}
