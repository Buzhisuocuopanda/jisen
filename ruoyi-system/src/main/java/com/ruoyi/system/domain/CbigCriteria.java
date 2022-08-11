package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbigCriteria() {
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

        public Criteria andCbig01IsNull() {
            addCriterion("CBIG01 is null");
            return (Criteria) this;
        }

        public Criteria andCbig01IsNotNull() {
            addCriterion("CBIG01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig01EqualTo(Integer value) {
            addCriterion("CBIG01 =", value, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01NotEqualTo(Integer value) {
            addCriterion("CBIG01 <>", value, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01GreaterThan(Integer value) {
            addCriterion("CBIG01 >", value, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG01 >=", value, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01LessThan(Integer value) {
            addCriterion("CBIG01 <", value, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG01 <=", value, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01In(List<Integer> values) {
            addCriterion("CBIG01 in", values, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01NotIn(List<Integer> values) {
            addCriterion("CBIG01 not in", values, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01Between(Integer value1, Integer value2) {
            addCriterion("CBIG01 between", value1, value2, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG01 not between", value1, value2, "cbig01");
            return (Criteria) this;
        }

        public Criteria andCbig02IsNull() {
            addCriterion("CBIG02 is null");
            return (Criteria) this;
        }

        public Criteria andCbig02IsNotNull() {
            addCriterion("CBIG02 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig02EqualTo(Integer value) {
            addCriterion("CBIG02 =", value, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02NotEqualTo(Integer value) {
            addCriterion("CBIG02 <>", value, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02GreaterThan(Integer value) {
            addCriterion("CBIG02 >", value, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG02 >=", value, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02LessThan(Integer value) {
            addCriterion("CBIG02 <", value, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG02 <=", value, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02In(List<Integer> values) {
            addCriterion("CBIG02 in", values, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02NotIn(List<Integer> values) {
            addCriterion("CBIG02 not in", values, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02Between(Integer value1, Integer value2) {
            addCriterion("CBIG02 between", value1, value2, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig02NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG02 not between", value1, value2, "cbig02");
            return (Criteria) this;
        }

        public Criteria andCbig03IsNull() {
            addCriterion("CBIG03 is null");
            return (Criteria) this;
        }

        public Criteria andCbig03IsNotNull() {
            addCriterion("CBIG03 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig03EqualTo(Date value) {
            addCriterion("CBIG03 =", value, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03NotEqualTo(Date value) {
            addCriterion("CBIG03 <>", value, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03GreaterThan(Date value) {
            addCriterion("CBIG03 >", value, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIG03 >=", value, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03LessThan(Date value) {
            addCriterion("CBIG03 <", value, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03LessThanOrEqualTo(Date value) {
            addCriterion("CBIG03 <=", value, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03In(List<Date> values) {
            addCriterion("CBIG03 in", values, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03NotIn(List<Date> values) {
            addCriterion("CBIG03 not in", values, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03Between(Date value1, Date value2) {
            addCriterion("CBIG03 between", value1, value2, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig03NotBetween(Date value1, Date value2) {
            addCriterion("CBIG03 not between", value1, value2, "cbig03");
            return (Criteria) this;
        }

        public Criteria andCbig04IsNull() {
            addCriterion("CBIG04 is null");
            return (Criteria) this;
        }

        public Criteria andCbig04IsNotNull() {
            addCriterion("CBIG04 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig04EqualTo(Integer value) {
            addCriterion("CBIG04 =", value, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04NotEqualTo(Integer value) {
            addCriterion("CBIG04 <>", value, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04GreaterThan(Integer value) {
            addCriterion("CBIG04 >", value, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG04 >=", value, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04LessThan(Integer value) {
            addCriterion("CBIG04 <", value, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG04 <=", value, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04In(List<Integer> values) {
            addCriterion("CBIG04 in", values, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04NotIn(List<Integer> values) {
            addCriterion("CBIG04 not in", values, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04Between(Integer value1, Integer value2) {
            addCriterion("CBIG04 between", value1, value2, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig04NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG04 not between", value1, value2, "cbig04");
            return (Criteria) this;
        }

        public Criteria andCbig05IsNull() {
            addCriterion("CBIG05 is null");
            return (Criteria) this;
        }

        public Criteria andCbig05IsNotNull() {
            addCriterion("CBIG05 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig05EqualTo(Date value) {
            addCriterion("CBIG05 =", value, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05NotEqualTo(Date value) {
            addCriterion("CBIG05 <>", value, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05GreaterThan(Date value) {
            addCriterion("CBIG05 >", value, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIG05 >=", value, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05LessThan(Date value) {
            addCriterion("CBIG05 <", value, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05LessThanOrEqualTo(Date value) {
            addCriterion("CBIG05 <=", value, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05In(List<Date> values) {
            addCriterion("CBIG05 in", values, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05NotIn(List<Date> values) {
            addCriterion("CBIG05 not in", values, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05Between(Date value1, Date value2) {
            addCriterion("CBIG05 between", value1, value2, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig05NotBetween(Date value1, Date value2) {
            addCriterion("CBIG05 not between", value1, value2, "cbig05");
            return (Criteria) this;
        }

        public Criteria andCbig06IsNull() {
            addCriterion("CBIG06 is null");
            return (Criteria) this;
        }

        public Criteria andCbig06IsNotNull() {
            addCriterion("CBIG06 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig06EqualTo(Integer value) {
            addCriterion("CBIG06 =", value, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06NotEqualTo(Integer value) {
            addCriterion("CBIG06 <>", value, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06GreaterThan(Integer value) {
            addCriterion("CBIG06 >", value, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG06 >=", value, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06LessThan(Integer value) {
            addCriterion("CBIG06 <", value, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG06 <=", value, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06In(List<Integer> values) {
            addCriterion("CBIG06 in", values, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06NotIn(List<Integer> values) {
            addCriterion("CBIG06 not in", values, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06Between(Integer value1, Integer value2) {
            addCriterion("CBIG06 between", value1, value2, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig06NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG06 not between", value1, value2, "cbig06");
            return (Criteria) this;
        }

        public Criteria andCbig07IsNull() {
            addCriterion("CBIG07 is null");
            return (Criteria) this;
        }

        public Criteria andCbig07IsNotNull() {
            addCriterion("CBIG07 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig07EqualTo(Integer value) {
            addCriterion("CBIG07 =", value, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07NotEqualTo(Integer value) {
            addCriterion("CBIG07 <>", value, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07GreaterThan(Integer value) {
            addCriterion("CBIG07 >", value, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG07 >=", value, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07LessThan(Integer value) {
            addCriterion("CBIG07 <", value, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG07 <=", value, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07In(List<Integer> values) {
            addCriterion("CBIG07 in", values, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07NotIn(List<Integer> values) {
            addCriterion("CBIG07 not in", values, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07Between(Integer value1, Integer value2) {
            addCriterion("CBIG07 between", value1, value2, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig07NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG07 not between", value1, value2, "cbig07");
            return (Criteria) this;
        }

        public Criteria andCbig08IsNull() {
            addCriterion("CBIG08 is null");
            return (Criteria) this;
        }

        public Criteria andCbig08IsNotNull() {
            addCriterion("CBIG08 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig08EqualTo(Integer value) {
            addCriterion("CBIG08 =", value, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08NotEqualTo(Integer value) {
            addCriterion("CBIG08 <>", value, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08GreaterThan(Integer value) {
            addCriterion("CBIG08 >", value, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG08 >=", value, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08LessThan(Integer value) {
            addCriterion("CBIG08 <", value, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG08 <=", value, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08In(List<Integer> values) {
            addCriterion("CBIG08 in", values, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08NotIn(List<Integer> values) {
            addCriterion("CBIG08 not in", values, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08Between(Integer value1, Integer value2) {
            addCriterion("CBIG08 between", value1, value2, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig08NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG08 not between", value1, value2, "cbig08");
            return (Criteria) this;
        }

        public Criteria andCbig09IsNull() {
            addCriterion("CBIG09 is null");
            return (Criteria) this;
        }

        public Criteria andCbig09IsNotNull() {
            addCriterion("CBIG09 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig09EqualTo(Integer value) {
            addCriterion("CBIG09 =", value, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09NotEqualTo(Integer value) {
            addCriterion("CBIG09 <>", value, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09GreaterThan(Integer value) {
            addCriterion("CBIG09 >", value, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG09 >=", value, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09LessThan(Integer value) {
            addCriterion("CBIG09 <", value, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG09 <=", value, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09In(List<Integer> values) {
            addCriterion("CBIG09 in", values, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09NotIn(List<Integer> values) {
            addCriterion("CBIG09 not in", values, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09Between(Integer value1, Integer value2) {
            addCriterion("CBIG09 between", value1, value2, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig09NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG09 not between", value1, value2, "cbig09");
            return (Criteria) this;
        }

        public Criteria andCbig10IsNull() {
            addCriterion("CBIG10 is null");
            return (Criteria) this;
        }

        public Criteria andCbig10IsNotNull() {
            addCriterion("CBIG10 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig10EqualTo(String value) {
            addCriterion("CBIG10 =", value, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10NotEqualTo(String value) {
            addCriterion("CBIG10 <>", value, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10GreaterThan(String value) {
            addCriterion("CBIG10 >", value, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10GreaterThanOrEqualTo(String value) {
            addCriterion("CBIG10 >=", value, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10LessThan(String value) {
            addCriterion("CBIG10 <", value, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10LessThanOrEqualTo(String value) {
            addCriterion("CBIG10 <=", value, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10Like(String value) {
            addCriterion("CBIG10 like", value, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10NotLike(String value) {
            addCriterion("CBIG10 not like", value, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10In(List<String> values) {
            addCriterion("CBIG10 in", values, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10NotIn(List<String> values) {
            addCriterion("CBIG10 not in", values, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10Between(String value1, String value2) {
            addCriterion("CBIG10 between", value1, value2, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig10NotBetween(String value1, String value2) {
            addCriterion("CBIG10 not between", value1, value2, "cbig10");
            return (Criteria) this;
        }

        public Criteria andCbig11IsNull() {
            addCriterion("CBIG11 is null");
            return (Criteria) this;
        }

        public Criteria andCbig11IsNotNull() {
            addCriterion("CBIG11 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig11EqualTo(Integer value) {
            addCriterion("CBIG11 =", value, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11NotEqualTo(Integer value) {
            addCriterion("CBIG11 <>", value, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11GreaterThan(Integer value) {
            addCriterion("CBIG11 >", value, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG11 >=", value, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11LessThan(Integer value) {
            addCriterion("CBIG11 <", value, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG11 <=", value, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11In(List<Integer> values) {
            addCriterion("CBIG11 in", values, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11NotIn(List<Integer> values) {
            addCriterion("CBIG11 not in", values, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11Between(Integer value1, Integer value2) {
            addCriterion("CBIG11 between", value1, value2, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig11NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG11 not between", value1, value2, "cbig11");
            return (Criteria) this;
        }

        public Criteria andCbig12IsNull() {
            addCriterion("CBIG12 is null");
            return (Criteria) this;
        }

        public Criteria andCbig12IsNotNull() {
            addCriterion("CBIG12 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig12EqualTo(String value) {
            addCriterion("CBIG12 =", value, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12NotEqualTo(String value) {
            addCriterion("CBIG12 <>", value, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12GreaterThan(String value) {
            addCriterion("CBIG12 >", value, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12GreaterThanOrEqualTo(String value) {
            addCriterion("CBIG12 >=", value, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12LessThan(String value) {
            addCriterion("CBIG12 <", value, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12LessThanOrEqualTo(String value) {
            addCriterion("CBIG12 <=", value, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12Like(String value) {
            addCriterion("CBIG12 like", value, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12NotLike(String value) {
            addCriterion("CBIG12 not like", value, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12In(List<String> values) {
            addCriterion("CBIG12 in", values, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12NotIn(List<String> values) {
            addCriterion("CBIG12 not in", values, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12Between(String value1, String value2) {
            addCriterion("CBIG12 between", value1, value2, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig12NotBetween(String value1, String value2) {
            addCriterion("CBIG12 not between", value1, value2, "cbig12");
            return (Criteria) this;
        }

        public Criteria andCbig13IsNull() {
            addCriterion("CBIG13 is null");
            return (Criteria) this;
        }

        public Criteria andCbig13IsNotNull() {
            addCriterion("CBIG13 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig13EqualTo(Double value) {
            addCriterion("CBIG13 =", value, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13NotEqualTo(Double value) {
            addCriterion("CBIG13 <>", value, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13GreaterThan(Double value) {
            addCriterion("CBIG13 >", value, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13GreaterThanOrEqualTo(Double value) {
            addCriterion("CBIG13 >=", value, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13LessThan(Double value) {
            addCriterion("CBIG13 <", value, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13LessThanOrEqualTo(Double value) {
            addCriterion("CBIG13 <=", value, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13In(List<Double> values) {
            addCriterion("CBIG13 in", values, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13NotIn(List<Double> values) {
            addCriterion("CBIG13 not in", values, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13Between(Double value1, Double value2) {
            addCriterion("CBIG13 between", value1, value2, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbig13NotBetween(Double value1, Double value2) {
            addCriterion("CBIG13 not between", value1, value2, "cbig13");
            return (Criteria) this;
        }

        public Criteria andCbie01IsNull() {
            addCriterion("CBIE01 is null");
            return (Criteria) this;
        }

        public Criteria andCbie01IsNotNull() {
            addCriterion("CBIE01 is not null");
            return (Criteria) this;
        }

        public Criteria andCbie01EqualTo(Integer value) {
            addCriterion("CBIE01 =", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotEqualTo(Integer value) {
            addCriterion("CBIE01 <>", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01GreaterThan(Integer value) {
            addCriterion("CBIE01 >", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIE01 >=", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01LessThan(Integer value) {
            addCriterion("CBIE01 <", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01LessThanOrEqualTo(Integer value) {
            addCriterion("CBIE01 <=", value, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01In(List<Integer> values) {
            addCriterion("CBIE01 in", values, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotIn(List<Integer> values) {
            addCriterion("CBIE01 not in", values, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01Between(Integer value1, Integer value2) {
            addCriterion("CBIE01 between", value1, value2, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbie01NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIE01 not between", value1, value2, "cbie01");
            return (Criteria) this;
        }

        public Criteria andCbig14IsNull() {
            addCriterion("CBIG14 is null");
            return (Criteria) this;
        }

        public Criteria andCbig14IsNotNull() {
            addCriterion("CBIG14 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig14EqualTo(Integer value) {
            addCriterion("CBIG14 =", value, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14NotEqualTo(Integer value) {
            addCriterion("CBIG14 <>", value, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14GreaterThan(Integer value) {
            addCriterion("CBIG14 >", value, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14GreaterThanOrEqualTo(Integer value) {
            addCriterion("CBIG14 >=", value, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14LessThan(Integer value) {
            addCriterion("CBIG14 <", value, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14LessThanOrEqualTo(Integer value) {
            addCriterion("CBIG14 <=", value, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14In(List<Integer> values) {
            addCriterion("CBIG14 in", values, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14NotIn(List<Integer> values) {
            addCriterion("CBIG14 not in", values, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14Between(Integer value1, Integer value2) {
            addCriterion("CBIG14 between", value1, value2, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig14NotBetween(Integer value1, Integer value2) {
            addCriterion("CBIG14 not between", value1, value2, "cbig14");
            return (Criteria) this;
        }

        public Criteria andCbig15IsNull() {
            addCriterion("CBIG15 is null");
            return (Criteria) this;
        }

        public Criteria andCbig15IsNotNull() {
            addCriterion("CBIG15 is not null");
            return (Criteria) this;
        }

        public Criteria andCbig15EqualTo(Date value) {
            addCriterion("CBIG15 =", value, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15NotEqualTo(Date value) {
            addCriterion("CBIG15 <>", value, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15GreaterThan(Date value) {
            addCriterion("CBIG15 >", value, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15GreaterThanOrEqualTo(Date value) {
            addCriterion("CBIG15 >=", value, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15LessThan(Date value) {
            addCriterion("CBIG15 <", value, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15LessThanOrEqualTo(Date value) {
            addCriterion("CBIG15 <=", value, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15In(List<Date> values) {
            addCriterion("CBIG15 in", values, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15NotIn(List<Date> values) {
            addCriterion("CBIG15 not in", values, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15Between(Date value1, Date value2) {
            addCriterion("CBIG15 between", value1, value2, "cbig15");
            return (Criteria) this;
        }

        public Criteria andCbig15NotBetween(Date value1, Date value2) {
            addCriterion("CBIG15 not between", value1, value2, "cbig15");
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