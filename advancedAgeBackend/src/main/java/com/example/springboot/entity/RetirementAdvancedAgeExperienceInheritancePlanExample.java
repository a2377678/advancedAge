package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class RetirementAdvancedAgeExperienceInheritancePlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RetirementAdvancedAgeExperienceInheritancePlanExample() {
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

        public Criteria andLowerEmploymentNumberIsNull() {
            addCriterion("lower_employment_number is null");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberIsNotNull() {
            addCriterion("lower_employment_number is not null");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberEqualTo(Integer value) {
            addCriterion("lower_employment_number =", value, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberNotEqualTo(Integer value) {
            addCriterion("lower_employment_number <>", value, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberGreaterThan(Integer value) {
            addCriterion("lower_employment_number >", value, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("lower_employment_number >=", value, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberLessThan(Integer value) {
            addCriterion("lower_employment_number <", value, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("lower_employment_number <=", value, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberIn(List<Integer> values) {
            addCriterion("lower_employment_number in", values, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberNotIn(List<Integer> values) {
            addCriterion("lower_employment_number not in", values, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberBetween(Integer value1, Integer value2) {
            addCriterion("lower_employment_number between", value1, value2, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andLowerEmploymentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("lower_employment_number not between", value1, value2, "lowerEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberIsNull() {
            addCriterion("retirement_employment_number is null");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberIsNotNull() {
            addCriterion("retirement_employment_number is not null");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberEqualTo(Integer value) {
            addCriterion("retirement_employment_number =", value, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberNotEqualTo(Integer value) {
            addCriterion("retirement_employment_number <>", value, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberGreaterThan(Integer value) {
            addCriterion("retirement_employment_number >", value, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("retirement_employment_number >=", value, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberLessThan(Integer value) {
            addCriterion("retirement_employment_number <", value, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("retirement_employment_number <=", value, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberIn(List<Integer> values) {
            addCriterion("retirement_employment_number in", values, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberNotIn(List<Integer> values) {
            addCriterion("retirement_employment_number not in", values, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberBetween(Integer value1, Integer value2) {
            addCriterion("retirement_employment_number between", value1, value2, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andRetirementEmploymentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("retirement_employment_number not between", value1, value2, "retirementEmploymentNumber");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionIsNull() {
            addCriterion("plan_description is null");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionIsNotNull() {
            addCriterion("plan_description is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionEqualTo(String value) {
            addCriterion("plan_description =", value, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionNotEqualTo(String value) {
            addCriterion("plan_description <>", value, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionGreaterThan(String value) {
            addCriterion("plan_description >", value, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("plan_description >=", value, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionLessThan(String value) {
            addCriterion("plan_description <", value, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionLessThanOrEqualTo(String value) {
            addCriterion("plan_description <=", value, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionLike(String value) {
            addCriterion("plan_description like", value, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionNotLike(String value) {
            addCriterion("plan_description not like", value, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionIn(List<String> values) {
            addCriterion("plan_description in", values, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionNotIn(List<String> values) {
            addCriterion("plan_description not in", values, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionBetween(String value1, String value2) {
            addCriterion("plan_description between", value1, value2, "planDescription");
            return (Criteria) this;
        }

        public Criteria andPlanDescriptionNotBetween(String value1, String value2) {
            addCriterion("plan_description not between", value1, value2, "planDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayIsNull() {
            addCriterion("execution_way is null");
            return (Criteria) this;
        }

        public Criteria andExecutionWayIsNotNull() {
            addCriterion("execution_way is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionWayEqualTo(String value) {
            addCriterion("execution_way =", value, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayNotEqualTo(String value) {
            addCriterion("execution_way <>", value, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayGreaterThan(String value) {
            addCriterion("execution_way >", value, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayGreaterThanOrEqualTo(String value) {
            addCriterion("execution_way >=", value, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayLessThan(String value) {
            addCriterion("execution_way <", value, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayLessThanOrEqualTo(String value) {
            addCriterion("execution_way <=", value, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayLike(String value) {
            addCriterion("execution_way like", value, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayNotLike(String value) {
            addCriterion("execution_way not like", value, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayIn(List<String> values) {
            addCriterion("execution_way in", values, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayNotIn(List<String> values) {
            addCriterion("execution_way not in", values, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayBetween(String value1, String value2) {
            addCriterion("execution_way between", value1, value2, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayNotBetween(String value1, String value2) {
            addCriterion("execution_way not between", value1, value2, "executionWay");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionIsNull() {
            addCriterion("execution_way_description is null");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionIsNotNull() {
            addCriterion("execution_way_description is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionEqualTo(String value) {
            addCriterion("execution_way_description =", value, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionNotEqualTo(String value) {
            addCriterion("execution_way_description <>", value, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionGreaterThan(String value) {
            addCriterion("execution_way_description >", value, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("execution_way_description >=", value, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionLessThan(String value) {
            addCriterion("execution_way_description <", value, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionLessThanOrEqualTo(String value) {
            addCriterion("execution_way_description <=", value, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionLike(String value) {
            addCriterion("execution_way_description like", value, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionNotLike(String value) {
            addCriterion("execution_way_description not like", value, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionIn(List<String> values) {
            addCriterion("execution_way_description in", values, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionNotIn(List<String> values) {
            addCriterion("execution_way_description not in", values, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionBetween(String value1, String value2) {
            addCriterion("execution_way_description between", value1, value2, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andExecutionWayDescriptionNotBetween(String value1, String value2) {
            addCriterion("execution_way_description not between", value1, value2, "executionWayDescription");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(String value) {
            addCriterion("plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(String value) {
            addCriterion("plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(String value) {
            addCriterion("plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(String value) {
            addCriterion("plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(String value) {
            addCriterion("plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLike(String value) {
            addCriterion("plan_start_time like", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotLike(String value) {
            addCriterion("plan_start_time not like", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<String> values) {
            addCriterion("plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<String> values) {
            addCriterion("plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(String value1, String value2) {
            addCriterion("plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(String value1, String value2) {
            addCriterion("plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNull() {
            addCriterion("plan_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNotNull() {
            addCriterion("plan_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeEqualTo(String value) {
            addCriterion("plan_end_time =", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotEqualTo(String value) {
            addCriterion("plan_end_time <>", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThan(String value) {
            addCriterion("plan_end_time >", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_end_time >=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThan(String value) {
            addCriterion("plan_end_time <", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThanOrEqualTo(String value) {
            addCriterion("plan_end_time <=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLike(String value) {
            addCriterion("plan_end_time like", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotLike(String value) {
            addCriterion("plan_end_time not like", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIn(List<String> values) {
            addCriterion("plan_end_time in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotIn(List<String> values) {
            addCriterion("plan_end_time not in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeBetween(String value1, String value2) {
            addCriterion("plan_end_time between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotBetween(String value1, String value2) {
            addCriterion("plan_end_time not between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceIsNull() {
            addCriterion("experience_inheritance is null");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceIsNotNull() {
            addCriterion("experience_inheritance is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceEqualTo(String value) {
            addCriterion("experience_inheritance =", value, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceNotEqualTo(String value) {
            addCriterion("experience_inheritance <>", value, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceGreaterThan(String value) {
            addCriterion("experience_inheritance >", value, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceGreaterThanOrEqualTo(String value) {
            addCriterion("experience_inheritance >=", value, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceLessThan(String value) {
            addCriterion("experience_inheritance <", value, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceLessThanOrEqualTo(String value) {
            addCriterion("experience_inheritance <=", value, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceLike(String value) {
            addCriterion("experience_inheritance like", value, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceNotLike(String value) {
            addCriterion("experience_inheritance not like", value, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceIn(List<String> values) {
            addCriterion("experience_inheritance in", values, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceNotIn(List<String> values) {
            addCriterion("experience_inheritance not in", values, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceBetween(String value1, String value2) {
            addCriterion("experience_inheritance between", value1, value2, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceNotBetween(String value1, String value2) {
            addCriterion("experience_inheritance not between", value1, value2, "experienceInheritance");
            return (Criteria) this;
        }

        public Criteria andParticipateIsNull() {
            addCriterion("participate is null");
            return (Criteria) this;
        }

        public Criteria andParticipateIsNotNull() {
            addCriterion("participate is not null");
            return (Criteria) this;
        }

        public Criteria andParticipateEqualTo(String value) {
            addCriterion("participate =", value, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateNotEqualTo(String value) {
            addCriterion("participate <>", value, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateGreaterThan(String value) {
            addCriterion("participate >", value, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateGreaterThanOrEqualTo(String value) {
            addCriterion("participate >=", value, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateLessThan(String value) {
            addCriterion("participate <", value, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateLessThanOrEqualTo(String value) {
            addCriterion("participate <=", value, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateLike(String value) {
            addCriterion("participate like", value, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateNotLike(String value) {
            addCriterion("participate not like", value, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateIn(List<String> values) {
            addCriterion("participate in", values, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateNotIn(List<String> values) {
            addCriterion("participate not in", values, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateBetween(String value1, String value2) {
            addCriterion("participate between", value1, value2, "participate");
            return (Criteria) this;
        }

        public Criteria andParticipateNotBetween(String value1, String value2) {
            addCriterion("participate not between", value1, value2, "participate");
            return (Criteria) this;
        }

        public Criteria andBenefitIsNull() {
            addCriterion("benefit is null");
            return (Criteria) this;
        }

        public Criteria andBenefitIsNotNull() {
            addCriterion("benefit is not null");
            return (Criteria) this;
        }

        public Criteria andBenefitEqualTo(String value) {
            addCriterion("benefit =", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotEqualTo(String value) {
            addCriterion("benefit <>", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitGreaterThan(String value) {
            addCriterion("benefit >", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitGreaterThanOrEqualTo(String value) {
            addCriterion("benefit >=", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitLessThan(String value) {
            addCriterion("benefit <", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitLessThanOrEqualTo(String value) {
            addCriterion("benefit <=", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitLike(String value) {
            addCriterion("benefit like", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotLike(String value) {
            addCriterion("benefit not like", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitIn(List<String> values) {
            addCriterion("benefit in", values, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotIn(List<String> values) {
            addCriterion("benefit not in", values, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitBetween(String value1, String value2) {
            addCriterion("benefit between", value1, value2, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotBetween(String value1, String value2) {
            addCriterion("benefit not between", value1, value2, "benefit");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationIsNull() {
            addCriterion("plan_execution_situation is null");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationIsNotNull() {
            addCriterion("plan_execution_situation is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationEqualTo(String value) {
            addCriterion("plan_execution_situation =", value, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationNotEqualTo(String value) {
            addCriterion("plan_execution_situation <>", value, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationGreaterThan(String value) {
            addCriterion("plan_execution_situation >", value, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationGreaterThanOrEqualTo(String value) {
            addCriterion("plan_execution_situation >=", value, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationLessThan(String value) {
            addCriterion("plan_execution_situation <", value, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationLessThanOrEqualTo(String value) {
            addCriterion("plan_execution_situation <=", value, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationLike(String value) {
            addCriterion("plan_execution_situation like", value, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationNotLike(String value) {
            addCriterion("plan_execution_situation not like", value, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationIn(List<String> values) {
            addCriterion("plan_execution_situation in", values, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationNotIn(List<String> values) {
            addCriterion("plan_execution_situation not in", values, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationBetween(String value1, String value2) {
            addCriterion("plan_execution_situation between", value1, value2, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionSituationNotBetween(String value1, String value2) {
            addCriterion("plan_execution_situation not between", value1, value2, "planExecutionSituation");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentIsNull() {
            addCriterion("other_attachment is null");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentIsNotNull() {
            addCriterion("other_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentEqualTo(String value) {
            addCriterion("other_attachment =", value, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentNotEqualTo(String value) {
            addCriterion("other_attachment <>", value, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentGreaterThan(String value) {
            addCriterion("other_attachment >", value, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("other_attachment >=", value, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentLessThan(String value) {
            addCriterion("other_attachment <", value, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentLessThanOrEqualTo(String value) {
            addCriterion("other_attachment <=", value, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentLike(String value) {
            addCriterion("other_attachment like", value, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentNotLike(String value) {
            addCriterion("other_attachment not like", value, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentIn(List<String> values) {
            addCriterion("other_attachment in", values, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentNotIn(List<String> values) {
            addCriterion("other_attachment not in", values, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentBetween(String value1, String value2) {
            addCriterion("other_attachment between", value1, value2, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andOtherAttachmentNotBetween(String value1, String value2) {
            addCriterion("other_attachment not between", value1, value2, "otherAttachment");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListIsNull() {
            addCriterion("attach_speaker_list is null");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListIsNotNull() {
            addCriterion("attach_speaker_list is not null");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListEqualTo(String value) {
            addCriterion("attach_speaker_list =", value, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListNotEqualTo(String value) {
            addCriterion("attach_speaker_list <>", value, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListGreaterThan(String value) {
            addCriterion("attach_speaker_list >", value, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListGreaterThanOrEqualTo(String value) {
            addCriterion("attach_speaker_list >=", value, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListLessThan(String value) {
            addCriterion("attach_speaker_list <", value, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListLessThanOrEqualTo(String value) {
            addCriterion("attach_speaker_list <=", value, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListLike(String value) {
            addCriterion("attach_speaker_list like", value, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListNotLike(String value) {
            addCriterion("attach_speaker_list not like", value, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListIn(List<String> values) {
            addCriterion("attach_speaker_list in", values, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListNotIn(List<String> values) {
            addCriterion("attach_speaker_list not in", values, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListBetween(String value1, String value2) {
            addCriterion("attach_speaker_list between", value1, value2, "attachSpeakerList");
            return (Criteria) this;
        }

        public Criteria andAttachSpeakerListNotBetween(String value1, String value2) {
            addCriterion("attach_speaker_list not between", value1, value2, "attachSpeakerList");
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