package com.lordma.employ.common.base;


public enum  ResponseConstant {

    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 异常
     */
    FAILED(500, "系统错误"),
    /**
     * 操作失败
     */
    ERROR(90000000, "操作失败"),
    /**
     * 未登录/token过期
     */
    UNAUTHORIZED(90000002, "登录超时"),
    /**
     * 参数错误
     */
    PARAM_ERROR(90000003, "参数错误"),
    /**
     * 验证码错误
     */
    INVALID_RE_VCODE(10000011, "验证码错误"),
    /**
     * 用户名或密码错误
     */
    INVALID_USERNAME_PASSWORD(10000003, "账号或密码错误"),
    /**
     *
     */
    INVALID_RE_PASSWORD(10000010, "两次输入密码不一致"),
    /**
     * 用户名或密码错误
     */
    INVALID_PASSWORD(10000009, "旧密码错误"),
    /**
     * 用户名重复
     */
    USERNAME_ALREADY_IN(10000002, "用户已存在"),
    /**
     * 用户不存在
     */
    INVALID_USER(10000001, "用户不存在"),
    /**
     * 角色不存在
     */
    INVALID_ROLE(10000004, "角色不存在"),
    /**
     * 角色不存在
     */
    ROLE_USER_USED(10000008, "角色使用中，不可删除"),
    /**
     * 参数错误-已存在
     */
    INVALID_PARAM_EXIST(10000005, "请求参数已存在"),
    /**
     * 参数错误
     */
    INVALID_PARAM_EMPTY(10000006, "请求参数为空"),
    /**
     * 没有权限
     */
    USER_NO_PERMITION(10000007, "当前用户无该接口权限");

    public int resultCode;
    public String message;

    ResponseConstant(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
