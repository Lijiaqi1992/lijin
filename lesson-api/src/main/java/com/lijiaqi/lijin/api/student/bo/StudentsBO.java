package com.lijiaqi.lijin.api.student.bo;

import com.ljq.plugins.base.page.RspPage;

import java.io.Serializable;
import java.util.Date;

public class StudentsBO extends RspPage implements Serializable {
    private String studentId;       // id
    private String studentName;     // 姓名
    private String studentPhone;    // 学生手机号
    private String grade;           // 年级
    private String weChartId;       // 微信号
    private String parentName;      // 家长姓名
    private String parentPhone;     // 家长手机号
    private Double fee;             // 课时费
    private Integer learnTimes;     // 学习次数
    private Integer paymentTimes;   // 缴费次数
    private Date createdDateTime;   // 创建时间
    private Date updatedDateTime;   // 修改时间
    private Integer status;            //  状态  ： 0正常1退出

    private static final long serialVersionUID = 1L;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone == null ? null : studentPhone.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getWeChartId() {
        return weChartId;
    }

    public void setWeChartId(String weChartId) {
        this.weChartId = weChartId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone == null ? null : parentPhone.trim();
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getLearnTimes() {
        return learnTimes;
    }

    public void setLearnTimes(Integer learnTimes) {
        this.learnTimes = learnTimes;
    }

    public Integer getPaymentTimes() {
        return paymentTimes;
    }

    public void setPaymentTimes(Integer paymentTimes) {
        this.paymentTimes = paymentTimes;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Date updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
