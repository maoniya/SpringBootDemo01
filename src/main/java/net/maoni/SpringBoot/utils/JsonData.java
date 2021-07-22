package net.maoni.SpringBoot.utils;

import lombok.Data;

/**
 * 接口返回的工具类
 */
@Data
public class JsonData {
    private int code;
    private Object data;
    private String msg;
    public JsonData(){}
    public JsonData(int code,Object data){
        this.code=code;
        this.data=data;
    }

    public JsonData(int code,Object data,String msg){
        this.code=code;
        this.data=data;
        this.msg=msg;
    }

    public static JsonData  buildSuccess(Object data){
        return new JsonData(0,data);
    }

    public static JsonData buildError(String msg){
        return new JsonData(-1,"",msg);
    }
    public static JsonData buildError(String msg,int code){
        return new JsonData(code,"",msg);
    }
}
