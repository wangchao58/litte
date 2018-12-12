package com.litte.entity.reception;

import java.util.ArrayList;
import java.util.List;

public class TShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TShopExample() {
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

        public Criteria andSSiteIsNull() {
            addCriterion("s_site is null");
            return (Criteria) this;
        }

        public Criteria andSSiteIsNotNull() {
            addCriterion("s_site is not null");
            return (Criteria) this;
        }

        public Criteria andSSiteEqualTo(String value) {
            addCriterion("s_site =", value, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteNotEqualTo(String value) {
            addCriterion("s_site <>", value, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteGreaterThan(String value) {
            addCriterion("s_site >", value, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteGreaterThanOrEqualTo(String value) {
            addCriterion("s_site >=", value, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteLessThan(String value) {
            addCriterion("s_site <", value, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteLessThanOrEqualTo(String value) {
            addCriterion("s_site <=", value, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteLike(String value) {
            addCriterion("s_site like", value, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteNotLike(String value) {
            addCriterion("s_site not like", value, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteIn(List<String> values) {
            addCriterion("s_site in", values, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteNotIn(List<String> values) {
            addCriterion("s_site not in", values, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteBetween(String value1, String value2) {
            addCriterion("s_site between", value1, value2, "sSite");
            return (Criteria) this;
        }

        public Criteria andSSiteNotBetween(String value1, String value2) {
            addCriterion("s_site not between", value1, value2, "sSite");
            return (Criteria) this;
        }

        public Criteria andSPortraitIsNull() {
            addCriterion("s_portrait is null");
            return (Criteria) this;
        }

        public Criteria andSPortraitIsNotNull() {
            addCriterion("s_portrait is not null");
            return (Criteria) this;
        }

        public Criteria andSPortraitEqualTo(String value) {
            addCriterion("s_portrait =", value, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitNotEqualTo(String value) {
            addCriterion("s_portrait <>", value, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitGreaterThan(String value) {
            addCriterion("s_portrait >", value, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("s_portrait >=", value, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitLessThan(String value) {
            addCriterion("s_portrait <", value, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitLessThanOrEqualTo(String value) {
            addCriterion("s_portrait <=", value, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitLike(String value) {
            addCriterion("s_portrait like", value, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitNotLike(String value) {
            addCriterion("s_portrait not like", value, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitIn(List<String> values) {
            addCriterion("s_portrait in", values, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitNotIn(List<String> values) {
            addCriterion("s_portrait not in", values, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitBetween(String value1, String value2) {
            addCriterion("s_portrait between", value1, value2, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSPortraitNotBetween(String value1, String value2) {
            addCriterion("s_portrait not between", value1, value2, "sPortrait");
            return (Criteria) this;
        }

        public Criteria andSLongitudeIsNull() {
            addCriterion("s_longitude is null");
            return (Criteria) this;
        }

        public Criteria andSLongitudeIsNotNull() {
            addCriterion("s_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andSLongitudeEqualTo(String value) {
            addCriterion("s_longitude =", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeNotEqualTo(String value) {
            addCriterion("s_longitude <>", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeGreaterThan(String value) {
            addCriterion("s_longitude >", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("s_longitude >=", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeLessThan(String value) {
            addCriterion("s_longitude <", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeLessThanOrEqualTo(String value) {
            addCriterion("s_longitude <=", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeLike(String value) {
            addCriterion("s_longitude like", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeNotLike(String value) {
            addCriterion("s_longitude not like", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeIn(List<String> values) {
            addCriterion("s_longitude in", values, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeNotIn(List<String> values) {
            addCriterion("s_longitude not in", values, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeBetween(String value1, String value2) {
            addCriterion("s_longitude between", value1, value2, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeNotBetween(String value1, String value2) {
            addCriterion("s_longitude not between", value1, value2, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeIsNull() {
            addCriterion("s_latitude is null");
            return (Criteria) this;
        }

        public Criteria andSLatitudeIsNotNull() {
            addCriterion("s_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andSLatitudeEqualTo(String value) {
            addCriterion("s_latitude =", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeNotEqualTo(String value) {
            addCriterion("s_latitude <>", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeGreaterThan(String value) {
            addCriterion("s_latitude >", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("s_latitude >=", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeLessThan(String value) {
            addCriterion("s_latitude <", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeLessThanOrEqualTo(String value) {
            addCriterion("s_latitude <=", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeLike(String value) {
            addCriterion("s_latitude like", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeNotLike(String value) {
            addCriterion("s_latitude not like", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeIn(List<String> values) {
            addCriterion("s_latitude in", values, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeNotIn(List<String> values) {
            addCriterion("s_latitude not in", values, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeBetween(String value1, String value2) {
            addCriterion("s_latitude between", value1, value2, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeNotBetween(String value1, String value2) {
            addCriterion("s_latitude not between", value1, value2, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSIntroductionIsNull() {
            addCriterion("s_introduction is null");
            return (Criteria) this;
        }

        public Criteria andSIntroductionIsNotNull() {
            addCriterion("s_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andSIntroductionEqualTo(String value) {
            addCriterion("s_introduction =", value, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionNotEqualTo(String value) {
            addCriterion("s_introduction <>", value, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionGreaterThan(String value) {
            addCriterion("s_introduction >", value, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("s_introduction >=", value, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionLessThan(String value) {
            addCriterion("s_introduction <", value, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionLessThanOrEqualTo(String value) {
            addCriterion("s_introduction <=", value, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionLike(String value) {
            addCriterion("s_introduction like", value, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionNotLike(String value) {
            addCriterion("s_introduction not like", value, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionIn(List<String> values) {
            addCriterion("s_introduction in", values, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionNotIn(List<String> values) {
            addCriterion("s_introduction not in", values, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionBetween(String value1, String value2) {
            addCriterion("s_introduction between", value1, value2, "sIntroduction");
            return (Criteria) this;
        }

        public Criteria andSIntroductionNotBetween(String value1, String value2) {
            addCriterion("s_introduction not between", value1, value2, "sIntroduction");
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