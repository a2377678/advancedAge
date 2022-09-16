package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.List;

public class RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RetirementAdvancedAgeExperienceInheritanceExpenditureDetailsExample() {
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

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdIsNull() {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id is null");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdIsNotNull() {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id is not null");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id =", value, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdNotEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id <>", value, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdGreaterThan(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id >", value, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id >=", value, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdLessThan(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id <", value, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdLessThanOrEqualTo(Integer value) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id <=", value, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdIn(List<Integer> values) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id in", values, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdNotIn(List<Integer> values) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id not in", values, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdBetween(Integer value1, Integer value2) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id between", value1, value2, "retirementAdvancedAgeExperienceInheritanceResultId");
            return (Criteria) this;
        }

        public Criteria andRetirementAdvancedAgeExperienceInheritanceResultIdNotBetween(Integer value1, Integer value2) {
            addCriterion("retirement_advanced_age_experience_inheritance_result_id not between", value1, value2, "retirementAdvancedAgeExperienceInheritanceResultId");
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

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Integer value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Integer value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Integer value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Integer value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Integer> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Integer> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNull() {
            addCriterion("plan_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("plan_name =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("plan_name <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("plan_name >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_name >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("plan_name <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("plan_name <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("plan_name like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("plan_name not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("plan_name in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("plan_name not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("plan_name between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("plan_name not between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsIsNull() {
            addCriterion("approve_amounts is null");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsIsNotNull() {
            addCriterion("approve_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsEqualTo(Integer value) {
            addCriterion("approve_amounts =", value, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsNotEqualTo(Integer value) {
            addCriterion("approve_amounts <>", value, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsGreaterThan(Integer value) {
            addCriterion("approve_amounts >", value, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_amounts >=", value, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsLessThan(Integer value) {
            addCriterion("approve_amounts <", value, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("approve_amounts <=", value, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsIn(List<Integer> values) {
            addCriterion("approve_amounts in", values, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsNotIn(List<Integer> values) {
            addCriterion("approve_amounts not in", values, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsBetween(Integer value1, Integer value2) {
            addCriterion("approve_amounts between", value1, value2, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andApproveAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_amounts not between", value1, value2, "approveAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsIsNull() {
            addCriterion("real_amounts is null");
            return (Criteria) this;
        }

        public Criteria andRealAmountsIsNotNull() {
            addCriterion("real_amounts is not null");
            return (Criteria) this;
        }

        public Criteria andRealAmountsEqualTo(Integer value) {
            addCriterion("real_amounts =", value, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsNotEqualTo(Integer value) {
            addCriterion("real_amounts <>", value, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsGreaterThan(Integer value) {
            addCriterion("real_amounts >", value, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_amounts >=", value, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsLessThan(Integer value) {
            addCriterion("real_amounts <", value, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsLessThanOrEqualTo(Integer value) {
            addCriterion("real_amounts <=", value, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsIn(List<Integer> values) {
            addCriterion("real_amounts in", values, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsNotIn(List<Integer> values) {
            addCriterion("real_amounts not in", values, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsBetween(Integer value1, Integer value2) {
            addCriterion("real_amounts between", value1, value2, "realAmounts");
            return (Criteria) this;
        }

        public Criteria andRealAmountsNotBetween(Integer value1, Integer value2) {
            addCriterion("real_amounts not between", value1, value2, "realAmounts");
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

        public Criteria andAccountantIsNull() {
            addCriterion("accountant is null");
            return (Criteria) this;
        }

        public Criteria andAccountantIsNotNull() {
            addCriterion("accountant is not null");
            return (Criteria) this;
        }

        public Criteria andAccountantEqualTo(String value) {
            addCriterion("accountant =", value, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantNotEqualTo(String value) {
            addCriterion("accountant <>", value, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantGreaterThan(String value) {
            addCriterion("accountant >", value, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantGreaterThanOrEqualTo(String value) {
            addCriterion("accountant >=", value, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantLessThan(String value) {
            addCriterion("accountant <", value, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantLessThanOrEqualTo(String value) {
            addCriterion("accountant <=", value, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantLike(String value) {
            addCriterion("accountant like", value, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantNotLike(String value) {
            addCriterion("accountant not like", value, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantIn(List<String> values) {
            addCriterion("accountant in", values, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantNotIn(List<String> values) {
            addCriterion("accountant not in", values, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantBetween(String value1, String value2) {
            addCriterion("accountant between", value1, value2, "accountant");
            return (Criteria) this;
        }

        public Criteria andAccountantNotBetween(String value1, String value2) {
            addCriterion("accountant not between", value1, value2, "accountant");
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