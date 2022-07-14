package com.lijiaqi.lijin.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PaymentRecordPOCriterion {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymentRecordPOCriterion() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPaymentIdIsNull() {
            addCriterion("payment_id is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("payment_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(String value) {
            addCriterion("payment_id =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(String value) {
            addCriterion("payment_id <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(String value) {
            addCriterion("payment_id >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(String value) {
            addCriterion("payment_id >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(String value) {
            addCriterion("payment_id <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(String value) {
            addCriterion("payment_id <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLike(String value) {
            addCriterion("payment_id like", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotLike(String value) {
            addCriterion("payment_id not like", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<String> values) {
            addCriterion("payment_id in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<String> values) {
            addCriterion("payment_id not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(String value1, String value2) {
            addCriterion("payment_id between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(String value1, String value2) {
            addCriterion("payment_id not between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNull() {
            addCriterion("pay_money is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(Double value) {
            addCriterion("pay_money =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(Double value) {
            addCriterion("pay_money <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(Double value) {
            addCriterion("pay_money >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("pay_money >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(Double value) {
            addCriterion("pay_money <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(Double value) {
            addCriterion("pay_money <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<Double> values) {
            addCriterion("pay_money in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<Double> values) {
            addCriterion("pay_money not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(Double value1, Double value2) {
            addCriterion("pay_money between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(Double value1, Double value2) {
            addCriterion("pay_money not between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(Date value) {
            addCriterion("pay_date =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(Date value) {
            addCriterion("pay_date <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(Date value) {
            addCriterion("pay_date >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_date >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(Date value) {
            addCriterion("pay_date <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(Date value) {
            addCriterion("pay_date <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<Date> values) {
            addCriterion("pay_date in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<Date> values) {
            addCriterion("pay_date not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(Date value1, Date value2) {
            addCriterion("pay_date between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(Date value1, Date value2) {
            addCriterion("pay_date not between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberIsNull() {
            addCriterion("pay_lesson_number is null");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberIsNotNull() {
            addCriterion("pay_lesson_number is not null");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberEqualTo(Integer value) {
            addCriterion("pay_lesson_number =", value, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberNotEqualTo(Integer value) {
            addCriterion("pay_lesson_number <>", value, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberGreaterThan(Integer value) {
            addCriterion("pay_lesson_number >", value, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_lesson_number >=", value, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberLessThan(Integer value) {
            addCriterion("pay_lesson_number <", value, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberLessThanOrEqualTo(Integer value) {
            addCriterion("pay_lesson_number <=", value, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberIn(List<Integer> values) {
            addCriterion("pay_lesson_number in", values, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberNotIn(List<Integer> values) {
            addCriterion("pay_lesson_number not in", values, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberBetween(Integer value1, Integer value2) {
            addCriterion("pay_lesson_number between", value1, value2, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andPayLessonNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_lesson_number not between", value1, value2, "payLessonNumber");
            return (Criteria) this;
        }

        public Criteria andNextPayDateIsNull() {
            addCriterion("next_pay_date is null");
            return (Criteria) this;
        }

        public Criteria andNextPayDateIsNotNull() {
            addCriterion("next_pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andNextPayDateEqualTo(Date value) {
            addCriterionForJDBCDate("next_pay_date =", value, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("next_pay_date <>", value, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateGreaterThan(Date value) {
            addCriterionForJDBCDate("next_pay_date >", value, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("next_pay_date >=", value, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateLessThan(Date value) {
            addCriterionForJDBCDate("next_pay_date <", value, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("next_pay_date <=", value, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateIn(List<Date> values) {
            addCriterionForJDBCDate("next_pay_date in", values, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("next_pay_date not in", values, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("next_pay_date between", value1, value2, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andNextPayDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("next_pay_date not between", value1, value2, "nextPayDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIsNull() {
            addCriterion("created_date_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIsNotNull() {
            addCriterion("created_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeEqualTo(Date value) {
            addCriterion("created_date_time =", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotEqualTo(Date value) {
            addCriterion("created_date_time <>", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeGreaterThan(Date value) {
            addCriterion("created_date_time >", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date_time >=", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeLessThan(Date value) {
            addCriterion("created_date_time <", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_date_time <=", value, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeIn(List<Date> values) {
            addCriterion("created_date_time in", values, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotIn(List<Date> values) {
            addCriterion("created_date_time not in", values, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeBetween(Date value1, Date value2) {
            addCriterion("created_date_time between", value1, value2, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_date_time not between", value1, value2, "createdDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeIsNull() {
            addCriterion("updated_date_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeIsNotNull() {
            addCriterion("updated_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeEqualTo(Date value) {
            addCriterion("updated_date_time =", value, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeNotEqualTo(Date value) {
            addCriterion("updated_date_time <>", value, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeGreaterThan(Date value) {
            addCriterion("updated_date_time >", value, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_date_time >=", value, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeLessThan(Date value) {
            addCriterion("updated_date_time <", value, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_date_time <=", value, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeIn(List<Date> values) {
            addCriterion("updated_date_time in", values, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeNotIn(List<Date> values) {
            addCriterion("updated_date_time not in", values, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeBetween(Date value1, Date value2) {
            addCriterion("updated_date_time between", value1, value2, "updatedDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_date_time not between", value1, value2, "updatedDateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
