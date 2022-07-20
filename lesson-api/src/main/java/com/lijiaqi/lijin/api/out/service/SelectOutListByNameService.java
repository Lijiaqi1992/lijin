package com.lijiaqi.lijin.api.out.service;

import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.bo.SearchInBO;
import com.lijiaqi.lijin.api.out.bo.LjOutMoneyBO;
import com.lijiaqi.lijin.api.out.bo.SearchOutBO;

import java.util.List;

/**
 * @author 李佳琪
 * 2022-07-18
 */
public interface SelectOutListByNameService {

    List<LjOutMoneyBO> getListByName(SearchOutBO searchOutBO);
}
