package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.po.Demo;
import com.lijiaqi.lijin.po.DemoCriterion;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoMapper {
    int countByExample(DemoCriterion example);

    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    int insertSelective(Demo record);

    List<Demo> selectByExample(DemoCriterion example);

    Demo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Demo record, @Param("example") DemoCriterion example);

    int updateByExample(@Param("record") Demo record, @Param("example") DemoCriterion example);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}
