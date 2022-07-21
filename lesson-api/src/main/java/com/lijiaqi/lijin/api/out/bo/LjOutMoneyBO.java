package com.lijiaqi.lijin.api.out.bo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LjOutMoneyBO implements Serializable {
    private Integer outId;

    private Integer userId;

    private String name;

    private String reason;

    private Double outMoney;

    @JSONField(format = "yyyy-MM-dd")
    private Date outDate;

    private Integer inId;

    private String note;

    private Date createDate;

    private String type = "out";

}
