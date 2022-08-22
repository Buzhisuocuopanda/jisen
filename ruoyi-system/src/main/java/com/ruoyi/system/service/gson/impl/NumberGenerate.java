package com.ruoyi.system.service.gson.impl;

import com.ruoyi.common.enums.NumberGenerateEnum;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Do.NumberDo;
import com.ruoyi.system.domain.vo.NumberVo;
import com.ruoyi.system.mapper.CboaMapper;
import com.ruoyi.system.mapper.CbocMapper;
import com.ruoyi.system.mapper.CbpkMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ClassName NumberGenerate
 * Description
 * Create by gfy
 * Date 2022/8/6 11:18
 */
@Component
public class NumberGenerate {

    @Resource
    private CboaMapper cboaMapper;

    @Resource
    private CbocMapper cbocMapper;

    @Resource
    private CbpkMapper cbpkMapper;


    public NumberVo createOrderNo(NumberDo numberDo){
        NumberVo res=new NumberVo();
        if(NumberGenerateEnum.SALEORDER.getCode().equals(numberDo.getType())){

            res.setOrderNo(getSaleOrderNo());
            return res;

        }else if(NumberGenerateEnum.SALEORDERCHANGE.getCode().equals(numberDo.getType())){
            res.setOrderNo(getSaleOrderChangeNo());
            return res;
        }else if(NumberGenerateEnum.TAKEORDER.getCode().equals(numberDo.getType())){
            res.setOrderNo(getTakeOrderNo());
            return res;
        }

        return res;
    }

    private synchronized String getSaleOrderChangeNo() {
        //拼接规则 PO202208040017 PO +年月日 +四位数数量自增
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        String format = sd.format(new Date());
        String orderNo="OC"+format;
        CbocCriteria example=new CbocCriteria();
        example.createCriteria()
                .andCboc07Like(orderNo+"%");
        List<Cboc> cbocs = cbocMapper.selectByExample(example);
        if(cbocs.size()==0){
            return orderNo+"0001";
        }else {
            Integer num=0;
            for (Cboc cboc : cbocs) {
                Integer no = getNum(cboc.getCboc07(),10);
                if(num<no){
                    num=no;
                }

            }

            return  createOrderNo(orderNo,num);

        }

    }

    private synchronized String getSaleOrderNo() {
        //拼接规则 PO202208040017 OC +年月日 +四位数数量自增
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        String format = sd.format(new Date());
        String orderNo="PO"+format;
        CboaCriteria example=new CboaCriteria();
        example.createCriteria()
                .andCboa07Like(orderNo+"%");
        List<Cboa> cboas = cboaMapper.selectByExample(example);
        if(cboas.size()==0){
            return orderNo+"0001";
        }else {
            Integer num=0;
            for (Cboa cboa : cboas) {
                Integer no = getNum(cboa.getCboa07(),10);
                if(num<no){
                    num=no;
                }

            }

            return  createOrderNo(orderNo,num);

        }

    }

    private synchronized String getTakeOrderNo() {
        //拼接规则 PO202208040017 SP05 +年月日 +四位数数量自增
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        String format = sd.format(new Date());
        String orderNo="OC"+format;
        CbpkCriteria example=new CbpkCriteria();
        example.createCriteria()
                .andCbpk07Like(orderNo+"%");
        List<Cbpk> cbpks = cbpkMapper.selectByExample(example);
        if(cbpks.size()==0){
            return orderNo+"0001";
        }else {
            Integer num=0;
            for (Cbpk res : cbpks) {
                Integer no = getNum(res.getCbpk07(),12);
                if(num<no){
                    num=no;
                }

            }

            return  createOrderNo(orderNo,num);

        }

    }


    private Integer getNum(String orderNo,int index){
        String substring = orderNo.substring(index);
        if(substring.startsWith("000")){
            return Integer.valueOf(substring.substring(3));
        }else if(substring.startsWith("00")){
            return Integer.valueOf(substring.substring(2));
        }else if(substring.startsWith("0")) {
            return Integer.valueOf(substring.substring(1));
        }else {
            return Integer.valueOf(substring.substring(0));
        }
    }


    private String createOrderNo(String orderNo,Integer num){
        String no=String.valueOf(num);
        if(no.length()==4){
            return orderNo+no;
        }else if(no.length()==3){
            return orderNo+"0"+no;
        }else if(no.length()==2){
            return orderNo+"00"+no;
        }else {
            return orderNo+"000"+no;
        }

    }


}
