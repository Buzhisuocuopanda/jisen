package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbqaDo;
import com.ruoyi.system.domain.vo.CbqaVo;
import com.ruoyi.system.domain.vo.IdVo;
import com.ruoyi.system.mapper.*;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SWQualityinspectionlistImplTest {

    @Mock
    private CbpkMapper mockCbpkMapper;
    @Mock
    private CbpmMapper mockCbpmMapper;
    @Mock
    private CbqaMapper mockCbqaMapper;
    @Mock
    private CbqbMapper mockCbqbMapper;
    @Mock
    private CbplMapper mockCbplMapper;
    @Mock
    private GsGoodsSnMapper mockGsGoodsSnMapper;
    @Mock
    private SqlSessionFactory mockSqlSessionFactory;
    @Mock
    private NumberGenerate mockNumberGenerate;

    @InjectMocks
    private SWQualityinspectionlistImpl swQualityinspectionlistImplUnderTest;

    @Test
    public void testInsertSwJsSkuBarcodes() throws Exception {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getQualityinspectionlistNo()).thenReturn("cbqa07");
        when(mockCbqaMapper.insertSelective(new Cbqa())).thenReturn(0);

        // Configure CbqaMapper.selectByExample(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        final List<Cbqa> cbqas = Arrays.asList(cbqa);
        when(mockCbqaMapper.selectByExample(any(CbqaCriteria.class))).thenReturn(cbqas);

        // Run the test
        final IdVo result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodes(cbqaDo);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockCbqaMapper).insertSelective(new Cbqa());
    }

    @Test
    public void testInsertSwJsSkuBarcodes_CbqaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getQualityinspectionlistNo()).thenReturn("cbqa07");
        when(mockCbqaMapper.insertSelective(new Cbqa())).thenReturn(0);
        when(mockCbqaMapper.selectByExample(any(CbqaCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final IdVo result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodes(cbqaDo);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockCbqaMapper).insertSelective(new Cbqa());
    }

    @Test
    public void testInsertSwJsSkuBarcode() {
        // Setup
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        final List<Cbqb> itemList = Arrays.asList(cbqb);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByPrimaryKey(new GsGoodsSn())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcode(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockGsGoodsSnMapper).updateByPrimaryKey(new GsGoodsSn());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcode_GsGoodsSnMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        final List<Cbqb> itemList = Arrays.asList(cbqb);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());
        when(mockGsGoodsSnMapper.updateByPrimaryKey(new GsGoodsSn())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcode(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockGsGoodsSnMapper).updateByPrimaryKey(new GsGoodsSn());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcode_CbpmMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        final List<Cbqb> itemList = Arrays.asList(cbqb);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByPrimaryKey(new GsGoodsSn())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcode(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockGsGoodsSnMapper).updateByPrimaryKey(new GsGoodsSn());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcode_CbplMapperSelectByExampleReturnsNull() {
        // Setup
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        final List<Cbqb> itemList = Arrays.asList(cbqb);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByPrimaryKey(new GsGoodsSn())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(null);
        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcode(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockGsGoodsSnMapper).updateByPrimaryKey(new GsGoodsSn());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcode_CbplMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        final List<Cbqb> itemList = Arrays.asList(cbqb);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByPrimaryKey(new GsGoodsSn())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcode(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockGsGoodsSnMapper).updateByPrimaryKey(new GsGoodsSn());
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs2() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs2(cbqaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockGsGoodsSnMapper).updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs2_CbqbMapperReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(Collections.emptyList());

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs2(cbqaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockGsGoodsSnMapper).updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs2_GsGoodsSnMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());
        when(mockGsGoodsSnMapper.updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs2(cbqaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockGsGoodsSnMapper).updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs2_CbpmMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs2(cbqaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockGsGoodsSnMapper).updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs2_CbplMapperSelectByExampleReturnsNull() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(null);
        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs2(cbqaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockGsGoodsSnMapper).updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs2_CbplMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

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
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setRepairStatus(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs2(cbqaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockGsGoodsSnMapper).updateByExample(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
    }

    @Test
    public void testInsertSwJsSkuBarcodeselete() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        when(mockCbqaMapper.deleteByPrimaryKey(0)).thenReturn(0);
        when(mockCbqbMapper.deleteByExample(any(CbqbCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeselete(cbqaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbqaMapper).deleteByPrimaryKey(0);
        verify(mockCbqbMapper).deleteByExample(any(CbqbCriteria.class));
    }

    @Test
    public void testInsertSwJsSkuBarcodesh() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByExampleSelective(eq(new Cbqa()), any(CbqaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodesh(cbqaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbqaMapper.updateByExampleSelective(eq(new Cbqa()), any(CbqaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs(cbqaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs_CbqbMapperReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(Collections.emptyList());

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbqaMapper.updateByExampleSelective(eq(new Cbqa()), any(CbqaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs(cbqaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs_CbpmMapperReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbqaMapper.updateByExampleSelective(eq(new Cbqa()), any(CbqaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs(cbqaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeshs_CbpkMapperReturnsNull() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeshs(cbqaDo));
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss() throws Exception {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        final CbqaVo cbqaVo1 = new CbqaVo();
        cbqaVo1.setCbqa01(0);
        cbqaVo1.setCala08("cala08");
        cbqaVo1.setCbpb12("cbpb12");
        cbqaVo1.setCbpb08("cbpb08");
        cbqaVo1.setCbqb08(0);
        cbqaVo1.setCbqb09("cbqb09");
        cbqaVo1.setCbqa07("cbqa07");
        cbqaVo1.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqa09(0);
        cbqaVo1.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqb10("cbqb10");
        cbqaVo1.setCbqb01(0);
        cbqaVo1.setStartTime("startTime");
        cbqaVo1.setEndTime("endTime");
        cbqaVo1.setCbpm08(0);
        final List<CbqaVo> expectedResult = Arrays.asList(cbqaVo1);

        // Configure CbqaMapper.selectSwJsTaskGoodsRelListss(...).
        final CbqaVo cbqaVo2 = new CbqaVo();
        cbqaVo2.setCbqa01(0);
        cbqaVo2.setCala08("cala08");
        cbqaVo2.setCbpb12("cbpb12");
        cbqaVo2.setCbpb08("cbpb08");
        cbqaVo2.setCbqb08(0);
        cbqaVo2.setCbqb09("cbqb09");
        cbqaVo2.setCbqa07("cbqa07");
        cbqaVo2.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqa09(0);
        cbqaVo2.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqb10("cbqb10");
        cbqaVo2.setCbqb01(0);
        cbqaVo2.setStartTime("startTime");
        cbqaVo2.setEndTime("endTime");
        cbqaVo2.setCbpm08(0);
        final List<CbqaVo> cbqaVos = Arrays.asList(cbqaVo2);
        when(mockCbqaMapper.selectSwJsTaskGoodsRelListss(new CbqaVo())).thenReturn(cbqaVos);

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.selectSwJsTaskGoodsRelListss(cbqaVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbqaMapperReturnsNoItems() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        when(mockCbqaMapper.selectSwJsTaskGoodsRelListss(new CbqaVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.selectSwJsTaskGoodsRelListss(cbqaVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelList() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        final CbqaVo cbqaVo1 = new CbqaVo();
        cbqaVo1.setCbqa01(0);
        cbqaVo1.setCala08("cala08");
        cbqaVo1.setCbpb12("cbpb12");
        cbqaVo1.setCbpb08("cbpb08");
        cbqaVo1.setCbqb08(0);
        cbqaVo1.setCbqb09("cbqb09");
        cbqaVo1.setCbqa07("cbqa07");
        cbqaVo1.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqa09(0);
        cbqaVo1.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqb10("cbqb10");
        cbqaVo1.setCbqb01(0);
        cbqaVo1.setStartTime("startTime");
        cbqaVo1.setEndTime("endTime");
        cbqaVo1.setCbpm08(0);
        final List<CbqaVo> expectedResult = Arrays.asList(cbqaVo1);

        // Configure CbqaMapper.selectSwJsTaskGoodsRelList(...).
        final CbqaVo cbqaVo2 = new CbqaVo();
        cbqaVo2.setCbqa01(0);
        cbqaVo2.setCala08("cala08");
        cbqaVo2.setCbpb12("cbpb12");
        cbqaVo2.setCbpb08("cbpb08");
        cbqaVo2.setCbqb08(0);
        cbqaVo2.setCbqb09("cbqb09");
        cbqaVo2.setCbqa07("cbqa07");
        cbqaVo2.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqa09(0);
        cbqaVo2.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqb10("cbqb10");
        cbqaVo2.setCbqb01(0);
        cbqaVo2.setStartTime("startTime");
        cbqaVo2.setEndTime("endTime");
        cbqaVo2.setCbpm08(0);
        final List<CbqaVo> cbqaVos = Arrays.asList(cbqaVo2);
        when(mockCbqaMapper.selectSwJsTaskGoodsRelList(new CbqaVo())).thenReturn(cbqaVos);

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.selectSwJsTaskGoodsRelList(cbqaVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelList_CbqaMapperReturnsNoItems() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        when(mockCbqaMapper.selectSwJsTaskGoodsRelList(new CbqaVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.selectSwJsTaskGoodsRelList(cbqaVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSwJsSkuBarcodeselect() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        final CbqaVo cbqaVo1 = new CbqaVo();
        cbqaVo1.setCbqa01(0);
        cbqaVo1.setCala08("cala08");
        cbqaVo1.setCbpb12("cbpb12");
        cbqaVo1.setCbpb08("cbpb08");
        cbqaVo1.setCbqb08(0);
        cbqaVo1.setCbqb09("cbqb09");
        cbqaVo1.setCbqa07("cbqa07");
        cbqaVo1.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqa09(0);
        cbqaVo1.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqb10("cbqb10");
        cbqaVo1.setCbqb01(0);
        cbqaVo1.setStartTime("startTime");
        cbqaVo1.setEndTime("endTime");
        cbqaVo1.setCbpm08(0);
        final List<CbqaVo> expectedResult = Arrays.asList(cbqaVo1);

        // Configure CbqaMapper.SwJsSkuBarcodeselect(...).
        final CbqaVo cbqaVo2 = new CbqaVo();
        cbqaVo2.setCbqa01(0);
        cbqaVo2.setCala08("cala08");
        cbqaVo2.setCbpb12("cbpb12");
        cbqaVo2.setCbpb08("cbpb08");
        cbqaVo2.setCbqb08(0);
        cbqaVo2.setCbqb09("cbqb09");
        cbqaVo2.setCbqa07("cbqa07");
        cbqaVo2.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqa09(0);
        cbqaVo2.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqb10("cbqb10");
        cbqaVo2.setCbqb01(0);
        cbqaVo2.setStartTime("startTime");
        cbqaVo2.setEndTime("endTime");
        cbqaVo2.setCbpm08(0);
        final List<CbqaVo> cbqaVos = Arrays.asList(cbqaVo2);
        when(mockCbqaMapper.SwJsSkuBarcodeselect(new CbqaVo())).thenReturn(cbqaVos);

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.SwJsSkuBarcodeselect(cbqaVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSwJsSkuBarcodeselect_CbqaMapperReturnsNoItems() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        when(mockCbqaMapper.SwJsSkuBarcodeselect(new CbqaVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.SwJsSkuBarcodeselect(cbqaVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSwJsSkuBarcodeselects() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        final CbqaVo cbqaVo1 = new CbqaVo();
        cbqaVo1.setCbqa01(0);
        cbqaVo1.setCala08("cala08");
        cbqaVo1.setCbpb12("cbpb12");
        cbqaVo1.setCbpb08("cbpb08");
        cbqaVo1.setCbqb08(0);
        cbqaVo1.setCbqb09("cbqb09");
        cbqaVo1.setCbqa07("cbqa07");
        cbqaVo1.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqa09(0);
        cbqaVo1.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqb10("cbqb10");
        cbqaVo1.setCbqb01(0);
        cbqaVo1.setStartTime("startTime");
        cbqaVo1.setEndTime("endTime");
        cbqaVo1.setCbpm08(0);
        final List<CbqaVo> expectedResult = Arrays.asList(cbqaVo1);

        // Configure CbqaMapper.SwJsSkuBarcodeselects(...).
        final CbqaVo cbqaVo2 = new CbqaVo();
        cbqaVo2.setCbqa01(0);
        cbqaVo2.setCala08("cala08");
        cbqaVo2.setCbpb12("cbpb12");
        cbqaVo2.setCbpb08("cbpb08");
        cbqaVo2.setCbqb08(0);
        cbqaVo2.setCbqb09("cbqb09");
        cbqaVo2.setCbqa07("cbqa07");
        cbqaVo2.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqa09(0);
        cbqaVo2.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqb10("cbqb10");
        cbqaVo2.setCbqb01(0);
        cbqaVo2.setStartTime("startTime");
        cbqaVo2.setEndTime("endTime");
        cbqaVo2.setCbpm08(0);
        final List<CbqaVo> cbqaVos = Arrays.asList(cbqaVo2);
        when(mockCbqaMapper.SwJsSkuBarcodeselects(new CbqaVo())).thenReturn(cbqaVos);

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.SwJsSkuBarcodeselects(cbqaVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSwJsSkuBarcodeselects_CbqaMapperReturnsNoItems() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        when(mockCbqaMapper.SwJsSkuBarcodeselects(new CbqaVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.SwJsSkuBarcodeselects(cbqaVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByExampleSelective(eq(new Cbqa()), any(CbqaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodebjwc(cbqaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeqxwc() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        // Configure CbqaMapper.selectByPrimaryKey(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        when(mockCbqaMapper.selectByPrimaryKey(0)).thenReturn(cbqa);

        when(mockCbqaMapper.updateByExampleSelective(eq(new Cbqa()), any(CbqaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodeqxwc(cbqaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSwJsPurchaseinboundeditone() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);
        when(mockCbpmMapper.deleteByPrimaryKey(0)).thenReturn(0);
        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

        when(mockCbqbMapper.updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class))).thenReturn(0);

        // Run the test
        swQualityinspectionlistImplUnderTest.SwJsPurchaseinboundeditone(cbqaDo);

        // Verify the results
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
        verify(mockCbplMapper).updateByPrimaryKeySelective(new Cbpl());
        verify(mockCbpmMapper).deleteByPrimaryKey(0);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockCbqbMapper).updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class));
    }

    @Test
    public void testSwJsPurchaseinboundeditone_CbpmMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);
        when(mockCbpmMapper.deleteByPrimaryKey(0)).thenReturn(0);
        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

        when(mockCbqbMapper.updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class))).thenReturn(0);

        // Run the test
        swQualityinspectionlistImplUnderTest.SwJsPurchaseinboundeditone(cbqaDo);

        // Verify the results
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
        verify(mockCbplMapper).updateByPrimaryKeySelective(new Cbpl());
        verify(mockCbpmMapper).deleteByPrimaryKey(0);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockCbqbMapper).updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class));
    }

    @Test
    public void testSwJsPurchaseinboundeditone_CbplMapperSelectByExampleReturnsNull() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(null);
        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);
        when(mockCbpmMapper.deleteByPrimaryKey(0)).thenReturn(0);
        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

        when(mockCbqbMapper.updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class))).thenReturn(0);

        // Run the test
        swQualityinspectionlistImplUnderTest.SwJsPurchaseinboundeditone(cbqaDo);

        // Verify the results
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
        verify(mockCbplMapper).updateByPrimaryKeySelective(new Cbpl());
        verify(mockCbpmMapper).deleteByPrimaryKey(0);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockCbqbMapper).updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class));
    }

    @Test
    public void testSwJsPurchaseinboundeditone_CbplMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);
        when(mockCbpmMapper.deleteByPrimaryKey(0)).thenReturn(0);
        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);

        // Configure CbqbMapper.selectByExample(...).
        final Cbqb cbqb1 = new Cbqb();
        cbqb1.setCbqb01(0);
        cbqb1.setCbqb02(0);
        cbqb1.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb04(0);
        cbqb1.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb1.setCbqb06(0);
        cbqb1.setCbqb07(0);
        cbqb1.setCbqb08(0);
        cbqb1.setCbqb09("cbpm09");
        cbqb1.setCbqb10("cbpm09");
        cbqb1.setCbqa01(0);
        cbqb1.setUserId(0);
        final List<Cbqb> cbqbs = Arrays.asList(cbqb1);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(cbqbs);

        when(mockCbqbMapper.updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class))).thenReturn(0);

        // Run the test
        swQualityinspectionlistImplUnderTest.SwJsPurchaseinboundeditone(cbqaDo);

        // Verify the results
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
        verify(mockCbplMapper).updateByPrimaryKeySelective(new Cbpl());
        verify(mockCbpmMapper).deleteByPrimaryKey(0);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockCbqbMapper).updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class));
    }

    @Test
    public void testSwJsPurchaseinboundeditone_CbqbMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

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
        cbpm.setCbpm12("cbpm09");
        cbpm.setCbpk01(0);
        final List<Cbpm> cbpms = Arrays.asList(cbpm);
        when(mockCbpmMapper.selectByExample(any(CbpmCriteria.class))).thenReturn(cbpms);

        // Configure CbpkMapper.selectByPrimaryKey(...).
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
        cbpk.setCheckStatus((byte) 0b0);
        when(mockCbpkMapper.selectByPrimaryKey(0)).thenReturn(cbpk);

        when(mockCbpmMapper.updateByPrimaryKeySelective(new Cbpm())).thenReturn(0);

        // Configure CbplMapper.selectByExample(...).
        final Cbpl cbpl = new Cbpl();
        cbpl.setCbpl01(0);
        cbpl.setCbpl02(0);
        cbpl.setCbpl03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl04(0);
        cbpl.setCbpl05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpl.setCbpl06(0);
        cbpl.setCbpl07(0);
        cbpl.setCbpl08(0);
        cbpl.setCbpl09(0.0);
        cbpl.setCbpl10(0.0);
        cbpl.setCbpl11(0.0);
        cbpl.setCbpl12(0.0);
        cbpl.setCbpl13("cbpl13");
        cbpl.setCbpl14(0);
        cbpl.setGoodProductQty(0.0);
        final List<Cbpl> cbpls = Arrays.asList(cbpl);
        when(mockCbplMapper.selectByExample(any(CbplCriteria.class))).thenReturn(cbpls);

        when(mockCbplMapper.updateByPrimaryKeySelective(new Cbpl())).thenReturn(0);
        when(mockCbpmMapper.deleteByPrimaryKey(0)).thenReturn(0);
        when(mockCbqaMapper.updateByPrimaryKeySelective(new Cbqa())).thenReturn(0);
        when(mockCbqbMapper.selectByExample(any(CbqbCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbqbMapper.updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class))).thenReturn(0);

        // Run the test
        swQualityinspectionlistImplUnderTest.SwJsPurchaseinboundeditone(cbqaDo);

        // Verify the results
        verify(mockCbpmMapper).updateByPrimaryKeySelective(new Cbpm());
        verify(mockCbplMapper).updateByPrimaryKeySelective(new Cbpl());
        verify(mockCbpmMapper).deleteByPrimaryKey(0);
        verify(mockCbqaMapper).updateByPrimaryKeySelective(new Cbqa());
        verify(mockCbqbMapper).updateByExampleSelective(eq(new Cbqb()), any(CbqbCriteria.class));
    }

    @Test
    public void testSwJsGoodslistsssy() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        final CbqaVo cbqaVo1 = new CbqaVo();
        cbqaVo1.setCbqa01(0);
        cbqaVo1.setCala08("cala08");
        cbqaVo1.setCbpb12("cbpb12");
        cbqaVo1.setCbpb08("cbpb08");
        cbqaVo1.setCbqb08(0);
        cbqaVo1.setCbqb09("cbqb09");
        cbqaVo1.setCbqa07("cbqa07");
        cbqaVo1.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqa09(0);
        cbqaVo1.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo1.setCbqb10("cbqb10");
        cbqaVo1.setCbqb01(0);
        cbqaVo1.setStartTime("startTime");
        cbqaVo1.setEndTime("endTime");
        cbqaVo1.setCbpm08(0);
        final List<CbqaVo> expectedResult = Arrays.asList(cbqaVo1);

        // Configure CbqaMapper.SwJsSkuBarcodeselectss(...).
        final CbqaVo cbqaVo2 = new CbqaVo();
        cbqaVo2.setCbqa01(0);
        cbqaVo2.setCala08("cala08");
        cbqaVo2.setCbpb12("cbpb12");
        cbqaVo2.setCbpb08("cbpb08");
        cbqaVo2.setCbqb08(0);
        cbqaVo2.setCbqb09("cbqb09");
        cbqaVo2.setCbqa07("cbqa07");
        cbqaVo2.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqa09(0);
        cbqaVo2.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo2.setCbqb10("cbqb10");
        cbqaVo2.setCbqb01(0);
        cbqaVo2.setStartTime("startTime");
        cbqaVo2.setEndTime("endTime");
        cbqaVo2.setCbpm08(0);
        final List<CbqaVo> cbqaVos = Arrays.asList(cbqaVo2);
        when(mockCbqaMapper.SwJsSkuBarcodeselectss(new CbqaVo())).thenReturn(cbqaVos);

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.swJsGoodslistsssy(cbqaVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSwJsGoodslistsssy_CbqaMapperReturnsNoItems() {
        // Setup
        final CbqaVo cbqaVo = new CbqaVo();
        cbqaVo.setCbqa01(0);
        cbqaVo.setCala08("cala08");
        cbqaVo.setCbpb12("cbpb12");
        cbqaVo.setCbpb08("cbpb08");
        cbqaVo.setCbqb08(0);
        cbqaVo.setCbqb09("cbqb09");
        cbqaVo.setCbqa07("cbqa07");
        cbqaVo.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqa09(0);
        cbqaVo.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqaVo.setCbqb10("cbqb10");
        cbqaVo.setCbqb01(0);
        cbqaVo.setStartTime("startTime");
        cbqaVo.setEndTime("endTime");
        cbqaVo.setCbpm08(0);

        when(mockCbqaMapper.SwJsSkuBarcodeselectss(new CbqaVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbqaVo> result = swQualityinspectionlistImplUnderTest.swJsGoodslistsssy(cbqaVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesplus() throws Exception {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        when(mockNumberGenerate.getQualityinspectionlistNo()).thenReturn("cbqa07");
        when(mockCbqaMapper.insertSelective(new Cbqa())).thenReturn(0);

        // Configure CbqaMapper.selectByExample(...).
        final Cbqa cbqa = new Cbqa();
        cbqa.setCbqa01(0);
        cbqa.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa03(0);
        cbqa.setCbqa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa05(0);
        cbqa.setCbqa06(0);
        cbqa.setCbqa07("cbqa07");
        cbqa.setCbqa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setCbqa09(0);
        cbqa.setCbqa10(0);
        cbqa.setCbqa11(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqa.setUserId(0);
        final List<Cbqa> cbqas = Arrays.asList(cbqa);
        when(mockCbqaMapper.selectByExample(any(CbqaCriteria.class))).thenReturn(cbqas);

        when(mockCbqbMapper.insertSelective(new Cbqb())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodesplus(cbqaDo);

        // Verify the results
        assertEquals(0,1, result);
      //  verify(mockCbqaMapper).insertSelective(new Cbqa());
      //  verify(mockCbqbMapper).insertSelective(new Cbqb());
    }

    @Test
    public void testInsertSwJsSkuBarcodesplus_CbqaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbqaDo cbqaDo = new CbqaDo();
        cbqaDo.setCbqa01(0);
        cbqaDo.setCbqa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbqb cbqb = new Cbqb();
        cbqb.setCbqb01(0);
        cbqb.setCbqb02(0);
        cbqb.setCbqb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb04(0);
        cbqb.setCbqb05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbqb.setCbqb06(0);
        cbqb.setCbqb07(0);
        cbqb.setCbqb08(0);
        cbqb.setCbqb09("cbpm09");
        cbqb.setCbqb10("cbpm09");
        cbqb.setCbqa01(0);
        cbqb.setUserId(0);
        cbqaDo.setGoods(Arrays.asList(cbqb));

        when(mockNumberGenerate.getQualityinspectionlistNo()).thenReturn("cbqa07");
        when(mockCbqaMapper.insertSelective(new Cbqa())).thenReturn(0);
        when(mockCbqaMapper.selectByExample(any(CbqaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbqbMapper.insertSelective(new Cbqb())).thenReturn(0);

        // Run the test
        final int result = swQualityinspectionlistImplUnderTest.insertSwJsSkuBarcodesplus(cbqaDo);

        // Verify the results
        assertEquals(0,1, result);
    //    verify(mockCbqaMapper).insertSelective(new Cbqa());
    //    verify(mockCbqbMapper).insertSelective(new Cbqb());
    }
}
