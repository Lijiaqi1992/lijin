package com.lijiaqi.lijin.api.in.bo;

import com.ljq.plugins.base.page.RspPage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 李佳琪
 * 2022-07-18
 */
@Data
@NoArgsConstructor
public class SearchAllBO extends RspPage implements Serializable {

    private Integer userId;

    private String name;

}
