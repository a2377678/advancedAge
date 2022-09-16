package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MailRecordExample() {
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

        public Criteria andMailContentIsNull() {
            addCriterion("mail_content is null");
            return (Criteria) this;
        }

        public Criteria andMailContentIsNotNull() {
            addCriterion("mail_content is not null");
            return (Criteria) this;
        }

        public Criteria andMailContentEqualTo(String value) {
            addCriterion("mail_content =", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentNotEqualTo(String value) {
            addCriterion("mail_content <>", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentGreaterThan(String value) {
            addCriterion("mail_content >", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentGreaterThanOrEqualTo(String value) {
            addCriterion("mail_content >=", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentLessThan(String value) {
            addCriterion("mail_content <", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentLessThanOrEqualTo(String value) {
            addCriterion("mail_content <=", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentLike(String value) {
            addCriterion("mail_content like", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentNotLike(String value) {
            addCriterion("mail_content not like", value, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentIn(List<String> values) {
            addCriterion("mail_content in", values, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentNotIn(List<String> values) {
            addCriterion("mail_content not in", values, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentBetween(String value1, String value2) {
            addCriterion("mail_content between", value1, value2, "mailContent");
            return (Criteria) this;
        }

        public Criteria andMailContentNotBetween(String value1, String value2) {
            addCriterion("mail_content not between", value1, value2, "mailContent");
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

        public Criteria andAdvancedAgeBaseIdIsNull() {
            addCriterion("advanced_age_base_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdIsNotNull() {
            addCriterion("advanced_age_base_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdEqualTo(Integer value) {
            addCriterion("advanced_age_base_id =", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdNotEqualTo(Integer value) {
            addCriterion("advanced_age_base_id <>", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdGreaterThan(Integer value) {
            addCriterion("advanced_age_base_id >", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_base_id >=", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdLessThan(Integer value) {
            addCriterion("advanced_age_base_id <", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("advanced_age_base_id <=", value, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdIn(List<Integer> values) {
            addCriterion("advanced_age_base_id in", values, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdNotIn(List<Integer> values) {
            addCriterion("advanced_age_base_id not in", values, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_base_id between", value1, value2, "advancedAgeBaseId");
            return (Criteria) this;
        }

        public Criteria andAdvancedAgeBaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advanced_age_base_id not between", value1, value2, "advancedAgeBaseId");
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