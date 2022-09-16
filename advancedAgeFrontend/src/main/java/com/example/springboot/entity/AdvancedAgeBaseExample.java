package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvancedAgeBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvancedAgeBaseExample() {
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

        public Criteria andAaidIsNull() {
            addCriterion("aaid is null");
            return (Criteria) this;
        }

        public Criteria andAaidIsNotNull() {
            addCriterion("aaid is not null");
            return (Criteria) this;
        }

        public Criteria andAaidEqualTo(String value) {
            addCriterion("aaid =", value, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidNotEqualTo(String value) {
            addCriterion("aaid <>", value, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidGreaterThan(String value) {
            addCriterion("aaid >", value, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidGreaterThanOrEqualTo(String value) {
            addCriterion("aaid >=", value, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidLessThan(String value) {
            addCriterion("aaid <", value, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidLessThanOrEqualTo(String value) {
            addCriterion("aaid <=", value, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidLike(String value) {
            addCriterion("aaid like", value, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidNotLike(String value) {
            addCriterion("aaid not like", value, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidIn(List<String> values) {
            addCriterion("aaid in", values, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidNotIn(List<String> values) {
            addCriterion("aaid not in", values, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidBetween(String value1, String value2) {
            addCriterion("aaid between", value1, value2, "aaid");
            return (Criteria) this;
        }

        public Criteria andAaidNotBetween(String value1, String value2) {
            addCriterion("aaid not between", value1, value2, "aaid");
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNull() {
            addCriterion("case_type is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNotNull() {
            addCriterion("case_type is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeEqualTo(String value) {
            addCriterion("case_type =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(String value) {
            addCriterion("case_type <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(String value) {
            addCriterion("case_type >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("case_type >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(String value) {
            addCriterion("case_type <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(String value) {
            addCriterion("case_type <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLike(String value) {
            addCriterion("case_type like", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotLike(String value) {
            addCriterion("case_type not like", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<String> values) {
            addCriterion("case_type in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<String> values) {
            addCriterion("case_type not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(String value1, String value2) {
            addCriterion("case_type between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(String value1, String value2) {
            addCriterion("case_type not between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIsNull() {
            addCriterion("case_status is null");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIsNotNull() {
            addCriterion("case_status is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStatusEqualTo(String value) {
            addCriterion("case_status =", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotEqualTo(String value) {
            addCriterion("case_status <>", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusGreaterThan(String value) {
            addCriterion("case_status >", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("case_status >=", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLessThan(String value) {
            addCriterion("case_status <", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLessThanOrEqualTo(String value) {
            addCriterion("case_status <=", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusLike(String value) {
            addCriterion("case_status like", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotLike(String value) {
            addCriterion("case_status not like", value, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusIn(List<String> values) {
            addCriterion("case_status in", values, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotIn(List<String> values) {
            addCriterion("case_status not in", values, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusBetween(String value1, String value2) {
            addCriterion("case_status between", value1, value2, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andCaseStatusNotBetween(String value1, String value2) {
            addCriterion("case_status not between", value1, value2, "caseStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordIsNull() {
            addCriterion("file_status_record is null");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordIsNotNull() {
            addCriterion("file_status_record is not null");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordEqualTo(String value) {
            addCriterion("file_status_record =", value, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordNotEqualTo(String value) {
            addCriterion("file_status_record <>", value, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordGreaterThan(String value) {
            addCriterion("file_status_record >", value, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordGreaterThanOrEqualTo(String value) {
            addCriterion("file_status_record >=", value, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordLessThan(String value) {
            addCriterion("file_status_record <", value, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordLessThanOrEqualTo(String value) {
            addCriterion("file_status_record <=", value, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordLike(String value) {
            addCriterion("file_status_record like", value, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordNotLike(String value) {
            addCriterion("file_status_record not like", value, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordIn(List<String> values) {
            addCriterion("file_status_record in", values, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordNotIn(List<String> values) {
            addCriterion("file_status_record not in", values, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordBetween(String value1, String value2) {
            addCriterion("file_status_record between", value1, value2, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileStatusRecordNotBetween(String value1, String value2) {
            addCriterion("file_status_record not between", value1, value2, "fileStatusRecord");
            return (Criteria) this;
        }

        public Criteria andFileRemarkIsNull() {
            addCriterion("file_remark is null");
            return (Criteria) this;
        }

        public Criteria andFileRemarkIsNotNull() {
            addCriterion("file_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFileRemarkEqualTo(String value) {
            addCriterion("file_remark =", value, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkNotEqualTo(String value) {
            addCriterion("file_remark <>", value, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkGreaterThan(String value) {
            addCriterion("file_remark >", value, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("file_remark >=", value, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkLessThan(String value) {
            addCriterion("file_remark <", value, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkLessThanOrEqualTo(String value) {
            addCriterion("file_remark <=", value, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkLike(String value) {
            addCriterion("file_remark like", value, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkNotLike(String value) {
            addCriterion("file_remark not like", value, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkIn(List<String> values) {
            addCriterion("file_remark in", values, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkNotIn(List<String> values) {
            addCriterion("file_remark not in", values, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkBetween(String value1, String value2) {
            addCriterion("file_remark between", value1, value2, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andFileRemarkNotBetween(String value1, String value2) {
            addCriterion("file_remark not between", value1, value2, "fileRemark");
            return (Criteria) this;
        }

        public Criteria andEmailContentIsNull() {
            addCriterion("email_content is null");
            return (Criteria) this;
        }

        public Criteria andEmailContentIsNotNull() {
            addCriterion("email_content is not null");
            return (Criteria) this;
        }

        public Criteria andEmailContentEqualTo(String value) {
            addCriterion("email_content =", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotEqualTo(String value) {
            addCriterion("email_content <>", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentGreaterThan(String value) {
            addCriterion("email_content >", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentGreaterThanOrEqualTo(String value) {
            addCriterion("email_content >=", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLessThan(String value) {
            addCriterion("email_content <", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLessThanOrEqualTo(String value) {
            addCriterion("email_content <=", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentLike(String value) {
            addCriterion("email_content like", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotLike(String value) {
            addCriterion("email_content not like", value, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentIn(List<String> values) {
            addCriterion("email_content in", values, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotIn(List<String> values) {
            addCriterion("email_content not in", values, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentBetween(String value1, String value2) {
            addCriterion("email_content between", value1, value2, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailContentNotBetween(String value1, String value2) {
            addCriterion("email_content not between", value1, value2, "emailContent");
            return (Criteria) this;
        }

        public Criteria andEmailTimeIsNull() {
            addCriterion("email_time is null");
            return (Criteria) this;
        }

        public Criteria andEmailTimeIsNotNull() {
            addCriterion("email_time is not null");
            return (Criteria) this;
        }

        public Criteria andEmailTimeEqualTo(Date value) {
            addCriterion("email_time =", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeNotEqualTo(Date value) {
            addCriterion("email_time <>", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeGreaterThan(Date value) {
            addCriterion("email_time >", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("email_time >=", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeLessThan(Date value) {
            addCriterion("email_time <", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeLessThanOrEqualTo(Date value) {
            addCriterion("email_time <=", value, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeIn(List<Date> values) {
            addCriterion("email_time in", values, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeNotIn(List<Date> values) {
            addCriterion("email_time not in", values, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeBetween(Date value1, Date value2) {
            addCriterion("email_time between", value1, value2, "emailTime");
            return (Criteria) this;
        }

        public Criteria andEmailTimeNotBetween(Date value1, Date value2) {
            addCriterion("email_time not between", value1, value2, "emailTime");
            return (Criteria) this;
        }

        public Criteria andFileStatusIsNull() {
            addCriterion("file_status is null");
            return (Criteria) this;
        }

        public Criteria andFileStatusIsNotNull() {
            addCriterion("file_status is not null");
            return (Criteria) this;
        }

        public Criteria andFileStatusEqualTo(String value) {
            addCriterion("file_status =", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusNotEqualTo(String value) {
            addCriterion("file_status <>", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusGreaterThan(String value) {
            addCriterion("file_status >", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusGreaterThanOrEqualTo(String value) {
            addCriterion("file_status >=", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusLessThan(String value) {
            addCriterion("file_status <", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusLessThanOrEqualTo(String value) {
            addCriterion("file_status <=", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusLike(String value) {
            addCriterion("file_status like", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusNotLike(String value) {
            addCriterion("file_status not like", value, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusIn(List<String> values) {
            addCriterion("file_status in", values, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusNotIn(List<String> values) {
            addCriterion("file_status not in", values, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusBetween(String value1, String value2) {
            addCriterion("file_status between", value1, value2, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andFileStatusNotBetween(String value1, String value2) {
            addCriterion("file_status not between", value1, value2, "fileStatus");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyIsNull() {
            addCriterion("check_multiple_company is null");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyIsNotNull() {
            addCriterion("check_multiple_company is not null");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyEqualTo(String value) {
            addCriterion("check_multiple_company =", value, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyNotEqualTo(String value) {
            addCriterion("check_multiple_company <>", value, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyGreaterThan(String value) {
            addCriterion("check_multiple_company >", value, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("check_multiple_company >=", value, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyLessThan(String value) {
            addCriterion("check_multiple_company <", value, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyLessThanOrEqualTo(String value) {
            addCriterion("check_multiple_company <=", value, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyLike(String value) {
            addCriterion("check_multiple_company like", value, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyNotLike(String value) {
            addCriterion("check_multiple_company not like", value, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyIn(List<String> values) {
            addCriterion("check_multiple_company in", values, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyNotIn(List<String> values) {
            addCriterion("check_multiple_company not in", values, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyBetween(String value1, String value2) {
            addCriterion("check_multiple_company between", value1, value2, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckMultipleCompanyNotBetween(String value1, String value2) {
            addCriterion("check_multiple_company not between", value1, value2, "checkMultipleCompany");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentIsNull() {
            addCriterion("check_workers_employment is null");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentIsNotNull() {
            addCriterion("check_workers_employment is not null");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentEqualTo(String value) {
            addCriterion("check_workers_employment =", value, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentNotEqualTo(String value) {
            addCriterion("check_workers_employment <>", value, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentGreaterThan(String value) {
            addCriterion("check_workers_employment >", value, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentGreaterThanOrEqualTo(String value) {
            addCriterion("check_workers_employment >=", value, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentLessThan(String value) {
            addCriterion("check_workers_employment <", value, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentLessThanOrEqualTo(String value) {
            addCriterion("check_workers_employment <=", value, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentLike(String value) {
            addCriterion("check_workers_employment like", value, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentNotLike(String value) {
            addCriterion("check_workers_employment not like", value, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentIn(List<String> values) {
            addCriterion("check_workers_employment in", values, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentNotIn(List<String> values) {
            addCriterion("check_workers_employment not in", values, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentBetween(String value1, String value2) {
            addCriterion("check_workers_employment between", value1, value2, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckWorkersEmploymentNotBetween(String value1, String value2) {
            addCriterion("check_workers_employment not between", value1, value2, "checkWorkersEmployment");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesIsNull() {
            addCriterion("check_relatives is null");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesIsNotNull() {
            addCriterion("check_relatives is not null");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesEqualTo(String value) {
            addCriterion("check_relatives =", value, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesNotEqualTo(String value) {
            addCriterion("check_relatives <>", value, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesGreaterThan(String value) {
            addCriterion("check_relatives >", value, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesGreaterThanOrEqualTo(String value) {
            addCriterion("check_relatives >=", value, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesLessThan(String value) {
            addCriterion("check_relatives <", value, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesLessThanOrEqualTo(String value) {
            addCriterion("check_relatives <=", value, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesLike(String value) {
            addCriterion("check_relatives like", value, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesNotLike(String value) {
            addCriterion("check_relatives not like", value, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesIn(List<String> values) {
            addCriterion("check_relatives in", values, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesNotIn(List<String> values) {
            addCriterion("check_relatives not in", values, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesBetween(String value1, String value2) {
            addCriterion("check_relatives between", value1, value2, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelativesNotBetween(String value1, String value2) {
            addCriterion("check_relatives not between", value1, value2, "checkRelatives");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsIsNull() {
            addCriterion("check_related_amounts is null");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsIsNotNull() {
            addCriterion("check_related_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsEqualTo(String value) {
            addCriterion("check_related_amounts =", value, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsNotEqualTo(String value) {
            addCriterion("check_related_amounts <>", value, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsGreaterThan(String value) {
            addCriterion("check_related_amounts >", value, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsGreaterThanOrEqualTo(String value) {
            addCriterion("check_related_amounts >=", value, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsLessThan(String value) {
            addCriterion("check_related_amounts <", value, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsLessThanOrEqualTo(String value) {
            addCriterion("check_related_amounts <=", value, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsLike(String value) {
            addCriterion("check_related_amounts like", value, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsNotLike(String value) {
            addCriterion("check_related_amounts not like", value, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsIn(List<String> values) {
            addCriterion("check_related_amounts in", values, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsNotIn(List<String> values) {
            addCriterion("check_related_amounts not in", values, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsBetween(String value1, String value2) {
            addCriterion("check_related_amounts between", value1, value2, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckRelatedAmountsNotBetween(String value1, String value2) {
            addCriterion("check_related_amounts not between", value1, value2, "checkRelatedAmounts");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryIsNull() {
            addCriterion("check_not_mandatory is null");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryIsNotNull() {
            addCriterion("check_not_mandatory is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryEqualTo(String value) {
            addCriterion("check_not_mandatory =", value, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryNotEqualTo(String value) {
            addCriterion("check_not_mandatory <>", value, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryGreaterThan(String value) {
            addCriterion("check_not_mandatory >", value, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryGreaterThanOrEqualTo(String value) {
            addCriterion("check_not_mandatory >=", value, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryLessThan(String value) {
            addCriterion("check_not_mandatory <", value, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryLessThanOrEqualTo(String value) {
            addCriterion("check_not_mandatory <=", value, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryLike(String value) {
            addCriterion("check_not_mandatory like", value, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryNotLike(String value) {
            addCriterion("check_not_mandatory not like", value, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryIn(List<String> values) {
            addCriterion("check_not_mandatory in", values, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryNotIn(List<String> values) {
            addCriterion("check_not_mandatory not in", values, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryBetween(String value1, String value2) {
            addCriterion("check_not_mandatory between", value1, value2, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckNotMandatoryNotBetween(String value1, String value2) {
            addCriterion("check_not_mandatory not between", value1, value2, "checkNotMandatory");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonIsNull() {
            addCriterion("check_employment_person is null");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonIsNotNull() {
            addCriterion("check_employment_person is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonEqualTo(Integer value) {
            addCriterion("check_employment_person =", value, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonNotEqualTo(Integer value) {
            addCriterion("check_employment_person <>", value, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonGreaterThan(Integer value) {
            addCriterion("check_employment_person >", value, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_employment_person >=", value, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonLessThan(Integer value) {
            addCriterion("check_employment_person <", value, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonLessThanOrEqualTo(Integer value) {
            addCriterion("check_employment_person <=", value, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonIn(List<Integer> values) {
            addCriterion("check_employment_person in", values, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonNotIn(List<Integer> values) {
            addCriterion("check_employment_person not in", values, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonBetween(Integer value1, Integer value2) {
            addCriterion("check_employment_person between", value1, value2, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentPersonNotBetween(Integer value1, Integer value2) {
            addCriterion("check_employment_person not between", value1, value2, "checkEmploymentPerson");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkIsNull() {
            addCriterion("check_employment_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkIsNotNull() {
            addCriterion("check_employment_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkEqualTo(String value) {
            addCriterion("check_employment_remark =", value, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkNotEqualTo(String value) {
            addCriterion("check_employment_remark <>", value, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkGreaterThan(String value) {
            addCriterion("check_employment_remark >", value, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_employment_remark >=", value, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkLessThan(String value) {
            addCriterion("check_employment_remark <", value, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_employment_remark <=", value, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkLike(String value) {
            addCriterion("check_employment_remark like", value, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkNotLike(String value) {
            addCriterion("check_employment_remark not like", value, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkIn(List<String> values) {
            addCriterion("check_employment_remark in", values, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkNotIn(List<String> values) {
            addCriterion("check_employment_remark not in", values, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkBetween(String value1, String value2) {
            addCriterion("check_employment_remark between", value1, value2, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckEmploymentRemarkNotBetween(String value1, String value2) {
            addCriterion("check_employment_remark not between", value1, value2, "checkEmploymentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkIsNull() {
            addCriterion("check_attachment_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkIsNotNull() {
            addCriterion("check_attachment_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkEqualTo(String value) {
            addCriterion("check_attachment_remark =", value, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkNotEqualTo(String value) {
            addCriterion("check_attachment_remark <>", value, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkGreaterThan(String value) {
            addCriterion("check_attachment_remark >", value, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_attachment_remark >=", value, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkLessThan(String value) {
            addCriterion("check_attachment_remark <", value, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_attachment_remark <=", value, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkLike(String value) {
            addCriterion("check_attachment_remark like", value, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkNotLike(String value) {
            addCriterion("check_attachment_remark not like", value, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkIn(List<String> values) {
            addCriterion("check_attachment_remark in", values, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkNotIn(List<String> values) {
            addCriterion("check_attachment_remark not in", values, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkBetween(String value1, String value2) {
            addCriterion("check_attachment_remark between", value1, value2, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAttachmentRemarkNotBetween(String value1, String value2) {
            addCriterion("check_attachment_remark not between", value1, value2, "checkAttachmentRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusIsNull() {
            addCriterion("check_blacklist_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusIsNotNull() {
            addCriterion("check_blacklist_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusEqualTo(String value) {
            addCriterion("check_blacklist_status =", value, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusNotEqualTo(String value) {
            addCriterion("check_blacklist_status <>", value, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusGreaterThan(String value) {
            addCriterion("check_blacklist_status >", value, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_blacklist_status >=", value, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusLessThan(String value) {
            addCriterion("check_blacklist_status <", value, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusLessThanOrEqualTo(String value) {
            addCriterion("check_blacklist_status <=", value, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusLike(String value) {
            addCriterion("check_blacklist_status like", value, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusNotLike(String value) {
            addCriterion("check_blacklist_status not like", value, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusIn(List<String> values) {
            addCriterion("check_blacklist_status in", values, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusNotIn(List<String> values) {
            addCriterion("check_blacklist_status not in", values, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusBetween(String value1, String value2) {
            addCriterion("check_blacklist_status between", value1, value2, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistStatusNotBetween(String value1, String value2) {
            addCriterion("check_blacklist_status not between", value1, value2, "checkBlacklistStatus");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkIsNull() {
            addCriterion("check_blacklist_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkIsNotNull() {
            addCriterion("check_blacklist_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkEqualTo(String value) {
            addCriterion("check_blacklist_remark =", value, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkNotEqualTo(String value) {
            addCriterion("check_blacklist_remark <>", value, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkGreaterThan(String value) {
            addCriterion("check_blacklist_remark >", value, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_blacklist_remark >=", value, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkLessThan(String value) {
            addCriterion("check_blacklist_remark <", value, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_blacklist_remark <=", value, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkLike(String value) {
            addCriterion("check_blacklist_remark like", value, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkNotLike(String value) {
            addCriterion("check_blacklist_remark not like", value, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkIn(List<String> values) {
            addCriterion("check_blacklist_remark in", values, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkNotIn(List<String> values) {
            addCriterion("check_blacklist_remark not in", values, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkBetween(String value1, String value2) {
            addCriterion("check_blacklist_remark between", value1, value2, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckBlacklistRemarkNotBetween(String value1, String value2) {
            addCriterion("check_blacklist_remark not between", value1, value2, "checkBlacklistRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusIsNull() {
            addCriterion("check_siteInspection_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusIsNotNull() {
            addCriterion("check_siteInspection_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusEqualTo(String value) {
            addCriterion("check_siteInspection_status =", value, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusNotEqualTo(String value) {
            addCriterion("check_siteInspection_status <>", value, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusGreaterThan(String value) {
            addCriterion("check_siteInspection_status >", value, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_siteInspection_status >=", value, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusLessThan(String value) {
            addCriterion("check_siteInspection_status <", value, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusLessThanOrEqualTo(String value) {
            addCriterion("check_siteInspection_status <=", value, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusLike(String value) {
            addCriterion("check_siteInspection_status like", value, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusNotLike(String value) {
            addCriterion("check_siteInspection_status not like", value, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusIn(List<String> values) {
            addCriterion("check_siteInspection_status in", values, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusNotIn(List<String> values) {
            addCriterion("check_siteInspection_status not in", values, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusBetween(String value1, String value2) {
            addCriterion("check_siteInspection_status between", value1, value2, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionStatusNotBetween(String value1, String value2) {
            addCriterion("check_siteInspection_status not between", value1, value2, "checkSiteinspectionStatus");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkIsNull() {
            addCriterion("check_siteInspection_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkIsNotNull() {
            addCriterion("check_siteInspection_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkEqualTo(String value) {
            addCriterion("check_siteInspection_remark =", value, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkNotEqualTo(String value) {
            addCriterion("check_siteInspection_remark <>", value, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkGreaterThan(String value) {
            addCriterion("check_siteInspection_remark >", value, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_siteInspection_remark >=", value, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkLessThan(String value) {
            addCriterion("check_siteInspection_remark <", value, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_siteInspection_remark <=", value, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkLike(String value) {
            addCriterion("check_siteInspection_remark like", value, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkNotLike(String value) {
            addCriterion("check_siteInspection_remark not like", value, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkIn(List<String> values) {
            addCriterion("check_siteInspection_remark in", values, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkNotIn(List<String> values) {
            addCriterion("check_siteInspection_remark not in", values, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkBetween(String value1, String value2) {
            addCriterion("check_siteInspection_remark between", value1, value2, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckSiteinspectionRemarkNotBetween(String value1, String value2) {
            addCriterion("check_siteInspection_remark not between", value1, value2, "checkSiteinspectionRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusIsNull() {
            addCriterion("check_insurance_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusIsNotNull() {
            addCriterion("check_insurance_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusEqualTo(String value) {
            addCriterion("check_insurance_status =", value, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusNotEqualTo(String value) {
            addCriterion("check_insurance_status <>", value, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusGreaterThan(String value) {
            addCriterion("check_insurance_status >", value, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_insurance_status >=", value, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusLessThan(String value) {
            addCriterion("check_insurance_status <", value, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusLessThanOrEqualTo(String value) {
            addCriterion("check_insurance_status <=", value, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusLike(String value) {
            addCriterion("check_insurance_status like", value, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusNotLike(String value) {
            addCriterion("check_insurance_status not like", value, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusIn(List<String> values) {
            addCriterion("check_insurance_status in", values, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusNotIn(List<String> values) {
            addCriterion("check_insurance_status not in", values, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusBetween(String value1, String value2) {
            addCriterion("check_insurance_status between", value1, value2, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceStatusNotBetween(String value1, String value2) {
            addCriterion("check_insurance_status not between", value1, value2, "checkInsuranceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkIsNull() {
            addCriterion("check_insurance_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkIsNotNull() {
            addCriterion("check_insurance_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkEqualTo(String value) {
            addCriterion("check_insurance_remark =", value, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkNotEqualTo(String value) {
            addCriterion("check_insurance_remark <>", value, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkGreaterThan(String value) {
            addCriterion("check_insurance_remark >", value, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_insurance_remark >=", value, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkLessThan(String value) {
            addCriterion("check_insurance_remark <", value, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_insurance_remark <=", value, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkLike(String value) {
            addCriterion("check_insurance_remark like", value, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkNotLike(String value) {
            addCriterion("check_insurance_remark not like", value, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkIn(List<String> values) {
            addCriterion("check_insurance_remark in", values, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkNotIn(List<String> values) {
            addCriterion("check_insurance_remark not in", values, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkBetween(String value1, String value2) {
            addCriterion("check_insurance_remark between", value1, value2, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckInsuranceRemarkNotBetween(String value1, String value2) {
            addCriterion("check_insurance_remark not between", value1, value2, "checkInsuranceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusIsNull() {
            addCriterion("check_allowance_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusIsNotNull() {
            addCriterion("check_allowance_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusEqualTo(String value) {
            addCriterion("check_allowance_status =", value, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusNotEqualTo(String value) {
            addCriterion("check_allowance_status <>", value, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusGreaterThan(String value) {
            addCriterion("check_allowance_status >", value, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_allowance_status >=", value, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusLessThan(String value) {
            addCriterion("check_allowance_status <", value, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusLessThanOrEqualTo(String value) {
            addCriterion("check_allowance_status <=", value, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusLike(String value) {
            addCriterion("check_allowance_status like", value, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusNotLike(String value) {
            addCriterion("check_allowance_status not like", value, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusIn(List<String> values) {
            addCriterion("check_allowance_status in", values, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusNotIn(List<String> values) {
            addCriterion("check_allowance_status not in", values, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusBetween(String value1, String value2) {
            addCriterion("check_allowance_status between", value1, value2, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceStatusNotBetween(String value1, String value2) {
            addCriterion("check_allowance_status not between", value1, value2, "checkAllowanceStatus");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkIsNull() {
            addCriterion("check_allowance_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkIsNotNull() {
            addCriterion("check_allowance_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkEqualTo(String value) {
            addCriterion("check_allowance_remark =", value, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkNotEqualTo(String value) {
            addCriterion("check_allowance_remark <>", value, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkGreaterThan(String value) {
            addCriterion("check_allowance_remark >", value, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_allowance_remark >=", value, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkLessThan(String value) {
            addCriterion("check_allowance_remark <", value, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_allowance_remark <=", value, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkLike(String value) {
            addCriterion("check_allowance_remark like", value, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkNotLike(String value) {
            addCriterion("check_allowance_remark not like", value, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkIn(List<String> values) {
            addCriterion("check_allowance_remark in", values, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkNotIn(List<String> values) {
            addCriterion("check_allowance_remark not in", values, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkBetween(String value1, String value2) {
            addCriterion("check_allowance_remark between", value1, value2, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckAllowanceRemarkNotBetween(String value1, String value2) {
            addCriterion("check_allowance_remark not between", value1, value2, "checkAllowanceRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusIsNull() {
            addCriterion("check_cgss_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusIsNotNull() {
            addCriterion("check_cgss_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusEqualTo(String value) {
            addCriterion("check_cgss_status =", value, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusNotEqualTo(String value) {
            addCriterion("check_cgss_status <>", value, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusGreaterThan(String value) {
            addCriterion("check_cgss_status >", value, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_cgss_status >=", value, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusLessThan(String value) {
            addCriterion("check_cgss_status <", value, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusLessThanOrEqualTo(String value) {
            addCriterion("check_cgss_status <=", value, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusLike(String value) {
            addCriterion("check_cgss_status like", value, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusNotLike(String value) {
            addCriterion("check_cgss_status not like", value, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusIn(List<String> values) {
            addCriterion("check_cgss_status in", values, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusNotIn(List<String> values) {
            addCriterion("check_cgss_status not in", values, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusBetween(String value1, String value2) {
            addCriterion("check_cgss_status between", value1, value2, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssStatusNotBetween(String value1, String value2) {
            addCriterion("check_cgss_status not between", value1, value2, "checkCgssStatus");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkIsNull() {
            addCriterion("check_cgss_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkIsNotNull() {
            addCriterion("check_cgss_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkEqualTo(String value) {
            addCriterion("check_cgss_remark =", value, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkNotEqualTo(String value) {
            addCriterion("check_cgss_remark <>", value, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkGreaterThan(String value) {
            addCriterion("check_cgss_remark >", value, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_cgss_remark >=", value, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkLessThan(String value) {
            addCriterion("check_cgss_remark <", value, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_cgss_remark <=", value, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkLike(String value) {
            addCriterion("check_cgss_remark like", value, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkNotLike(String value) {
            addCriterion("check_cgss_remark not like", value, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkIn(List<String> values) {
            addCriterion("check_cgss_remark in", values, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkNotIn(List<String> values) {
            addCriterion("check_cgss_remark not in", values, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkBetween(String value1, String value2) {
            addCriterion("check_cgss_remark between", value1, value2, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckCgssRemarkNotBetween(String value1, String value2) {
            addCriterion("check_cgss_remark not between", value1, value2, "checkCgssRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusIsNull() {
            addCriterion("check_violationlaborlaws_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusIsNotNull() {
            addCriterion("check_violationlaborlaws_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusEqualTo(String value) {
            addCriterion("check_violationlaborlaws_status =", value, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusNotEqualTo(String value) {
            addCriterion("check_violationlaborlaws_status <>", value, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusGreaterThan(String value) {
            addCriterion("check_violationlaborlaws_status >", value, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_violationlaborlaws_status >=", value, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusLessThan(String value) {
            addCriterion("check_violationlaborlaws_status <", value, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusLessThanOrEqualTo(String value) {
            addCriterion("check_violationlaborlaws_status <=", value, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusLike(String value) {
            addCriterion("check_violationlaborlaws_status like", value, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusNotLike(String value) {
            addCriterion("check_violationlaborlaws_status not like", value, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusIn(List<String> values) {
            addCriterion("check_violationlaborlaws_status in", values, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusNotIn(List<String> values) {
            addCriterion("check_violationlaborlaws_status not in", values, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusBetween(String value1, String value2) {
            addCriterion("check_violationlaborlaws_status between", value1, value2, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsStatusNotBetween(String value1, String value2) {
            addCriterion("check_violationlaborlaws_status not between", value1, value2, "checkViolationlaborlawsStatus");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkIsNull() {
            addCriterion("check_violationlaborlaws_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkIsNotNull() {
            addCriterion("check_violationlaborlaws_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkEqualTo(String value) {
            addCriterion("check_violationlaborlaws_remark =", value, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkNotEqualTo(String value) {
            addCriterion("check_violationlaborlaws_remark <>", value, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkGreaterThan(String value) {
            addCriterion("check_violationlaborlaws_remark >", value, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_violationlaborlaws_remark >=", value, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkLessThan(String value) {
            addCriterion("check_violationlaborlaws_remark <", value, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_violationlaborlaws_remark <=", value, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkLike(String value) {
            addCriterion("check_violationlaborlaws_remark like", value, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkNotLike(String value) {
            addCriterion("check_violationlaborlaws_remark not like", value, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkIn(List<String> values) {
            addCriterion("check_violationlaborlaws_remark in", values, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkNotIn(List<String> values) {
            addCriterion("check_violationlaborlaws_remark not in", values, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkBetween(String value1, String value2) {
            addCriterion("check_violationlaborlaws_remark between", value1, value2, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andCheckViolationlaborlawsRemarkNotBetween(String value1, String value2) {
            addCriterion("check_violationlaborlaws_remark not between", value1, value2, "checkViolationlaborlawsRemark");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberIsNull() {
            addCriterion("official_document_number is null");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberIsNotNull() {
            addCriterion("official_document_number is not null");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberEqualTo(String value) {
            addCriterion("official_document_number =", value, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberNotEqualTo(String value) {
            addCriterion("official_document_number <>", value, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberGreaterThan(String value) {
            addCriterion("official_document_number >", value, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("official_document_number >=", value, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberLessThan(String value) {
            addCriterion("official_document_number <", value, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberLessThanOrEqualTo(String value) {
            addCriterion("official_document_number <=", value, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberLike(String value) {
            addCriterion("official_document_number like", value, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberNotLike(String value) {
            addCriterion("official_document_number not like", value, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberIn(List<String> values) {
            addCriterion("official_document_number in", values, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberNotIn(List<String> values) {
            addCriterion("official_document_number not in", values, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberBetween(String value1, String value2) {
            addCriterion("official_document_number between", value1, value2, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andOfficialDocumentNumberNotBetween(String value1, String value2) {
            addCriterion("official_document_number not between", value1, value2, "officialDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionIsNull() {
            addCriterion("case_description is null");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionIsNotNull() {
            addCriterion("case_description is not null");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionEqualTo(String value) {
            addCriterion("case_description =", value, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionNotEqualTo(String value) {
            addCriterion("case_description <>", value, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionGreaterThan(String value) {
            addCriterion("case_description >", value, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("case_description >=", value, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionLessThan(String value) {
            addCriterion("case_description <", value, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionLessThanOrEqualTo(String value) {
            addCriterion("case_description <=", value, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionLike(String value) {
            addCriterion("case_description like", value, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionNotLike(String value) {
            addCriterion("case_description not like", value, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionIn(List<String> values) {
            addCriterion("case_description in", values, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionNotIn(List<String> values) {
            addCriterion("case_description not in", values, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionBetween(String value1, String value2) {
            addCriterion("case_description between", value1, value2, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andCaseDescriptionNotBetween(String value1, String value2) {
            addCriterion("case_description not between", value1, value2, "caseDescription");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdIsNull() {
            addCriterion("allowance_id is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdIsNotNull() {
            addCriterion("allowance_id is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdEqualTo(String value) {
            addCriterion("allowance_id =", value, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdNotEqualTo(String value) {
            addCriterion("allowance_id <>", value, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdGreaterThan(String value) {
            addCriterion("allowance_id >", value, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_id >=", value, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdLessThan(String value) {
            addCriterion("allowance_id <", value, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdLessThanOrEqualTo(String value) {
            addCriterion("allowance_id <=", value, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdLike(String value) {
            addCriterion("allowance_id like", value, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdNotLike(String value) {
            addCriterion("allowance_id not like", value, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdIn(List<String> values) {
            addCriterion("allowance_id in", values, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdNotIn(List<String> values) {
            addCriterion("allowance_id not in", values, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdBetween(String value1, String value2) {
            addCriterion("allowance_id between", value1, value2, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceIdNotBetween(String value1, String value2) {
            addCriterion("allowance_id not between", value1, value2, "allowanceId");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsIsNull() {
            addCriterion("allowance_amounts is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsIsNotNull() {
            addCriterion("allowance_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsEqualTo(Integer value) {
            addCriterion("allowance_amounts =", value, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsNotEqualTo(Integer value) {
            addCriterion("allowance_amounts <>", value, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsGreaterThan(Integer value) {
            addCriterion("allowance_amounts >", value, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("allowance_amounts >=", value, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsLessThan(Integer value) {
            addCriterion("allowance_amounts <", value, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("allowance_amounts <=", value, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsIn(List<Integer> values) {
            addCriterion("allowance_amounts in", values, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsNotIn(List<Integer> values) {
            addCriterion("allowance_amounts not in", values, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsBetween(Integer value1, Integer value2) {
            addCriterion("allowance_amounts between", value1, value2, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("allowance_amounts not between", value1, value2, "allowanceAmounts");
            return (Criteria) this;
        }

        public Criteria andCountersignIdIsNull() {
            addCriterion("countersign_id is null");
            return (Criteria) this;
        }

        public Criteria andCountersignIdIsNotNull() {
            addCriterion("countersign_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountersignIdEqualTo(String value) {
            addCriterion("countersign_id =", value, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdNotEqualTo(String value) {
            addCriterion("countersign_id <>", value, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdGreaterThan(String value) {
            addCriterion("countersign_id >", value, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdGreaterThanOrEqualTo(String value) {
            addCriterion("countersign_id >=", value, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdLessThan(String value) {
            addCriterion("countersign_id <", value, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdLessThanOrEqualTo(String value) {
            addCriterion("countersign_id <=", value, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdLike(String value) {
            addCriterion("countersign_id like", value, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdNotLike(String value) {
            addCriterion("countersign_id not like", value, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdIn(List<String> values) {
            addCriterion("countersign_id in", values, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdNotIn(List<String> values) {
            addCriterion("countersign_id not in", values, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdBetween(String value1, String value2) {
            addCriterion("countersign_id between", value1, value2, "countersignId");
            return (Criteria) this;
        }

        public Criteria andCountersignIdNotBetween(String value1, String value2) {
            addCriterion("countersign_id not between", value1, value2, "countersignId");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameIsNull() {
            addCriterion("allowance_company_name is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameIsNotNull() {
            addCriterion("allowance_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameEqualTo(String value) {
            addCriterion("allowance_company_name =", value, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameNotEqualTo(String value) {
            addCriterion("allowance_company_name <>", value, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameGreaterThan(String value) {
            addCriterion("allowance_company_name >", value, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_company_name >=", value, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameLessThan(String value) {
            addCriterion("allowance_company_name <", value, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("allowance_company_name <=", value, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameLike(String value) {
            addCriterion("allowance_company_name like", value, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameNotLike(String value) {
            addCriterion("allowance_company_name not like", value, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameIn(List<String> values) {
            addCriterion("allowance_company_name in", values, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameNotIn(List<String> values) {
            addCriterion("allowance_company_name not in", values, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameBetween(String value1, String value2) {
            addCriterion("allowance_company_name between", value1, value2, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceCompanyNameNotBetween(String value1, String value2) {
            addCriterion("allowance_company_name not between", value1, value2, "allowanceCompanyName");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqIsNull() {
            addCriterion("allowance_seq is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqIsNotNull() {
            addCriterion("allowance_seq is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqEqualTo(String value) {
            addCriterion("allowance_seq =", value, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqNotEqualTo(String value) {
            addCriterion("allowance_seq <>", value, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqGreaterThan(String value) {
            addCriterion("allowance_seq >", value, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_seq >=", value, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqLessThan(String value) {
            addCriterion("allowance_seq <", value, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqLessThanOrEqualTo(String value) {
            addCriterion("allowance_seq <=", value, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqLike(String value) {
            addCriterion("allowance_seq like", value, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqNotLike(String value) {
            addCriterion("allowance_seq not like", value, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqIn(List<String> values) {
            addCriterion("allowance_seq in", values, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqNotIn(List<String> values) {
            addCriterion("allowance_seq not in", values, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqBetween(String value1, String value2) {
            addCriterion("allowance_seq between", value1, value2, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowanceSeqNotBetween(String value1, String value2) {
            addCriterion("allowance_seq not between", value1, value2, "allowanceSeq");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameIsNull() {
            addCriterion("allowance_plan_name is null");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameIsNotNull() {
            addCriterion("allowance_plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameEqualTo(String value) {
            addCriterion("allowance_plan_name =", value, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameNotEqualTo(String value) {
            addCriterion("allowance_plan_name <>", value, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameGreaterThan(String value) {
            addCriterion("allowance_plan_name >", value, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_plan_name >=", value, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameLessThan(String value) {
            addCriterion("allowance_plan_name <", value, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameLessThanOrEqualTo(String value) {
            addCriterion("allowance_plan_name <=", value, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameLike(String value) {
            addCriterion("allowance_plan_name like", value, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameNotLike(String value) {
            addCriterion("allowance_plan_name not like", value, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameIn(List<String> values) {
            addCriterion("allowance_plan_name in", values, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameNotIn(List<String> values) {
            addCriterion("allowance_plan_name not in", values, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameBetween(String value1, String value2) {
            addCriterion("allowance_plan_name between", value1, value2, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowancePlanNameNotBetween(String value1, String value2) {
            addCriterion("allowance_plan_name not between", value1, value2, "allowancePlanName");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeIsNull() {
            addCriterion("allowance_apply_time is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeIsNotNull() {
            addCriterion("allowance_apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeEqualTo(String value) {
            addCriterion("allowance_apply_time =", value, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeNotEqualTo(String value) {
            addCriterion("allowance_apply_time <>", value, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeGreaterThan(String value) {
            addCriterion("allowance_apply_time >", value, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_apply_time >=", value, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeLessThan(String value) {
            addCriterion("allowance_apply_time <", value, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeLessThanOrEqualTo(String value) {
            addCriterion("allowance_apply_time <=", value, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeLike(String value) {
            addCriterion("allowance_apply_time like", value, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeNotLike(String value) {
            addCriterion("allowance_apply_time not like", value, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeIn(List<String> values) {
            addCriterion("allowance_apply_time in", values, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeNotIn(List<String> values) {
            addCriterion("allowance_apply_time not in", values, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeBetween(String value1, String value2) {
            addCriterion("allowance_apply_time between", value1, value2, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyTimeNotBetween(String value1, String value2) {
            addCriterion("allowance_apply_time not between", value1, value2, "allowanceApplyTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeIsNull() {
            addCriterion("allowance_apply_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeIsNotNull() {
            addCriterion("allowance_apply_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeEqualTo(String value) {
            addCriterion("allowance_apply_start_time =", value, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeNotEqualTo(String value) {
            addCriterion("allowance_apply_start_time <>", value, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeGreaterThan(String value) {
            addCriterion("allowance_apply_start_time >", value, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_apply_start_time >=", value, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeLessThan(String value) {
            addCriterion("allowance_apply_start_time <", value, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeLessThanOrEqualTo(String value) {
            addCriterion("allowance_apply_start_time <=", value, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeLike(String value) {
            addCriterion("allowance_apply_start_time like", value, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeNotLike(String value) {
            addCriterion("allowance_apply_start_time not like", value, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeIn(List<String> values) {
            addCriterion("allowance_apply_start_time in", values, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeNotIn(List<String> values) {
            addCriterion("allowance_apply_start_time not in", values, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeBetween(String value1, String value2) {
            addCriterion("allowance_apply_start_time between", value1, value2, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyStartTimeNotBetween(String value1, String value2) {
            addCriterion("allowance_apply_start_time not between", value1, value2, "allowanceApplyStartTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeIsNull() {
            addCriterion("allowance_apply_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeIsNotNull() {
            addCriterion("allowance_apply_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeEqualTo(String value) {
            addCriterion("allowance_apply_end_time =", value, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeNotEqualTo(String value) {
            addCriterion("allowance_apply_end_time <>", value, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeGreaterThan(String value) {
            addCriterion("allowance_apply_end_time >", value, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_apply_end_time >=", value, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeLessThan(String value) {
            addCriterion("allowance_apply_end_time <", value, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeLessThanOrEqualTo(String value) {
            addCriterion("allowance_apply_end_time <=", value, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeLike(String value) {
            addCriterion("allowance_apply_end_time like", value, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeNotLike(String value) {
            addCriterion("allowance_apply_end_time not like", value, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeIn(List<String> values) {
            addCriterion("allowance_apply_end_time in", values, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeNotIn(List<String> values) {
            addCriterion("allowance_apply_end_time not in", values, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeBetween(String value1, String value2) {
            addCriterion("allowance_apply_end_time between", value1, value2, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApplyEndTimeNotBetween(String value1, String value2) {
            addCriterion("allowance_apply_end_time not between", value1, value2, "allowanceApplyEndTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsIsNull() {
            addCriterion("allowance_total_amounts is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsIsNotNull() {
            addCriterion("allowance_total_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsEqualTo(Integer value) {
            addCriterion("allowance_total_amounts =", value, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsNotEqualTo(Integer value) {
            addCriterion("allowance_total_amounts <>", value, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsGreaterThan(Integer value) {
            addCriterion("allowance_total_amounts >", value, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("allowance_total_amounts >=", value, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsLessThan(Integer value) {
            addCriterion("allowance_total_amounts <", value, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("allowance_total_amounts <=", value, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsIn(List<Integer> values) {
            addCriterion("allowance_total_amounts in", values, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsNotIn(List<Integer> values) {
            addCriterion("allowance_total_amounts not in", values, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsBetween(Integer value1, Integer value2) {
            addCriterion("allowance_total_amounts between", value1, value2, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceTotalAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("allowance_total_amounts not between", value1, value2, "allowanceTotalAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsIsNull() {
            addCriterion("allowance_approve_amounts is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsIsNotNull() {
            addCriterion("allowance_approve_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsEqualTo(Integer value) {
            addCriterion("allowance_approve_amounts =", value, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsNotEqualTo(Integer value) {
            addCriterion("allowance_approve_amounts <>", value, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsGreaterThan(Integer value) {
            addCriterion("allowance_approve_amounts >", value, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("allowance_approve_amounts >=", value, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsLessThan(Integer value) {
            addCriterion("allowance_approve_amounts <", value, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("allowance_approve_amounts <=", value, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsIn(List<Integer> values) {
            addCriterion("allowance_approve_amounts in", values, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsNotIn(List<Integer> values) {
            addCriterion("allowance_approve_amounts not in", values, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsBetween(Integer value1, Integer value2) {
            addCriterion("allowance_approve_amounts between", value1, value2, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("allowance_approve_amounts not between", value1, value2, "allowanceApproveAmounts");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdIsNull() {
            addCriterion("allowance_approve_id is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdIsNotNull() {
            addCriterion("allowance_approve_id is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdEqualTo(String value) {
            addCriterion("allowance_approve_id =", value, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdNotEqualTo(String value) {
            addCriterion("allowance_approve_id <>", value, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdGreaterThan(String value) {
            addCriterion("allowance_approve_id >", value, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_approve_id >=", value, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdLessThan(String value) {
            addCriterion("allowance_approve_id <", value, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdLessThanOrEqualTo(String value) {
            addCriterion("allowance_approve_id <=", value, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdLike(String value) {
            addCriterion("allowance_approve_id like", value, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdNotLike(String value) {
            addCriterion("allowance_approve_id not like", value, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdIn(List<String> values) {
            addCriterion("allowance_approve_id in", values, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdNotIn(List<String> values) {
            addCriterion("allowance_approve_id not in", values, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdBetween(String value1, String value2) {
            addCriterion("allowance_approve_id between", value1, value2, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveIdNotBetween(String value1, String value2) {
            addCriterion("allowance_approve_id not between", value1, value2, "allowanceApproveId");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeIsNull() {
            addCriterion("allowance_approve_time is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeIsNotNull() {
            addCriterion("allowance_approve_time is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeEqualTo(String value) {
            addCriterion("allowance_approve_time =", value, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeNotEqualTo(String value) {
            addCriterion("allowance_approve_time <>", value, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeGreaterThan(String value) {
            addCriterion("allowance_approve_time >", value, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_approve_time >=", value, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeLessThan(String value) {
            addCriterion("allowance_approve_time <", value, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeLessThanOrEqualTo(String value) {
            addCriterion("allowance_approve_time <=", value, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeLike(String value) {
            addCriterion("allowance_approve_time like", value, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeNotLike(String value) {
            addCriterion("allowance_approve_time not like", value, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeIn(List<String> values) {
            addCriterion("allowance_approve_time in", values, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeNotIn(List<String> values) {
            addCriterion("allowance_approve_time not in", values, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeBetween(String value1, String value2) {
            addCriterion("allowance_approve_time between", value1, value2, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceApproveTimeNotBetween(String value1, String value2) {
            addCriterion("allowance_approve_time not between", value1, value2, "allowanceApproveTime");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkIsNull() {
            addCriterion("allowance_remark is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkIsNotNull() {
            addCriterion("allowance_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkEqualTo(String value) {
            addCriterion("allowance_remark =", value, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkNotEqualTo(String value) {
            addCriterion("allowance_remark <>", value, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkGreaterThan(String value) {
            addCriterion("allowance_remark >", value, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_remark >=", value, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkLessThan(String value) {
            addCriterion("allowance_remark <", value, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkLessThanOrEqualTo(String value) {
            addCriterion("allowance_remark <=", value, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkLike(String value) {
            addCriterion("allowance_remark like", value, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkNotLike(String value) {
            addCriterion("allowance_remark not like", value, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkIn(List<String> values) {
            addCriterion("allowance_remark in", values, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkNotIn(List<String> values) {
            addCriterion("allowance_remark not in", values, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkBetween(String value1, String value2) {
            addCriterion("allowance_remark between", value1, value2, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceRemarkNotBetween(String value1, String value2) {
            addCriterion("allowance_remark not between", value1, value2, "allowanceRemark");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordIsNull() {
            addCriterion("allowance_frequency_record is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordIsNotNull() {
            addCriterion("allowance_frequency_record is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordEqualTo(String value) {
            addCriterion("allowance_frequency_record =", value, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordNotEqualTo(String value) {
            addCriterion("allowance_frequency_record <>", value, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordGreaterThan(String value) {
            addCriterion("allowance_frequency_record >", value, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordGreaterThanOrEqualTo(String value) {
            addCriterion("allowance_frequency_record >=", value, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordLessThan(String value) {
            addCriterion("allowance_frequency_record <", value, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordLessThanOrEqualTo(String value) {
            addCriterion("allowance_frequency_record <=", value, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordLike(String value) {
            addCriterion("allowance_frequency_record like", value, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordNotLike(String value) {
            addCriterion("allowance_frequency_record not like", value, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordIn(List<String> values) {
            addCriterion("allowance_frequency_record in", values, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordNotIn(List<String> values) {
            addCriterion("allowance_frequency_record not in", values, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordBetween(String value1, String value2) {
            addCriterion("allowance_frequency_record between", value1, value2, "allowanceFrequencyRecord");
            return (Criteria) this;
        }

        public Criteria andAllowanceFrequencyRecordNotBetween(String value1, String value2) {
            addCriterion("allowance_frequency_record not between", value1, value2, "allowanceFrequencyRecord");
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