
package com.lordma.employ.system.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lordma.employ.common.annotation.auth.CurrentUser;
import com.lordma.employ.common.base.Constant;
import com.lordma.employ.common.base.Result;
import com.lordma.employ.common.base.component.JwtComponent;
import com.lordma.employ.system.entity.Staff;
import com.lordma.employ.system.security.dto.LoginUser;
import com.lordma.employ.system.service.IStaffService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@Api(value = "LoginController|登录鉴权相关的前端控制器")
public class LoginController {

    @Autowired
    private JwtComponent jwtComponent;

    @Autowired
    private IStaffService staffService;

    @PostMapping("login")
    public Result<JSONObject> login(@RequestBody LoginUser loginUser){
        QueryWrapper<Staff> ew = new QueryWrapper<Staff>();
        ew.eq("login_name", loginUser.getLoginAccount()).eq("password", loginUser.getLoginPassword());
        Staff staff = staffService.getOne(ew);
        String token = jwtComponent.sign(staff.getLoginName(), staff.getPassword(), Constant.ExpTimeType.WEB);
        JSONObject json = new JSONObject();
        json.put("token", token);
        return new Result<JSONObject>().success().put(json);
    }
    @GetMapping("user/info")
    public Result<Staff> getUserInfo(HttpServletRequest request, @ApiIgnore @CurrentUser Staff staff){
        return new Result<Staff>().success().put(staff);
    }

    @PostMapping("logout")
    public Result<?> logOut(HttpServletRequest request){
        return new Result<>().success();
    }
}
