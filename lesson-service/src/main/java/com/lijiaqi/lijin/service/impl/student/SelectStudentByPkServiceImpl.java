package com.lijiaqi.lijin.service.impl.student;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.lijiaqi.lijin.api.student.service.SelectStudentByPkService;
import com.lijiaqi.lijin.dao.StudentsPOMapper;
import com.lijiaqi.lijin.po.StudentsPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2021-12-26
 */
@Service
public class SelectStudentByPkServiceImpl implements SelectStudentByPkService {
    @Resource
    StudentsPOMapper studentsPOMapper;

    @Override
    public StudentsBO selectStudentByPkService(String id) {
        StudentsPO studentsPO = studentsPOMapper.selectByPrimaryKey(id);
        StudentsBO bo = new StudentsBO();
        BeanUtils.copyProperties(studentsPO, bo);
        return bo;
    }
}
