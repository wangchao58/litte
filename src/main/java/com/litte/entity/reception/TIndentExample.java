package com.litte.entity.reception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TIndentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TIndentExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andICodeIsNull() {
            addCriterion("i_code is null");
            return (Criteria) this;
        }

        public Criteria andICodeIsNotNull() {
            addCriterion("i_code is not null");
            return (Criteria) this;
        }

        public Criteria andICodeEqualTo(String value) {
            addCriterion("i_code =", value, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeNotEqualTo(String value) {
            addCriterion("i_code <>", value, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeGreaterThan(String value) {
            addCriterion("i_code >", value, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeGreaterThanOrEqualTo(String value) {
            addCriterion("i_code >=", value, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeLessThan(String value) {
            addCriterion("i_code <", value, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeLessThanOrEqualTo(String value) {
            addCriterion("i_code <=", value, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeLike(String value) {
            addCriterion("i_code like", value, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeNotLike(String value) {
            addCriterion("i_code not like", value, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeIn(List<String> values) {
            addCriterion("i_code in", values, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeNotIn(List<String> values) {
            addCriterion("i_code not in", values, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeBetween(String value1, String value2) {
            addCriterion("i_code between", value1, value2, "iCode");
            return (Criteria) this;
        }

        public Criteria andICodeNotBetween(String value1, String value2) {
            addCriterion("i_code not between", value1, value2, "iCode");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIPriceIsNull() {
            addCriterion("i_price is null");
            return (Criteria) this;
        }

        public Criteria andIPriceIsNotNull() {
            addCriterion("i_price is not null");
            return (Criteria) this;
        }

        public Criteria andIPriceEqualTo(String value) {
            addCriterion("i_price =", value, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceNotEqualTo(String value) {
            addCriterion("i_price <>", value, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceGreaterThan(String value) {
            addCriterion("i_price >", value, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceGreaterThanOrEqualTo(String value) {
            addCriterion("i_price >=", value, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceLessThan(String value) {
            addCriterion("i_price <", value, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceLessThanOrEqualTo(String value) {
            addCriterion("i_price <=", value, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceLike(String value) {
            addCriterion("i_price like", value, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceNotLike(String value) {
            addCriterion("i_price not like", value, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceIn(List<String> values) {
            addCriterion("i_price in", values, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceNotIn(List<String> values) {
            addCriterion("i_price not in", values, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceBetween(String value1, String value2) {
            addCriterion("i_price between", value1, value2, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPriceNotBetween(String value1, String value2) {
            addCriterion("i_price not between", value1, value2, "iPrice");
            return (Criteria) this;
        }

        public Criteria andIPhoneIsNull() {
            addCriterion("i_phone is null");
            return (Criteria) this;
        }

        public Criteria andIPhoneIsNotNull() {
            addCriterion("i_phone is not null");
            return (Criteria) this;
        }

        public Criteria andIPhoneEqualTo(String value) {
            addCriterion("i_phone =", value, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneNotEqualTo(String value) {
            addCriterion("i_phone <>", value, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneGreaterThan(String value) {
            addCriterion("i_phone >", value, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("i_phone >=", value, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneLessThan(String value) {
            addCriterion("i_phone <", value, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneLessThanOrEqualTo(String value) {
            addCriterion("i_phone <=", value, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneLike(String value) {
            addCriterion("i_phone like", value, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneNotLike(String value) {
            addCriterion("i_phone not like", value, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneIn(List<String> values) {
            addCriterion("i_phone in", values, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneNotIn(List<String> values) {
            addCriterion("i_phone not in", values, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneBetween(String value1, String value2) {
            addCriterion("i_phone between", value1, value2, "iPhone");
            return (Criteria) this;
        }

        public Criteria andIPhoneNotBetween(String value1, String value2) {
            addCriterion("i_phone not between", value1, value2, "iPhone");
            return (Criteria) this;
        }

        public Criteria andITypeIsNull() {
            addCriterion("i_type is null");
            return (Criteria) this;
        }

        public Criteria andITypeIsNotNull() {
            addCriterion("i_type is not null");
            return (Criteria) this;
        }

        public Criteria andITypeEqualTo(String value) {
            addCriterion("i_type =", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeNotEqualTo(String value) {
            addCriterion("i_type <>", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeGreaterThan(String value) {
            addCriterion("i_type >", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeGreaterThanOrEqualTo(String value) {
            addCriterion("i_type >=", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeLessThan(String value) {
            addCriterion("i_type <", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeLessThanOrEqualTo(String value) {
            addCriterion("i_type <=", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeLike(String value) {
            addCriterion("i_type like", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeNotLike(String value) {
            addCriterion("i_type not like", value, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeIn(List<String> values) {
            addCriterion("i_type in", values, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeNotIn(List<String> values) {
            addCriterion("i_type not in", values, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeBetween(String value1, String value2) {
            addCriterion("i_type between", value1, value2, "iType");
            return (Criteria) this;
        }

        public Criteria andITypeNotBetween(String value1, String value2) {
            addCriterion("i_type not between", value1, value2, "iType");
            return (Criteria) this;
        }

        public Criteria andITimeIsNull() {
            addCriterion("i_time is null");
            return (Criteria) this;
        }

        public Criteria andITimeIsNotNull() {
            addCriterion("i_time is not null");
            return (Criteria) this;
        }

        public Criteria andITimeEqualTo(Date value) {
            addCriterion("i_time =", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotEqualTo(Date value) {
            addCriterion("i_time <>", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeGreaterThan(Date value) {
            addCriterion("i_time >", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeGreaterThanOrEqualTo(Date value) {
            addCriterion("i_time >=", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeLessThan(Date value) {
            addCriterion("i_time <", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeLessThanOrEqualTo(Date value) {
            addCriterion("i_time <=", value, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeIn(List<Date> values) {
            addCriterion("i_time in", values, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotIn(List<Date> values) {
            addCriterion("i_time not in", values, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeBetween(Date value1, Date value2) {
            addCriterion("i_time between", value1, value2, "iTime");
            return (Criteria) this;
        }

        public Criteria andITimeNotBetween(Date value1, Date value2) {
            addCriterion("i_time not between", value1, value2, "iTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeIsNull() {
            addCriterion("is_time is null");
            return (Criteria) this;
        }

        public Criteria andIsTimeIsNotNull() {
            addCriterion("is_time is not null");
            return (Criteria) this;
        }

        public Criteria andIsTimeEqualTo(Date value) {
            addCriterion("is_time =", value, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeNotEqualTo(Date value) {
            addCriterion("is_time <>", value, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeGreaterThan(Date value) {
            addCriterion("is_time >", value, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("is_time >=", value, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeLessThan(Date value) {
            addCriterion("is_time <", value, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeLessThanOrEqualTo(Date value) {
            addCriterion("is_time <=", value, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeIn(List<Date> values) {
            addCriterion("is_time in", values, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeNotIn(List<Date> values) {
            addCriterion("is_time not in", values, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeBetween(Date value1, Date value2) {
            addCriterion("is_time between", value1, value2, "isTime");
            return (Criteria) this;
        }

        public Criteria andIsTimeNotBetween(Date value1, Date value2) {
            addCriterion("is_time not between", value1, value2, "isTime");
            return (Criteria) this;
        }

        public Criteria andHairIdIsNull() {
            addCriterion("hair_id is null");
            return (Criteria) this;
        }

        public Criteria andHairIdIsNotNull() {
            addCriterion("hair_id is not null");
            return (Criteria) this;
        }

        public Criteria andHairIdEqualTo(String value) {
            addCriterion("hair_id =", value, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdNotEqualTo(String value) {
            addCriterion("hair_id <>", value, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdGreaterThan(String value) {
            addCriterion("hair_id >", value, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdGreaterThanOrEqualTo(String value) {
            addCriterion("hair_id >=", value, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdLessThan(String value) {
            addCriterion("hair_id <", value, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdLessThanOrEqualTo(String value) {
            addCriterion("hair_id <=", value, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdLike(String value) {
            addCriterion("hair_id like", value, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdNotLike(String value) {
            addCriterion("hair_id not like", value, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdIn(List<String> values) {
            addCriterion("hair_id in", values, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdNotIn(List<String> values) {
            addCriterion("hair_id not in", values, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdBetween(String value1, String value2) {
            addCriterion("hair_id between", value1, value2, "hairId");
            return (Criteria) this;
        }

        public Criteria andHairIdNotBetween(String value1, String value2) {
            addCriterion("hair_id not between", value1, value2, "hairId");
            return (Criteria) this;
        }

        public Criteria andChangingTimeIsNull() {
            addCriterion("changing_time is null");
            return (Criteria) this;
        }

        public Criteria andChangingTimeIsNotNull() {
            addCriterion("changing_time is not null");
            return (Criteria) this;
        }

        public Criteria andChangingTimeEqualTo(Date value) {
            addCriterion("changing_time =", value, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeNotEqualTo(Date value) {
            addCriterion("changing_time <>", value, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeGreaterThan(Date value) {
            addCriterion("changing_time >", value, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("changing_time >=", value, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeLessThan(Date value) {
            addCriterion("changing_time <", value, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeLessThanOrEqualTo(Date value) {
            addCriterion("changing_time <=", value, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeIn(List<Date> values) {
            addCriterion("changing_time in", values, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeNotIn(List<Date> values) {
            addCriterion("changing_time not in", values, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeBetween(Date value1, Date value2) {
            addCriterion("changing_time between", value1, value2, "changingTime");
            return (Criteria) this;
        }

        public Criteria andChangingTimeNotBetween(Date value1, Date value2) {
            addCriterion("changing_time not between", value1, value2, "changingTime");
            return (Criteria) this;
        }

        public Criteria andIModeIsNull() {
            addCriterion("i_mode is null");
            return (Criteria) this;
        }

        public Criteria andIModeIsNotNull() {
            addCriterion("i_mode is not null");
            return (Criteria) this;
        }

        public Criteria andIModeEqualTo(String value) {
            addCriterion("i_mode =", value, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeNotEqualTo(String value) {
            addCriterion("i_mode <>", value, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeGreaterThan(String value) {
            addCriterion("i_mode >", value, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeGreaterThanOrEqualTo(String value) {
            addCriterion("i_mode >=", value, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeLessThan(String value) {
            addCriterion("i_mode <", value, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeLessThanOrEqualTo(String value) {
            addCriterion("i_mode <=", value, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeLike(String value) {
            addCriterion("i_mode like", value, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeNotLike(String value) {
            addCriterion("i_mode not like", value, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeIn(List<String> values) {
            addCriterion("i_mode in", values, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeNotIn(List<String> values) {
            addCriterion("i_mode not in", values, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeBetween(String value1, String value2) {
            addCriterion("i_mode between", value1, value2, "iMode");
            return (Criteria) this;
        }

        public Criteria andIModeNotBetween(String value1, String value2) {
            addCriterion("i_mode not between", value1, value2, "iMode");
            return (Criteria) this;
        }

        public Criteria andIRefundIsNull() {
            addCriterion("i_refund is null");
            return (Criteria) this;
        }

        public Criteria andIRefundIsNotNull() {
            addCriterion("i_refund is not null");
            return (Criteria) this;
        }

        public Criteria andIRefundEqualTo(String value) {
            addCriterion("i_refund =", value, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundNotEqualTo(String value) {
            addCriterion("i_refund <>", value, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundGreaterThan(String value) {
            addCriterion("i_refund >", value, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundGreaterThanOrEqualTo(String value) {
            addCriterion("i_refund >=", value, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundLessThan(String value) {
            addCriterion("i_refund <", value, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundLessThanOrEqualTo(String value) {
            addCriterion("i_refund <=", value, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundLike(String value) {
            addCriterion("i_refund like", value, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundNotLike(String value) {
            addCriterion("i_refund not like", value, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundIn(List<String> values) {
            addCriterion("i_refund in", values, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundNotIn(List<String> values) {
            addCriterion("i_refund not in", values, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundBetween(String value1, String value2) {
            addCriterion("i_refund between", value1, value2, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundNotBetween(String value1, String value2) {
            addCriterion("i_refund not between", value1, value2, "iRefund");
            return (Criteria) this;
        }

        public Criteria andIRefundModelIsNull() {
            addCriterion("i_refund_model is null");
            return (Criteria) this;
        }

        public Criteria andIRefundModelIsNotNull() {
            addCriterion("i_refund_model is not null");
            return (Criteria) this;
        }

        public Criteria andIRefundModelEqualTo(String value) {
            addCriterion("i_refund_model =", value, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelNotEqualTo(String value) {
            addCriterion("i_refund_model <>", value, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelGreaterThan(String value) {
            addCriterion("i_refund_model >", value, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelGreaterThanOrEqualTo(String value) {
            addCriterion("i_refund_model >=", value, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelLessThan(String value) {
            addCriterion("i_refund_model <", value, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelLessThanOrEqualTo(String value) {
            addCriterion("i_refund_model <=", value, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelLike(String value) {
            addCriterion("i_refund_model like", value, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelNotLike(String value) {
            addCriterion("i_refund_model not like", value, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelIn(List<String> values) {
            addCriterion("i_refund_model in", values, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelNotIn(List<String> values) {
            addCriterion("i_refund_model not in", values, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelBetween(String value1, String value2) {
            addCriterion("i_refund_model between", value1, value2, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundModelNotBetween(String value1, String value2) {
            addCriterion("i_refund_model not between", value1, value2, "iRefundModel");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyIsNull() {
            addCriterion("i_refund_money is null");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyIsNotNull() {
            addCriterion("i_refund_money is not null");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyEqualTo(String value) {
            addCriterion("i_refund_money =", value, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyNotEqualTo(String value) {
            addCriterion("i_refund_money <>", value, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyGreaterThan(String value) {
            addCriterion("i_refund_money >", value, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("i_refund_money >=", value, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyLessThan(String value) {
            addCriterion("i_refund_money <", value, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyLessThanOrEqualTo(String value) {
            addCriterion("i_refund_money <=", value, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyLike(String value) {
            addCriterion("i_refund_money like", value, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyNotLike(String value) {
            addCriterion("i_refund_money not like", value, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyIn(List<String> values) {
            addCriterion("i_refund_money in", values, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyNotIn(List<String> values) {
            addCriterion("i_refund_money not in", values, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyBetween(String value1, String value2) {
            addCriterion("i_refund_money between", value1, value2, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andIRefundMoneyNotBetween(String value1, String value2) {
            addCriterion("i_refund_money not between", value1, value2, "iRefundMoney");
            return (Criteria) this;
        }

        public Criteria andConditionIsNull() {
            addCriterion("condition is null");
            return (Criteria) this;
        }

        public Criteria andConditionIsNotNull() {
            addCriterion("condition is not null");
            return (Criteria) this;
        }

        public Criteria andConditionEqualTo(String value) {
            addCriterion("condition =", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotEqualTo(String value) {
            addCriterion("condition <>", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThan(String value) {
            addCriterion("condition >", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThanOrEqualTo(String value) {
            addCriterion("condition >=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThan(String value) {
            addCriterion("condition <", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThanOrEqualTo(String value) {
            addCriterion("condition <=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLike(String value) {
            addCriterion("condition like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotLike(String value) {
            addCriterion("condition not like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionIn(List<String> values) {
            addCriterion("condition in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotIn(List<String> values) {
            addCriterion("condition not in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionBetween(String value1, String value2) {
            addCriterion("condition between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotBetween(String value1, String value2) {
            addCriterion("condition not between", value1, value2, "condition");
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