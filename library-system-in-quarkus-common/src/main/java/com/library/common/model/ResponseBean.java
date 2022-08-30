package com.library.common.model;


import java.util.Collection;
import java.util.Map;


public class ResponseBean {

    private int code;

    private String message;

    private Object value;

    public ResponseBean() {
    }

    public ResponseBean(int code, String message) {
        this(code, message, null);
    }

    private ResponseBean(int code, String message, Object value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }

    public static ResponseBean success(Object value) {
        if (value == null) {
            return new ResponseBean(ResponseErrorCode.DATA_NOT_FOUND.getCode(), ResponseErrorCode.DATA_NOT_FOUND.getMsg());
        }
        if (value instanceof Collection) {
            Collection collection = (Collection) value;
            if (collection.isEmpty()) {
                return new ResponseBean(ResponseErrorCode.DATA_NOT_FOUND.getCode(), ResponseErrorCode.DATA_NOT_FOUND.getMsg());
            }
        }
        if (value instanceof Map) {
            Map map = (Map) value;
            if (map.isEmpty()) {
                return new ResponseBean(ResponseErrorCode.DATA_NOT_FOUND.getCode(), ResponseErrorCode.DATA_NOT_FOUND.getMsg());
            }
        }
        return new ResponseBean(ResponseErrorCode.SUCCESS.getCode(), ResponseErrorCode.SUCCESS.getMsg(), value);
    }

    public static ResponseBean internalError() {
        return new ResponseBean(ResponseErrorCode.INTERNAL_ERROR.getCode(), ResponseErrorCode.INTERNAL_ERROR.getMsg());
    }

    public static ResponseBean internalError(String message) {
        return new ResponseBean(ResponseErrorCode.INTERNAL_ERROR.getCode(), ResponseErrorCode.INTERNAL_ERROR.getMsg()
                + " : " + message);
    }

    public static ResponseBean noAuth(String message) {
        return new ResponseBean(ResponseErrorCode.AUTH_FAILED.getCode(), ResponseErrorCode.AUTH_FAILED.getMsg()
                + " : " + message);
    }

    public static ResponseBean notEnoughCredit(String message) {
        return new ResponseBean(ResponseErrorCode.NO_ENOUGH_CREDIT.getCode(), ResponseErrorCode.NO_ENOUGH_CREDIT.getMsg()
                + " : " + message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
