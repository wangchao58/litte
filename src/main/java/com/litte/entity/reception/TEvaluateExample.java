package com.litte.entity.reception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEvaluateExample() {
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

        public Criteria andEUseridIsNull() {
            addCriterion("e_userid is null");
            return (Criteria) this;
        }

        public Criteria andEUseridIsNotNull() {
            addCriterion("e_userid is not null");
            return (Criteria) this;
        }

        public Criteria andEUseridEqualTo(String value) {
            addCriterion("e_userid =", value, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridNotEqualTo(String value) {
            addCriterion("e_userid <>", value, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridGreaterThan(String value) {
            addCriterion("e_userid >", value, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridGreaterThanOrEqualTo(String value) {
            addCriterion("e_userid >=", value, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridLessThan(String value) {
            addCriterion("e_userid <", value, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridLessThanOrEqualTo(String value) {
            addCriterion("e_userid <=", value, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridLike(String value) {
            addCriterion("e_userid like", value, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridNotLike(String value) {
            addCriterion("e_userid not like", value, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridIn(List<String> values) {
            addCriterion("e_userid in", values, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridNotIn(List<String> values) {
            addCriterion("e_userid not in", values, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridBetween(String value1, String value2) {
            addCriterion("e_userid between", value1, value2, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEUseridNotBetween(String value1, String value2) {
            addCriterion("e_userid not between", value1, value2, "eUserid");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIsNull() {
            addCriterion("e_person_shop is null");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIsNotNull() {
            addCriterion("e_person_shop is not null");
            return (Criteria) this;
        }

        public Criteria andEPersonShopEqualTo(String value) {
            addCriterion("e_person_shop =", value, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopNotEqualTo(String value) {
            addCriterion("e_person_shop <>", value, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopGreaterThan(String value) {
            addCriterion("e_person_shop >", value, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopGreaterThanOrEqualTo(String value) {
            addCriterion("e_person_shop >=", value, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopLessThan(String value) {
            addCriterion("e_person_shop <", value, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopLessThanOrEqualTo(String value) {
            addCriterion("e_person_shop <=", value, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopLike(String value) {
            addCriterion("e_person_shop like", value, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopNotLike(String value) {
            addCriterion("e_person_shop not like", value, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIn(List<String> values) {
            addCriterion("e_person_shop in", values, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopNotIn(List<String> values) {
            addCriterion("e_person_shop not in", values, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopBetween(String value1, String value2) {
            addCriterion("e_person_shop between", value1, value2, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopNotBetween(String value1, String value2) {
            addCriterion("e_person_shop not between", value1, value2, "ePersonShop");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdIsNull() {
            addCriterion("e_person_shop_id is null");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdIsNotNull() {
            addCriterion("e_person_shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdEqualTo(String value) {
            addCriterion("e_person_shop_id =", value, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdNotEqualTo(String value) {
            addCriterion("e_person_shop_id <>", value, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdGreaterThan(String value) {
            addCriterion("e_person_shop_id >", value, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("e_person_shop_id >=", value, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdLessThan(String value) {
            addCriterion("e_person_shop_id <", value, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdLessThanOrEqualTo(String value) {
            addCriterion("e_person_shop_id <=", value, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdLike(String value) {
            addCriterion("e_person_shop_id like", value, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdNotLike(String value) {
            addCriterion("e_person_shop_id not like", value, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdIn(List<String> values) {
            addCriterion("e_person_shop_id in", values, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdNotIn(List<String> values) {
            addCriterion("e_person_shop_id not in", values, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdBetween(String value1, String value2) {
            addCriterion("e_person_shop_id between", value1, value2, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEPersonShopIdNotBetween(String value1, String value2) {
            addCriterion("e_person_shop_id not between", value1, value2, "ePersonShopId");
            return (Criteria) this;
        }

        public Criteria andEContentIsNull() {
            addCriterion("e_content is null");
            return (Criteria) this;
        }

        public Criteria andEContentIsNotNull() {
            addCriterion("e_content is not null");
            return (Criteria) this;
        }

        public Criteria andEContentEqualTo(String value) {
            addCriterion("e_content =", value, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentNotEqualTo(String value) {
            addCriterion("e_content <>", value, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentGreaterThan(String value) {
            addCriterion("e_content >", value, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentGreaterThanOrEqualTo(String value) {
            addCriterion("e_content >=", value, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentLessThan(String value) {
            addCriterion("e_content <", value, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentLessThanOrEqualTo(String value) {
            addCriterion("e_content <=", value, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentLike(String value) {
            addCriterion("e_content like", value, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentNotLike(String value) {
            addCriterion("e_content not like", value, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentIn(List<String> values) {
            addCriterion("e_content in", values, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentNotIn(List<String> values) {
            addCriterion("e_content not in", values, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentBetween(String value1, String value2) {
            addCriterion("e_content between", value1, value2, "eContent");
            return (Criteria) this;
        }

        public Criteria andEContentNotBetween(String value1, String value2) {
            addCriterion("e_content not between", value1, value2, "eContent");
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