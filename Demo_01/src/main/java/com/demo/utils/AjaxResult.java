package com.demo.utils;
/*
* 操作返回结果类
* */
public class AjaxResult{

    //操作是否成功
    private boolean success=true;
    //返回的信息
    private String msg;

    @Override
    public String toString(){
        return "AjaxResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }
    public boolean isLog(){
        return success;
    }

    public AjaxResult setLog(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg(){
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public static AjaxResult getAjaxResult(){
        return new AjaxResult();
    }

}
