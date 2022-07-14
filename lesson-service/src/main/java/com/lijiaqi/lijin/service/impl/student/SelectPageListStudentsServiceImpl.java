package com.lijiaqi.lijin.service.impl.student;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.lijiaqi.lijin.api.student.service.SelectPageListStudentsService;
import com.lijiaqi.lijin.dao.StudentsPOMapper;
import com.lijiaqi.lijin.po.StudentsPO;
import com.lijiaqi.lijin.po.StudentsPOCriterion;
import com.ljq.plugins.base.page.RspPage;
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
public class SelectPageListStudentsServiceImpl implements SelectPageListStudentsService {
    @Resource
    StudentsPOMapper studentsPOMapper;

    @Override
    public RspPage<StudentsBO> selectPageListStudentsService(StudentsBO studentsBO) {
        StudentsPOCriterion studentsPOCriterion = new StudentsPOCriterion();
        StudentsPOCriterion.Criteria criteria = studentsPOCriterion.createCriteria();
        if (StringUtils.isNotEmpty(studentsBO.getStudentName())) {
            criteria.andStudentNameLike("%"+studentsBO.getStudentName()+"%");
        }
        if (StringUtils.isNotEmpty(studentsBO.getStudentPhone())) {
            criteria.andStudentPhoneLike(studentsBO.getStudentPhone());
        }
        if (StringUtils.isNotEmpty(studentsBO.getParentName())) {
            criteria.andParentNameLike(studentsBO.getParentName());
        }
        if (StringUtils.isNotEmpty(studentsBO.getParentPhone())) {
            criteria.andParentPhoneLike(studentsBO.getParentPhone());
        }
        studentsPOCriterion.setOrderByClause("created_date_time desc");
        Page<StudentsBO> page = PageHelper.startPage(studentsBO.getPageNo(), studentsBO.getPageSize());
        List<StudentsPO> studentsPOList = studentsPOMapper.selectByExample(studentsPOCriterion);
        RspPage<StudentsBO> rspPage = new RspPage<>();

        List<StudentsBO> studentsBOList = studentsPOList.stream().map(po -> {
            StudentsBO bo = new StudentsBO();
            BeanUtils.copyProperties(po, bo);
            return bo;
        }).collect(Collectors.toList());
        rspPage.setResult(studentsBOList);
        rspPage.setPageNo(studentsBO.getPageNo());
        rspPage.setTotalPages(page.getPages());
        rspPage.setTotalCount((int) page.getTotal());
        return rspPage;
    }
}
