package com.commontest.demo.config;
import com.commontest.demo.annotation.NoResponseAdvice;
import com.commontest.demo.common.CommonResult;
import com.commontest.demo.enums.StatusAndMsg;
import com.commontest.demo.exception.ResponseException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

@EnableWebMvc
@Configuration
public class UnifiedReturnConfig {
    @RestControllerAdvice("com.commontest.demo.controller")
    static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {
        /**
         * supports方法是来给定条件判断是否该调用beforeBodyWrite，MethodParameter里面有各种数据
         * @param methodParameter
         * @param aClass
         * @return
         */
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            boolean isIntercept = true;
            Method method = methodParameter.getMethod();
            assert method != null;
//          不拦截@NoResponseAdvice接口
            AnnotatedElement annotatedElement = methodParameter.getAnnotatedElement();
            NoResponseAdvice noResponseAdvice = AnnotationUtils.findAnnotation(annotatedElement, NoResponseAdvice.class);
            if(noResponseAdvice!=null){
                isIntercept = false;
            }
            return isIntercept;
        }

        /**
         * 定义自己返回的数据结构体
         * @param body 准备处理的返回数据
         * @param methodParameter 控制层返回的数据结构类型
         * @param mediaType 通过内容协商选择内容类型
         * @param aClass 选择要写入响应的转换器类型
         * @param serverHttpRequest 当前请求对象
         * @param serverHttpResponse 返回对象
         * @return 传入或修改(可能是新实例)的主体
         */
        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            //若是CommonResult类型，直接返回，否则封装后再返回
            if (body instanceof CommonResult){
                return body;
            }
            return CommonResult.successResult(StatusAndMsg.SUCCESS.getCode(),StatusAndMsg.SUCCESS.getMsg(),body);
        }
    }
}