package com.ruoyi.common.utils;



import com.ruoyi.common.exception.ServiceException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.rmi.ServerException;

/***
 * 接口字段校验参数
 * <a href="https://www.jianshu.com/p/67d3637493c7">相关注释使用</a>
 * @Author：ALong  <br>
 * @Date：2020/8/23
 */
public class ValidUtils {

    public static void bindvaild(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return;
        }

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            throw new ServiceException(fieldError.getDefaultMessage());
        }
    }
}
