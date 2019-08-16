package com.api.enums;

public enum ResponseCode {


    RESPONSE_STATUS_CODE_200(200,"响应成功"),RESPONSE_STATUS_CODE_500(500,"服务器错误");
    private ResponseCode(Integer value,String name){
        this.value = value;
        this.name = name;
    }
    private final Integer value;
    private final String name;
    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


}
