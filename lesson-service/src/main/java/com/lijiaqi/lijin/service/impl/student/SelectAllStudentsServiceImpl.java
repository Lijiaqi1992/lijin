package com.lijiaqi.lijin.service.impl.student;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.lijiaqi.lijin.api.student.service.SelectAllStudentsService;
import com.lijiaqi.lijin.dao.StudentsPOMapper;
import com.lijiaqi.lijin.po.StudentsPOCriterion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2022-01-02
 */
@Service
public class SelectAllStudentsServiceImpl implements SelectAllStudentsService{
    @Resource
    StudentsPOMapper studentsPOMapper;

    @Override
    public List<StudentsBO> selectAllStudentsService(StudentsBO studentsBO) {
        StudentsPOCriterion studentsPOCriterion = new StudentsPOCriterion();
        StudentsPOCriterion.Criteria criteria = studentsPOCriterion.createCriteria();
        if(StringUtils.isNotEmpty(studentsBO.getStudentName())){
            criteria.andStudentNameLike("%"+studentsBO.getStudentName()+"%");
        }
        return studentsPOMapper.selectByExample(studentsPOCriterion).stream().map(po->{
            StudentsBO bo = new StudentsBO();
            BeanUtils.copyProperties(po, bo);
            return bo;
        }).collect(Collectors.toList());
    }
}
