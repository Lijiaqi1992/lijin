package com.lijiaqi.lijin.service.impl.student;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.lijiaqi.lijin.api.student.service.UpdateStudentService;
import com.lijiaqi.lijin.dao.StudentsPOMapper;
import com.lijiaqi.lijin.po.StudentsPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2022-01-03
 */
@Service
public class UpdateStudentServiceImpl implements UpdateStudentService {
    @Resource
    StudentsPOMapper studentsPOMapper;

    @Override
    public int updateStudentService(StudentsBO studentsBO) {
        StudentsPO po = new StudentsPO();
        BeanUtils.copyProperties(studentsBO, po);
        po.setUpdatedDateTime(new Date());
        return studentsPOMapper.updateByPrimaryKeySelective(po);
    }
}
