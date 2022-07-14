package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.po.LjInMoneyPO;
import com.lijiaqi.lijin.po.LjInMoneyPOCriterion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LjInMoneyPOMapper {
    long countByExample(LjInMoneyPOCriterion example);

    int deleteByPrimaryKey(Integer inId);

    int insert(LjInMoneyPO record);

    int insertSelective(LjInMoneyPO record);

    List<LjInMoneyPO> selectByExample(LjInMoneyPOCriterion example);

    LjInMoneyPO selectByPrimaryKey(Integer inId);

    int updateByExampleSelective(@Param("record") LjInMoneyPO record, @Param("example") LjInMoneyPOCriterion example);

    int updateByExample(@Param("record") LjInMoneyPO record, @Param("example") LjInMoneyPOCriterion example);

    int updateByPrimaryKeySelective(LjInMoneyPO record);

    int updateByPrimaryKey(LjInMoneyPO record);
}