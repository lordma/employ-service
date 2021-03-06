package com.lordma.employ.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lordma
 */
@ApiModel("响应类")
@Data
public class Result<T> {

    @ApiModelProperty(value ="响应代码 200:success;<br>500:系统错误;<br>90000000:操作失败;<br>90000002:未登录/token过期;<br>90000003:参数错误;<br>10000011:验证码错误;<br>10000007:当前用户无该接口权限")
    private int code;
    @ApiModelProperty(value="提示信息")
    private String message;
    @ApiModelProperty(value="返回数据")
    private T data;

    /**
     * 返回成功
     */
    public Result<T> success() {
        return success("操作成功！");
    }

    /**
     * 返回成功
     */
    public Result<T> success(String message) {
        return success(200, message);
    }

    /**
     * 返回成功
     */
    public Result<T> success(ResponseConstant constant) {
        return success(constant.getResultCode(), constant.getMessage());
    }

    /**
     * 返回成功
     */
    public Result<T> success(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    /**
     * 返回失败
     */
    public Result<T> error() {
        return error("操作失败！");
    }

    /**
     * 返回失败
     */
    public Result<T> error(String message) {
        return error(500, message);
    }

    /**
     * 返回失败
     */
    public  Result<T> error(int code, String message) {
        return success(code, message);
    }

    /**
     * 返回信息
     */
    public  Result<T> error(ResponseConstant constant) {
        return success(constant.getResultCode(), constant.getMessage());
    }
    /**
     * 放入object
     */
    public Result<T> put(T object) {
        this.setData(object);
        return this;
    }

}
