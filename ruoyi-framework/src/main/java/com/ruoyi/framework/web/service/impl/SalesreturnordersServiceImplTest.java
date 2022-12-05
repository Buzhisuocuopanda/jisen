package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.CbseDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.TaskService;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SalesreturnordersServiceImplTest {

    @Mock
    private CbseMapper mockCbseMapper;
    @Mock
    private CbsfMapper mockCbsfMapper;
    @Mock
    private CbsgMapper mockCbsgMapper;
    @Mock
    private SqlSessionFactory mockSqlSessionFactory;
    @Mock
    private NumberGenerate mockNumberGenerate;
    @Mock
    private TaskService mockTaskService;
    @Mock
    private CbsaMapper mockCbsaMapper;
    @Mock
    private BaseCheckService mockBaseCheckService;
    @Mock
    private GsGoodsSnMapper mockGsGoodsSnMapper;
    @Mock
    private GsGoodsSkuMapper mockGsGoodsSkuMapper;
    @Mock
    private CblaMapper mockCblaMapper;
    @Mock
    private CbpbMapper mockCbpbMapper;

    @InjectMocks
    private SalesreturnordersServiceImpl salesreturnordersServiceImplUnderTest;

    @Test
    public void testInsertSelloutofwarehouse() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getSalesreturnordersNo(0)).thenReturn("cbse07");
        when(mockCbseMapper.insertSelective(new Cbse())).thenReturn(0);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbseMapper.updateByPrimaryKeySelective(new Cbse())).thenReturn(0);

        // Run the test
        final IdVo result = salesreturnordersServiceImplUnderTest.insertSelloutofwarehouse(cbseDo);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockSqlSession).close();
        verify(mockCbseMapper).updateByPrimaryKeySelective(new Cbse());
    }

    @Test
    public void testInsertSelloutofwarehouse_CbseMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getSalesreturnordersNo(0)).thenReturn("cbse07");
        when(mockCbseMapper.insertSelective(new Cbse())).thenReturn(0);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(Collections.emptyList());

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbseMapper.updateByPrimaryKeySelective(new Cbse())).thenReturn(0);

        // Run the test
        final IdVo result = salesreturnordersServiceImplUnderTest.insertSelloutofwarehouse(cbseDo);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockSqlSession).close();
        verify(mockCbseMapper).updateByPrimaryKeySelective(new Cbse());
    }

    @Test
    public void testInsertSwJsStores() throws Exception {
        // Setup
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        final List<Cbsf> itemList = Arrays.asList(cbsf);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbseMapper.updateByPrimaryKeySelective(new Cbse())).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbseMapper).updateByPrimaryKeySelective(new Cbse());
    }

    @Test
    public void testInsertSwJsSkuBarcodesh() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodesh(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesh_CbseMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodesh(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesf() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodesf(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesf_CbsgMapperReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodesf(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesf_CbseMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodesf(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeqxwc() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodeqxwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeqxwc_CbsgMapperReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodeqxwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeqxwc_CbseMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodeqxwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku4 = new GsGoodsSku();
        gsGoodsSku4.setId(0);
        gsGoodsSku4.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setCreateBy(0);
        gsGoodsSku4.setUpdateBy(0);
        gsGoodsSku4.setDeleteFlag((byte) 0b0);
        gsGoodsSku4.setGoodsId(0);
        gsGoodsSku4.setWhId(0);
        gsGoodsSku4.setQty(0.0);
        gsGoodsSku4.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus2 = Arrays.asList(gsGoodsSku4);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus2);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbsgMapperSelectByExampleReturnsNull() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(null);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbsgMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku1);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku2);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus1);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbsfMapperReturnsNull() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(null);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbsfMapperReturnsNoItems() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(Collections.emptyList());

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku4 = new GsGoodsSku();
        gsGoodsSku4.setId(0);
        gsGoodsSku4.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setCreateBy(0);
        gsGoodsSku4.setUpdateBy(0);
        gsGoodsSku4.setDeleteFlag((byte) 0b0);
        gsGoodsSku4.setGoodsId(0);
        gsGoodsSku4.setWhId(0);
        gsGoodsSku4.setQty(0.0);
        gsGoodsSku4.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus2 = Arrays.asList(gsGoodsSku4);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus2);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_GsGoodsSkuMapperSelectByGoodsIdAndWhIdReturnsNoItems() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(Collections.emptyList());
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku1);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku2);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus1);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbsaMapperReturnsNull() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku4 = new GsGoodsSku();
        gsGoodsSku4.setId(0);
        gsGoodsSku4.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setCreateBy(0);
        gsGoodsSku4.setUpdateBy(0);
        gsGoodsSku4.setDeleteFlag((byte) 0b0);
        gsGoodsSku4.setGoodsId(0);
        gsGoodsSku4.setWhId(0);
        gsGoodsSku4.setQty(0.0);
        gsGoodsSku4.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus2 = Arrays.asList(gsGoodsSku4);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus2);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_TaskServiceInsertCBIBThrowsInterruptedException() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        when(mockTaskService.InsertCBIB(new CbibDo())).thenThrow(InterruptedException.class);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbseMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku4 = new GsGoodsSku();
        gsGoodsSku4.setId(0);
        gsGoodsSku4.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setCreateBy(0);
        gsGoodsSku4.setUpdateBy(0);
        gsGoodsSku4.setDeleteFlag((byte) 0b0);
        gsGoodsSku4.setGoodsId(0);
        gsGoodsSku4.setWhId(0);
        gsGoodsSku4.setQty(0.0);
        gsGoodsSku4.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus2 = Arrays.asList(gsGoodsSku4);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus2);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbsgMapperSelectbyidReturnsNoItems() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(Collections.emptyList());

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku4 = new GsGoodsSku();
        gsGoodsSku4.setId(0);
        gsGoodsSku4.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setCreateBy(0);
        gsGoodsSku4.setUpdateBy(0);
        gsGoodsSku4.setDeleteFlag((byte) 0b0);
        gsGoodsSku4.setGoodsId(0);
        gsGoodsSku4.setWhId(0);
        gsGoodsSku4.setQty(0.0);
        gsGoodsSku4.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus2 = Arrays.asList(gsGoodsSku4);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus2);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_TaskServiceCheckGsGoodsSkuReturnsNoItems() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(Collections.emptyList());

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus1);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CblaMapperReturnsNull() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_GsGoodsSkuMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(Collections.emptyList());

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_GsGoodsSnMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure GsGoodsSkuMapper.selectByGoodsIdAndWhId(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(gsGoodsSkus);

        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbsa07");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure TaskService.InsertCBIB(...).
        final Cbib cbib = new Cbib();
        cbib.setCbib01(0);
        cbib.setCbib02(0);
        cbib.setCbib03("cbib03");
        cbib.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbib.setCbib05("cbib05");
        cbib.setCbib06("cbib06");
        cbib.setCbib07(0);
        cbib.setCbib08(0);
        cbib.setCbib09(0.0);
        cbib.setCbib10(0.0);
        cbib.setCbib11(0.0);
        cbib.setCbib12(0.0);
        cbib.setCbib13(0.0);
        cbib.setCbib14(0.0);
        cbib.setCbib15(0.0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse1 = new Cbse();
        cbse1.setCbse01(0);
        cbse1.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse03(0);
        cbse1.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse05(0);
        cbse1.setCbse06(0);
        cbse1.setCbse07("cbse07");
        cbse1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse09(0);
        cbse1.setCbse10(0);
        cbse1.setCbse11(0);
        cbse1.setCbse12(0);
        cbse1.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse1.setCbse14(0);
        cbse1.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse1);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        // Configure CbsgMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsgMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku3 = new GsGoodsSku();
        gsGoodsSku3.setId(0);
        gsGoodsSku3.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku3.setCreateBy(0);
        gsGoodsSku3.setUpdateBy(0);
        gsGoodsSku3.setDeleteFlag((byte) 0b0);
        gsGoodsSku3.setGoodsId(0);
        gsGoodsSku3.setWhId(0);
        gsGoodsSku3.setQty(0.0);
        gsGoodsSku3.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku3);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure GsGoodsSkuMapper.selectByExample(...).
        final GsGoodsSku gsGoodsSku4 = new GsGoodsSku();
        gsGoodsSku4.setId(0);
        gsGoodsSku4.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku4.setCreateBy(0);
        gsGoodsSku4.setUpdateBy(0);
        gsGoodsSku4.setDeleteFlag((byte) 0b0);
        gsGoodsSku4.setGoodsId(0);
        gsGoodsSku4.setWhId(0);
        gsGoodsSku4.setQty(0.0);
        gsGoodsSku4.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus2 = Arrays.asList(gsGoodsSku4);
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus2);

        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
    }

    @Test
    public void testInsertSwJsSkuBarcodel() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        when(mockCbseMapper.updateByExampleSelective(eq(new Cbse()), any(CbseCriteria.class))).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodel(cbseDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists() throws Exception {
        // Setup
        final CbseVo cbsbVo = new CbseVo();
        cbsbVo.setCbse01(0);
        cbsbVo.setCbse07("cbse07");
        cbsbVo.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbse11(0);
        cbsbVo.setCbse18(0);
        cbsbVo.setCbca08("cbca08");
        cbsbVo.setCbwa09("cbwa09");
        cbsbVo.setCala08("cala08");

        final CbseVo cbseVo = new CbseVo();
        cbseVo.setCbse01(0);
        cbseVo.setCbse07("cbse07");
        cbseVo.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbseVo.setCbse11(0);
        cbseVo.setCbse18(0);
        cbseVo.setCbca08("cbca08");
        cbseVo.setCbwa09("cbwa09");
        cbseVo.setCala08("cala08");
        final List<CbseVo> expectedResult = Arrays.asList(cbseVo);

        // Configure CbseMapper.selectSwJsTaskGoodsRelLists(...).
        final CbseVo cbseVo1 = new CbseVo();
        cbseVo1.setCbse01(0);
        cbseVo1.setCbse07("cbse07");
        cbseVo1.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbseVo1.setCbse11(0);
        cbseVo1.setCbse18(0);
        cbseVo1.setCbca08("cbca08");
        cbseVo1.setCbwa09("cbwa09");
        cbseVo1.setCala08("cala08");
        final List<CbseVo> cbseVos = Arrays.asList(cbseVo1);
        when(mockCbseMapper.selectSwJsTaskGoodsRelLists(new CbseVo())).thenReturn(cbseVos);

        // Run the test
        final List<CbseVo> result = salesreturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbsbVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists_CbseMapperReturnsNoItems() {
        // Setup
        final CbseVo cbsbVo = new CbseVo();
        cbsbVo.setCbse01(0);
        cbsbVo.setCbse07("cbse07");
        cbsbVo.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbse11(0);
        cbsbVo.setCbse18(0);
        cbsbVo.setCbca08("cbca08");
        cbsbVo.setCbwa09("cbwa09");
        cbsbVo.setCala08("cala08");

        when(mockCbseMapper.selectSwJsTaskGoodsRelLists(new CbseVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbseVo> result = salesreturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbsbVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss() throws Exception {
        // Setup
        final CbsesVo cbsesVo = new CbsesVo();
        cbsesVo.setCbpb15("cbpb15");
        cbsesVo.setCbpb12("cbpb12");
        cbsesVo.setCbpb08("cbpb08");
        cbsesVo.setCbsf09(0.0);
        cbsesVo.setCbse01(0);
        cbsesVo.setCbsf08(0);
        cbsesVo.setCbpa08("cbpa08");
        cbsesVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsg09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        scanVo.setUpc("cbpb15");
        cbsesVo.setGoods(Arrays.asList(scanVo));
        cbsesVo.setPinpai("pinpai");
        cbsesVo.setSaomanums(0);
        cbsesVo.setNums(0.0);

        final CbsesVo cbsesVo1 = new CbsesVo();
        cbsesVo1.setCbpb15("cbpb15");
        cbsesVo1.setCbpb12("cbpb12");
        cbsesVo1.setCbpb08("cbpb08");
        cbsesVo1.setCbsf09(0.0);
        cbsesVo1.setCbse01(0);
        cbsesVo1.setCbsf08(0);
        cbsesVo1.setCbpa08("cbpa08");
        cbsesVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("pinpai");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbsg09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        scanVo1.setUpc("cbpb15");
        cbsesVo1.setGoods(Arrays.asList(scanVo1));
        cbsesVo1.setPinpai("pinpai");
        cbsesVo1.setSaomanums(0);
        cbsesVo1.setNums(0.0);
        final List<CbsesVo> expectedResult = Arrays.asList(cbsesVo1);

        // Configure CbseMapper.selectSwJsTaskGoodsRelListss(...).
        final CbsesVo cbsesVo2 = new CbsesVo();
        cbsesVo2.setCbpb15("cbpb15");
        cbsesVo2.setCbpb12("cbpb12");
        cbsesVo2.setCbpb08("cbpb08");
        cbsesVo2.setCbsf09(0.0);
        cbsesVo2.setCbse01(0);
        cbsesVo2.setCbsf08(0);
        cbsesVo2.setCbpa08("cbpa08");
        cbsesVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("pinpai");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbsg09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        scanVo2.setUpc("cbpb15");
        cbsesVo2.setGoods(Arrays.asList(scanVo2));
        cbsesVo2.setPinpai("pinpai");
        cbsesVo2.setSaomanums(0);
        cbsesVo2.setNums(0.0);
        final List<CbsesVo> cbsesVos = Arrays.asList(cbsesVo2);
        when(mockCbseMapper.selectSwJsTaskGoodsRelListss(new CbsesVo())).thenReturn(cbsesVos);

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Run the test
        final List<CbsesVo> result = salesreturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsesVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbseMapperReturnsNoItems() {
        // Setup
        final CbsesVo cbsesVo = new CbsesVo();
        cbsesVo.setCbpb15("cbpb15");
        cbsesVo.setCbpb12("cbpb12");
        cbsesVo.setCbpb08("cbpb08");
        cbsesVo.setCbsf09(0.0);
        cbsesVo.setCbse01(0);
        cbsesVo.setCbsf08(0);
        cbsesVo.setCbpa08("cbpa08");
        cbsesVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsg09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        scanVo.setUpc("cbpb15");
        cbsesVo.setGoods(Arrays.asList(scanVo));
        cbsesVo.setPinpai("pinpai");
        cbsesVo.setSaomanums(0);
        cbsesVo.setNums(0.0);

        when(mockCbseMapper.selectSwJsTaskGoodsRelListss(new CbsesVo())).thenReturn(Collections.emptyList());

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Run the test
        final List<CbsesVo> result = salesreturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsesVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbsgMapperReturnsNoItems() {
        // Setup
        final CbsesVo cbsesVo = new CbsesVo();
        cbsesVo.setCbpb15("cbpb15");
        cbsesVo.setCbpb12("cbpb12");
        cbsesVo.setCbpb08("cbpb08");
        cbsesVo.setCbsf09(0.0);
        cbsesVo.setCbse01(0);
        cbsesVo.setCbsf08(0);
        cbsesVo.setCbpa08("cbpa08");
        cbsesVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsg09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        scanVo.setUpc("cbpb15");
        cbsesVo.setGoods(Arrays.asList(scanVo));
        cbsesVo.setPinpai("pinpai");
        cbsesVo.setSaomanums(0);
        cbsesVo.setNums(0.0);

        // Configure CbseMapper.selectSwJsTaskGoodsRelListss(...).
        final CbsesVo cbsesVo1 = new CbsesVo();
        cbsesVo1.setCbpb15("cbpb15");
        cbsesVo1.setCbpb12("cbpb12");
        cbsesVo1.setCbpb08("cbpb08");
        cbsesVo1.setCbsf09(0.0);
        cbsesVo1.setCbse01(0);
        cbsesVo1.setCbsf08(0);
        cbsesVo1.setCbpa08("cbpa08");
        cbsesVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("pinpai");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbsg09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        scanVo1.setUpc("cbpb15");
        cbsesVo1.setGoods(Arrays.asList(scanVo1));
        cbsesVo1.setPinpai("pinpai");
        cbsesVo1.setSaomanums(0);
        cbsesVo1.setNums(0.0);
        final List<CbsesVo> cbsesVos = Arrays.asList(cbsesVo1);
        when(mockCbseMapper.selectSwJsTaskGoodsRelListss(new CbsesVo())).thenReturn(cbsesVos);

        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Run the test
        final List<CbsesVo> result = salesreturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsesVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CblaMapperReturnsNull() {
        // Setup
        final CbsesVo cbsesVo = new CbsesVo();
        cbsesVo.setCbpb15("cbpb15");
        cbsesVo.setCbpb12("cbpb12");
        cbsesVo.setCbpb08("cbpb08");
        cbsesVo.setCbsf09(0.0);
        cbsesVo.setCbse01(0);
        cbsesVo.setCbsf08(0);
        cbsesVo.setCbpa08("cbpa08");
        cbsesVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsg09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        scanVo.setUpc("cbpb15");
        cbsesVo.setGoods(Arrays.asList(scanVo));
        cbsesVo.setPinpai("pinpai");
        cbsesVo.setSaomanums(0);
        cbsesVo.setNums(0.0);

        // Configure CbseMapper.selectSwJsTaskGoodsRelListss(...).
        final CbsesVo cbsesVo1 = new CbsesVo();
        cbsesVo1.setCbpb15("cbpb15");
        cbsesVo1.setCbpb12("cbpb12");
        cbsesVo1.setCbpb08("cbpb08");
        cbsesVo1.setCbsf09(0.0);
        cbsesVo1.setCbse01(0);
        cbsesVo1.setCbsf08(0);
        cbsesVo1.setCbpa08("cbpa08");
        cbsesVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("pinpai");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbsg09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        scanVo1.setUpc("cbpb15");
        cbsesVo1.setGoods(Arrays.asList(scanVo1));
        cbsesVo1.setPinpai("pinpai");
        cbsesVo1.setSaomanums(0);
        cbsesVo1.setNums(0.0);
        final List<CbsesVo> cbsesVos = Arrays.asList(cbsesVo1);
        when(mockCbseMapper.selectSwJsTaskGoodsRelListss(new CbsesVo())).thenReturn(cbsesVos);

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class,
                () -> salesreturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsesVo));
    }

    @Test
    public void testInsertSwJsStoress() {
        // Setup
        final Cbsg itemList = new Cbsg();
        itemList.setCbsg01(0);
        itemList.setCbsg02(0);
        itemList.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg04(0);
        itemList.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg06(0);
        itemList.setCbsg07(0);
        itemList.setCbsg08(0);
        itemList.setCbsg09("cbsg09");
        itemList.setCbsg10(0);
        itemList.setCbsg11(0);
        itemList.setCbsg12("cbsg12");
        itemList.setCbse01(0);
        itemList.setUserId(0);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb = new Cbpb();
        cbpb.setCbpb01(0);
        cbpb.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb04(0);
        cbpb.setCbpb05(0);
        cbpb.setCbpb06((byte) 0b0);
        cbpb.setCbpb07("cbpb07");
        cbpb.setCbpb08("cbpb08");
        cbpb.setCbpb09("cbpb09");
        cbpb.setCbpb10(0);
        cbpb.setCbpb11(0);
        cbpb.setCbpb12("cbpb12");
        cbpb.setCbpb13(0.0);
        cbpb.setCbpb14(0);
        cbpb.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        when(mockCbsgMapper.updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class))).thenReturn(0);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbsgMapper.insertSelective(new Cbsg())).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbsgMapper).updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbsgMapper).insertSelective(new Cbsg());
    }

    @Test
    public void testInsertSwJsStoress_CbpbMapperReturnsNull() {
        // Setup
        final Cbsg itemList = new Cbsg();
        itemList.setCbsg01(0);
        itemList.setCbsg02(0);
        itemList.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg04(0);
        itemList.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg06(0);
        itemList.setCbsg07(0);
        itemList.setCbsg08(0);
        itemList.setCbsg09("cbsg09");
        itemList.setCbsg10(0);
        itemList.setCbsg11(0);
        itemList.setCbsg12("cbsg12");
        itemList.setCbse01(0);
        itemList.setUserId(0);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        when(mockCbsgMapper.updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class))).thenReturn(0);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbsgMapper.insertSelective(new Cbsg())).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbsgMapper).updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbsgMapper).insertSelective(new Cbsg());
    }

    @Test
    public void testInsertSwJsStoress_CblaMapperReturnsNull() {
        // Setup
        final Cbsg itemList = new Cbsg();
        itemList.setCbsg01(0);
        itemList.setCbsg02(0);
        itemList.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg04(0);
        itemList.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg06(0);
        itemList.setCbsg07(0);
        itemList.setCbsg08(0);
        itemList.setCbsg09("cbsg09");
        itemList.setCbsg10(0);
        itemList.setCbsg11(0);
        itemList.setCbsg12("cbsg12");
        itemList.setCbse01(0);
        itemList.setUserId(0);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb = new Cbpb();
        cbpb.setCbpb01(0);
        cbpb.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb04(0);
        cbpb.setCbpb05(0);
        cbpb.setCbpb06((byte) 0b0);
        cbpb.setCbpb07("cbpb07");
        cbpb.setCbpb08("cbpb08");
        cbpb.setCbpb09("cbpb09");
        cbpb.setCbpb10(0);
        cbpb.setCbpb11(0);
        cbpb.setCbpb12("cbpb12");
        cbpb.setCbpb13(0.0);
        cbpb.setCbpb14(0);
        cbpb.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> salesreturnordersServiceImplUnderTest.insertSwJsStoress(itemList));
    }

    @Test
    public void testInsertSwJsStoress_CbsfMapperReturnsNoItems() {
        // Setup
        final Cbsg itemList = new Cbsg();
        itemList.setCbsg01(0);
        itemList.setCbsg02(0);
        itemList.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg04(0);
        itemList.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg06(0);
        itemList.setCbsg07(0);
        itemList.setCbsg08(0);
        itemList.setCbsg09("cbsg09");
        itemList.setCbsg10(0);
        itemList.setCbsg11(0);
        itemList.setCbsg12("cbsg12");
        itemList.setCbse01(0);
        itemList.setUserId(0);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb = new Cbpb();
        cbpb.setCbpb01(0);
        cbpb.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb04(0);
        cbpb.setCbpb05(0);
        cbpb.setCbpb06((byte) 0b0);
        cbpb.setCbpb07("cbpb07");
        cbpb.setCbpb08("cbpb08");
        cbpb.setCbpb09("cbpb09");
        cbpb.setCbpb10(0);
        cbpb.setCbpb11(0);
        cbpb.setCbpb12("cbpb12");
        cbpb.setCbpb13(0.0);
        cbpb.setCbpb14(0);
        cbpb.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        when(mockCbsgMapper.updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class))).thenReturn(0);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbsgMapper.insertSelective(new Cbsg())).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbsgMapper).updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbsgMapper).insertSelective(new Cbsg());
    }

    @Test
    public void testInsertSwJsStoress_CbsgMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbsg itemList = new Cbsg();
        itemList.setCbsg01(0);
        itemList.setCbsg02(0);
        itemList.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg04(0);
        itemList.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg06(0);
        itemList.setCbsg07(0);
        itemList.setCbsg08(0);
        itemList.setCbsg09("cbsg09");
        itemList.setCbsg10(0);
        itemList.setCbsg11(0);
        itemList.setCbsg12("cbsg12");
        itemList.setCbse01(0);
        itemList.setUserId(0);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb = new Cbpb();
        cbpb.setCbpb01(0);
        cbpb.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb04(0);
        cbpb.setCbpb05(0);
        cbpb.setCbpb06((byte) 0b0);
        cbpb.setCbpb07("cbpb07");
        cbpb.setCbpb08("cbpb08");
        cbpb.setCbpb09("cbpb09");
        cbpb.setCbpb10(0);
        cbpb.setCbpb11(0);
        cbpb.setCbpb12("cbpb12");
        cbpb.setCbpb13(0.0);
        cbpb.setCbpb14(0);
        cbpb.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbsgMapper.updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class))).thenReturn(0);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbsg09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbsgMapper.insertSelective(new Cbsg())).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbsgMapper).updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbsgMapper).insertSelective(new Cbsg());
    }

    @Test
    public void testInsertSwJsStoress_GsGoodsSnMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbsg itemList = new Cbsg();
        itemList.setCbsg01(0);
        itemList.setCbsg02(0);
        itemList.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg04(0);
        itemList.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsg06(0);
        itemList.setCbsg07(0);
        itemList.setCbsg08(0);
        itemList.setCbsg09("cbsg09");
        itemList.setCbsg10(0);
        itemList.setCbsg11(0);
        itemList.setCbsg12("cbsg12");
        itemList.setCbse01(0);
        itemList.setUserId(0);

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb = new Cbpb();
        cbpb.setCbpb01(0);
        cbpb.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb.setCbpb04(0);
        cbpb.setCbpb05(0);
        cbpb.setCbpb06((byte) 0b0);
        cbpb.setCbpb07("cbpb07");
        cbpb.setCbpb08("cbpb08");
        cbpb.setCbpb09("cbpb09");
        cbpb.setCbpb10(0);
        cbpb.setCbpb11(0);
        cbpb.setCbpb12("cbpb12");
        cbpb.setCbpb13(0.0);
        cbpb.setCbpb14(0);
        cbpb.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb);

        // Configure CblaMapper.selectByPrimaryKey(...).
        final Cbla cbla = new Cbla();
        cbla.setCbla01(0);
        cbla.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla03(0);
        cbla.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla.setCbla05(0);
        cbla.setCbla06(0);
        cbla.setCbla07(0);
        cbla.setCbla08("cbla08");
        cbla.setCbla09("cbla09");
        cbla.setCbla10(0);
        cbla.setCbla11(0.0);
        cbla.setCbla12("cbla12");
        cbla.setCbla13("cbla13");
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(cbla);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure CbsgMapper.selectByExample(...).
        final Cbsg cbsg = new Cbsg();
        cbsg.setCbsg01(0);
        cbsg.setCbsg02(0);
        cbsg.setCbsg03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg04(0);
        cbsg.setCbsg05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsg.setCbsg06(0);
        cbsg.setCbsg07(0);
        cbsg.setCbsg08(0);
        cbsg.setCbsg09("cbsg09");
        cbsg.setCbsg10(0);
        cbsg.setCbsg11(0);
        cbsg.setCbsg12("cbsg12");
        cbsg.setCbse01(0);
        cbsg.setUserId(0);
        final List<Cbsg> cbsgs = Arrays.asList(cbsg);
        when(mockCbsgMapper.selectByExample(any(CbsgCriteria.class))).thenReturn(cbsgs);

        when(mockCbsgMapper.updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbsgMapper.insertSelective(new Cbsg())).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbsgMapper).updateByExampleSelective(eq(new Cbsg()), any(CbsgCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbsgMapper).insertSelective(new Cbsg());
    }

    @Test
    public void testInsertSwJsSkuBarcodergqr() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodergqr(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodergqr_CbsfMapperReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(Collections.emptyList());

        // Configure TaskService.checkGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus);

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku1);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku2 = new GsGoodsSku();
        gsGoodsSku2.setId(0);
        gsGoodsSku2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku2.setCreateBy(0);
        gsGoodsSku2.setUpdateBy(0);
        gsGoodsSku2.setDeleteFlag((byte) 0b0);
        gsGoodsSku2.setGoodsId(0);
        gsGoodsSku2.setWhId(0);
        gsGoodsSku2.setQty(0.0);
        gsGoodsSku2.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodergqr(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodergqr_TaskServiceCheckGsGoodsSkuReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(Collections.emptyList());

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
        final GsGoodsSku gsGoodsSku = new GsGoodsSku();
        gsGoodsSku.setId(0);
        gsGoodsSku.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku.setCreateBy(0);
        gsGoodsSku.setUpdateBy(0);
        gsGoodsSku.setDeleteFlag((byte) 0b0);
        gsGoodsSku.setGoodsId(0);
        gsGoodsSku.setWhId(0);
        gsGoodsSku.setQty(0.0);
        gsGoodsSku.setLocationId(0);
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku);

        // Configure TaskService.updateGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku1 = new GsGoodsSku();
        gsGoodsSku1.setId(0);
        gsGoodsSku1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku1.setCreateBy(0);
        gsGoodsSku1.setUpdateBy(0);
        gsGoodsSku1.setDeleteFlag((byte) 0b0);
        gsGoodsSku1.setGoodsId(0);
        gsGoodsSku1.setWhId(0);
        gsGoodsSku1.setQty(0.0);
        gsGoodsSku1.setLocationId(0);
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku1);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSwJsSkuBarcodergqr(cbseDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testSelloutofwarehousedeitone() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        when(mockCbseMapper.updateByPrimaryKeySelective(new Cbse())).thenReturn(0);

        // Configure CbsfMapper.selectByExample(...).
        final Cbsf cbsf1 = new Cbsf();
        cbsf1.setCbsf01(0);
        cbsf1.setCbsf02(0);
        cbsf1.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf04(0);
        cbsf1.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf1.setCbsf06(0);
        cbsf1.setCbsf07(0);
        cbsf1.setCbsf08(0);
        cbsf1.setCbsf09(0.0);
        cbsf1.setCbsf10(0.0);
        cbsf1.setCbsf11(0.0);
        cbsf1.setCbsf12(0.0);
        cbsf1.setCbsf13("cbsf13");
        cbsf1.setCbse01(0);
        cbsf1.setCbsf14(0);
        cbsf1.setCbsf15(0);
        cbsf1.setCbsf16(0);
        cbsf1.setUserId(0);
        cbsf1.setGoodsId(0);
        final List<Cbsf> cbsfs = Arrays.asList(cbsf1);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(cbsfs);

        when(mockCbsfMapper.deleteByExample(any(CbsfCriteria.class))).thenReturn(0);
        when(mockCbsfMapper.insertSelective(new Cbsf())).thenReturn(0);

        // Run the test
        salesreturnordersServiceImplUnderTest.Selloutofwarehousedeitone(cbseDo);

        // Verify the results
        verify(mockCbseMapper).updateByPrimaryKeySelective(new Cbse());
        verify(mockCbsfMapper).insertSelective(new Cbsf());
    }

    @Test
    public void testSelloutofwarehousedeitone_CbsfMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        // Configure CbseMapper.selectByPrimaryKey(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        when(mockCbseMapper.selectByPrimaryKey(0)).thenReturn(cbse);

        when(mockCbseMapper.updateByPrimaryKeySelective(new Cbse())).thenReturn(0);
        when(mockCbsfMapper.selectByExample(any(CbsfCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbsfMapper.deleteByExample(any(CbsfCriteria.class))).thenReturn(0);
        when(mockCbsfMapper.insertSelective(new Cbsf())).thenReturn(0);

        // Run the test
        salesreturnordersServiceImplUnderTest.Selloutofwarehousedeitone(cbseDo);

        // Verify the results
        verify(mockCbseMapper).updateByPrimaryKeySelective(new Cbse());
        verify(mockCbsfMapper).insertSelective(new Cbsf());
    }

    @Test
    public void testInsertSelloutofwarehouseplus() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        when(mockNumberGenerate.getSalesreturnordersNo(0)).thenReturn("cbse07");
        when(mockCbseMapper.insertSelective(new Cbse())).thenReturn(0);

        // Configure CbseMapper.selectByExample(...).
        final Cbse cbse = new Cbse();
        cbse.setCbse01(0);
        cbse.setCbse02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse03(0);
        cbse.setCbse04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse05(0);
        cbse.setCbse06(0);
        cbse.setCbse07("cbse07");
        cbse.setCbse08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse09(0);
        cbse.setCbse10(0);
        cbse.setCbse11(0);
        cbse.setCbse12(0);
        cbse.setCbse13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbse.setCbse14(0);
        cbse.setUserId(0);
        final List<Cbse> cbses = Arrays.asList(cbse);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(cbses);

        when(mockCbsfMapper.insertSelective(new Cbsf())).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSelloutofwarehouseplus(cbseDo);

        // Verify the results
        assertEquals(0, 1,result);
       // verify(mockCbseMapper).insertSelective(new Cbse());
     //   verify(mockCbsfMapper).insertSelective(new Cbsf());
    }

    @Test
    public void testInsertSelloutofwarehouseplus_CbseMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbseDo cbseDo = new CbseDo();
        cbseDo.setCbse01(0);
        cbseDo.setCbse07("cbse07");
        cbseDo.setCbse10(0);
        final Cbsf cbsf = new Cbsf();
        cbsf.setCbsf01(0);
        cbsf.setCbsf02(0);
        cbsf.setCbsf03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf04(0);
        cbsf.setCbsf05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsf.setCbsf06(0);
        cbsf.setCbsf07(0);
        cbsf.setCbsf08(0);
        cbsf.setCbsf09(0.0);
        cbsf.setCbsf10(0.0);
        cbsf.setCbsf11(0.0);
        cbsf.setCbsf12(0.0);
        cbsf.setCbsf13("cbsf13");
        cbsf.setCbse01(0);
        cbsf.setCbsf14(0);
        cbsf.setCbsf15(0);
        cbsf.setCbsf16(0);
        cbsf.setUserId(0);
        cbsf.setGoodsId(0);
        cbseDo.setGoods(Arrays.asList(cbsf));

        when(mockNumberGenerate.getSalesreturnordersNo(0)).thenReturn("cbse07");
        when(mockCbseMapper.insertSelective(new Cbse())).thenReturn(0);
        when(mockCbseMapper.selectByExample(any(CbseCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbsfMapper.insertSelective(new Cbsf())).thenReturn(0);

        // Run the test
        final int result = salesreturnordersServiceImplUnderTest.insertSelloutofwarehouseplus(cbseDo);

        // Verify the results
        assertEquals(0,1, result);
       // verify(mockCbseMapper).insertSelective(new Cbse());
      //  verify(mockCbsfMapper).insertSelective(new Cbsf());
    }
}
