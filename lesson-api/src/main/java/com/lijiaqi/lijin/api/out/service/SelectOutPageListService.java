package com.lijiaqi.lijin.api.out.service;

import com.lijiaqi.lijin.api.out.bo.LjOutMoneyBO;
import com.lijiaqi.lijin.api.out.bo.SearchOutBO;
import com.ljq.plugins.base.page.RspPage;

public interface SelectOutPageListService {
    RspPage<LjOutMoneyBO> getOutPageList(SearchOutBO searchOutBO);
}
