package com.example.kmyc.result;

import java.util.Date;

/**
 * 前端统一返回的数据
 */
public class Result {
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 数据
     */
    private Object data;

    /**
     * uri路径
     */
    private String path;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", path='" + path + '\'' +
                '}';
    }

    public Result(Integer code, Object data, String path) {
        this.code = code;
        this.data = data;
        this.path = path;
    }
}
