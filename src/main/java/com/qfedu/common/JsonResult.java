package com.qfedu.common;

/**
 * @author Kui
 */
public class JsonResult {
    private int code;   // 1正常 0异常
    private Object info;  // 返回前端数据

    public JsonResult() {
    }

    public JsonResult(int code, Object info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
