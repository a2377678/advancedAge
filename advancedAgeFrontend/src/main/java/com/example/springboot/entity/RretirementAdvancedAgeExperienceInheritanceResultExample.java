package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RretirementAdvancedAgeExperienceInheritanceResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RretirementAdvancedAgeExperienceInheritanceResultExample() {
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

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andSuggestionIsNull() {
            addCriterion("suggestion is null");
            return (Criteria) this;
        }

        public Criteria andSuggestionIsNotNull() {
            addCriterion("suggestion is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestionEqualTo(String value) {
            addCriterion("suggestion =", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotEqualTo(String value) {
            addCriterion("suggestion <>", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionGreaterThan(String value) {
            addCriterion("suggestion >", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionGreaterThanOrEqualTo(String value) {
            addCriterion("suggestion >=", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLessThan(String value) {
            addCriterion("suggestion <", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLessThanOrEqualTo(String value) {
            addCriterion("suggestion <=", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionLike(String value) {
            addCriterion("suggestion like", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotLike(String value) {
            addCriterion("suggestion not like", value, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionIn(List<String> values) {
            addCriterion("suggestion in", values, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotIn(List<String> values) {
            addCriterion("suggestion not in", values, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionBetween(String value1, String value2) {
            addCriterion("suggestion between", value1, value2, "suggestion");
            return (Criteria) this;
        }

        public Criteria andSuggestionNotBetween(String value1, String value2) {
            addCriterion("suggestion not between", value1, value2, "suggestion");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveIsNull() {
            addCriterion("attach_documents_plan_approve is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveIsNotNull() {
            addCriterion("attach_documents_plan_approve is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveEqualTo(String value) {
            addCriterion("attach_documents_plan_approve =", value, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveNotEqualTo(String value) {
            addCriterion("attach_documents_plan_approve <>", value, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveGreaterThan(String value) {
            addCriterion("attach_documents_plan_approve >", value, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_plan_approve >=", value, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveLessThan(String value) {
            addCriterion("attach_documents_plan_approve <", value, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_plan_approve <=", value, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveLike(String value) {
            addCriterion("attach_documents_plan_approve like", value, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveNotLike(String value) {
            addCriterion("attach_documents_plan_approve not like", value, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveIn(List<String> values) {
            addCriterion("attach_documents_plan_approve in", values, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveNotIn(List<String> values) {
            addCriterion("attach_documents_plan_approve not in", values, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveBetween(String value1, String value2) {
            addCriterion("attach_documents_plan_approve between", value1, value2, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsPlanApproveNotBetween(String value1, String value2) {
            addCriterion("attach_documents_plan_approve not between", value1, value2, "attachDocumentsPlanApprove");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultIsNull() {
            addCriterion("attach_documents_result is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultIsNotNull() {
            addCriterion("attach_documents_result is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultEqualTo(String value) {
            addCriterion("attach_documents_result =", value, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultNotEqualTo(String value) {
            addCriterion("attach_documents_result <>", value, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultGreaterThan(String value) {
            addCriterion("attach_documents_result >", value, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_result >=", value, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultLessThan(String value) {
            addCriterion("attach_documents_result <", value, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_result <=", value, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultLike(String value) {
            addCriterion("attach_documents_result like", value, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultNotLike(String value) {
            addCriterion("attach_documents_result not like", value, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultIn(List<String> values) {
            addCriterion("attach_documents_result in", values, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultNotIn(List<String> values) {
            addCriterion("attach_documents_result not in", values, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultBetween(String value1, String value2) {
            addCriterion("attach_documents_result between", value1, value2, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsResultNotBetween(String value1, String value2) {
            addCriterion("attach_documents_result not between", value1, value2, "attachDocumentsResult");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptIsNull() {
            addCriterion("attach_documents_receipt is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptIsNotNull() {
            addCriterion("attach_documents_receipt is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptEqualTo(String value) {
            addCriterion("attach_documents_receipt =", value, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptNotEqualTo(String value) {
            addCriterion("attach_documents_receipt <>", value, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptGreaterThan(String value) {
            addCriterion("attach_documents_receipt >", value, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_receipt >=", value, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptLessThan(String value) {
            addCriterion("attach_documents_receipt <", value, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_receipt <=", value, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptLike(String value) {
            addCriterion("attach_documents_receipt like", value, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptNotLike(String value) {
            addCriterion("attach_documents_receipt not like", value, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptIn(List<String> values) {
            addCriterion("attach_documents_receipt in", values, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptNotIn(List<String> values) {
            addCriterion("attach_documents_receipt not in", values, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptBetween(String value1, String value2) {
            addCriterion("attach_documents_receipt between", value1, value2, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsReceiptNotBetween(String value1, String value2) {
            addCriterion("attach_documents_receipt not between", value1, value2, "attachDocumentsReceipt");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeIsNull() {
            addCriterion("attach_documents_speaker_fee is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeIsNotNull() {
            addCriterion("attach_documents_speaker_fee is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeEqualTo(String value) {
            addCriterion("attach_documents_speaker_fee =", value, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeNotEqualTo(String value) {
            addCriterion("attach_documents_speaker_fee <>", value, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeGreaterThan(String value) {
            addCriterion("attach_documents_speaker_fee >", value, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_speaker_fee >=", value, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeLessThan(String value) {
            addCriterion("attach_documents_speaker_fee <", value, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_speaker_fee <=", value, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeLike(String value) {
            addCriterion("attach_documents_speaker_fee like", value, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeNotLike(String value) {
            addCriterion("attach_documents_speaker_fee not like", value, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeIn(List<String> values) {
            addCriterion("attach_documents_speaker_fee in", values, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeNotIn(List<String> values) {
            addCriterion("attach_documents_speaker_fee not in", values, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeBetween(String value1, String value2) {
            addCriterion("attach_documents_speaker_fee between", value1, value2, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsSpeakerFeeNotBetween(String value1, String value2) {
            addCriterion("attach_documents_speaker_fee not between", value1, value2, "attachDocumentsSpeakerFee");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionIsNull() {
            addCriterion("attach_documents_expenditure_description is null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionIsNotNull() {
            addCriterion("attach_documents_expenditure_description is not null");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionEqualTo(String value) {
            addCriterion("attach_documents_expenditure_description =", value, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionNotEqualTo(String value) {
            addCriterion("attach_documents_expenditure_description <>", value, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionGreaterThan(String value) {
            addCriterion("attach_documents_expenditure_description >", value, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("attach_documents_expenditure_description >=", value, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionLessThan(String value) {
            addCriterion("attach_documents_expenditure_description <", value, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionLessThanOrEqualTo(String value) {
            addCriterion("attach_documents_expenditure_description <=", value, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionLike(String value) {
            addCriterion("attach_documents_expenditure_description like", value, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionNotLike(String value) {
            addCriterion("attach_documents_expenditure_description not like", value, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionIn(List<String> values) {
            addCriterion("attach_documents_expenditure_description in", values, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionNotIn(List<String> values) {
            addCriterion("attach_documents_expenditure_description not in", values, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionBetween(String value1, String value2) {
            addCriterion("attach_documents_expenditure_description between", value1, value2, "attachDocumentsExpenditureDescription");
            return (Criteria) this;
        }

        public Criteria andAttachDocumentsExpenditureDescriptionNotBetween(String value1, String value2) {
            addCriterion("attach_documents_expenditure_description not between", value1, value2, "attachDocumentsExpenditureDescription");
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

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
            addCriterion("manager not between", value1, value2, "manager");
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