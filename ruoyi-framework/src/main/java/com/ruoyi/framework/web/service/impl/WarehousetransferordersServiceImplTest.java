package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.domain.entity.Cbpa;
import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.*;
import com.ruoyi.system.domain.dto.cbaaDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WarehousetransferordersServiceImplTest {

    @Mock
    private CbaaMapper mockCbaaMapper;
    @Mock
    private CbabMapper mockCbabMapper;
    @Mock
    private SqlSessionFactory mockSqlSessionFactory;
    @Mock
    private GsGoodsSkuMapper mockGsGoodsSkuMapper;
    @Mock
    private NumberGenerate mockNumberGenerate;
    @Mock
    private TaskService mockTaskService;
    @Mock
    private CbsaMapper mockCbsaMapper;
    @Mock
    private BaseCheckService mockBaseCheckService;
    @Mock
    private CalaMapper mockCalaMapper;
    @Mock
    private CbacMapper mockCbacMapper;
    @Mock
    private CblaMapper mockCblaMapper;
    @Mock
    private CbwaMapper mockCbwaMapper;
    @Mock
    private CbpbMapper mockCbpbMapper;
    @Mock
    private StringRedisTemplate mockRedisTemplate;
    @Mock
    private GsGoodsSnMapper mockGsGoodsSnMapper;
    @Mock
    private OrderDistributionService mockOrderDistributionService;
    @Mock
    private CbpaMapper mockCbpaMapper;

    @InjectMocks
    private WarehousetransferordersServiceImpl warehousetransferordersServiceImplUnderTest;

    @Test
    public void testInsertSwJsStore() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

        // Run the test
        final IdVo result = warehousetransferordersServiceImplUnderTest.insertSwJsStore(cbaaDo);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockCbaaMapper).insertSelective(new Cbaa());
    }

    @Test
    public void testInsertSwJsStore_CbaaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final IdVo result = warehousetransferordersServiceImplUnderTest.insertSwJsStore(cbaaDo);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockCbaaMapper).insertSelective(new Cbaa());
    }

    @Test
    public void testInsertSwJsStores() throws Exception {
        // Setup
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> itemList = Arrays.asList(cbab);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
    }

    @Test
    public void testSelectSwJsTaskGoodsRelList() throws Exception {
        // Setup
        final CbaaVo cbaaVo = new CbaaVo();
        cbaaVo.setCbaa01(0);
        cbaaVo.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa03(0);
        cbaaVo.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa05(0);
        cbaaVo.setCbaa06(0);
        cbaaVo.setCbaa07("cbaa07");
        cbaaVo.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa09(0);
        cbaaVo.setCbaa10(0);
        cbaaVo.setCbaa11(0);
        cbaaVo.setCbaa12(0);
        cbaaVo.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa14(0);
        cbaaVo.setCbaa15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        final CbaaVo cbaaVo1 = new CbaaVo();
        cbaaVo1.setCbaa01(0);
        cbaaVo1.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo1.setCbaa03(0);
        cbaaVo1.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo1.setCbaa05(0);
        cbaaVo1.setCbaa06(0);
        cbaaVo1.setCbaa07("cbaa07");
        cbaaVo1.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo1.setCbaa09(0);
        cbaaVo1.setCbaa10(0);
        cbaaVo1.setCbaa11(0);
        cbaaVo1.setCbaa12(0);
        cbaaVo1.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo1.setCbaa14(0);
        cbaaVo1.setCbaa15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<CbaaVo> expectedResult = Arrays.asList(cbaaVo1);

        // Configure CbaaMapper.selectSwJsTaskGoodsRelList(...).
        final CbaaVo cbaaVo2 = new CbaaVo();
        cbaaVo2.setCbaa01(0);
        cbaaVo2.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo2.setCbaa03(0);
        cbaaVo2.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo2.setCbaa05(0);
        cbaaVo2.setCbaa06(0);
        cbaaVo2.setCbaa07("cbaa07");
        cbaaVo2.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo2.setCbaa09(0);
        cbaaVo2.setCbaa10(0);
        cbaaVo2.setCbaa11(0);
        cbaaVo2.setCbaa12(0);
        cbaaVo2.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo2.setCbaa14(0);
        cbaaVo2.setCbaa15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<CbaaVo> cbaaVos = Arrays.asList(cbaaVo2);
        when(mockCbaaMapper.selectSwJsTaskGoodsRelList(new CbaaVo())).thenReturn(cbaaVos);

        // Run the test
        final List<CbaaVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelList(cbaaVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelList_CbaaMapperReturnsNoItems() {
        // Setup
        final CbaaVo cbaaVo = new CbaaVo();
        cbaaVo.setCbaa01(0);
        cbaaVo.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa03(0);
        cbaaVo.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa05(0);
        cbaaVo.setCbaa06(0);
        cbaaVo.setCbaa07("cbaa07");
        cbaaVo.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa09(0);
        cbaaVo.setCbaa10(0);
        cbaaVo.setCbaa11(0);
        cbaaVo.setCbaa12(0);
        cbaaVo.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa14(0);
        cbaaVo.setCbaa15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        when(mockCbaaMapper.selectSwJsTaskGoodsRelList(new CbaaVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbaaVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelList(cbaaVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists() throws Exception {
        // Setup
        final CbaaVo cbaaVo = new CbaaVo();
        cbaaVo.setCbaa01(0);
        cbaaVo.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa03(0);
        cbaaVo.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa05(0);
        cbaaVo.setCbaa06(0);
        cbaaVo.setCbaa07("cbaa07");
        cbaaVo.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa09(0);
        cbaaVo.setCbaa10(0);
        cbaaVo.setCbaa11(0);
        cbaaVo.setCbaa12(0);
        cbaaVo.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa14(0);
        cbaaVo.setCbaa15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        final CbaaVo cbaaVo1 = new CbaaVo();
        cbaaVo1.setCbaa01(0);
        cbaaVo1.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo1.setCbaa03(0);
        cbaaVo1.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo1.setCbaa05(0);
        cbaaVo1.setCbaa06(0);
        cbaaVo1.setCbaa07("cbaa07");
        cbaaVo1.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo1.setCbaa09(0);
        cbaaVo1.setCbaa10(0);
        cbaaVo1.setCbaa11(0);
        cbaaVo1.setCbaa12(0);
        cbaaVo1.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo1.setCbaa14(0);
        cbaaVo1.setCbaa15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<CbaaVo> expectedResult = Arrays.asList(cbaaVo1);

        // Configure CbaaMapper.selectSwJsTaskGoodsRelLists(...).
        final CbaaVo cbaaVo2 = new CbaaVo();
        cbaaVo2.setCbaa01(0);
        cbaaVo2.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo2.setCbaa03(0);
        cbaaVo2.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo2.setCbaa05(0);
        cbaaVo2.setCbaa06(0);
        cbaaVo2.setCbaa07("cbaa07");
        cbaaVo2.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo2.setCbaa09(0);
        cbaaVo2.setCbaa10(0);
        cbaaVo2.setCbaa11(0);
        cbaaVo2.setCbaa12(0);
        cbaaVo2.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo2.setCbaa14(0);
        cbaaVo2.setCbaa15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<CbaaVo> cbaaVos = Arrays.asList(cbaaVo2);
        when(mockCbaaMapper.selectSwJsTaskGoodsRelLists(new CbaaVo())).thenReturn(cbaaVos);

        // Run the test
        final List<CbaaVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbaaVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists_CbaaMapperReturnsNoItems() {
        // Setup
        final CbaaVo cbaaVo = new CbaaVo();
        cbaaVo.setCbaa01(0);
        cbaaVo.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa03(0);
        cbaaVo.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa05(0);
        cbaaVo.setCbaa06(0);
        cbaaVo.setCbaa07("cbaa07");
        cbaaVo.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa09(0);
        cbaaVo.setCbaa10(0);
        cbaaVo.setCbaa11(0);
        cbaaVo.setCbaa12(0);
        cbaaVo.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaVo.setCbaa14(0);
        cbaaVo.setCbaa15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        when(mockCbaaMapper.selectSwJsTaskGoodsRelLists(new CbaaVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbaaVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbaaVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesh() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodesh(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodesh_CbaaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodesh(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodefs() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodefs(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodefs_CbaaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodefs(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodefs_CbacMapperReturnsNoItems() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodefs(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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

        // Configure TaskService.addGsGoodsSku(...).
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
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbaaMapperSelectByPrimaryKeyReturnsNull() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class,
                () -> warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbaaDo));
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbabMapperReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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

        // Configure TaskService.addGsGoodsSku(...).
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
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_CbacMapperReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Collections.emptyList());
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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

        // Configure TaskService.addGsGoodsSku(...).
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
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_TaskServiceCheckGsGoodsSkuReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
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

        // Configure TaskService.addGsGoodsSku(...).
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
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku2);

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).InsertCBIB(new CbibDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodebjwc_TaskServiceInsertCBIBThrowsInterruptedException() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);

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

        // Configure TaskService.addGsGoodsSku(...).
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
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku3);

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
                () -> warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodebjwc(cbaaDo));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testInsertSwJsSkuBarcodeqxwc() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodeqxwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeqxwc_CbaaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodeqxwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeupdate() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodeupdate(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testInsertSwJsSkuBarcodeupdate_CbaaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsSkuBarcodeupdate(cbaaDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss() throws Exception {
        // Setup
        final CbaasVo cbaasVo = new CbaasVo();
        cbaasVo.setPinpai("pinpai");
        cbaasVo.setCbaa01(0);
        cbaasVo.setCbab15(0);
        cbaasVo.setCbab08(0);
        cbaasVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbac09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo.setGoods(Arrays.asList(scanVo));
        cbaasVo.setOrderClass("国内订单");

        final CbaasVo cbaasVo1 = new CbaasVo();
        cbaasVo1.setPinpai("pinpai");
        cbaasVo1.setCbaa01(0);
        cbaasVo1.setCbab15(0);
        cbaasVo1.setCbab08(0);
        cbaasVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbac09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo1.setGoods(Arrays.asList(scanVo1));
        cbaasVo1.setOrderClass("国内订单");
        final List<CbaasVo> expectedResult = Arrays.asList(cbaasVo1);

        // Configure CbaaMapper.selectSwJsTaskGoodsRelListss(...).
        final CbaasVo cbaasVo2 = new CbaasVo();
        cbaasVo2.setPinpai("pinpai");
        cbaasVo2.setCbaa01(0);
        cbaasVo2.setCbab15(0);
        cbaasVo2.setCbab08(0);
        cbaasVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("cala08");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbac09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo2.setGoods(Arrays.asList(scanVo2));
        cbaasVo2.setOrderClass("国内订单");
        final List<CbaasVo> cbaasVos = Arrays.asList(cbaasVo2);
        when(mockCbaaMapper.selectSwJsTaskGoodsRelListss(new CbaasVo())).thenReturn(cbaasVos);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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
        final List<CbaasVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbaasVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbaaMapperReturnsNoItems() {
        // Setup
        final CbaasVo cbaasVo = new CbaasVo();
        cbaasVo.setPinpai("pinpai");
        cbaasVo.setCbaa01(0);
        cbaasVo.setCbab15(0);
        cbaasVo.setCbab08(0);
        cbaasVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbac09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo.setGoods(Arrays.asList(scanVo));
        cbaasVo.setOrderClass("国内订单");

        when(mockCbaaMapper.selectSwJsTaskGoodsRelListss(new CbaasVo())).thenReturn(Collections.emptyList());
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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
        final List<CbaasVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbaasVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbacMapperReturnsNoItems() {
        // Setup
        final CbaasVo cbaasVo = new CbaasVo();
        cbaasVo.setPinpai("pinpai");
        cbaasVo.setCbaa01(0);
        cbaasVo.setCbab15(0);
        cbaasVo.setCbab08(0);
        cbaasVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbac09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo.setGoods(Arrays.asList(scanVo));
        cbaasVo.setOrderClass("国内订单");

        // Configure CbaaMapper.selectSwJsTaskGoodsRelListss(...).
        final CbaasVo cbaasVo1 = new CbaasVo();
        cbaasVo1.setPinpai("pinpai");
        cbaasVo1.setCbaa01(0);
        cbaasVo1.setCbab15(0);
        cbaasVo1.setCbab08(0);
        cbaasVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbac09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo1.setGoods(Arrays.asList(scanVo1));
        cbaasVo1.setOrderClass("国内订单");
        final List<CbaasVo> cbaasVos = Arrays.asList(cbaasVo1);
        when(mockCbaaMapper.selectSwJsTaskGoodsRelListss(new CbaasVo())).thenReturn(cbaasVos);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Collections.emptyList());

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
        final List<CbaasVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbaasVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbpbMapperReturnsNull() {
        // Setup
        final CbaasVo cbaasVo = new CbaasVo();
        cbaasVo.setPinpai("pinpai");
        cbaasVo.setCbaa01(0);
        cbaasVo.setCbab15(0);
        cbaasVo.setCbab08(0);
        cbaasVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbac09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo.setGoods(Arrays.asList(scanVo));
        cbaasVo.setOrderClass("国内订单");

        final CbaasVo cbaasVo1 = new CbaasVo();
        cbaasVo1.setPinpai("pinpai");
        cbaasVo1.setCbaa01(0);
        cbaasVo1.setCbab15(0);
        cbaasVo1.setCbab08(0);
        cbaasVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbac09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo1.setGoods(Arrays.asList(scanVo1));
        cbaasVo1.setOrderClass("国内订单");
        final List<CbaasVo> expectedResult = Arrays.asList(cbaasVo1);

        // Configure CbaaMapper.selectSwJsTaskGoodsRelListss(...).
        final CbaasVo cbaasVo2 = new CbaasVo();
        cbaasVo2.setPinpai("pinpai");
        cbaasVo2.setCbaa01(0);
        cbaasVo2.setCbab15(0);
        cbaasVo2.setCbab08(0);
        cbaasVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("cala08");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbac09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo2.setGoods(Arrays.asList(scanVo2));
        cbaasVo2.setOrderClass("国内订单");
        final List<CbaasVo> cbaasVos = Arrays.asList(cbaasVo2);
        when(mockCbaaMapper.selectSwJsTaskGoodsRelListss(new CbaasVo())).thenReturn(cbaasVos);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(null);

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
        final List<CbaasVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbaasVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CalaMapperReturnsNull() {
        // Setup
        final CbaasVo cbaasVo = new CbaasVo();
        cbaasVo.setPinpai("pinpai");
        cbaasVo.setCbaa01(0);
        cbaasVo.setCbab15(0);
        cbaasVo.setCbab08(0);
        cbaasVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbac09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo.setGoods(Arrays.asList(scanVo));
        cbaasVo.setOrderClass("国内订单");

        final CbaasVo cbaasVo1 = new CbaasVo();
        cbaasVo1.setPinpai("pinpai");
        cbaasVo1.setCbaa01(0);
        cbaasVo1.setCbab15(0);
        cbaasVo1.setCbab08(0);
        cbaasVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbac09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo1.setGoods(Arrays.asList(scanVo1));
        cbaasVo1.setOrderClass("国内订单");
        final List<CbaasVo> expectedResult = Arrays.asList(cbaasVo1);

        // Configure CbaaMapper.selectSwJsTaskGoodsRelListss(...).
        final CbaasVo cbaasVo2 = new CbaasVo();
        cbaasVo2.setPinpai("pinpai");
        cbaasVo2.setCbaa01(0);
        cbaasVo2.setCbab15(0);
        cbaasVo2.setCbab08(0);
        cbaasVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("cala08");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbac09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo2.setGoods(Arrays.asList(scanVo2));
        cbaasVo2.setOrderClass("国内订单");
        final List<CbaasVo> cbaasVos = Arrays.asList(cbaasVo2);
        when(mockCbaaMapper.selectSwJsTaskGoodsRelListss(new CbaasVo())).thenReturn(cbaasVos);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCalaMapper.selectByPrimaryKey(0)).thenReturn(null);

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
        final List<CbaasVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbaasVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbpaMapperReturnsNull() {
        // Setup
        final CbaasVo cbaasVo = new CbaasVo();
        cbaasVo.setPinpai("pinpai");
        cbaasVo.setCbaa01(0);
        cbaasVo.setCbab15(0);
        cbaasVo.setCbab08(0);
        cbaasVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbac09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo.setGoods(Arrays.asList(scanVo));
        cbaasVo.setOrderClass("国内订单");

        final CbaasVo cbaasVo1 = new CbaasVo();
        cbaasVo1.setPinpai("pinpai");
        cbaasVo1.setCbaa01(0);
        cbaasVo1.setCbab15(0);
        cbaasVo1.setCbab08(0);
        cbaasVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbac09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo1.setGoods(Arrays.asList(scanVo1));
        cbaasVo1.setOrderClass("国内订单");
        final List<CbaasVo> expectedResult = Arrays.asList(cbaasVo1);

        // Configure CbaaMapper.selectSwJsTaskGoodsRelListss(...).
        final CbaasVo cbaasVo2 = new CbaasVo();
        cbaasVo2.setPinpai("pinpai");
        cbaasVo2.setCbaa01(0);
        cbaasVo2.setCbab15(0);
        cbaasVo2.setCbab08(0);
        cbaasVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("cala08");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbac09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo2.setGoods(Arrays.asList(scanVo2));
        cbaasVo2.setOrderClass("国内订单");
        final List<CbaasVo> cbaasVos = Arrays.asList(cbaasVo2);
        when(mockCbaaMapper.selectSwJsTaskGoodsRelListss(new CbaasVo())).thenReturn(cbaasVos);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbpaMapper.selectByPrimaryKey(0)).thenReturn(null);

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
        final List<CbaasVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbaasVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CblaMapperReturnsNull() throws Exception {
        // Setup
        final CbaasVo cbaasVo = new CbaasVo();
        cbaasVo.setPinpai("pinpai");
        cbaasVo.setCbaa01(0);
        cbaasVo.setCbab15(0);
        cbaasVo.setCbab08(0);
        cbaasVo.setSaoma(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa08");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbac09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo.setGoods(Arrays.asList(scanVo));
        cbaasVo.setOrderClass("国内订单");

        final CbaasVo cbaasVo1 = new CbaasVo();
        cbaasVo1.setPinpai("pinpai");
        cbaasVo1.setCbaa01(0);
        cbaasVo1.setCbab15(0);
        cbaasVo1.setCbab08(0);
        cbaasVo1.setSaoma(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa08");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbac09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo1.setGoods(Arrays.asList(scanVo1));
        cbaasVo1.setOrderClass("国内订单");
        final List<CbaasVo> expectedResult = Arrays.asList(cbaasVo1);

        // Configure CbaaMapper.selectSwJsTaskGoodsRelListss(...).
        final CbaasVo cbaasVo2 = new CbaasVo();
        cbaasVo2.setPinpai("pinpai");
        cbaasVo2.setCbaa01(0);
        cbaasVo2.setCbab15(0);
        cbaasVo2.setCbab08(0);
        cbaasVo2.setSaoma(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa08");
        scanVo2.setPinpai("cala08");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbac09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaasVo2.setGoods(Arrays.asList(scanVo2));
        cbaasVo2.setOrderClass("国内订单");
        final List<CbaasVo> cbaasVos = Arrays.asList(cbaasVo2);
        when(mockCbaaMapper.selectSwJsTaskGoodsRelListss(new CbaasVo())).thenReturn(cbaasVos);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        final List<CbaasVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbaasVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testInsertSwJsStoress() throws Exception {
        // Setup
        final List<Cbac> itemList = Arrays.asList(Cbac.getInstance());

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

        // Configure BaseCheckService.checkGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("cbac09");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        gsGoodsSn1.setPrice(0.0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsStoress_CbabMapperReturnsNoItems() {
        // Setup
        final List<Cbac> itemList = Arrays.asList(Cbac.getInstance());

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

        // Configure BaseCheckService.checkGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("cbac09");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        gsGoodsSn1.setPrice(0.0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsStoress_GsGoodsSkuMapperReturnsNoItems() {
        // Setup
        final List<Cbac> itemList = Arrays.asList(Cbac.getInstance());

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(Collections.emptyList());

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

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

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

        // Configure BaseCheckService.checkGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("cbac09");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        gsGoodsSn1.setPrice(0.0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testInsertSwJsStoress_CblaMapperReturnsNull() throws Exception {
        // Setup
        final List<Cbac> itemList = Arrays.asList(Cbac.getInstance());

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> warehousetransferordersServiceImplUnderTest.insertSwJsStoress(itemList));
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStoress_CbacMapperReturnsNoItems() {
        // Setup
        final List<Cbac> itemList = Arrays.asList(Cbac.getInstance());

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Collections.emptyList());

        // Configure BaseCheckService.checkGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        when(mockBaseCheckService.checkGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn);

        // Configure TaskService.updateGsGoodsSn(...).
        final GsGoodsSn gsGoodsSn1 = new GsGoodsSn();
        gsGoodsSn1.setId(0);
        gsGoodsSn1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setCreateBy(0);
        gsGoodsSn1.setUpdateBy(0);
        gsGoodsSn1.setDeleteFlag((byte) 0b0);
        gsGoodsSn1.setSn("cbac09");
        gsGoodsSn1.setGoodsId(0);
        gsGoodsSn1.setLocationId(0);
        gsGoodsSn1.setStatus((byte) 0b0);
        gsGoodsSn1.setWhId(0);
        gsGoodsSn1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn1.setGroudStatus((byte) 0b0);
        gsGoodsSn1.setPrice(0.0);
        when(mockTaskService.updateGsGoodsSn(new GsGoodsSnDo())).thenReturn(gsGoodsSn1);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsStoress(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockBaseCheckService).checkGsGoodsSn(new GsGoodsSnDo());
        verify(mockTaskService).updateGsGoodsSn(new GsGoodsSnDo());
    }

    @Test
    public void testWarehousetransferorderseditone() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbabMapper.deleteByExample(any(CbabCriteria.class))).thenReturn(0);
        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        warehousetransferordersServiceImplUnderTest.Warehousetransferorderseditone(cbaaDo);

        // Verify the results
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockCbabMapper).insertSelective(new Cbab());
    }

    @Test
    public void testSelloutofwarehousedel() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.Selloutofwarehousedel(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
    }

    @Test
    public void testSelloutofwarehousedel_CbaaMapperSelectByPrimaryKeyReturnsNull() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class,
                () -> warehousetransferordersServiceImplUnderTest.Selloutofwarehousedel(cbaaDo));
    }

    @Test
    public void testTransferordersout() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

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

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersout(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
    }

    @Test
    public void testTransferordersout_CbaaMapperReturnsNull() {
        // Setup
        final Cbac itemList = Cbac.getInstance();
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> warehousetransferordersServiceImplUnderTest.transferordersout(itemList));
    }

    @Test
    public void testTransferordersout_GsGoodsSnMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersout(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
    }

    @Test
    public void testTransferordersout_CbabMapperReturnsNoItems() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

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

        when(mockRedisTemplate.opsForValue()).thenReturn(null);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersout(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
    }

    @Test
    public void testTransferordersout_CbacMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

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

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersout(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
    }

    @Test
    public void testTransferordersin() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

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

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb1 = new Cbpb();
        cbpb1.setCbpb01(0);
        cbpb1.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb04(0);
        cbpb1.setCbpb05(0);
        cbpb1.setCbpb06((byte) 0b0);
        cbpb1.setCbpb07("cbpb07");
        cbpb1.setCbpb08("cbpb08");
        cbpb1.setCbpb09("cbpb09");
        cbpb1.setCbpb10(0);
        cbpb1.setCbpb11(0);
        cbpb1.setCbpb12("cbpb12");
        cbpb1.setCbpb13(0.0);
        cbpb1.setCbpb14(0);
        cbpb1.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb1);

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbacMapper.updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class))).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersin(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbacMapper).updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class));
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
    }

    @Test
    public void testTransferordersin_CbpbMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbac itemList = Cbac.getInstance();
        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(Collections.emptyList());

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

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

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbacMapper.updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class))).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersin(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbacMapper).updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class));
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
    }

    @Test
    public void testTransferordersin_GsGoodsSnMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

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

        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb1 = new Cbpb();
        cbpb1.setCbpb01(0);
        cbpb1.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb04(0);
        cbpb1.setCbpb05(0);
        cbpb1.setCbpb06((byte) 0b0);
        cbpb1.setCbpb07("cbpb07");
        cbpb1.setCbpb08("cbpb08");
        cbpb1.setCbpb09("cbpb09");
        cbpb1.setCbpb10(0);
        cbpb1.setCbpb11(0);
        cbpb1.setCbpb12("cbpb12");
        cbpb1.setCbpb13(0.0);
        cbpb1.setCbpb14(0);
        cbpb1.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb1);

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbacMapper.updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class))).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersin(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbacMapper).updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class));
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
    }

    @Test
    public void testTransferordersin_CbabMapperReturnsNoItems() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

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

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb1 = new Cbpb();
        cbpb1.setCbpb01(0);
        cbpb1.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb04(0);
        cbpb1.setCbpb05(0);
        cbpb1.setCbpb06((byte) 0b0);
        cbpb1.setCbpb07("cbpb07");
        cbpb1.setCbpb08("cbpb08");
        cbpb1.setCbpb09("cbpb09");
        cbpb1.setCbpb10(0);
        cbpb1.setCbpb11(0);
        cbpb1.setCbpb12("cbpb12");
        cbpb1.setCbpb13(0.0);
        cbpb1.setCbpb14(0);
        cbpb1.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb1);

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbacMapper.updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class))).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersin(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbacMapper).updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class));
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
    }

    @Test
    public void testTransferordersin_CbwaMapperReturnsNoItems() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

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

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb1 = new Cbpb();
        cbpb1.setCbpb01(0);
        cbpb1.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb04(0);
        cbpb1.setCbpb05(0);
        cbpb1.setCbpb06((byte) 0b0);
        cbpb1.setCbpb07("cbpb07");
        cbpb1.setCbpb08("cbpb08");
        cbpb1.setCbpb09("cbpb09");
        cbpb1.setCbpb10(0);
        cbpb1.setCbpb11(0);
        cbpb1.setCbpb12("cbpb12");
        cbpb1.setCbpb13(0.0);
        cbpb1.setCbpb14(0);
        cbpb1.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb1);

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbacMapper.updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class))).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersin(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbacMapper).updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class));
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
    }

    @Test
    public void testTransferordersin_CblaMapperReturnsNull() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

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

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb1 = new Cbpb();
        cbpb1.setCbpb01(0);
        cbpb1.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb04(0);
        cbpb1.setCbpb05(0);
        cbpb1.setCbpb06((byte) 0b0);
        cbpb1.setCbpb07("cbpb07");
        cbpb1.setCbpb08("cbpb08");
        cbpb1.setCbpb09("cbpb09");
        cbpb1.setCbpb10(0);
        cbpb1.setCbpb11(0);
        cbpb1.setCbpb12("cbpb12");
        cbpb1.setCbpb13(0.0);
        cbpb1.setCbpb14(0);
        cbpb1.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb1);

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbacMapper.updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class))).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersin(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbacMapper).updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class));
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
    }

    @Test
    public void testTransferordersin_CbacMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbac itemList = Cbac.getInstance();

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

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbac09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        // Configure CbpbMapper.selectByPrimaryKey(...).
        final Cbpb cbpb1 = new Cbpb();
        cbpb1.setCbpb01(0);
        cbpb1.setCbpb02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpb1.setCbpb04(0);
        cbpb1.setCbpb05(0);
        cbpb1.setCbpb06((byte) 0b0);
        cbpb1.setCbpb07("cbpb07");
        cbpb1.setCbpb08("cbpb08");
        cbpb1.setCbpb09("cbpb09");
        cbpb1.setCbpb10(0);
        cbpb1.setCbpb11(0);
        cbpb1.setCbpb12("cbpb12");
        cbpb1.setCbpb13(0.0);
        cbpb1.setCbpb14(0);
        cbpb1.setCbpb15("cbpb15");
        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(cbpb1);

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbacMapper.updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class))).thenReturn(0);
        when(mockCbacMapper.insertSelective(Cbac.getInstance())).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByPrimaryKeySelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersin(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockCbacMapper).updateByExampleSelective(eq(Cbac.getInstance()), any(CbacCriteria.class));
        verify(mockCbacMapper).insertSelective(Cbac.getInstance());
        verify(mockGsGoodsSnMapper).updateByPrimaryKeySelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
    }

    @Test
    public void testTransferordersoutbjwc() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
    }

    @Test
    public void testTransferordersoutbjwc_CbaaMapperSelectByPrimaryKeyReturnsNull() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class,
                () -> warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo));
    }

    @Test
    public void testTransferordersoutbjwc_CbaaMapperSelectbytypeReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Collections.emptyList());

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
    }

    @Test
    public void testTransferordersoutbjwc_CbwaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
    }

    @Test
    public void testTransferordersoutbjwc_CbabMapperReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
    }

    @Test
    public void testTransferordersoutbjwc_GsGoodsSkuMapperSelectByGoodsIdAndWhIdReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
    }

    @Test
    public void testTransferordersoutbjwc_TaskServiceInsertCBIBThrowsInterruptedException() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        when(mockTaskService.InsertCBIB(new CbibDo())).thenThrow(InterruptedException.class);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo));
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
    }

    @Test
    public void testTransferordersoutbjwc_CbacMapperReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
    }

    @Test
    public void testTransferordersoutbjwc_TaskServiceCheckGsGoodsSkuReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(Collections.emptyList());

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersoutbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
    }

    @Test
    public void testTransferordersinbjwc() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);

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

        // Configure TaskService.addGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku5 = new GsGoodsSku();
        gsGoodsSku5.setId(0);
        gsGoodsSku5.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setCreateBy(0);
        gsGoodsSku5.setUpdateBy(0);
        gsGoodsSku5.setDeleteFlag((byte) 0b0);
        gsGoodsSku5.setGoodsId(0);
        gsGoodsSku5.setWhId(0);
        gsGoodsSku5.setQty(0.0);
        gsGoodsSku5.setLocationId(0);
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku5);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testTransferordersinbjwc_CbaaMapperSelectByPrimaryKeyReturnsNull() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo));
    }

    @Test
    public void testTransferordersinbjwc_CbaaMapperSelectbytypeReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Collections.emptyList());

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);

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

        // Configure TaskService.addGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku5 = new GsGoodsSku();
        gsGoodsSku5.setId(0);
        gsGoodsSku5.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setCreateBy(0);
        gsGoodsSku5.setUpdateBy(0);
        gsGoodsSku5.setDeleteFlag((byte) 0b0);
        gsGoodsSku5.setGoodsId(0);
        gsGoodsSku5.setWhId(0);
        gsGoodsSku5.setQty(0.0);
        gsGoodsSku5.setLocationId(0);
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku5);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testTransferordersinbjwc_CbwaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);

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

        // Configure TaskService.addGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku5 = new GsGoodsSku();
        gsGoodsSku5.setId(0);
        gsGoodsSku5.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setCreateBy(0);
        gsGoodsSku5.setUpdateBy(0);
        gsGoodsSku5.setDeleteFlag((byte) 0b0);
        gsGoodsSku5.setGoodsId(0);
        gsGoodsSku5.setWhId(0);
        gsGoodsSku5.setQty(0.0);
        gsGoodsSku5.setLocationId(0);
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku5);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testTransferordersinbjwc_CbabMapperReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);

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

        // Configure TaskService.addGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku5 = new GsGoodsSku();
        gsGoodsSku5.setId(0);
        gsGoodsSku5.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setCreateBy(0);
        gsGoodsSku5.setUpdateBy(0);
        gsGoodsSku5.setDeleteFlag((byte) 0b0);
        gsGoodsSku5.setGoodsId(0);
        gsGoodsSku5.setWhId(0);
        gsGoodsSku5.setQty(0.0);
        gsGoodsSku5.setLocationId(0);
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku5);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testTransferordersinbjwc_GsGoodsSkuMapperSelectByGoodsIdAndWhIdReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);

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

        // Configure TaskService.addGsGoodsSku(...).
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
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku4);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testTransferordersinbjwc_TaskServiceInsertCBIBThrowsInterruptedException() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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
        when(mockCbsaMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        when(mockTaskService.InsertCBIB(new CbibDo())).thenThrow(InterruptedException.class);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo));
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
    }

    @Test
    public void testTransferordersinbjwc_CbacMapperReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);

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

        // Configure TaskService.addGsGoodsSku(...).
        final GsGoodsSku gsGoodsSku5 = new GsGoodsSku();
        gsGoodsSku5.setId(0);
        gsGoodsSku5.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSku5.setCreateBy(0);
        gsGoodsSku5.setUpdateBy(0);
        gsGoodsSku5.setDeleteFlag((byte) 0b0);
        gsGoodsSku5.setGoodsId(0);
        gsGoodsSku5.setWhId(0);
        gsGoodsSku5.setQty(0.0);
        gsGoodsSku5.setLocationId(0);
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku5);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testTransferordersinbjwc_TaskServiceCheckGsGoodsSkuReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));
        when(mockTaskService.checkGsGoodsSku(new GsGoodsSkuDo())).thenReturn(Collections.emptyList());

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);

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

        // Configure TaskService.addGsGoodsSku(...).
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
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku4);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testTransferordersinbjwc_CblaMapperReturnsNull() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);
        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo));
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
    }

    @Test
    public void testTransferordersinbjwc_GsGoodsSkuMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        // Configure CbaaMapper.selectByPrimaryKey(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        when(mockCbaaMapper.selectByPrimaryKey(0)).thenReturn(cbaa);

        when(mockCbaaMapper.selectbytype(0)).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab1 = new Cbab();
        cbab1.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab04(0);
        cbab1.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab1.setCbab06(0);
        cbab1.setCbab07(0);
        cbab1.setCbab08(0);
        cbab1.setCbab09(0.0);
        cbab1.setCbab10(0.0);
        cbab1.setCbab11(0.0);
        cbab1.setCbab12(0.0);
        cbab1.setCbab13("cbab13");
        cbab1.setCbaa01(0);
        cbab1.setCbab14(0);
        cbab1.setCbab15(0);
        cbab1.setCbab16(0);
        cbab1.setCbab17(0);
        cbab1.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab1);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

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

        when(mockCbaaMapper.updateByPrimaryKeySelective(new Cbaa())).thenReturn(0);
        when(mockCbacMapper.selectByExample(any(CbacCriteria.class))).thenReturn(Arrays.asList(Cbac.getInstance()));

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

        when(mockCbaaMapper.updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSkuMapper.insertSelective(new GsGoodsSku())).thenReturn(0);
        when(mockOrderDistributionService.diaoboUseOp(new TranUseQtyDo())).thenReturn(false);

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

        // Configure TaskService.addGsGoodsSku(...).
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
        when(mockTaskService.addGsGoodsSku(new GsGoodsSkuDo())).thenReturn(gsGoodsSku4);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.transferordersinbjwc(cbaaDo);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbaaMapper).updateByPrimaryKeySelective(new Cbaa());
        verify(mockTaskService).updateGsGoodsSku(new GsGoodsSkuDo());
        verify(mockCbaaMapper).updateByExampleSelective(eq(new Cbaa()), any(CbaaCriteria.class));
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockOrderDistributionService).diaoboUseOp(new TranUseQtyDo());
        verify(mockTaskService).addGsGoodsSku(new GsGoodsSkuDo());
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListsss() throws Exception {
        // Setup
        final CbacVo cbacVo = new CbacVo();
        cbacVo.setCbac01(0);
        cbacVo.setCbac02(0);
        cbacVo.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac04(0);
        cbacVo.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac06(0);
        cbacVo.setCbac07(0);
        cbacVo.setCbac08(0);
        cbacVo.setCbac09("cbac09");
        cbacVo.setCbac10(0);
        cbacVo.setCbac11(0);
        cbacVo.setCbac12("cbac12");
        cbacVo.setCbaa01(0);
        cbacVo.setSaoma(0);
        cbacVo.setNums(0.0);

        final CbacVo cbacVo1 = new CbacVo();
        cbacVo1.setCbac01(0);
        cbacVo1.setCbac02(0);
        cbacVo1.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo1.setCbac04(0);
        cbacVo1.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo1.setCbac06(0);
        cbacVo1.setCbac07(0);
        cbacVo1.setCbac08(0);
        cbacVo1.setCbac09("cbac09");
        cbacVo1.setCbac10(0);
        cbacVo1.setCbac11(0);
        cbacVo1.setCbac12("cbac12");
        cbacVo1.setCbaa01(0);
        cbacVo1.setSaoma(0);
        cbacVo1.setNums(0.0);
        final List<CbacVo> expectedResult = Arrays.asList(cbacVo1);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        // Configure CbacMapper.selectSwJsTaskGoodsRelListsss(...).
        final CbacVo cbacVo2 = new CbacVo();
        cbacVo2.setCbac01(0);
        cbacVo2.setCbac02(0);
        cbacVo2.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo2.setCbac04(0);
        cbacVo2.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo2.setCbac06(0);
        cbacVo2.setCbac07(0);
        cbacVo2.setCbac08(0);
        cbacVo2.setCbac09("cbac09");
        cbacVo2.setCbac10(0);
        cbacVo2.setCbac11(0);
        cbacVo2.setCbac12("cbac12");
        cbacVo2.setCbaa01(0);
        cbacVo2.setSaoma(0);
        cbacVo2.setNums(0.0);
        final List<CbacVo> cbacVos = Arrays.asList(cbacVo2);
        when(mockCbacMapper.selectSwJsTaskGoodsRelListsss(new CbacVo())).thenReturn(cbacVos);

        // Run the test
        final List<CbacVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListsss(cbacVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListsss_CbabMapperReturnsNoItems() {
        // Setup
        final CbacVo cbacVo = new CbacVo();
        cbacVo.setCbac01(0);
        cbacVo.setCbac02(0);
        cbacVo.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac04(0);
        cbacVo.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac06(0);
        cbacVo.setCbac07(0);
        cbacVo.setCbac08(0);
        cbacVo.setCbac09("cbac09");
        cbacVo.setCbac10(0);
        cbacVo.setCbac11(0);
        cbacVo.setCbac12("cbac12");
        cbacVo.setCbaa01(0);
        cbacVo.setSaoma(0);
        cbacVo.setNums(0.0);

        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbacMapper.selectSwJsTaskGoodsRelListsss(...).
        final CbacVo cbacVo1 = new CbacVo();
        cbacVo1.setCbac01(0);
        cbacVo1.setCbac02(0);
        cbacVo1.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo1.setCbac04(0);
        cbacVo1.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo1.setCbac06(0);
        cbacVo1.setCbac07(0);
        cbacVo1.setCbac08(0);
        cbacVo1.setCbac09("cbac09");
        cbacVo1.setCbac10(0);
        cbacVo1.setCbac11(0);
        cbacVo1.setCbac12("cbac12");
        cbacVo1.setCbaa01(0);
        cbacVo1.setSaoma(0);
        cbacVo1.setNums(0.0);
        final List<CbacVo> cbacVos = Arrays.asList(cbacVo1);
        when(mockCbacMapper.selectSwJsTaskGoodsRelListsss(new CbacVo())).thenReturn(cbacVos);

        // Run the test
        final List<CbacVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListsss(cbacVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListsss_CbacMapperReturnsNoItems() {
        // Setup
        final CbacVo cbacVo = new CbacVo();
        cbacVo.setCbac01(0);
        cbacVo.setCbac02(0);
        cbacVo.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac04(0);
        cbacVo.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac06(0);
        cbacVo.setCbac07(0);
        cbacVo.setCbac08(0);
        cbacVo.setCbac09("cbac09");
        cbacVo.setCbac10(0);
        cbacVo.setCbac11(0);
        cbacVo.setCbac12("cbac12");
        cbacVo.setCbaa01(0);
        cbacVo.setSaoma(0);
        cbacVo.setNums(0.0);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.selectSwJsTaskGoodsRelListsss(new CbacVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbacVo> result = warehousetransferordersServiceImplUnderTest.selectSwJsTaskGoodsRelListsss(cbacVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSwJsGoodslistsss() {
        // Setup
        final CbacVo cbacVo = new CbacVo();
        cbacVo.setCbac01(0);
        cbacVo.setCbac02(0);
        cbacVo.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac04(0);
        cbacVo.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac06(0);
        cbacVo.setCbac07(0);
        cbacVo.setCbac08(0);
        cbacVo.setCbac09("cbac09");
        cbacVo.setCbac10(0);
        cbacVo.setCbac11(0);
        cbacVo.setCbac12("cbac12");
        cbacVo.setCbaa01(0);
        cbacVo.setSaoma(0);
        cbacVo.setNums(0.0);

        final CbacVo cbacVo1 = new CbacVo();
        cbacVo1.setCbac01(0);
        cbacVo1.setCbac02(0);
        cbacVo1.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo1.setCbac04(0);
        cbacVo1.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo1.setCbac06(0);
        cbacVo1.setCbac07(0);
        cbacVo1.setCbac08(0);
        cbacVo1.setCbac09("cbac09");
        cbacVo1.setCbac10(0);
        cbacVo1.setCbac11(0);
        cbacVo1.setCbac12("cbac12");
        cbacVo1.setCbaa01(0);
        cbacVo1.setSaoma(0);
        cbacVo1.setNums(0.0);
        final List<CbacVo> expectedResult = Arrays.asList(cbacVo1);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        // Configure CbacMapper.swJsGoodslistsss(...).
        final CbacVo cbacVo2 = new CbacVo();
        cbacVo2.setCbac01(0);
        cbacVo2.setCbac02(0);
        cbacVo2.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo2.setCbac04(0);
        cbacVo2.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo2.setCbac06(0);
        cbacVo2.setCbac07(0);
        cbacVo2.setCbac08(0);
        cbacVo2.setCbac09("cbac09");
        cbacVo2.setCbac10(0);
        cbacVo2.setCbac11(0);
        cbacVo2.setCbac12("cbac12");
        cbacVo2.setCbaa01(0);
        cbacVo2.setSaoma(0);
        cbacVo2.setNums(0.0);
        final List<CbacVo> cbacVos = Arrays.asList(cbacVo2);
        when(mockCbacMapper.swJsGoodslistsss(new CbacVo())).thenReturn(cbacVos);

        // Run the test
        final List<CbacVo> result = warehousetransferordersServiceImplUnderTest.swJsGoodslistsss(cbacVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSwJsGoodslistsss_CbabMapperReturnsNoItems() {
        // Setup
        final CbacVo cbacVo = new CbacVo();
        cbacVo.setCbac01(0);
        cbacVo.setCbac02(0);
        cbacVo.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac04(0);
        cbacVo.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac06(0);
        cbacVo.setCbac07(0);
        cbacVo.setCbac08(0);
        cbacVo.setCbac09("cbac09");
        cbacVo.setCbac10(0);
        cbacVo.setCbac11(0);
        cbacVo.setCbac12("cbac12");
        cbacVo.setCbaa01(0);
        cbacVo.setSaoma(0);
        cbacVo.setNums(0.0);

        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbacMapper.swJsGoodslistsss(...).
        final CbacVo cbacVo1 = new CbacVo();
        cbacVo1.setCbac01(0);
        cbacVo1.setCbac02(0);
        cbacVo1.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo1.setCbac04(0);
        cbacVo1.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo1.setCbac06(0);
        cbacVo1.setCbac07(0);
        cbacVo1.setCbac08(0);
        cbacVo1.setCbac09("cbac09");
        cbacVo1.setCbac10(0);
        cbacVo1.setCbac11(0);
        cbacVo1.setCbac12("cbac12");
        cbacVo1.setCbaa01(0);
        cbacVo1.setSaoma(0);
        cbacVo1.setNums(0.0);
        final List<CbacVo> cbacVos = Arrays.asList(cbacVo1);
        when(mockCbacMapper.swJsGoodslistsss(new CbacVo())).thenReturn(cbacVos);

        // Run the test
        final List<CbacVo> result = warehousetransferordersServiceImplUnderTest.swJsGoodslistsss(cbacVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSwJsGoodslistsss_CbacMapperReturnsNoItems() {
        // Setup
        final CbacVo cbacVo = new CbacVo();
        cbacVo.setCbac01(0);
        cbacVo.setCbac02(0);
        cbacVo.setCbac03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac04(0);
        cbacVo.setCbac05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbacVo.setCbac06(0);
        cbacVo.setCbac07(0);
        cbacVo.setCbac08(0);
        cbacVo.setCbac09("cbac09");
        cbacVo.setCbac10(0);
        cbacVo.setCbac11(0);
        cbacVo.setCbac12("cbac12");
        cbacVo.setCbaa01(0);
        cbacVo.setSaoma(0);
        cbacVo.setNums(0.0);

        // Configure CbabMapper.selectByExample(...).
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        final List<Cbab> cbabs = Arrays.asList(cbab);
        when(mockCbabMapper.selectByExample(any(CbabCriteria.class))).thenReturn(cbabs);

        when(mockCbacMapper.swJsGoodslistsss(new CbacVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbacVo> result = warehousetransferordersServiceImplUnderTest.swJsGoodslistsss(cbacVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testImportSwJsGoods() throws Exception {
        // Setup
        final cbaaDto cbaaDto = new cbaaDto();
        cbaaDto.setTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaDto.setOutstore("outstore");
        cbaaDto.setIntstore("intstore");
        cbaaDto.setCurrent("current");
        cbaaDto.setSupplierName("supplierName");
        cbaaDto.setOrderNo("orderNo");
        cbaaDto.setGoodssku("goodssku");
        cbaaDto.setNum(0);
        cbaaDto.setPrice(0.0);
        cbaaDto.setMark("cbab13");
        final List<com.ruoyi.system.domain.dto.cbaaDto> swJsGoodsList = Arrays.asList(cbaaDto);

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

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

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

        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        final String result = warehousetransferordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbaaMapper).insertSelective(new Cbaa());
        verify(mockCbabMapper).insertSelective(new Cbab());
    }

    @Test
    public void testImportSwJsGoods_CbwaMapperReturnsNoItems() throws Exception {
        // Setup
        final cbaaDto cbaaDto = new cbaaDto();
        cbaaDto.setTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaDto.setOutstore("outstore");
        cbaaDto.setIntstore("intstore");
        cbaaDto.setCurrent("current");
        cbaaDto.setSupplierName("supplierName");
        cbaaDto.setOrderNo("orderNo");
        cbaaDto.setGoodssku("goodssku");
        cbaaDto.setNum(0);
        cbaaDto.setPrice(0.0);
        cbaaDto.setMark("cbab13");
        final List<com.ruoyi.system.domain.dto.cbaaDto> swJsGoodsList = Arrays.asList(cbaaDto);
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

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

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

        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        final String result = warehousetransferordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbaaMapper).insertSelective(new Cbaa());
        verify(mockCbabMapper).insertSelective(new Cbab());
    }

    @Test
    public void testImportSwJsGoods_CalaMapperReturnsNoItems() throws Exception {
        // Setup
        final cbaaDto cbaaDto = new cbaaDto();
        cbaaDto.setTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaDto.setOutstore("outstore");
        cbaaDto.setIntstore("intstore");
        cbaaDto.setCurrent("current");
        cbaaDto.setSupplierName("supplierName");
        cbaaDto.setOrderNo("orderNo");
        cbaaDto.setGoodssku("goodssku");
        cbaaDto.setNum(0);
        cbaaDto.setPrice(0.0);
        cbaaDto.setMark("cbab13");
        final List<com.ruoyi.system.domain.dto.cbaaDto> swJsGoodsList = Arrays.asList(cbaaDto);

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
        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

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

        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        final String result = warehousetransferordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbaaMapper).insertSelective(new Cbaa());
        verify(mockCbabMapper).insertSelective(new Cbab());
    }

    @Test
    public void testImportSwJsGoods_CbaaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final cbaaDto cbaaDto = new cbaaDto();
        cbaaDto.setTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaDto.setOutstore("outstore");
        cbaaDto.setIntstore("intstore");
        cbaaDto.setCurrent("current");
        cbaaDto.setSupplierName("supplierName");
        cbaaDto.setOrderNo("orderNo");
        cbaaDto.setGoodssku("goodssku");
        cbaaDto.setNum(0);
        cbaaDto.setPrice(0.0);
        cbaaDto.setMark("cbab13");
        final List<com.ruoyi.system.domain.dto.cbaaDto> swJsGoodsList = Arrays.asList(cbaaDto);

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

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        final String result = warehousetransferordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbaaMapper).insertSelective(new Cbaa());
        verify(mockCbabMapper).insertSelective(new Cbab());
    }

    @Test
    public void testImportSwJsGoods_CbsaMapperReturnsNoItems() throws Exception {
        // Setup
        final cbaaDto cbaaDto = new cbaaDto();
        cbaaDto.setTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaDto.setOutstore("outstore");
        cbaaDto.setIntstore("intstore");
        cbaaDto.setCurrent("current");
        cbaaDto.setSupplierName("supplierName");
        cbaaDto.setOrderNo("orderNo");
        cbaaDto.setGoodssku("goodssku");
        cbaaDto.setNum(0);
        cbaaDto.setPrice(0.0);
        cbaaDto.setMark("cbab13");
        final List<com.ruoyi.system.domain.dto.cbaaDto> swJsGoodsList = Arrays.asList(cbaaDto);

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

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        final String result = warehousetransferordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbaaMapper).insertSelective(new Cbaa());
        verify(mockCbabMapper).insertSelective(new Cbab());
    }

    @Test
    public void testImportSwJsGoods_CbpbMapperReturnsNoItems() throws Exception {
        // Setup
        final cbaaDto cbaaDto = new cbaaDto();
        cbaaDto.setTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaaDto.setOutstore("outstore");
        cbaaDto.setIntstore("intstore");
        cbaaDto.setCurrent("current");
        cbaaDto.setSupplierName("supplierName");
        cbaaDto.setOrderNo("orderNo");
        cbaaDto.setGoodssku("goodssku");
        cbaaDto.setNum(0);
        cbaaDto.setPrice(0.0);
        cbaaDto.setMark("cbab13");
        final List<com.ruoyi.system.domain.dto.cbaaDto> swJsGoodsList = Arrays.asList(cbaaDto);

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

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

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

        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        final String result = warehousetransferordersServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false,
                "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbaaMapper).insertSelective(new Cbaa());
        verify(mockCbabMapper).insertSelective(new Cbab());
    }

    @Test
    public void testInsertSwJsStoreplus() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);

        // Configure CbaaMapper.selectByExample(...).
        final Cbaa cbaa = new Cbaa();
        cbaa.setCbaa01(0);
        cbaa.setCbaa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa03(0);
        cbaa.setCbaa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa05(0);
        cbaa.setCbaa06(0);
        cbaa.setCbaa07("cbaa07");
        cbaa.setCbaa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa09(0);
        cbaa.setCbaa10(0);
        cbaa.setCbaa11(0);
        cbaa.setCbaa12(0);
        cbaa.setCbaa13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbaa.setCbaa16(0);
        cbaa.setUserId(0);
        final List<Cbaa> cbaas = Arrays.asList(cbaa);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(cbaas);

        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsStoreplus(cbaaDo);

        // Verify the results
        assertEquals(0,1, result);
      //  verify(mockCbaaMapper).insertSelective(new Cbaa());
     //   verify(mockCbabMapper).insertSelective(new Cbab());
    }

    @Test
    public void testInsertSwJsStoreplus_CbaaMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbaaDo cbaaDo = new CbaaDo();
        cbaaDo.setCbaa01(0);
        cbaaDo.setCbaa10(0);
        final Cbab cbab = new Cbab();
        cbab.setCbab03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab04(0);
        cbab.setCbab05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbab.setCbab06(0);
        cbab.setCbab07(0);
        cbab.setCbab08(0);
        cbab.setCbab09(0.0);
        cbab.setCbab10(0.0);
        cbab.setCbab11(0.0);
        cbab.setCbab12(0.0);
        cbab.setCbab13("cbab13");
        cbab.setCbaa01(0);
        cbab.setCbab14(0);
        cbab.setCbab15(0);
        cbab.setCbab16(0);
        cbab.setCbab17(0);
        cbab.setUserId(0);
        cbaaDo.setGoods(Arrays.asList(cbab));

        when(mockNumberGenerate.getWarehouseinitializationNos(0)).thenReturn("cbaa07");
        when(mockCbaaMapper.insertSelective(new Cbaa())).thenReturn(0);
        when(mockCbaaMapper.selectByExample(any(CbaaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbabMapper.insertSelective(new Cbab())).thenReturn(0);

        // Run the test
        final int result = warehousetransferordersServiceImplUnderTest.insertSwJsStoreplus(cbaaDo);

        // Verify the results
        assertEquals(1, result);
      //  verify(mockCbaaMapper).insertSelective(new Cbaa());
     //   verify(mockCbabMapper).insertSelective(new Cbab());
    }
}
