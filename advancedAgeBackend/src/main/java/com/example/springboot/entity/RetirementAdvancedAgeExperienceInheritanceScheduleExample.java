package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class RetirementAdvancedAgeExperienceInheritanceScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RetirementAdvancedAgeExperienceInheritanceScheduleExample() {
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

        public Criteria andExecutionStartTimeIsNull() {
            addCriterion("execution_start_time is null");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeIsNotNull() {
            addCriterion("execution_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeEqualTo(String value) {
            addCriterion("execution_start_time =", value, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeNotEqualTo(String value) {
            addCriterion("execution_start_time <>", value, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeGreaterThan(String value) {
            addCriterion("execution_start_time >", value, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("execution_start_time >=", value, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeLessThan(String value) {
            addCriterion("execution_start_time <", value, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeLessThanOrEqualTo(String value) {
            addCriterion("execution_start_time <=", value, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeLike(String value) {
            addCriterion("execution_start_time like", value, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeNotLike(String value) {
            addCriterion("execution_start_time not like", value, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeIn(List<String> values) {
            addCriterion("execution_start_time in", values, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeNotIn(List<String> values) {
            addCriterion("execution_start_time not in", values, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeBetween(String value1, String value2) {
            addCriterion("execution_start_time between", value1, value2, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionStartTimeNotBetween(String value1, String value2) {
            addCriterion("execution_start_time not between", value1, value2, "executionStartTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeIsNull() {
            addCriterion("execution_end_time is null");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeIsNotNull() {
            addCriterion("execution_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeEqualTo(String value) {
            addCriterion("execution_end_time =", value, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeNotEqualTo(String value) {
            addCriterion("execution_end_time <>", value, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeGreaterThan(String value) {
            addCriterion("execution_end_time >", value, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("execution_end_time >=", value, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeLessThan(String value) {
            addCriterion("execution_end_time <", value, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeLessThanOrEqualTo(String value) {
            addCriterion("execution_end_time <=", value, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeLike(String value) {
            addCriterion("execution_end_time like", value, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeNotLike(String value) {
            addCriterion("execution_end_time not like", value, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeIn(List<String> values) {
            addCriterion("execution_end_time in", values, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeNotIn(List<String> values) {
            addCriterion("execution_end_time not in", values, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeBetween(String value1, String value2) {
            addCriterion("execution_end_time between", value1, value2, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionEndTimeNotBetween(String value1, String value2) {
            addCriterion("execution_end_time not between", value1, value2, "executionEndTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeIsNull() {
            addCriterion("execution_time is null");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeIsNotNull() {
            addCriterion("execution_time is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeEqualTo(String value) {
            addCriterion("execution_time =", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeNotEqualTo(String value) {
            addCriterion("execution_time <>", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeGreaterThan(String value) {
            addCriterion("execution_time >", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("execution_time >=", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeLessThan(String value) {
            addCriterion("execution_time <", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeLessThanOrEqualTo(String value) {
            addCriterion("execution_time <=", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeLike(String value) {
            addCriterion("execution_time like", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeNotLike(String value) {
            addCriterion("execution_time not like", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeIn(List<String> values) {
            addCriterion("execution_time in", values, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeNotIn(List<String> values) {
            addCriterion("execution_time not in", values, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeBetween(String value1, String value2) {
            addCriterion("execution_time between", value1, value2, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeNotBetween(String value1, String value2) {
            addCriterion("execution_time not between", value1, value2, "executionTime");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
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

        public Criteria andExecutionCityIsNull() {
            addCriterion("execution_city is null");
            return (Criteria) this;
        }

        public Criteria andExecutionCityIsNotNull() {
            addCriterion("execution_city is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionCityEqualTo(String value) {
            addCriterion("execution_city =", value, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityNotEqualTo(String value) {
            addCriterion("execution_city <>", value, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityGreaterThan(String value) {
            addCriterion("execution_city >", value, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityGreaterThanOrEqualTo(String value) {
            addCriterion("execution_city >=", value, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityLessThan(String value) {
            addCriterion("execution_city <", value, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityLessThanOrEqualTo(String value) {
            addCriterion("execution_city <=", value, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityLike(String value) {
            addCriterion("execution_city like", value, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityNotLike(String value) {
            addCriterion("execution_city not like", value, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityIn(List<String> values) {
            addCriterion("execution_city in", values, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityNotIn(List<String> values) {
            addCriterion("execution_city not in", values, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityBetween(String value1, String value2) {
            addCriterion("execution_city between", value1, value2, "executionCity");
            return (Criteria) this;
        }

        public Criteria andExecutionCityNotBetween(String value1, String value2) {
            addCriterion("execution_city not between", value1, value2, "executionCity");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIsNull() {
            addCriterion("speaker_name is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIsNotNull() {
            addCriterion("speaker_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameEqualTo(String value) {
            addCriterion("speaker_name =", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotEqualTo(String value) {
            addCriterion("speaker_name <>", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameGreaterThan(String value) {
            addCriterion("speaker_name >", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameGreaterThanOrEqualTo(String value) {
            addCriterion("speaker_name >=", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLessThan(String value) {
            addCriterion("speaker_name <", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLessThanOrEqualTo(String value) {
            addCriterion("speaker_name <=", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLike(String value) {
            addCriterion("speaker_name like", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotLike(String value) {
            addCriterion("speaker_name not like", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIn(List<String> values) {
            addCriterion("speaker_name in", values, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotIn(List<String> values) {
            addCriterion("speaker_name not in", values, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameBetween(String value1, String value2) {
            addCriterion("speaker_name between", value1, value2, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotBetween(String value1, String value2) {
            addCriterion("speaker_name not between", value1, value2, "speakerName");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursIsNull() {
            addCriterion("teaching_hours is null");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursIsNotNull() {
            addCriterion("teaching_hours is not null");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursEqualTo(Double value) {
            addCriterion("teaching_hours =", value, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursNotEqualTo(Double value) {
            addCriterion("teaching_hours <>", value, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursGreaterThan(Double value) {
            addCriterion("teaching_hours >", value, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursGreaterThanOrEqualTo(Double value) {
            addCriterion("teaching_hours >=", value, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursLessThan(Double value) {
            addCriterion("teaching_hours <", value, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursLessThanOrEqualTo(Double value) {
            addCriterion("teaching_hours <=", value, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursIn(List<Double> values) {
            addCriterion("teaching_hours in", values, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursNotIn(List<Double> values) {
            addCriterion("teaching_hours not in", values, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursBetween(Double value1, Double value2) {
            addCriterion("teaching_hours between", value1, value2, "teachingHours");
            return (Criteria) this;
        }

        public Criteria andTeachingHoursNotBetween(Double value1, Double value2) {
            addCriterion("teaching_hours not between", value1, value2, "teachingHours");
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

        public Criteria andParticipatePeopleIsNull() {
            addCriterion("participate_people is null");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleIsNotNull() {
            addCriterion("participate_people is not null");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleEqualTo(String value) {
            addCriterion("participate_people =", value, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleNotEqualTo(String value) {
            addCriterion("participate_people <>", value, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleGreaterThan(String value) {
            addCriterion("participate_people >", value, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("participate_people >=", value, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleLessThan(String value) {
            addCriterion("participate_people <", value, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleLessThanOrEqualTo(String value) {
            addCriterion("participate_people <=", value, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleLike(String value) {
            addCriterion("participate_people like", value, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleNotLike(String value) {
            addCriterion("participate_people not like", value, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleIn(List<String> values) {
            addCriterion("participate_people in", values, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleNotIn(List<String> values) {
            addCriterion("participate_people not in", values, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleBetween(String value1, String value2) {
            addCriterion("participate_people between", value1, value2, "participatePeople");
            return (Criteria) this;
        }

        public Criteria andParticipatePeopleNotBetween(String value1, String value2) {
            addCriterion("participate_people not between", value1, value2, "participatePeople");
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