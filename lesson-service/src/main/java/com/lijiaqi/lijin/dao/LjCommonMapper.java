package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.api.in.bo.SearchAllBO;
import com.lijiaqi.lijin.po.InOutPO;

import java.util.List;

public interface LjCommonMapper {

    List<InOutPO> getAllList(SearchAllBO searchAllBO);
}
