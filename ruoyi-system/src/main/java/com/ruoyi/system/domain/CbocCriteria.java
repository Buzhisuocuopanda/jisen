package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbocCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbocCriteria() {
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

        public Criteria andCboc01IsNull() {
            addCriterion("CBOC01 is null");
            return (Criteria) this;
        }

        public Criteria andCboc01IsNotNull() {
            addCriterion("CBOC01 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc01EqualTo(Integer value) {
            addCriterion("CBOC01 =", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01NotEqualTo(Integer value) {
            addCriterion("CBOC01 <>", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01GreaterThan(Integer value) {
            addCriterion("CBOC01 >", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC01 >=", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01LessThan(Integer value) {
            addCriterion("CBOC01 <", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC01 <=", value, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01In(List<Integer> values) {
            addCriterion("CBOC01 in", values, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01NotIn(List<Integer> values) {
            addCriterion("CBOC01 not in", values, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01Between(Integer value1, Integer value2) {
            addCriterion("CBOC01 between", value1, value2, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC01 not between", value1, value2, "cboc01");
            return (Criteria) this;
        }

        public Criteria andCboc02IsNull() {
            addCriterion("CBOC02 is null");
            return (Criteria) this;
        }

        public Criteria andCboc02IsNotNull() {
            addCriterion("CBOC02 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc02EqualTo(Date value) {
            addCriterion("CBOC02 =", value, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02NotEqualTo(Date value) {
            addCriterion("CBOC02 <>", value, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02GreaterThan(Date value) {
            addCriterion("CBOC02 >", value, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOC02 >=", value, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02LessThan(Date value) {
            addCriterion("CBOC02 <", value, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02LessThanOrEqualTo(Date value) {
            addCriterion("CBOC02 <=", value, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02In(List<Date> values) {
            addCriterion("CBOC02 in", values, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02NotIn(List<Date> values) {
            addCriterion("CBOC02 not in", values, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02Between(Date value1, Date value2) {
            addCriterion("CBOC02 between", value1, value2, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc02NotBetween(Date value1, Date value2) {
            addCriterion("CBOC02 not between", value1, value2, "cboc02");
            return (Criteria) this;
        }

        public Criteria andCboc03IsNull() {
            addCriterion("CBOC03 is null");
            return (Criteria) this;
        }

        public Criteria andCboc03IsNotNull() {
            addCriterion("CBOC03 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc03EqualTo(Integer value) {
            addCriterion("CBOC03 =", value, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03NotEqualTo(Integer value) {
            addCriterion("CBOC03 <>", value, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03GreaterThan(Integer value) {
            addCriterion("CBOC03 >", value, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC03 >=", value, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03LessThan(Integer value) {
            addCriterion("CBOC03 <", value, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC03 <=", value, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03In(List<Integer> values) {
            addCriterion("CBOC03 in", values, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03NotIn(List<Integer> values) {
            addCriterion("CBOC03 not in", values, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03Between(Integer value1, Integer value2) {
            addCriterion("CBOC03 between", value1, value2, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc03NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC03 not between", value1, value2, "cboc03");
            return (Criteria) this;
        }

        public Criteria andCboc04IsNull() {
            addCriterion("CBOC04 is null");
            return (Criteria) this;
        }

        public Criteria andCboc04IsNotNull() {
            addCriterion("CBOC04 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc04EqualTo(Date value) {
            addCriterion("CBOC04 =", value, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04NotEqualTo(Date value) {
            addCriterion("CBOC04 <>", value, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04GreaterThan(Date value) {
            addCriterion("CBOC04 >", value, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOC04 >=", value, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04LessThan(Date value) {
            addCriterion("CBOC04 <", value, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04LessThanOrEqualTo(Date value) {
            addCriterion("CBOC04 <=", value, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04In(List<Date> values) {
            addCriterion("CBOC04 in", values, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04NotIn(List<Date> values) {
            addCriterion("CBOC04 not in", values, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04Between(Date value1, Date value2) {
            addCriterion("CBOC04 between", value1, value2, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc04NotBetween(Date value1, Date value2) {
            addCriterion("CBOC04 not between", value1, value2, "cboc04");
            return (Criteria) this;
        }

        public Criteria andCboc05IsNull() {
            addCriterion("CBOC05 is null");
            return (Criteria) this;
        }

        public Criteria andCboc05IsNotNull() {
            addCriterion("CBOC05 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc05EqualTo(Integer value) {
            addCriterion("CBOC05 =", value, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05NotEqualTo(Integer value) {
            addCriterion("CBOC05 <>", value, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05GreaterThan(Integer value) {
            addCriterion("CBOC05 >", value, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC05 >=", value, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05LessThan(Integer value) {
            addCriterion("CBOC05 <", value, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC05 <=", value, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05In(List<Integer> values) {
            addCriterion("CBOC05 in", values, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05NotIn(List<Integer> values) {
            addCriterion("CBOC05 not in", values, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05Between(Integer value1, Integer value2) {
            addCriterion("CBOC05 between", value1, value2, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc05NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC05 not between", value1, value2, "cboc05");
            return (Criteria) this;
        }

        public Criteria andCboc06IsNull() {
            addCriterion("CBOC06 is null");
            return (Criteria) this;
        }

        public Criteria andCboc06IsNotNull() {
            addCriterion("CBOC06 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc06EqualTo(Integer value) {
            addCriterion("CBOC06 =", value, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06NotEqualTo(Integer value) {
            addCriterion("CBOC06 <>", value, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06GreaterThan(Integer value) {
            addCriterion("CBOC06 >", value, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC06 >=", value, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06LessThan(Integer value) {
            addCriterion("CBOC06 <", value, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC06 <=", value, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06In(List<Integer> values) {
            addCriterion("CBOC06 in", values, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06NotIn(List<Integer> values) {
            addCriterion("CBOC06 not in", values, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06Between(Integer value1, Integer value2) {
            addCriterion("CBOC06 between", value1, value2, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC06 not between", value1, value2, "cboc06");
            return (Criteria) this;
        }

        public Criteria andCboc07IsNull() {
            addCriterion("CBOC07 is null");
            return (Criteria) this;
        }

        public Criteria andCboc07IsNotNull() {
            addCriterion("CBOC07 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc07EqualTo(String value) {
            addCriterion("CBOC07 =", value, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07NotEqualTo(String value) {
            addCriterion("CBOC07 <>", value, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07GreaterThan(String value) {
            addCriterion("CBOC07 >", value, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07GreaterThanOrEqualTo(String value) {
            addCriterion("CBOC07 >=", value, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07LessThan(String value) {
            addCriterion("CBOC07 <", value, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07LessThanOrEqualTo(String value) {
            addCriterion("CBOC07 <=", value, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07Like(String value) {
            addCriterion("CBOC07 like", value, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07NotLike(String value) {
            addCriterion("CBOC07 not like", value, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07In(List<String> values) {
            addCriterion("CBOC07 in", values, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07NotIn(List<String> values) {
            addCriterion("CBOC07 not in", values, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07Between(String value1, String value2) {
            addCriterion("CBOC07 between", value1, value2, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc07NotBetween(String value1, String value2) {
            addCriterion("CBOC07 not between", value1, value2, "cboc07");
            return (Criteria) this;
        }

        public Criteria andCboc08IsNull() {
            addCriterion("CBOC08 is null");
            return (Criteria) this;
        }

        public Criteria andCboc08IsNotNull() {
            addCriterion("CBOC08 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc08EqualTo(Date value) {
            addCriterion("CBOC08 =", value, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08NotEqualTo(Date value) {
            addCriterion("CBOC08 <>", value, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08GreaterThan(Date value) {
            addCriterion("CBOC08 >", value, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOC08 >=", value, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08LessThan(Date value) {
            addCriterion("CBOC08 <", value, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08LessThanOrEqualTo(Date value) {
            addCriterion("CBOC08 <=", value, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08In(List<Date> values) {
            addCriterion("CBOC08 in", values, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08NotIn(List<Date> values) {
            addCriterion("CBOC08 not in", values, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08Between(Date value1, Date value2) {
            addCriterion("CBOC08 between", value1, value2, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc08NotBetween(Date value1, Date value2) {
            addCriterion("CBOC08 not between", value1, value2, "cboc08");
            return (Criteria) this;
        }

        public Criteria andCboc09IsNull() {
            addCriterion("CBOC09 is null");
            return (Criteria) this;
        }

        public Criteria andCboc09IsNotNull() {
            addCriterion("CBOC09 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc09EqualTo(Integer value) {
            addCriterion("CBOC09 =", value, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09NotEqualTo(Integer value) {
            addCriterion("CBOC09 <>", value, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09GreaterThan(Integer value) {
            addCriterion("CBOC09 >", value, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC09 >=", value, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09LessThan(Integer value) {
            addCriterion("CBOC09 <", value, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC09 <=", value, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09In(List<Integer> values) {
            addCriterion("CBOC09 in", values, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09NotIn(List<Integer> values) {
            addCriterion("CBOC09 not in", values, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09Between(Integer value1, Integer value2) {
            addCriterion("CBOC09 between", value1, value2, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC09 not between", value1, value2, "cboc09");
            return (Criteria) this;
        }

        public Criteria andCboc10IsNull() {
            addCriterion("CBOC10 is null");
            return (Criteria) this;
        }

        public Criteria andCboc10IsNotNull() {
            addCriterion("CBOC10 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc10EqualTo(Integer value) {
            addCriterion("CBOC10 =", value, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10NotEqualTo(Integer value) {
            addCriterion("CBOC10 <>", value, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10GreaterThan(Integer value) {
            addCriterion("CBOC10 >", value, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC10 >=", value, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10LessThan(Integer value) {
            addCriterion("CBOC10 <", value, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC10 <=", value, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10In(List<Integer> values) {
            addCriterion("CBOC10 in", values, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10NotIn(List<Integer> values) {
            addCriterion("CBOC10 not in", values, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10Between(Integer value1, Integer value2) {
            addCriterion("CBOC10 between", value1, value2, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc10NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC10 not between", value1, value2, "cboc10");
            return (Criteria) this;
        }

        public Criteria andCboc11IsNull() {
            addCriterion("CBOC11 is null");
            return (Criteria) this;
        }

        public Criteria andCboc11IsNotNull() {
            addCriterion("CBOC11 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc11EqualTo(Integer value) {
            addCriterion("CBOC11 =", value, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11NotEqualTo(Integer value) {
            addCriterion("CBOC11 <>", value, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11GreaterThan(Integer value) {
            addCriterion("CBOC11 >", value, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC11 >=", value, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11LessThan(Integer value) {
            addCriterion("CBOC11 <", value, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC11 <=", value, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11In(List<Integer> values) {
            addCriterion("CBOC11 in", values, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11NotIn(List<Integer> values) {
            addCriterion("CBOC11 not in", values, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11Between(Integer value1, Integer value2) {
            addCriterion("CBOC11 between", value1, value2, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC11 not between", value1, value2, "cboc11");
            return (Criteria) this;
        }

        public Criteria andCboc12IsNull() {
            addCriterion("CBOC12 is null");
            return (Criteria) this;
        }

        public Criteria andCboc12IsNotNull() {
            addCriterion("CBOC12 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc12EqualTo(Integer value) {
            addCriterion("CBOC12 =", value, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12NotEqualTo(Integer value) {
            addCriterion("CBOC12 <>", value, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12GreaterThan(Integer value) {
            addCriterion("CBOC12 >", value, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC12 >=", value, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12LessThan(Integer value) {
            addCriterion("CBOC12 <", value, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC12 <=", value, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12In(List<Integer> values) {
            addCriterion("CBOC12 in", values, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12NotIn(List<Integer> values) {
            addCriterion("CBOC12 not in", values, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12Between(Integer value1, Integer value2) {
            addCriterion("CBOC12 between", value1, value2, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc12NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC12 not between", value1, value2, "cboc12");
            return (Criteria) this;
        }

        public Criteria andCboc13IsNull() {
            addCriterion("CBOC13 is null");
            return (Criteria) this;
        }

        public Criteria andCboc13IsNotNull() {
            addCriterion("CBOC13 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc13EqualTo(Date value) {
            addCriterion("CBOC13 =", value, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13NotEqualTo(Date value) {
            addCriterion("CBOC13 <>", value, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13GreaterThan(Date value) {
            addCriterion("CBOC13 >", value, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOC13 >=", value, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13LessThan(Date value) {
            addCriterion("CBOC13 <", value, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13LessThanOrEqualTo(Date value) {
            addCriterion("CBOC13 <=", value, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13In(List<Date> values) {
            addCriterion("CBOC13 in", values, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13NotIn(List<Date> values) {
            addCriterion("CBOC13 not in", values, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13Between(Date value1, Date value2) {
            addCriterion("CBOC13 between", value1, value2, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc13NotBetween(Date value1, Date value2) {
            addCriterion("CBOC13 not between", value1, value2, "cboc13");
            return (Criteria) this;
        }

        public Criteria andCboc14IsNull() {
            addCriterion("CBOC14 is null");
            return (Criteria) this;
        }

        public Criteria andCboc14IsNotNull() {
            addCriterion("CBOC14 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc14EqualTo(Integer value) {
            addCriterion("CBOC14 =", value, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14NotEqualTo(Integer value) {
            addCriterion("CBOC14 <>", value, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14GreaterThan(Integer value) {
            addCriterion("CBOC14 >", value, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC14 >=", value, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14LessThan(Integer value) {
            addCriterion("CBOC14 <", value, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC14 <=", value, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14In(List<Integer> values) {
            addCriterion("CBOC14 in", values, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14NotIn(List<Integer> values) {
            addCriterion("CBOC14 not in", values, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14Between(Integer value1, Integer value2) {
            addCriterion("CBOC14 between", value1, value2, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC14 not between", value1, value2, "cboc14");
            return (Criteria) this;
        }

        public Criteria andCboc15IsNull() {
            addCriterion("CBOC15 is null");
            return (Criteria) this;
        }

        public Criteria andCboc15IsNotNull() {
            addCriterion("CBOC15 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc15EqualTo(Date value) {
            addCriterion("CBOC15 =", value, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15NotEqualTo(Date value) {
            addCriterion("CBOC15 <>", value, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15GreaterThan(Date value) {
            addCriterion("CBOC15 >", value, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBOC15 >=", value, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15LessThan(Date value) {
            addCriterion("CBOC15 <", value, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15LessThanOrEqualTo(Date value) {
            addCriterion("CBOC15 <=", value, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15In(List<Date> values) {
            addCriterion("CBOC15 in", values, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15NotIn(List<Date> values) {
            addCriterion("CBOC15 not in", values, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15Between(Date value1, Date value2) {
            addCriterion("CBOC15 between", value1, value2, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc15NotBetween(Date value1, Date value2) {
            addCriterion("CBOC15 not between", value1, value2, "cboc15");
            return (Criteria) this;
        }

        public Criteria andCboc16IsNull() {
            addCriterion("CBOC16 is null");
            return (Criteria) this;
        }

        public Criteria andCboc16IsNotNull() {
            addCriterion("CBOC16 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc16EqualTo(Integer value) {
            addCriterion("CBOC16 =", value, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16NotEqualTo(Integer value) {
            addCriterion("CBOC16 <>", value, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16GreaterThan(Integer value) {
            addCriterion("CBOC16 >", value, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC16 >=", value, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16LessThan(Integer value) {
            addCriterion("CBOC16 <", value, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC16 <=", value, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16In(List<Integer> values) {
            addCriterion("CBOC16 in", values, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16NotIn(List<Integer> values) {
            addCriterion("CBOC16 not in", values, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16Between(Integer value1, Integer value2) {
            addCriterion("CBOC16 between", value1, value2, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc16NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC16 not between", value1, value2, "cboc16");
            return (Criteria) this;
        }

        public Criteria andCboc17IsNull() {
            addCriterion("CBOC17 is null");
            return (Criteria) this;
        }

        public Criteria andCboc17IsNotNull() {
            addCriterion("CBOC17 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc17EqualTo(String value) {
            addCriterion("CBOC17 =", value, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17NotEqualTo(String value) {
            addCriterion("CBOC17 <>", value, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17GreaterThan(String value) {
            addCriterion("CBOC17 >", value, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17GreaterThanOrEqualTo(String value) {
            addCriterion("CBOC17 >=", value, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17LessThan(String value) {
            addCriterion("CBOC17 <", value, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17LessThanOrEqualTo(String value) {
            addCriterion("CBOC17 <=", value, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17Like(String value) {
            addCriterion("CBOC17 like", value, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17NotLike(String value) {
            addCriterion("CBOC17 not like", value, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17In(List<String> values) {
            addCriterion("CBOC17 in", values, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17NotIn(List<String> values) {
            addCriterion("CBOC17 not in", values, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17Between(String value1, String value2) {
            addCriterion("CBOC17 between", value1, value2, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc17NotBetween(String value1, String value2) {
            addCriterion("CBOC17 not between", value1, value2, "cboc17");
            return (Criteria) this;
        }

        public Criteria andCboc18IsNull() {
            addCriterion("CBOC18 is null");
            return (Criteria) this;
        }

        public Criteria andCboc18IsNotNull() {
            addCriterion("CBOC18 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc18EqualTo(String value) {
            addCriterion("CBOC18 =", value, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18NotEqualTo(String value) {
            addCriterion("CBOC18 <>", value, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18GreaterThan(String value) {
            addCriterion("CBOC18 >", value, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18GreaterThanOrEqualTo(String value) {
            addCriterion("CBOC18 >=", value, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18LessThan(String value) {
            addCriterion("CBOC18 <", value, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18LessThanOrEqualTo(String value) {
            addCriterion("CBOC18 <=", value, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18Like(String value) {
            addCriterion("CBOC18 like", value, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18NotLike(String value) {
            addCriterion("CBOC18 not like", value, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18In(List<String> values) {
            addCriterion("CBOC18 in", values, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18NotIn(List<String> values) {
            addCriterion("CBOC18 not in", values, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18Between(String value1, String value2) {
            addCriterion("CBOC18 between", value1, value2, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc18NotBetween(String value1, String value2) {
            addCriterion("CBOC18 not between", value1, value2, "cboc18");
            return (Criteria) this;
        }

        public Criteria andCboc19IsNull() {
            addCriterion("CBOC19 is null");
            return (Criteria) this;
        }

        public Criteria andCboc19IsNotNull() {
            addCriterion("CBOC19 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc19EqualTo(String value) {
            addCriterion("CBOC19 =", value, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19NotEqualTo(String value) {
            addCriterion("CBOC19 <>", value, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19GreaterThan(String value) {
            addCriterion("CBOC19 >", value, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19GreaterThanOrEqualTo(String value) {
            addCriterion("CBOC19 >=", value, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19LessThan(String value) {
            addCriterion("CBOC19 <", value, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19LessThanOrEqualTo(String value) {
            addCriterion("CBOC19 <=", value, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19Like(String value) {
            addCriterion("CBOC19 like", value, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19NotLike(String value) {
            addCriterion("CBOC19 not like", value, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19In(List<String> values) {
            addCriterion("CBOC19 in", values, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19NotIn(List<String> values) {
            addCriterion("CBOC19 not in", values, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19Between(String value1, String value2) {
            addCriterion("CBOC19 between", value1, value2, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc19NotBetween(String value1, String value2) {
            addCriterion("CBOC19 not between", value1, value2, "cboc19");
            return (Criteria) this;
        }

        public Criteria andCboc20IsNull() {
            addCriterion("CBOC20 is null");
            return (Criteria) this;
        }

        public Criteria andCboc20IsNotNull() {
            addCriterion("CBOC20 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc20EqualTo(String value) {
            addCriterion("CBOC20 =", value, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20NotEqualTo(String value) {
            addCriterion("CBOC20 <>", value, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20GreaterThan(String value) {
            addCriterion("CBOC20 >", value, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20GreaterThanOrEqualTo(String value) {
            addCriterion("CBOC20 >=", value, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20LessThan(String value) {
            addCriterion("CBOC20 <", value, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20LessThanOrEqualTo(String value) {
            addCriterion("CBOC20 <=", value, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20Like(String value) {
            addCriterion("CBOC20 like", value, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20NotLike(String value) {
            addCriterion("CBOC20 not like", value, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20In(List<String> values) {
            addCriterion("CBOC20 in", values, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20NotIn(List<String> values) {
            addCriterion("CBOC20 not in", values, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20Between(String value1, String value2) {
            addCriterion("CBOC20 between", value1, value2, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc20NotBetween(String value1, String value2) {
            addCriterion("CBOC20 not between", value1, value2, "cboc20");
            return (Criteria) this;
        }

        public Criteria andCboc21IsNull() {
            addCriterion("CBOC21 is null");
            return (Criteria) this;
        }

        public Criteria andCboc21IsNotNull() {
            addCriterion("CBOC21 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc21EqualTo(String value) {
            addCriterion("CBOC21 =", value, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21NotEqualTo(String value) {
            addCriterion("CBOC21 <>", value, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21GreaterThan(String value) {
            addCriterion("CBOC21 >", value, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21GreaterThanOrEqualTo(String value) {
            addCriterion("CBOC21 >=", value, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21LessThan(String value) {
            addCriterion("CBOC21 <", value, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21LessThanOrEqualTo(String value) {
            addCriterion("CBOC21 <=", value, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21Like(String value) {
            addCriterion("CBOC21 like", value, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21NotLike(String value) {
            addCriterion("CBOC21 not like", value, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21In(List<String> values) {
            addCriterion("CBOC21 in", values, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21NotIn(List<String> values) {
            addCriterion("CBOC21 not in", values, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21Between(String value1, String value2) {
            addCriterion("CBOC21 between", value1, value2, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc21NotBetween(String value1, String value2) {
            addCriterion("CBOC21 not between", value1, value2, "cboc21");
            return (Criteria) this;
        }

        public Criteria andCboc22IsNull() {
            addCriterion("CBOC22 is null");
            return (Criteria) this;
        }

        public Criteria andCboc22IsNotNull() {
            addCriterion("CBOC22 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc22EqualTo(String value) {
            addCriterion("CBOC22 =", value, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22NotEqualTo(String value) {
            addCriterion("CBOC22 <>", value, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22GreaterThan(String value) {
            addCriterion("CBOC22 >", value, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22GreaterThanOrEqualTo(String value) {
            addCriterion("CBOC22 >=", value, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22LessThan(String value) {
            addCriterion("CBOC22 <", value, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22LessThanOrEqualTo(String value) {
            addCriterion("CBOC22 <=", value, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22Like(String value) {
            addCriterion("CBOC22 like", value, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22NotLike(String value) {
            addCriterion("CBOC22 not like", value, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22In(List<String> values) {
            addCriterion("CBOC22 in", values, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22NotIn(List<String> values) {
            addCriterion("CBOC22 not in", values, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22Between(String value1, String value2) {
            addCriterion("CBOC22 between", value1, value2, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc22NotBetween(String value1, String value2) {
            addCriterion("CBOC22 not between", value1, value2, "cboc22");
            return (Criteria) this;
        }

        public Criteria andCboc23IsNull() {
            addCriterion("CBOC23 is null");
            return (Criteria) this;
        }

        public Criteria andCboc23IsNotNull() {
            addCriterion("CBOC23 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc23EqualTo(Integer value) {
            addCriterion("CBOC23 =", value, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23NotEqualTo(Integer value) {
            addCriterion("CBOC23 <>", value, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23GreaterThan(Integer value) {
            addCriterion("CBOC23 >", value, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC23 >=", value, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23LessThan(Integer value) {
            addCriterion("CBOC23 <", value, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC23 <=", value, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23In(List<Integer> values) {
            addCriterion("CBOC23 in", values, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23NotIn(List<Integer> values) {
            addCriterion("CBOC23 not in", values, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23Between(Integer value1, Integer value2) {
            addCriterion("CBOC23 between", value1, value2, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc23NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC23 not between", value1, value2, "cboc23");
            return (Criteria) this;
        }

        public Criteria andCboc24IsNull() {
            addCriterion("CBOC24 is null");
            return (Criteria) this;
        }

        public Criteria andCboc24IsNotNull() {
            addCriterion("CBOC24 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc24EqualTo(Integer value) {
            addCriterion("CBOC24 =", value, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24NotEqualTo(Integer value) {
            addCriterion("CBOC24 <>", value, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24GreaterThan(Integer value) {
            addCriterion("CBOC24 >", value, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC24 >=", value, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24LessThan(Integer value) {
            addCriterion("CBOC24 <", value, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC24 <=", value, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24In(List<Integer> values) {
            addCriterion("CBOC24 in", values, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24NotIn(List<Integer> values) {
            addCriterion("CBOC24 not in", values, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24Between(Integer value1, Integer value2) {
            addCriterion("CBOC24 between", value1, value2, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc24NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC24 not between", value1, value2, "cboc24");
            return (Criteria) this;
        }

        public Criteria andCboc25IsNull() {
            addCriterion("CBOC25 is null");
            return (Criteria) this;
        }

        public Criteria andCboc25IsNotNull() {
            addCriterion("CBOC25 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc25EqualTo(String value) {
            addCriterion("CBOC25 =", value, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25NotEqualTo(String value) {
            addCriterion("CBOC25 <>", value, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25GreaterThan(String value) {
            addCriterion("CBOC25 >", value, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25GreaterThanOrEqualTo(String value) {
            addCriterion("CBOC25 >=", value, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25LessThan(String value) {
            addCriterion("CBOC25 <", value, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25LessThanOrEqualTo(String value) {
            addCriterion("CBOC25 <=", value, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25Like(String value) {
            addCriterion("CBOC25 like", value, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25NotLike(String value) {
            addCriterion("CBOC25 not like", value, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25In(List<String> values) {
            addCriterion("CBOC25 in", values, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25NotIn(List<String> values) {
            addCriterion("CBOC25 not in", values, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25Between(String value1, String value2) {
            addCriterion("CBOC25 between", value1, value2, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc25NotBetween(String value1, String value2) {
            addCriterion("CBOC25 not between", value1, value2, "cboc25");
            return (Criteria) this;
        }

        public Criteria andCboc26IsNull() {
            addCriterion("CBOC26 is null");
            return (Criteria) this;
        }

        public Criteria andCboc26IsNotNull() {
            addCriterion("CBOC26 is not null");
            return (Criteria) this;
        }

        public Criteria andCboc26EqualTo(Integer value) {
            addCriterion("CBOC26 =", value, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26NotEqualTo(Integer value) {
            addCriterion("CBOC26 <>", value, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26GreaterThan(Integer value) {
            addCriterion("CBOC26 >", value, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBOC26 >=", value, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26LessThan(Integer value) {
            addCriterion("CBOC26 <", value, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26LessThanOrEqualTo(Integer value) {
            addCriterion("CBOC26 <=", value, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26In(List<Integer> values) {
            addCriterion("CBOC26 in", values, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26NotIn(List<Integer> values) {
            addCriterion("CBOC26 not in", values, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26Between(Integer value1, Integer value2) {
            addCriterion("CBOC26 between", value1, value2, "cboc26");
            return (Criteria) this;
        }

        public Criteria andCboc26NotBetween(Integer value1, Integer value2) {
            addCriterion("CBOC26 not between", value1, value2, "cboc26");
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