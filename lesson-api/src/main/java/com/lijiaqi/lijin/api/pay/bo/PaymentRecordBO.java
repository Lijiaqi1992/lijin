package com.lijiaqi.lijin.api.pay.bo;

import com.ljq.plugins.base.page.RspPage;

import java.io.Serializable;
import java.util.Date;

public class PaymentRecordBO extends RspPage implements Serializable {
    private String paymentId;

    private String studentId;   //学生id

    private String studentName;

    private Double payMoney;    //缴费金额

    private Date payDate;       //缴费时间

    private Integer payLessonNumber;    //缴费课次

    private Date nextPayDate;       //课费结束日期

    private Date createdDateTime;   //创建时间

    private Date updatedDateTime;   //修改时间

    private static final long serialVersionUID = 1L;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId == null ? null : paymentId.trim();
    }

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
        this.studentName = studentName;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Integer getPayLessonNumber() {
        return payLessonNumber;
    }

    public void setPayLessonNumber(Integer payLessonNumber) {
        this.payLessonNumber = payLessonNumber;
    }

    public Date getNextPayDate() {
        return nextPayDate;
    }

    public void setNextPayDate(Date nextPayDate) {
        this.nextPayDate = nextPayDate;
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
}
