package com.litte.entity.reception;

import java.util.ArrayList;
import java.util.List;

public class TCouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCouponExample() {
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

        public Criteria andCCodeIsNull() {
            addCriterion("c_code is null");
            return (Criteria) this;
        }

        public Criteria andCCodeIsNotNull() {
            addCriterion("c_code is not null");
            return (Criteria) this;
        }

        public Criteria andCCodeEqualTo(String value) {
            addCriterion("c_code =", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotEqualTo(String value) {
            addCriterion("c_code <>", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeGreaterThan(String value) {
            addCriterion("c_code >", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeGreaterThanOrEqualTo(String value) {
            addCriterion("c_code >=", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLessThan(String value) {
            addCriterion("c_code <", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLessThanOrEqualTo(String value) {
            addCriterion("c_code <=", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLike(String value) {
            addCriterion("c_code like", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotLike(String value) {
            addCriterion("c_code not like", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeIn(List<String> values) {
            addCriterion("c_code in", values, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotIn(List<String> values) {
            addCriterion("c_code not in", values, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeBetween(String value1, String value2) {
            addCriterion("c_code between", value1, value2, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotBetween(String value1, String value2) {
            addCriterion("c_code not between", value1, value2, "cCode");
            return (Criteria) this;
        }

        public Criteria andCMoneyIsNull() {
            addCriterion("c_money is null");
            return (Criteria) this;
        }

        public Criteria andCMoneyIsNotNull() {
            addCriterion("c_money is not null");
            return (Criteria) this;
        }

        public Criteria andCMoneyEqualTo(String value) {
            addCriterion("c_money =", value, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyNotEqualTo(String value) {
            addCriterion("c_money <>", value, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyGreaterThan(String value) {
            addCriterion("c_money >", value, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("c_money >=", value, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyLessThan(String value) {
            addCriterion("c_money <", value, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyLessThanOrEqualTo(String value) {
            addCriterion("c_money <=", value, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyLike(String value) {
            addCriterion("c_money like", value, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyNotLike(String value) {
            addCriterion("c_money not like", value, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyIn(List<String> values) {
            addCriterion("c_money in", values, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyNotIn(List<String> values) {
            addCriterion("c_money not in", values, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyBetween(String value1, String value2) {
            addCriterion("c_money between", value1, value2, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyNotBetween(String value1, String value2) {
            addCriterion("c_money not between", value1, value2, "cMoney");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsIsNull() {
            addCriterion("c_money_receipts is null");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsIsNotNull() {
            addCriterion("c_money_receipts is not null");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsEqualTo(String value) {
            addCriterion("c_money_receipts =", value, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsNotEqualTo(String value) {
            addCriterion("c_money_receipts <>", value, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsGreaterThan(String value) {
            addCriterion("c_money_receipts >", value, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsGreaterThanOrEqualTo(String value) {
            addCriterion("c_money_receipts >=", value, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsLessThan(String value) {
            addCriterion("c_money_receipts <", value, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsLessThanOrEqualTo(String value) {
            addCriterion("c_money_receipts <=", value, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsLike(String value) {
            addCriterion("c_money_receipts like", value, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsNotLike(String value) {
            addCriterion("c_money_receipts not like", value, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsIn(List<String> values) {
            addCriterion("c_money_receipts in", values, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsNotIn(List<String> values) {
            addCriterion("c_money_receipts not in", values, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsBetween(String value1, String value2) {
            addCriterion("c_money_receipts between", value1, value2, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andCMoneyReceiptsNotBetween(String value1, String value2) {
            addCriterion("c_money_receipts not between", value1, value2, "cMoneyReceipts");
            return (Criteria) this;
        }

        public Criteria andIsStatusIsNull() {
            addCriterion("is_status is null");
            return (Criteria) this;
        }

        public Criteria andIsStatusIsNotNull() {
            addCriterion("is_status is not null");
            return (Criteria) this;
        }

        public Criteria andIsStatusEqualTo(String value) {
            addCriterion("is_status =", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotEqualTo(String value) {
            addCriterion("is_status <>", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusGreaterThan(String value) {
            addCriterion("is_status >", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("is_status >=", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLessThan(String value) {
            addCriterion("is_status <", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLessThanOrEqualTo(String value) {
            addCriterion("is_status <=", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLike(String value) {
            addCriterion("is_status like", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotLike(String value) {
            addCriterion("is_status not like", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusIn(List<String> values) {
            addCriterion("is_status in", values, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotIn(List<String> values) {
            addCriterion("is_status not in", values, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusBetween(String value1, String value2) {
            addCriterion("is_status between", value1, value2, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotBetween(String value1, String value2) {
            addCriterion("is_status not between", value1, value2, "isStatus");
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