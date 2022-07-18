package com.lijiaqi.lijin.api.in.service;

import com.lijiaqi.lijin.api.in.bo.LjInMoneyBO;
import com.lijiaqi.lijin.api.in.bo.SearchInBO;
import com.ljq.plugins.base.page.RspPage;

/**
 * @author 李佳琪
 * 2022-07-18
 */
public interface SelectInPageListService {

    RspPage<LjInMoneyBO> getInPageList(SearchInBO searchInBO);
}
