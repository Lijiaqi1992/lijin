package com.lijiaqi.lijin.po;

import java.io.Serializable;
import java.util.Date;

public class PaymentRecordPO implements Serializable {
    private String paymentId;

    private String studentId;

    private Double payMoney;

    private Date payDate;

    private Integer payLessonNumber;

    private Date nextPayDate;

    private Date createdDateTime;

    private Date updatedDateTime;

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
