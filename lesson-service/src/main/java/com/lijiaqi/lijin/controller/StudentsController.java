package com.lijiaqi.lijin.controller;

import com.lijiaqi.lijin.api.student.bo.StudentsBO;
import com.lijiaqi.lijin.api.student.service.*;
import com.ljq.plugins.base.page.RspPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @描述：
 * @作者： 李佳琪
 * @时间 2021-12-26
 */
@RestController
@RequestMapping(value = "/student")
public class StudentsController {

    @Resource
    CreateStudentService createStudentService;

    @Resource
    SelectPageListStudentsService selectPageListStudentsService;

    @Resource
    SelectStudentByPkService selectStudentByPkService;

    @Resource
    SelectAllStudentsService selectAllStudentsService;

    @Resource
    DeleteStudentByIdService deleteStudentByIdService;

    @Resource
    UpdateStudentService updateStudentService;

    @ResponseBody
    @RequestMapping(value = "/create")
    public Object createStudent(@RequestBody StudentsBO studentsBO) {
        int studentService = createStudentService.createStudentService(studentsBO);
        return studentService;
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public Object updateStudent(@RequestBody StudentsBO studentsBO) {
        int studentService = updateStudentService.updateStudentService(studentsBO);
        return studentService;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}")
    public Object deleteStudent(@PathVariable String id) {
        int studentService = deleteStudentByIdService.deleteStudentByIdService(id);
        return studentService;
    }

    @ResponseBody
    @RequestMapping(value = "/selectByPk/{id}")
    public Object selectByPk(@PathVariable String id) {
        StudentsBO studentService = selectStudentByPkService.selectStudentByPkService(id);
        return studentService;
    }

    @ResponseBody
    @RequestMapping(value = "/pageList")
    public Object pageListStudents(@RequestBody StudentsBO studentsBO) {
        RspPage<StudentsBO> studentsBORspPage = selectPageListStudentsService.selectPageListStudentsService(studentsBO);
        return studentsBORspPage;
    }

    @ResponseBody
    @RequestMapping(value = "/selectAll")
    public Object selectAllStudents(@RequestBody StudentsBO studentsBO) {
        List<StudentsBO> studentsBOS = selectAllStudentsService.selectAllStudentsService(studentsBO);
        return studentsBOS;
    }


}
