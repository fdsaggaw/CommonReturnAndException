package com.commontest.demo.exception;

import com.commontest.demo.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    public RestResponseExceptionHandler() {
        super();
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception e, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (e instanceof MissingServletRequestParameterException) {
            return new ResponseEntity(CommonResult.errorResult("400", e.getMessage()), headers, status);
        }
        if (e instanceof NoHandlerFoundException) {
            return new ResponseEntity(CommonResult.errorResult("404", e.getMessage()), headers, status);
        }
        if(e instanceof HttpRequestMethodNotSupportedException){
            return new ResponseEntity(CommonResult.errorResult("405", e.getMessage()), headers, status);
        }
        return new ResponseEntity(CommonResult.errorResult("500", e.getMessage()), headers, status);
    }

}
