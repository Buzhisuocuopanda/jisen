package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TravelStrategyFactory {
    private static Map<Integer, Travel> map = new HashMap<>();

    public static void register(Integer code, Travel travel) {
        if (!(code ==null)) {
            map.put(code, travel);
        }
    }

    public static Travel get(Integer code) {
        return map.get(code);
    }
}
