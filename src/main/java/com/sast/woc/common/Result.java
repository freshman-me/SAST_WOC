package com.sast.woc.common;

import lombok.Data;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
public class Result<T> {
    // 状态码，1 成功 0 失败
    private Integer code;
    // 记录错误信息
    private String msg;
    // 数据
    private T data;

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.code = 1;
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(String msg){
        Result<T> result = new Result<>();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
