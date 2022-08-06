package com.lijiaqi.lijin.api.in.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.ljq.plugins.base.page.RspPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LjInMoneyBO extends RspPage implements Serializable {

    private Integer id;

    private Integer inId;

    private Integer userId;

    private String name;

    private String reason;

    private Double inMoney;

    @JSONField(format = "yyyy-MM-dd")
    private Date inDate;

    private Double returnMoney;

    @JSONField(format = "yyyy-MM-dd")
    private Date returnDate;

    private String returnReason;

    private String note;

    private Date createDate;

    private String type = "in";

    public Integer getId() {
        return inId;
    }
}
