package com.ljq.plugins.base.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RspBO implements Serializable {
    @JSONField(serialize=false)
    private String code;
    @JSONField(serialize=false)
    private String message;
}
