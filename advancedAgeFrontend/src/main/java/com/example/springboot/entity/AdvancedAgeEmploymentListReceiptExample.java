package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvancedAgeEmploymentListReceiptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvancedAgeEmploymentListReceiptExample() {
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

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(String value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(String value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(String value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(String value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(String value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(String value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLike(String value) {
            addCriterion("seq like", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotLike(String value) {
            addCriterion("seq not like", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<String> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<String> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(String value1, String value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(String value1, String value2) {
            addCriterion("seq not between", value1, value2, "seq");
            return (Criteria) this;
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

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Integer value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Integer value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Integer value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Integer value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Integer> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Integer> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdIsNull() {
            addCriterion("advanced_age_base_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdIsNotNull() {
            addCriterion("advanced_age_base_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdEqualTo(Integer value) {
            addCriterion("advanced_age_base_id =", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdNotEqualTo(Integer value) {
            addCriterion("advanced_age_base_id <>", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdGreaterThan(Integer value) {
            addCriterion("advanced_age_base_id >", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_base_id >=", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdLessThan(Integer value) {
            addCriterion("advanced_age_base_id <", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_base_id <=", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdIn(List<Integer> values) {
            addCriterion("advanced_age_base_id in", values, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdNotIn(List<Integer> values) {
            addCriterion("advanced_age_base_id not in", values, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_base_id between", value1, value2, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_base_id not between", value1, value2, "advancedAgeBaseId");
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("principal like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("principal not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("principal not between", value1, value2, "principal");
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

        public Criteria andLaborProtectionExpiredTimeIsNull() {
            addCriterion("labor_protection_expired_time is null");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeIsNotNull() {
            addCriterion("labor_protection_expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeEqualTo(String value) {
            addCriterion("labor_protection_expired_time =", value, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeNotEqualTo(String value) {
            addCriterion("labor_protection_expired_time <>", value, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeGreaterThan(String value) {
            addCriterion("labor_protection_expired_time >", value, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeGreaterThanOrEqualTo(String value) {
            addCriterion("labor_protection_expired_time >=", value, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeLessThan(String value) {
            addCriterion("labor_protection_expired_time <", value, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeLessThanOrEqualTo(String value) {
            addCriterion("labor_protection_expired_time <=", value, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeLike(String value) {
            addCriterion("labor_protection_expired_time like", value, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeNotLike(String value) {
            addCriterion("labor_protection_expired_time not like", value, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeIn(List<String> values) {
            addCriterion("labor_protection_expired_time in", values, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeNotIn(List<String> values) {
            addCriterion("labor_protection_expired_time not in", values, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeBetween(String value1, String value2) {
            addCriterion("labor_protection_expired_time between", value1, value2, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andLaborProtectionExpiredTimeNotBetween(String value1, String value2) {
            addCriterion("labor_protection_expired_time not between", value1, value2, "laborProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeIsNull() {
            addCriterion("occupational_accident_protection_expired_time is null");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeIsNotNull() {
            addCriterion("occupational_accident_protection_expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeEqualTo(String value) {
            addCriterion("occupational_accident_protection_expired_time =", value, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeNotEqualTo(String value) {
            addCriterion("occupational_accident_protection_expired_time <>", value, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeGreaterThan(String value) {
            addCriterion("occupational_accident_protection_expired_time >", value, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeGreaterThanOrEqualTo(String value) {
            addCriterion("occupational_accident_protection_expired_time >=", value, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeLessThan(String value) {
            addCriterion("occupational_accident_protection_expired_time <", value, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeLessThanOrEqualTo(String value) {
            addCriterion("occupational_accident_protection_expired_time <=", value, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeLike(String value) {
            addCriterion("occupational_accident_protection_expired_time like", value, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeNotLike(String value) {
            addCriterion("occupational_accident_protection_expired_time not like", value, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeIn(List<String> values) {
            addCriterion("occupational_accident_protection_expired_time in", values, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeNotIn(List<String> values) {
            addCriterion("occupational_accident_protection_expired_time not in", values, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeBetween(String value1, String value2) {
            addCriterion("occupational_accident_protection_expired_time between", value1, value2, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andOccupationalAccidentProtectionExpiredTimeNotBetween(String value1, String value2) {
            addCriterion("occupational_accident_protection_expired_time not between", value1, value2, "occupationalAccidentProtectionExpiredTime");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(Integer value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(Integer value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(Integer value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(Integer value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<Integer> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<Integer> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(Integer value1, Integer value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodIsNull() {
            addCriterion("salary_method is null");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodIsNotNull() {
            addCriterion("salary_method is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodEqualTo(String value) {
            addCriterion("salary_method =", value, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodNotEqualTo(String value) {
            addCriterion("salary_method <>", value, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodGreaterThan(String value) {
            addCriterion("salary_method >", value, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodGreaterThanOrEqualTo(String value) {
            addCriterion("salary_method >=", value, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodLessThan(String value) {
            addCriterion("salary_method <", value, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodLessThanOrEqualTo(String value) {
            addCriterion("salary_method <=", value, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodLike(String value) {
            addCriterion("salary_method like", value, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodNotLike(String value) {
            addCriterion("salary_method not like", value, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodIn(List<String> values) {
            addCriterion("salary_method in", values, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodNotIn(List<String> values) {
            addCriterion("salary_method not in", values, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodBetween(String value1, String value2) {
            addCriterion("salary_method between", value1, value2, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodNotBetween(String value1, String value2) {
            addCriterion("salary_method not between", value1, value2, "salaryMethod");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkIsNull() {
            addCriterion("salary_method_remark is null");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkIsNotNull() {
            addCriterion("salary_method_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkEqualTo(String value) {
            addCriterion("salary_method_remark =", value, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkNotEqualTo(String value) {
            addCriterion("salary_method_remark <>", value, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkGreaterThan(String value) {
            addCriterion("salary_method_remark >", value, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("salary_method_remark >=", value, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkLessThan(String value) {
            addCriterion("salary_method_remark <", value, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkLessThanOrEqualTo(String value) {
            addCriterion("salary_method_remark <=", value, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkLike(String value) {
            addCriterion("salary_method_remark like", value, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkNotLike(String value) {
            addCriterion("salary_method_remark not like", value, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkIn(List<String> values) {
            addCriterion("salary_method_remark in", values, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkNotIn(List<String> values) {
            addCriterion("salary_method_remark not in", values, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkBetween(String value1, String value2) {
            addCriterion("salary_method_remark between", value1, value2, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andSalaryMethodRemarkNotBetween(String value1, String value2) {
            addCriterion("salary_method_remark not between", value1, value2, "salaryMethodRemark");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeIsNull() {
            addCriterion("employment_month_start_time is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeIsNotNull() {
            addCriterion("employment_month_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeEqualTo(String value) {
            addCriterion("employment_month_start_time =", value, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeNotEqualTo(String value) {
            addCriterion("employment_month_start_time <>", value, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeGreaterThan(String value) {
            addCriterion("employment_month_start_time >", value, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("employment_month_start_time >=", value, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeLessThan(String value) {
            addCriterion("employment_month_start_time <", value, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeLessThanOrEqualTo(String value) {
            addCriterion("employment_month_start_time <=", value, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeLike(String value) {
            addCriterion("employment_month_start_time like", value, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeNotLike(String value) {
            addCriterion("employment_month_start_time not like", value, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeIn(List<String> values) {
            addCriterion("employment_month_start_time in", values, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeNotIn(List<String> values) {
            addCriterion("employment_month_start_time not in", values, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeBetween(String value1, String value2) {
            addCriterion("employment_month_start_time between", value1, value2, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthStartTimeNotBetween(String value1, String value2) {
            addCriterion("employment_month_start_time not between", value1, value2, "employmentMonthStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeIsNull() {
            addCriterion("employment_month_end_time is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeIsNotNull() {
            addCriterion("employment_month_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeEqualTo(String value) {
            addCriterion("employment_month_end_time =", value, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeNotEqualTo(String value) {
            addCriterion("employment_month_end_time <>", value, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeGreaterThan(String value) {
            addCriterion("employment_month_end_time >", value, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("employment_month_end_time >=", value, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeLessThan(String value) {
            addCriterion("employment_month_end_time <", value, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeLessThanOrEqualTo(String value) {
            addCriterion("employment_month_end_time <=", value, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeLike(String value) {
            addCriterion("employment_month_end_time like", value, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeNotLike(String value) {
            addCriterion("employment_month_end_time not like", value, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeIn(List<String> values) {
            addCriterion("employment_month_end_time in", values, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeNotIn(List<String> values) {
            addCriterion("employment_month_end_time not in", values, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeBetween(String value1, String value2) {
            addCriterion("employment_month_end_time between", value1, value2, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentMonthEndTimeNotBetween(String value1, String value2) {
            addCriterion("employment_month_end_time not between", value1, value2, "employmentMonthEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeIsNull() {
            addCriterion("employment_hour_start_time is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeIsNotNull() {
            addCriterion("employment_hour_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeEqualTo(String value) {
            addCriterion("employment_hour_start_time =", value, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeNotEqualTo(String value) {
            addCriterion("employment_hour_start_time <>", value, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeGreaterThan(String value) {
            addCriterion("employment_hour_start_time >", value, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("employment_hour_start_time >=", value, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeLessThan(String value) {
            addCriterion("employment_hour_start_time <", value, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeLessThanOrEqualTo(String value) {
            addCriterion("employment_hour_start_time <=", value, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeLike(String value) {
            addCriterion("employment_hour_start_time like", value, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeNotLike(String value) {
            addCriterion("employment_hour_start_time not like", value, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeIn(List<String> values) {
            addCriterion("employment_hour_start_time in", values, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeNotIn(List<String> values) {
            addCriterion("employment_hour_start_time not in", values, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeBetween(String value1, String value2) {
            addCriterion("employment_hour_start_time between", value1, value2, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourStartTimeNotBetween(String value1, String value2) {
            addCriterion("employment_hour_start_time not between", value1, value2, "employmentHourStartTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeIsNull() {
            addCriterion("employment_hour_end_time is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeIsNotNull() {
            addCriterion("employment_hour_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeEqualTo(String value) {
            addCriterion("employment_hour_end_time =", value, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeNotEqualTo(String value) {
            addCriterion("employment_hour_end_time <>", value, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeGreaterThan(String value) {
            addCriterion("employment_hour_end_time >", value, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("employment_hour_end_time >=", value, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeLessThan(String value) {
            addCriterion("employment_hour_end_time <", value, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeLessThanOrEqualTo(String value) {
            addCriterion("employment_hour_end_time <=", value, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeLike(String value) {
            addCriterion("employment_hour_end_time like", value, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeNotLike(String value) {
            addCriterion("employment_hour_end_time not like", value, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeIn(List<String> values) {
            addCriterion("employment_hour_end_time in", values, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeNotIn(List<String> values) {
            addCriterion("employment_hour_end_time not in", values, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeBetween(String value1, String value2) {
            addCriterion("employment_hour_end_time between", value1, value2, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andEmploymentHourEndTimeNotBetween(String value1, String value2) {
            addCriterion("employment_hour_end_time not between", value1, value2, "employmentHourEndTime");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberIsNull() {
            addCriterion("low_month_number is null");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberIsNotNull() {
            addCriterion("low_month_number is not null");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberEqualTo(Integer value) {
            addCriterion("low_month_number =", value, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberNotEqualTo(Integer value) {
            addCriterion("low_month_number <>", value, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberGreaterThan(Integer value) {
            addCriterion("low_month_number >", value, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_month_number >=", value, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberLessThan(Integer value) {
            addCriterion("low_month_number <", value, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberLessThanOrEqualTo(Integer value) {
            addCriterion("low_month_number <=", value, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberIn(List<Integer> values) {
            addCriterion("low_month_number in", values, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberNotIn(List<Integer> values) {
            addCriterion("low_month_number not in", values, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberBetween(Integer value1, Integer value2) {
            addCriterion("low_month_number between", value1, value2, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowMonthNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("low_month_number not between", value1, value2, "lowMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberIsNull() {
            addCriterion("high_month_number is null");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberIsNotNull() {
            addCriterion("high_month_number is not null");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberEqualTo(Integer value) {
            addCriterion("high_month_number =", value, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberNotEqualTo(Integer value) {
            addCriterion("high_month_number <>", value, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberGreaterThan(Integer value) {
            addCriterion("high_month_number >", value, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_month_number >=", value, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberLessThan(Integer value) {
            addCriterion("high_month_number <", value, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberLessThanOrEqualTo(Integer value) {
            addCriterion("high_month_number <=", value, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberIn(List<Integer> values) {
            addCriterion("high_month_number in", values, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberNotIn(List<Integer> values) {
            addCriterion("high_month_number not in", values, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberBetween(Integer value1, Integer value2) {
            addCriterion("high_month_number between", value1, value2, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andHighMonthNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("high_month_number not between", value1, value2, "highMonthNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberIsNull() {
            addCriterion("low_hours_number is null");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberIsNotNull() {
            addCriterion("low_hours_number is not null");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberEqualTo(Integer value) {
            addCriterion("low_hours_number =", value, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberNotEqualTo(Integer value) {
            addCriterion("low_hours_number <>", value, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberGreaterThan(Integer value) {
            addCriterion("low_hours_number >", value, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_hours_number >=", value, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberLessThan(Integer value) {
            addCriterion("low_hours_number <", value, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberLessThanOrEqualTo(Integer value) {
            addCriterion("low_hours_number <=", value, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberIn(List<Integer> values) {
            addCriterion("low_hours_number in", values, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberNotIn(List<Integer> values) {
            addCriterion("low_hours_number not in", values, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberBetween(Integer value1, Integer value2) {
            addCriterion("low_hours_number between", value1, value2, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andLowHoursNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("low_hours_number not between", value1, value2, "lowHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberIsNull() {
            addCriterion("high_hours_number is null");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberIsNotNull() {
            addCriterion("high_hours_number is not null");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberEqualTo(Integer value) {
            addCriterion("high_hours_number =", value, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberNotEqualTo(Integer value) {
            addCriterion("high_hours_number <>", value, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberGreaterThan(Integer value) {
            addCriterion("high_hours_number >", value, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_hours_number >=", value, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberLessThan(Integer value) {
            addCriterion("high_hours_number <", value, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberLessThanOrEqualTo(Integer value) {
            addCriterion("high_hours_number <=", value, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberIn(List<Integer> values) {
            addCriterion("high_hours_number in", values, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberNotIn(List<Integer> values) {
            addCriterion("high_hours_number not in", values, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberBetween(Integer value1, Integer value2) {
            addCriterion("high_hours_number between", value1, value2, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andHighHoursNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("high_hours_number not between", value1, value2, "highHoursNumber");
            return (Criteria) this;
        }

        public Criteria andAmountsIsNull() {
            addCriterion("amounts is null");
            return (Criteria) this;
        }

        public Criteria andAmountsIsNotNull() {
            addCriterion("amounts is not null");
            return (Criteria) this;
        }

        public Criteria andAmountsEqualTo(Integer value) {
            addCriterion("amounts =", value, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsNotEqualTo(Integer value) {
            addCriterion("amounts <>", value, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsGreaterThan(Integer value) {
            addCriterion("amounts >", value, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("amounts >=", value, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsLessThan(Integer value) {
            addCriterion("amounts <", value, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("amounts <=", value, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsIn(List<Integer> values) {
            addCriterion("amounts in", values, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsNotIn(List<Integer> values) {
            addCriterion("amounts not in", values, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsBetween(Integer value1, Integer value2) {
            addCriterion("amounts between", value1, value2, "amounts");
            return (Criteria) this;
        }

        public Criteria andAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("amounts not between", value1, value2, "amounts");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNull() {
            addCriterion("approve_status is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNotNull() {
            addCriterion("approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusEqualTo(String value) {
            addCriterion("approve_status =", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotEqualTo(String value) {
            addCriterion("approve_status <>", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThan(String value) {
            addCriterion("approve_status >", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("approve_status >=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThan(String value) {
            addCriterion("approve_status <", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThanOrEqualTo(String value) {
            addCriterion("approve_status <=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLike(String value) {
            addCriterion("approve_status like", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotLike(String value) {
            addCriterion("approve_status not like", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIn(List<String> values) {
            addCriterion("approve_status in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotIn(List<String> values) {
            addCriterion("approve_status not in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusBetween(String value1, String value2) {
            addCriterion("approve_status between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotBetween(String value1, String value2) {
            addCriterion("approve_status not between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsIsNull() {
            addCriterion("adjust_amounts is null");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsIsNotNull() {
            addCriterion("adjust_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsEqualTo(Integer value) {
            addCriterion("adjust_amounts =", value, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsNotEqualTo(Integer value) {
            addCriterion("adjust_amounts <>", value, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsGreaterThan(Integer value) {
            addCriterion("adjust_amounts >", value, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("adjust_amounts >=", value, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsLessThan(Integer value) {
            addCriterion("adjust_amounts <", value, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("adjust_amounts <=", value, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsIn(List<Integer> values) {
            addCriterion("adjust_amounts in", values, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsNotIn(List<Integer> values) {
            addCriterion("adjust_amounts not in", values, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsBetween(Integer value1, Integer value2) {
            addCriterion("adjust_amounts between", value1, value2, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andAdjustAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("adjust_amounts not between", value1, value2, "adjustAmounts");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyIsNull() {
            addCriterion("base_allowance_frequency is null");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyIsNotNull() {
            addCriterion("base_allowance_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyEqualTo(Integer value) {
            addCriterion("base_allowance_frequency =", value, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyNotEqualTo(Integer value) {
            addCriterion("base_allowance_frequency <>", value, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyGreaterThan(Integer value) {
            addCriterion("base_allowance_frequency >", value, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_allowance_frequency >=", value, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyLessThan(Integer value) {
            addCriterion("base_allowance_frequency <", value, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("base_allowance_frequency <=", value, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyIn(List<Integer> values) {
            addCriterion("base_allowance_frequency in", values, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyNotIn(List<Integer> values) {
            addCriterion("base_allowance_frequency not in", values, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("base_allowance_frequency between", value1, value2, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andBaseAllowanceFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("base_allowance_frequency not between", value1, value2, "baseAllowanceFrequency");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonIsNull() {
            addCriterion("verify_person is null");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonIsNotNull() {
            addCriterion("verify_person is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonEqualTo(String value) {
            addCriterion("verify_person =", value, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonNotEqualTo(String value) {
            addCriterion("verify_person <>", value, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonGreaterThan(String value) {
            addCriterion("verify_person >", value, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("verify_person >=", value, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonLessThan(String value) {
            addCriterion("verify_person <", value, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonLessThanOrEqualTo(String value) {
            addCriterion("verify_person <=", value, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonLike(String value) {
            addCriterion("verify_person like", value, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonNotLike(String value) {
            addCriterion("verify_person not like", value, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonIn(List<String> values) {
            addCriterion("verify_person in", values, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonNotIn(List<String> values) {
            addCriterion("verify_person not in", values, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonBetween(String value1, String value2) {
            addCriterion("verify_person between", value1, value2, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andVerifyPersonNotBetween(String value1, String value2) {
            addCriterion("verify_person not between", value1, value2, "verifyPerson");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerIsNull() {
            addCriterion("business_manager is null");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerIsNotNull() {
            addCriterion("business_manager is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerEqualTo(String value) {
            addCriterion("business_manager =", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerNotEqualTo(String value) {
            addCriterion("business_manager <>", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerGreaterThan(String value) {
            addCriterion("business_manager >", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerGreaterThanOrEqualTo(String value) {
            addCriterion("business_manager >=", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerLessThan(String value) {
            addCriterion("business_manager <", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerLessThanOrEqualTo(String value) {
            addCriterion("business_manager <=", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerLike(String value) {
            addCriterion("business_manager like", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerNotLike(String value) {
            addCriterion("business_manager not like", value, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerIn(List<String> values) {
            addCriterion("business_manager in", values, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerNotIn(List<String> values) {
            addCriterion("business_manager not in", values, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerBetween(String value1, String value2) {
            addCriterion("business_manager between", value1, value2, "businessManager");
            return (Criteria) this;
        }

        public Criteria andBusinessManagerNotBetween(String value1, String value2) {
            addCriterion("business_manager not between", value1, value2, "businessManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerIsNull() {
            addCriterion("head_manager is null");
            return (Criteria) this;
        }

        public Criteria andHeadManagerIsNotNull() {
            addCriterion("head_manager is not null");
            return (Criteria) this;
        }

        public Criteria andHeadManagerEqualTo(String value) {
            addCriterion("head_manager =", value, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerNotEqualTo(String value) {
            addCriterion("head_manager <>", value, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerGreaterThan(String value) {
            addCriterion("head_manager >", value, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerGreaterThanOrEqualTo(String value) {
            addCriterion("head_manager >=", value, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerLessThan(String value) {
            addCriterion("head_manager <", value, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerLessThanOrEqualTo(String value) {
            addCriterion("head_manager <=", value, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerLike(String value) {
            addCriterion("head_manager like", value, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerNotLike(String value) {
            addCriterion("head_manager not like", value, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerIn(List<String> values) {
            addCriterion("head_manager in", values, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerNotIn(List<String> values) {
            addCriterion("head_manager not in", values, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerBetween(String value1, String value2) {
            addCriterion("head_manager between", value1, value2, "headManager");
            return (Criteria) this;
        }

        public Criteria andHeadManagerNotBetween(String value1, String value2) {
            addCriterion("head_manager not between", value1, value2, "headManager");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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