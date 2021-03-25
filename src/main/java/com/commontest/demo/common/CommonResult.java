package com.commontest.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CommonResult<T> {
    private int status = 1;
    private String code = "";
    private String msg = "";
    private T resultBody;
    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }

    /**
     * 统一的成功返回方法
     * @param successCode
     * @param successMsg
     * @param resultBody
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> successResult(String successCode,String successMsg,T resultBody)
    {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.code = successCode;
        commonResult.msg = successMsg;
        commonResult.resultBody=resultBody;
        commonResult.status = 1;
        return commonResult;
    }

    /**
     * 统一处理异常的方法
     * @param errorCode
     * @param errorMsg
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> errorResult(String errorCode, String errorMsg){
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.code = errorCode;
        commonResult.msg = errorMsg;
        commonResult.status = -1;
        return commonResult;
    }
}