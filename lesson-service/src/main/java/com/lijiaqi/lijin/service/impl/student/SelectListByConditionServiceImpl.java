package com.lijiaqi.lijin.service.impl.student;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.lijiaqi.lijin.api.student.service.SelectListByConditionService;
import com.lijiaqi.lijin.dao.StudentsPOMapper;
import com.lijiaqi.lijin.po.StudentsPO;
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
 * @时间 2021-12-26
 */
@Service
public class SelectListByConditionServiceImpl implements SelectListByConditionService {
    @Resource
    StudentsPOMapper studentsPOMapper;

    @Override
    public List<StudentsBO> selectListByConditionService(StudentsBO studentsBO) {
        StudentsPOCriterion studentsPOCriterion = new StudentsPOCriterion();
        StudentsPOCriterion.Criteria criteria = studentsPOCriterion.createCriteria();
        if (StringUtils.isNotEmpty(studentsBO.getStudentName())) {
            criteria.andStudentNameLike("%"+studentsBO.getStudentName()+"%");
        }
        studentsPOCriterion.setOrderByClause("created_date_time desc");
        List<StudentsPO> studentsPOList = studentsPOMapper.selectByExample(studentsPOCriterion);
        return studentsPOList.stream().map(po -> {
            StudentsBO bo = new StudentsBO();
            BeanUtils.copyProperties(po, bo);
            return bo;
        }).collect(Collectors.toList());
    }
}
