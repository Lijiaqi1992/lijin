package com.lijiaqi.lijin.api.student.service;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.ljq.plugins.base.page.RspPage;

/**
 * @描述： 带分页列表
 * @作者： 李佳琪
 * @时间 2021-12-26
 */
public interface SelectPageListStudentsService {
    RspPage<StudentsBO> selectPageListStudentsService(StudentsBO studentsBO);
}
