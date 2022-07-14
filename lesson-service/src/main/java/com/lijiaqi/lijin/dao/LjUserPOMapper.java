package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.po.LjUserPO;
import com.lijiaqi.lijin.po.LjUserPOCriterion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LjUserPOMapper {
    long countByExample(LjUserPOCriterion example);

    int deleteByPrimaryKey(Integer userId);

    int insert(LjUserPO record);

    int insertSelective(LjUserPO record);

    List<LjUserPO> selectByExample(LjUserPOCriterion example);

    LjUserPO selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") LjUserPO record, @Param("example") LjUserPOCriterion example);

    int updateByExample(@Param("record") LjUserPO record, @Param("example") LjUserPOCriterion example);

    int updateByPrimaryKeySelective(LjUserPO record);

    int updateByPrimaryKey(LjUserPO record);
}