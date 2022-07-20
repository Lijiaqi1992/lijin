package com.lijiaqi.lijin.po;

import lombok.Data;

import java.util.Date;

/**
 * @author 李佳琪
 * 2022-07-20
 */
@Data
public class InOutPO {
    private Integer userId;
    private String name;
    private Date edate;
    private Double money;
    private String type;
    private String reason;
}
