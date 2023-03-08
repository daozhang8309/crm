package com.powernode.crm.commons.domain;
/*
    使用实体类存储响应信息
 */
public class ReturnObject {
    private String code;//网页响应成功或失败的标记 1是成功，0是失败
    private String message;//提示信息
    private Object retData;//其他数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }
}
