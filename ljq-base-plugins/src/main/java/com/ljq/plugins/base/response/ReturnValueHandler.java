package com.ljq.plugins.base.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 返回值处理
 */
public class ReturnValueHandler implements HandlerMethodReturnValueHandler {
    private Logger logger = LoggerFactory.getLogger(ReturnValueHandler.class);

    public ReturnValueHandler() {
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return returnType.getMethodAnnotation(ResponseBody.class) != null;
    }
    @Override
    public void handleReturnValue(Object obj, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        Map<String, Object> reMap = new HashMap<>();
        modelAndViewContainer.setRequestHandled(true);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        response.setContentType("application/json;charset=UTF-8");
        try {
            if (obj instanceof RspBO) {
                JSONObject jsonObject = JSON.parseObject(this.objToJsonString(obj));
                if (jsonObject.size() == 1) {
                    Set<String> keySet = jsonObject.keySet();
                    Iterator var9 = keySet.iterator();

                    while(var9.hasNext()) {
                        String str = (String)var9.next();
                        Object o = jsonObject.get(str);
                        reMap.put("data", o);
                    }
                } else {
                    reMap.put("data", jsonObject);
                }
                if (StringUtils.isNotEmpty(((RspBO) obj).getCode())) {
                    reMap.put("code", ((RspBO) obj).getCode());
                    reMap.put("message", ((RspBO) obj).getMessage());
                } else {
                    reMap.put("code", "0");
                    reMap.put("message", "成功");
                }
            } else {
                reMap.put("code", "0");
                reMap.put("message", "成功");
                if (obj != null) {
                    reMap.put("data", obj);
                }
            }
            this.returnMsg(reMap, response);
        } catch (Exception var12) {
            this.logger.info("转换信息失败，返回消息转换");
        }

    }


    private void returnMsg(Object msg, HttpServletResponse response) {
        PrintWriter writer = null;

        try {
            writer = response.getWriter();
            writer.write(this.objToJsonString(msg));
            writer.flush();
        } catch (IOException var8) {
            this.logger.error("统一格式返回", var8);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String objToJsonString(Object msg) {
        return JSON.toJSONString(msg, new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse});
    }

}

