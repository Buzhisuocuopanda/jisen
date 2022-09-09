package com.ruoyi.common.utils;

import com.ruoyi.common.exception.ServiceException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * ClassName SystemUtils
 * Description
 * Create by gfy
 * Date 2022/9/9 10:32
 */
public class SystemUtils {

    public static Boolean checkIsLinux() {
            String os = System.getProperty("os.name");
            //Windows操作系统
            if( os != null && os.toLowerCase().startsWith("linux")) {
                return true;
            }  else { //其它操作系统
               return false;
            }

    }
}
