package com.ljq.plugins.base.interceptor;

import com.ljq.plugins.base.exception.MyBusinessException;
import com.ljq.plugins.base.security.jwt.LjqJwt;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        try {
            if (StringUtils.isNotEmpty(token)) {
                Claims claims = LjqJwt.decodeToken(token);
                request.setAttribute("userId", claims.getId());
                request.setAttribute("userName", claims.getSubject());
                return true;
            }
            response.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401
        } catch (Exception e) {
            throw new MyBusinessException(HttpStatus.UNAUTHORIZED.value(), "请登录！");
        }
        return false;
    }
}
