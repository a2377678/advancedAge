package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvancedAgeRetirementReemploymentApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvancedAgeRetirementReemploymentApplyExample() {
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

        public Criteria andAssistanceMeasures1IsNull() {
            addCriterion("assistance_measures_1 is null");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1IsNotNull() {
            addCriterion("assistance_measures_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1EqualTo(String value) {
            addCriterion("assistance_measures_1 =", value, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1NotEqualTo(String value) {
            addCriterion("assistance_measures_1 <>", value, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1GreaterThan(String value) {
            addCriterion("assistance_measures_1 >", value, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1GreaterThanOrEqualTo(String value) {
            addCriterion("assistance_measures_1 >=", value, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1LessThan(String value) {
            addCriterion("assistance_measures_1 <", value, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1LessThanOrEqualTo(String value) {
            addCriterion("assistance_measures_1 <=", value, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1Like(String value) {
            addCriterion("assistance_measures_1 like", value, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1NotLike(String value) {
            addCriterion("assistance_measures_1 not like", value, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1In(List<String> values) {
            addCriterion("assistance_measures_1 in", values, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1NotIn(List<String> values) {
            addCriterion("assistance_measures_1 not in", values, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1Between(String value1, String value2) {
            addCriterion("assistance_measures_1 between", value1, value2, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures1NotBetween(String value1, String value2) {
            addCriterion("assistance_measures_1 not between", value1, value2, "assistanceMeasures1");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2IsNull() {
            addCriterion("assistance_measures_2 is null");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2IsNotNull() {
            addCriterion("assistance_measures_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2EqualTo(String value) {
            addCriterion("assistance_measures_2 =", value, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2NotEqualTo(String value) {
            addCriterion("assistance_measures_2 <>", value, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2GreaterThan(String value) {
            addCriterion("assistance_measures_2 >", value, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2GreaterThanOrEqualTo(String value) {
            addCriterion("assistance_measures_2 >=", value, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2LessThan(String value) {
            addCriterion("assistance_measures_2 <", value, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2LessThanOrEqualTo(String value) {
            addCriterion("assistance_measures_2 <=", value, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2Like(String value) {
            addCriterion("assistance_measures_2 like", value, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2NotLike(String value) {
            addCriterion("assistance_measures_2 not like", value, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2In(List<String> values) {
            addCriterion("assistance_measures_2 in", values, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2NotIn(List<String> values) {
            addCriterion("assistance_measures_2 not in", values, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2Between(String value1, String value2) {
            addCriterion("assistance_measures_2 between", value1, value2, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures2NotBetween(String value1, String value2) {
            addCriterion("assistance_measures_2 not between", value1, value2, "assistanceMeasures2");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3IsNull() {
            addCriterion("assistance_measures_3 is null");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3IsNotNull() {
            addCriterion("assistance_measures_3 is not null");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3EqualTo(String value) {
            addCriterion("assistance_measures_3 =", value, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3NotEqualTo(String value) {
            addCriterion("assistance_measures_3 <>", value, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3GreaterThan(String value) {
            addCriterion("assistance_measures_3 >", value, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3GreaterThanOrEqualTo(String value) {
            addCriterion("assistance_measures_3 >=", value, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3LessThan(String value) {
            addCriterion("assistance_measures_3 <", value, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3LessThanOrEqualTo(String value) {
            addCriterion("assistance_measures_3 <=", value, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3Like(String value) {
            addCriterion("assistance_measures_3 like", value, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3NotLike(String value) {
            addCriterion("assistance_measures_3 not like", value, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3In(List<String> values) {
            addCriterion("assistance_measures_3 in", values, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3NotIn(List<String> values) {
            addCriterion("assistance_measures_3 not in", values, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3Between(String value1, String value2) {
            addCriterion("assistance_measures_3 between", value1, value2, "assistanceMeasures3");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasures3NotBetween(String value1, String value2) {
            addCriterion("assistance_measures_3 not between", value1, value2, "assistanceMeasures3");
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

        public Criteria andGuaranteeNumberIsNull() {
            addCriterion("guarantee_number is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberIsNotNull() {
            addCriterion("guarantee_number is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberEqualTo(String value) {
            addCriterion("guarantee_number =", value, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberNotEqualTo(String value) {
            addCriterion("guarantee_number <>", value, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberGreaterThan(String value) {
            addCriterion("guarantee_number >", value, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_number >=", value, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberLessThan(String value) {
            addCriterion("guarantee_number <", value, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberLessThanOrEqualTo(String value) {
            addCriterion("guarantee_number <=", value, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberLike(String value) {
            addCriterion("guarantee_number like", value, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberNotLike(String value) {
            addCriterion("guarantee_number not like", value, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberIn(List<String> values) {
            addCriterion("guarantee_number in", values, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberNotIn(List<String> values) {
            addCriterion("guarantee_number not in", values, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberBetween(String value1, String value2) {
            addCriterion("guarantee_number between", value1, value2, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andGuaranteeNumberNotBetween(String value1, String value2) {
            addCriterion("guarantee_number not between", value1, value2, "guaranteeNumber");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeIsNull() {
            addCriterion("register_postal_code is null");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeIsNotNull() {
            addCriterion("register_postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeEqualTo(String value) {
            addCriterion("register_postal_code =", value, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeNotEqualTo(String value) {
            addCriterion("register_postal_code <>", value, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeGreaterThan(String value) {
            addCriterion("register_postal_code >", value, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("register_postal_code >=", value, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeLessThan(String value) {
            addCriterion("register_postal_code <", value, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("register_postal_code <=", value, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeLike(String value) {
            addCriterion("register_postal_code like", value, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeNotLike(String value) {
            addCriterion("register_postal_code not like", value, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeIn(List<String> values) {
            addCriterion("register_postal_code in", values, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeNotIn(List<String> values) {
            addCriterion("register_postal_code not in", values, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeBetween(String value1, String value2) {
            addCriterion("register_postal_code between", value1, value2, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterPostalCodeNotBetween(String value1, String value2) {
            addCriterion("register_postal_code not between", value1, value2, "registerPostalCode");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIsNull() {
            addCriterion("register_city is null");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIsNotNull() {
            addCriterion("register_city is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterCityEqualTo(String value) {
            addCriterion("register_city =", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotEqualTo(String value) {
            addCriterion("register_city <>", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityGreaterThan(String value) {
            addCriterion("register_city >", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityGreaterThanOrEqualTo(String value) {
            addCriterion("register_city >=", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLessThan(String value) {
            addCriterion("register_city <", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLessThanOrEqualTo(String value) {
            addCriterion("register_city <=", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLike(String value) {
            addCriterion("register_city like", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotLike(String value) {
            addCriterion("register_city not like", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIn(List<String> values) {
            addCriterion("register_city in", values, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotIn(List<String> values) {
            addCriterion("register_city not in", values, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityBetween(String value1, String value2) {
            addCriterion("register_city between", value1, value2, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotBetween(String value1, String value2) {
            addCriterion("register_city not between", value1, value2, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaIsNull() {
            addCriterion("register_area is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaIsNotNull() {
            addCriterion("register_area is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaEqualTo(String value) {
            addCriterion("register_area =", value, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaNotEqualTo(String value) {
            addCriterion("register_area <>", value, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaGreaterThan(String value) {
            addCriterion("register_area >", value, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaGreaterThanOrEqualTo(String value) {
            addCriterion("register_area >=", value, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaLessThan(String value) {
            addCriterion("register_area <", value, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaLessThanOrEqualTo(String value) {
            addCriterion("register_area <=", value, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaLike(String value) {
            addCriterion("register_area like", value, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaNotLike(String value) {
            addCriterion("register_area not like", value, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaIn(List<String> values) {
            addCriterion("register_area in", values, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaNotIn(List<String> values) {
            addCriterion("register_area not in", values, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaBetween(String value1, String value2) {
            addCriterion("register_area between", value1, value2, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAreaNotBetween(String value1, String value2) {
            addCriterion("register_area not between", value1, value2, "registerArea");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressIsNull() {
            addCriterion("register_address is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressIsNotNull() {
            addCriterion("register_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressEqualTo(String value) {
            addCriterion("register_address =", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressNotEqualTo(String value) {
            addCriterion("register_address <>", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressGreaterThan(String value) {
            addCriterion("register_address >", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressGreaterThanOrEqualTo(String value) {
            addCriterion("register_address >=", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressLessThan(String value) {
            addCriterion("register_address <", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressLessThanOrEqualTo(String value) {
            addCriterion("register_address <=", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressLike(String value) {
            addCriterion("register_address like", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressNotLike(String value) {
            addCriterion("register_address not like", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressIn(List<String> values) {
            addCriterion("register_address in", values, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressNotIn(List<String> values) {
            addCriterion("register_address not in", values, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressBetween(String value1, String value2) {
            addCriterion("register_address between", value1, value2, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressNotBetween(String value1, String value2) {
            addCriterion("register_address not between", value1, value2, "registerAddress");
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

        public Criteria andJobtitleIsNull() {
            addCriterion("jobtitle is null");
            return (Criteria) this;
        }

        public Criteria andJobtitleIsNotNull() {
            addCriterion("jobtitle is not null");
            return (Criteria) this;
        }

        public Criteria andJobtitleEqualTo(String value) {
            addCriterion("jobtitle =", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotEqualTo(String value) {
            addCriterion("jobtitle <>", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleGreaterThan(String value) {
            addCriterion("jobtitle >", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleGreaterThanOrEqualTo(String value) {
            addCriterion("jobtitle >=", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLessThan(String value) {
            addCriterion("jobtitle <", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLessThanOrEqualTo(String value) {
            addCriterion("jobtitle <=", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLike(String value) {
            addCriterion("jobtitle like", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotLike(String value) {
            addCriterion("jobtitle not like", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleIn(List<String> values) {
            addCriterion("jobtitle in", values, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotIn(List<String> values) {
            addCriterion("jobtitle not in", values, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleBetween(String value1, String value2) {
            addCriterion("jobtitle between", value1, value2, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotBetween(String value1, String value2) {
            addCriterion("jobtitle not between", value1, value2, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andContactCityIsNull() {
            addCriterion("contact_city is null");
            return (Criteria) this;
        }

        public Criteria andContactCityIsNotNull() {
            addCriterion("contact_city is not null");
            return (Criteria) this;
        }

        public Criteria andContactCityEqualTo(String value) {
            addCriterion("contact_city =", value, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityNotEqualTo(String value) {
            addCriterion("contact_city <>", value, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityGreaterThan(String value) {
            addCriterion("contact_city >", value, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityGreaterThanOrEqualTo(String value) {
            addCriterion("contact_city >=", value, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityLessThan(String value) {
            addCriterion("contact_city <", value, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityLessThanOrEqualTo(String value) {
            addCriterion("contact_city <=", value, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityLike(String value) {
            addCriterion("contact_city like", value, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityNotLike(String value) {
            addCriterion("contact_city not like", value, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityIn(List<String> values) {
            addCriterion("contact_city in", values, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityNotIn(List<String> values) {
            addCriterion("contact_city not in", values, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityBetween(String value1, String value2) {
            addCriterion("contact_city between", value1, value2, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactCityNotBetween(String value1, String value2) {
            addCriterion("contact_city not between", value1, value2, "contactCity");
            return (Criteria) this;
        }

        public Criteria andContactAreaIsNull() {
            addCriterion("contact_area is null");
            return (Criteria) this;
        }

        public Criteria andContactAreaIsNotNull() {
            addCriterion("contact_area is not null");
            return (Criteria) this;
        }

        public Criteria andContactAreaEqualTo(String value) {
            addCriterion("contact_area =", value, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaNotEqualTo(String value) {
            addCriterion("contact_area <>", value, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaGreaterThan(String value) {
            addCriterion("contact_area >", value, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaGreaterThanOrEqualTo(String value) {
            addCriterion("contact_area >=", value, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaLessThan(String value) {
            addCriterion("contact_area <", value, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaLessThanOrEqualTo(String value) {
            addCriterion("contact_area <=", value, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaLike(String value) {
            addCriterion("contact_area like", value, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaNotLike(String value) {
            addCriterion("contact_area not like", value, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaIn(List<String> values) {
            addCriterion("contact_area in", values, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaNotIn(List<String> values) {
            addCriterion("contact_area not in", values, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaBetween(String value1, String value2) {
            addCriterion("contact_area between", value1, value2, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAreaNotBetween(String value1, String value2) {
            addCriterion("contact_area not between", value1, value2, "contactArea");
            return (Criteria) this;
        }

        public Criteria andContactAddressIsNull() {
            addCriterion("contact_address is null");
            return (Criteria) this;
        }

        public Criteria andContactAddressIsNotNull() {
            addCriterion("contact_address is not null");
            return (Criteria) this;
        }

        public Criteria andContactAddressEqualTo(String value) {
            addCriterion("contact_address =", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotEqualTo(String value) {
            addCriterion("contact_address <>", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressGreaterThan(String value) {
            addCriterion("contact_address >", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressGreaterThanOrEqualTo(String value) {
            addCriterion("contact_address >=", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLessThan(String value) {
            addCriterion("contact_address <", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLessThanOrEqualTo(String value) {
            addCriterion("contact_address <=", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLike(String value) {
            addCriterion("contact_address like", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotLike(String value) {
            addCriterion("contact_address not like", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressIn(List<String> values) {
            addCriterion("contact_address in", values, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotIn(List<String> values) {
            addCriterion("contact_address not in", values, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressBetween(String value1, String value2) {
            addCriterion("contact_address between", value1, value2, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotBetween(String value1, String value2) {
            addCriterion("contact_address not between", value1, value2, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyIsNull() {
            addCriterion("multiple_company is null");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyIsNotNull() {
            addCriterion("multiple_company is not null");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyEqualTo(String value) {
            addCriterion("multiple_company =", value, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyNotEqualTo(String value) {
            addCriterion("multiple_company <>", value, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyGreaterThan(String value) {
            addCriterion("multiple_company >", value, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("multiple_company >=", value, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyLessThan(String value) {
            addCriterion("multiple_company <", value, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyLessThanOrEqualTo(String value) {
            addCriterion("multiple_company <=", value, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyLike(String value) {
            addCriterion("multiple_company like", value, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyNotLike(String value) {
            addCriterion("multiple_company not like", value, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyIn(List<String> values) {
            addCriterion("multiple_company in", values, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyNotIn(List<String> values) {
            addCriterion("multiple_company not in", values, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyBetween(String value1, String value2) {
            addCriterion("multiple_company between", value1, value2, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andMultipleCompanyNotBetween(String value1, String value2) {
            addCriterion("multiple_company not between", value1, value2, "multipleCompany");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsIsNull() {
            addCriterion("related_amounts is null");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsIsNotNull() {
            addCriterion("related_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsEqualTo(String value) {
            addCriterion("related_amounts =", value, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsNotEqualTo(String value) {
            addCriterion("related_amounts <>", value, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsGreaterThan(String value) {
            addCriterion("related_amounts >", value, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsGreaterThanOrEqualTo(String value) {
            addCriterion("related_amounts >=", value, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsLessThan(String value) {
            addCriterion("related_amounts <", value, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsLessThanOrEqualTo(String value) {
            addCriterion("related_amounts <=", value, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsLike(String value) {
            addCriterion("related_amounts like", value, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsNotLike(String value) {
            addCriterion("related_amounts not like", value, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsIn(List<String> values) {
            addCriterion("related_amounts in", values, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsNotIn(List<String> values) {
            addCriterion("related_amounts not in", values, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsBetween(String value1, String value2) {
            addCriterion("related_amounts between", value1, value2, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andRelatedAmountsNotBetween(String value1, String value2) {
            addCriterion("related_amounts not between", value1, value2, "relatedAmounts");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberIsNull() {
            addCriterion("employee_number is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberIsNotNull() {
            addCriterion("employee_number is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberEqualTo(Integer value) {
            addCriterion("employee_number =", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberNotEqualTo(Integer value) {
            addCriterion("employee_number <>", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberGreaterThan(Integer value) {
            addCriterion("employee_number >", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_number >=", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberLessThan(Integer value) {
            addCriterion("employee_number <", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("employee_number <=", value, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberIn(List<Integer> values) {
            addCriterion("employee_number in", values, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberNotIn(List<Integer> values) {
            addCriterion("employee_number not in", values, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberBetween(Integer value1, Integer value2) {
            addCriterion("employee_number between", value1, value2, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andEmployeeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_number not between", value1, value2, "employeeNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberIsNull() {
            addCriterion("benefit_number is null");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberIsNotNull() {
            addCriterion("benefit_number is not null");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberEqualTo(Integer value) {
            addCriterion("benefit_number =", value, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberNotEqualTo(Integer value) {
            addCriterion("benefit_number <>", value, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberGreaterThan(Integer value) {
            addCriterion("benefit_number >", value, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("benefit_number >=", value, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberLessThan(Integer value) {
            addCriterion("benefit_number <", value, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberLessThanOrEqualTo(Integer value) {
            addCriterion("benefit_number <=", value, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberIn(List<Integer> values) {
            addCriterion("benefit_number in", values, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberNotIn(List<Integer> values) {
            addCriterion("benefit_number not in", values, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberBetween(Integer value1, Integer value2) {
            addCriterion("benefit_number between", value1, value2, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("benefit_number not between", value1, value2, "benefitNumber");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesIsNull() {
            addCriterion("company_attributes is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesIsNotNull() {
            addCriterion("company_attributes is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesEqualTo(String value) {
            addCriterion("company_attributes =", value, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesNotEqualTo(String value) {
            addCriterion("company_attributes <>", value, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesGreaterThan(String value) {
            addCriterion("company_attributes >", value, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesGreaterThanOrEqualTo(String value) {
            addCriterion("company_attributes >=", value, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesLessThan(String value) {
            addCriterion("company_attributes <", value, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesLessThanOrEqualTo(String value) {
            addCriterion("company_attributes <=", value, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesLike(String value) {
            addCriterion("company_attributes like", value, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesNotLike(String value) {
            addCriterion("company_attributes not like", value, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesIn(List<String> values) {
            addCriterion("company_attributes in", values, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesNotIn(List<String> values) {
            addCriterion("company_attributes not in", values, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesBetween(String value1, String value2) {
            addCriterion("company_attributes between", value1, value2, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andCompanyAttributesNotBetween(String value1, String value2) {
            addCriterion("company_attributes not between", value1, value2, "companyAttributes");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleIsNull() {
            addCriterion("contact_jobtitle is null");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleIsNotNull() {
            addCriterion("contact_jobtitle is not null");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleEqualTo(String value) {
            addCriterion("contact_jobtitle =", value, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleNotEqualTo(String value) {
            addCriterion("contact_jobtitle <>", value, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleGreaterThan(String value) {
            addCriterion("contact_jobtitle >", value, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleGreaterThanOrEqualTo(String value) {
            addCriterion("contact_jobtitle >=", value, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleLessThan(String value) {
            addCriterion("contact_jobtitle <", value, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleLessThanOrEqualTo(String value) {
            addCriterion("contact_jobtitle <=", value, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleLike(String value) {
            addCriterion("contact_jobtitle like", value, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleNotLike(String value) {
            addCriterion("contact_jobtitle not like", value, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleIn(List<String> values) {
            addCriterion("contact_jobtitle in", values, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleNotIn(List<String> values) {
            addCriterion("contact_jobtitle not in", values, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleBetween(String value1, String value2) {
            addCriterion("contact_jobtitle between", value1, value2, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactJobtitleNotBetween(String value1, String value2) {
            addCriterion("contact_jobtitle not between", value1, value2, "contactJobtitle");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeIsNull() {
            addCriterion("contact_work_phone_area_code is null");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeIsNotNull() {
            addCriterion("contact_work_phone_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeEqualTo(String value) {
            addCriterion("contact_work_phone_area_code =", value, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeNotEqualTo(String value) {
            addCriterion("contact_work_phone_area_code <>", value, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeGreaterThan(String value) {
            addCriterion("contact_work_phone_area_code >", value, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("contact_work_phone_area_code >=", value, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeLessThan(String value) {
            addCriterion("contact_work_phone_area_code <", value, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("contact_work_phone_area_code <=", value, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeLike(String value) {
            addCriterion("contact_work_phone_area_code like", value, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeNotLike(String value) {
            addCriterion("contact_work_phone_area_code not like", value, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeIn(List<String> values) {
            addCriterion("contact_work_phone_area_code in", values, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeNotIn(List<String> values) {
            addCriterion("contact_work_phone_area_code not in", values, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeBetween(String value1, String value2) {
            addCriterion("contact_work_phone_area_code between", value1, value2, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneAreaCodeNotBetween(String value1, String value2) {
            addCriterion("contact_work_phone_area_code not between", value1, value2, "contactWorkPhoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneIsNull() {
            addCriterion("contact_work_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneIsNotNull() {
            addCriterion("contact_work_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneEqualTo(String value) {
            addCriterion("contact_work_phone =", value, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneNotEqualTo(String value) {
            addCriterion("contact_work_phone <>", value, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneGreaterThan(String value) {
            addCriterion("contact_work_phone >", value, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_work_phone >=", value, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneLessThan(String value) {
            addCriterion("contact_work_phone <", value, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_work_phone <=", value, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneLike(String value) {
            addCriterion("contact_work_phone like", value, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneNotLike(String value) {
            addCriterion("contact_work_phone not like", value, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneIn(List<String> values) {
            addCriterion("contact_work_phone in", values, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneNotIn(List<String> values) {
            addCriterion("contact_work_phone not in", values, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneBetween(String value1, String value2) {
            addCriterion("contact_work_phone between", value1, value2, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_work_phone not between", value1, value2, "contactWorkPhone");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionIsNull() {
            addCriterion("contact_work_phone_extension is null");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionIsNotNull() {
            addCriterion("contact_work_phone_extension is not null");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionEqualTo(String value) {
            addCriterion("contact_work_phone_extension =", value, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionNotEqualTo(String value) {
            addCriterion("contact_work_phone_extension <>", value, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionGreaterThan(String value) {
            addCriterion("contact_work_phone_extension >", value, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionGreaterThanOrEqualTo(String value) {
            addCriterion("contact_work_phone_extension >=", value, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionLessThan(String value) {
            addCriterion("contact_work_phone_extension <", value, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionLessThanOrEqualTo(String value) {
            addCriterion("contact_work_phone_extension <=", value, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionLike(String value) {
            addCriterion("contact_work_phone_extension like", value, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionNotLike(String value) {
            addCriterion("contact_work_phone_extension not like", value, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionIn(List<String> values) {
            addCriterion("contact_work_phone_extension in", values, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionNotIn(List<String> values) {
            addCriterion("contact_work_phone_extension not in", values, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionBetween(String value1, String value2) {
            addCriterion("contact_work_phone_extension between", value1, value2, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactWorkPhoneExtensionNotBetween(String value1, String value2) {
            addCriterion("contact_work_phone_extension not between", value1, value2, "contactWorkPhoneExtension");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeIsNull() {
            addCriterion("fax_area_code is null");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeIsNotNull() {
            addCriterion("fax_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeEqualTo(String value) {
            addCriterion("fax_area_code =", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeNotEqualTo(String value) {
            addCriterion("fax_area_code <>", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeGreaterThan(String value) {
            addCriterion("fax_area_code >", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fax_area_code >=", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeLessThan(String value) {
            addCriterion("fax_area_code <", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("fax_area_code <=", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeLike(String value) {
            addCriterion("fax_area_code like", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeNotLike(String value) {
            addCriterion("fax_area_code not like", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeIn(List<String> values) {
            addCriterion("fax_area_code in", values, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeNotIn(List<String> values) {
            addCriterion("fax_area_code not in", values, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeBetween(String value1, String value2) {
            addCriterion("fax_area_code between", value1, value2, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeNotBetween(String value1, String value2) {
            addCriterion("fax_area_code not between", value1, value2, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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

        public Criteria andApplyManyGovernmentIsNull() {
            addCriterion("apply_many_government is null");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentIsNotNull() {
            addCriterion("apply_many_government is not null");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentEqualTo(String value) {
            addCriterion("apply_many_government =", value, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentNotEqualTo(String value) {
            addCriterion("apply_many_government <>", value, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentGreaterThan(String value) {
            addCriterion("apply_many_government >", value, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentGreaterThanOrEqualTo(String value) {
            addCriterion("apply_many_government >=", value, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentLessThan(String value) {
            addCriterion("apply_many_government <", value, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentLessThanOrEqualTo(String value) {
            addCriterion("apply_many_government <=", value, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentLike(String value) {
            addCriterion("apply_many_government like", value, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentNotLike(String value) {
            addCriterion("apply_many_government not like", value, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentIn(List<String> values) {
            addCriterion("apply_many_government in", values, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentNotIn(List<String> values) {
            addCriterion("apply_many_government not in", values, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentBetween(String value1, String value2) {
            addCriterion("apply_many_government between", value1, value2, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentNotBetween(String value1, String value2) {
            addCriterion("apply_many_government not between", value1, value2, "applyManyGovernment");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearIsNull() {
            addCriterion("apply_many_government_year is null");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearIsNotNull() {
            addCriterion("apply_many_government_year is not null");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearEqualTo(String value) {
            addCriterion("apply_many_government_year =", value, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearNotEqualTo(String value) {
            addCriterion("apply_many_government_year <>", value, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearGreaterThan(String value) {
            addCriterion("apply_many_government_year >", value, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearGreaterThanOrEqualTo(String value) {
            addCriterion("apply_many_government_year >=", value, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearLessThan(String value) {
            addCriterion("apply_many_government_year <", value, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearLessThanOrEqualTo(String value) {
            addCriterion("apply_many_government_year <=", value, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearLike(String value) {
            addCriterion("apply_many_government_year like", value, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearNotLike(String value) {
            addCriterion("apply_many_government_year not like", value, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearIn(List<String> values) {
            addCriterion("apply_many_government_year in", values, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearNotIn(List<String> values) {
            addCriterion("apply_many_government_year not in", values, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearBetween(String value1, String value2) {
            addCriterion("apply_many_government_year between", value1, value2, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentYearNotBetween(String value1, String value2) {
            addCriterion("apply_many_government_year not between", value1, value2, "applyManyGovernmentYear");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameIsNull() {
            addCriterion("apply_many_government_plan_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameIsNotNull() {
            addCriterion("apply_many_government_plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameEqualTo(String value) {
            addCriterion("apply_many_government_plan_name =", value, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameNotEqualTo(String value) {
            addCriterion("apply_many_government_plan_name <>", value, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameGreaterThan(String value) {
            addCriterion("apply_many_government_plan_name >", value, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_many_government_plan_name >=", value, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameLessThan(String value) {
            addCriterion("apply_many_government_plan_name <", value, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameLessThanOrEqualTo(String value) {
            addCriterion("apply_many_government_plan_name <=", value, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameLike(String value) {
            addCriterion("apply_many_government_plan_name like", value, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameNotLike(String value) {
            addCriterion("apply_many_government_plan_name not like", value, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameIn(List<String> values) {
            addCriterion("apply_many_government_plan_name in", values, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameNotIn(List<String> values) {
            addCriterion("apply_many_government_plan_name not in", values, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameBetween(String value1, String value2) {
            addCriterion("apply_many_government_plan_name between", value1, value2, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentPlanNameNotBetween(String value1, String value2) {
            addCriterion("apply_many_government_plan_name not between", value1, value2, "applyManyGovernmentPlanName");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsIsNull() {
            addCriterion("apply_many_government_amounts is null");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsIsNotNull() {
            addCriterion("apply_many_government_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsEqualTo(Integer value) {
            addCriterion("apply_many_government_amounts =", value, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsNotEqualTo(Integer value) {
            addCriterion("apply_many_government_amounts <>", value, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsGreaterThan(Integer value) {
            addCriterion("apply_many_government_amounts >", value, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_many_government_amounts >=", value, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsLessThan(Integer value) {
            addCriterion("apply_many_government_amounts <", value, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("apply_many_government_amounts <=", value, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsIn(List<Integer> values) {
            addCriterion("apply_many_government_amounts in", values, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsNotIn(List<Integer> values) {
            addCriterion("apply_many_government_amounts not in", values, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsBetween(Integer value1, Integer value2) {
            addCriterion("apply_many_government_amounts between", value1, value2, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andApplyManyGovernmentAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_many_government_amounts not between", value1, value2, "applyManyGovernmentAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyIsNull() {
            addCriterion("repeat_apply is null");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyIsNotNull() {
            addCriterion("repeat_apply is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyEqualTo(String value) {
            addCriterion("repeat_apply =", value, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyNotEqualTo(String value) {
            addCriterion("repeat_apply <>", value, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyGreaterThan(String value) {
            addCriterion("repeat_apply >", value, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyGreaterThanOrEqualTo(String value) {
            addCriterion("repeat_apply >=", value, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyLessThan(String value) {
            addCriterion("repeat_apply <", value, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyLessThanOrEqualTo(String value) {
            addCriterion("repeat_apply <=", value, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyLike(String value) {
            addCriterion("repeat_apply like", value, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyNotLike(String value) {
            addCriterion("repeat_apply not like", value, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyIn(List<String> values) {
            addCriterion("repeat_apply in", values, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyNotIn(List<String> values) {
            addCriterion("repeat_apply not in", values, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyBetween(String value1, String value2) {
            addCriterion("repeat_apply between", value1, value2, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyNotBetween(String value1, String value2) {
            addCriterion("repeat_apply not between", value1, value2, "repeatApply");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearIsNull() {
            addCriterion("repeat_apply_year is null");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearIsNotNull() {
            addCriterion("repeat_apply_year is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearEqualTo(String value) {
            addCriterion("repeat_apply_year =", value, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearNotEqualTo(String value) {
            addCriterion("repeat_apply_year <>", value, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearGreaterThan(String value) {
            addCriterion("repeat_apply_year >", value, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearGreaterThanOrEqualTo(String value) {
            addCriterion("repeat_apply_year >=", value, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearLessThan(String value) {
            addCriterion("repeat_apply_year <", value, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearLessThanOrEqualTo(String value) {
            addCriterion("repeat_apply_year <=", value, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearLike(String value) {
            addCriterion("repeat_apply_year like", value, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearNotLike(String value) {
            addCriterion("repeat_apply_year not like", value, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearIn(List<String> values) {
            addCriterion("repeat_apply_year in", values, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearNotIn(List<String> values) {
            addCriterion("repeat_apply_year not in", values, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearBetween(String value1, String value2) {
            addCriterion("repeat_apply_year between", value1, value2, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyYearNotBetween(String value1, String value2) {
            addCriterion("repeat_apply_year not between", value1, value2, "repeatApplyYear");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsIsNull() {
            addCriterion("repeat_apply_amounts is null");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsIsNotNull() {
            addCriterion("repeat_apply_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsEqualTo(Integer value) {
            addCriterion("repeat_apply_amounts =", value, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsNotEqualTo(Integer value) {
            addCriterion("repeat_apply_amounts <>", value, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsGreaterThan(Integer value) {
            addCriterion("repeat_apply_amounts >", value, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("repeat_apply_amounts >=", value, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsLessThan(Integer value) {
            addCriterion("repeat_apply_amounts <", value, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("repeat_apply_amounts <=", value, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsIn(List<Integer> values) {
            addCriterion("repeat_apply_amounts in", values, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsNotIn(List<Integer> values) {
            addCriterion("repeat_apply_amounts not in", values, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsBetween(Integer value1, Integer value2) {
            addCriterion("repeat_apply_amounts between", value1, value2, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andRepeatApplyAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("repeat_apply_amounts not between", value1, value2, "repeatApplyAmounts");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyIsNull() {
            addCriterion("attach_documents_apply is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyIsNotNull() {
            addCriterion("attach_documents_apply is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyEqualTo(String value) {
            addCriterion("attach_documents_apply =", value, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyNotEqualTo(String value) {
            addCriterion("attach_documents_apply <>", value, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyGreaterThan(String value) {
            addCriterion("attach_documents_apply >", value, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_apply >=", value, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyLessThan(String value) {
            addCriterion("attach_documents_apply <", value, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_apply <=", value, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyLike(String value) {
            addCriterion("attach_documents_apply like", value, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyNotLike(String value) {
            addCriterion("attach_documents_apply not like", value, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyIn(List<String> values) {
            addCriterion("attach_documents_apply in", values, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyNotIn(List<String> values) {
            addCriterion("attach_documents_apply not in", values, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyBetween(String value1, String value2) {
            addCriterion("attach_documents_apply between", value1, value2, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsApplyNotBetween(String value1, String value2) {
            addCriterion("attach_documents_apply not between", value1, value2, "attachDocumentsApply");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanIsNull() {
            addCriterion("attach_documents_plan is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanIsNotNull() {
            addCriterion("attach_documents_plan is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanEqualTo(String value) {
            addCriterion("attach_documents_plan =", value, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanNotEqualTo(String value) {
            addCriterion("attach_documents_plan <>", value, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanGreaterThan(String value) {
            addCriterion("attach_documents_plan >", value, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_plan >=", value, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanLessThan(String value) {
            addCriterion("attach_documents_plan <", value, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_plan <=", value, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanLike(String value) {
            addCriterion("attach_documents_plan like", value, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanNotLike(String value) {
            addCriterion("attach_documents_plan not like", value, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanIn(List<String> values) {
            addCriterion("attach_documents_plan in", values, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanNotIn(List<String> values) {
            addCriterion("attach_documents_plan not in", values, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanBetween(String value1, String value2) {
            addCriterion("attach_documents_plan between", value1, value2, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanNotBetween(String value1, String value2) {
            addCriterion("attach_documents_plan not between", value1, value2, "attachDocumentsPlan");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureIsNull() {
            addCriterion("attach_documents_expenditure is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureIsNotNull() {
            addCriterion("attach_documents_expenditure is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureEqualTo(String value) {
            addCriterion("attach_documents_expenditure =", value, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureNotEqualTo(String value) {
            addCriterion("attach_documents_expenditure <>", value, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureGreaterThan(String value) {
            addCriterion("attach_documents_expenditure >", value, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_expenditure >=", value, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureLessThan(String value) {
            addCriterion("attach_documents_expenditure <", value, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_expenditure <=", value, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureLike(String value) {
            addCriterion("attach_documents_expenditure like", value, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureNotLike(String value) {
            addCriterion("attach_documents_expenditure not like", value, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureIn(List<String> values) {
            addCriterion("attach_documents_expenditure in", values, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureNotIn(List<String> values) {
            addCriterion("attach_documents_expenditure not in", values, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureBetween(String value1, String value2) {
            addCriterion("attach_documents_expenditure between", value1, value2, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureNotBetween(String value1, String value2) {
            addCriterion("attach_documents_expenditure not between", value1, value2, "attachDocumentsExpenditure");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofIsNull() {
            addCriterion("attach_documents_register_proof is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofIsNotNull() {
            addCriterion("attach_documents_register_proof is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofEqualTo(String value) {
            addCriterion("attach_documents_register_proof =", value, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofNotEqualTo(String value) {
            addCriterion("attach_documents_register_proof <>", value, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofGreaterThan(String value) {
            addCriterion("attach_documents_register_proof >", value, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_register_proof >=", value, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofLessThan(String value) {
            addCriterion("attach_documents_register_proof <", value, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_register_proof <=", value, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofLike(String value) {
            addCriterion("attach_documents_register_proof like", value, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofNotLike(String value) {
            addCriterion("attach_documents_register_proof not like", value, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofIn(List<String> values) {
            addCriterion("attach_documents_register_proof in", values, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofNotIn(List<String> values) {
            addCriterion("attach_documents_register_proof not in", values, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofBetween(String value1, String value2) {
            addCriterion("attach_documents_register_proof between", value1, value2, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsRegisterProofNotBetween(String value1, String value2) {
            addCriterion("attach_documents_register_proof not between", value1, value2, "attachDocumentsRegisterProof");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataIsNull() {
            addCriterion("joint_authorize_basic_data is null");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataIsNotNull() {
            addCriterion("joint_authorize_basic_data is not null");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataEqualTo(String value) {
            addCriterion("joint_authorize_basic_data =", value, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataNotEqualTo(String value) {
            addCriterion("joint_authorize_basic_data <>", value, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataGreaterThan(String value) {
            addCriterion("joint_authorize_basic_data >", value, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataGreaterThanOrEqualTo(String value) {
            addCriterion("joint_authorize_basic_data >=", value, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataLessThan(String value) {
            addCriterion("joint_authorize_basic_data <", value, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataLessThanOrEqualTo(String value) {
            addCriterion("joint_authorize_basic_data <=", value, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataLike(String value) {
            addCriterion("joint_authorize_basic_data like", value, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataNotLike(String value) {
            addCriterion("joint_authorize_basic_data not like", value, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataIn(List<String> values) {
            addCriterion("joint_authorize_basic_data in", values, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataNotIn(List<String> values) {
            addCriterion("joint_authorize_basic_data not in", values, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataBetween(String value1, String value2) {
            addCriterion("joint_authorize_basic_data between", value1, value2, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andJointAuthorizeBasicDataNotBetween(String value1, String value2) {
            addCriterion("joint_authorize_basic_data not between", value1, value2, "jointAuthorizeBasicData");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofIsNull() {
            addCriterion("attach_documents_other_proof is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofIsNotNull() {
            addCriterion("attach_documents_other_proof is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofEqualTo(String value) {
            addCriterion("attach_documents_other_proof =", value, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofNotEqualTo(String value) {
            addCriterion("attach_documents_other_proof <>", value, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofGreaterThan(String value) {
            addCriterion("attach_documents_other_proof >", value, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_other_proof >=", value, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofLessThan(String value) {
            addCriterion("attach_documents_other_proof <", value, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_other_proof <=", value, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofLike(String value) {
            addCriterion("attach_documents_other_proof like", value, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofNotLike(String value) {
            addCriterion("attach_documents_other_proof not like", value, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofIn(List<String> values) {
            addCriterion("attach_documents_other_proof in", values, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofNotIn(List<String> values) {
            addCriterion("attach_documents_other_proof not in", values, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofBetween(String value1, String value2) {
            addCriterion("attach_documents_other_proof between", value1, value2, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofNotBetween(String value1, String value2) {
            addCriterion("attach_documents_other_proof not between", value1, value2, "attachDocumentsOtherProof");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentIsNull() {
            addCriterion("attach_documents_other_proof_document is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentIsNotNull() {
            addCriterion("attach_documents_other_proof_document is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentEqualTo(String value) {
            addCriterion("attach_documents_other_proof_document =", value, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentNotEqualTo(String value) {
            addCriterion("attach_documents_other_proof_document <>", value, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentGreaterThan(String value) {
            addCriterion("attach_documents_other_proof_document >", value, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_other_proof_document >=", value, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentLessThan(String value) {
            addCriterion("attach_documents_other_proof_document <", value, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_other_proof_document <=", value, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentLike(String value) {
            addCriterion("attach_documents_other_proof_document like", value, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentNotLike(String value) {
            addCriterion("attach_documents_other_proof_document not like", value, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentIn(List<String> values) {
            addCriterion("attach_documents_other_proof_document in", values, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentNotIn(List<String> values) {
            addCriterion("attach_documents_other_proof_document not in", values, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentBetween(String value1, String value2) {
            addCriterion("attach_documents_other_proof_document between", value1, value2, "attachDocumentsOtherProofDocument");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsOtherProofDocumentNotBetween(String value1, String value2) {
            addCriterion("attach_documents_other_proof_document not between", value1, value2, "attachDocumentsOtherProofDocument");
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

        public Criteria andAgreeIsNull() {
            addCriterion("agree is null");
            return (Criteria) this;
        }

        public Criteria andAgreeIsNotNull() {
            addCriterion("agree is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeEqualTo(String value) {
            addCriterion("agree =", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotEqualTo(String value) {
            addCriterion("agree <>", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeGreaterThan(String value) {
            addCriterion("agree >", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeGreaterThanOrEqualTo(String value) {
            addCriterion("agree >=", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLessThan(String value) {
            addCriterion("agree <", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLessThanOrEqualTo(String value) {
            addCriterion("agree <=", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLike(String value) {
            addCriterion("agree like", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotLike(String value) {
            addCriterion("agree not like", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeIn(List<String> values) {
            addCriterion("agree in", values, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotIn(List<String> values) {
            addCriterion("agree not in", values, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeBetween(String value1, String value2) {
            addCriterion("agree between", value1, value2, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotBetween(String value1, String value2) {
            addCriterion("agree not between", value1, value2, "agree");
            return (Criteria) this;
        }

        public Criteria andFillerIsNull() {
            addCriterion("filler is null");
            return (Criteria) this;
        }

        public Criteria andFillerIsNotNull() {
            addCriterion("filler is not null");
            return (Criteria) this;
        }

        public Criteria andFillerEqualTo(String value) {
            addCriterion("filler =", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotEqualTo(String value) {
            addCriterion("filler <>", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThan(String value) {
            addCriterion("filler >", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThanOrEqualTo(String value) {
            addCriterion("filler >=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThan(String value) {
            addCriterion("filler <", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThanOrEqualTo(String value) {
            addCriterion("filler <=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLike(String value) {
            addCriterion("filler like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotLike(String value) {
            addCriterion("filler not like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerIn(List<String> values) {
            addCriterion("filler in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotIn(List<String> values) {
            addCriterion("filler not in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerBetween(String value1, String value2) {
            addCriterion("filler between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotBetween(String value1, String value2) {
            addCriterion("filler not between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNull() {
            addCriterion("updator is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("updator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("updator =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("updator <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("updator >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("updator >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("updator <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("updator <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("updator like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("updator not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("updator in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("updator not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("updator between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("updator not between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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