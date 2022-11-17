package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.CheckSkuDo;
import com.ruoyi.system.domain.dto.GsSalesOrdersDetailsDto2;
import com.ruoyi.system.domain.dto.InwuquDto;
import com.ruoyi.system.domain.dto.InwuqusDto;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.gson.BaseCheckService;
import com.ruoyi.system.service.gson.OrderDistributionService;
import com.ruoyi.system.service.gson.SaleOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountQueryServiceImplTest {

    @Mock
    private CbifMapper mockCbifMapper;
    @Mock
    private GsGoodsUseMapper mockGsGoodsUseMapper;
    @Mock
    private BaseCheckService mockBaseCheckService;
    @Mock
    private GsSalesOrdersDetailsMapper mockGsSalesOrdersDetailsMapper;
    @Mock
    private GsSalesOrdersMapper mockGsSalesOrdersMapper;
    @Mock
    private OrderDistributionService mockOrderDistributionService;
    @Mock
    private SaleOrderService mockSaleOrderService;
    @Mock
    private CbodMapper mockCbodMapper;
    @Mock
    private GsGoodsSkuMapper mockGsGoodsSkuMapper;
    @Mock
    private CbpbMapper mockCbpbMapper;
    @Mock
    private CboaMapper mockCboaMapper;
    @Mock
    private ThreadPoolTaskExecutor mockThreadPoolTaskExecutor;

    @InjectMocks
    private CountQueryServiceImpl countQueryServiceImplUnderTest;

    @Test
    public void testSelectInventorysummaryquery() throws Exception {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        final InwuquVo inwuquVo = new InwuquVo();
        inwuquVo.setTotalclassify("cbpa07");
        inwuquVo.setCbpa07("cbpa07");
        inwuquVo.setCala08("cala08");
        inwuquVo.setCbpb12("cbpb12");
        inwuquVo.setCbpb15("cbpb15");
        inwuquVo.setCbpb08("cbpb08");
        inwuquVo.setCbib15(0.0);
        inwuquVo.setLockQty(0.0);
        inwuquVo.setTotallockQty(0.0);
        inwuquVo.setTotalcbib15(0.0);
        inwuquVo.setCbib01(0);
        inwuquVo.setCbib02(0);
        inwuquVo.setCbib08(0);
        inwuquVo.setCbpb10(0);
        inwuquVo.setCbpb14(0);
        final List<InwuquVo> expectedResult = Arrays.asList(inwuquVo);

        // Configure CbifMapper.selectInventorysummaryquery4(...).
        final InwuquVo inwuquVo1 = new InwuquVo();
        inwuquVo1.setTotalclassify("cbpa07");
        inwuquVo1.setCbpa07("cbpa07");
        inwuquVo1.setCala08("cala08");
        inwuquVo1.setCbpb12("cbpb12");
        inwuquVo1.setCbpb15("cbpb15");
        inwuquVo1.setCbpb08("cbpb08");
        inwuquVo1.setCbib15(0.0);
        inwuquVo1.setLockQty(0.0);
        inwuquVo1.setTotallockQty(0.0);
        inwuquVo1.setTotalcbib15(0.0);
        inwuquVo1.setCbib01(0);
        inwuquVo1.setCbib02(0);
        inwuquVo1.setCbib08(0);
        inwuquVo1.setCbpb10(0);
        inwuquVo1.setCbpb14(0);
        final List<InwuquVo> inwuquVos = Arrays.asList(inwuquVo1);
        when(mockCbifMapper.selectInventorysummaryquery4(new InwuquDto())).thenReturn(inwuquVos);

        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());

        // Configure GsGoodsUseMapper.selectByWhIdAndGoodsId(...).
        final GsGoodsUse gsGoodsUse = new GsGoodsUse();
        gsGoodsUse.setId(0);
        gsGoodsUse.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsUse.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsUse.setCreateBy(0);
        gsGoodsUse.setUpdateBy(0);
        gsGoodsUse.setGoodsId(0);
        gsGoodsUse.setOrderNo("orderNo");
        gsGoodsUse.setOrderQty(0.0);
        gsGoodsUse.setOrderType((byte) 0b0);
        gsGoodsUse.setLockQty(0.0);
        gsGoodsUse.setWhId(0);
        gsGoodsUse.setTransNo("transNo");
        gsGoodsUse.setNoOutQty(0.0);
        final List<GsGoodsUse> gsGoodsUses = Arrays.asList(gsGoodsUse);
        when(mockGsGoodsUseMapper.selectByWhIdAndGoodsId(0, 0)).thenReturn(gsGoodsUses);

        // Run the test
        final List<InwuquVo> result = countQueryServiceImplUnderTest.selectInventorysummaryquery(inwuquDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysummaryquery_CbifMapperReturnsNoItems() throws Exception {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        when(mockCbifMapper.selectInventorysummaryquery4(new InwuquDto())).thenReturn(Collections.emptyList());
        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());

        // Configure GsGoodsUseMapper.selectByWhIdAndGoodsId(...).
        final GsGoodsUse gsGoodsUse = new GsGoodsUse();
        gsGoodsUse.setId(0);
        gsGoodsUse.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsUse.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsUse.setCreateBy(0);
        gsGoodsUse.setUpdateBy(0);
        gsGoodsUse.setGoodsId(0);
        gsGoodsUse.setOrderNo("orderNo");
        gsGoodsUse.setOrderQty(0.0);
        gsGoodsUse.setOrderType((byte) 0b0);
        gsGoodsUse.setLockQty(0.0);
        gsGoodsUse.setWhId(0);
        gsGoodsUse.setTransNo("transNo");
        gsGoodsUse.setNoOutQty(0.0);
        final List<GsGoodsUse> gsGoodsUses = Arrays.asList(gsGoodsUse);
        when(mockGsGoodsUseMapper.selectByWhIdAndGoodsId(0, 0)).thenReturn(gsGoodsUses);

        // Run the test
        final List<InwuquVo> result = countQueryServiceImplUnderTest.selectInventorysummaryquery(inwuquDto);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysummaryquery_GsGoodsUseMapperReturnsNoItems() throws Exception {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        // Configure CbifMapper.selectInventorysummaryquery4(...).
        final InwuquVo inwuquVo = new InwuquVo();
        inwuquVo.setTotalclassify("cbpa07");
        inwuquVo.setCbpa07("cbpa07");
        inwuquVo.setCala08("cala08");
        inwuquVo.setCbpb12("cbpb12");
        inwuquVo.setCbpb15("cbpb15");
        inwuquVo.setCbpb08("cbpb08");
        inwuquVo.setCbib15(0.0);
        inwuquVo.setLockQty(0.0);
        inwuquVo.setTotallockQty(0.0);
        inwuquVo.setTotalcbib15(0.0);
        inwuquVo.setCbib01(0);
        inwuquVo.setCbib02(0);
        inwuquVo.setCbib08(0);
        inwuquVo.setCbpb10(0);
        inwuquVo.setCbpb14(0);
        final List<InwuquVo> inwuquVos = Arrays.asList(inwuquVo);
        when(mockCbifMapper.selectInventorysummaryquery4(new InwuquDto())).thenReturn(inwuquVos);

        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());
        when(mockGsGoodsUseMapper.selectByWhIdAndGoodsId(0, 0)).thenReturn(Collections.emptyList());

        // Run the test
        final List<InwuquVo> result = countQueryServiceImplUnderTest.selectInventorysummaryquery(inwuquDto);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysummaryquery_ThrowsExecutionException() {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        // Configure CbifMapper.selectInventorysummaryquery4(...).
        final InwuquVo inwuquVo = new InwuquVo();
        inwuquVo.setTotalclassify("cbpa07");
        inwuquVo.setCbpa07("cbpa07");
        inwuquVo.setCala08("cala08");
        inwuquVo.setCbpb12("cbpb12");
        inwuquVo.setCbpb15("cbpb15");
        inwuquVo.setCbpb08("cbpb08");
        inwuquVo.setCbib15(0.0);
        inwuquVo.setLockQty(0.0);
        inwuquVo.setTotallockQty(0.0);
        inwuquVo.setTotalcbib15(0.0);
        inwuquVo.setCbib01(0);
        inwuquVo.setCbib02(0);
        inwuquVo.setCbib08(0);
        inwuquVo.setCbpb10(0);
        inwuquVo.setCbpb14(0);
        final List<InwuquVo> inwuquVos = Arrays.asList(inwuquVo);
        when(mockCbifMapper.selectInventorysummaryquery4(new InwuquDto())).thenReturn(inwuquVos);

        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());

        // Configure GsGoodsUseMapper.selectByWhIdAndGoodsId(...).
        final GsGoodsUse gsGoodsUse = new GsGoodsUse();
        gsGoodsUse.setId(0);
        gsGoodsUse.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsUse.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsUse.setCreateBy(0);
        gsGoodsUse.setUpdateBy(0);
        gsGoodsUse.setGoodsId(0);
        gsGoodsUse.setOrderNo("orderNo");
        gsGoodsUse.setOrderQty(0.0);
        gsGoodsUse.setOrderType((byte) 0b0);
        gsGoodsUse.setLockQty(0.0);
        gsGoodsUse.setWhId(0);
        gsGoodsUse.setTransNo("transNo");
        gsGoodsUse.setNoOutQty(0.0);
        final List<GsGoodsUse> gsGoodsUses = Arrays.asList(gsGoodsUse);
        when(mockGsGoodsUseMapper.selectByWhIdAndGoodsId(0, 0)).thenReturn(gsGoodsUses);

        // Run the test
        assertThrows(ExecutionException.class,
                () -> countQueryServiceImplUnderTest.selectInventorysummaryquery(inwuquDto));
    }

    @Test
    public void testSelectInventorysummaryquery_ThrowsInterruptedException() {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        // Configure CbifMapper.selectInventorysummaryquery4(...).
        final InwuquVo inwuquVo = new InwuquVo();
        inwuquVo.setTotalclassify("cbpa07");
        inwuquVo.setCbpa07("cbpa07");
        inwuquVo.setCala08("cala08");
        inwuquVo.setCbpb12("cbpb12");
        inwuquVo.setCbpb15("cbpb15");
        inwuquVo.setCbpb08("cbpb08");
        inwuquVo.setCbib15(0.0);
        inwuquVo.setLockQty(0.0);
        inwuquVo.setTotallockQty(0.0);
        inwuquVo.setTotalcbib15(0.0);
        inwuquVo.setCbib01(0);
        inwuquVo.setCbib02(0);
        inwuquVo.setCbib08(0);
        inwuquVo.setCbpb10(0);
        inwuquVo.setCbpb14(0);
        final List<InwuquVo> inwuquVos = Arrays.asList(inwuquVo);
        when(mockCbifMapper.selectInventorysummaryquery4(new InwuquDto())).thenReturn(inwuquVos);

        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());

        // Configure GsGoodsUseMapper.selectByWhIdAndGoodsId(...).
        final GsGoodsUse gsGoodsUse = new GsGoodsUse();
        gsGoodsUse.setId(0);
        gsGoodsUse.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsUse.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsGoodsUse.setCreateBy(0);
        gsGoodsUse.setUpdateBy(0);
        gsGoodsUse.setGoodsId(0);
        gsGoodsUse.setOrderNo("orderNo");
        gsGoodsUse.setOrderQty(0.0);
        gsGoodsUse.setOrderType((byte) 0b0);
        gsGoodsUse.setLockQty(0.0);
        gsGoodsUse.setWhId(0);
        gsGoodsUse.setTransNo("transNo");
        gsGoodsUse.setNoOutQty(0.0);
        final List<GsGoodsUse> gsGoodsUses = Arrays.asList(gsGoodsUse);
        when(mockGsGoodsUseMapper.selectByWhIdAndGoodsId(0, 0)).thenReturn(gsGoodsUses);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> countQueryServiceImplUnderTest.selectInventorysummaryquery(inwuquDto));
    }

    @Test
    public void testSaleOrderListCountquery() {
        // Setup
        final GsSalesOrdersDetailsDto2 gsSalesOrdersDetailsDto = new GsSalesOrdersDetailsDto2();
        gsSalesOrdersDetailsDto.setId(0);
        gsSalesOrdersDetailsDto.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsSalesOrdersDetailsDto.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsSalesOrdersDetailsDto.setCustomerId(0);
        gsSalesOrdersDetailsDto.setSupplierId(0);
        gsSalesOrdersDetailsDto.setSalerId(0);
        gsSalesOrdersDetailsDto.setCbpb12("cbpb12");

        final GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo = new GsSalesOrdersDetailsVo();
        gsSalesOrdersDetailsVo.setIds(0);
        gsSalesOrdersDetailsVo.setIdss(0);
        gsSalesOrdersDetailsVo.setDetailId(0);
        gsSalesOrdersDetailsVo.setId(0);
        gsSalesOrdersDetailsVo.setGoodsId(0);
        gsSalesOrdersDetailsVo.setPrice(new BigDecimal("0.00"));
        gsSalesOrdersDetailsVo.setRemark("remark");
        gsSalesOrdersDetailsVo.setFactory("factory");
        gsSalesOrdersDetailsVo.setGsSalesOrders("gsSalesOrders");
        gsSalesOrdersDetailsVo.setCustomer("customer");
        gsSalesOrdersDetailsVo.setCbpb10("cbpb10");
        gsSalesOrdersDetailsVo.setQty(0.0);
        gsSalesOrdersDetailsVo.setInQty(0.0);
        gsSalesOrdersDetailsVo.setRemainNum(0.0);
        gsSalesOrdersDetailsVo.setIsFinish("NO");
        final List<GsSalesOrdersDetailsVo> expectedResult = Arrays.asList(gsSalesOrdersDetailsVo);

        // Configure GsSalesOrdersDetailsMapper.saleOrderListCountquery(...).
        final GsSalesOrdersDetailsVo gsSalesOrdersDetailsVo1 = new GsSalesOrdersDetailsVo();
        gsSalesOrdersDetailsVo1.setIds(0);
        gsSalesOrdersDetailsVo1.setIdss(0);
        gsSalesOrdersDetailsVo1.setDetailId(0);
        gsSalesOrdersDetailsVo1.setId(0);
        gsSalesOrdersDetailsVo1.setGoodsId(0);
        gsSalesOrdersDetailsVo1.setPrice(new BigDecimal("0.00"));
        gsSalesOrdersDetailsVo1.setRemark("remark");
        gsSalesOrdersDetailsVo1.setFactory("factory");
        gsSalesOrdersDetailsVo1.setGsSalesOrders("gsSalesOrders");
        gsSalesOrdersDetailsVo1.setCustomer("customer");
        gsSalesOrdersDetailsVo1.setCbpb10("cbpb10");
        gsSalesOrdersDetailsVo1.setQty(0.0);
        gsSalesOrdersDetailsVo1.setInQty(0.0);
        gsSalesOrdersDetailsVo1.setRemainNum(0.0);
        gsSalesOrdersDetailsVo1.setIsFinish("NO");
        final List<GsSalesOrdersDetailsVo> gsSalesOrdersDetailsVos = Arrays.asList(gsSalesOrdersDetailsVo1);
        when(mockGsSalesOrdersDetailsMapper.saleOrderListCountquery(new GsSalesOrdersDetailsDto2()))
                .thenReturn(gsSalesOrdersDetailsVos);

        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());

        // Run the test
        final List<GsSalesOrdersDetailsVo> result = countQueryServiceImplUnderTest.saleOrderListCountquery(
                gsSalesOrdersDetailsDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSaleOrderListCountquery_GsSalesOrdersDetailsMapperReturnsNoItems() {
        // Setup
        final GsSalesOrdersDetailsDto2 gsSalesOrdersDetailsDto = new GsSalesOrdersDetailsDto2();
        gsSalesOrdersDetailsDto.setId(0);
        gsSalesOrdersDetailsDto.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsSalesOrdersDetailsDto.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        gsSalesOrdersDetailsDto.setCustomerId(0);
        gsSalesOrdersDetailsDto.setSupplierId(0);
        gsSalesOrdersDetailsDto.setSalerId(0);
        gsSalesOrdersDetailsDto.setCbpb12("cbpb12");

        when(mockGsSalesOrdersDetailsMapper.saleOrderListCountquery(new GsSalesOrdersDetailsDto2()))
                .thenReturn(Collections.emptyList());
        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());

        // Run the test
        final List<GsSalesOrdersDetailsVo> result = countQueryServiceImplUnderTest.saleOrderListCountquery(
                gsSalesOrdersDetailsDto);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysummaryquery2() throws Exception {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        final InwuquVo inwuquVo = new InwuquVo();
        inwuquVo.setTotalclassify("cbpa07");
        inwuquVo.setCbpa07("cbpa07");
        inwuquVo.setCala08("cala08");
        inwuquVo.setCbpb12("cbpb12");
        inwuquVo.setCbpb15("cbpb15");
        inwuquVo.setCbpb08("cbpb08");
        inwuquVo.setCbib15(0.0);
        inwuquVo.setLockQty(0.0);
        inwuquVo.setTotallockQty(0.0);
        inwuquVo.setTotalcbib15(0.0);
        inwuquVo.setCbib01(0);
        inwuquVo.setCbib02(0);
        inwuquVo.setCbib08(0);
        inwuquVo.setCbpb10(0);
        inwuquVo.setCbpb14(0);
        final List<InwuquVo> expectedResult = Arrays.asList(inwuquVo);
        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());

        // Configure CbpbMapper.selectGnXs(...).
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
        when(mockCbpbMapper.selectGnXs(new InwuquDto())).thenReturn(cbpbs);

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

        // Run the test
        final List<InwuquVo> result = countQueryServiceImplUnderTest.selectInventorysummaryquery2(inwuquDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysummaryquery2_CbpbMapperReturnsNoItems() throws Exception {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());
        when(mockCbpbMapper.selectGnXs(new InwuquDto())).thenReturn(Collections.emptyList());

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

        // Run the test
        final List<InwuquVo> result = countQueryServiceImplUnderTest.selectInventorysummaryquery2(inwuquDto);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysummaryquery2_OrderDistributionServiceReturnsNull() throws Exception {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        final InwuquVo inwuquVo = new InwuquVo();
        inwuquVo.setTotalclassify("cbpa07");
        inwuquVo.setCbpa07("cbpa07");
        inwuquVo.setCala08("cala08");
        inwuquVo.setCbpb12("cbpb12");
        inwuquVo.setCbpb15("cbpb15");
        inwuquVo.setCbpb08("cbpb08");
        inwuquVo.setCbib15(0.0);
        inwuquVo.setLockQty(0.0);
        inwuquVo.setTotallockQty(0.0);
        inwuquVo.setTotalcbib15(0.0);
        inwuquVo.setCbib01(0);
        inwuquVo.setCbib02(0);
        inwuquVo.setCbib08(0);
        inwuquVo.setCbpb10(0);
        inwuquVo.setCbpb14(0);
        final List<InwuquVo> expectedResult = Arrays.asList(inwuquVo);
        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());

        // Configure CbpbMapper.selectGnXs(...).
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
        when(mockCbpbMapper.selectGnXs(new InwuquDto())).thenReturn(cbpbs);

        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(null);

        // Run the test
        final List<InwuquVo> result = countQueryServiceImplUnderTest.selectInventorysummaryquery2(inwuquDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysummaryquery2_ThrowsInterruptedException() {
        // Setup
        final InwuquDto inwuquDto = new InwuquDto();
        inwuquDto.setTotalclassify("totalclassify");
        inwuquDto.setCbpa07("cbpa07");
        inwuquDto.setCala08("cala08");
        inwuquDto.setCbpb12("cbpb12");
        inwuquDto.setCbpb15("cbpb15");
        inwuquDto.setCbpb08("cbpb08");
        inwuquDto.setCbif09(0.0);
        inwuquDto.setCbwa09("cbwa09");
        inwuquDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuquDto.setLockQty(0.0);
        inwuquDto.setCbpb01(0);
        inwuquDto.setCbpb10(0);
        inwuquDto.setClassId(0);
        inwuquDto.setUserId(0L);
        inwuquDto.setDeptId(0L);

        when(mockBaseCheckService.brandMap()).thenReturn(new HashMap<>());
        when(mockBaseCheckService.classMap()).thenReturn(new HashMap<>());

        // Configure CbpbMapper.selectGnXs(...).
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
        when(mockCbpbMapper.selectGnXs(new InwuquDto())).thenReturn(cbpbs);

        // Configure OrderDistributionService.checkSku(...).
        final QtyMsgVo qtyMsgVo = new QtyMsgVo();
        qtyMsgVo.setGoodsId(0);
        qtyMsgVo.setCanUseNum(0.0);
        qtyMsgVo.setTotalQty(0.0);
        when(mockOrderDistributionService.checkSku(new CheckSkuDo())).thenReturn(qtyMsgVo);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> countQueryServiceImplUnderTest.selectInventorysummaryquery2(inwuquDto));
    }

    @Test
    public void testSelectInventorysummaryquerys2() {
        // Setup
        final InwuqusDto inwuqusDto = new InwuqusDto();
        inwuqusDto.setCbwa09("cbwa09");
        inwuqusDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuqusDto.setCbla09("cbla09");
        inwuqusDto.setCbla09s(new String[]{"cbla09s"});
        inwuqusDto.setCbig09(0);
        inwuqusDto.setCbig10("cbig10");
        inwuqusDto.setCbpb01(0);
        inwuqusDto.setCbpb10(0);
        inwuqusDto.setGroudStatus(0);
        inwuqusDto.setStatus(0);
        inwuqusDto.setDeptId(0L);
        inwuqusDto.setUserId(0L);
        inwuqusDto.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusDto.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        final InwuqusVo inwuqusVo = new InwuqusVo();
        inwuqusVo.setId(0);
        inwuqusVo.setCbwa09("cbwa09");
        inwuqusVo.setCbla09("cbla09");
        inwuqusVo.setCbpa07("cbpa07");
        inwuqusVo.setCala08("cala08");
        inwuqusVo.setCbpb12("cbpb12");
        inwuqusVo.setCbpb08("cbpb08");
        inwuqusVo.setCbpb15("cbpb15");
        inwuqusVo.setSn("sn");
        inwuqusVo.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusVo.setStatus(0);
        inwuqusVo.setGroudStatus(0);
        inwuqusVo.setRepairStatus(0);
        inwuqusVo.setGoodsId(0);
        inwuqusVo.setLocationId(0);
        final List<InwuqusVo> expectedResult = Arrays.asList(inwuqusVo);

        // Configure CbifMapper.selectInventorysummaryquerys(...).
        final InwuqusVo inwuqusVo1 = new InwuqusVo();
        inwuqusVo1.setId(0);
        inwuqusVo1.setCbwa09("cbwa09");
        inwuqusVo1.setCbla09("cbla09");
        inwuqusVo1.setCbpa07("cbpa07");
        inwuqusVo1.setCala08("cala08");
        inwuqusVo1.setCbpb12("cbpb12");
        inwuqusVo1.setCbpb08("cbpb08");
        inwuqusVo1.setCbpb15("cbpb15");
        inwuqusVo1.setSn("sn");
        inwuqusVo1.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusVo1.setStatus(0);
        inwuqusVo1.setGroudStatus(0);
        inwuqusVo1.setRepairStatus(0);
        inwuqusVo1.setGoodsId(0);
        inwuqusVo1.setLocationId(0);
        final List<InwuqusVo> inwuqusVos = Arrays.asList(inwuqusVo1);
        when(mockCbifMapper.selectInventorysummaryquerys(new InwuqusDto())).thenReturn(inwuqusVos);

        // Run the test
        final List<InwuqusVo> result = countQueryServiceImplUnderTest.selectInventorysummaryquerys(inwuqusDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysummaryquerys2_CbifMapperReturnsNoItems() {
        // Setup
        final InwuqusDto inwuqusDto = new InwuqusDto();
        inwuqusDto.setCbwa09("cbwa09");
        inwuqusDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuqusDto.setCbla09("cbla09");
        inwuqusDto.setCbla09s(new String[]{"cbla09s"});
        inwuqusDto.setCbig09(0);
        inwuqusDto.setCbig10("cbig10");
        inwuqusDto.setCbpb01(0);
        inwuqusDto.setCbpb10(0);
        inwuqusDto.setGroudStatus(0);
        inwuqusDto.setStatus(0);
        inwuqusDto.setDeptId(0L);
        inwuqusDto.setUserId(0L);
        inwuqusDto.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusDto.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        when(mockCbifMapper.selectInventorysummaryquerys(new InwuqusDto())).thenReturn(Collections.emptyList());

        // Run the test
        final List<InwuqusVo> result = countQueryServiceImplUnderTest.selectInventorysummaryquerys(inwuqusDto);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectOutInventorysummaryquerys() {
        // Setup
        final InwuqusDto inwuqusDto = new InwuqusDto();
        inwuqusDto.setCbwa09("cbwa09");
        inwuqusDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuqusDto.setCbla09("cbla09");
        inwuqusDto.setCbla09s(new String[]{"cbla09s"});
        inwuqusDto.setCbig09(0);
        inwuqusDto.setCbig10("cbig10");
        inwuqusDto.setCbpb01(0);
        inwuqusDto.setCbpb10(0);
        inwuqusDto.setGroudStatus(0);
        inwuqusDto.setStatus(0);
        inwuqusDto.setDeptId(0L);
        inwuqusDto.setUserId(0L);
        inwuqusDto.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusDto.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        final InwuqusVo2 inwuqusVo2 = new InwuqusVo2();
        inwuqusVo2.setId(0);
        inwuqusVo2.setCbwa09("cbwa09");
        inwuqusVo2.setCbla09("cbla09");
        inwuqusVo2.setCbpa07("cbpa07");
        inwuqusVo2.setCala08("cala08");
        inwuqusVo2.setCbpb12("cbpb12");
        inwuqusVo2.setCbpb08("cbpb08");
        inwuqusVo2.setCbpb15("cbpb15");
        inwuqusVo2.setSn("sn");
        inwuqusVo2.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusVo2.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusVo2.setStatus(0);
        inwuqusVo2.setGroudStatus(0);
        inwuqusVo2.setRepairStatus(0);
        inwuqusVo2.setGoodsId(0);
        final List<InwuqusVo2> expectedResult = Arrays.asList(inwuqusVo2);

        // Configure CbifMapper.selectOutInventorysummaryquerys(...).
        final InwuqusVo2 inwuqusVo21 = new InwuqusVo2();
        inwuqusVo21.setId(0);
        inwuqusVo21.setCbwa09("cbwa09");
        inwuqusVo21.setCbla09("cbla09");
        inwuqusVo21.setCbpa07("cbpa07");
        inwuqusVo21.setCala08("cala08");
        inwuqusVo21.setCbpb12("cbpb12");
        inwuqusVo21.setCbpb08("cbpb08");
        inwuqusVo21.setCbpb15("cbpb15");
        inwuqusVo21.setSn("sn");
        inwuqusVo21.setInTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusVo21.setOutTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusVo21.setStatus(0);
        inwuqusVo21.setGroudStatus(0);
        inwuqusVo21.setRepairStatus(0);
        inwuqusVo21.setGoodsId(0);
        final List<InwuqusVo2> inwuqusVo2s = Arrays.asList(inwuqusVo21);
        when(mockCbifMapper.selectOutInventorysummaryquerys(new InwuqusDto())).thenReturn(inwuqusVo2s);

        // Run the test
        final List<InwuqusVo2> result = countQueryServiceImplUnderTest.selectOutInventorysummaryquerys(inwuqusDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectOutInventorysummaryquerys_CbifMapperReturnsNoItems() {
        // Setup
        final InwuqusDto inwuqusDto = new InwuqusDto();
        inwuqusDto.setCbwa09("cbwa09");
        inwuqusDto.setCbwa09s(new String[]{"cbwa09s"});
        inwuqusDto.setCbla09("cbla09");
        inwuqusDto.setCbla09s(new String[]{"cbla09s"});
        inwuqusDto.setCbig09(0);
        inwuqusDto.setCbig10("cbig10");
        inwuqusDto.setCbpb01(0);
        inwuqusDto.setCbpb10(0);
        inwuqusDto.setGroudStatus(0);
        inwuqusDto.setStatus(0);
        inwuqusDto.setDeptId(0L);
        inwuqusDto.setUserId(0L);
        inwuqusDto.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        inwuqusDto.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        when(mockCbifMapper.selectOutInventorysummaryquerys(new InwuqusDto())).thenReturn(Collections.emptyList());

        // Run the test
        final List<InwuqusVo2> result = countQueryServiceImplUnderTest.selectOutInventorysummaryquerys(inwuqusDto);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysmmaryquerys() {
        // Setup
        final LedgerVo ledgerVo = new LedgerVo();
        ledgerVo.setCbwa09("cbwa09");
        ledgerVo.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        ledgerVo.setCbib17("cbib17");
        ledgerVo.setCbib03("cbib03");
        ledgerVo.setCbib06("cbib06");
        ledgerVo.setCbpb08("cbpb08");
        ledgerVo.setCbpb12("cbpb12");
        ledgerVo.setCbib09(0.0);
        ledgerVo.setCbib10(0.0);
        ledgerVo.setCbwa11("cbwa11");
        ledgerVo.setCbib11("cbib11");
        ledgerVo.setCbib12(0.0);
        ledgerVo.setCbib13(0.0);
        ledgerVo.setCbib14(0.0);
        ledgerVo.setCbib15(0.0);

        final LedgerVo ledgerVo1 = new LedgerVo();
        ledgerVo1.setCbwa09("cbwa09");
        ledgerVo1.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        ledgerVo1.setCbib17("cbib17");
        ledgerVo1.setCbib03("cbib03");
        ledgerVo1.setCbib06("cbib06");
        ledgerVo1.setCbpb08("cbpb08");
        ledgerVo1.setCbpb12("cbpb12");
        ledgerVo1.setCbib09(0.0);
        ledgerVo1.setCbib10(0.0);
        ledgerVo1.setCbwa11("cbwa11");
        ledgerVo1.setCbib11("cbib11");
        ledgerVo1.setCbib12(0.0);
        ledgerVo1.setCbib13(0.0);
        ledgerVo1.setCbib14(0.0);
        ledgerVo1.setCbib15(0.0);
        final List<LedgerVo> expectedResult = Arrays.asList(ledgerVo1);

        // Configure CbifMapper.selectInventorysmmaryquerys(...).
        final LedgerVo ledgerVo2 = new LedgerVo();
        ledgerVo2.setCbwa09("cbwa09");
        ledgerVo2.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        ledgerVo2.setCbib17("cbib17");
        ledgerVo2.setCbib03("cbib03");
        ledgerVo2.setCbib06("cbib06");
        ledgerVo2.setCbpb08("cbpb08");
        ledgerVo2.setCbpb12("cbpb12");
        ledgerVo2.setCbib09(0.0);
        ledgerVo2.setCbib10(0.0);
        ledgerVo2.setCbwa11("cbwa11");
        ledgerVo2.setCbib11("cbib11");
        ledgerVo2.setCbib12(0.0);
        ledgerVo2.setCbib13(0.0);
        ledgerVo2.setCbib14(0.0);
        ledgerVo2.setCbib15(0.0);
        final List<LedgerVo> ledgerVos = Arrays.asList(ledgerVo2);
        when(mockCbifMapper.selectInventorysmmaryquerys(new LedgerVo())).thenReturn(ledgerVos);

        // Run the test
        final List<LedgerVo> result = countQueryServiceImplUnderTest.selectInventorysmmaryquerys(ledgerVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysmmaryquerys_CbifMapperReturnsNoItems() {
        // Setup
        final LedgerVo ledgerVo = new LedgerVo();
        ledgerVo.setCbwa09("cbwa09");
        ledgerVo.setCbib04(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        ledgerVo.setCbib17("cbib17");
        ledgerVo.setCbib03("cbib03");
        ledgerVo.setCbib06("cbib06");
        ledgerVo.setCbpb08("cbpb08");
        ledgerVo.setCbpb12("cbpb12");
        ledgerVo.setCbib09(0.0);
        ledgerVo.setCbib10(0.0);
        ledgerVo.setCbwa11("cbwa11");
        ledgerVo.setCbib11("cbib11");
        ledgerVo.setCbib12(0.0);
        ledgerVo.setCbib13(0.0);
        ledgerVo.setCbib14(0.0);
        ledgerVo.setCbib15(0.0);

        when(mockCbifMapper.selectInventorysmmaryquerys(new LedgerVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<LedgerVo> result = countQueryServiceImplUnderTest.selectInventorysmmaryquerys(ledgerVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysmsmaryquerys() throws Exception {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        final OccupancyVo occupancyVo1 = new OccupancyVo();
        occupancyVo1.setCboa07("cboa07");
        occupancyVo1.setCbca08("cbca08");
        occupancyVo1.setCboa25("cboa25");
        occupancyVo1.setCbpa07("cbpa07");
        occupancyVo1.setCala08("cala08");
        occupancyVo1.setCbpb12("cbpb12");
        occupancyVo1.setLockQty(0.0);
        occupancyVo1.setCbob09(0.0);
        occupancyVo1.setCbob10(0.0);
        occupancyVo1.setCbob15(0.0);
        occupancyVo1.setCbpb01(0);
        occupancyVo1.setCboa01(0);
        occupancyVo1.setCbob01(0);
        occupancyVo1.setMax(0);
        occupancyVo1.setMin(0);
        final List<OccupancyVo> expectedResult = Arrays.asList(occupancyVo1);

        // Configure CbifMapper.selectInventorysmsmaryquerys(...).
        final OccupancyVo occupancyVo2 = new OccupancyVo();
        occupancyVo2.setCboa07("cboa07");
        occupancyVo2.setCbca08("cbca08");
        occupancyVo2.setCboa25("cboa25");
        occupancyVo2.setCbpa07("cbpa07");
        occupancyVo2.setCala08("cala08");
        occupancyVo2.setCbpb12("cbpb12");
        occupancyVo2.setLockQty(0.0);
        occupancyVo2.setCbob09(0.0);
        occupancyVo2.setCbob10(0.0);
        occupancyVo2.setCbob15(0.0);
        occupancyVo2.setCbpb01(0);
        occupancyVo2.setCboa01(0);
        occupancyVo2.setCbob01(0);
        occupancyVo2.setMax(0);
        occupancyVo2.setMin(0);
        final List<OccupancyVo> occupancyVos = Arrays.asList(occupancyVo2);
        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(occupancyVos);

        // Configure CbodMapper.selectByExample(...).
        final Cbod cbod = new Cbod();
        cbod.setCbod01(0);
        cbod.setCbod02(0);
        cbod.setCbod03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod04(0);
        cbod.setCbod05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod06(0);
        cbod.setCbod07(0);
        cbod.setCbod08(0);
        cbod.setCbod09(0.0);
        cbod.setCbod10(0.0);
        cbod.setCbod11(0.0);
        cbod.setCbod12(0.0);
        cbod.setCbod13("cbod13");
        cbod.setCbod14(0.0);
        cbod.setBefQty(0.0);
        final List<Cbod> cbods = Arrays.asList(cbod);
        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(cbods);

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryquerys(occupancyVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysmsmaryquerys_CbifMapperReturnsNoItems() throws Exception {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(Collections.emptyList());

        // Configure CbodMapper.selectByExample(...).
        final Cbod cbod = new Cbod();
        cbod.setCbod01(0);
        cbod.setCbod02(0);
        cbod.setCbod03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod04(0);
        cbod.setCbod05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod06(0);
        cbod.setCbod07(0);
        cbod.setCbod08(0);
        cbod.setCbod09(0.0);
        cbod.setCbod10(0.0);
        cbod.setCbod11(0.0);
        cbod.setCbod12(0.0);
        cbod.setCbod13("cbod13");
        cbod.setCbod14(0.0);
        cbod.setBefQty(0.0);
        final List<Cbod> cbods = Arrays.asList(cbod);
        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(cbods);

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryquerys(occupancyVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysmsmaryquerys_CbodMapperReturnsNull() throws Exception {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        final OccupancyVo occupancyVo1 = new OccupancyVo();
        occupancyVo1.setCboa07("cboa07");
        occupancyVo1.setCbca08("cbca08");
        occupancyVo1.setCboa25("cboa25");
        occupancyVo1.setCbpa07("cbpa07");
        occupancyVo1.setCala08("cala08");
        occupancyVo1.setCbpb12("cbpb12");
        occupancyVo1.setLockQty(0.0);
        occupancyVo1.setCbob09(0.0);
        occupancyVo1.setCbob10(0.0);
        occupancyVo1.setCbob15(0.0);
        occupancyVo1.setCbpb01(0);
        occupancyVo1.setCboa01(0);
        occupancyVo1.setCbob01(0);
        occupancyVo1.setMax(0);
        occupancyVo1.setMin(0);
        final List<OccupancyVo> expectedResult = Arrays.asList(occupancyVo1);

        // Configure CbifMapper.selectInventorysmsmaryquerys(...).
        final OccupancyVo occupancyVo2 = new OccupancyVo();
        occupancyVo2.setCboa07("cboa07");
        occupancyVo2.setCbca08("cbca08");
        occupancyVo2.setCboa25("cboa25");
        occupancyVo2.setCbpa07("cbpa07");
        occupancyVo2.setCala08("cala08");
        occupancyVo2.setCbpb12("cbpb12");
        occupancyVo2.setLockQty(0.0);
        occupancyVo2.setCbob09(0.0);
        occupancyVo2.setCbob10(0.0);
        occupancyVo2.setCbob15(0.0);
        occupancyVo2.setCbpb01(0);
        occupancyVo2.setCboa01(0);
        occupancyVo2.setCbob01(0);
        occupancyVo2.setMax(0);
        occupancyVo2.setMin(0);
        final List<OccupancyVo> occupancyVos = Arrays.asList(occupancyVo2);
        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(occupancyVos);

        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(null);

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryquerys(occupancyVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysmsmaryquerys_CbodMapperReturnsNoItems() throws Exception {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        // Configure CbifMapper.selectInventorysmsmaryquerys(...).
        final OccupancyVo occupancyVo1 = new OccupancyVo();
        occupancyVo1.setCboa07("cboa07");
        occupancyVo1.setCbca08("cbca08");
        occupancyVo1.setCboa25("cboa25");
        occupancyVo1.setCbpa07("cbpa07");
        occupancyVo1.setCala08("cala08");
        occupancyVo1.setCbpb12("cbpb12");
        occupancyVo1.setLockQty(0.0);
        occupancyVo1.setCbob09(0.0);
        occupancyVo1.setCbob10(0.0);
        occupancyVo1.setCbob15(0.0);
        occupancyVo1.setCbpb01(0);
        occupancyVo1.setCboa01(0);
        occupancyVo1.setCbob01(0);
        occupancyVo1.setMax(0);
        occupancyVo1.setMin(0);
        final List<OccupancyVo> occupancyVos = Arrays.asList(occupancyVo1);
        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(occupancyVos);

        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryquerys(occupancyVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysmsmaryquerys_ThrowsInterruptedException() {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        // Configure CbifMapper.selectInventorysmsmaryquerys(...).
        final OccupancyVo occupancyVo1 = new OccupancyVo();
        occupancyVo1.setCboa07("cboa07");
        occupancyVo1.setCbca08("cbca08");
        occupancyVo1.setCboa25("cboa25");
        occupancyVo1.setCbpa07("cbpa07");
        occupancyVo1.setCala08("cala08");
        occupancyVo1.setCbpb12("cbpb12");
        occupancyVo1.setLockQty(0.0);
        occupancyVo1.setCbob09(0.0);
        occupancyVo1.setCbob10(0.0);
        occupancyVo1.setCbob15(0.0);
        occupancyVo1.setCbpb01(0);
        occupancyVo1.setCboa01(0);
        occupancyVo1.setCbob01(0);
        occupancyVo1.setMax(0);
        occupancyVo1.setMin(0);
        final List<OccupancyVo> occupancyVos = Arrays.asList(occupancyVo1);
        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(occupancyVos);

        // Configure CbodMapper.selectByExample(...).
        final Cbod cbod = new Cbod();
        cbod.setCbod01(0);
        cbod.setCbod02(0);
        cbod.setCbod03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod04(0);
        cbod.setCbod05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod06(0);
        cbod.setCbod07(0);
        cbod.setCbod08(0);
        cbod.setCbod09(0.0);
        cbod.setCbod10(0.0);
        cbod.setCbod11(0.0);
        cbod.setCbod12(0.0);
        cbod.setCbod13("cbod13");
        cbod.setCbod14(0.0);
        cbod.setBefQty(0.0);
        final List<Cbod> cbods = Arrays.asList(cbod);
        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(cbods);

        // Run the test
        assertThrows(InterruptedException.class,
                () -> countQueryServiceImplUnderTest.selectInventorysmsmaryquerys(occupancyVo));
    }

    @Test
    public void testSelectInvntorysmsmaryquerys() {
        // Setup
        final OccuspancyVo occuspancyVo = new OccuspancyVo();
        occuspancyVo.setCboa07("cboa07");
        occuspancyVo.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        occuspancyVo.setCbca08("cbca08");
        occuspancyVo.setCaua17("caua17");
        occuspancyVo.setCala08("cala08");
        occuspancyVo.setCbpa08("cbpa08");
        occuspancyVo.setCbpb12("cbpb12");
        occuspancyVo.setCbob09(0.0);
        occuspancyVo.setCbob10(0.0);
        occuspancyVo.setNum(0.0);
        occuspancyVo.setCbob11(0.0);
        occuspancyVo.setCbob12(0.0);
        occuspancyVo.setCbpb01(0);
        occuspancyVo.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        occuspancyVo.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        final OccuspancyVo occuspancyVo1 = new OccuspancyVo();
        occuspancyVo1.setCboa07("cboa07");
        occuspancyVo1.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        occuspancyVo1.setCbca08("cbca08");
        occuspancyVo1.setCaua17("caua17");
        occuspancyVo1.setCala08("cala08");
        occuspancyVo1.setCbpa08("cbpa08");
        occuspancyVo1.setCbpb12("cbpb12");
        occuspancyVo1.setCbob09(0.0);
        occuspancyVo1.setCbob10(0.0);
        occuspancyVo1.setNum(0.0);
        occuspancyVo1.setCbob11(0.0);
        occuspancyVo1.setCbob12(0.0);
        occuspancyVo1.setCbpb01(0);
        occuspancyVo1.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        occuspancyVo1.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<OccuspancyVo> expectedResult = Arrays.asList(occuspancyVo1);

        // Configure CbifMapper.selectInvntorysmsmaryquerys(...).
        final OccuspancyVo occuspancyVo2 = new OccuspancyVo();
        occuspancyVo2.setCboa07("cboa07");
        occuspancyVo2.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        occuspancyVo2.setCbca08("cbca08");
        occuspancyVo2.setCaua17("caua17");
        occuspancyVo2.setCala08("cala08");
        occuspancyVo2.setCbpa08("cbpa08");
        occuspancyVo2.setCbpb12("cbpb12");
        occuspancyVo2.setCbob09(0.0);
        occuspancyVo2.setCbob10(0.0);
        occuspancyVo2.setNum(0.0);
        occuspancyVo2.setCbob11(0.0);
        occuspancyVo2.setCbob12(0.0);
        occuspancyVo2.setCbpb01(0);
        occuspancyVo2.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        occuspancyVo2.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<OccuspancyVo> occuspancyVos = Arrays.asList(occuspancyVo2);
        when(mockCbifMapper.selectInvntorysmsmaryquerys(new OccuspancyVo())).thenReturn(occuspancyVos);

        // Run the test
        final List<OccuspancyVo> result = countQueryServiceImplUnderTest.selectInvntorysmsmaryquerys(occuspancyVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInvntorysmsmaryquerys_CbifMapperReturnsNoItems() {
        // Setup
        final OccuspancyVo occuspancyVo = new OccuspancyVo();
        occuspancyVo.setCboa07("cboa07");
        occuspancyVo.setCboa08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        occuspancyVo.setCbca08("cbca08");
        occuspancyVo.setCaua17("caua17");
        occuspancyVo.setCala08("cala08");
        occuspancyVo.setCbpa08("cbpa08");
        occuspancyVo.setCbpb12("cbpb12");
        occuspancyVo.setCbob09(0.0);
        occuspancyVo.setCbob10(0.0);
        occuspancyVo.setNum(0.0);
        occuspancyVo.setCbob11(0.0);
        occuspancyVo.setCbob12(0.0);
        occuspancyVo.setCbpb01(0);
        occuspancyVo.setStartTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        occuspancyVo.setEndTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        when(mockCbifMapper.selectInvntorysmsmaryquerys(new OccuspancyVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<OccuspancyVo> result = countQueryServiceImplUnderTest.selectInvntorysmsmaryquerys(occuspancyVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInntorysummaryquery() {
        // Setup
        final OutofstockregistrationVo outofstockregistrationVo = new OutofstockregistrationVo();
        outofstockregistrationVo.setCbpa08("cbpa08");
        outofstockregistrationVo.setCbpa07("cbpa07");
        outofstockregistrationVo.setCala08("cala08");
        outofstockregistrationVo.setCbpb12("cbpb12");
        outofstockregistrationVo.setCbpb15("cbpb15");
        outofstockregistrationVo.setCbpb08("cbpb08");
        outofstockregistrationVo.setCbof09(0.0);
        outofstockregistrationVo.setTotalmum(0.0);
        outofstockregistrationVo.setCbca08("cbca08");
        outofstockregistrationVo.setCboe08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        outofstockregistrationVo.setCbpb01(0);

        final OutofstockregistrationVo outofstockregistrationVo1 = new OutofstockregistrationVo();
        outofstockregistrationVo1.setCbpa08("cbpa08");
        outofstockregistrationVo1.setCbpa07("cbpa07");
        outofstockregistrationVo1.setCala08("cala08");
        outofstockregistrationVo1.setCbpb12("cbpb12");
        outofstockregistrationVo1.setCbpb15("cbpb15");
        outofstockregistrationVo1.setCbpb08("cbpb08");
        outofstockregistrationVo1.setCbof09(0.0);
        outofstockregistrationVo1.setTotalmum(0.0);
        outofstockregistrationVo1.setCbca08("cbca08");
        outofstockregistrationVo1.setCboe08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        outofstockregistrationVo1.setCbpb01(0);
        final List<OutofstockregistrationVo> expectedResult = Arrays.asList(outofstockregistrationVo1);

        // Configure CbifMapper.selectInntorysummaryquery(...).
        final OutofstockregistrationVo outofstockregistrationVo2 = new OutofstockregistrationVo();
        outofstockregistrationVo2.setCbpa08("cbpa08");
        outofstockregistrationVo2.setCbpa07("cbpa07");
        outofstockregistrationVo2.setCala08("cala08");
        outofstockregistrationVo2.setCbpb12("cbpb12");
        outofstockregistrationVo2.setCbpb15("cbpb15");
        outofstockregistrationVo2.setCbpb08("cbpb08");
        outofstockregistrationVo2.setCbof09(0.0);
        outofstockregistrationVo2.setTotalmum(0.0);
        outofstockregistrationVo2.setCbca08("cbca08");
        outofstockregistrationVo2.setCboe08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        outofstockregistrationVo2.setCbpb01(0);
        final List<OutofstockregistrationVo> outofstockregistrationVos = Arrays.asList(outofstockregistrationVo2);
        when(mockCbifMapper.selectInntorysummaryquery(new OutofstockregistrationVo()))
                .thenReturn(outofstockregistrationVos);

        // Run the test
        final List<OutofstockregistrationVo> result = countQueryServiceImplUnderTest.selectInntorysummaryquery(
                outofstockregistrationVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInntorysummaryquery_CbifMapperReturnsNoItems() {
        // Setup
        final OutofstockregistrationVo outofstockregistrationVo = new OutofstockregistrationVo();
        outofstockregistrationVo.setCbpa08("cbpa08");
        outofstockregistrationVo.setCbpa07("cbpa07");
        outofstockregistrationVo.setCala08("cala08");
        outofstockregistrationVo.setCbpb12("cbpb12");
        outofstockregistrationVo.setCbpb15("cbpb15");
        outofstockregistrationVo.setCbpb08("cbpb08");
        outofstockregistrationVo.setCbof09(0.0);
        outofstockregistrationVo.setTotalmum(0.0);
        outofstockregistrationVo.setCbca08("cbca08");
        outofstockregistrationVo.setCboe08(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        outofstockregistrationVo.setCbpb01(0);

        when(mockCbifMapper.selectInntorysummaryquery(new OutofstockregistrationVo()))
                .thenReturn(Collections.emptyList());

        // Run the test
        final List<OutofstockregistrationVo> result = countQueryServiceImplUnderTest.selectInntorysummaryquery(
                outofstockregistrationVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInnorysummaryquery() {
        // Setup
        final SczddVo sczddVo = new SczddVo();
        sczddVo.setCbba07("cbba07");
        sczddVo.setCala08("cala08");
        sczddVo.setCbpb12("cbpb12");
        sczddVo.setCbpb08("cbpb08");
        sczddVo.setCbba09(0.0);
        sczddVo.setCbba11(0.0);
        sczddVo.setCbba13(0.0);
        sczddVo.setProducedNum(0.0);
        sczddVo.setStockoutNum(0.0);
        sczddVo.setCbba14(0.0);
        sczddVo.setCbba12(0);
        sczddVo.setTotalOrderNum(0.0);
        sczddVo.setTotaldeliver(0.0);
        sczddVo.setTotalproducedNum(0.0);
        sczddVo.setTotalstockoutNum(0.0);

        final SczddVo sczddVo1 = new SczddVo();
        sczddVo1.setCbba07("cbba07");
        sczddVo1.setCala08("cala08");
        sczddVo1.setCbpb12("cbpb12");
        sczddVo1.setCbpb08("cbpb08");
        sczddVo1.setCbba09(0.0);
        sczddVo1.setCbba11(0.0);
        sczddVo1.setCbba13(0.0);
        sczddVo1.setProducedNum(0.0);
        sczddVo1.setStockoutNum(0.0);
        sczddVo1.setCbba14(0.0);
        sczddVo1.setCbba12(0);
        sczddVo1.setTotalOrderNum(0.0);
        sczddVo1.setTotaldeliver(0.0);
        sczddVo1.setTotalproducedNum(0.0);
        sczddVo1.setTotalstockoutNum(0.0);
        final List<SczddVo> expectedResult = Arrays.asList(sczddVo1);

        // Configure CbifMapper.selectInntoryummaryquery(...).
        final SczddVo sczddVo2 = new SczddVo();
        sczddVo2.setCbba07("cbba07");
        sczddVo2.setCala08("cala08");
        sczddVo2.setCbpb12("cbpb12");
        sczddVo2.setCbpb08("cbpb08");
        sczddVo2.setCbba09(0.0);
        sczddVo2.setCbba11(0.0);
        sczddVo2.setCbba13(0.0);
        sczddVo2.setProducedNum(0.0);
        sczddVo2.setStockoutNum(0.0);
        sczddVo2.setCbba14(0.0);
        sczddVo2.setCbba12(0);
        sczddVo2.setTotalOrderNum(0.0);
        sczddVo2.setTotaldeliver(0.0);
        sczddVo2.setTotalproducedNum(0.0);
        sczddVo2.setTotalstockoutNum(0.0);
        final List<SczddVo> sczddVos = Arrays.asList(sczddVo2);
        when(mockCbifMapper.selectInntoryummaryquery(new SczddVo())).thenReturn(sczddVos);

        // Run the test
        final List<SczddVo> result = countQueryServiceImplUnderTest.selectInnorysummaryquery(sczddVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInnorysummaryquery_CbifMapperReturnsNoItems() {
        // Setup
        final SczddVo sczddVo = new SczddVo();
        sczddVo.setCbba07("cbba07");
        sczddVo.setCala08("cala08");
        sczddVo.setCbpb12("cbpb12");
        sczddVo.setCbpb08("cbpb08");
        sczddVo.setCbba09(0.0);
        sczddVo.setCbba11(0.0);
        sczddVo.setCbba13(0.0);
        sczddVo.setProducedNum(0.0);
        sczddVo.setStockoutNum(0.0);
        sczddVo.setCbba14(0.0);
        sczddVo.setCbba12(0);
        sczddVo.setTotalOrderNum(0.0);
        sczddVo.setTotaldeliver(0.0);
        sczddVo.setTotalproducedNum(0.0);
        sczddVo.setTotalstockoutNum(0.0);

        when(mockCbifMapper.selectInntoryummaryquery(new SczddVo())).thenReturn(Collections.emptyList());

        // Run the test
        final List<SczddVo> result = countQueryServiceImplUnderTest.selectInnorysummaryquery(sczddVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testGetDataTable() {
        // Setup
        // Run the test
        final TableDataInfo result = countQueryServiceImplUnderTest.getDataTable(Arrays.asList("value"));

        // Verify the results
    }

    @Test
    public void testSelectInventorysmsmaryqueryss() {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
       /* occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);
*/
        final OccupancyVo occupancyVo1 = new OccupancyVo();
        /*occupancyVo1.setCboa07("cboa07");
        occupancyVo1.setCbca08("cbca08");
        occupancyVo1.setCboa25("cboa25");
        occupancyVo1.setCbpa07("cbpa07");
        occupancyVo1.setCala08("cala08");
        occupancyVo1.setCbpb12("cbpb12");
        occupancyVo1.setLockQty(0.0);
        occupancyVo1.setCbob09(0.0);
        occupancyVo1.setCbob10(0.0);
        occupancyVo1.setCbob15(0.0);
        occupancyVo1.setCbpb01(0);
        occupancyVo1.setCboa01(0);
        occupancyVo1.setCbob01(0);
        occupancyVo1.setMax(0);
        occupancyVo1.setMin(0);*/
        /*final List<OccupancyVo> expectedResult = Arrays.asList(occupancyVo1);

        // Configure CboaMapper.selectid(...).
        final Id id = new Id();
        id.setId(0);
        final List<Id> ids = Arrays.asList(id);
        when(mockCboaMapper.selectid()).thenReturn(ids);

        // Configure CbifMapper.selectInventorysmsmaryquerys(...).
        final OccupancyVo occupancyVo2 = new OccupancyVo();
        occupancyVo2.setCboa07("cboa07");
        occupancyVo2.setCbca08("cbca08");
        occupancyVo2.setCboa25("cboa25");
        occupancyVo2.setCbpa07("cbpa07");
        occupancyVo2.setCala08("cala08");
        occupancyVo2.setCbpb12("cbpb12");
        occupancyVo2.setLockQty(0.0);
        occupancyVo2.setCbob09(0.0);
        occupancyVo2.setCbob10(0.0);
        occupancyVo2.setCbob15(0.0);
        occupancyVo2.setCbpb01(0);
        occupancyVo2.setCboa01(0);
        occupancyVo2.setCbob01(0);
        occupancyVo2.setMax(0);
        occupancyVo2.setMin(0);
        final List<OccupancyVo> occupancyVos = Arrays.asList(occupancyVo2);
        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(occupancyVos);

        // Configure CbodMapper.selectByExample(...).
        final Cbod cbod = new Cbod();
        cbod.setCbod01(0);
        cbod.setCbod02(0);
        cbod.setCbod03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod04(0);
        cbod.setCbod05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod06(0);
        cbod.setCbod07(0);
        cbod.setCbod08(0);
        cbod.setCbod09(0.0);
        cbod.setCbod10(0.0);
        cbod.setCbod11(0.0);
        cbod.setCbod12(0.0);
        cbod.setCbod13("cbod13");
        cbod.setCbod14(0.0);
        cbod.setBefQty(0.0);
        final List<Cbod> cbods = Arrays.asList(cbod);
        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(cbods);*/

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryqueryss(occupancyVo);

        // Verify the results
     //   assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysmsmaryqueryss_CboaMapperReturnsNoItems() {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        when(mockCboaMapper.selectid()).thenReturn(Collections.emptyList());

        // Configure CbifMapper.selectInventorysmsmaryquerys(...).
        final OccupancyVo occupancyVo1 = new OccupancyVo();
        occupancyVo1.setCboa07("cboa07");
        occupancyVo1.setCbca08("cbca08");
        occupancyVo1.setCboa25("cboa25");
        occupancyVo1.setCbpa07("cbpa07");
        occupancyVo1.setCala08("cala08");
        occupancyVo1.setCbpb12("cbpb12");
        occupancyVo1.setLockQty(0.0);
        occupancyVo1.setCbob09(0.0);
        occupancyVo1.setCbob10(0.0);
        occupancyVo1.setCbob15(0.0);
        occupancyVo1.setCbpb01(0);
        occupancyVo1.setCboa01(0);
        occupancyVo1.setCbob01(0);
        occupancyVo1.setMax(0);
        occupancyVo1.setMin(0);
        final List<OccupancyVo> occupancyVos = Arrays.asList(occupancyVo1);
        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(occupancyVos);

        // Configure CbodMapper.selectByExample(...).
        final Cbod cbod = new Cbod();
        cbod.setCbod01(0);
        cbod.setCbod02(0);
        cbod.setCbod03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod04(0);
        cbod.setCbod05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod06(0);
        cbod.setCbod07(0);
        cbod.setCbod08(0);
        cbod.setCbod09(0.0);
        cbod.setCbod10(0.0);
        cbod.setCbod11(0.0);
        cbod.setCbod12(0.0);
        cbod.setCbod13("cbod13");
        cbod.setCbod14(0.0);
        cbod.setBefQty(0.0);
        final List<Cbod> cbods = Arrays.asList(cbod);
        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(cbods);

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryqueryss(occupancyVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysmsmaryqueryss_CbifMapperReturnsNoItems() {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        // Configure CboaMapper.selectid(...).
        final Id id = new Id();
        id.setId(0);
        final List<Id> ids = Arrays.asList(id);
        when(mockCboaMapper.selectid()).thenReturn(ids);

        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(Collections.emptyList());

        // Configure CbodMapper.selectByExample(...).
        final Cbod cbod = new Cbod();
        cbod.setCbod01(0);
        cbod.setCbod02(0);
        cbod.setCbod03(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod04(0);
        cbod.setCbod05(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cbod.setCbod06(0);
        cbod.setCbod07(0);
        cbod.setCbod08(0);
        cbod.setCbod09(0.0);
        cbod.setCbod10(0.0);
        cbod.setCbod11(0.0);
        cbod.setCbod12(0.0);
        cbod.setCbod13("cbod13");
        cbod.setCbod14(0.0);
        cbod.setBefQty(0.0);
        final List<Cbod> cbods = Arrays.asList(cbod);
        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(cbods);

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryqueryss(occupancyVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testSelectInventorysmsmaryqueryss_CbodMapperReturnsNull() {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        final OccupancyVo occupancyVo1 = new OccupancyVo();
        occupancyVo1.setCboa07("cboa07");
        occupancyVo1.setCbca08("cbca08");
        occupancyVo1.setCboa25("cboa25");
        occupancyVo1.setCbpa07("cbpa07");
        occupancyVo1.setCala08("cala08");
        occupancyVo1.setCbpb12("cbpb12");
        occupancyVo1.setLockQty(0.0);
        occupancyVo1.setCbob09(0.0);
        occupancyVo1.setCbob10(0.0);
        occupancyVo1.setCbob15(0.0);
        occupancyVo1.setCbpb01(0);
        occupancyVo1.setCboa01(0);
        occupancyVo1.setCbob01(0);
        occupancyVo1.setMax(0);
        occupancyVo1.setMin(0);
        final List<OccupancyVo> expectedResult = Arrays.asList(occupancyVo1);

        // Configure CboaMapper.selectid(...).
        final Id id = new Id();
        id.setId(0);
        final List<Id> ids = Arrays.asList(id);
        when(mockCboaMapper.selectid()).thenReturn(ids);

        // Configure CbifMapper.selectInventorysmsmaryquerys(...).
        final OccupancyVo occupancyVo2 = new OccupancyVo();
        occupancyVo2.setCboa07("cboa07");
        occupancyVo2.setCbca08("cbca08");
        occupancyVo2.setCboa25("cboa25");
        occupancyVo2.setCbpa07("cbpa07");
        occupancyVo2.setCala08("cala08");
        occupancyVo2.setCbpb12("cbpb12");
        occupancyVo2.setLockQty(0.0);
        occupancyVo2.setCbob09(0.0);
        occupancyVo2.setCbob10(0.0);
        occupancyVo2.setCbob15(0.0);
        occupancyVo2.setCbpb01(0);
        occupancyVo2.setCboa01(0);
        occupancyVo2.setCbob01(0);
        occupancyVo2.setMax(0);
        occupancyVo2.setMin(0);
        final List<OccupancyVo> occupancyVos = Arrays.asList(occupancyVo2);
        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(occupancyVos);

        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(null);

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryqueryss(occupancyVo);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSelectInventorysmsmaryqueryss_CbodMapperReturnsNoItems() {
        // Setup
        final OccupancyVo occupancyVo = new OccupancyVo();
        occupancyVo.setCboa07("cboa07");
        occupancyVo.setCbca08("cbca08");
        occupancyVo.setCboa25("cboa25");
        occupancyVo.setCbpa07("cbpa07");
        occupancyVo.setCala08("cala08");
        occupancyVo.setCbpb12("cbpb12");
        occupancyVo.setLockQty(0.0);
        occupancyVo.setCbob09(0.0);
        occupancyVo.setCbob10(0.0);
        occupancyVo.setCbob15(0.0);
        occupancyVo.setCbpb01(0);
        occupancyVo.setCboa01(0);
        occupancyVo.setCbob01(0);
        occupancyVo.setMax(0);
        occupancyVo.setMin(0);

        // Configure CboaMapper.selectid(...).
        final Id id = new Id();
        id.setId(0);
        final List<Id> ids = Arrays.asList(id);
        when(mockCboaMapper.selectid()).thenReturn(ids);

        // Configure CbifMapper.selectInventorysmsmaryquerys(...).
        final OccupancyVo occupancyVo1 = new OccupancyVo();
        occupancyVo1.setCboa07("cboa07");
        occupancyVo1.setCbca08("cbca08");
        occupancyVo1.setCboa25("cboa25");
        occupancyVo1.setCbpa07("cbpa07");
        occupancyVo1.setCala08("cala08");
        occupancyVo1.setCbpb12("cbpb12");
        occupancyVo1.setLockQty(0.0);
        occupancyVo1.setCbob09(0.0);
        occupancyVo1.setCbob10(0.0);
        occupancyVo1.setCbob15(0.0);
        occupancyVo1.setCbpb01(0);
        occupancyVo1.setCboa01(0);
        occupancyVo1.setCbob01(0);
        occupancyVo1.setMax(0);
        occupancyVo1.setMin(0);
        final List<OccupancyVo> occupancyVos = Arrays.asList(occupancyVo1);
        when(mockCbifMapper.selectInventorysmsmaryquerys(new OccupancyVo())).thenReturn(occupancyVos);

        when(mockCbodMapper.selectByExample(any(CbodCriteria.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<OccupancyVo> result = countQueryServiceImplUnderTest.selectInventorysmsmaryqueryss(occupancyVo);

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }
}
