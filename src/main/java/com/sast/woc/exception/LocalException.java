package com.sast.woc.exception;

import com.sast.woc.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LocalException extends RuntimeException{

    @ExceptionHandler
    public Result<String> doException(Exception exception){
        exception.printStackTrace();
        return Result.error("服务器问题，请稍后再试");
    }

}
