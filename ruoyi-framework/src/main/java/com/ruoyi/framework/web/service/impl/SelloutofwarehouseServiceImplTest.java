package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.*;
import com.ruoyi.system.service.gson.impl.NumberGenerate;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.*;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SelloutofwarehouseServiceImplTest {

    @Mock
    private CbsbMapper mockCbsbMapper;
    @Mock
    private CbscMapper mockCbscMapper;
    @Mock
    private CbsdMapper mockCbsdMapper;
    @Mock
    private CbpkMapper mockCbpkMapper;
    @Mock
    private CbwaMapper mockCbwaMapper;
    @Mock
    private SqlSessionFactory mockSqlSessionFactory;
    @Mock
    private SysUserMapper mockSysUserMapper;
    @Mock
    private NumberGenerate mockNumberGenerate;
    @Mock
    private TaskService mockTaskService;
    @Mock
    private BaseCheckService mockBaseCheckService;
    @Mock
    private CbpaMapper mockCbpaMapper;
    @Mock
    private OrderDistributionService mockOrderDistributionService;
    @Mock
    private CbobMapper mockCbobMapper;
    @Mock
    private CbbaMapper mockCbbaMapper;
    @Mock
    private SaleOrderService mockSaleOrderService;
    @Mock
    private CbsaMapper mockCbsaMapper;
    @Mock
    private CbodMapper mockCbodMapper;
    @Mock
    private CblaMapper mockCblaMapper;
    @Mock
    private GsGoodsSkuMapper mockGsGoodsSkuMapper;
    @Mock
    private GsGoodsSnMapper mockGsGoodsSnMapper;
    @Mock
    private CbpmMapper mockCbpmMapper;
    @Mock
    private TakeGoodsService mockTakeGoodsService;
    @Mock
    private CboaMapper mockCboaMapper;
    @Mock
    private CbpeMapper mockCbpeMapper;
    @Mock
    private RedisTemplate mockRedisTemplates;
    @Mock
    private CalaMapper mockCalaMapper;
    @Mock
    private CbcaMapper mockCbcaMapper;
    @Mock
    private CbpbMapper mockCbpbMapper;

    @InjectMocks
    private SelloutofwarehouseServiceImpl selloutofwarehouseServiceImplUnderTest;

    @Test
    public void testInsertSelloutofwarehouse() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getSellofwarehouseNo(0)).thenReturn("cbsb07");
        when(mockCbsbMapper.insertSelective(new Cbsb())).thenReturn(0);

        // Configure CbsbMapper.selectByExample(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        final List<Cbsb> cbsbs = Arrays.asList(cbsb);
        when(mockCbsbMapper.selectByExample(any(CbsbCriteria.class))).thenReturn(cbsbs);

        // Run the test
        final IdVo result = selloutofwarehouseServiceImplUnderTest.insertSelloutofwarehouse(cbsbDo);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockCbsbMapper).insertSelective(new Cbsb());
    }

    @Test
    public void testInsertSelloutofwarehouse_CbsbMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getSellofwarehouseNo(0)).thenReturn("cbsb07");
        when(mockCbsbMapper.insertSelective(new Cbsb())).thenReturn(0);
        when(mockCbsbMapper.selectByExample(any(CbsbCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final IdVo result = selloutofwarehouseServiceImplUnderTest.insertSelloutofwarehouse(cbsbDo);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockCbsbMapper).insertSelective(new Cbsb());
    }

    @Test
    public void testInsertSwJsStores() throws Exception {
        // Setup
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> itemList = Arrays.asList(cbsc);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure GsGoodsSkuMapper.selectByExample(...).
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
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        when(mockCbpkMapper.updateByPrimaryKeySelective(new Cbpk())).thenReturn(0);
        when(mockCbsbMapper.updateByPrimaryKeySelective(new Cbsb())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbpkMapper).updateByPrimaryKeySelective(new Cbpk());
        verify(mockCbsbMapper).updateByPrimaryKeySelective(new Cbsb());
    }

    @Test
    public void testInsertSwJsStores_CbsbMapperSelectByPrimaryKeyReturnsNull() {
        // Setup
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> itemList = Arrays.asList(cbsc);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> selloutofwarehouseServiceImplUnderTest.insertSwJsStores(itemList));
    }

    @Test
    public void testInsertSwJsStores_GsGoodsSkuMapperReturnsNoItems() {
        // Setup
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> itemList = Arrays.asList(cbsc);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(Collections.emptyList());

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        when(mockCbpkMapper.updateByPrimaryKeySelective(new Cbpk())).thenReturn(0);
        when(mockCbsbMapper.updateByPrimaryKeySelective(new Cbsb())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbpkMapper).updateByPrimaryKeySelective(new Cbpk());
        verify(mockCbsbMapper).updateByPrimaryKeySelective(new Cbsb());
    }

    @Test
    public void testInsertSwJsStores_CbscMapperReturnsNoItems() {
        // Setup
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> itemList = Arrays.asList(cbsc);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure GsGoodsSkuMapper.selectByExample(...).
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
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbpkMapper.updateByPrimaryKeySelective(new Cbpk())).thenReturn(0);
        when(mockCbsbMapper.updateByPrimaryKeySelective(new Cbsb())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbpkMapper).updateByPrimaryKeySelective(new Cbpk());
        verify(mockCbsbMapper).updateByPrimaryKeySelective(new Cbsb());
    }

    @Test
    public void testInsertSwJsSkuBarcodesh() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByExample(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        final List<Cbsb> cbsbs = Arrays.asList(cbsb);
        when(mockCbsbMapper.selectByExample(any(CbsbCriteria.class))).thenReturn(cbsbs);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodesh(cbsbDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesh_CbsbMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        when(mockCbsbMapper.selectByExample(any(CbsbCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodesh(cbsbDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesf() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodesf(cbsbDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesf_CbsdMapperReturnsNoItems() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodesf(cbsbDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        // Configure CbsdMapper.selectBYID(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(uioVos);

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

        // Configure TaskService.checkGsGoodsSkuByWhId(...).
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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku1);
        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku3);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

        // Configure CbscMapper.selegroupgoodsid(...).
        final Cbsc cbsc2 = new Cbsc();
        cbsc2.setCbsc01(0);
        cbsc2.setCbsc02(0);
        cbsc2.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc04(0);
        cbsc2.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc06(0);
        cbsc2.setCbsc07(0);
        cbsc2.setCbsc08(0);
        cbsc2.setCbsc09(0.0);
        cbsc2.setCbsc10(0.0);
        cbsc2.setCbsc11(0.0);
        cbsc2.setCbsc12(0.0);
        cbsc2.setCbsc13("cbsc13");
        cbsc2.setCbsb01(0);
        cbsc2.setCbsc14(0);
        cbsc2.setCbsc15(0);
        cbsc2.setCbsc16(0);
        cbsc2.setCbsc17(0);
        cbsc2.setUserId(0);
        cbsc2.setTakegoodsid(0);
        cbsc2.setScannum(0);
        final List<Cbsc> cbscs1 = Arrays.asList(cbsc2);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(cbscs1);

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

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_CbscMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        // Configure CbsdMapper.selectBYID(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(uioVos);

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

        // Configure TaskService.checkGsGoodsSkuByWhId(...).
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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku1);
        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku3);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

        // Configure CbscMapper.selegroupgoodsid(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(cbscs);

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

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_CbwaMapperReturnsNull() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        // Configure CbsdMapper.selectBYID(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(uioVos);

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

        // Configure TaskService.checkGsGoodsSkuByWhId(...).
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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku1);
        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku3);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

        // Configure CbscMapper.selegroupgoodsid(...).
        final Cbsc cbsc2 = new Cbsc();
        cbsc2.setCbsc01(0);
        cbsc2.setCbsc02(0);
        cbsc2.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc04(0);
        cbsc2.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc06(0);
        cbsc2.setCbsc07(0);
        cbsc2.setCbsc08(0);
        cbsc2.setCbsc09(0.0);
        cbsc2.setCbsc10(0.0);
        cbsc2.setCbsc11(0.0);
        cbsc2.setCbsc12(0.0);
        cbsc2.setCbsc13("cbsc13");
        cbsc2.setCbsb01(0);
        cbsc2.setCbsc14(0);
        cbsc2.setCbsc15(0);
        cbsc2.setCbsc16(0);
        cbsc2.setCbsc17(0);
        cbsc2.setUserId(0);
        cbsc2.setTakegoodsid(0);
        cbsc2.setScannum(0);
        final List<Cbsc> cbscs1 = Arrays.asList(cbsc2);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(cbscs1);

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

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_CbsdMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(Collections.emptyList());
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        // Configure CbsdMapper.selectBYID(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(uioVos);

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

        // Configure TaskService.checkGsGoodsSkuByWhId(...).
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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku1);
        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku3);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

        // Configure CbscMapper.selegroupgoodsid(...).
        final Cbsc cbsc2 = new Cbsc();
        cbsc2.setCbsc01(0);
        cbsc2.setCbsc02(0);
        cbsc2.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc04(0);
        cbsc2.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc06(0);
        cbsc2.setCbsc07(0);
        cbsc2.setCbsc08(0);
        cbsc2.setCbsc09(0.0);
        cbsc2.setCbsc10(0.0);
        cbsc2.setCbsc11(0.0);
        cbsc2.setCbsc12(0.0);
        cbsc2.setCbsc13("cbsc13");
        cbsc2.setCbsb01(0);
        cbsc2.setCbsc14(0);
        cbsc2.setCbsc15(0);
        cbsc2.setCbsc16(0);
        cbsc2.setCbsc17(0);
        cbsc2.setUserId(0);
        cbsc2.setTakegoodsid(0);
        cbsc2.setScannum(0);
        final List<Cbsc> cbscs1 = Arrays.asList(cbsc2);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(cbscs1);

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

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_CbobMapperReturnsNull() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_CboaMapperReturnsNull() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_CbsdMapperSelectBYIDReturnsNoItems() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(Collections.emptyList());

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

        // Configure TaskService.checkGsGoodsSkuByWhId(...).
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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku1);
        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku3);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

        // Configure CbscMapper.selegroupgoodsid(...).
        final Cbsc cbsc2 = new Cbsc();
        cbsc2.setCbsc01(0);
        cbsc2.setCbsc02(0);
        cbsc2.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc04(0);
        cbsc2.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc06(0);
        cbsc2.setCbsc07(0);
        cbsc2.setCbsc08(0);
        cbsc2.setCbsc09(0.0);
        cbsc2.setCbsc10(0.0);
        cbsc2.setCbsc11(0.0);
        cbsc2.setCbsc12(0.0);
        cbsc2.setCbsc13("cbsc13");
        cbsc2.setCbsb01(0);
        cbsc2.setCbsc14(0);
        cbsc2.setCbsc15(0);
        cbsc2.setCbsc16(0);
        cbsc2.setCbsc17(0);
        cbsc2.setUserId(0);
        cbsc2.setTakegoodsid(0);
        cbsc2.setScannum(0);
        final List<Cbsc> cbscs1 = Arrays.asList(cbsc2);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(cbscs1);

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

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_GsGoodsSkuMapperSelectByGoodsIdAndWhIdReturnsNoItems() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        // Configure CbsdMapper.selectBYID(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(uioVos);

        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(Collections.emptyList());

        // Configure TaskService.checkGsGoodsSkuByWhId(...).
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
        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus);

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku2);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

        // Configure CbscMapper.selegroupgoodsid(...).
        final Cbsc cbsc2 = new Cbsc();
        cbsc2.setCbsc01(0);
        cbsc2.setCbsc02(0);
        cbsc2.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc04(0);
        cbsc2.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc06(0);
        cbsc2.setCbsc07(0);
        cbsc2.setCbsc08(0);
        cbsc2.setCbsc09(0.0);
        cbsc2.setCbsc10(0.0);
        cbsc2.setCbsc11(0.0);
        cbsc2.setCbsc12(0.0);
        cbsc2.setCbsc13("cbsc13");
        cbsc2.setCbsb01(0);
        cbsc2.setCbsc14(0);
        cbsc2.setCbsc15(0);
        cbsc2.setCbsc16(0);
        cbsc2.setCbsc17(0);
        cbsc2.setUserId(0);
        cbsc2.setTakegoodsid(0);
        cbsc2.setScannum(0);
        final List<Cbsc> cbscs1 = Arrays.asList(cbsc2);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(cbscs1);

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

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_TaskServiceCheckGsGoodsSkuByWhIdReturnsNoItems() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        // Configure CbsdMapper.selectBYID(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(uioVos);

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

        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(Collections.emptyList());

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku2);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

        // Configure CbscMapper.selegroupgoodsid(...).
        final Cbsc cbsc2 = new Cbsc();
        cbsc2.setCbsc01(0);
        cbsc2.setCbsc02(0);
        cbsc2.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc04(0);
        cbsc2.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc06(0);
        cbsc2.setCbsc07(0);
        cbsc2.setCbsc08(0);
        cbsc2.setCbsc09(0.0);
        cbsc2.setCbsc10(0.0);
        cbsc2.setCbsc11(0.0);
        cbsc2.setCbsc12(0.0);
        cbsc2.setCbsc13("cbsc13");
        cbsc2.setCbsb01(0);
        cbsc2.setCbsc14(0);
        cbsc2.setCbsc15(0);
        cbsc2.setCbsc16(0);
        cbsc2.setCbsc17(0);
        cbsc2.setUserId(0);
        cbsc2.setTakegoodsid(0);
        cbsc2.setScannum(0);
        final List<Cbsc> cbscs1 = Arrays.asList(cbsc2);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(cbscs1);

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

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_CbscMapperSelegroupgoodsidReturnsNoItems() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        // Configure CbsdMapper.selectBYID(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(uioVos);

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

        // Configure TaskService.checkGsGoodsSkuByWhId(...).
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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku1);
        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku3);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(Collections.emptyList());

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

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshwc_TaskServiceInsertCBIBThrowsInterruptedException() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc1 = new Cbsc();
        cbsc1.setCbsc01(0);
        cbsc1.setCbsc02(0);
        cbsc1.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc04(0);
        cbsc1.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc1.setCbsc06(0);
        cbsc1.setCbsc07(0);
        cbsc1.setCbsc08(0);
        cbsc1.setCbsc09(0.0);
        cbsc1.setCbsc10(0.0);
        cbsc1.setCbsc11(0.0);
        cbsc1.setCbsc12(0.0);
        cbsc1.setCbsc13("cbsc13");
        cbsc1.setCbsb01(0);
        cbsc1.setCbsc14(0);
        cbsc1.setCbsc15(0);
        cbsc1.setCbsc16(0);
        cbsc1.setCbsc17(0);
        cbsc1.setUserId(0);
        cbsc1.setTakegoodsid(0);
        cbsc1.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc1);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

        // Configure CbobMapper.selectByPrimaryKey(...).
        final Cbob cbob = new Cbob();
        cbob.setCbob01(0);
        cbob.setCbob02(0);
        cbob.setCbob03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob04(0);
        cbob.setCbob05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbob.setCbob06(0);
        cbob.setCbob07(0);
        cbob.setCbob08(0);
        cbob.setCbob09(0.0);
        cbob.setCbob10(0.0);
        cbob.setCbob11(0.0);
        cbob.setCbob12(0.0);
        cbob.setCbob13("cbob13");
        cbob.setCboa01(0);
        cbob.setCbob18("cbob18");
        when(mockCbobMapper.selectByPrimaryKey(0)).thenReturn(cbob);

        // Configure CboaMapper.selectByPrimaryKey(...).
        final Cboa cboa = new Cboa();
        cboa.setCboa01(0);
        cboa.setCboa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa03(0);
        cboa.setCboa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa05(0);
        cboa.setCboa06(0);
        cboa.setCboa07("cboa07");
        cboa.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa09(0);
        cboa.setCboa10(0);
        cboa.setCboa11(0);
        cboa.setCboa12(0);
        cboa.setCboa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cboa.setCboa14(0);
        cboa.setCboa27(0);
        when(mockCboaMapper.selectByPrimaryKey(0)).thenReturn(cboa);

        // Configure OrderDistributionService.saleOrderExit(...).
        final SaleOrderExitVo saleOrderExitVo = new SaleOrderExitVo();
        when(mockOrderDistributionService.saleOrderExit(new SaleOrderExitDo())).thenReturn(saleOrderExitVo);

        // Configure CbsdMapper.selectBYID(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbsdMapper.selectBYID(new UIOVo())).thenReturn(uioVos);

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

        // Configure TaskService.checkGsGoodsSkuByWhId(...).
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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku1);
        when(mockTaskService.checkGsGoodsSkuByWhId(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

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

        // Configure BaseCheckService.checkGoodsSkuForUpdate(...).
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
        when(mockBaseCheckService.checkGoodsSkuForUpdate(0)).thenReturn(gsGoodsSku3);

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

        // Configure CbscMapper.selegroupgoodsid(...).
        final Cbsc cbsc2 = new Cbsc();
        cbsc2.setCbsc01(0);
        cbsc2.setCbsc02(0);
        cbsc2.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc04(0);
        cbsc2.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc2.setCbsc06(0);
        cbsc2.setCbsc07(0);
        cbsc2.setCbsc08(0);
        cbsc2.setCbsc09(0.0);
        cbsc2.setCbsc10(0.0);
        cbsc2.setCbsc11(0.0);
        cbsc2.setCbsc12(0.0);
        cbsc2.setCbsc13("cbsc13");
        cbsc2.setCbsb01(0);
        cbsc2.setCbsc14(0);
        cbsc2.setCbsc15(0);
        cbsc2.setCbsc16(0);
        cbsc2.setCbsc17(0);
        cbsc2.setUserId(0);
        cbsc2.setTakegoodsid(0);
        cbsc2.setScannum(0);
        final List<Cbsc> cbscs1 = Arrays.asList(cbsc2);
        when(mockCbscMapper.selegroupgoodsid(0)).thenReturn(cbscs1);

        when(mockTaskService.InsertCBIB(new CbibDo())).thenThrow(InterruptedException.class);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeshwc(cbsbDo));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockOrderDistributionService).saleOrderExit(new SaleOrderExitDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
    }

    @Test
    public void testInsertSwJsSkuBarcodeqxwc() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeqxwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeqxwc_CbsdMapperReturnsNoItems() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodeqxwc(cbsbDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelList() throws Exception {
        // Setup
        final CbsbVo cbsbVo = new CbsbVo();
        cbsbVo.setCbsb01(0);
        cbsbVo.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb03(0);
        cbsbVo.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb05(0);
        cbsbVo.setCbsb06(0);
        cbsbVo.setCbsb07("cbsb07");
        cbsbVo.setCaua15("caua15");
        cbsbVo.setCbwa09("cbwa09");
        cbsbVo.setCala08("cala08");
        cbsbVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb09(0);
        cbsbVo.setCbsb10(0);
        cbsbVo.setCbsb11(0);
        cbsbVo.setCbsb12(0);

        final CbsbVo cbsbVo1 = new CbsbVo();
        cbsbVo1.setCbsb01(0);
        cbsbVo1.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo1.setCbsb03(0);
        cbsbVo1.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo1.setCbsb05(0);
        cbsbVo1.setCbsb06(0);
        cbsbVo1.setCbsb07("cbsb07");
        cbsbVo1.setCaua15("caua15");
        cbsbVo1.setCbwa09("cbwa09");
        cbsbVo1.setCala08("cala08");
        cbsbVo1.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo1.setCbsb09(0);
        cbsbVo1.setCbsb10(0);
        cbsbVo1.setCbsb11(0);
        cbsbVo1.setCbsb12(0);
        final List<CbsbVo> expectedResult = Arrays.asList(cbsbVo1);

        // Configure CbsbMapper.selectSwJsTaskGoodsRelList(...).
        final CbsbVo cbsbVo2 = new CbsbVo();
        cbsbVo2.setCbsb01(0);
        cbsbVo2.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo2.setCbsb03(0);
        cbsbVo2.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo2.setCbsb05(0);
        cbsbVo2.setCbsb06(0);
        cbsbVo2.setCbsb07("cbsb07");
        cbsbVo2.setCaua15("caua15");
        cbsbVo2.setCbwa09("cbwa09");
        cbsbVo2.setCala08("cala08");
        cbsbVo2.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo2.setCbsb09(0);
        cbsbVo2.setCbsb10(0);
        cbsbVo2.setCbsb11(0);
        cbsbVo2.setCbsb12(0);
        final List<CbsbVo> cbsbVos = Arrays.asList(cbsbVo2);
        when(mockCbsbMapper.selectSwJsTaskGoodsRelList(new CbsbVo())).thenReturn(cbsbVos);

        // Run the test
        final List<CbsbVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelList(cbsbVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelList_CbsbMapperReturnsNoItems() {
        // Setup
        final CbsbVo cbsbVo = new CbsbVo();
        cbsbVo.setCbsb01(0);
        cbsbVo.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb03(0);
        cbsbVo.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb05(0);
        cbsbVo.setCbsb06(0);
        cbsbVo.setCbsb07("cbsb07");
        cbsbVo.setCaua15("caua15");
        cbsbVo.setCbwa09("cbwa09");
        cbsbVo.setCala08("cala08");
        cbsbVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb09(0);
        cbsbVo.setCbsb10(0);
        cbsbVo.setCbsb11(0);
        cbsbVo.setCbsb12(0);

        when(mockCbsbMapper.selectSwJsTaskGoodsRelList(new CbsbVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbsbVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelList(cbsbVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists() throws Exception {
        // Setup
        final CbsbVo cbsbVo = new CbsbVo();
        cbsbVo.setCbsb01(0);
        cbsbVo.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb03(0);
        cbsbVo.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb05(0);
        cbsbVo.setCbsb06(0);
        cbsbVo.setCbsb07("cbsb07");
        cbsbVo.setCaua15("caua15");
        cbsbVo.setCbwa09("cbwa09");
        cbsbVo.setCala08("cala08");
        cbsbVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb09(0);
        cbsbVo.setCbsb10(0);
        cbsbVo.setCbsb11(0);
        cbsbVo.setCbsb12(0);

        final CbsbVo cbsbVo1 = new CbsbVo();
        cbsbVo1.setCbsb01(0);
        cbsbVo1.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo1.setCbsb03(0);
        cbsbVo1.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo1.setCbsb05(0);
        cbsbVo1.setCbsb06(0);
        cbsbVo1.setCbsb07("cbsb07");
        cbsbVo1.setCaua15("caua15");
        cbsbVo1.setCbwa09("cbwa09");
        cbsbVo1.setCala08("cala08");
        cbsbVo1.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo1.setCbsb09(0);
        cbsbVo1.setCbsb10(0);
        cbsbVo1.setCbsb11(0);
        cbsbVo1.setCbsb12(0);
        final List<CbsbVo> expectedResult = Arrays.asList(cbsbVo1);

        // Configure CbsbMapper.selectSwJsTaskGoodsRelLists(...).
        final CbsbVo cbsbVo2 = new CbsbVo();
        cbsbVo2.setCbsb01(0);
        cbsbVo2.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo2.setCbsb03(0);
        cbsbVo2.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo2.setCbsb05(0);
        cbsbVo2.setCbsb06(0);
        cbsbVo2.setCbsb07("cbsb07");
        cbsbVo2.setCaua15("caua15");
        cbsbVo2.setCbwa09("cbwa09");
        cbsbVo2.setCala08("cala08");
        cbsbVo2.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo2.setCbsb09(0);
        cbsbVo2.setCbsb10(0);
        cbsbVo2.setCbsb11(0);
        cbsbVo2.setCbsb12(0);
        final List<CbsbVo> cbsbVos = Arrays.asList(cbsbVo2);
        when(mockCbsbMapper.selectSwJsTaskGoodsRelLists(new CbsbVo())).thenReturn(cbsbVos);

        // Run the test
        final List<CbsbVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbsbVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists_CbsbMapperReturnsNoItems() {
        // Setup
        final CbsbVo cbsbVo = new CbsbVo();
        cbsbVo.setCbsb01(0);
        cbsbVo.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb03(0);
        cbsbVo.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb05(0);
        cbsbVo.setCbsb06(0);
        cbsbVo.setCbsb07("cbsb07");
        cbsbVo.setCaua15("caua15");
        cbsbVo.setCbwa09("cbwa09");
        cbsbVo.setCala08("cala08");
        cbsbVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbVo.setCbsb09(0);
        cbsbVo.setCbsb10(0);
        cbsbVo.setCbsb11(0);
        cbsbVo.setCbsb12(0);

        when(mockCbsbMapper.selectSwJsTaskGoodsRelLists(new CbsbVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbsbVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbsbVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testInsertSwJsSkuBarcodel() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbscMapper.deleteByExample(any(CbscCriteria.class))).thenReturn(0);
        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodel(cbsbDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss() throws Exception {
        // Setup
        final CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsc01(0);
        cbsbsVo.setCbsb10(0);
        cbsbsVo.setCbsb09(0);
        cbsbsVo.setCbsb07("cbsb07");
        cbsbsVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setCbca08("cbca08");
        cbsbsVo.setCbwa09("cbwa09");
        cbsbsVo.setCaua15("nickName");
        cbsbsVo.setCbpb15("cbpb15");
        cbsbsVo.setCbsb17("cbsb17");
        cbsbsVo.setCbsb18("cbsb18");
        cbsbsVo.setCbsb19("cbsb19");
        cbsbsVo.setCbca28(0);
        cbsbsVo.setCala08("cala08");
        cbsbsVo.setCbsb20(0);
        cbsbsVo.setCbsb21("cbsb21");
        cbsbsVo.setCbsc17(0);
        cbsbsVo.setCbpb12("cbpb12");
        cbsbsVo.setCbpb08("cbpb08");
        cbsbsVo.setCbsc09(0.0);
        cbsbsVo.setCbsc11(0.0);
        cbsbsVo.setCbsc12(0.0);
        cbsbsVo.setCbsc13("cbsc13");
        cbsbsVo.setCbsb01(0);
        cbsbsVo.setCbpa07("cbpa07");
        cbsbsVo.setCny("cala08");
        cbsbsVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsd09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setGoods(Arrays.asList(scanVo));
        final TakeOrderSugestVo takeOrderSugestVo = new TakeOrderSugestVo();
        takeOrderSugestVo.setGoodClass("cbpa08");
        takeOrderSugestVo.setBrand("cala08");
        takeOrderSugestVo.setModel("cbpb12");
        takeOrderSugestVo.setDescription("cbpb08");
        takeOrderSugestVo.setSn("cbpm09");
        takeOrderSugestVo.setSku("cbla09");
        takeOrderSugestVo.setScanStatus("已扫码");
        cbsbsVo.setOutsuggestion(Arrays.asList(takeOrderSugestVo));
        cbsbsVo.setSaomanums(0);
        cbsbsVo.setNums(0.0);

        final CbsbsVo cbsbsVo1 = new CbsbsVo();
        cbsbsVo1.setCbsc01(0);
        cbsbsVo1.setCbsb10(0);
        cbsbsVo1.setCbsb09(0);
        cbsbsVo1.setCbsb07("cbsb07");
        cbsbsVo1.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo1.setCbca08("cbca08");
        cbsbsVo1.setCbwa09("cbwa09");
        cbsbsVo1.setCaua15("nickName");
        cbsbsVo1.setCbpb15("cbpb15");
        cbsbsVo1.setCbsb17("cbsb17");
        cbsbsVo1.setCbsb18("cbsb18");
        cbsbsVo1.setCbsb19("cbsb19");
        cbsbsVo1.setCbca28(0);
        cbsbsVo1.setCala08("cala08");
        cbsbsVo1.setCbsb20(0);
        cbsbsVo1.setCbsb21("cbsb21");
        cbsbsVo1.setCbsc17(0);
        cbsbsVo1.setCbpb12("cbpb12");
        cbsbsVo1.setCbpb08("cbpb08");
        cbsbsVo1.setCbsc09(0.0);
        cbsbsVo1.setCbsc11(0.0);
        cbsbsVo1.setCbsc12(0.0);
        cbsbsVo1.setCbsc13("cbsc13");
        cbsbsVo1.setCbsb01(0);
        cbsbsVo1.setCbpa07("cbpa07");
        cbsbsVo1.setCny("cala08");
        cbsbsVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa07");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbsd09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo1.setGoods(Arrays.asList(scanVo1));
        final TakeOrderSugestVo takeOrderSugestVo1 = new TakeOrderSugestVo();
        takeOrderSugestVo1.setGoodClass("cbpa08");
        takeOrderSugestVo1.setBrand("cala08");
        takeOrderSugestVo1.setModel("cbpb12");
        takeOrderSugestVo1.setDescription("cbpb08");
        takeOrderSugestVo1.setSn("cbpm09");
        takeOrderSugestVo1.setSku("cbla09");
        takeOrderSugestVo1.setScanStatus("已扫码");
        cbsbsVo1.setOutsuggestion(Arrays.asList(takeOrderSugestVo1));
        cbsbsVo1.setSaomanums(0);
        cbsbsVo1.setNums(0.0);
        final List<CbsbsVo> expectedResult = Arrays.asList(cbsbsVo1);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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
        final List<CbsbsVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsbsVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbscMapperReturnsNoItems() throws Exception {
        // Setup
        final CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsc01(0);
        cbsbsVo.setCbsb10(0);
        cbsbsVo.setCbsb09(0);
        cbsbsVo.setCbsb07("cbsb07");
        cbsbsVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setCbca08("cbca08");
        cbsbsVo.setCbwa09("cbwa09");
        cbsbsVo.setCaua15("nickName");
        cbsbsVo.setCbpb15("cbpb15");
        cbsbsVo.setCbsb17("cbsb17");
        cbsbsVo.setCbsb18("cbsb18");
        cbsbsVo.setCbsb19("cbsb19");
        cbsbsVo.setCbca28(0);
        cbsbsVo.setCala08("cala08");
        cbsbsVo.setCbsb20(0);
        cbsbsVo.setCbsb21("cbsb21");
        cbsbsVo.setCbsc17(0);
        cbsbsVo.setCbpb12("cbpb12");
        cbsbsVo.setCbpb08("cbpb08");
        cbsbsVo.setCbsc09(0.0);
        cbsbsVo.setCbsc11(0.0);
        cbsbsVo.setCbsc12(0.0);
        cbsbsVo.setCbsc13("cbsc13");
        cbsbsVo.setCbsb01(0);
        cbsbsVo.setCbpa07("cbpa07");
        cbsbsVo.setCny("cala08");
        cbsbsVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsd09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setGoods(Arrays.asList(scanVo));
        final TakeOrderSugestVo takeOrderSugestVo = new TakeOrderSugestVo();
        takeOrderSugestVo.setGoodClass("cbpa08");
        takeOrderSugestVo.setBrand("cala08");
        takeOrderSugestVo.setModel("cbpb12");
        takeOrderSugestVo.setDescription("cbpb08");
        takeOrderSugestVo.setSn("cbpm09");
        takeOrderSugestVo.setSku("cbla09");
        takeOrderSugestVo.setScanStatus("已扫码");
        cbsbsVo.setOutsuggestion(Arrays.asList(takeOrderSugestVo));
        cbsbsVo.setSaomanums(0);
        cbsbsVo.setNums(0.0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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
        final List<CbsbsVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsbsVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_RedisTemplateHasKeyReturnsNull() throws Exception {
        // Setup
        final CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsc01(0);
        cbsbsVo.setCbsb10(0);
        cbsbsVo.setCbsb09(0);
        cbsbsVo.setCbsb07("cbsb07");
        cbsbsVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setCbca08("cbca08");
        cbsbsVo.setCbwa09("cbwa09");
        cbsbsVo.setCaua15("nickName");
        cbsbsVo.setCbpb15("cbpb15");
        cbsbsVo.setCbsb17("cbsb17");
        cbsbsVo.setCbsb18("cbsb18");
        cbsbsVo.setCbsb19("cbsb19");
        cbsbsVo.setCbca28(0);
        cbsbsVo.setCala08("cala08");
        cbsbsVo.setCbsb20(0);
        cbsbsVo.setCbsb21("cbsb21");
        cbsbsVo.setCbsc17(0);
        cbsbsVo.setCbpb12("cbpb12");
        cbsbsVo.setCbpb08("cbpb08");
        cbsbsVo.setCbsc09(0.0);
        cbsbsVo.setCbsc11(0.0);
        cbsbsVo.setCbsc12(0.0);
        cbsbsVo.setCbsc13("cbsc13");
        cbsbsVo.setCbsb01(0);
        cbsbsVo.setCbpa07("cbpa07");
        cbsbsVo.setCny("cala08");
        cbsbsVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsd09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setGoods(Arrays.asList(scanVo));
        final TakeOrderSugestVo takeOrderSugestVo = new TakeOrderSugestVo();
        takeOrderSugestVo.setGoodClass("cbpa08");
        takeOrderSugestVo.setBrand("cala08");
        takeOrderSugestVo.setModel("cbpb12");
        takeOrderSugestVo.setDescription("cbpb08");
        takeOrderSugestVo.setSn("cbpm09");
        takeOrderSugestVo.setSku("cbla09");
        takeOrderSugestVo.setScanStatus("已扫码");
        cbsbsVo.setOutsuggestion(Arrays.asList(takeOrderSugestVo));
        cbsbsVo.setSaomanums(0);
        cbsbsVo.setNums(0.0);

        final CbsbsVo cbsbsVo1 = new CbsbsVo();
        cbsbsVo1.setCbsc01(0);
        cbsbsVo1.setCbsb10(0);
        cbsbsVo1.setCbsb09(0);
        cbsbsVo1.setCbsb07("cbsb07");
        cbsbsVo1.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo1.setCbca08("cbca08");
        cbsbsVo1.setCbwa09("cbwa09");
        cbsbsVo1.setCaua15("nickName");
        cbsbsVo1.setCbpb15("cbpb15");
        cbsbsVo1.setCbsb17("cbsb17");
        cbsbsVo1.setCbsb18("cbsb18");
        cbsbsVo1.setCbsb19("cbsb19");
        cbsbsVo1.setCbca28(0);
        cbsbsVo1.setCala08("cala08");
        cbsbsVo1.setCbsb20(0);
        cbsbsVo1.setCbsb21("cbsb21");
        cbsbsVo1.setCbsc17(0);
        cbsbsVo1.setCbpb12("cbpb12");
        cbsbsVo1.setCbpb08("cbpb08");
        cbsbsVo1.setCbsc09(0.0);
        cbsbsVo1.setCbsc11(0.0);
        cbsbsVo1.setCbsc12(0.0);
        cbsbsVo1.setCbsc13("cbsc13");
        cbsbsVo1.setCbsb01(0);
        cbsbsVo1.setCbpa07("cbpa07");
        cbsbsVo1.setCny("cala08");
        cbsbsVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa07");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbsd09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo1.setGoods(Arrays.asList(scanVo1));
        final TakeOrderSugestVo takeOrderSugestVo1 = new TakeOrderSugestVo();
        takeOrderSugestVo1.setGoodClass("cbpa08");
        takeOrderSugestVo1.setBrand("cala08");
        takeOrderSugestVo1.setModel("cbpb12");
        takeOrderSugestVo1.setDescription("cbpb08");
        takeOrderSugestVo1.setSn("cbpm09");
        takeOrderSugestVo1.setSku("cbla09");
        takeOrderSugestVo1.setScanStatus("已扫码");
        cbsbsVo1.setOutsuggestion(Arrays.asList(takeOrderSugestVo1));
        cbsbsVo1.setSaomanums(0);
        cbsbsVo1.setNums(0.0);
        final List<CbsbsVo> expectedResult = Arrays.asList(cbsbsVo1);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(null);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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
        final List<CbsbsVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsbsVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbsdMapperReturnsNoItems() throws Exception {
        // Setup
        final CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsc01(0);
        cbsbsVo.setCbsb10(0);
        cbsbsVo.setCbsb09(0);
        cbsbsVo.setCbsb07("cbsb07");
        cbsbsVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setCbca08("cbca08");
        cbsbsVo.setCbwa09("cbwa09");
        cbsbsVo.setCaua15("nickName");
        cbsbsVo.setCbpb15("cbpb15");
        cbsbsVo.setCbsb17("cbsb17");
        cbsbsVo.setCbsb18("cbsb18");
        cbsbsVo.setCbsb19("cbsb19");
        cbsbsVo.setCbca28(0);
        cbsbsVo.setCala08("cala08");
        cbsbsVo.setCbsb20(0);
        cbsbsVo.setCbsb21("cbsb21");
        cbsbsVo.setCbsc17(0);
        cbsbsVo.setCbpb12("cbpb12");
        cbsbsVo.setCbpb08("cbpb08");
        cbsbsVo.setCbsc09(0.0);
        cbsbsVo.setCbsc11(0.0);
        cbsbsVo.setCbsc12(0.0);
        cbsbsVo.setCbsc13("cbsc13");
        cbsbsVo.setCbsb01(0);
        cbsbsVo.setCbpa07("cbpa07");
        cbsbsVo.setCny("cala08");
        cbsbsVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsd09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setGoods(Arrays.asList(scanVo));
        final TakeOrderSugestVo takeOrderSugestVo = new TakeOrderSugestVo();
        takeOrderSugestVo.setGoodClass("cbpa08");
        takeOrderSugestVo.setBrand("cala08");
        takeOrderSugestVo.setModel("cbpb12");
        takeOrderSugestVo.setDescription("cbpb08");
        takeOrderSugestVo.setSn("cbpm09");
        takeOrderSugestVo.setSku("cbla09");
        takeOrderSugestVo.setScanStatus("已扫码");
        cbsbsVo.setOutsuggestion(Arrays.asList(takeOrderSugestVo));
        cbsbsVo.setSaomanums(0);
        cbsbsVo.setNums(0.0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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
        final List<CbsbsVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsbsVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbpmMapperReturnsNoItems() throws Exception {
        // Setup
        final CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsc01(0);
        cbsbsVo.setCbsb10(0);
        cbsbsVo.setCbsb09(0);
        cbsbsVo.setCbsb07("cbsb07");
        cbsbsVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setCbca08("cbca08");
        cbsbsVo.setCbwa09("cbwa09");
        cbsbsVo.setCaua15("nickName");
        cbsbsVo.setCbpb15("cbpb15");
        cbsbsVo.setCbsb17("cbsb17");
        cbsbsVo.setCbsb18("cbsb18");
        cbsbsVo.setCbsb19("cbsb19");
        cbsbsVo.setCbca28(0);
        cbsbsVo.setCala08("cala08");
        cbsbsVo.setCbsb20(0);
        cbsbsVo.setCbsb21("cbsb21");
        cbsbsVo.setCbsc17(0);
        cbsbsVo.setCbpb12("cbpb12");
        cbsbsVo.setCbpb08("cbpb08");
        cbsbsVo.setCbsc09(0.0);
        cbsbsVo.setCbsc11(0.0);
        cbsbsVo.setCbsc12(0.0);
        cbsbsVo.setCbsc13("cbsc13");
        cbsbsVo.setCbsb01(0);
        cbsbsVo.setCbpa07("cbpa07");
        cbsbsVo.setCny("cala08");
        cbsbsVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsd09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setGoods(Arrays.asList(scanVo));
        final TakeOrderSugestVo takeOrderSugestVo = new TakeOrderSugestVo();
        takeOrderSugestVo.setGoodClass("cbpa08");
        takeOrderSugestVo.setBrand("cala08");
        takeOrderSugestVo.setModel("cbpb12");
        takeOrderSugestVo.setDescription("cbpb08");
        takeOrderSugestVo.setSn("cbpm09");
        takeOrderSugestVo.setSku("cbla09");
        takeOrderSugestVo.setScanStatus("已扫码");
        cbsbsVo.setOutsuggestion(Arrays.asList(takeOrderSugestVo));
        cbsbsVo.setSaomanums(0);
        cbsbsVo.setNums(0.0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(Collections.emptyList());

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
        final List<CbsbsVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsbsVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CblaMapperReturnsNull() throws Exception {
        // Setup
        final CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsc01(0);
        cbsbsVo.setCbsb10(0);
        cbsbsVo.setCbsb09(0);
        cbsbsVo.setCbsb07("cbsb07");
        cbsbsVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setCbca08("cbca08");
        cbsbsVo.setCbwa09("cbwa09");
        cbsbsVo.setCaua15("nickName");
        cbsbsVo.setCbpb15("cbpb15");
        cbsbsVo.setCbsb17("cbsb17");
        cbsbsVo.setCbsb18("cbsb18");
        cbsbsVo.setCbsb19("cbsb19");
        cbsbsVo.setCbca28(0);
        cbsbsVo.setCala08("cala08");
        cbsbsVo.setCbsb20(0);
        cbsbsVo.setCbsb21("cbsb21");
        cbsbsVo.setCbsc17(0);
        cbsbsVo.setCbpb12("cbpb12");
        cbsbsVo.setCbpb08("cbpb08");
        cbsbsVo.setCbsc09(0.0);
        cbsbsVo.setCbsc11(0.0);
        cbsbsVo.setCbsc12(0.0);
        cbsbsVo.setCbsc13("cbsc13");
        cbsbsVo.setCbsb01(0);
        cbsbsVo.setCbpa07("cbpa07");
        cbsbsVo.setCny("cala08");
        cbsbsVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsd09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setGoods(Arrays.asList(scanVo));
        final TakeOrderSugestVo takeOrderSugestVo = new TakeOrderSugestVo();
        takeOrderSugestVo.setGoodClass("cbpa08");
        takeOrderSugestVo.setBrand("cala08");
        takeOrderSugestVo.setModel("cbpb12");
        takeOrderSugestVo.setDescription("cbpb08");
        takeOrderSugestVo.setSn("cbpm09");
        takeOrderSugestVo.setSku("cbla09");
        takeOrderSugestVo.setScanStatus("已扫码");
        cbsbsVo.setOutsuggestion(Arrays.asList(takeOrderSugestVo));
        cbsbsVo.setSaomanums(0);
        cbsbsVo.setNums(0.0);

        final CbsbsVo cbsbsVo1 = new CbsbsVo();
        cbsbsVo1.setCbsc01(0);
        cbsbsVo1.setCbsb10(0);
        cbsbsVo1.setCbsb09(0);
        cbsbsVo1.setCbsb07("cbsb07");
        cbsbsVo1.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo1.setCbca08("cbca08");
        cbsbsVo1.setCbwa09("cbwa09");
        cbsbsVo1.setCaua15("nickName");
        cbsbsVo1.setCbpb15("cbpb15");
        cbsbsVo1.setCbsb17("cbsb17");
        cbsbsVo1.setCbsb18("cbsb18");
        cbsbsVo1.setCbsb19("cbsb19");
        cbsbsVo1.setCbca28(0);
        cbsbsVo1.setCala08("cala08");
        cbsbsVo1.setCbsb20(0);
        cbsbsVo1.setCbsb21("cbsb21");
        cbsbsVo1.setCbsc17(0);
        cbsbsVo1.setCbpb12("cbpb12");
        cbsbsVo1.setCbpb08("cbpb08");
        cbsbsVo1.setCbsc09(0.0);
        cbsbsVo1.setCbsc11(0.0);
        cbsbsVo1.setCbsc12(0.0);
        cbsbsVo1.setCbsc13("cbsc13");
        cbsbsVo1.setCbsb01(0);
        cbsbsVo1.setCbpa07("cbpa07");
        cbsbsVo1.setCny("cala08");
        cbsbsVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa07");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbsd09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo1.setGoods(Arrays.asList(scanVo1));
        final TakeOrderSugestVo takeOrderSugestVo1 = new TakeOrderSugestVo();
        takeOrderSugestVo1.setGoodClass("cbpa08");
        takeOrderSugestVo1.setBrand("cala08");
        takeOrderSugestVo1.setModel("cbpb12");
        takeOrderSugestVo1.setDescription("cbpb08");
        takeOrderSugestVo1.setSn("cbpm09");
        takeOrderSugestVo1.setSku("cbla09");
        takeOrderSugestVo1.setScanStatus("已扫码");
        cbsbsVo1.setOutsuggestion(Arrays.asList(takeOrderSugestVo1));
        cbsbsVo1.setSaomanums(0);
        cbsbsVo1.setNums(0.0);
        final List<CbsbsVo> expectedResult = Arrays.asList(cbsbsVo1);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        final List<CbsbsVo> result = selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsbsVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_ThrowsExecutionException() {
        // Setup
        final CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsc01(0);
        cbsbsVo.setCbsb10(0);
        cbsbsVo.setCbsb09(0);
        cbsbsVo.setCbsb07("cbsb07");
        cbsbsVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setCbca08("cbca08");
        cbsbsVo.setCbwa09("cbwa09");
        cbsbsVo.setCaua15("nickName");
        cbsbsVo.setCbpb15("cbpb15");
        cbsbsVo.setCbsb17("cbsb17");
        cbsbsVo.setCbsb18("cbsb18");
        cbsbsVo.setCbsb19("cbsb19");
        cbsbsVo.setCbca28(0);
        cbsbsVo.setCala08("cala08");
        cbsbsVo.setCbsb20(0);
        cbsbsVo.setCbsb21("cbsb21");
        cbsbsVo.setCbsc17(0);
        cbsbsVo.setCbpb12("cbpb12");
        cbsbsVo.setCbpb08("cbpb08");
        cbsbsVo.setCbsc09(0.0);
        cbsbsVo.setCbsc11(0.0);
        cbsbsVo.setCbsc12(0.0);
        cbsbsVo.setCbsc13("cbsc13");
        cbsbsVo.setCbsb01(0);
        cbsbsVo.setCbpa07("cbpa07");
        cbsbsVo.setCny("cala08");
        cbsbsVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsd09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setGoods(Arrays.asList(scanVo));
        final TakeOrderSugestVo takeOrderSugestVo = new TakeOrderSugestVo();
        takeOrderSugestVo.setGoodClass("cbpa08");
        takeOrderSugestVo.setBrand("cala08");
        takeOrderSugestVo.setModel("cbpb12");
        takeOrderSugestVo.setDescription("cbpb08");
        takeOrderSugestVo.setSn("cbpm09");
        takeOrderSugestVo.setSku("cbla09");
        takeOrderSugestVo.setScanStatus("已扫码");
        cbsbsVo.setOutsuggestion(Arrays.asList(takeOrderSugestVo));
        cbsbsVo.setSaomanums(0);
        cbsbsVo.setNums(0.0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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
        assertThrows(ExecutionException.class,
                () -> selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsbsVo));
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_ThrowsInterruptedException() {
        // Setup
        final CbsbsVo cbsbsVo = new CbsbsVo();
        cbsbsVo.setCbsc01(0);
        cbsbsVo.setCbsb10(0);
        cbsbsVo.setCbsb09(0);
        cbsbsVo.setCbsb07("cbsb07");
        cbsbsVo.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setCbca08("cbca08");
        cbsbsVo.setCbwa09("cbwa09");
        cbsbsVo.setCaua15("nickName");
        cbsbsVo.setCbpb15("cbpb15");
        cbsbsVo.setCbsb17("cbsb17");
        cbsbsVo.setCbsb18("cbsb18");
        cbsbsVo.setCbsb19("cbsb19");
        cbsbsVo.setCbca28(0);
        cbsbsVo.setCala08("cala08");
        cbsbsVo.setCbsb20(0);
        cbsbsVo.setCbsb21("cbsb21");
        cbsbsVo.setCbsc17(0);
        cbsbsVo.setCbpb12("cbpb12");
        cbsbsVo.setCbpb08("cbpb08");
        cbsbsVo.setCbsc09(0.0);
        cbsbsVo.setCbsc11(0.0);
        cbsbsVo.setCbsc12(0.0);
        cbsbsVo.setCbsc13("cbsc13");
        cbsbsVo.setCbsb01(0);
        cbsbsVo.setCbpa07("cbpa07");
        cbsbsVo.setCny("cala08");
        cbsbsVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbsd09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsbsVo.setGoods(Arrays.asList(scanVo));
        final TakeOrderSugestVo takeOrderSugestVo = new TakeOrderSugestVo();
        takeOrderSugestVo.setGoodClass("cbpa08");
        takeOrderSugestVo.setBrand("cala08");
        takeOrderSugestVo.setModel("cbpb12");
        takeOrderSugestVo.setDescription("cbpb08");
        takeOrderSugestVo.setSn("cbpm09");
        takeOrderSugestVo.setSku("cbla09");
        takeOrderSugestVo.setScanStatus("已扫码");
        cbsbsVo.setOutsuggestion(Arrays.asList(takeOrderSugestVo));
        cbsbsVo.setSaomanums(0);
        cbsbsVo.setNums(0.0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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
        assertThrows(InterruptedException.class,
                () -> selloutofwarehouseServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbsbsVo));
    }

    @Test
    public void testInsertSwJsStoress() throws Exception {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_CbscMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_RedisTemplateHasKeyReturnsNull() throws Exception {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(null);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_CbsdMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_CbpmMapperReturnsNoItems() throws Exception {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_CblaMapperReturnsNull() throws Exception {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);
        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_CbpkMapperReturnsNoItems() throws Exception {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(Collections.emptyList());

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_GsGoodsSnMapperReturnsNoItems() throws Exception {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_ThrowsExecutionException() {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        assertThrows(ExecutionException.class,
                () -> selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList));
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsStoress_ThrowsInterruptedException() {
        // Setup
        final Cbsd itemList = new Cbsd();
        itemList.setCbsd01(0);
        itemList.setCbsd02(0);
        itemList.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd04(0);
        itemList.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbsd06(0);
        itemList.setCbsd07(0);
        itemList.setCbsd08(0);
        itemList.setCbsd09("cbsd09");
        itemList.setCbsd10(0);
        itemList.setCbsd11(0);
        itemList.setCbsd12("cbsd12");
        itemList.setCbsb01(0);
        itemList.setUserId(0);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        // Configure CbscMapper.selectByExample(...).
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        final List<Cbsc> cbscs = Arrays.asList(cbsc);
        when(mockCbscMapper.selectByExample(any(CbscCriteria.class))).thenReturn(cbscs);

        // Configure CalaMapper.selectByPrimaryKey(...).
        final Cala cala = new Cala();
        cala.setCala01(0);
        cala.setCala02("cala02");
        cala.setCala03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cala.setCala05(0);
        cala.setCala06(0);
        cala.setCala07(0);
        cala.setCala08("cala08");
        cala.setCala09("cala09");
        cala.setCala10("cala10");
        cala.setCala11("cala11");
        cala.setCala12("cala12");
        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(cala);

        // Configure CbwaMapper.selectByPrimaryKey(...).
        final Cbwa cbwa = new Cbwa();
        cbwa.setCbwa01(0);
        cbwa.setCbwa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa03(0);
        cbwa.setCbwa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbwa.setCbwa05(0);
        cbwa.setCbwa06(0);
        cbwa.setCbwa07(0);
        cbwa.setCbwa08("cbwa08");
        cbwa.setCbwa09("cbwa09");
        cbwa.setCbwa10("cbwa10");
        cbwa.setCbwa11("cbwa11");
        cbwa.setCbwa12("cbwa12");
        cbwa.setCbwa13(0);
        cbwa.setCbwa14(0);
        cbwa.setCbwa15(0);
        when(mockCbwaMapper.selectByPrimaryKey(0)).thenReturn(cbwa);

        // Configure CbcaMapper.selectByPrimaryKey(...).
        final Cbca cbca = new Cbca();
        cbca.setCbca01(0);
        cbca.setCbca02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca03(0);
        cbca.setCbca04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbca.setCbca05(0);
        cbca.setCbca06(0);
        cbca.setCbca07("cbca07");
        cbca.setCbca08("cbca08");
        cbca.setCbca09("cbca09");
        cbca.setCbca10("cbca10");
        cbca.setCbca11("cbca11");
        cbca.setCbca12("cbca12");
        cbca.setCbca13("cbca13");
        cbca.setCbca14("cbca14");
        cbca.setCbca28(0);
        when(mockCbcaMapper.selectByPrimaryKey(0)).thenReturn(cbca);

        when(mockSysUserMapper.selectByPrimaryKey(0L)).thenReturn(new SysUser(0L));

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

        // Configure CbpaMapper.selectByPrimaryKey(...).
        final Cbpa cbpa = new Cbpa();
        cbpa.setCbpa01(0);
        cbpa.setCbpa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpa.setCbpa04(0);
        cbpa.setCbpa05(0);
        cbpa.setCbpa06(0);
        cbpa.setCbpa07("cbpa07");
        cbpa.setCbpa08("cbpa08");
        cbpa.setCbpa09(0);
        cbpa.setCbpa11("cbpa11");
        cbpa.setCbpa12("cbpa12");
        cbpa.setChildren(Arrays.asList(new Cbpa()));
        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(cbpa);

        when(mockRedisTemplates.opsForList()).thenReturn(null);
        when(mockRedisTemplates.hasKey("key")).thenReturn(false);

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbpmMapper.selectByExample(...).
        final Cbpm cbpm = new Cbpm();
        cbpm.setCbpm01(0);
        cbpm.setCbpm02(0);
        cbpm.setCbpm03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm04(0);
        cbpm.setCbpm05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpm.setCbpm06(0);
        cbpm.setCbpm07(0);
        cbpm.setCbpm08(0);
        cbpm.setCbpm09("cbpm09");
        cbpm.setCbpm10(0);
        cbpm.setCbpm11(0);
        cbpm.setCbpm12("cbpm12");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

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

        when(mockRedisTemplates.opsForValue()).thenReturn(null);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpkMapper.selectByExample(...).
        final Cbpk cbpk = new Cbpk();
        cbpk.setCbpk01(0);
        cbpk.setCbpk02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk03(0);
        cbpk.setCbpk04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk05(0);
        cbpk.setCbpk06(0);
        cbpk.setCbpk07("cbpk07");
        cbpk.setCbpk08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk09(0);
        cbpk.setCbpk10(0);
        cbpk.setCbpk11(0);
        cbpk.setCbpk12(0);
        cbpk.setCbpk13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpk.setCbpk14(0);
        cbpk.setCbpk15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cbpk> cbpks = Arrays.asList(cbpk);
        when(mockCbpkMapper.selectByExample(any(CbpkCriteria.class))).thenReturn(cbpks);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("sn");
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

        when(mockCbscMapper.updateByPrimaryKeySelective(new Cbsc())).thenReturn(0);
        when(mockRedisTemplates.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn("result");

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("sn");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockCbsdMapper.insertSelective(new Cbsd())).thenReturn(0);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> selloutofwarehouseServiceImplUnderTest.insertSwJsStoress(itemList));
        verify(mockSqlSession).close();
        verify(mockCbscMapper).updateByPrimaryKeySelective(new Cbsc());
        verify(mockRedisTemplates).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbsdMapper).insertSelective(new Cbsd());
    }

    @Test
    public void testInsertSwJsSkuBarcodedit() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsdMapper.selectByExample(...).
        final Cbsd cbsd = new Cbsd();
        cbsd.setCbsd01(0);
        cbsd.setCbsd02(0);
        cbsd.setCbsd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd04(0);
        cbsd.setCbsd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsd.setCbsd06(0);
        cbsd.setCbsd07(0);
        cbsd.setCbsd08(0);
        cbsd.setCbsd09("cbsd09");
        cbsd.setCbsd10(0);
        cbsd.setCbsd11(0);
        cbsd.setCbsd12("cbsd12");
        cbsd.setCbsb01(0);
        cbsd.setUserId(0);
        final List<Cbsd> cbsds = Arrays.asList(cbsd);
        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(cbsds);

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodedit(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbsbMapper).updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class));
    }

    @Test
    public void testInsertSwJsSkuBarcodedit_CbsdMapperReturnsNoItems() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        when(mockCbsdMapper.selectByExample(any(CbsdCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbsbMapper.updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSwJsSkuBarcodedit(cbsbDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbsbMapper).updateByExampleSelective(eq(new Cbsb()), any(CbsbCriteria.class));
    }

    @Test
    public void testSelloutofwarehouseeditone() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        // Configure CbsbMapper.selectByPrimaryKey(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        when(mockCbsbMapper.selectByPrimaryKey(0)).thenReturn(cbsb);

        when(mockCbsbMapper.updateByPrimaryKeySelective(new Cbsb())).thenReturn(0);
        when(mockCbscMapper.deleteByExample(any(CbscCriteria.class))).thenReturn(0);
        when(mockCbscMapper.insertSelective(new Cbsc())).thenReturn(0);

        // Run the test
        selloutofwarehouseServiceImplUnderTest.Selloutofwarehouseeditone(cbsbDo);

        // Verify the results
        verify(mockCbsbMapper).updateByPrimaryKeySelective(new Cbsb());
        verify(mockCbscMapper).insertSelective(new Cbsc());
    }

    @Test
    public void testInsertSelloutofwarehouseplus() throws Exception {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        when(mockNumberGenerate.getSellofwarehouseNo(0)).thenReturn("cbsb07");
        when(mockCbsbMapper.insertSelective(new Cbsb())).thenReturn(0);

        // Configure CbsbMapper.selectByExample(...).
        final Cbsb cbsb = new Cbsb();
        cbsb.setCbsb01(0);
        cbsb.setCbsb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb03(0);
        cbsb.setCbsb04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb05(0);
        cbsb.setCbsb06(0);
        cbsb.setCbsb07("cbsb07");
        cbsb.setCbsb08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsb.setCbsb09(0);
        cbsb.setCbsb10(0);
        cbsb.setCbsb11(0);
        cbsb.setCbsb12(0);
        cbsb.setCbsb16(0);
        cbsb.setCbsb17("cbsb17");
        cbsb.setCbsb18("cbsb18");
        cbsb.setCbsb19("cbsb19");
        cbsb.setCbsb20(0);
        cbsb.setCbsb21("cbsb21");
        cbsb.setUserId(0);
        final List<Cbsb> cbsbs = Arrays.asList(cbsb);
        when(mockCbsbMapper.selectByExample(any(CbsbCriteria.class))).thenReturn(cbsbs);

        when(mockCbscMapper.insertSelective(new Cbsc())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSelloutofwarehouseplus(cbsbDo);

        // Verify the results
        assertEquals(0, 1,result);
     //   verify(mockCbsbMapper).insertSelective(new Cbsb());
     //   verify(mockCbscMapper).insertSelective(new Cbsc());
    }

    @Test
    public void testInsertSelloutofwarehouseplus_CbsbMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbsbDo cbsbDo = new CbsbDo();
        cbsbDo.setCbsb01(0);
        cbsbDo.setCbsb10(0);
        final Cbsc cbsc = new Cbsc();
        cbsc.setCbsc01(0);
        cbsc.setCbsc02(0);
        cbsc.setCbsc03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc04(0);
        cbsc.setCbsc05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsc.setCbsc06(0);
        cbsc.setCbsc07(0);
        cbsc.setCbsc08(0);
        cbsc.setCbsc09(0.0);
        cbsc.setCbsc10(0.0);
        cbsc.setCbsc11(0.0);
        cbsc.setCbsc12(0.0);
        cbsc.setCbsc13("cbsc13");
        cbsc.setCbsb01(0);
        cbsc.setCbsc14(0);
        cbsc.setCbsc15(0);
        cbsc.setCbsc16(0);
        cbsc.setCbsc17(0);
        cbsc.setUserId(0);
        cbsc.setTakegoodsid(0);
        cbsc.setScannum(0);
        cbsbDo.setGoods(Arrays.asList(cbsc));

        when(mockNumberGenerate.getSellofwarehouseNo(0)).thenReturn("cbsb07");
        when(mockCbsbMapper.insertSelective(new Cbsb())).thenReturn(0);
        when(mockCbsbMapper.selectByExample(any(CbsbCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbscMapper.insertSelective(new Cbsc())).thenReturn(0);

        // Run the test
        final int result = selloutofwarehouseServiceImplUnderTest.insertSelloutofwarehouseplus(cbsbDo);

        // Verify the results
        assertEquals(0, 1,result);
   //     verify(mockCbsbMapper).insertSelective(new Cbsb());
    //    verify(mockCbscMapper).insertSelective(new Cbsc());
    }
}
