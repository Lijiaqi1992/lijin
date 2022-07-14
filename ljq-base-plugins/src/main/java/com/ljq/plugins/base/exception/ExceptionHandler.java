package com.ljq.plugins.base.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理
 */
@Order(-1000)
@RestControllerAdvice
public class ExceptionHandler implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    public ExceptionHandler(){}
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        Map<String,Object> reMap = new HashMap<>();
        if(e.getClass().getSimpleName().equals(MyBusinessException.class.getSimpleName()) ){
            MyBusinessException mb = (MyBusinessException) e;
            String msg = mb.getMsg();
            addResult(reMap, mb.getHttpStatus(),msg);
        }else{
            addResult(reMap, 1 ,e.getMessage());
        }
        this.logger.error("程序出现异常：" + JSON.toJSONString(reMap), e);
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            httpServletResponse.getWriter().write(JSON.toJSONString(reMap, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse));
        } catch (IOException ex) {
            logger.error("响应回复异常："+ex.getMessage());
        }
        return new ModelAndView();
    }

    /**
     * 封装code和msg
     */
    private final void addResult(Map<String,Object> reMap, final Integer code, final String message) {
        if(code == null){
            reMap.put("code",1);
        }else{
            reMap.put("code",code);
        }
        reMap.put("message",message);
    }
}
