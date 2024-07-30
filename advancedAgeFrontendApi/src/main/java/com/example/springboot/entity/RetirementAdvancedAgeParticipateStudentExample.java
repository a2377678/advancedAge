package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class RetirementAdvancedAgeParticipateStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RetirementAdvancedAgeParticipateStudentExample() {
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

        public Criteria andSeniorityIsNull() {
            addCriterion("seniority is null");
            return (Criteria) this;
        }

        public Criteria andSeniorityIsNotNull() {
            addCriterion("seniority is not null");
            return (Criteria) this;
        }

        public Criteria andSeniorityEqualTo(Integer value) {
            addCriterion("seniority =", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotEqualTo(Integer value) {
            addCriterion("seniority <>", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityGreaterThan(Integer value) {
            addCriterion("seniority >", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("seniority >=", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityLessThan(Integer value) {
            addCriterion("seniority <", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityLessThanOrEqualTo(Integer value) {
            addCriterion("seniority <=", value, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityIn(List<Integer> values) {
            addCriterion("seniority in", values, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotIn(List<Integer> values) {
            addCriterion("seniority not in", values, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityBetween(Integer value1, Integer value2) {
            addCriterion("seniority between", value1, value2, "seniority");
            return (Criteria) this;
        }

        public Criteria andSeniorityNotBetween(Integer value1, Integer value2) {
            addCriterion("seniority not between", value1, value2, "seniority");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdIsNull() {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdIsNotNull() {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id =", value, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdNotEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id <>", value, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdGreaterThan(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id >", value, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id >=", value, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdLessThan(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id <", value, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id <=", value, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdIn(List<Integer> values) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id in", values, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdNotIn(List<Integer> values) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id not in", values, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id between", value1, value2, "retirementAdvancedAgeExperienceInheritanceApplyId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("retirement_advanced_age_experience_inheritance_apply_id not between", value1, value2, "retirementAdvancedAgeExperienceInheritanceApplyId");
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

        public Criteria andLaborProtectionTimeIsNull() {
            addCriterion("labor_protection_time is null");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeIsNotNull() {
            addCriterion("labor_protection_time is not null");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeEqualTo(String value) {
            addCriterion("labor_protection_time =", value, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeNotEqualTo(String value) {
            addCriterion("labor_protection_time <>", value, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeGreaterThan(String value) {
            addCriterion("labor_protection_time >", value, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("labor_protection_time >=", value, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeLessThan(String value) {
            addCriterion("labor_protection_time <", value, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeLessThanOrEqualTo(String value) {
            addCriterion("labor_protection_time <=", value, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeLike(String value) {
            addCriterion("labor_protection_time like", value, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeNotLike(String value) {
            addCriterion("labor_protection_time not like", value, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeIn(List<String> values) {
            addCriterion("labor_protection_time in", values, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeNotIn(List<String> values) {
            addCriterion("labor_protection_time not in", values, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeBetween(String value1, String value2) {
            addCriterion("labor_protection_time between", value1, value2, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionTimeNotBetween(String value1, String value2) {
            addCriterion("labor_protection_time not between", value1, value2, "laborProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeIsNull() {
            addCriterion("occupational_accident_protection_time is null");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeIsNotNull() {
            addCriterion("occupational_accident_protection_time is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeEqualTo(String value) {
            addCriterion("occupational_accident_protection_time =", value, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeNotEqualTo(String value) {
            addCriterion("occupational_accident_protection_time <>", value, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeGreaterThan(String value) {
            addCriterion("occupational_accident_protection_time >", value, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("occupational_accident_protection_time >=", value, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeLessThan(String value) {
            addCriterion("occupational_accident_protection_time <", value, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeLessThanOrEqualTo(String value) {
            addCriterion("occupational_accident_protection_time <=", value, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeLike(String value) {
            addCriterion("occupational_accident_protection_time like", value, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeNotLike(String value) {
            addCriterion("occupational_accident_protection_time not like", value, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeIn(List<String> values) {
            addCriterion("occupational_accident_protection_time in", values, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeNotIn(List<String> values) {
            addCriterion("occupational_accident_protection_time not in", values, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeBetween(String value1, String value2) {
            addCriterion("occupational_accident_protection_time between", value1, value2, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionTimeNotBetween(String value1, String value2) {
            addCriterion("occupational_accident_protection_time not between", value1, value2, "occupationalAccidentProtectionTime");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursIsNull() {
            addCriterion("working_hours is null");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursIsNotNull() {
            addCriterion("working_hours is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursEqualTo(String value) {
            addCriterion("working_hours =", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursNotEqualTo(String value) {
            addCriterion("working_hours <>", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursGreaterThan(String value) {
            addCriterion("working_hours >", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursGreaterThanOrEqualTo(String value) {
            addCriterion("working_hours >=", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursLessThan(String value) {
            addCriterion("working_hours <", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursLessThanOrEqualTo(String value) {
            addCriterion("working_hours <=", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursLike(String value) {
            addCriterion("working_hours like", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursNotLike(String value) {
            addCriterion("working_hours not like", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursIn(List<String> values) {
            addCriterion("working_hours in", values, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursNotIn(List<String> values) {
            addCriterion("working_hours not in", values, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursBetween(String value1, String value2) {
            addCriterion("working_hours between", value1, value2, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursNotBetween(String value1, String value2) {
            addCriterion("working_hours not between", value1, value2, "workingHours");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthIsNull() {
            addCriterion("seniority_month is null");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthIsNotNull() {
            addCriterion("seniority_month is not null");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthEqualTo(Integer value) {
            addCriterion("seniority_month =", value, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthNotEqualTo(Integer value) {
            addCriterion("seniority_month <>", value, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthGreaterThan(Integer value) {
            addCriterion("seniority_month >", value, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("seniority_month >=", value, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthLessThan(Integer value) {
            addCriterion("seniority_month <", value, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthLessThanOrEqualTo(Integer value) {
            addCriterion("seniority_month <=", value, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthIn(List<Integer> values) {
            addCriterion("seniority_month in", values, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthNotIn(List<Integer> values) {
            addCriterion("seniority_month not in", values, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthBetween(Integer value1, Integer value2) {
            addCriterion("seniority_month between", value1, value2, "seniorityMonth");
            return (Criteria) this;
        }

        public Criteria andSeniorityMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("seniority_month not between", value1, value2, "seniorityMonth");
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