package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class EexperienceInheritanceSpeakerSituationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EexperienceInheritanceSpeakerSituationExample() {
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

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdIsNull() {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdIsNotNull() {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id =", value, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdNotEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id <>", value, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdGreaterThan(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id >", value, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id >=", value, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdLessThan(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id <", value, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id <=", value, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdIn(List<Integer> values) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id in", values, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdNotIn(List<Integer> values) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id not in", values, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdBetween(Integer value1, Integer value2) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id between", value1, value2, "retirementAdvancedAgeExperienceInheritancePlanId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritancePlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("retirement_advanced_age_experience_inheritance_plan_id not between", value1, value2, "retirementAdvancedAgeExperienceInheritancePlanId");
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

        public Criteria andSituationIsNull() {
            addCriterion("situation is null");
            return (Criteria) this;
        }

        public Criteria andSituationIsNotNull() {
            addCriterion("situation is not null");
            return (Criteria) this;
        }

        public Criteria andSituationEqualTo(String value) {
            addCriterion("situation =", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotEqualTo(String value) {
            addCriterion("situation <>", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationGreaterThan(String value) {
            addCriterion("situation >", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationGreaterThanOrEqualTo(String value) {
            addCriterion("situation >=", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLessThan(String value) {
            addCriterion("situation <", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLessThanOrEqualTo(String value) {
            addCriterion("situation <=", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLike(String value) {
            addCriterion("situation like", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotLike(String value) {
            addCriterion("situation not like", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationIn(List<String> values) {
            addCriterion("situation in", values, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotIn(List<String> values) {
            addCriterion("situation not in", values, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationBetween(String value1, String value2) {
            addCriterion("situation between", value1, value2, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotBetween(String value1, String value2) {
            addCriterion("situation not between", value1, value2, "situation");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthIsNull() {
            addCriterion("execution_month is null");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthIsNotNull() {
            addCriterion("execution_month is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthEqualTo(Double value) {
            addCriterion("execution_month =", value, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthNotEqualTo(Double value) {
            addCriterion("execution_month <>", value, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthGreaterThan(Double value) {
            addCriterion("execution_month >", value, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthGreaterThanOrEqualTo(Double value) {
            addCriterion("execution_month >=", value, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthLessThan(Double value) {
            addCriterion("execution_month <", value, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthLessThanOrEqualTo(Double value) {
            addCriterion("execution_month <=", value, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthIn(List<Double> values) {
            addCriterion("execution_month in", values, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthNotIn(List<Double> values) {
            addCriterion("execution_month not in", values, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthBetween(Double value1, Double value2) {
            addCriterion("execution_month between", value1, value2, "executionMonth");
            return (Criteria) this;
        }

        public Criteria andExecutionMonthNotBetween(Double value1, Double value2) {
            addCriterion("execution_month not between", value1, value2, "executionMonth");
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