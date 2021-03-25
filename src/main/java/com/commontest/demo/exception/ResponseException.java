package com.commontest.demo.exception;

import com.commontest.demo.common.CommonResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Cristianoxm
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public final class ResponseException extends RuntimeException {
    private String errorCode;
    private String errorMsg;
}