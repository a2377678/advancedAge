package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class AdvancedAgeApplyEmployedSituationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvancedAgeApplyEmployedSituationExample() {
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

        public Criteria andIdentificationIsNull() {
            addCriterion("identification is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationIsNotNull() {
            addCriterion("identification is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationEqualTo(String value) {
            addCriterion("identification =", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotEqualTo(String value) {
            addCriterion("identification <>", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationGreaterThan(String value) {
            addCriterion("identification >", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationGreaterThanOrEqualTo(String value) {
            addCriterion("identification >=", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLessThan(String value) {
            addCriterion("identification <", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLessThanOrEqualTo(String value) {
            addCriterion("identification <=", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLike(String value) {
            addCriterion("identification like", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotLike(String value) {
            addCriterion("identification not like", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationIn(List<String> values) {
            addCriterion("identification in", values, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotIn(List<String> values) {
            addCriterion("identification not in", values, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationBetween(String value1, String value2) {
            addCriterion("identification between", value1, value2, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotBetween(String value1, String value2) {
            addCriterion("identification not between", value1, value2, "identification");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdIsNull() {
            addCriterion("advanced_age_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdIsNotNull() {
            addCriterion("advanced_age_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdEqualTo(Integer value) {
            addCriterion("advanced_age_plan_id =", value, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdNotEqualTo(Integer value) {
            addCriterion("advanced_age_plan_id <>", value, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdGreaterThan(Integer value) {
            addCriterion("advanced_age_plan_id >", value, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_plan_id >=", value, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdLessThan(Integer value) {
            addCriterion("advanced_age_plan_id <", value, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_plan_id <=", value, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdIn(List<Integer> values) {
            addCriterion("advanced_age_plan_id in", values, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdNotIn(List<Integer> values) {
            addCriterion("advanced_age_plan_id not in", values, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_plan_id between", value1, value2, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgePlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_plan_id not between", value1, value2, "advancedAgePlanId");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(String value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(String value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(String value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(String value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLike(String value) {
            addCriterion("employee_id like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotLike(String value) {
            addCriterion("employee_id not like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<String> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<String> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(String value1, String value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andApplyYearIsNull() {
            addCriterion("apply_year is null");
            return (Criteria) this;
        }

        public Criteria andApplyYearIsNotNull() {
            addCriterion("apply_year is not null");
            return (Criteria) this;
        }

        public Criteria andApplyYearEqualTo(String value) {
            addCriterion("apply_year =", value, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearNotEqualTo(String value) {
            addCriterion("apply_year <>", value, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearGreaterThan(String value) {
            addCriterion("apply_year >", value, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearGreaterThanOrEqualTo(String value) {
            addCriterion("apply_year >=", value, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearLessThan(String value) {
            addCriterion("apply_year <", value, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearLessThanOrEqualTo(String value) {
            addCriterion("apply_year <=", value, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearLike(String value) {
            addCriterion("apply_year like", value, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearNotLike(String value) {
            addCriterion("apply_year not like", value, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearIn(List<String> values) {
            addCriterion("apply_year in", values, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearNotIn(List<String> values) {
            addCriterion("apply_year not in", values, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearBetween(String value1, String value2) {
            addCriterion("apply_year between", value1, value2, "applyYear");
            return (Criteria) this;
        }

        public Criteria andApplyYearNotBetween(String value1, String value2) {
            addCriterion("apply_year not between", value1, value2, "applyYear");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongIsNull() {
            addCriterion("employed_among is null");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongIsNotNull() {
            addCriterion("employed_among is not null");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongEqualTo(Double value) {
            addCriterion("employed_among =", value, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongNotEqualTo(Double value) {
            addCriterion("employed_among <>", value, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongGreaterThan(Double value) {
            addCriterion("employed_among >", value, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongGreaterThanOrEqualTo(Double value) {
            addCriterion("employed_among >=", value, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongLessThan(Double value) {
            addCriterion("employed_among <", value, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongLessThanOrEqualTo(Double value) {
            addCriterion("employed_among <=", value, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongIn(List<Double> values) {
            addCriterion("employed_among in", values, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongNotIn(List<Double> values) {
            addCriterion("employed_among not in", values, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongBetween(Double value1, Double value2) {
            addCriterion("employed_among between", value1, value2, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedAmongNotBetween(Double value1, Double value2) {
            addCriterion("employed_among not between", value1, value2, "employedAmong");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusIsNull() {
            addCriterion("employed_expired_status is null");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusIsNotNull() {
            addCriterion("employed_expired_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusEqualTo(String value) {
            addCriterion("employed_expired_status =", value, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusNotEqualTo(String value) {
            addCriterion("employed_expired_status <>", value, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusGreaterThan(String value) {
            addCriterion("employed_expired_status >", value, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusGreaterThanOrEqualTo(String value) {
            addCriterion("employed_expired_status >=", value, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusLessThan(String value) {
            addCriterion("employed_expired_status <", value, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusLessThanOrEqualTo(String value) {
            addCriterion("employed_expired_status <=", value, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusLike(String value) {
            addCriterion("employed_expired_status like", value, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusNotLike(String value) {
            addCriterion("employed_expired_status not like", value, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusIn(List<String> values) {
            addCriterion("employed_expired_status in", values, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusNotIn(List<String> values) {
            addCriterion("employed_expired_status not in", values, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusBetween(String value1, String value2) {
            addCriterion("employed_expired_status between", value1, value2, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredStatusNotBetween(String value1, String value2) {
            addCriterion("employed_expired_status not between", value1, value2, "employedExpiredStatus");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignIsNull() {
            addCriterion("employed_expired_resign is null");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignIsNotNull() {
            addCriterion("employed_expired_resign is not null");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignEqualTo(Double value) {
            addCriterion("employed_expired_resign =", value, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignNotEqualTo(Double value) {
            addCriterion("employed_expired_resign <>", value, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignGreaterThan(Double value) {
            addCriterion("employed_expired_resign >", value, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignGreaterThanOrEqualTo(Double value) {
            addCriterion("employed_expired_resign >=", value, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignLessThan(Double value) {
            addCriterion("employed_expired_resign <", value, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignLessThanOrEqualTo(Double value) {
            addCriterion("employed_expired_resign <=", value, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignIn(List<Double> values) {
            addCriterion("employed_expired_resign in", values, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignNotIn(List<Double> values) {
            addCriterion("employed_expired_resign not in", values, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignBetween(Double value1, Double value2) {
            addCriterion("employed_expired_resign between", value1, value2, "employedExpiredResign");
            return (Criteria) this;
        }

        public Criteria andEmployedExpiredResignNotBetween(Double value1, Double value2) {
            addCriterion("employed_expired_resign not between", value1, value2, "employedExpiredResign");
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