package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.po.LjOutMoneyPO;
import com.lijiaqi.lijin.po.LjOutMoneyPOCriterion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LjOutMoneyPOMapper {
    long countByExample(LjOutMoneyPOCriterion example);

    int deleteByPrimaryKey(Integer outId);

    int insert(LjOutMoneyPO record);

    int insertSelective(LjOutMoneyPO record);

    List<LjOutMoneyPO> selectByExample(LjOutMoneyPOCriterion example);

    LjOutMoneyPO selectByPrimaryKey(Integer outId);

    int updateByExampleSelective(@Param("record") LjOutMoneyPO record, @Param("example") LjOutMoneyPOCriterion example);

    int updateByExample(@Param("record") LjOutMoneyPO record, @Param("example") LjOutMoneyPOCriterion example);

    int updateByPrimaryKeySelective(LjOutMoneyPO record);

    int updateByPrimaryKey(LjOutMoneyPO record);
}