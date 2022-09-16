package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvancedAgePlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvancedAgePlanExample() {
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

        public Criteria andAdvancedAgeApplyIdIsNull() {
            addCriterion("advanced_age_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdIsNotNull() {
            addCriterion("advanced_age_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdEqualTo(Integer value) {
            addCriterion("advanced_age_apply_id =", value, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdNotEqualTo(Integer value) {
            addCriterion("advanced_age_apply_id <>", value, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdGreaterThan(Integer value) {
            addCriterion("advanced_age_apply_id >", value, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_apply_id >=", value, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdLessThan(Integer value) {
            addCriterion("advanced_age_apply_id <", value, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_apply_id <=", value, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdIn(List<Integer> values) {
            addCriterion("advanced_age_apply_id in", values, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdNotIn(List<Integer> values) {
            addCriterion("advanced_age_apply_id not in", values, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_apply_id between", value1, value2, "advancedAgeApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_apply_id not between", value1, value2, "advancedAgeApplyId");
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

        public Criteria andCompanyCreateTimeIsNull() {
            addCriterion("company_create_time is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeIsNotNull() {
            addCriterion("company_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeEqualTo(String value) {
            addCriterion("company_create_time =", value, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeNotEqualTo(String value) {
            addCriterion("company_create_time <>", value, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeGreaterThan(String value) {
            addCriterion("company_create_time >", value, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("company_create_time >=", value, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeLessThan(String value) {
            addCriterion("company_create_time <", value, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("company_create_time <=", value, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeLike(String value) {
            addCriterion("company_create_time like", value, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeNotLike(String value) {
            addCriterion("company_create_time not like", value, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeIn(List<String> values) {
            addCriterion("company_create_time in", values, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeNotIn(List<String> values) {
            addCriterion("company_create_time not in", values, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeBetween(String value1, String value2) {
            addCriterion("company_create_time between", value1, value2, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateTimeNotBetween(String value1, String value2) {
            addCriterion("company_create_time not between", value1, value2, "companyCreateTime");
            return (Criteria) this;
        }

        public Criteria andItemsIsNull() {
            addCriterion("items is null");
            return (Criteria) this;
        }

        public Criteria andItemsIsNotNull() {
            addCriterion("items is not null");
            return (Criteria) this;
        }

        public Criteria andItemsEqualTo(String value) {
            addCriterion("items =", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsNotEqualTo(String value) {
            addCriterion("items <>", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsGreaterThan(String value) {
            addCriterion("items >", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsGreaterThanOrEqualTo(String value) {
            addCriterion("items >=", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsLessThan(String value) {
            addCriterion("items <", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsLessThanOrEqualTo(String value) {
            addCriterion("items <=", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsLike(String value) {
            addCriterion("items like", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsNotLike(String value) {
            addCriterion("items not like", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsIn(List<String> values) {
            addCriterion("items in", values, "items");
            return (Criteria) this;
        }

        public Criteria andItemsNotIn(List<String> values) {
            addCriterion("items not in", values, "items");
            return (Criteria) this;
        }

        public Criteria andItemsBetween(String value1, String value2) {
            addCriterion("items between", value1, value2, "items");
            return (Criteria) this;
        }

        public Criteria andItemsNotBetween(String value1, String value2) {
            addCriterion("items not between", value1, value2, "items");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberIsNull() {
            addCriterion("employment_number is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberIsNotNull() {
            addCriterion("employment_number is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberEqualTo(Integer value) {
            addCriterion("employment_number =", value, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberNotEqualTo(Integer value) {
            addCriterion("employment_number <>", value, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberGreaterThan(Integer value) {
            addCriterion("employment_number >", value, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("employment_number >=", value, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberLessThan(Integer value) {
            addCriterion("employment_number <", value, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("employment_number <=", value, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberIn(List<Integer> values) {
            addCriterion("employment_number in", values, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberNotIn(List<Integer> values) {
            addCriterion("employment_number not in", values, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberBetween(Integer value1, Integer value2) {
            addCriterion("employment_number between", value1, value2, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andEmploymentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("employment_number not between", value1, value2, "employmentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberIsNull() {
            addCriterion("high_employment_number is null");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberIsNotNull() {
            addCriterion("high_employment_number is not null");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberEqualTo(Integer value) {
            addCriterion("high_employment_number =", value, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberNotEqualTo(Integer value) {
            addCriterion("high_employment_number <>", value, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberGreaterThan(Integer value) {
            addCriterion("high_employment_number >", value, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_employment_number >=", value, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberLessThan(Integer value) {
            addCriterion("high_employment_number <", value, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("high_employment_number <=", value, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberIn(List<Integer> values) {
            addCriterion("high_employment_number in", values, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberNotIn(List<Integer> values) {
            addCriterion("high_employment_number not in", values, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberBetween(Integer value1, Integer value2) {
            addCriterion("high_employment_number between", value1, value2, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andHighEmploymentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("high_employment_number not between", value1, value2, "highEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberIsNull() {
            addCriterion("middle_employment_number is null");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberIsNotNull() {
            addCriterion("middle_employment_number is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberEqualTo(Integer value) {
            addCriterion("middle_employment_number =", value, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberNotEqualTo(Integer value) {
            addCriterion("middle_employment_number <>", value, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberGreaterThan(Integer value) {
            addCriterion("middle_employment_number >", value, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("middle_employment_number >=", value, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberLessThan(Integer value) {
            addCriterion("middle_employment_number <", value, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("middle_employment_number <=", value, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberIn(List<Integer> values) {
            addCriterion("middle_employment_number in", values, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberNotIn(List<Integer> values) {
            addCriterion("middle_employment_number not in", values, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberBetween(Integer value1, Integer value2) {
            addCriterion("middle_employment_number between", value1, value2, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andMiddleEmploymentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("middle_employment_number not between", value1, value2, "middleEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberIsNull() {
            addCriterion("low_employment_number is null");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberIsNotNull() {
            addCriterion("low_employment_number is not null");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberEqualTo(Integer value) {
            addCriterion("low_employment_number =", value, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberNotEqualTo(Integer value) {
            addCriterion("low_employment_number <>", value, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberGreaterThan(Integer value) {
            addCriterion("low_employment_number >", value, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_employment_number >=", value, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberLessThan(Integer value) {
            addCriterion("low_employment_number <", value, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("low_employment_number <=", value, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberIn(List<Integer> values) {
            addCriterion("low_employment_number in", values, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberNotIn(List<Integer> values) {
            addCriterion("low_employment_number not in", values, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberBetween(Integer value1, Integer value2) {
            addCriterion("low_employment_number between", value1, value2, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowEmploymentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("low_employment_number not between", value1, value2, "lowEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresIsNull() {
            addCriterion("friendly_measures is null");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresIsNotNull() {
            addCriterion("friendly_measures is not null");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresEqualTo(String value) {
            addCriterion("friendly_measures =", value, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresNotEqualTo(String value) {
            addCriterion("friendly_measures <>", value, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresGreaterThan(String value) {
            addCriterion("friendly_measures >", value, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresGreaterThanOrEqualTo(String value) {
            addCriterion("friendly_measures >=", value, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresLessThan(String value) {
            addCriterion("friendly_measures <", value, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresLessThanOrEqualTo(String value) {
            addCriterion("friendly_measures <=", value, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresLike(String value) {
            addCriterion("friendly_measures like", value, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresNotLike(String value) {
            addCriterion("friendly_measures not like", value, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresIn(List<String> values) {
            addCriterion("friendly_measures in", values, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresNotIn(List<String> values) {
            addCriterion("friendly_measures not in", values, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresBetween(String value1, String value2) {
            addCriterion("friendly_measures between", value1, value2, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andFriendlyMeasuresNotBetween(String value1, String value2) {
            addCriterion("friendly_measures not between", value1, value2, "friendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresIsNull() {
            addCriterion("attach_friendly_measures is null");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresIsNotNull() {
            addCriterion("attach_friendly_measures is not null");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresEqualTo(String value) {
            addCriterion("attach_friendly_measures =", value, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresNotEqualTo(String value) {
            addCriterion("attach_friendly_measures <>", value, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresGreaterThan(String value) {
            addCriterion("attach_friendly_measures >", value, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresGreaterThanOrEqualTo(String value) {
            addCriterion("attach_friendly_measures >=", value, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresLessThan(String value) {
            addCriterion("attach_friendly_measures <", value, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresLessThanOrEqualTo(String value) {
            addCriterion("attach_friendly_measures <=", value, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresLike(String value) {
            addCriterion("attach_friendly_measures like", value, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresNotLike(String value) {
            addCriterion("attach_friendly_measures not like", value, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresIn(List<String> values) {
            addCriterion("attach_friendly_measures in", values, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresNotIn(List<String> values) {
            addCriterion("attach_friendly_measures not in", values, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresBetween(String value1, String value2) {
            addCriterion("attach_friendly_measures between", value1, value2, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachFriendlyMeasuresNotBetween(String value1, String value2) {
            addCriterion("attach_friendly_measures not between", value1, value2, "attachFriendlyMeasures");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberIsNull() {
            addCriterion("near_high_employment_number is null");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberIsNotNull() {
            addCriterion("near_high_employment_number is not null");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberEqualTo(Integer value) {
            addCriterion("near_high_employment_number =", value, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberNotEqualTo(Integer value) {
            addCriterion("near_high_employment_number <>", value, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberGreaterThan(Integer value) {
            addCriterion("near_high_employment_number >", value, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("near_high_employment_number >=", value, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberLessThan(Integer value) {
            addCriterion("near_high_employment_number <", value, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("near_high_employment_number <=", value, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberIn(List<Integer> values) {
            addCriterion("near_high_employment_number in", values, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberNotIn(List<Integer> values) {
            addCriterion("near_high_employment_number not in", values, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberBetween(Integer value1, Integer value2) {
            addCriterion("near_high_employment_number between", value1, value2, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andNearHighEmploymentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("near_high_employment_number not between", value1, value2, "nearHighEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberIsNull() {
            addCriterion("continue_employment_number is null");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberIsNotNull() {
            addCriterion("continue_employment_number is not null");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberEqualTo(Integer value) {
            addCriterion("continue_employment_number =", value, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberNotEqualTo(Integer value) {
            addCriterion("continue_employment_number <>", value, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberGreaterThan(Integer value) {
            addCriterion("continue_employment_number >", value, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("continue_employment_number >=", value, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberLessThan(Integer value) {
            addCriterion("continue_employment_number <", value, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("continue_employment_number <=", value, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberIn(List<Integer> values) {
            addCriterion("continue_employment_number in", values, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberNotIn(List<Integer> values) {
            addCriterion("continue_employment_number not in", values, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberBetween(Integer value1, Integer value2) {
            addCriterion("continue_employment_number between", value1, value2, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("continue_employment_number not between", value1, value2, "continueEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageIsNull() {
            addCriterion("continue_employment_percentage is null");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageIsNotNull() {
            addCriterion("continue_employment_percentage is not null");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageEqualTo(Double value) {
            addCriterion("continue_employment_percentage =", value, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageNotEqualTo(Double value) {
            addCriterion("continue_employment_percentage <>", value, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageGreaterThan(Double value) {
            addCriterion("continue_employment_percentage >", value, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageGreaterThanOrEqualTo(Double value) {
            addCriterion("continue_employment_percentage >=", value, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageLessThan(Double value) {
            addCriterion("continue_employment_percentage <", value, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageLessThanOrEqualTo(Double value) {
            addCriterion("continue_employment_percentage <=", value, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageIn(List<Double> values) {
            addCriterion("continue_employment_percentage in", values, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageNotIn(List<Double> values) {
            addCriterion("continue_employment_percentage not in", values, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageBetween(Double value1, Double value2) {
            addCriterion("continue_employment_percentage between", value1, value2, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andContinueEmploymentPercentageNotBetween(Double value1, Double value2) {
            addCriterion("continue_employment_percentage not between", value1, value2, "continueEmploymentPercentage");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresIsNull() {
            addCriterion("assistance_measures is null");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresIsNotNull() {
            addCriterion("assistance_measures is not null");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresEqualTo(String value) {
            addCriterion("assistance_measures =", value, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresNotEqualTo(String value) {
            addCriterion("assistance_measures <>", value, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresGreaterThan(String value) {
            addCriterion("assistance_measures >", value, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresGreaterThanOrEqualTo(String value) {
            addCriterion("assistance_measures >=", value, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresLessThan(String value) {
            addCriterion("assistance_measures <", value, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresLessThanOrEqualTo(String value) {
            addCriterion("assistance_measures <=", value, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresLike(String value) {
            addCriterion("assistance_measures like", value, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresNotLike(String value) {
            addCriterion("assistance_measures not like", value, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresIn(List<String> values) {
            addCriterion("assistance_measures in", values, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresNotIn(List<String> values) {
            addCriterion("assistance_measures not in", values, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresBetween(String value1, String value2) {
            addCriterion("assistance_measures between", value1, value2, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAssistanceMeasuresNotBetween(String value1, String value2) {
            addCriterion("assistance_measures not between", value1, value2, "assistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresIsNull() {
            addCriterion("attach_assistance_measures is null");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresIsNotNull() {
            addCriterion("attach_assistance_measures is not null");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresEqualTo(String value) {
            addCriterion("attach_assistance_measures =", value, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresNotEqualTo(String value) {
            addCriterion("attach_assistance_measures <>", value, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresGreaterThan(String value) {
            addCriterion("attach_assistance_measures >", value, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresGreaterThanOrEqualTo(String value) {
            addCriterion("attach_assistance_measures >=", value, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresLessThan(String value) {
            addCriterion("attach_assistance_measures <", value, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresLessThanOrEqualTo(String value) {
            addCriterion("attach_assistance_measures <=", value, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresLike(String value) {
            addCriterion("attach_assistance_measures like", value, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresNotLike(String value) {
            addCriterion("attach_assistance_measures not like", value, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresIn(List<String> values) {
            addCriterion("attach_assistance_measures in", values, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresNotIn(List<String> values) {
            addCriterion("attach_assistance_measures not in", values, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresBetween(String value1, String value2) {
            addCriterion("attach_assistance_measures between", value1, value2, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andAttachAssistanceMeasuresNotBetween(String value1, String value2) {
            addCriterion("attach_assistance_measures not between", value1, value2, "attachAssistanceMeasures");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessIsNull() {
            addCriterion("expected_measures_effectiveness is null");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessIsNotNull() {
            addCriterion("expected_measures_effectiveness is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessEqualTo(String value) {
            addCriterion("expected_measures_effectiveness =", value, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessNotEqualTo(String value) {
            addCriterion("expected_measures_effectiveness <>", value, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessGreaterThan(String value) {
            addCriterion("expected_measures_effectiveness >", value, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessGreaterThanOrEqualTo(String value) {
            addCriterion("expected_measures_effectiveness >=", value, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessLessThan(String value) {
            addCriterion("expected_measures_effectiveness <", value, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessLessThanOrEqualTo(String value) {
            addCriterion("expected_measures_effectiveness <=", value, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessLike(String value) {
            addCriterion("expected_measures_effectiveness like", value, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessNotLike(String value) {
            addCriterion("expected_measures_effectiveness not like", value, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessIn(List<String> values) {
            addCriterion("expected_measures_effectiveness in", values, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessNotIn(List<String> values) {
            addCriterion("expected_measures_effectiveness not in", values, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessBetween(String value1, String value2) {
            addCriterion("expected_measures_effectiveness between", value1, value2, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andExpectedMeasuresEffectivenessNotBetween(String value1, String value2) {
            addCriterion("expected_measures_effectiveness not between", value1, value2, "expectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessIsNull() {
            addCriterion("attach_expected_measures_effectiveness is null");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessIsNotNull() {
            addCriterion("attach_expected_measures_effectiveness is not null");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessEqualTo(String value) {
            addCriterion("attach_expected_measures_effectiveness =", value, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessNotEqualTo(String value) {
            addCriterion("attach_expected_measures_effectiveness <>", value, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessGreaterThan(String value) {
            addCriterion("attach_expected_measures_effectiveness >", value, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessGreaterThanOrEqualTo(String value) {
            addCriterion("attach_expected_measures_effectiveness >=", value, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessLessThan(String value) {
            addCriterion("attach_expected_measures_effectiveness <", value, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessLessThanOrEqualTo(String value) {
            addCriterion("attach_expected_measures_effectiveness <=", value, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessLike(String value) {
            addCriterion("attach_expected_measures_effectiveness like", value, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessNotLike(String value) {
            addCriterion("attach_expected_measures_effectiveness not like", value, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessIn(List<String> values) {
            addCriterion("attach_expected_measures_effectiveness in", values, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessNotIn(List<String> values) {
            addCriterion("attach_expected_measures_effectiveness not in", values, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessBetween(String value1, String value2) {
            addCriterion("attach_expected_measures_effectiveness between", value1, value2, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachExpectedMeasuresEffectivenessNotBetween(String value1, String value2) {
            addCriterion("attach_expected_measures_effectiveness not between", value1, value2, "attachExpectedMeasuresEffectiveness");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListIsNull() {
            addCriterion("attach_employment_list is null");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListIsNotNull() {
            addCriterion("attach_employment_list is not null");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListEqualTo(String value) {
            addCriterion("attach_employment_list =", value, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListNotEqualTo(String value) {
            addCriterion("attach_employment_list <>", value, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListGreaterThan(String value) {
            addCriterion("attach_employment_list >", value, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListGreaterThanOrEqualTo(String value) {
            addCriterion("attach_employment_list >=", value, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListLessThan(String value) {
            addCriterion("attach_employment_list <", value, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListLessThanOrEqualTo(String value) {
            addCriterion("attach_employment_list <=", value, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListLike(String value) {
            addCriterion("attach_employment_list like", value, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListNotLike(String value) {
            addCriterion("attach_employment_list not like", value, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListIn(List<String> values) {
            addCriterion("attach_employment_list in", values, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListNotIn(List<String> values) {
            addCriterion("attach_employment_list not in", values, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListBetween(String value1, String value2) {
            addCriterion("attach_employment_list between", value1, value2, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andAttachEmploymentListNotBetween(String value1, String value2) {
            addCriterion("attach_employment_list not between", value1, value2, "attachEmploymentList");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
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

        public Criteria andCompanyPrincipalIsNull() {
            addCriterion("company_principal is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalIsNotNull() {
            addCriterion("company_principal is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalEqualTo(String value) {
            addCriterion("company_principal =", value, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalNotEqualTo(String value) {
            addCriterion("company_principal <>", value, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalGreaterThan(String value) {
            addCriterion("company_principal >", value, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("company_principal >=", value, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalLessThan(String value) {
            addCriterion("company_principal <", value, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalLessThanOrEqualTo(String value) {
            addCriterion("company_principal <=", value, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalLike(String value) {
            addCriterion("company_principal like", value, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalNotLike(String value) {
            addCriterion("company_principal not like", value, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalIn(List<String> values) {
            addCriterion("company_principal in", values, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalNotIn(List<String> values) {
            addCriterion("company_principal not in", values, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalBetween(String value1, String value2) {
            addCriterion("company_principal between", value1, value2, "companyPrincipal");
            return (Criteria) this;
        }

        public Criteria andCompanyPrincipalNotBetween(String value1, String value2) {
            addCriterion("company_principal not between", value1, value2, "companyPrincipal");
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