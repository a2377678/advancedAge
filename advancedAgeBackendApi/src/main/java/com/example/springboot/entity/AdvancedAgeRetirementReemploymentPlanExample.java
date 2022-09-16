package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class AdvancedAgeRetirementReemploymentPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvancedAgeRetirementReemploymentPlanExample() {
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

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdIsNull() {
            addCriterion("advanced_age_retirement_reemployment_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdIsNotNull() {
            addCriterion("advanced_age_retirement_reemployment_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdEqualTo(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_apply_id =", value, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdNotEqualTo(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_apply_id <>", value, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdGreaterThan(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_apply_id >", value, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_apply_id >=", value, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdLessThan(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_apply_id <", value, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_retirement_reemployment_apply_id <=", value, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdIn(List<Integer> values) {
            addCriterion("advanced_age_retirement_reemployment_apply_id in", values, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdNotIn(List<Integer> values) {
            addCriterion("advanced_age_retirement_reemployment_apply_id not in", values, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_retirement_reemployment_apply_id between", value1, value2, "advancedAgeRetirementReemploymentApplyId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeRetirementReemploymentApplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_retirement_reemployment_apply_id not between", value1, value2, "advancedAgeRetirementReemploymentApplyId");
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

        public Criteria andPlanGoalIsNull() {
            addCriterion("plan_goal is null");
            return (Criteria) this;
        }

        public Criteria andPlanGoalIsNotNull() {
            addCriterion("plan_goal is not null");
            return (Criteria) this;
        }

        public Criteria andPlanGoalEqualTo(String value) {
            addCriterion("plan_goal =", value, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalNotEqualTo(String value) {
            addCriterion("plan_goal <>", value, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalGreaterThan(String value) {
            addCriterion("plan_goal >", value, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalGreaterThanOrEqualTo(String value) {
            addCriterion("plan_goal >=", value, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalLessThan(String value) {
            addCriterion("plan_goal <", value, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalLessThanOrEqualTo(String value) {
            addCriterion("plan_goal <=", value, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalLike(String value) {
            addCriterion("plan_goal like", value, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalNotLike(String value) {
            addCriterion("plan_goal not like", value, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalIn(List<String> values) {
            addCriterion("plan_goal in", values, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalNotIn(List<String> values) {
            addCriterion("plan_goal not in", values, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalBetween(String value1, String value2) {
            addCriterion("plan_goal between", value1, value2, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanGoalNotBetween(String value1, String value2) {
            addCriterion("plan_goal not between", value1, value2, "planGoal");
            return (Criteria) this;
        }

        public Criteria andPlanContentIsNull() {
            addCriterion("plan_content is null");
            return (Criteria) this;
        }

        public Criteria andPlanContentIsNotNull() {
            addCriterion("plan_content is not null");
            return (Criteria) this;
        }

        public Criteria andPlanContentEqualTo(String value) {
            addCriterion("plan_content =", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotEqualTo(String value) {
            addCriterion("plan_content <>", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentGreaterThan(String value) {
            addCriterion("plan_content >", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentGreaterThanOrEqualTo(String value) {
            addCriterion("plan_content >=", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLessThan(String value) {
            addCriterion("plan_content <", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLessThanOrEqualTo(String value) {
            addCriterion("plan_content <=", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLike(String value) {
            addCriterion("plan_content like", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotLike(String value) {
            addCriterion("plan_content not like", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentIn(List<String> values) {
            addCriterion("plan_content in", values, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotIn(List<String> values) {
            addCriterion("plan_content not in", values, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentBetween(String value1, String value2) {
            addCriterion("plan_content between", value1, value2, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotBetween(String value1, String value2) {
            addCriterion("plan_content not between", value1, value2, "planContent");
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

        public Criteria andQualityBenefitIsNull() {
            addCriterion("quality_benefit is null");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitIsNotNull() {
            addCriterion("quality_benefit is not null");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitEqualTo(String value) {
            addCriterion("quality_benefit =", value, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitNotEqualTo(String value) {
            addCriterion("quality_benefit <>", value, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitGreaterThan(String value) {
            addCriterion("quality_benefit >", value, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitGreaterThanOrEqualTo(String value) {
            addCriterion("quality_benefit >=", value, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitLessThan(String value) {
            addCriterion("quality_benefit <", value, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitLessThanOrEqualTo(String value) {
            addCriterion("quality_benefit <=", value, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitLike(String value) {
            addCriterion("quality_benefit like", value, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitNotLike(String value) {
            addCriterion("quality_benefit not like", value, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitIn(List<String> values) {
            addCriterion("quality_benefit in", values, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitNotIn(List<String> values) {
            addCriterion("quality_benefit not in", values, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitBetween(String value1, String value2) {
            addCriterion("quality_benefit between", value1, value2, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQualityBenefitNotBetween(String value1, String value2) {
            addCriterion("quality_benefit not between", value1, value2, "qualityBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitIsNull() {
            addCriterion("quantify_benefit is null");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitIsNotNull() {
            addCriterion("quantify_benefit is not null");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitEqualTo(String value) {
            addCriterion("quantify_benefit =", value, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitNotEqualTo(String value) {
            addCriterion("quantify_benefit <>", value, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitGreaterThan(String value) {
            addCriterion("quantify_benefit >", value, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitGreaterThanOrEqualTo(String value) {
            addCriterion("quantify_benefit >=", value, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitLessThan(String value) {
            addCriterion("quantify_benefit <", value, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitLessThanOrEqualTo(String value) {
            addCriterion("quantify_benefit <=", value, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitLike(String value) {
            addCriterion("quantify_benefit like", value, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitNotLike(String value) {
            addCriterion("quantify_benefit not like", value, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitIn(List<String> values) {
            addCriterion("quantify_benefit in", values, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitNotIn(List<String> values) {
            addCriterion("quantify_benefit not in", values, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitBetween(String value1, String value2) {
            addCriterion("quantify_benefit between", value1, value2, "quantifyBenefit");
            return (Criteria) this;
        }

        public Criteria andQuantifyBenefitNotBetween(String value1, String value2) {
            addCriterion("quantify_benefit not between", value1, value2, "quantifyBenefit");
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