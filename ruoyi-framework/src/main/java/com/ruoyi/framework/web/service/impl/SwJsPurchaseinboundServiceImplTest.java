package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.exception.SwException;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CbibDo;
import com.ruoyi.system.domain.Do.CbpcDo;
import com.ruoyi.system.domain.Do.CheckSkuDo;
import com.ruoyi.system.domain.dto.CbpcDto;
import com.ruoyi.system.domain.dto.CbpdDto;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SwJsPurchaseinboundServiceImplTest {

    @Mock
    private GsGoodsSnMapper mockGsGoodsSnMapper;
    @Mock
    private BaseCheckService mockBaseCheckService;
    @Mock
    private GsGoodsSkuMapper mockGsGoodsSkuMapper;
    @Mock
    private CbpcMapper mockCbpcMapper;
    @Mock
    private CbpdMapper mockCbpdMapper;
    @Mock
    private CbsaMapper mockCbasMapper;
    @Mock
    private CbpeMapper mockCbpeMapper;
    @Mock
    private TaskService mockTaskService;
    @Mock
    private CbsaMapper mockCbsaMapper;
    @Mock
    private CblaMapper mockCblaMapper;
    @Mock
    private CbwaMapper mockCbwaMapper;
    @Mock
    private CalaMapper mockCalaMapper;
    @Mock
    private CbpbMapper mockCbpbMapper;
    @Mock
    private StringRedisTemplate mockRedisTemplate;
    @Mock
    private CbibMapper mockCbibMapper;
    @Mock
    private OrderDistributionService mockOrderDistributionService;
    @Mock
    private NumberGenerate mockNumberGenerate;
    @Mock
    private SqlSessionFactory mockSqlSessionFactory;

    @InjectMocks
    private SwJsPurchaseinboundServiceImpl swJsPurchaseinboundServiceImplUnderTest;

    @Test
    public void testInsertSwJsSkuBarcodes() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        // Configure BaseCheckService.checksupplier(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockBaseCheckService.checksupplier(0)).thenReturn(cbsa);

        // Configure BaseCheckService.checkStore(...).
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
        when(mockBaseCheckService.checkStore(0)).thenReturn(cbwa);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpcMapper.updateByPrimaryKeySelective(new Cbpc())).thenReturn(0);

        // Run the test
        final IdVo result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodes(cbpdDto);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockBaseCheckService).checksupplier(0);
        verify(mockBaseCheckService).checkStore(0);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
        verify(mockCbpcMapper).updateByPrimaryKeySelective(new Cbpc());
    }

    @Test
    public void testInsertSwJsSkuBarcodes_CbpcMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        final IdVo expectedResult = new IdVo();
        expectedResult.setId(0);

        // Configure BaseCheckService.checksupplier(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockBaseCheckService.checksupplier(0)).thenReturn(cbsa);

        // Configure BaseCheckService.checkStore(...).
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
        when(mockBaseCheckService.checkStore(0)).thenReturn(cbwa);

        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(Collections.emptyList());
        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpcMapper.updateByPrimaryKeySelective(new Cbpc())).thenReturn(0);

        // Run the test
        final IdVo result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodes(cbpdDto);

        // Verify the results
        assertEquals(expectedResult, result);
        verify(mockBaseCheckService).checksupplier(0);
        verify(mockBaseCheckService).checkStore(0);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
        verify(mockCbpcMapper).updateByPrimaryKeySelective(new Cbpc());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm() {
        // Setup
        final Cbpe itemList = new Cbpe();
        itemList.setCbpe01(0);
        itemList.setCbpe02(0);
        itemList.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe04(0);
        itemList.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe06(0);
        itemList.setCbpe07(0);
        itemList.setCbpe08(0);
        itemList.setCbpe09("cbpe09");
        itemList.setCbpe10(0);
        itemList.setCbpe11(0);
        itemList.setCbpe12("cbpe12");
        itemList.setCbpc01(0);
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

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

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

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd02(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure BaseCheckService.checkStoresku(...).
        final Cbla cbla1 = new Cbla();
        cbla1.setCbla01(0);
        cbla1.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla03(0);
        cbla1.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla05(0);
        cbla1.setCbla06(0);
        cbla1.setCbla07(0);
        cbla1.setCbla08("cbla08");
        cbla1.setCbla09("cbla09");
        cbla1.setCbla10(0);
        cbla1.setCbla11(0.0);
        cbla1.setCbla12("cbla12");
        cbla1.setCbla13("cbla13");
        when(mockBaseCheckService.checkStoresku(0)).thenReturn(cbla1);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbpe09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        gsGoodsSn.setCurrency(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockCbpeMapper.insertSelective(new Cbpe())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockCbpeMapper).insertSelective(new Cbpe());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CbpbMapperReturnsNull() {
        // Setup
        final Cbpe itemList = new Cbpe();
        itemList.setCbpe01(0);
        itemList.setCbpe02(0);
        itemList.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe04(0);
        itemList.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe06(0);
        itemList.setCbpe07(0);
        itemList.setCbpe08(0);
        itemList.setCbpe09("cbpe09");
        itemList.setCbpe10(0);
        itemList.setCbpe11(0);
        itemList.setCbpe12("cbpe12");
        itemList.setCbpc01(0);
        itemList.setUserId(0);

        when(mockCbpbMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

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

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd02(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure BaseCheckService.checkStoresku(...).
        final Cbla cbla1 = new Cbla();
        cbla1.setCbla01(0);
        cbla1.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla03(0);
        cbla1.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla05(0);
        cbla1.setCbla06(0);
        cbla1.setCbla07(0);
        cbla1.setCbla08("cbla08");
        cbla1.setCbla09("cbla09");
        cbla1.setCbla10(0);
        cbla1.setCbla11(0.0);
        cbla1.setCbla12("cbla12");
        cbla1.setCbla13("cbla13");
        when(mockBaseCheckService.checkStoresku(0)).thenReturn(cbla1);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbpe09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        gsGoodsSn.setCurrency(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockCbpeMapper.insertSelective(new Cbpe())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockCbpeMapper).insertSelective(new Cbpe());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CbpdMapperGetInfossssReturnsNoItems() {
        // Setup
        final Cbpe itemList = new Cbpe();
        itemList.setCbpe01(0);
        itemList.setCbpe02(0);
        itemList.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe04(0);
        itemList.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe06(0);
        itemList.setCbpe07(0);
        itemList.setCbpe08(0);
        itemList.setCbpe09("cbpe09");
        itemList.setCbpe10(0);
        itemList.setCbpe11(0);
        itemList.setCbpe12("cbpe12");
        itemList.setCbpc01(0);
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

        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(Collections.emptyList());

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

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

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd02(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure BaseCheckService.checkStoresku(...).
        final Cbla cbla1 = new Cbla();
        cbla1.setCbla01(0);
        cbla1.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla03(0);
        cbla1.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla05(0);
        cbla1.setCbla06(0);
        cbla1.setCbla07(0);
        cbla1.setCbla08("cbla08");
        cbla1.setCbla09("cbla09");
        cbla1.setCbla10(0);
        cbla1.setCbla11(0.0);
        cbla1.setCbla12("cbla12");
        cbla1.setCbla13("cbla13");
        when(mockBaseCheckService.checkStoresku(0)).thenReturn(cbla1);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbpe09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        gsGoodsSn.setCurrency(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockCbpeMapper.insertSelective(new Cbpe())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockCbpeMapper).insertSelective(new Cbpe());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CbpeMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbpe itemList = new Cbpe();
        itemList.setCbpe01(0);
        itemList.setCbpe02(0);
        itemList.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe04(0);
        itemList.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe06(0);
        itemList.setCbpe07(0);
        itemList.setCbpe08(0);
        itemList.setCbpe09("cbpe09");
        itemList.setCbpe10(0);
        itemList.setCbpe11(0);
        itemList.setCbpe12("cbpe12");
        itemList.setCbpc01(0);
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

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(Collections.emptyList());

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

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd02(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure BaseCheckService.checkStoresku(...).
        final Cbla cbla1 = new Cbla();
        cbla1.setCbla01(0);
        cbla1.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla03(0);
        cbla1.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla05(0);
        cbla1.setCbla06(0);
        cbla1.setCbla07(0);
        cbla1.setCbla08("cbla08");
        cbla1.setCbla09("cbla09");
        cbla1.setCbla10(0);
        cbla1.setCbla11(0.0);
        cbla1.setCbla12("cbla12");
        cbla1.setCbla13("cbla13");
        when(mockBaseCheckService.checkStoresku(0)).thenReturn(cbla1);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbpe09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        gsGoodsSn.setCurrency(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockCbpeMapper.insertSelective(new Cbpe())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockCbpeMapper).insertSelective(new Cbpe());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CblaMapperReturnsNull() {
        // Setup
        final Cbpe itemList = new Cbpe();
        itemList.setCbpe01(0);
        itemList.setCbpe02(0);
        itemList.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe04(0);
        itemList.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe06(0);
        itemList.setCbpe07(0);
        itemList.setCbpe08(0);
        itemList.setCbpe09("cbpe09");
        itemList.setCbpe10(0);
        itemList.setCbpe11(0);
        itemList.setCbpe12("cbpe12");
        itemList.setCbpc01(0);
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

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList));
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_CbpdMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbpe itemList = new Cbpe();
        itemList.setCbpe01(0);
        itemList.setCbpe02(0);
        itemList.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe04(0);
        itemList.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe06(0);
        itemList.setCbpe07(0);
        itemList.setCbpe08(0);
        itemList.setCbpe09("cbpe09");
        itemList.setCbpe10(0);
        itemList.setCbpe11(0);
        itemList.setCbpe12("cbpe12");
        itemList.setCbpc01(0);
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

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

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

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(Collections.emptyList());
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure BaseCheckService.checkStoresku(...).
        final Cbla cbla1 = new Cbla();
        cbla1.setCbla01(0);
        cbla1.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla03(0);
        cbla1.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla05(0);
        cbla1.setCbla06(0);
        cbla1.setCbla07(0);
        cbla1.setCbla08("cbla08");
        cbla1.setCbla09("cbla09");
        cbla1.setCbla10(0);
        cbla1.setCbla11(0.0);
        cbla1.setCbla12("cbla12");
        cbla1.setCbla13("cbla13");
        when(mockBaseCheckService.checkStoresku(0)).thenReturn(cbla1);

        // Configure GsGoodsSnMapper.selectByExample(...).
        final GsGoodsSn gsGoodsSn = new GsGoodsSn();
        gsGoodsSn.setId(0);
        gsGoodsSn.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setCreateBy(0);
        gsGoodsSn.setUpdateBy(0);
        gsGoodsSn.setDeleteFlag((byte) 0b0);
        gsGoodsSn.setSn("cbpe09");
        gsGoodsSn.setGoodsId(0);
        gsGoodsSn.setLocationId(0);
        gsGoodsSn.setStatus((byte) 0b0);
        gsGoodsSn.setWhId(0);
        gsGoodsSn.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsSn.setGroudStatus((byte) 0b0);
        gsGoodsSn.setPrice(0.0);
        gsGoodsSn.setCurrency(0);
        final List<GsGoodsSn> gsGoodsSns = Arrays.asList(gsGoodsSn);
        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(gsGoodsSns);

        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockCbpeMapper.insertSelective(new Cbpe())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockCbpeMapper).insertSelective(new Cbpe());
    }

    @Test
    public void testInsertSwJsSkuBarcodesm_GsGoodsSnMapperSelectByExampleReturnsNoItems() {
        // Setup
        final Cbpe itemList = new Cbpe();
        itemList.setCbpe01(0);
        itemList.setCbpe02(0);
        itemList.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe04(0);
        itemList.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        itemList.setCbpe06(0);
        itemList.setCbpe07(0);
        itemList.setCbpe08(0);
        itemList.setCbpe09("cbpe09");
        itemList.setCbpe10(0);
        itemList.setCbpe11(0);
        itemList.setCbpe12("cbpe12");
        itemList.setCbpc01(0);
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

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

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

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd02(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Configure BaseCheckService.checkStoresku(...).
        final Cbla cbla1 = new Cbla();
        cbla1.setCbla01(0);
        cbla1.setCbla02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla03(0);
        cbla1.setCbla04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbla1.setCbla05(0);
        cbla1.setCbla06(0);
        cbla1.setCbla07(0);
        cbla1.setCbla08("cbla08");
        cbla1.setCbla09("cbla09");
        cbla1.setCbla10(0);
        cbla1.setCbla11(0.0);
        cbla1.setCbla12("cbla12");
        cbla1.setCbla13("cbla13");
        when(mockBaseCheckService.checkStoresku(0)).thenReturn(cbla1);

        when(mockGsGoodsSnMapper.selectByExample(any(GsGoodsSnCriteria.class))).thenReturn(Collections.emptyList());
        when(mockGsGoodsSnMapper.updateByExampleSelective(eq(new GsGoodsSn()),
                any(GsGoodsSnCriteria.class))).thenReturn(0);
        when(mockGsGoodsSnMapper.insertSelective(new GsGoodsSn())).thenReturn(0);
        when(mockRedisTemplate.execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")),
                eq("args"))).thenReturn(false);
        when(mockCbpeMapper.insertSelective(new Cbpe())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSnMapper).updateByExampleSelective(eq(new GsGoodsSn()), any(GsGoodsSnCriteria.class));
        verify(mockGsGoodsSnMapper).insertSelective(new GsGoodsSn());
        verify(mockRedisTemplate).execute(any(DefaultRedisScript.class), eq(Arrays.asList("value")), eq("args"));
        verify(mockCbpeMapper).insertSelective(new Cbpe());
    }

    @Test
    public void testInsertSwJsStores() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> itemList = Arrays.asList(cbpcDto);

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

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

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
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CbwaMapperReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> itemList = Arrays.asList(cbpcDto);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

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
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CbsaMapperReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> itemList = Arrays.asList(cbpcDto);

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

        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

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
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CalaMapperReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> itemList = Arrays.asList(cbpcDto);

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

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

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
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CbpcMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> itemList = Arrays.asList(cbpcDto);

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

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(Collections.emptyList());

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
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsStores_CbpbMapperReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> itemList = Arrays.asList(cbpcDto);

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

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsStores(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertSwJsSkuBarcsodesm() {
        // Setup
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd02(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        final List<Cbpd> itemList = Arrays.asList(cbpd);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpcMapper.updateByPrimaryKeySelective(new Cbpc())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcsodesm(itemList);

        // Verify the results
        assertEquals(0, result);
        verify(mockSqlSession).close();
        verify(mockCbpcMapper).updateByPrimaryKeySelective(new Cbpc());
    }

    @Test
    public void testSwJsPurchaseinboundeditone() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        when(mockCbpcMapper.updateByPrimaryKeySelective(new Cbpc())).thenReturn(0);
        when(mockCbpdMapper.deleteByExample(any(CbpdCriteria.class))).thenReturn(0);
        when(mockCbpdMapper.insertSelective(new Cbpd())).thenReturn(0);

        // Run the test
        swJsPurchaseinboundServiceImplUnderTest.SwJsPurchaseinboundeditone(cbpdDto);

        // Verify the results
        verify(mockCbpcMapper).updateByPrimaryKeySelective(new Cbpc());
        verify(mockCbpdMapper).insertSelective(new Cbpd());
    }

    @Test
    public void testInsertSwJsSkuBarcodesplus() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure BaseCheckService.checksupplier(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockBaseCheckService.checksupplier(0)).thenReturn(cbsa);

        // Configure BaseCheckService.checkStore(...).
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
        when(mockBaseCheckService.checkStore(0)).thenReturn(cbwa);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(1);
        when(mockCbpdMapper.insertSelective(new Cbpd())).thenReturn(1);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesplus(cbpdDto);

        // Verify the results
        assertEquals(0, 1,result);
        verify(mockBaseCheckService).checksupplier(0);
        verify(mockBaseCheckService).checkStore(0);
      //  verify(mockCbpcMapper).insertSelective(new Cbpc());
      //  verify(mockCbpdMapper).insertSelective(new Cbpd());
    }

    @Test
    public void testInsertSwJsSkuBarcodesplus_CbpcMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure BaseCheckService.checksupplier(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockBaseCheckService.checksupplier(0)).thenReturn(cbsa);

        // Configure BaseCheckService.checkStore(...).
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
        when(mockBaseCheckService.checkStore(0)).thenReturn(cbwa);

        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(Collections.emptyList());
        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);
        when(mockCbpdMapper.insertSelective(new Cbpd())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertSwJsSkuBarcodesplus(cbpdDto);

        // Verify the results
        assertEquals(0,1, result);
        verify(mockBaseCheckService).checksupplier(0);
        verify(mockBaseCheckService).checkStore(0);
       // verify(mockCbpcMapper).insertSelective(new Cbpc());
       // verify(mockCbpdMapper).insertSelective(new Cbpd());
    }

    @Test
    public void testSwJsSkuBarcodeshs() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshs(cbpdDto);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSwJsSkuBarcodeshss() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSwJsSkuBarcodeshss_CbpeMapperReturnsNoItems() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSwJsSkuBarcodeshsss() throws Exception {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        // Configure CbpeMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpeMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure GsGoodsSkuMapper.selectByExample(...).
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
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus1);

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

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodeshsss_CbsaMapperReturnsNull() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto));
    }

    @Test
    public void testSwJsSkuBarcodeshsss_CbwaMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        // Configure CbpeMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpeMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure GsGoodsSkuMapper.selectByExample(...).
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
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus1);

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

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodeshsss_CbpdMapperReturnsNoItems() throws Exception {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(Collections.emptyList());

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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        // Configure CbpeMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpeMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure GsGoodsSkuMapper.selectByExample(...).
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
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus1);

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

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodeshsss_GsGoodsSkuMapperSelectByGoodsIdAndWhIdReturnsNoItems() throws Exception {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        // Configure CbpeMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpeMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure GsGoodsSkuMapper.selectByExample(...).
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
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus);

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

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodeshsss_TaskServiceThrowsInterruptedException() throws Exception {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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
                () -> swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto));
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
    }

    @Test
    public void testSwJsSkuBarcodeshsss_CbpeMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbpeMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpeMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        // Configure GsGoodsSkuMapper.selectByExample(...).
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
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus1);

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

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodeshsss_CbpeMapperSelectbyidReturnsNoItems() throws Exception {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        when(mockCbpeMapper.selectbyid(new UIOVo())).thenReturn(Collections.emptyList());

        // Configure GsGoodsSkuMapper.selectByExample(...).
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
        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(gsGoodsSkus1);

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

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodeshsss_GsGoodsSkuMapperSelectByExampleReturnsNoItems() throws Exception {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbsaMapper.selectByPrimaryKey(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockTaskService.InsertCBIB(new CbibDo())).thenReturn(cbib);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        // Configure CbpeMapper.selectbyid(...).
        final UIOVo uioVo = new UIOVo();
        uioVo.setId(0);
        uioVo.setGoodsId(0);
        uioVo.setStoreskuid(0);
        uioVo.setNums(0);
        uioVo.setPrice(0.0);
        final List<UIOVo> uioVos = Arrays.asList(uioVo);
        when(mockCbpeMapper.selectbyid(new UIOVo())).thenReturn(uioVos);

        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodeshsss(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockGsGoodsSkuMapper).insertSelective(new GsGoodsSku());
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockTaskService).InsertCBIB(new CbibDo());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodesh() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

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
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure CbibMapper.selectLastByGoodsIdAndStoreId(...).
        final Cbib cbib = new Cbib();
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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockCbibMapper.selectLastByGoodsIdAndStoreId(0, 0)).thenReturn(cbib);

        when(mockCbibMapper.insertSelective(new Cbib())).thenReturn(0);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodesh(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockCbibMapper).insertSelective(new Cbib());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodesh_CbpcMapperSelectByPrimaryKeyReturnsNull() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodesh(cbpdDto));
    }

    @Test
    public void testSwJsSkuBarcodesh_CbpdMapperReturnsNoItems() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

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

        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(Collections.emptyList());

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

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

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
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure CbibMapper.selectLastByGoodsIdAndStoreId(...).
        final Cbib cbib = new Cbib();
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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockCbibMapper.selectLastByGoodsIdAndStoreId(0, 0)).thenReturn(cbib);

        when(mockCbibMapper.insertSelective(new Cbib())).thenReturn(0);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodesh(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockCbibMapper).insertSelective(new Cbib());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodesh_GsGoodsSkuMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

        when(mockGsGoodsSkuMapper.selectByExample(any(GsGoodsSkuCriteria.class))).thenReturn(Collections.emptyList());

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

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
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure CbibMapper.selectLastByGoodsIdAndStoreId(...).
        final Cbib cbib = new Cbib();
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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockCbibMapper.selectLastByGoodsIdAndStoreId(0, 0)).thenReturn(cbib);

        when(mockCbibMapper.insertSelective(new Cbib())).thenReturn(0);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodesh(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockCbibMapper).insertSelective(new Cbib());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodesh_CbsaMapperReturnsNull() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

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
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class, () -> swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodesh(cbpdDto));
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
    }

    @Test
    public void testSwJsSkuBarcodesh_CbibMapperSelectLastByGoodsIdAndStoreIdReturnsNull() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

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
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        when(mockCbibMapper.selectLastByGoodsIdAndStoreId(0, 0)).thenReturn(null);
        when(mockCbibMapper.insertSelective(new Cbib())).thenReturn(0);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodesh(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockCbibMapper).insertSelective(new Cbib());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSwJsSkuBarcodesh_CbpeMapperReturnsNoItems() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

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

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

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

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

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
        cbsa.setCbsa07("cbib06");
        cbsa.setCbsa08("cbsa08");
        cbsa.setCbsa09("cbsa09");
        cbsa.setCbsa10("cbsa10");
        cbsa.setCbsa11("cbsa11");
        cbsa.setCbsa12("cbsa12");
        cbsa.setCbsa13("cbsa13");
        cbsa.setCbsa14("cbsa14");
        cbsa.setCbsa15("cbsa15");
        when(mockCbasMapper.selectByPrimaryKey(0)).thenReturn(cbsa);

        // Configure CbibMapper.selectLastByGoodsIdAndStoreId(...).
        final Cbib cbib = new Cbib();
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
        cbib.setCbib16(0.0);
        cbib.setCbib17("cbib17");
        cbib.setCbib18(0);
        cbib.setCbib19(0);
        when(mockCbibMapper.selectLastByGoodsIdAndStoreId(0, 0)).thenReturn(cbib);

        when(mockCbibMapper.insertSelective(new Cbib())).thenReturn(0);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.SwJsSkuBarcodesh(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSkuForUpdate(0);
        verify(mockGsGoodsSkuMapper).updateByPrimaryKeySelective(new GsGoodsSku());
        verify(mockCbibMapper).insertSelective(new Cbib());
        verify(mockCbpcMapper).updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class));
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss() {
        // Setup
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);

        final CbpcVo cbpcVo1 = new CbpcVo();
        cbpcVo1.setCbpc01(0);
        cbpcVo1.setCala08("cala08");
        cbpcVo1.setCbpb08("cbpb08");
        cbpcVo1.setCbpb12("cbpb12");
        cbpcVo1.setCbpb15("cbpb15");
        cbpcVo1.setCbpd09(0.0);
        cbpcVo1.setCbpa07("cbpa07");
        cbpcVo1.setCbpd08(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa07");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpe09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo1.setGoods(Arrays.asList(scanVo1));
        cbpcVo1.setSaoma(0);
        cbpcVo1.setSaomanums(0);
        cbpcVo1.setNums(0.0);
        final List<CbpcVo> expectedResult = Arrays.asList(cbpcVo1);

        // Configure CbpdMapper.getInfosss(...).
        final CbpcVo cbpcVo2 = new CbpcVo();
        cbpcVo2.setCbpc01(0);
        cbpcVo2.setCala08("cala08");
        cbpcVo2.setCbpb08("cbpb08");
        cbpcVo2.setCbpb12("cbpb12");
        cbpcVo2.setCbpb15("cbpb15");
        cbpcVo2.setCbpd09(0.0);
        cbpcVo2.setCbpa07("cbpa07");
        cbpcVo2.setCbpd08(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa07");
        scanVo2.setPinpai("cala08");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbpe09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo2.setGoods(Arrays.asList(scanVo2));
        cbpcVo2.setSaoma(0);
        cbpcVo2.setSaomanums(0);
        cbpcVo2.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo2);
        when(mockCbpdMapper.getInfosss(new CbpcVo())).thenReturn(cbpcVos);

        // Run the test
        final List<CbpcVo> result = swJsPurchaseinboundServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbpcVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListss_CbpdMapperReturnsNoItems() {
        // Setup
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);

        when(mockCbpdMapper.getInfosss(new CbpcVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbpcVo> result = swJsPurchaseinboundServiceImplUnderTest.selectSwJsTaskGoodsRelListss(cbpcVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testDeleteSwJsSkuBarcodsById() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbpdMapper.selectByExample(...).
        final Cbpd cbpd1 = new Cbpd();
        cbpd1.setCbpd01(0);
        cbpd1.setCbpd02(0);
        cbpd1.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd04(0);
        cbpd1.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd1.setCbpd06(0);
        cbpd1.setCbpd07(0);
        cbpd1.setCbpd08(0);
        cbpd1.setCbpd09(0.0);
        cbpd1.setCbpd10(0.0);
        cbpd1.setCbpd11(0.0);
        cbpd1.setCbpd12(0.0);
        cbpd1.setCbpd13("cbpd13");
        cbpd1.setCbpc01(0);
        cbpd1.setUserId(0);
        final List<Cbpd> cbpds = Arrays.asList(cbpd1);
        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(cbpds);

        // Configure BaseCheckService.checkGoodsSku(...).
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
        when(mockBaseCheckService.checkGoodsSku(0, 0)).thenReturn(gsGoodsSku);

        when(mockCbpdMapper.updateByExampleSelective(eq(new Cbpd()), any(CbpdCriteria.class))).thenReturn(0);
        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.deleteSwJsSkuBarcodsById(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSku(0, 0);
        verify(mockCbpdMapper).updateByExampleSelective(eq(new Cbpd()), any(CbpdCriteria.class));
    }

    @Test
    public void testDeleteSwJsSkuBarcodsById_CbpdMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpdDto cbpdDto = new CbpdDto();
        cbpdDto.setCbpc01(0);
        cbpdDto.setCbpc07("cbpc07");
        cbpdDto.setCbpc09(0);
        cbpdDto.setCbpc10(0);
        cbpdDto.setCbpc12(0);
        cbpdDto.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Cbpd cbpd = new Cbpd();
        cbpd.setCbpd01(0);
        cbpd.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd04(0);
        cbpd.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpd.setCbpd06(0);
        cbpd.setCbpd07(0);
        cbpd.setCbpd08(0);
        cbpd.setCbpd09(0.0);
        cbpd.setCbpd10(0.0);
        cbpd.setCbpd11(0.0);
        cbpd.setCbpd12(0.0);
        cbpd.setCbpd13("cbpd13");
        cbpd.setCbpc01(0);
        cbpd.setUserId(0);
        cbpdDto.setGoods(Arrays.asList(cbpd));

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        when(mockCbpdMapper.selectByExample(any(CbpdCriteria.class))).thenReturn(Collections.emptyList());

        // Configure BaseCheckService.checkGoodsSku(...).
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
        when(mockBaseCheckService.checkGoodsSku(0, 0)).thenReturn(gsGoodsSku);

        when(mockCbpdMapper.updateByExampleSelective(eq(new Cbpd()), any(CbpdCriteria.class))).thenReturn(0);
        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.deleteSwJsSkuBarcodsById(cbpdDto);

        // Verify the results
        assertEquals(0, result);
        verify(mockBaseCheckService).checkGoodsSku(0, 0);
        verify(mockCbpdMapper).updateByExampleSelective(eq(new Cbpd()), any(CbpdCriteria.class));
    }

    @Test
    public void testUpdateSwJsSkuBarcodes() {
        // Setup
        final CbpcDo cbpcDo = new CbpcDo();
        cbpcDo.setCbpc01(0);
        cbpcDo.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc03(0);
        cbpcDo.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc07("cbib03");
        cbpcDo.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc09(0);
        cbpcDo.setCbpc10(0);
        cbpcDo.setCbpc11(0);
        cbpcDo.setCbpc12(0);
        cbpcDo.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc14(0);
        cbpcDo.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc16(0);
        cbpcDo.setCbpc17("cbpc17");

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc1 = new Cbpc();
        cbpc1.setCbpc01(0);
        cbpc1.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc03(0);
        cbpc1.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc05(0);
        cbpc1.setCbpc06(0);
        cbpc1.setCbpc07("cbib03");
        cbpc1.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc09(0);
        cbpc1.setCbpc10(0);
        cbpc1.setCbpc11(0);
        cbpc1.setCbpc12(0);
        cbpc1.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc14(0);
        cbpc1.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc16(0);
        cbpc1.setCbpc17("cbpc17");
        cbpc1.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc1);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.updateSwJsSkuBarcodes(cbpcDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testUpdateSwJsSkuBarcodes_CbpcMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpcDo cbpcDo = new CbpcDo();
        cbpcDo.setCbpc01(0);
        cbpcDo.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc03(0);
        cbpcDo.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc07("cbib03");
        cbpcDo.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc09(0);
        cbpcDo.setCbpc10(0);
        cbpcDo.setCbpc11(0);
        cbpcDo.setCbpc12(0);
        cbpcDo.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc14(0);
        cbpcDo.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDo.setCbpc16(0);
        cbpcDo.setCbpc17("cbpc17");

        // Configure CbpcMapper.selectByPrimaryKey(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        when(mockCbpcMapper.selectByPrimaryKey(0)).thenReturn(cbpc);

        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(Collections.emptyList());
        when(mockCbpcMapper.updateByExampleSelective(eq(new Cbpc()), any(CbpcCriteria.class))).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.updateSwJsSkuBarcodes(cbpcDo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists() {
        // Setup
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);

        final CbpcVo cbpcVo1 = new CbpcVo();
        cbpcVo1.setCbpc01(0);
        cbpcVo1.setCala08("cala08");
        cbpcVo1.setCbpb08("cbpb08");
        cbpcVo1.setCbpb12("cbpb12");
        cbpcVo1.setCbpb15("cbpb15");
        cbpcVo1.setCbpd09(0.0);
        cbpcVo1.setCbpa07("cbpa07");
        cbpcVo1.setCbpd08(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa07");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpe09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo1.setGoods(Arrays.asList(scanVo1));
        cbpcVo1.setSaoma(0);
        cbpcVo1.setSaomanums(0);
        cbpcVo1.setNums(0.0);
        final List<CbpcVo> expectedResult = Arrays.asList(cbpcVo1);

        // Configure CbpdMapper.getInfoss(...).
        final CbpcVo cbpcVo2 = new CbpcVo();
        cbpcVo2.setCbpc01(0);
        cbpcVo2.setCala08("cala08");
        cbpcVo2.setCbpb08("cbpb08");
        cbpcVo2.setCbpb12("cbpb12");
        cbpcVo2.setCbpb15("cbpb15");
        cbpcVo2.setCbpd09(0.0);
        cbpcVo2.setCbpa07("cbpa07");
        cbpcVo2.setCbpd08(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa07");
        scanVo2.setPinpai("cala08");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbpe09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo2.setGoods(Arrays.asList(scanVo2));
        cbpcVo2.setSaoma(0);
        cbpcVo2.setSaomanums(0);
        cbpcVo2.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo2);
        when(mockCbpdMapper.getInfoss(new CbpcVo())).thenReturn(cbpcVos);

        // Run the test
        final List<CbpcVo> result = swJsPurchaseinboundServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbpcVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelLists_CbpdMapperReturnsNoItems() {
        // Setup
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);

        when(mockCbpdMapper.getInfoss(new CbpcVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<CbpcVo> result = swJsPurchaseinboundServiceImplUnderTest.selectSwJsTaskGoodsRelLists(cbpcVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testM2() {
        assertEquals(0.0, swJsPurchaseinboundServiceImplUnderTest.m2(0.0), 0.0001);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListsss() {
        // Setup
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);

        final CbpcVo cbpcVo1 = new CbpcVo();
        cbpcVo1.setCbpc01(0);
        cbpcVo1.setCala08("cala08");
        cbpcVo1.setCbpb08("cbpb08");
        cbpcVo1.setCbpb12("cbpb12");
        cbpcVo1.setCbpb15("cbpb15");
        cbpcVo1.setCbpd09(0.0);
        cbpcVo1.setCbpa07("cbpa07");
        cbpcVo1.setCbpd08(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa07");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpe09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo1.setGoods(Arrays.asList(scanVo1));
        cbpcVo1.setSaoma(0);
        cbpcVo1.setSaomanums(0);
        cbpcVo1.setNums(0.0);
        final List<CbpcVo> expectedResult = Arrays.asList(cbpcVo1);

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo2 = new CbpcVo();
        cbpcVo2.setCbpc01(0);
        cbpcVo2.setCala08("cala08");
        cbpcVo2.setCbpb08("cbpb08");
        cbpcVo2.setCbpb12("cbpb12");
        cbpcVo2.setCbpb15("cbpb15");
        cbpcVo2.setCbpd09(0.0);
        cbpcVo2.setCbpa07("cbpa07");
        cbpcVo2.setCbpd08(0);
        final ScanVo scanVo2 = new ScanVo();
        scanVo2.setLx("cbpa07");
        scanVo2.setPinpai("cala08");
        scanVo2.setCbpb12("cbpb12");
        scanVo2.setCbpb15("cbpb15");
        scanVo2.setCbpb08("cbpb08");
        scanVo2.setSn("cbpe09");
        scanVo2.setKwm("cbla09");
        scanVo2.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo2.setGoods(Arrays.asList(scanVo2));
        cbpcVo2.setSaoma(0);
        cbpcVo2.setSaomanums(0);
        cbpcVo2.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo2);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

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
        final List<CbpcVo> result = swJsPurchaseinboundServiceImplUnderTest.selectSwJsTaskGoodsRelListsss(cbpcVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListsss_CbpdMapperReturnsNoItems() {
        // Setup
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);

        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(Collections.emptyList());

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

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
        final List<CbpcVo> result = swJsPurchaseinboundServiceImplUnderTest.selectSwJsTaskGoodsRelListsss(cbpcVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListsss_CbpeMapperReturnsNoItems() {
        // Setup
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo1 = new CbpcVo();
        cbpcVo1.setCbpc01(0);
        cbpcVo1.setCala08("cala08");
        cbpcVo1.setCbpb08("cbpb08");
        cbpcVo1.setCbpb12("cbpb12");
        cbpcVo1.setCbpb15("cbpb15");
        cbpcVo1.setCbpd09(0.0);
        cbpcVo1.setCbpa07("cbpa07");
        cbpcVo1.setCbpd08(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa07");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpe09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo1.setGoods(Arrays.asList(scanVo1));
        cbpcVo1.setSaoma(0);
        cbpcVo1.setSaomanums(0);
        cbpcVo1.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo1);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(Collections.emptyList());

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
        final List<CbpcVo> result = swJsPurchaseinboundServiceImplUnderTest.selectSwJsTaskGoodsRelListsss(cbpcVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectSwJsTaskGoodsRelListsss_CblaMapperReturnsNull() {
        // Setup
        final CbpcVo cbpcVo = new CbpcVo();
        cbpcVo.setCbpc01(0);
        cbpcVo.setCala08("cala08");
        cbpcVo.setCbpb08("cbpb08");
        cbpcVo.setCbpb12("cbpb12");
        cbpcVo.setCbpb15("cbpb15");
        cbpcVo.setCbpd09(0.0);
        cbpcVo.setCbpa07("cbpa07");
        cbpcVo.setCbpd08(0);
        final ScanVo scanVo = new ScanVo();
        scanVo.setLx("cbpa07");
        scanVo.setPinpai("cala08");
        scanVo.setCbpb12("cbpb12");
        scanVo.setCbpb15("cbpb15");
        scanVo.setCbpb08("cbpb08");
        scanVo.setSn("cbpe09");
        scanVo.setKwm("cbla09");
        scanVo.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo.setGoods(Arrays.asList(scanVo));
        cbpcVo.setSaoma(0);
        cbpcVo.setSaomanums(0);
        cbpcVo.setNums(0.0);

        // Configure CbpdMapper.getInfossss(...).
        final CbpcVo cbpcVo1 = new CbpcVo();
        cbpcVo1.setCbpc01(0);
        cbpcVo1.setCala08("cala08");
        cbpcVo1.setCbpb08("cbpb08");
        cbpcVo1.setCbpb12("cbpb12");
        cbpcVo1.setCbpb15("cbpb15");
        cbpcVo1.setCbpd09(0.0);
        cbpcVo1.setCbpa07("cbpa07");
        cbpcVo1.setCbpd08(0);
        final ScanVo scanVo1 = new ScanVo();
        scanVo1.setLx("cbpa07");
        scanVo1.setPinpai("cala08");
        scanVo1.setCbpb12("cbpb12");
        scanVo1.setCbpb15("cbpb15");
        scanVo1.setCbpb08("cbpb08");
        scanVo1.setSn("cbpe09");
        scanVo1.setKwm("cbla09");
        scanVo1.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcVo1.setGoods(Arrays.asList(scanVo1));
        cbpcVo1.setSaoma(0);
        cbpcVo1.setSaomanums(0);
        cbpcVo1.setNums(0.0);
        final List<CbpcVo> cbpcVos = Arrays.asList(cbpcVo1);
        when(mockCbpdMapper.getInfossss(new CbpcVo())).thenReturn(cbpcVos);

        // Configure CbpeMapper.selectByExample(...).
        final Cbpe cbpe = new Cbpe();
        cbpe.setCbpe01(0);
        cbpe.setCbpe02(0);
        cbpe.setCbpe03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe04(0);
        cbpe.setCbpe05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpe.setCbpe06(0);
        cbpe.setCbpe07(0);
        cbpe.setCbpe08(0);
        cbpe.setCbpe09("cbpe09");
        cbpe.setCbpe10(0);
        cbpe.setCbpe11(0);
        cbpe.setCbpe12("cbpe12");
        cbpe.setCbpc01(0);
        cbpe.setUserId(0);
        final List<Cbpe> cbpes = Arrays.asList(cbpe);
        when(mockCbpeMapper.selectByExample(any(CbpeCriteria.class))).thenReturn(cbpes);

        when(mockCblaMapper.selectByPrimaryKey(0)).thenReturn(null);

        // Run the test
        assertThrows(SwException.class,
                () -> swJsPurchaseinboundServiceImplUnderTest.selectSwJsTaskGoodsRelListsss(cbpcVo));
    }

    @Test
    public void testSelectCBPCList() {
        // Setup
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);

        final Cbpc cbpc1 = new Cbpc();
        cbpc1.setCbpc01(0);
        cbpc1.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc03(0);
        cbpc1.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc05(0);
        cbpc1.setCbpc06(0);
        cbpc1.setCbpc07("cbib03");
        cbpc1.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc09(0);
        cbpc1.setCbpc10(0);
        cbpc1.setCbpc11(0);
        cbpc1.setCbpc12(0);
        cbpc1.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc14(0);
        cbpc1.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc1.setCbpc16(0);
        cbpc1.setCbpc17("cbpc17");
        cbpc1.setUserId(0);
        final List<Cbpc> expectedResult = Arrays.asList(cbpc1);

        // Configure CbpdMapper.selectCBPCList(...).
        final Cbpc cbpc2 = new Cbpc();
        cbpc2.setCbpc01(0);
        cbpc2.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc2.setCbpc03(0);
        cbpc2.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc2.setCbpc05(0);
        cbpc2.setCbpc06(0);
        cbpc2.setCbpc07("cbib03");
        cbpc2.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc2.setCbpc09(0);
        cbpc2.setCbpc10(0);
        cbpc2.setCbpc11(0);
        cbpc2.setCbpc12(0);
        cbpc2.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc2.setCbpc14(0);
        cbpc2.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc2.setCbpc16(0);
        cbpc2.setCbpc17("cbpc17");
        cbpc2.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc2);
        when(mockCbpdMapper.selectCBPCList(new Cbpc())).thenReturn(cbpcs);

        // Run the test
        final List<Cbpc> result = swJsPurchaseinboundServiceImplUnderTest.selectCBPCList(cbpc);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectCBPCList_CbpdMapperReturnsNoItems() {
        // Setup
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);

        when(mockCbpdMapper.selectCBPCList(new Cbpc())).thenReturn(Collections.emptyList());

        // Run the test
        final List<Cbpc> result = swJsPurchaseinboundServiceImplUnderTest.selectCBPCList(cbpc);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testImportSwJsGoods() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> swJsGoodsList = Arrays.asList(cbpcDto);

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

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

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
        final String result = swJsPurchaseinboundServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false, "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CbwaMapperReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> swJsGoodsList = Arrays.asList(cbpcDto);
        when(mockCbwaMapper.selectByExample(any(CbwaCriteria.class))).thenReturn(Collections.emptyList());

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

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
        final String result = swJsPurchaseinboundServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false, "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CbsaMapperReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> swJsGoodsList = Arrays.asList(cbpcDto);

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

        when(mockCbsaMapper.selectByExample(any(CbsaCriteria.class))).thenReturn(Collections.emptyList());

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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

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
        final String result = swJsPurchaseinboundServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false, "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CalaMapperReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> swJsGoodsList = Arrays.asList(cbpcDto);

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

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockCalaMapper.selectByExample(any(CalaCriteria.class))).thenReturn(Collections.emptyList());
        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

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
        final String result = swJsPurchaseinboundServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false, "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CbpcMapperSelectByExampleReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> swJsGoodsList = Arrays.asList(cbpcDto);

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

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(Collections.emptyList());

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
        final String result = swJsPurchaseinboundServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false, "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testImportSwJsGoods_CbpbMapperReturnsNoItems() {
        // Setup
        final CbpcDto cbpcDto = new CbpcDto();
        cbpcDto.setCbpc01(0);
        cbpcDto.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setSuppierName("SuppierName");
        cbpcDto.setCbpc09(0);
        cbpcDto.setStorename("storename");
        cbpcDto.setCbpc10(0);
        cbpcDto.setMoneytype("moneytype");
        cbpcDto.setCbpc16(0);
        cbpcDto.setUserId(0);
        cbpcDto.setCbpd03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd04(0);
        cbpcDto.setCbpd05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpcDto.setCbpd06(0);
        cbpcDto.setCbpd07(0);
        cbpcDto.setGoodtype("goodtype");
        cbpcDto.setCbpd08(0);
        cbpcDto.setCbpd09(0.0);
        cbpcDto.setCbpd11(0.0);
        cbpcDto.setCbpd12(0.0);
        cbpcDto.setCbpd13("cbpd13");
        final List<CbpcDto> swJsGoodsList = Arrays.asList(cbpcDto);

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

        // Configure CbsaMapper.selectByExample(...).
        final Cbsa cbsa = new Cbsa();
        cbsa.setCbsa01(0);
        cbsa.setCbsa02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa03(0);
        cbsa.setCbsa04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbsa.setCbsa05(0);
        cbsa.setCbsa06(0);
        cbsa.setCbsa07("cbib06");
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

        when(mockNumberGenerate.getPurchaseinboundNo(0)).thenReturn("cbib03");
        when(mockCbpcMapper.insertSelective(new Cbpc())).thenReturn(0);

        // Configure CbpcMapper.selectByExample(...).
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);
        final List<Cbpc> cbpcs = Arrays.asList(cbpc);
        when(mockCbpcMapper.selectByExample(any(CbpcCriteria.class))).thenReturn(cbpcs);

        // Configure SqlSessionFactory.openSession(...).
        final SqlSession mockSqlSession = mock(SqlSession.class);
        when(mockSqlSessionFactory.openSession(ExecutorType.BATCH, false)).thenReturn(mockSqlSession);

        when(mockCbpbMapper.selectByExample(any(CbpbCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final String result = swJsPurchaseinboundServiceImplUnderTest.importSwJsGoods(swJsGoodsList, false, "operName");

        // Verify the results
        assertEquals("result", result);
        verify(mockCbpcMapper).insertSelective(new Cbpc());
        verify(mockSqlSession).close();
    }

    @Test
    public void testInsertCBPC() {
        // Setup
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);

        when(mockCbpdMapper.insertCBPC(new Cbpc())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.insertCBPC(cbpc);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testUpdateCBPC() {
        // Setup
        final Cbpc cbpc = new Cbpc();
        cbpc.setCbpc01(0);
        cbpc.setCbpc02(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc03(0);
        cbpc.setCbpc04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc05(0);
        cbpc.setCbpc06(0);
        cbpc.setCbpc07("cbib03");
        cbpc.setCbpc08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc09(0);
        cbpc.setCbpc10(0);
        cbpc.setCbpc11(0);
        cbpc.setCbpc12(0);
        cbpc.setCbpc13(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc14(0);
        cbpc.setCbpc15(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbpc.setCbpc16(0);
        cbpc.setCbpc17("cbpc17");
        cbpc.setUserId(0);

        when(mockCbpdMapper.updateCBPC(new Cbpc())).thenReturn(0);

        // Run the test
        final int result = swJsPurchaseinboundServiceImplUnderTest.updateCBPC(cbpc);

        // Verify the results
        assertEquals(0, result);
    }
}
