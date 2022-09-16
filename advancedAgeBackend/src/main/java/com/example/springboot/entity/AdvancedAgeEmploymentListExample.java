package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class AdvancedAgeEmploymentListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvancedAgeEmploymentListExample() {
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

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
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

        public Criteria andRelativesIsNull() {
            addCriterion("relatives is null");
            return (Criteria) this;
        }

        public Criteria andRelativesIsNotNull() {
            addCriterion("relatives is not null");
            return (Criteria) this;
        }

        public Criteria andRelativesEqualTo(String value) {
            addCriterion("relatives =", value, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesNotEqualTo(String value) {
            addCriterion("relatives <>", value, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesGreaterThan(String value) {
            addCriterion("relatives >", value, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesGreaterThanOrEqualTo(String value) {
            addCriterion("relatives >=", value, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesLessThan(String value) {
            addCriterion("relatives <", value, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesLessThanOrEqualTo(String value) {
            addCriterion("relatives <=", value, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesLike(String value) {
            addCriterion("relatives like", value, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesNotLike(String value) {
            addCriterion("relatives not like", value, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesIn(List<String> values) {
            addCriterion("relatives in", values, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesNotIn(List<String> values) {
            addCriterion("relatives not in", values, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesBetween(String value1, String value2) {
            addCriterion("relatives between", value1, value2, "relatives");
            return (Criteria) this;
        }

        public Criteria andRelativesNotBetween(String value1, String value2) {
            addCriterion("relatives not between", value1, value2, "relatives");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryIsNull() {
            addCriterion("average_salary is null");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryIsNotNull() {
            addCriterion("average_salary is not null");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryEqualTo(Integer value) {
            addCriterion("average_salary =", value, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryNotEqualTo(Integer value) {
            addCriterion("average_salary <>", value, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryGreaterThan(Integer value) {
            addCriterion("average_salary >", value, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("average_salary >=", value, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryLessThan(Integer value) {
            addCriterion("average_salary <", value, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("average_salary <=", value, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryIn(List<Integer> values) {
            addCriterion("average_salary in", values, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryNotIn(List<Integer> values) {
            addCriterion("average_salary not in", values, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryBetween(Integer value1, Integer value2) {
            addCriterion("average_salary between", value1, value2, "averageSalary");
            return (Criteria) this;
        }

        public Criteria andAverageSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("average_salary not between", value1, value2, "averageSalary");
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

        public Criteria andRecurringSalaryIsNull() {
            addCriterion("recurring_salary is null");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryIsNotNull() {
            addCriterion("recurring_salary is not null");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryEqualTo(Integer value) {
            addCriterion("recurring_salary =", value, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryNotEqualTo(Integer value) {
            addCriterion("recurring_salary <>", value, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryGreaterThan(Integer value) {
            addCriterion("recurring_salary >", value, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("recurring_salary >=", value, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryLessThan(Integer value) {
            addCriterion("recurring_salary <", value, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("recurring_salary <=", value, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryIn(List<Integer> values) {
            addCriterion("recurring_salary in", values, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryNotIn(List<Integer> values) {
            addCriterion("recurring_salary not in", values, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryBetween(Integer value1, Integer value2) {
            addCriterion("recurring_salary between", value1, value2, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andRecurringSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("recurring_salary not between", value1, value2, "recurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryIsNull() {
            addCriterion("not_recurring_salary is null");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryIsNotNull() {
            addCriterion("not_recurring_salary is not null");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryEqualTo(Integer value) {
            addCriterion("not_recurring_salary =", value, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryNotEqualTo(Integer value) {
            addCriterion("not_recurring_salary <>", value, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryGreaterThan(Integer value) {
            addCriterion("not_recurring_salary >", value, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("not_recurring_salary >=", value, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryLessThan(Integer value) {
            addCriterion("not_recurring_salary <", value, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("not_recurring_salary <=", value, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryIn(List<Integer> values) {
            addCriterion("not_recurring_salary in", values, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryNotIn(List<Integer> values) {
            addCriterion("not_recurring_salary not in", values, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryBetween(Integer value1, Integer value2) {
            addCriterion("not_recurring_salary between", value1, value2, "notRecurringSalary");
            return (Criteria) this;
        }

        public Criteria andNotRecurringSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("not_recurring_salary not between", value1, value2, "notRecurringSalary");
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