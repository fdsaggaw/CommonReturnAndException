package com.commontest.demo.enums;

import lombok.Data;

public enum StatusAndMsg {
    SUCCESS("200", "SUCCESS"),
    METHODFAIL("2000", "ENCOUNTER AN ERROR WHEN EXECUTE METHOD"),
    UNKNOWEXCEPTION("3000", "THIS IS AN UNKNOW EXCEPTION"),
    ERROR404("404","There was an unexpected error (type=Bad Request, status=400)"),
    ERROR500("500","There was an unexpected error (type=Internal Server Error, status=500)");

    private String code;
    private String msg;

    StatusAndMsg(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
