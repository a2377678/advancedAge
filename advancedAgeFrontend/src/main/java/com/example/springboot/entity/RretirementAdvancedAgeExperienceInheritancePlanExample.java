package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class RretirementAdvancedAgeExperienceInheritancePlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RretirementAdvancedAgeExperienceInheritancePlanExample() {
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

        public Criteria andWorkContentIsNull() {
            addCriterion("work_content is null");
            return (Criteria) this;
        }

        public Criteria andWorkContentIsNotNull() {
            addCriterion("work_content is not null");
            return (Criteria) this;
        }

        public Criteria andWorkContentEqualTo(String value) {
            addCriterion("work_content =", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotEqualTo(String value) {
            addCriterion("work_content <>", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThan(String value) {
            addCriterion("work_content >", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentGreaterThanOrEqualTo(String value) {
            addCriterion("work_content >=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThan(String value) {
            addCriterion("work_content <", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLessThanOrEqualTo(String value) {
            addCriterion("work_content <=", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentLike(String value) {
            addCriterion("work_content like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotLike(String value) {
            addCriterion("work_content not like", value, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentIn(List<String> values) {
            addCriterion("work_content in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotIn(List<String> values) {
            addCriterion("work_content not in", values, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentBetween(String value1, String value2) {
            addCriterion("work_content between", value1, value2, "workContent");
            return (Criteria) this;
        }

        public Criteria andWorkContentNotBetween(String value1, String value2) {
            addCriterion("work_content not between", value1, value2, "workContent");
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

        public Criteria andExperienceInheritanceHoursIsNull() {
            addCriterion("experience_inheritance_hours is null");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursIsNotNull() {
            addCriterion("experience_inheritance_hours is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursEqualTo(Double value) {
            addCriterion("experience_inheritance_hours =", value, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursNotEqualTo(Double value) {
            addCriterion("experience_inheritance_hours <>", value, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursGreaterThan(Double value) {
            addCriterion("experience_inheritance_hours >", value, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursGreaterThanOrEqualTo(Double value) {
            addCriterion("experience_inheritance_hours >=", value, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursLessThan(Double value) {
            addCriterion("experience_inheritance_hours <", value, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursLessThanOrEqualTo(Double value) {
            addCriterion("experience_inheritance_hours <=", value, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursIn(List<Double> values) {
            addCriterion("experience_inheritance_hours in", values, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursNotIn(List<Double> values) {
            addCriterion("experience_inheritance_hours not in", values, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursBetween(Double value1, Double value2) {
            addCriterion("experience_inheritance_hours between", value1, value2, "experienceInheritanceHours");
            return (Criteria) this;
        }

        public Criteria andExperienceInheritanceHoursNotBetween(Double value1, Double value2) {
            addCriterion("experience_inheritance_hours not between", value1, value2, "experienceInheritanceHours");
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