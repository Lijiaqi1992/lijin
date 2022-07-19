package com.lijiaqi.lijin.api.in.service;

import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.bo.SearchInBO;

import java.util.List;

/**
 * @author 李佳琪
 * 2022-07-18
 */
public interface SelectInListByNameService {

    List<LjInMoneyBO> getListByName(SearchInBO searchInBO);
}
