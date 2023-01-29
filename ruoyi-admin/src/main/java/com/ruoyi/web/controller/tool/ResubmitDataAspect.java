package com.ruoyi.web.controller.tool;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.ErrCode;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ResubmitDataAspect {

    private final static String DATA = "data";
    private final static Object PRESENT = new Object();

    @Around("@annotation(com.ruoyi.web.controller.tool.Resubmit)")
    public Object handleResubmit(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //获取注解信息
        Resubmit annotation = method.getAnnotation(Resubmit.class);
        int delaySeconds = annotation.delaySeconds();
        Object[] pointArgs = joinPoint.getArgs();
        String key = "";
        //获取第一个参数
        Object firstParam = pointArgs[0];
        if (firstParam instanceof AjaxResult) {
            //解析参数
            //解析参数
            JSONObject requestDTO = JSONObject.parseObject(firstParam.toString(), JSONObject.class);
            JSONObject data = JSONObject.parseObject(requestDTO.getString(DATA), JSONObject.class);

            if (data != null) {
                StringBuffer sb = new StringBuffer();
                data.forEach((k, v) -> {
                    sb.append(v);
                });
                //生成加密参数 使用了content_MD5的加密方式
                key = ResubmitLock.handleKey(sb.toString());
            }
        }
        //执行锁
        boolean lock = false;
        try {
            //设置解锁key
            lock = ResubmitLock.getInstance().lock(key, PRESENT);
            if (lock) {  //如果设置成功
                //放行
                return joinPoint.proceed();
            } else {
                //响应重复提交异常
                return AjaxResult.error((int) ErrCode.UNKNOW_ERROR.getErrCode(), "请勿重复提交");
            }
        } finally {
            //设置解锁key和解锁时间
            ResubmitLock.getInstance().unLock(lock, key, delaySeconds);
        }
    }

    @After("@annotation(com.ruoyi.web.controller.tool.Resubmit)")
    public void printTakeOrderOrder(){
        System.out.println("后置通知");
    }
}

