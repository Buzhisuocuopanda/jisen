package com.ruoyi.common.core.domain;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;

import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author ruoyi
 */
public class AjaxResult<T> extends HashMap<String, Object>
{

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult()
    {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     */
    public AjaxResult(int code, String msg)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AjaxResult(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static AjaxResult success(Object data)
    {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static AjaxResult error()
    {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(int code, String msg)
    {
        return new AjaxResult(code, msg, null);
    }



    /**
     * 方便链式调用
     *
     * @param key 键
     * @param value 值
     * @return 数据对象
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
    private Long errcode;
    private String errmsg;
    private T data;
    private String traceId;
    AjaxResult(final Long errcode, final String errmsg, final T data, final String traceId) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
        this.traceId = traceId;
    }
    public static class AjaxResultBuilder<T> {
        private Long errcode;
        private String errmsg;
        private T data;
        private String traceId;

        AjaxResultBuilder() {
        }

        public AjaxResultBuilder<T> errcode(final Long errcode) {
            this.errcode = errcode;
            return this;
        }

        public AjaxResultBuilder<T> errmsg(final String errmsg) {
            this.errmsg = errmsg;
            return this;
        }

        public AjaxResultBuilder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public AjaxResultBuilder<T> traceId(final String traceId) {
            this.traceId = traceId;
            return this;
        }

        public AjaxResult<TableDataInfo> build() {
            return new AjaxResult(this.errcode, this.errmsg, this.data, this.traceId);
        }

        public String toString() {
            return "ResponseResult.AjaxResultBuilder(errcode=" + this.errcode + ", errmsg=" + this.errmsg + ", data=" + this.data + ", traceId=" + this.traceId + ")";
        }
    }

    public static <T> AjaxResultBuilder<T> builder() {
        return new AjaxResultBuilder();
    }

}
