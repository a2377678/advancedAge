package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyInfoExample() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andAccountStatusIsNull() {
            addCriterion("account_status is null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNotNull() {
            addCriterion("account_status is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusEqualTo(String value) {
            addCriterion("account_status =", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotEqualTo(String value) {
            addCriterion("account_status <>", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThan(String value) {
            addCriterion("account_status >", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("account_status >=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThan(String value) {
            addCriterion("account_status <", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThanOrEqualTo(String value) {
            addCriterion("account_status <=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLike(String value) {
            addCriterion("account_status like", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotLike(String value) {
            addCriterion("account_status not like", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIn(List<String> values) {
            addCriterion("account_status in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotIn(List<String> values) {
            addCriterion("account_status not in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusBetween(String value1, String value2) {
            addCriterion("account_status between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotBetween(String value1, String value2) {
            addCriterion("account_status not between", value1, value2, "accountStatus");
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

        public Criteria andVerifyTimeIsNull() {
            addCriterion("verify_time is null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeIsNotNull() {
            addCriterion("verify_time is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeEqualTo(Date value) {
            addCriterion("verify_time =", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotEqualTo(Date value) {
            addCriterion("verify_time <>", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeGreaterThan(Date value) {
            addCriterion("verify_time >", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("verify_time >=", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeLessThan(Date value) {
            addCriterion("verify_time <", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("verify_time <=", value, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeIn(List<Date> values) {
            addCriterion("verify_time in", values, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotIn(List<Date> values) {
            addCriterion("verify_time not in", values, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeBetween(Date value1, Date value2) {
            addCriterion("verify_time between", value1, value2, "verifyTime");
            return (Criteria) this;
        }

        public Criteria andVerifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("verify_time not between", value1, value2, "verifyTime");
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

        public Criteria andVerifyUnitIsNull() {
            addCriterion("verify_unit is null");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitIsNotNull() {
            addCriterion("verify_unit is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitEqualTo(String value) {
            addCriterion("verify_unit =", value, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitNotEqualTo(String value) {
            addCriterion("verify_unit <>", value, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitGreaterThan(String value) {
            addCriterion("verify_unit >", value, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("verify_unit >=", value, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitLessThan(String value) {
            addCriterion("verify_unit <", value, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitLessThanOrEqualTo(String value) {
            addCriterion("verify_unit <=", value, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitLike(String value) {
            addCriterion("verify_unit like", value, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitNotLike(String value) {
            addCriterion("verify_unit not like", value, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitIn(List<String> values) {
            addCriterion("verify_unit in", values, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitNotIn(List<String> values) {
            addCriterion("verify_unit not in", values, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitBetween(String value1, String value2) {
            addCriterion("verify_unit between", value1, value2, "verifyUnit");
            return (Criteria) this;
        }

        public Criteria andVerifyUnitNotBetween(String value1, String value2) {
            addCriterion("verify_unit not between", value1, value2, "verifyUnit");
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