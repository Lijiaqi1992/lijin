package com.lijiaqi.lijin.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentsPOCriterion {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentsPOCriterion() {
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

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIsNull() {
            addCriterion("student_phone is null");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIsNotNull() {
            addCriterion("student_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneEqualTo(String value) {
            addCriterion("student_phone =", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotEqualTo(String value) {
            addCriterion("student_phone <>", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneGreaterThan(String value) {
            addCriterion("student_phone >", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("student_phone >=", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLessThan(String value) {
            addCriterion("student_phone <", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLessThanOrEqualTo(String value) {
            addCriterion("student_phone <=", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLike(String value) {
            addCriterion("student_phone like", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotLike(String value) {
            addCriterion("student_phone not like", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIn(List<String> values) {
            addCriterion("student_phone in", values, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotIn(List<String> values) {
            addCriterion("student_phone not in", values, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneBetween(String value1, String value2) {
            addCriterion("student_phone between", value1, value2, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotBetween(String value1, String value2) {
            addCriterion("student_phone not between", value1, value2, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andWechartIdIsNull() {
            addCriterion("wechart_id is null");
            return (Criteria) this;
        }

        public Criteria andWechartIdIsNotNull() {
            addCriterion("wechart_id is not null");
            return (Criteria) this;
        }

        public Criteria andWechartIdEqualTo(String value) {
            addCriterion("wechart_id =", value, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdNotEqualTo(String value) {
            addCriterion("wechart_id <>", value, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdGreaterThan(String value) {
            addCriterion("wechart_id >", value, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdGreaterThanOrEqualTo(String value) {
            addCriterion("wechart_id >=", value, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdLessThan(String value) {
            addCriterion("wechart_id <", value, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdLessThanOrEqualTo(String value) {
            addCriterion("wechart_id <=", value, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdLike(String value) {
            addCriterion("wechart_id like", value, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdNotLike(String value) {
            addCriterion("wechart_id not like", value, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdIn(List<String> values) {
            addCriterion("wechart_id in", values, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdNotIn(List<String> values) {
            addCriterion("wechart_id not in", values, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdBetween(String value1, String value2) {
            addCriterion("wechart_id between", value1, value2, "wechartId");
            return (Criteria) this;
        }

        public Criteria andWechartIdNotBetween(String value1, String value2) {
            addCriterion("wechart_id not between", value1, value2, "wechartId");
            return (Criteria) this;
        }

        public Criteria andParentNameIsNull() {
            addCriterion("parent_name is null");
            return (Criteria) this;
        }

        public Criteria andParentNameIsNotNull() {
            addCriterion("parent_name is not null");
            return (Criteria) this;
        }

        public Criteria andParentNameEqualTo(String value) {
            addCriterion("parent_name =", value, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameNotEqualTo(String value) {
            addCriterion("parent_name <>", value, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameGreaterThan(String value) {
            addCriterion("parent_name >", value, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameGreaterThanOrEqualTo(String value) {
            addCriterion("parent_name >=", value, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameLessThan(String value) {
            addCriterion("parent_name <", value, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameLessThanOrEqualTo(String value) {
            addCriterion("parent_name <=", value, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameLike(String value) {
            addCriterion("parent_name like", value, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameNotLike(String value) {
            addCriterion("parent_name not like", value, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameIn(List<String> values) {
            addCriterion("parent_name in", values, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameNotIn(List<String> values) {
            addCriterion("parent_name not in", values, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameBetween(String value1, String value2) {
            addCriterion("parent_name between", value1, value2, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentNameNotBetween(String value1, String value2) {
            addCriterion("parent_name not between", value1, value2, "parentName");
            return (Criteria) this;
        }

        public Criteria andParentPhoneIsNull() {
            addCriterion("parent_phone is null");
            return (Criteria) this;
        }

        public Criteria andParentPhoneIsNotNull() {
            addCriterion("parent_phone is not null");
            return (Criteria) this;
        }

        public Criteria andParentPhoneEqualTo(String value) {
            addCriterion("parent_phone =", value, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneNotEqualTo(String value) {
            addCriterion("parent_phone <>", value, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneGreaterThan(String value) {
            addCriterion("parent_phone >", value, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("parent_phone >=", value, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneLessThan(String value) {
            addCriterion("parent_phone <", value, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneLessThanOrEqualTo(String value) {
            addCriterion("parent_phone <=", value, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneLike(String value) {
            addCriterion("parent_phone like", value, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneNotLike(String value) {
            addCriterion("parent_phone not like", value, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneIn(List<String> values) {
            addCriterion("parent_phone in", values, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneNotIn(List<String> values) {
            addCriterion("parent_phone not in", values, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneBetween(String value1, String value2) {
            addCriterion("parent_phone between", value1, value2, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andParentPhoneNotBetween(String value1, String value2) {
            addCriterion("parent_phone not between", value1, value2, "parentPhone");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Double value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Double value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Double value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Double value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Double value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Double> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Double> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Double value1, Double value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Double value1, Double value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andLearnTimesIsNull() {
            addCriterion("learn_times is null");
            return (Criteria) this;
        }

        public Criteria andLearnTimesIsNotNull() {
            addCriterion("learn_times is not null");
            return (Criteria) this;
        }

        public Criteria andLearnTimesEqualTo(Integer value) {
            addCriterion("learn_times =", value, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesNotEqualTo(Integer value) {
            addCriterion("learn_times <>", value, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesGreaterThan(Integer value) {
            addCriterion("learn_times >", value, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("learn_times >=", value, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesLessThan(Integer value) {
            addCriterion("learn_times <", value, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesLessThanOrEqualTo(Integer value) {
            addCriterion("learn_times <=", value, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesIn(List<Integer> values) {
            addCriterion("learn_times in", values, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesNotIn(List<Integer> values) {
            addCriterion("learn_times not in", values, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesBetween(Integer value1, Integer value2) {
            addCriterion("learn_times between", value1, value2, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andLearnTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("learn_times not between", value1, value2, "learnTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesIsNull() {
            addCriterion("payment_times is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesIsNotNull() {
            addCriterion("payment_times is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesEqualTo(Integer value) {
            addCriterion("payment_times =", value, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesNotEqualTo(Integer value) {
            addCriterion("payment_times <>", value, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesGreaterThan(Integer value) {
            addCriterion("payment_times >", value, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_times >=", value, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesLessThan(Integer value) {
            addCriterion("payment_times <", value, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesLessThanOrEqualTo(Integer value) {
            addCriterion("payment_times <=", value, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesIn(List<Integer> values) {
            addCriterion("payment_times in", values, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesNotIn(List<Integer> values) {
            addCriterion("payment_times not in", values, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesBetween(Integer value1, Integer value2) {
            addCriterion("payment_times between", value1, value2, "paymentTimes");
            return (Criteria) this;
        }

        public Criteria andPaymentTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_times not between", value1, value2, "paymentTimes");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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
