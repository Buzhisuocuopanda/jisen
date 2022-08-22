package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CboeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CboeCriteria() {
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

        public Criteria andCboe01IsNull() {
            addCriterion("CBOE01 is null");
            return (Criteria) this;
        }

        public Criteria andCboe01IsNotNull() {
            addCriterion("CBOE01 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe01EqualTo(Integer value) {
            addCriterion("CBOE01 =", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01NotEqualTo(Integer value) {
            addCriterion("CBOE01 <>", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01GreaterThan(Integer value) {
            addCriterion("CBOE01 >", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOE01 >=", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01LessThan(Integer value) {
            addCriterion("CBOE01 <", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOE01 <=", value, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01In(List<Integer> values) {
            addCriterion("CBOE01 in", values, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01NotIn(List<Integer> values) {
            addCriterion("CBOE01 not in", values, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01Between(Integer value1, Integer value2) {
            addCriterion("CBOE01 between", value1, value2, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOE01 not between", value1, value2, "cboe01");
            return (Criteria) this;
        }

        public Criteria andCboe02IsNull() {
            addCriterion("CBOE02 is null");
            return (Criteria) this;
        }

        public Criteria andCboe02IsNotNull() {
            addCriterion("CBOE02 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe02EqualTo(Date value) {
            addCriterion("CBOE02 =", value, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02NotEqualTo(Date value) {
            addCriterion("CBOE02 <>", value, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02GreaterThan(Date value) {
            addCriterion("CBOE02 >", value, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOE02 >=", value, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02LessThan(Date value) {
            addCriterion("CBOE02 <", value, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02LessThanOrEqualTo(Date value) {
            addCriterion("CBOE02 <=", value, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02In(List<Date> values) {
            addCriterion("CBOE02 in", values, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02NotIn(List<Date> values) {
            addCriterion("CBOE02 not in", values, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02Between(Date value1, Date value2) {
            addCriterion("CBOE02 between", value1, value2, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe02NotBetween(Date value1, Date value2) {
            addCriterion("CBOE02 not between", value1, value2, "cboe02");
            return (Criteria) this;
        }

        public Criteria andCboe03IsNull() {
            addCriterion("CBOE03 is null");
            return (Criteria) this;
        }

        public Criteria andCboe03IsNotNull() {
            addCriterion("CBOE03 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe03EqualTo(Integer value) {
            addCriterion("CBOE03 =", value, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03NotEqualTo(Integer value) {
            addCriterion("CBOE03 <>", value, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03GreaterThan(Integer value) {
            addCriterion("CBOE03 >", value, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOE03 >=", value, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03LessThan(Integer value) {
            addCriterion("CBOE03 <", value, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03LessThanOrEqualTo(Integer value) {
            addCriterion("CBOE03 <=", value, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03In(List<Integer> values) {
            addCriterion("CBOE03 in", values, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03NotIn(List<Integer> values) {
            addCriterion("CBOE03 not in", values, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03Between(Integer value1, Integer value2) {
            addCriterion("CBOE03 between", value1, value2, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOE03 not between", value1, value2, "cboe03");
            return (Criteria) this;
        }

        public Criteria andCboe04IsNull() {
            addCriterion("CBOE04 is null");
            return (Criteria) this;
        }

        public Criteria andCboe04IsNotNull() {
            addCriterion("CBOE04 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe04EqualTo(Date value) {
            addCriterion("CBOE04 =", value, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04NotEqualTo(Date value) {
            addCriterion("CBOE04 <>", value, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04GreaterThan(Date value) {
            addCriterion("CBOE04 >", value, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOE04 >=", value, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04LessThan(Date value) {
            addCriterion("CBOE04 <", value, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04LessThanOrEqualTo(Date value) {
            addCriterion("CBOE04 <=", value, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04In(List<Date> values) {
            addCriterion("CBOE04 in", values, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04NotIn(List<Date> values) {
            addCriterion("CBOE04 not in", values, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04Between(Date value1, Date value2) {
            addCriterion("CBOE04 between", value1, value2, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe04NotBetween(Date value1, Date value2) {
            addCriterion("CBOE04 not between", value1, value2, "cboe04");
            return (Criteria) this;
        }

        public Criteria andCboe05IsNull() {
            addCriterion("CBOE05 is null");
            return (Criteria) this;
        }

        public Criteria andCboe05IsNotNull() {
            addCriterion("CBOE05 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe05EqualTo(Integer value) {
            addCriterion("CBOE05 =", value, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05NotEqualTo(Integer value) {
            addCriterion("CBOE05 <>", value, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05GreaterThan(Integer value) {
            addCriterion("CBOE05 >", value, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOE05 >=", value, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05LessThan(Integer value) {
            addCriterion("CBOE05 <", value, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05LessThanOrEqualTo(Integer value) {
            addCriterion("CBOE05 <=", value, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05In(List<Integer> values) {
            addCriterion("CBOE05 in", values, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05NotIn(List<Integer> values) {
            addCriterion("CBOE05 not in", values, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05Between(Integer value1, Integer value2) {
            addCriterion("CBOE05 between", value1, value2, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOE05 not between", value1, value2, "cboe05");
            return (Criteria) this;
        }

        public Criteria andCboe06IsNull() {
            addCriterion("CBOE06 is null");
            return (Criteria) this;
        }

        public Criteria andCboe06IsNotNull() {
            addCriterion("CBOE06 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe06EqualTo(Integer value) {
            addCriterion("CBOE06 =", value, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06NotEqualTo(Integer value) {
            addCriterion("CBOE06 <>", value, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06GreaterThan(Integer value) {
            addCriterion("CBOE06 >", value, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOE06 >=", value, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06LessThan(Integer value) {
            addCriterion("CBOE06 <", value, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06LessThanOrEqualTo(Integer value) {
            addCriterion("CBOE06 <=", value, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06In(List<Integer> values) {
            addCriterion("CBOE06 in", values, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06NotIn(List<Integer> values) {
            addCriterion("CBOE06 not in", values, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06Between(Integer value1, Integer value2) {
            addCriterion("CBOE06 between", value1, value2, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOE06 not between", value1, value2, "cboe06");
            return (Criteria) this;
        }

        public Criteria andCboe07IsNull() {
            addCriterion("CBOE07 is null");
            return (Criteria) this;
        }

        public Criteria andCboe07IsNotNull() {
            addCriterion("CBOE07 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe07EqualTo(String value) {
            addCriterion("CBOE07 =", value, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07NotEqualTo(String value) {
            addCriterion("CBOE07 <>", value, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07GreaterThan(String value) {
            addCriterion("CBOE07 >", value, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07GreaterThanOrEqualTo(String value) {
            addCriterion("CBOE07 >=", value, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07LessThan(String value) {
            addCriterion("CBOE07 <", value, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07LessThanOrEqualTo(String value) {
            addCriterion("CBOE07 <=", value, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07Like(String value) {
            addCriterion("CBOE07 like", value, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07NotLike(String value) {
            addCriterion("CBOE07 not like", value, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07In(List<String> values) {
            addCriterion("CBOE07 in", values, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07NotIn(List<String> values) {
            addCriterion("CBOE07 not in", values, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07Between(String value1, String value2) {
            addCriterion("CBOE07 between", value1, value2, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe07NotBetween(String value1, String value2) {
            addCriterion("CBOE07 not between", value1, value2, "cboe07");
            return (Criteria) this;
        }

        public Criteria andCboe08IsNull() {
            addCriterion("CBOE08 is null");
            return (Criteria) this;
        }

        public Criteria andCboe08IsNotNull() {
            addCriterion("CBOE08 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe08EqualTo(Date value) {
            addCriterion("CBOE08 =", value, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08NotEqualTo(Date value) {
            addCriterion("CBOE08 <>", value, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08GreaterThan(Date value) {
            addCriterion("CBOE08 >", value, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOE08 >=", value, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08LessThan(Date value) {
            addCriterion("CBOE08 <", value, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08LessThanOrEqualTo(Date value) {
            addCriterion("CBOE08 <=", value, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08In(List<Date> values) {
            addCriterion("CBOE08 in", values, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08NotIn(List<Date> values) {
            addCriterion("CBOE08 not in", values, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08Between(Date value1, Date value2) {
            addCriterion("CBOE08 between", value1, value2, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe08NotBetween(Date value1, Date value2) {
            addCriterion("CBOE08 not between", value1, value2, "cboe08");
            return (Criteria) this;
        }

        public Criteria andCboe10IsNull() {
            addCriterion("CBOE10 is null");
            return (Criteria) this;
        }

        public Criteria andCboe10IsNotNull() {
            addCriterion("CBOE10 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe10EqualTo(Integer value) {
            addCriterion("CBOE10 =", value, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10NotEqualTo(Integer value) {
            addCriterion("CBOE10 <>", value, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10GreaterThan(Integer value) {
            addCriterion("CBOE10 >", value, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOE10 >=", value, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10LessThan(Integer value) {
            addCriterion("CBOE10 <", value, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10LessThanOrEqualTo(Integer value) {
            addCriterion("CBOE10 <=", value, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10In(List<Integer> values) {
            addCriterion("CBOE10 in", values, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10NotIn(List<Integer> values) {
            addCriterion("CBOE10 not in", values, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10Between(Integer value1, Integer value2) {
            addCriterion("CBOE10 between", value1, value2, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOE10 not between", value1, value2, "cboe10");
            return (Criteria) this;
        }

        public Criteria andCboe21IsNull() {
            addCriterion("CBOE21 is null");
            return (Criteria) this;
        }

        public Criteria andCboe21IsNotNull() {
            addCriterion("CBOE21 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe21EqualTo(String value) {
            addCriterion("CBOE21 =", value, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21NotEqualTo(String value) {
            addCriterion("CBOE21 <>", value, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21GreaterThan(String value) {
            addCriterion("CBOE21 >", value, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21GreaterThanOrEqualTo(String value) {
            addCriterion("CBOE21 >=", value, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21LessThan(String value) {
            addCriterion("CBOE21 <", value, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21LessThanOrEqualTo(String value) {
            addCriterion("CBOE21 <=", value, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21Like(String value) {
            addCriterion("CBOE21 like", value, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21NotLike(String value) {
            addCriterion("CBOE21 not like", value, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21In(List<String> values) {
            addCriterion("CBOE21 in", values, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21NotIn(List<String> values) {
            addCriterion("CBOE21 not in", values, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21Between(String value1, String value2) {
            addCriterion("CBOE21 between", value1, value2, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe21NotBetween(String value1, String value2) {
            addCriterion("CBOE21 not between", value1, value2, "cboe21");
            return (Criteria) this;
        }

        public Criteria andCboe09IsNull() {
            addCriterion("CBOE09 is null");
            return (Criteria) this;
        }

        public Criteria andCboe09IsNotNull() {
            addCriterion("CBOE09 is not null");
            return (Criteria) this;
        }

        public Criteria andCboe09EqualTo(Integer value) {
            addCriterion("CBOE09 =", value, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09NotEqualTo(Integer value) {
            addCriterion("CBOE09 <>", value, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09GreaterThan(Integer value) {
            addCriterion("CBOE09 >", value, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOE09 >=", value, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09LessThan(Integer value) {
            addCriterion("CBOE09 <", value, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09LessThanOrEqualTo(Integer value) {
            addCriterion("CBOE09 <=", value, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09In(List<Integer> values) {
            addCriterion("CBOE09 in", values, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09NotIn(List<Integer> values) {
            addCriterion("CBOE09 not in", values, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09Between(Integer value1, Integer value2) {
            addCriterion("CBOE09 between", value1, value2, "cboe09");
            return (Criteria) this;
        }

        public Criteria andCboe09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOE09 not between", value1, value2, "cboe09");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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