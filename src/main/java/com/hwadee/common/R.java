package com.hwadee.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局对象返回类
 */
@Data
public class R {

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 返回消息
     */
    @ApiModelProperty(value = "返回消息")
    private String message;
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private R() {
    };

    /**
     * 默认成功方法
     * @return
     */
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    /**
     * 失败方法
     * @return
     */
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    /**
     * 自定义设置成功的方法
     * @param success
     * @return
     */
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    /**
     * 自定义设置返回消息的方法
     * @param message
     * @return
     */
    public R message(String message){
        this.setMessage(message);
        return  this;
    }

    /**
     * 自定义设置状态码的方法
     * @param code
     * @return
     */
    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    /**
     * 设置返回数据 key，value
     * @param key
     * @param value
     * @return
     */
    public R data(String key,String value){
        this.data.put(key,value);
        return this;
    }

    /**
     * 设置整体数据返回
     * @param data
     * @return
     */
    public R data(Map<String, Object> data){
        this.setData(data);
        return this;
    }
}
