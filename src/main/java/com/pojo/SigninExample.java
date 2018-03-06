package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SigninExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SigninExample() {
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

        public Criteria andSigninUserIdIsNull() {
            addCriterion("signin_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdIsNotNull() {
            addCriterion("signin_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdEqualTo(Integer value) {
            addCriterion("signin_user_id =", value, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdNotEqualTo(Integer value) {
            addCriterion("signin_user_id <>", value, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdGreaterThan(Integer value) {
            addCriterion("signin_user_id >", value, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("signin_user_id >=", value, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdLessThan(Integer value) {
            addCriterion("signin_user_id <", value, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("signin_user_id <=", value, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdIn(List<Integer> values) {
            addCriterion("signin_user_id in", values, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdNotIn(List<Integer> values) {
            addCriterion("signin_user_id not in", values, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdBetween(Integer value1, Integer value2) {
            addCriterion("signin_user_id between", value1, value2, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("signin_user_id not between", value1, value2, "signinUserId");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNull() {
            addCriterion("signin_time is null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNotNull() {
            addCriterion("signin_time is not null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeEqualTo(Date value) {
            addCriterion("signin_time =", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotEqualTo(Date value) {
            addCriterion("signin_time <>", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThan(Date value) {
            addCriterion("signin_time >", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("signin_time >=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThan(Date value) {
            addCriterion("signin_time <", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThanOrEqualTo(Date value) {
            addCriterion("signin_time <=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIn(List<Date> values) {
            addCriterion("signin_time in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotIn(List<Date> values) {
            addCriterion("signin_time not in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeBetween(Date value1, Date value2) {
            addCriterion("signin_time between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotBetween(Date value1, Date value2) {
            addCriterion("signin_time not between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninIpIsNull() {
            addCriterion("signin_ip is null");
            return (Criteria) this;
        }

        public Criteria andSigninIpIsNotNull() {
            addCriterion("signin_ip is not null");
            return (Criteria) this;
        }

        public Criteria andSigninIpEqualTo(String value) {
            addCriterion("signin_ip =", value, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpNotEqualTo(String value) {
            addCriterion("signin_ip <>", value, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpGreaterThan(String value) {
            addCriterion("signin_ip >", value, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpGreaterThanOrEqualTo(String value) {
            addCriterion("signin_ip >=", value, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpLessThan(String value) {
            addCriterion("signin_ip <", value, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpLessThanOrEqualTo(String value) {
            addCriterion("signin_ip <=", value, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpLike(String value) {
            addCriterion("signin_ip like", value, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpNotLike(String value) {
            addCriterion("signin_ip not like", value, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpIn(List<String> values) {
            addCriterion("signin_ip in", values, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpNotIn(List<String> values) {
            addCriterion("signin_ip not in", values, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpBetween(String value1, String value2) {
            addCriterion("signin_ip between", value1, value2, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninIpNotBetween(String value1, String value2) {
            addCriterion("signin_ip not between", value1, value2, "signinIp");
            return (Criteria) this;
        }

        public Criteria andSigninUaIsNull() {
            addCriterion("signin_ua is null");
            return (Criteria) this;
        }

        public Criteria andSigninUaIsNotNull() {
            addCriterion("signin_ua is not null");
            return (Criteria) this;
        }

        public Criteria andSigninUaEqualTo(String value) {
            addCriterion("signin_ua =", value, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaNotEqualTo(String value) {
            addCriterion("signin_ua <>", value, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaGreaterThan(String value) {
            addCriterion("signin_ua >", value, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaGreaterThanOrEqualTo(String value) {
            addCriterion("signin_ua >=", value, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaLessThan(String value) {
            addCriterion("signin_ua <", value, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaLessThanOrEqualTo(String value) {
            addCriterion("signin_ua <=", value, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaLike(String value) {
            addCriterion("signin_ua like", value, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaNotLike(String value) {
            addCriterion("signin_ua not like", value, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaIn(List<String> values) {
            addCriterion("signin_ua in", values, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaNotIn(List<String> values) {
            addCriterion("signin_ua not in", values, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaBetween(String value1, String value2) {
            addCriterion("signin_ua between", value1, value2, "signinUa");
            return (Criteria) this;
        }

        public Criteria andSigninUaNotBetween(String value1, String value2) {
            addCriterion("signin_ua not between", value1, value2, "signinUa");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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