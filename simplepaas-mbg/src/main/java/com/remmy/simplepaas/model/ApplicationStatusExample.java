package com.remmy.simplepaas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationStatusExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Integer value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Integer value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Integer value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Integer value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Integer> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Integer> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Integer value1, Integer value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andTargetNumIsNull() {
            addCriterion("target_num is null");
            return (Criteria) this;
        }

        public Criteria andTargetNumIsNotNull() {
            addCriterion("target_num is not null");
            return (Criteria) this;
        }

        public Criteria andTargetNumEqualTo(Integer value) {
            addCriterion("target_num =", value, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumNotEqualTo(Integer value) {
            addCriterion("target_num <>", value, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumGreaterThan(Integer value) {
            addCriterion("target_num >", value, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_num >=", value, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumLessThan(Integer value) {
            addCriterion("target_num <", value, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumLessThanOrEqualTo(Integer value) {
            addCriterion("target_num <=", value, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumIn(List<Integer> values) {
            addCriterion("target_num in", values, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumNotIn(List<Integer> values) {
            addCriterion("target_num not in", values, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumBetween(Integer value1, Integer value2) {
            addCriterion("target_num between", value1, value2, "targetNum");
            return (Criteria) this;
        }

        public Criteria andTargetNumNotBetween(Integer value1, Integer value2) {
            addCriterion("target_num not between", value1, value2, "targetNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumIsNull() {
            addCriterion("available_num is null");
            return (Criteria) this;
        }

        public Criteria andAvailableNumIsNotNull() {
            addCriterion("available_num is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableNumEqualTo(Integer value) {
            addCriterion("available_num =", value, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumNotEqualTo(Integer value) {
            addCriterion("available_num <>", value, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumGreaterThan(Integer value) {
            addCriterion("available_num >", value, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("available_num >=", value, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumLessThan(Integer value) {
            addCriterion("available_num <", value, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumLessThanOrEqualTo(Integer value) {
            addCriterion("available_num <=", value, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumIn(List<Integer> values) {
            addCriterion("available_num in", values, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumNotIn(List<Integer> values) {
            addCriterion("available_num not in", values, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumBetween(Integer value1, Integer value2) {
            addCriterion("available_num between", value1, value2, "availableNum");
            return (Criteria) this;
        }

        public Criteria andAvailableNumNotBetween(Integer value1, Integer value2) {
            addCriterion("available_num not between", value1, value2, "availableNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumIsNull() {
            addCriterion("update_num is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNumIsNotNull() {
            addCriterion("update_num is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNumEqualTo(Integer value) {
            addCriterion("update_num =", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotEqualTo(Integer value) {
            addCriterion("update_num <>", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumGreaterThan(Integer value) {
            addCriterion("update_num >", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_num >=", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumLessThan(Integer value) {
            addCriterion("update_num <", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumLessThanOrEqualTo(Integer value) {
            addCriterion("update_num <=", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumIn(List<Integer> values) {
            addCriterion("update_num in", values, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotIn(List<Integer> values) {
            addCriterion("update_num not in", values, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumBetween(Integer value1, Integer value2) {
            addCriterion("update_num between", value1, value2, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotBetween(Integer value1, Integer value2) {
            addCriterion("update_num not between", value1, value2, "updateNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumIsNull() {
            addCriterion("ready_num is null");
            return (Criteria) this;
        }

        public Criteria andReadyNumIsNotNull() {
            addCriterion("ready_num is not null");
            return (Criteria) this;
        }

        public Criteria andReadyNumEqualTo(Integer value) {
            addCriterion("ready_num =", value, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumNotEqualTo(Integer value) {
            addCriterion("ready_num <>", value, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumGreaterThan(Integer value) {
            addCriterion("ready_num >", value, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ready_num >=", value, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumLessThan(Integer value) {
            addCriterion("ready_num <", value, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumLessThanOrEqualTo(Integer value) {
            addCriterion("ready_num <=", value, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumIn(List<Integer> values) {
            addCriterion("ready_num in", values, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumNotIn(List<Integer> values) {
            addCriterion("ready_num not in", values, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumBetween(Integer value1, Integer value2) {
            addCriterion("ready_num between", value1, value2, "readyNum");
            return (Criteria) this;
        }

        public Criteria andReadyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ready_num not between", value1, value2, "readyNum");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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