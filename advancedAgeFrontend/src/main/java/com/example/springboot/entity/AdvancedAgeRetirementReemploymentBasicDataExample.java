package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class AdvancedAgeRetirementReemploymentBasicDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvancedAgeRetirementReemploymentBasicDataExample() {
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

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdIsNull() {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdIsNotNull() {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdEqualTo(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id =", value, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdNotEqualTo(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id <>", value, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdGreaterThan(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id >", value, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id >=", value, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdLessThan(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id <", value, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id <=", value, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdIn(List<Integer> values) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id in", values, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdNotIn(List<Integer> values) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id not in", values, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id between", value1, value2, "advancedAgeRetirementReemploymentJointAuthorizeId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentJointAuthorizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_retirement_reemployment_joint_authorize_id not between", value1, value2, "advancedAgeRetirementReemploymentJointAuthorizeId");
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

        public Criteria andBusinessItemIsNull() {
            addCriterion("business_item is null");
            return (Criteria) this;
        }

        public Criteria andBusinessItemIsNotNull() {
            addCriterion("business_item is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessItemEqualTo(String value) {
            addCriterion("business_item =", value, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemNotEqualTo(String value) {
            addCriterion("business_item <>", value, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemGreaterThan(String value) {
            addCriterion("business_item >", value, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemGreaterThanOrEqualTo(String value) {
            addCriterion("business_item >=", value, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemLessThan(String value) {
            addCriterion("business_item <", value, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemLessThanOrEqualTo(String value) {
            addCriterion("business_item <=", value, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemLike(String value) {
            addCriterion("business_item like", value, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemNotLike(String value) {
            addCriterion("business_item not like", value, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemIn(List<String> values) {
            addCriterion("business_item in", values, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemNotIn(List<String> values) {
            addCriterion("business_item not in", values, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemBetween(String value1, String value2) {
            addCriterion("business_item between", value1, value2, "businessItem");
            return (Criteria) this;
        }

        public Criteria andBusinessItemNotBetween(String value1, String value2) {
            addCriterion("business_item not between", value1, value2, "businessItem");
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

        public Criteria andUnitSizeIsNull() {
            addCriterion("unit_size is null");
            return (Criteria) this;
        }

        public Criteria andUnitSizeIsNotNull() {
            addCriterion("unit_size is not null");
            return (Criteria) this;
        }

        public Criteria andUnitSizeEqualTo(String value) {
            addCriterion("unit_size =", value, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeNotEqualTo(String value) {
            addCriterion("unit_size <>", value, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeGreaterThan(String value) {
            addCriterion("unit_size >", value, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_size >=", value, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeLessThan(String value) {
            addCriterion("unit_size <", value, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeLessThanOrEqualTo(String value) {
            addCriterion("unit_size <=", value, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeLike(String value) {
            addCriterion("unit_size like", value, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeNotLike(String value) {
            addCriterion("unit_size not like", value, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeIn(List<String> values) {
            addCriterion("unit_size in", values, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeNotIn(List<String> values) {
            addCriterion("unit_size not in", values, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeBetween(String value1, String value2) {
            addCriterion("unit_size between", value1, value2, "unitSize");
            return (Criteria) this;
        }

        public Criteria andUnitSizeNotBetween(String value1, String value2) {
            addCriterion("unit_size not between", value1, value2, "unitSize");
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

        public Criteria andParticipateNumberIsNull() {
            addCriterion("participate_number is null");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberIsNotNull() {
            addCriterion("participate_number is not null");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberEqualTo(Integer value) {
            addCriterion("participate_number =", value, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberNotEqualTo(Integer value) {
            addCriterion("participate_number <>", value, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberGreaterThan(Integer value) {
            addCriterion("participate_number >", value, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("participate_number >=", value, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberLessThan(Integer value) {
            addCriterion("participate_number <", value, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberLessThanOrEqualTo(Integer value) {
            addCriterion("participate_number <=", value, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberIn(List<Integer> values) {
            addCriterion("participate_number in", values, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberNotIn(List<Integer> values) {
            addCriterion("participate_number not in", values, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberBetween(Integer value1, Integer value2) {
            addCriterion("participate_number between", value1, value2, "participateNumber");
            return (Criteria) this;
        }

        public Criteria andParticipateNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("participate_number not between", value1, value2, "participateNumber");
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