package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.api.in.bo.SearchAllBO;
import com.lijiaqi.lijin.api.mine.bo.AnalysisPieBO;
import com.lijiaqi.lijin.po.InOutPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LjCommonMapper {

    List<InOutPO> getAllList(SearchAllBO searchAllBO);

    Double inMoneyCount(@Param("userId") Integer userId);

    Double outMoneyCount(@Param("userId") Integer userId);

    List<AnalysisPieBO> inMoneyGroupAnalysis(@Param("userId") Integer currentUserId);

    List<AnalysisPieBO> outMoneyGroupAnalysis(@Param("userId") Integer currentUserId);
}
