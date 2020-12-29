package com.security.jwt.util;

/**
 * 枚举类，方便记录准确的错误码
 * @author BaryLeo
 */
public enum  ResultCode {
    /**
     * 成功状态码
     */
    SUCCESS(1,"成功"),
    /**
     * 参数状态码1000-1999
     */
    SERVICE_NOT_ACTIVITY(1000,"服务暂未开启"),
    SERVICE_ERROR(1001,"服务出现错误"),
    //只要是参数方面的问题，都用这个，避免前端过多设置状态码，具体错误由状态码返回提示
    PARAM_ERROR(1002,"参数错误"),


    /**
     * 用户行为状态码2000-2999
     */
    USER_AUTH_ERROR(2000,"权限不足"),
    USER_NOT_LOGGED_IN(2001,"用户未登录，访问页面需要验证，请登录"),
    USER_LOGIN_ERROR(2002,"账号不存在或密码错误"),
    USER_NOT_EXIST(2004,"用户不存在"),
    USER_HAS_EXISTED(2005,"用户已存在"),
    USER_PASSWORD_CHANGE_ERROR(2006,"密码修改失败"),
    USER_FREQUENT_REQUEST(2007,"请求过于频繁");


    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
