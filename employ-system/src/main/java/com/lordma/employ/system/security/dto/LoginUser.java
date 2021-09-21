package com.lordma.employ.system.security.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/5/5 9:21
 * @Version 1.0
 */
@ApiModel(value = "LoginUser对象", description = "用户登录信息")
public class LoginUser {
    @ApiModelProperty(value = "用户账号", required = true, dataType = "String", notes = "账号长度范围应该在2-32位之间。")
    @Size(min=2,max=32,message="账号长度不正确")
    private String loginAccount;
    @ApiModelProperty(value = "用户密码", required = true, dataType = "String")
    private String loginPassword;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
