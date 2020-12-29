package com.security.jwt.util;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 作为统一的返回格式
 * @author BaryLeo
 */
public class ResultResponse implements Serializable {
    private Integer resultCode;

    private String message;

    private Object ObjData;

    public ResultResponse(){}

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObjData() {
        return ObjData;
    }

    public void setObjData(Object objData) {
        ObjData = objData;
    }

    /**
     * 返回成功
     * @return
     */
    public static ResultResponse success(){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultCode(ResultCode.SUCCESS.getCode());
        resultResponse.setMessage(ResultCode.SUCCESS.getMessage());
        return resultResponse;
    }

    /**
     * 返回带对象数据的JSON
     * @param objData
     * @return
     */
    public static ResultResponse success(Object objData){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultCode(ResultCode.SUCCESS.getCode());
        resultResponse.setMessage(ResultCode.SUCCESS.getMessage());
        resultResponse.setObjData(objData);
        return resultResponse;
    }

    /**
     * 返回失败
     */
    public static ResultResponse failure(HttpServletResponse httpServletResponse, ResultCode resultCode){
        httpServletResponse.setStatus(403);
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultCode(resultCode.getCode());
        resultResponse.setMessage(resultCode.getMessage());
        return resultResponse;
    }

    /**
     * 返回失败带对象数据的JSON
     */
    public static ResultResponse failure(HttpServletResponse httpServletResponse, ResultCode resultCode, Object objData){
        httpServletResponse.setStatus(403);
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultCode(resultCode.getCode());
        resultResponse.setMessage(resultCode.getMessage());
        resultResponse.setObjData(objData);
        return resultResponse;
    }

    /**
     * 返回失败带对象数据的JSON
     */
    public static ResultResponse convince(ResultCode resultCode){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultCode(resultCode.getCode());
        resultResponse.setMessage(resultCode.getMessage());
        return resultResponse;
    }

    /**
     *自定义错误返回信息
     */
    public static ResultResponse error(HttpServletResponse httpServletResponse, String message){
        httpServletResponse.setStatus(403);
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultCode(0);
        resultResponse.setMessage(message);
        return resultResponse;
    }

    public static ResultResponse success(HttpServletResponse httpServletResponse, String message){
        httpServletResponse.setStatus(200);
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultCode(1);
        resultResponse.setMessage(message);
        return resultResponse;
    }


}
