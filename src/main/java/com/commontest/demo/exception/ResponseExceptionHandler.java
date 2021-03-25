package com.commontest.demo.exception;

import com.commontest.demo.common.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Cristianoxm
 */
@RestControllerAdvice("com.commontest.demo.controller")
public class ResponseExceptionHandler{
    /**
     * 捕捉自定义异常类
     * @param responseException
     * @return
     */
    @ExceptionHandler(ResponseException.class)
    public CommonResult<Void> handleResponseException(ResponseException responseException){
        return CommonResult.errorResult(responseException.getErrorCode(), responseException.getErrorMsg());

    }
}