package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.CbpgDo;
import com.ruoyi.system.domain.Do.GsGoodsSkuDo;
import com.ruoyi.system.domain.Do.GsGoodsSnDo;
import com.ruoyi.system.domain.dto.CbpgDto;
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
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SwJsPurchasereturnordersServiceImplTest {

    @Mock
    private CbpgMapper mockCbpgMapper;
    @Mock
    private GsGoodsSkuMapper mockGsGoodsSkuMapper;
    @Mock
    private CbphMapper mockCbphMapper;
    @Mock
    private GsGoodsSnMapper mockGsGoodsSnMapper;
    @Mock
    private BaseCheckService mockBaseCheckService;
    @Mock
    private CbpcMapper mockCbpcMapper;
    @Mock
    private CbpdMapper mockCbpdMapper;
    @Mock
    private CbbaMapper mockCbbaMapper;
    @Mock
    private CbsaMapper mockCbasMapper;
    @Mock
    private CbpeMapper mockCbpeMapper;
    @Mock
    private CbpiMapper mockCbpiMapper;
    @Mock
    private TaskService mockTaskService;
    @Mock
    private CblaMapper mockCblaMapper;
    @Mock
    private SqlSessionFactory mockSqlSessionFactory;
    @Mock
    private NumberGenerate mockNumberGenerate;
    @Mock
    private CbsaMapper mockCbsaMapper;
    @Mock
    private CbwaMapper mockCbwaMapper;
    @Mock
    private CalaMapper mockCalaMapper;
    @Mock
    private CbpbMapper mockCbpbMapper;
    @Mock
    private StringRedisTemplate mockRedisTemplate;

    @InjectMocks
    private SwJsPurchasereturnordersServiceImpl swJsPurchasereturnordersServiceImplUnderTest;

    @Test
    public void testInsertSwJsSkuBarcodes() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Run the test
        final IdVo result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
    }

    @Test
    public void testInsertSwJsSkuBarcodes_CbpgMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final IdVo result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
    }

    @Test
    public void testInsertSwJsSkuBarcodess() {
        // Setup
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> itemList = Arrays.asList(cbph);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

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

        when(mockCbpgMapper.updateByPrimaryKeySelective(new Cbpg())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodess(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbpgMapper).updateByPrimaryKeySelective(new Cbpg());
    }

    @Test
    public void testInsertSwJsSkuBarcodess_CbpgMapperSelectByPrimaryKeyReturnsNull() {
        // Setup
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> itemList = Arrays.asList(cbph);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class,
                () -> swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodess(itemList));
    }

    @Test
    public void testInsertSwJsSkuBarcodess_GsGoodsSkuMapperReturnsNoItems() {
        // Setup
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> itemList = Arrays.asList(cbph);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(Collections.emptyList());

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpgMapper.updateByPrimaryKeySelective(new Cbpg())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodess(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbpgMapper).updateByPrimaryKeySelective(new Cbpg());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm() throws Exception {
        // Setup
        final Cbpi itemList = new Cbpi();
        itemList.setCbpi01(0);
        itemList.setCbpi02(0);
        itemList.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi04(0);
        itemList.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi06(0);
        itemList.setCbpi07(0);
        itemList.setCbpi08(0);
        itemList.setCbpi09("cbpi09");
        itemList.setCbpi10(0);
        itemList.setCbpi11(0);
        itemList.setCbpi12("cbpi12");
        itemList.setCbpg01(0);
        itemList.setUserId(0);

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

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

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

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure BaseCheckService.checkGsGoodsSn(...).
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
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn2 = new GsGoodsSn();
        gsGoodsSn2.setId(0);
        gsGoodsSn2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setCreateBy(0);
        gsGoodsSn2.setUpdateBy(0);
        gsGoodsSn2.setDeleteFlag((byte) 0b0);
        gsGoodsSn2.setSn("sn");
        gsGoodsSn2.setGoodsId(0);
        gsGoodsSn2.setLocationId(0);
        gsGoodsSn2.setStatus((byte) 0b0);
        gsGoodsSn2.setWhId(0);
        gsGoodsSn2.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn2);

        when(mockCbpiMapper.insertSelective(new Cbpi())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbpiMapper).insertSelective(new Cbpi());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CbpbMapperReturnsNull() throws Exception {
        // Setup
        final Cbpi itemList = new Cbpi();
        itemList.setCbpi01(0);
        itemList.setCbpi02(0);
        itemList.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi04(0);
        itemList.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi06(0);
        itemList.setCbpi07(0);
        itemList.setCbpi08(0);
        itemList.setCbpi09("cbpi09");
        itemList.setCbpi10(0);
        itemList.setCbpi11(0);
        itemList.setCbpi12("cbpi12");
        itemList.setCbpg01(0);
        itemList.setUserId(0);

        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

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

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure BaseCheckService.checkGsGoodsSn(...).
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
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn2 = new GsGoodsSn();
        gsGoodsSn2.setId(0);
        gsGoodsSn2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setCreateBy(0);
        gsGoodsSn2.setUpdateBy(0);
        gsGoodsSn2.setDeleteFlag((byte) 0b0);
        gsGoodsSn2.setSn("sn");
        gsGoodsSn2.setGoodsId(0);
        gsGoodsSn2.setLocationId(0);
        gsGoodsSn2.setStatus((byte) 0b0);
        gsGoodsSn2.setWhId(0);
        gsGoodsSn2.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn2);

        when(mockCbpiMapper.insertSelective(new Cbpi())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbpiMapper).insertSelective(new Cbpi());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CbphMapperReturnsNoItems() {
        // Setup
        final Cbpi itemList = new Cbpi();
        itemList.setCbpi01(0);
        itemList.setCbpi02(0);
        itemList.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi04(0);
        itemList.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi06(0);
        itemList.setCbpi07(0);
        itemList.setCbpi08(0);
        itemList.setCbpi09("cbpi09");
        itemList.setCbpi10(0);
        itemList.setCbpi11(0);
        itemList.setCbpi12("cbpi12");
        itemList.setCbpg01(0);
        itemList.setUserId(0);

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

        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

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

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure BaseCheckService.checkGsGoodsSn(...).
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
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn2 = new GsGoodsSn();
        gsGoodsSn2.setId(0);
        gsGoodsSn2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setCreateBy(0);
        gsGoodsSn2.setUpdateBy(0);
        gsGoodsSn2.setDeleteFlag((byte) 0b0);
        gsGoodsSn2.setSn("sn");
        gsGoodsSn2.setGoodsId(0);
        gsGoodsSn2.setLocationId(0);
        gsGoodsSn2.setStatus((byte) 0b0);
        gsGoodsSn2.setWhId(0);
        gsGoodsSn2.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn2);

        when(mockCbpiMapper.insertSelective(new Cbpi())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbpiMapper).insertSelective(new Cbpi());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CbpgMapperReturnsNull() {
        // Setup
        final Cbpi itemList = new Cbpi();
        itemList.setCbpi01(0);
        itemList.setCbpi02(0);
        itemList.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi04(0);
        itemList.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi06(0);
        itemList.setCbpi07(0);
        itemList.setCbpi08(0);
        itemList.setCbpi09("cbpi09");
        itemList.setCbpi10(0);
        itemList.setCbpi11(0);
        itemList.setCbpi12("cbpi12");
        itemList.setCbpg01(0);
        itemList.setUserId(0);

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

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class,
                () -> swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList));
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_GsGoodsSnMapperReturnsNoItems() {
        // Setup
        final Cbpi itemList = new Cbpi();
        itemList.setCbpi01(0);
        itemList.setCbpi02(0);
        itemList.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi04(0);
        itemList.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi06(0);
        itemList.setCbpi07(0);
        itemList.setCbpi08(0);
        itemList.setCbpi09("cbpi09");
        itemList.setCbpi10(0);
        itemList.setCbpi11(0);
        itemList.setCbpi12("cbpi12");
        itemList.setCbpg01(0);
        itemList.setUserId(0);

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

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());

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

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure BaseCheckService.checkGsGoodsSn(...).
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
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

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

        when(mockCbpiMapper.insertSelective(new Cbpi())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbpiMapper).insertSelective(new Cbpi());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CblaMapperReturnsNull() throws Exception {
        // Setup
        final Cbpi itemList = new Cbpi();
        itemList.setCbpi01(0);
        itemList.setCbpi02(0);
        itemList.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi04(0);
        itemList.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi06(0);
        itemList.setCbpi07(0);
        itemList.setCbpi08(0);
        itemList.setCbpi09("cbpi09");
        itemList.setCbpi10(0);
        itemList.setCbpi11(0);
        itemList.setCbpi12("cbpi12");
        itemList.setCbpg01(0);
        itemList.setUserId(0);

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

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

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

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Run the test
        assertThrows(SwException.class,
                () -> swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList));
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CbpiMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbpi itemList = new Cbpi();
        itemList.setCbpi01(0);
        itemList.setCbpi02(0);
        itemList.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi04(0);
        itemList.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpi06(0);
        itemList.setCbpi07(0);
        itemList.setCbpi08(0);
        itemList.setCbpi09("cbpi09");
        itemList.setCbpi10(0);
        itemList.setCbpi11(0);
        itemList.setCbpi12("cbpi12");
        itemList.setCbpg01(0);
        itemList.setUserId(0);

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

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph = new Cbph();
        cbph.setCbph01(0);
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

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

        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(Collections.emptyList());

        // Configure BaseCheckService.checkGsGoodsSn(...).
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
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn2 = new GsGoodsSn();
        gsGoodsSn2.setId(0);
        gsGoodsSn2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setCreateBy(0);
        gsGoodsSn2.setUpdateBy(0);
        gsGoodsSn2.setDeleteFlag((byte) 0b0);
        gsGoodsSn2.setSn("sn");
        gsGoodsSn2.setGoodsId(0);
        gsGoodsSn2.setLocationId(0);
        gsGoodsSn2.setStatus((byte) 0b0);
        gsGoodsSn2.setWhId(0);
        gsGoodsSn2.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setPrdDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn2.setGroudStatus((byte) 0b0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn2);

        when(mockCbpiMapper.insertSelective(new Cbpi())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
        verify(mockCbpiMapper).insertSelective(new Cbpi());
    }

    @Test
    public void testInsertSwJsStores() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> itemList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CbsaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> itemList = Arrays.asList(cbpgDo);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CbwaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> itemList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CalaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> itemList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CbpgMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> itemList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(Collections.emptyList());

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CbpbMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> itemList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> swJsGoodsList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final String result = swJsPurchasereturnordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CbsaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> swJsGoodsList = Arrays.asList(cbpgDo);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final String result = swJsPurchasereturnordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CbwaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> swJsGoodsList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final String result = swJsPurchasereturnordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CalaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> swJsGoodsList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final String result = swJsPurchasereturnordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CbpgMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> swJsGoodsList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(Collections.emptyList());

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        // Configure CbpbMapper.selectByExample(...).
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
        final List<Cbpb> cbpbs = Arrays.asList(cbpb);
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(cbpbs);

        // Run the test
        final String result = swJsPurchasereturnordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CbpbMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDo cbpgDo = new CbpgDo();
        cbpgDo.setCbph02(0);
        cbpgDo.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph04(0);
        cbpgDo.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbph06(0);
        cbpgDo.setCbph07(0);
        cbpgDo.setCbph11(0.0);
        cbpgDo.setCbph12(0.0);
        cbpgDo.setCbpg01(0);
        cbpgDo.setUserId(0);
        cbpgDo.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgDo.setCbpg10(0);
        cbpgDo.setCbpg16(0);
        cbpgDo.setCbph08(0);
        cbpgDo.setCbph09(0.0);
        cbpgDo.setCbph10(0.0);
        cbpgDo.setCbph13("cbph13");
        cbpgDo.setSuppierName("SuppierName");
        cbpgDo.setStorename("storename");
        cbpgDo.setMoneytype("moneytype");
        cbpgDo.setGoodtype("goodtype");
        final List<CbpgDo> swJsGoodsList = Arrays.asList(cbpgDo);

        // Configure CbsaMapper.selectByExample(...).
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
        final List<Cbsa> cbsas = Arrays.asList(cbsa);
        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(cbsas);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CalaMapper.selectByExample(...).
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
        final List<Cala> calas = Arrays.asList(cala);
        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(calas);

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final String result = swJsPurchasereturnordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpgMapper).insertSelective(new Cbpg());
        verify(mockSqlSession).close();
    }

    @Test
    public void testSwJsPurchasereturnorderseditone() {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockCbpgMapper.updateByPrimaryKeySelective(new Cbpg())).thenReturn(0);
        when(mockCbphMapper.deleteByExample(any(CbphCriteria.class))).thenReturn(0);
        when(mockCbphMapper.insertSelective(new Cbph())).thenReturn(0);

        // Run the test
        swJsPurchasereturnordersServiceImplUnderTest.SwJsPurchasereturnorderseditone(cbpgDto);

        // Verify the results
        verify(mockCbpgMapper).updateByPrimaryKeySelective(new Cbpg());
        verify(mockCbphMapper).insertSelective(new Cbph());
    }

    @Test
    public void testDeleteSwJsSkuBarcodsById() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.deleteSwJsSkuBarcodsById(cbpgDto);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testDeleteSwJsSkuBarcodsById_CbphMapperReturnsNoItems() {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.deleteSwJsSkuBarcodsById(cbpgDto);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testUpdateSwJsSkuBarcodes() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg1 = new Cbpg();
        cbpg1.setCbpg01(0);
        cbpg1.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg1.setCbpg03(0);
        cbpg1.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg1.setCbpg05(0);
        cbpg1.setCbpg06(0);
        cbpg1.setCbpg07("cbpg07");
        cbpg1.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg1.setCbpg09(0);
        cbpg1.setCbpg10(0);
        cbpg1.setCbpg11(0);
        cbpg1.setCbpg12(0);
        cbpg1.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg1.setCbpg16(0);
        cbpg1.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg1);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.updateSwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpgMapper).updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class));
    }

    @Test
    public void testUpdateSwJsSkuBarcodes_CbpgMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.updateSwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpgMapper).updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class));
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists() throws Exception {
        // Setup
        final CbpgVo cbpgVo = new CbpgVo();
        cbpgVo.setPinpai("pinpai");
        cbpgVo.setCbpg01(0);
        cbpgVo.setCbpb08("cbpb08");
        cbpgVo.setCbph08(0);
        cbpgVo.setCbpb12("cbpb12");
        cbpgVo.setCbph09(0.0);
        cbpgVo.setCbpb15("cbpb15");
        cbpgVo.setCbpa08("cbpa08");
        cbpgVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpi09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo.setGoods(Arrays.asList(scanVo));
        cbpgVo.setSaomanums(0);
        cbpgVo.setNums(0.0);

        final CbpgVo cbpgVo1 = new CbpgVo();
        cbpgVo1.setPinpai("pinpai");
        cbpgVo1.setCbpg01(0);
        cbpgVo1.setCbpb08("cbpb08");
        cbpgVo1.setCbph08(0);
        cbpgVo1.setCbpb12("cbpb12");
        cbpgVo1.setCbph09(0.0);
        cbpgVo1.setCbpb15("cbpb15");
        cbpgVo1.setCbpa08("cbpa08");
        cbpgVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("pinpai");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpi09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo1.setGoods(Arrays.asList(scanVo1));
        cbpgVo1.setSaomanums(0);
        cbpgVo1.setNums(0.0);
        final List<CbpgVo> expectedResult = Arrays.asList(cbpgVo1);

        // Configure CbpgMapper.getInfoss(...).
        final CbpgVo cbpgVo2 = new CbpgVo();
        cbpgVo2.setPinpai("pinpai");
        cbpgVo2.setCbpg01(0);
        cbpgVo2.setCbpb08("cbpb08");
        cbpgVo2.setCbph08(0);
        cbpgVo2.setCbpb12("cbpb12");
        cbpgVo2.setCbph09(0.0);
        cbpgVo2.setCbpb15("cbpb15");
        cbpgVo2.setCbpa08("cbpa08");
        cbpgVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("pinpai");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbpi09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo2.setGoods(Arrays.asList(scanVo2));
        cbpgVo2.setSaomanums(0);
        cbpgVo2.setNums(0.0);
        final List<CbpgVo> cbpgVos = Arrays.asList(cbpgVo2);
        when(mockCbpgMapper.getInfoss(new CbpgVo())).thenReturn(cbpgVos);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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
        final List<CbpgVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbpgVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists_CbpgMapperReturnsNoItems() {
        // Setup
        final CbpgVo cbpgVo = new CbpgVo();
        cbpgVo.setPinpai("pinpai");
        cbpgVo.setCbpg01(0);
        cbpgVo.setCbpb08("cbpb08");
        cbpgVo.setCbph08(0);
        cbpgVo.setCbpb12("cbpb12");
        cbpgVo.setCbph09(0.0);
        cbpgVo.setCbpb15("cbpb15");
        cbpgVo.setCbpa08("cbpa08");
        cbpgVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpi09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo.setGoods(Arrays.asList(scanVo));
        cbpgVo.setSaomanums(0);
        cbpgVo.setNums(0.0);

        when(mockCbpgMapper.getInfoss(new CbpgVo())).thenReturn(Collections.emptyList());

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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
        final List<CbpgVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbpgVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists_CbpiMapperReturnsNoItems() {
        // Setup
        final CbpgVo cbpgVo = new CbpgVo();
        cbpgVo.setPinpai("pinpai");
        cbpgVo.setCbpg01(0);
        cbpgVo.setCbpb08("cbpb08");
        cbpgVo.setCbph08(0);
        cbpgVo.setCbpb12("cbpb12");
        cbpgVo.setCbph09(0.0);
        cbpgVo.setCbpb15("cbpb15");
        cbpgVo.setCbpa08("cbpa08");
        cbpgVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpi09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo.setGoods(Arrays.asList(scanVo));
        cbpgVo.setSaomanums(0);
        cbpgVo.setNums(0.0);

        // Configure CbpgMapper.getInfoss(...).
        final CbpgVo cbpgVo1 = new CbpgVo();
        cbpgVo1.setPinpai("pinpai");
        cbpgVo1.setCbpg01(0);
        cbpgVo1.setCbpb08("cbpb08");
        cbpgVo1.setCbph08(0);
        cbpgVo1.setCbpb12("cbpb12");
        cbpgVo1.setCbph09(0.0);
        cbpgVo1.setCbpb15("cbpb15");
        cbpgVo1.setCbpa08("cbpa08");
        cbpgVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("pinpai");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpi09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo1.setGoods(Arrays.asList(scanVo1));
        cbpgVo1.setSaomanums(0);
        cbpgVo1.setNums(0.0);
        final List<CbpgVo> cbpgVos = Arrays.asList(cbpgVo1);
        when(mockCbpgMapper.getInfoss(new CbpgVo())).thenReturn(cbpgVos);

        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(Collections.emptyList());

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
        final List<CbpgVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbpgVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists_CblaMapperReturnsNull() {
        // Setup
        final CbpgVo cbpgVo = new CbpgVo();
        cbpgVo.setPinpai("pinpai");
        cbpgVo.setCbpg01(0);
        cbpgVo.setCbpb08("cbpb08");
        cbpgVo.setCbph08(0);
        cbpgVo.setCbpb12("cbpb12");
        cbpgVo.setCbph09(0.0);
        cbpgVo.setCbpb15("cbpb15");
        cbpgVo.setCbpa08("cbpa08");
        cbpgVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpi09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo.setGoods(Arrays.asList(scanVo));
        cbpgVo.setSaomanums(0);
        cbpgVo.setNums(0.0);

        // Configure CbpgMapper.getInfoss(...).
        final CbpgVo cbpgVo1 = new CbpgVo();
        cbpgVo1.setPinpai("pinpai");
        cbpgVo1.setCbpg01(0);
        cbpgVo1.setCbpb08("cbpb08");
        cbpgVo1.setCbph08(0);
        cbpgVo1.setCbpb12("cbpb12");
        cbpgVo1.setCbph09(0.0);
        cbpgVo1.setCbpb15("cbpb15");
        cbpgVo1.setCbpa08("cbpa08");
        cbpgVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("pinpai");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpi09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo1.setGoods(Arrays.asList(scanVo1));
        cbpgVo1.setSaomanums(0);
        cbpgVo1.setNums(0.0);
        final List<CbpgVo> cbpgVos = Arrays.asList(cbpgVo1);
        when(mockCbpgMapper.getInfoss(new CbpgVo())).thenReturn(cbpgVos);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class,
                () -> swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbpgVo));
    }

    @Test
    public void testSelectSwJsTaskGoodsRelList() {
        // Setup
        final CbpgVo cbpgVo = new CbpgVo();
        cbpgVo.setPinpai("pinpai");
        cbpgVo.setCbpg01(0);
        cbpgVo.setCbpb08("cbpb08");
        cbpgVo.setCbph08(0);
        cbpgVo.setCbpb12("cbpb12");
        cbpgVo.setCbph09(0.0);
        cbpgVo.setCbpb15("cbpb15");
        cbpgVo.setCbpa08("cbpa08");
        cbpgVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpi09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo.setGoods(Arrays.asList(scanVo));
        cbpgVo.setSaomanums(0);
        cbpgVo.setNums(0.0);

        final CbpgVo cbpgVo1 = new CbpgVo();
        cbpgVo1.setPinpai("pinpai");
        cbpgVo1.setCbpg01(0);
        cbpgVo1.setCbpb08("cbpb08");
        cbpgVo1.setCbph08(0);
        cbpgVo1.setCbpb12("cbpb12");
        cbpgVo1.setCbph09(0.0);
        cbpgVo1.setCbpb15("cbpb15");
        cbpgVo1.setCbpa08("cbpa08");
        cbpgVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("pinpai");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpi09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo1.setGoods(Arrays.asList(scanVo1));
        cbpgVo1.setSaomanums(0);
        cbpgVo1.setNums(0.0);
        final List<CbpgVo> expectedResult = Arrays.asList(cbpgVo1);

        // Configure CbpgMapper.getInfos(...).
        final CbpgVo cbpgVo2 = new CbpgVo();
        cbpgVo2.setPinpai("pinpai");
        cbpgVo2.setCbpg01(0);
        cbpgVo2.setCbpb08("cbpb08");
        cbpgVo2.setCbph08(0);
        cbpgVo2.setCbpb12("cbpb12");
        cbpgVo2.setCbph09(0.0);
        cbpgVo2.setCbpb15("cbpb15");
        cbpgVo2.setCbpa08("cbpa08");
        cbpgVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("pinpai");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbpi09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo2.setGoods(Arrays.asList(scanVo2));
        cbpgVo2.setSaomanums(0);
        cbpgVo2.setNums(0.0);
        final List<CbpgVo> cbpgVos = Arrays.asList(cbpgVo2);
        when(mockCbpgMapper.getInfos(new CbpgVo())).thenReturn(cbpgVos);

        // Run the test
        final List<CbpgVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelList(cbpgVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelList_CbpgMapperReturnsNoItems() {
        // Setup
        final CbpgVo cbpgVo = new CbpgVo();
        cbpgVo.setPinpai("pinpai");
        cbpgVo.setCbpg01(0);
        cbpgVo.setCbpb08("cbpb08");
        cbpgVo.setCbph08(0);
        cbpgVo.setCbpb12("cbpb12");
        cbpgVo.setCbph09(0.0);
        cbpgVo.setCbpb15("cbpb15");
        cbpgVo.setCbpa08("cbpa08");
        cbpgVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpi09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo.setGoods(Arrays.asList(scanVo));
        cbpgVo.setSaomanums(0);
        cbpgVo.setNums(0.0);

        when(mockCbpgMapper.getInfos(new CbpgVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbpgVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelList(cbpgVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss() throws Exception {
        // Setup
        final CbpgVo cbpgVo = new CbpgVo();
        cbpgVo.setPinpai("pinpai");
        cbpgVo.setCbpg01(0);
        cbpgVo.setCbpb08("cbpb08");
        cbpgVo.setCbph08(0);
        cbpgVo.setCbpb12("cbpb12");
        cbpgVo.setCbph09(0.0);
        cbpgVo.setCbpb15("cbpb15");
        cbpgVo.setCbpa08("cbpa08");
        cbpgVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpi09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo.setGoods(Arrays.asList(scanVo));
        cbpgVo.setSaomanums(0);
        cbpgVo.setNums(0.0);

        final CbpgVo cbpgVo1 = new CbpgVo();
        cbpgVo1.setPinpai("pinpai");
        cbpgVo1.setCbpg01(0);
        cbpgVo1.setCbpb08("cbpb08");
        cbpgVo1.setCbph08(0);
        cbpgVo1.setCbpb12("cbpb12");
        cbpgVo1.setCbph09(0.0);
        cbpgVo1.setCbpb15("cbpb15");
        cbpgVo1.setCbpa08("cbpa08");
        cbpgVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("pinpai");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpi09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo1.setGoods(Arrays.asList(scanVo1));
        cbpgVo1.setSaomanums(0);
        cbpgVo1.setNums(0.0);
        final List<CbpgVo> expectedResult = Arrays.asList(cbpgVo1);

        // Configure CbpgMapper.getInfosss(...).
        final CbpgVo cbpgVo2 = new CbpgVo();
        cbpgVo2.setPinpai("pinpai");
        cbpgVo2.setCbpg01(0);
        cbpgVo2.setCbpb08("cbpb08");
        cbpgVo2.setCbph08(0);
        cbpgVo2.setCbpb12("cbpb12");
        cbpgVo2.setCbph09(0.0);
        cbpgVo2.setCbpb15("cbpb15");
        cbpgVo2.setCbpa08("cbpa08");
        cbpgVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("pinpai");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbpi09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo2.setGoods(Arrays.asList(scanVo2));
        cbpgVo2.setSaomanums(0);
        cbpgVo2.setNums(0.0);
        final List<CbpgVo> cbpgVos = Arrays.asList(cbpgVo2);
        when(mockCbpgMapper.getInfosss(new CbpgVo())).thenReturn(cbpgVos);

        // Run the test
        final List<CbpgVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbpgVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbpgMapperReturnsNoItems() {
        // Setup
        final CbpgVo cbpgVo = new CbpgVo();
        cbpgVo.setPinpai("pinpai");
        cbpgVo.setCbpg01(0);
        cbpgVo.setCbpb08("cbpb08");
        cbpgVo.setCbph08(0);
        cbpgVo.setCbpb12("cbpb12");
        cbpgVo.setCbph09(0.0);
        cbpgVo.setCbpb15("cbpb15");
        cbpgVo.setCbpa08("cbpa08");
        cbpgVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("pinpai");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpi09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpgVo.setGoods(Arrays.asList(scanVo));
        cbpgVo.setSaomanums(0);
        cbpgVo.setNums(0.0);

        when(mockCbpgMapper.getInfosss(new CbpgVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbpgVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbpgVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSwJsSkuBarcodeshs() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodeshs(cbpgDto);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSwJsSkuBarcodesh() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodesh(cbpgDto);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSwJsSkuBarcodesh_CbpiMapperReturnsNoItems() {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodesh(cbpgDto);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSwJsSkuBarcodeshss() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodeshss(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testSwJsSkuBarcodeshss_CbpiMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodeshss(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testSwJsSkuBarcodeshss_CbwaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodeshss(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testSwJsSkuBarcodeshss_CbphMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodeshss(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testSwJsSkuBarcodeshss_GsGoodsSkuMapperSelectByGoodsIdAndWhIdReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodeshss(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testSwJsSkuBarcodeshss_TaskServiceThrowsInterruptedException() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenThrow(InterruptedException.class);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodeshss(cbpgDto));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
    }

    @Test
    public void testSwJsSkuBarcodes() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Configure CbpiMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpiMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku2);
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

        // Configure TaskService.updateGsGoodsSku(...).
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
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

        // Configure CbbaMapper.selectByPrimaryKey(...).
        final Cbba cbba = new Cbba();
        cbba.setCbba01(0);
        cbba.setCbba02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba03(0);
        cbba.setCbba04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba05(0);
        cbba.setCbba06(0);
        cbba.setCbba07("cbba07");
        cbba.setCbba08(0);
        cbba.setCbba09(0.0);
        cbba.setCbba10(0);
        cbba.setCbba11(0.0);
        cbba.setCbba12(0);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(0L);
        when(mockCbbaMapper.selectByPrimaryKey(0)).thenReturn(cbba);

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

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testSwJsSkuBarcodes_CbphMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Configure CbpiMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpiMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku2);
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

        // Configure TaskService.updateGsGoodsSku(...).
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
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

        // Configure CbbaMapper.selectByPrimaryKey(...).
        final Cbba cbba = new Cbba();
        cbba.setCbba01(0);
        cbba.setCbba02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba03(0);
        cbba.setCbba04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba05(0);
        cbba.setCbba06(0);
        cbba.setCbba07("cbba07");
        cbba.setCbba08(0);
        cbba.setCbba09(0.0);
        cbba.setCbba10(0);
        cbba.setCbba11(0.0);
        cbba.setCbba12(0);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(0L);
        when(mockCbbaMapper.selectByPrimaryKey(0)).thenReturn(cbba);

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

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testSwJsSkuBarcodes_CbwaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Configure CbpiMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpiMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku2);
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

        // Configure TaskService.updateGsGoodsSku(...).
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
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

        // Configure CbbaMapper.selectByPrimaryKey(...).
        final Cbba cbba = new Cbba();
        cbba.setCbba01(0);
        cbba.setCbba02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba03(0);
        cbba.setCbba04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba05(0);
        cbba.setCbba06(0);
        cbba.setCbba07("cbba07");
        cbba.setCbba08(0);
        cbba.setCbba09(0.0);
        cbba.setCbba10(0);
        cbba.setCbba11(0.0);
        cbba.setCbba12(0);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(0L);
        when(mockCbbaMapper.selectByPrimaryKey(0)).thenReturn(cbba);

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

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testSwJsSkuBarcodes_CbpiMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Configure CbpiMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpiMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku2);
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

        // Configure TaskService.updateGsGoodsSku(...).
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
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

        // Configure CbbaMapper.selectByPrimaryKey(...).
        final Cbba cbba = new Cbba();
        cbba.setCbba01(0);
        cbba.setCbba02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba03(0);
        cbba.setCbba04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba05(0);
        cbba.setCbba06(0);
        cbba.setCbba07("cbba07");
        cbba.setCbba08(0);
        cbba.setCbba09(0.0);
        cbba.setCbba10(0);
        cbba.setCbba11(0.0);
        cbba.setCbba12(0);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(0L);
        when(mockCbbaMapper.selectByPrimaryKey(0)).thenReturn(cbba);

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

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testSwJsSkuBarcodes_GsGoodsSkuMapperSelectByGoodsIdAndWhIdReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

        when(mockGsGoodsSkuMapper.selectByGoodsIdAndWhId(0, 0)).thenReturn(Collections.emptyList());

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Configure CbpiMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpiMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure TaskService.checkGsGoodsSku(...).
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
        final List<GsGoodsSku> gsGoodsSkus = Arrays.asList(gsGoodsSku1);
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

        // Configure CbbaMapper.selectByPrimaryKey(...).
        final Cbba cbba = new Cbba();
        cbba.setCbba01(0);
        cbba.setCbba02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba03(0);
        cbba.setCbba04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba05(0);
        cbba.setCbba06(0);
        cbba.setCbba07("cbba07");
        cbba.setCbba08(0);
        cbba.setCbba09(0.0);
        cbba.setCbba10(0);
        cbba.setCbba11(0.0);
        cbba.setCbba12(0);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(0L);
        when(mockCbbaMapper.selectByPrimaryKey(0)).thenReturn(cbba);

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

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testSwJsSkuBarcodes_TaskServiceInsertCBIBThrowsInterruptedException() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        when(mockTaskService.InsertCBIB(new CbibDo())).thenThrow(InterruptedException.class);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto));
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
    }

    @Test
    public void testSwJsSkuBarcodes_CbpiMapperSelectbyidReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);
        when(mockCbpiMapper.selectbyid(new UIOVo())).thenReturn(Collections.emptyList());

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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku2);
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

        // Configure TaskService.updateGsGoodsSku(...).
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
        when(mockTaskService.updateGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

        // Configure CbbaMapper.selectByPrimaryKey(...).
        final Cbba cbba = new Cbba();
        cbba.setCbba01(0);
        cbba.setCbba02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba03(0);
        cbba.setCbba04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba05(0);
        cbba.setCbba06(0);
        cbba.setCbba07("cbba07");
        cbba.setCbba08(0);
        cbba.setCbba09(0.0);
        cbba.setCbba10(0);
        cbba.setCbba11(0.0);
        cbba.setCbba12(0);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(0L);
        when(mockCbbaMapper.selectByPrimaryKey(0)).thenReturn(cbba);

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

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testSwJsSkuBarcodes_TaskServiceCheckGsGoodsSkuReturnsNoItems() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Configure CbpiMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpiMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

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

        // Configure CbbaMapper.selectByPrimaryKey(...).
        final Cbba cbba = new Cbba();
        cbba.setCbba01(0);
        cbba.setCbba02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba03(0);
        cbba.setCbba04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbba.setCbba05(0);
        cbba.setCbba06(0);
        cbba.setCbba07("cbba07");
        cbba.setCbba08(0);
        cbba.setCbba09(0.0);
        cbba.setCbba10(0);
        cbba.setCbba11(0.0);
        cbba.setCbba12(0);
        cbba.setCbba13(0.0);
        cbba.setCbba14(0.0);
        cbba.setCbba15(0L);
        when(mockCbbaMapper.selectByPrimaryKey(0)).thenReturn(cbba);

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

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testSwJsSkuBarcodes_CblaMapperReturnsNull() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        // Configure CbpgMapper.selectByPrimaryKey(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        when(mockCbpgMapper.selectByPrimaryKey(0)).thenReturn(cbpg);

        // Configure CbphMapper.selectByExample(...).
        final Cbph cbph1 = new Cbph();
        cbph1.setCbph01(0);
        cbph1.setCbph02(0);
        cbph1.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph04(0);
        cbph1.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph1.setCbph06(0);
        cbph1.setCbph07(0);
        cbph1.setCbph08(0);
        cbph1.setCbph09(0.0);
        cbph1.setCbph10(0.0);
        cbph1.setCbph11(0.0);
        cbph1.setCbph12(0.0);
        cbph1.setCbph13("cbph13");
        cbph1.setCbpg01(0);
        cbph1.setUserId(0);
        final List<Cbph> cbphs = Arrays.asList(cbph1);
        when(mockCbphMapper.selectByExample(any(CbphCriteria.class))).thenReturn(cbphs);

        // Configure CbwaMapper.selectByExample(...).
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
        final List<Cbwa> cbwas = Arrays.asList(cbwa);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(cbwas);

        // Configure CbpiMapper.selectByExample(...).
        final Cbpi cbpi = new Cbpi();
        cbpi.setCbpi01(0);
        cbpi.setCbpi02(0);
        cbpi.setCbpi03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi04(0);
        cbpi.setCbpi05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpi.setCbpi06(0);
        cbpi.setCbpi07(0);
        cbpi.setCbpi08(0);
        cbpi.setCbpi09("cbpi09");
        cbpi.setCbpi10(0);
        cbpi.setCbpi11(0);
        cbpi.setCbpi12("cbpi12");
        cbpi.setCbpg01(0);
        cbpi.setUserId(0);
        final List<Cbpi> cbpis = Arrays.asList(cbpi);
        when(mockCbpiMapper.selectByExample(any(CbpiCriteria.class))).thenReturn(cbpis);

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

        when(mockGsGoodsSkuMapper.updateByPrimaryKeySelective(new GsGoodsSku())).thenReturn(0);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpgMapper.updateByExampleSelective(eq(new Cbpg()), any(CbpgCriteria.class))).thenReturn(0);

        // Configure CbpiMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpiMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

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
        final List<GsGoodsSku> gsGoodsSkus1 = Arrays.asList(gsGoodsSku2);
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSkus1);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> swJsPurchasereturnordersServiceImplUnderTest.SwJsSkuBarcodes(cbpgDto));
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListssS() {
        // Setup
        final GsGoodsSnsVo gsGoodsSnsVo = new GsGoodsSnsVo();
        gsGoodsSnsVo.setId(0);
        gsGoodsSnsVo.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo.setCreateBy(0);
        gsGoodsSnsVo.setUpdateBy(0);
        gsGoodsSnsVo.setDeleteFlag((byte) 0b0);
        gsGoodsSnsVo.setSn("sn");
        gsGoodsSnsVo.setGoodsId(0);
        gsGoodsSnsVo.setLocationId(0);
        gsGoodsSnsVo.setStatus((byte) 0b0);
        gsGoodsSnsVo.setWhId(0);
        gsGoodsSnsVo.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo.setCbpb10("cbpb10");
        gsGoodsSnsVo.setBrandId(0);

        final GsGoodsSnsVo gsGoodsSnsVo1 = new GsGoodsSnsVo();
        gsGoodsSnsVo1.setId(0);
        gsGoodsSnsVo1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo1.setCreateBy(0);
        gsGoodsSnsVo1.setUpdateBy(0);
        gsGoodsSnsVo1.setDeleteFlag((byte) 0b0);
        gsGoodsSnsVo1.setSn("sn");
        gsGoodsSnsVo1.setGoodsId(0);
        gsGoodsSnsVo1.setLocationId(0);
        gsGoodsSnsVo1.setStatus((byte) 0b0);
        gsGoodsSnsVo1.setWhId(0);
        gsGoodsSnsVo1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo1.setCbpb10("cbpb10");
        gsGoodsSnsVo1.setBrandId(0);
        final List<GsGoodsSnsVo> expectedResult = Arrays.asList(gsGoodsSnsVo1);
        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());

        // Configure GsGoodsSnMapper.getInfosss(...).
        final GsGoodsSnsVo gsGoodsSnsVo2 = new GsGoodsSnsVo();
        gsGoodsSnsVo2.setId(0);
        gsGoodsSnsVo2.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo2.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo2.setCreateBy(0);
        gsGoodsSnsVo2.setUpdateBy(0);
        gsGoodsSnsVo2.setDeleteFlag((byte) 0b0);
        gsGoodsSnsVo2.setSn("sn");
        gsGoodsSnsVo2.setGoodsId(0);
        gsGoodsSnsVo2.setLocationId(0);
        gsGoodsSnsVo2.setStatus((byte) 0b0);
        gsGoodsSnsVo2.setWhId(0);
        gsGoodsSnsVo2.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo2.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo2.setCbpb10("cbpb10");
        gsGoodsSnsVo2.setBrandId(0);
        final List<GsGoodsSnsVo> gsGoodsSnsVos = Arrays.asList(gsGoodsSnsVo2);
        when(mockGsGoodsSnMapper.getInfosss(new GsGoodsSnsVo())).thenReturn(gsGoodsSnsVos);

        // Run the test
        final List<GsGoodsSnsVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelListssS(
                gsGoodsSnsVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListssS_GsGoodsSnMapperReturnsNoItems() {
        // Setup
        final GsGoodsSnsVo gsGoodsSnsVo = new GsGoodsSnsVo();
        gsGoodsSnsVo.setId(0);
        gsGoodsSnsVo.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo.setCreateBy(0);
        gsGoodsSnsVo.setUpdateBy(0);
        gsGoodsSnsVo.setDeleteFlag((byte) 0b0);
        gsGoodsSnsVo.setSn("sn");
        gsGoodsSnsVo.setGoodsId(0);
        gsGoodsSnsVo.setLocationId(0);
        gsGoodsSnsVo.setStatus((byte) 0b0);
        gsGoodsSnsVo.setWhId(0);
        gsGoodsSnsVo.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSnsVo.setCbpb10("cbpb10");
        gsGoodsSnsVo.setBrandId(0);

        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockGsGoodsSnMapper.getInfosss(new GsGoodsSnsVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<GsGoodsSnsVo> result = swJsPurchasereturnordersServiceImplUnderTest.selectSwJsTaskGoodsRelListssS(
                gsGoodsSnsVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesplus() throws Exception {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);

        // Configure CbpgMapper.selectByExample(...).
        final Cbpg cbpg = new Cbpg();
        cbpg.setCbpg01(0);
        cbpg.setCbpg02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg03(0);
        cbpg.setCbpg04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg05(0);
        cbpg.setCbpg06(0);
        cbpg.setCbpg07("cbpg07");
        cbpg.setCbpg08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg09(0);
        cbpg.setCbpg10(0);
        cbpg.setCbpg11(0);
        cbpg.setCbpg12(0);
        cbpg.setCbpg13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpg.setCbpg16(0);
        cbpg.setUserId(0);
        final List<Cbpg> cbpgs = Arrays.asList(cbpg);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(cbpgs);

        when(mockCbphMapper.insertSelective(new Cbph())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesplus(cbpgDto);

        // Verify the results
        assertEquals(0,1, result);
       // verify(mockCbpgMapper).insertSelective(new Cbpg());
     //   verify(mockCbphMapper).insertSelective(new Cbph());
    }

    @Test
    public void testInsertSwJsSkuBarcodesplus_CbpgMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpgDto cbpgDto = new CbpgDto();
        cbpgDto.setCbpg01(0);
        cbpgDto.setCbpg07("cbpg07");
        cbpgDto.setCbpg10(0);
        final Cbph cbph = new Cbph();
        cbph.setCbph02(0);
        cbph.setCbph03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph04(0);
        cbph.setCbph05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbph.setCbph06(0);
        cbph.setCbph07(0);
        cbph.setCbph08(0);
        cbph.setCbph09(0.0);
        cbph.setCbph10(0.0);
        cbph.setCbph11(0.0);
        cbph.setCbph12(0.0);
        cbph.setCbph13("cbph13");
        cbph.setCbpg01(0);
        cbph.setUserId(0);
        cbpgDto.setGoods(Arrays.asList(cbph));

        when(mockNumberGenerate.getPurchasereturnNo(0)).thenReturn("cbpg07");
        when(mockCbpgMapper.insertSelective(new Cbpg())).thenReturn(0);
        when(mockCbpgMapper.selectByExample(any(CbpgCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbphMapper.insertSelective(new Cbph())).thenReturn(0);

        // Run the test
        final int result = swJsPurchasereturnordersServiceImplUnderTest.insertSwJsSkuBarcodesplus(cbpgDto);

        // Verify the results
        assertEquals(0, 1,result);
       // verify(mockCbpgMapper).insertSelective(new Cbpg());
      //  verify(mockCbphMapper).insertSelective(new Cbph());
    }
}
