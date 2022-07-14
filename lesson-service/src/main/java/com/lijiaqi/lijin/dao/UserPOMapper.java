package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.po.UserPO;
import com.lijiaqi.lijin.po.UserPOCriterion;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserPOMapper {
    long countByExample(UserPOCriterion example);

    int deleteByPrimaryKey(String userId);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    List<UserPO> selectByExample(UserPOCriterion example);

    UserPO selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserPO record, @Param("example") UserPOCriterion example);

    int updateByExample(@Param("record") UserPO record, @Param("example") UserPOCriterion example);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}
