package com.lijiaqi.lijin.service.impl.student;

import com.lijiaqi.lijin.api.student.service.DeleteStudentByIdService;
import com.lijiaqi.lijin.dao.StudentsPOMapper;
import com.lijiaqi.lijin.po.StudentsPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2022-01-03
 */
@Service
public class DeleteStudentByIdServiceImpl implements DeleteStudentByIdService {
    @Resource
    StudentsPOMapper studentsPOMapper;

    @Override
    public int deleteStudentByIdService(String id) {
        StudentsPO po = new StudentsPO();
        po.setUpdatedDateTime(new Date());
        po.setStatus(1);
        po.setStudentId(id);
        return studentsPOMapper.updateByPrimaryKeySelective(po);
    }
}
