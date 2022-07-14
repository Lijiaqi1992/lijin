package com.lijiaqi.lijin.dao;

import com.lijiaqi.lijin.po.StudentsPO;
import com.lijiaqi.lijin.po.StudentsPOCriterion;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentsPOMapper {
    long countByExample(StudentsPOCriterion example);

    int deleteByPrimaryKey(String studentId);

    int insert(StudentsPO record);

    int insertSelective(StudentsPO record);

    List<StudentsPO> selectByExample(StudentsPOCriterion example);

    StudentsPO selectByPrimaryKey(String studentId);

    int updateByExampleSelective(@Param("record") StudentsPO record, @Param("example") StudentsPOCriterion example);

    int updateByExample(@Param("record") StudentsPO record, @Param("example") StudentsPOCriterion example);

    int updateByPrimaryKeySelective(StudentsPO record);

    int updateByPrimaryKey(StudentsPO record);
}
