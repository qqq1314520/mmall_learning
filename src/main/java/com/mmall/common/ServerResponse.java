package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * 扩展类对象
 * 由于构造方法私有化，向外部暴露的接口 就写成了static类型的
 */

//@JsonSerialize当json返回数据中，有的键没有值，则键也不返回
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;//向前端返回的状态
    private String msg;//向前端返回的信息
    private T data;//具体的实体类

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    /**
     * 是不是一个正确的响应
     * 0 正确
     * @return
     * @JsonIgnore  在json数据中不会显示isSuccess()字段，安全性考虑
     */
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    /**
     * 获取status
     * @return
     */
    public int getStatus(){
        return status;
    }
    /**
     * 获取data
     * @return
     */
    public T getData(){
        return data;
    }
    /**
     * 获取msg
     * @return
     */
    public String getMsg(){
        return msg;
    }

    /**
     * 请求成功创建一个ServerResponse扩展类对象
     * 传入的参数不同，调用不同的构造方法
     * @return ServerResponse对象
     */
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    /**
     * 通过msg创建一个ServerResponse扩展类对象
     * @return ServerResponse对象
     */
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    /**
     * 请求失败创建一个ServerResponse扩展类对象
     * @return ServerResponse对象
     */
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    /**
     * 通过errorMessage创建一个ServerResponse扩展类对象
     * @return ServerResponse对象
     */
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }

}
