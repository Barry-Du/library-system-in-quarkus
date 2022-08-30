package com.library.common.model;

public enum ResponseErrorCode {

    SUCCESS(100000, "success"),

    INTERNAL_ERROR(101000, "internal error"),
    DATA_NOT_FOUND(101001, "data not found"),
    AUTH_FAILED(101002, "authentication failed"),
    NO_MORE_BOOK(101003, "This Book has No More"),
    NO_ENOUGH_CREDIT(101004, "not enough reader credit"),
    ALREADY_LOGIN(101005, "This Reader Had Login Already"),
    PHONE_NUMBER_WRONG(10106, "Phone Number Is Wrong"),
    RETURN_BOOK_OverDate(10107, "The Book You Return Is OverDate"),
    ALREADY_HAD_SAME_BOOK_ID(10108, "This BookId Already Have"),
    DO_NOT_HAVE_THIS_BOOK(10109, "Do Not Have This Book"),
    DO_NOT_HAVE_THIS_READER(101100, "Do Not Have This Reader");

    private int code;
    private String msg;

    ResponseErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseErrorCode getByCode(int code) {
        for (ResponseErrorCode errorCode : ResponseErrorCode.values()) {
            if (errorCode.code == code) {
                return errorCode;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "[" + code + ", " + msg + "]";
    }
}
