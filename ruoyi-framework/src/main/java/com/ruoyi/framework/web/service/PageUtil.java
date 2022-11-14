package com.ruoyi.framework.web.service;

public class PageUtil {
        public static Integer[] getPageAndPageSize(Integer allCount,Integer pageNo,Integer pageSize) {
            if (pageNo >= 1 && pageSize >= 1) {
                //第pageNo页 从第(pageNo-1)*pageSize个下标开始往下数
                int maxPage = (allCount % pageSize )== 0 ? (allCount / pageSize) : (allCount / pageSize) + 1;
                if (pageNo >= maxPage) {
                    pageNo = (maxPage - 1) * pageSize;
                } else {
                    pageNo = (pageNo - 1) * pageSize;
                }
                return new Integer[]{pageNo,pageSize};
            }else{
                return null;
            }
        }
    }



