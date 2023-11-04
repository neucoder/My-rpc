package com.example.rpc_server.result;

import com.example.rpc_server.domain.User;

import java.io.Serializable;

public class ApiResult<T> implements Serializable {
    //uid
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiResult() {
    }

    public ApiResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ApiResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResult<User> success(User user) {
        ApiResult<User> result = new ApiResult<>();
        result.code = 200;
        result.message = "success";
        result.data = user;
        return result;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
