package com.lijiaqi.lijin.service.impl.student;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.lijiaqi.lijin.api.student.service.CreateStudentService;
import com.lijiaqi.lijin.dao.StudentsPOMapper;
import com.lijiaqi.lijin.po.StudentsPO;
import com.ljq.plugins.base.common.CommonTools;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2021-12-26
 */
@Service
public class CreateStudentServiceImpl implements CreateStudentService {
    @Resource
    StudentsPOMapper studentsPOMapper;

    @Override
    public int createStudentService(StudentsBO studentsBO) {
        StudentsPO po = new StudentsPO();
        BeanUtils.copyProperties(studentsBO, po);
        po.setStudentId(CommonTools.idGenerate());
        po.setCreatedDateTime(new Date());
        po.setStatus(0);
        return studentsPOMapper.insert(po);
    }
}
