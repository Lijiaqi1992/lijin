package com.lijiaqi.lijin.api.student.service;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;

import java.util.List;

/**
 * @描述： 查询所有的学生，根据名称模糊
 * @作者： 李佳琪
 * @时间 2022-01-02
 */
public interface SelectAllStudentsService {

    List<StudentsBO> selectAllStudentsService(StudentsBO studentsBO);
}
