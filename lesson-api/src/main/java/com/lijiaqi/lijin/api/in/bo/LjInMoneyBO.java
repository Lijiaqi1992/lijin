package com.lijiaqi.lijin.api.in.bo;

import com.ljq.plugins.base.page.RspPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LjInMoneyBO extends RspPage implements Serializable {
    private Integer inId;

    private Integer userId;

    private String name;

    private String reason;

    private Double inMoney;

    private Date inDate;

    private Double returnMoney;

    private Date returnDate;

    private String returnReason;

    private String note;

    private Date createDate;

    private String type = "in";


}
