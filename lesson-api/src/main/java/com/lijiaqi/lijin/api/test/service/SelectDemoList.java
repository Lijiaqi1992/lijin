package com.lijiaqi.lijin.api.test.service;

import com.lijiaqi.lijin.api.test.bo.DemoReqBO;
import com.lijiaqi.lijin.api.test.bo.DemoRspBO;
import com.ljq.plugins.base.page.RspPage;

public interface SelectDemoList {
    RspPage<DemoRspBO> selectDemoList(DemoReqBO reqBO);
}
