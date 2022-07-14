package com.lijiaqi.lijin.api.student.service;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;

import java.util.List;

/**
 * @描述： 不带分页条件查询列表
 * @作者： 李佳琪
 * @时间 2021-12-26
 */
public interface SelectListByConditionService {
    List<StudentsBO> selectListByConditionService(StudentsBO studentsBO);
}
