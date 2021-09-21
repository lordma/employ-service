package com.lordma.employ.system.shiro;

import com.alibaba.fastjson.JSONObject;
import com.lordma.employ.common.base.component.JwtComponent;
import com.lordma.employ.system.config.SpringContextBean;
import com.lordma.employ.system.entity.Staff;
import com.lordma.employ.system.service.IStaffService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/5/28 12:45
 * @Version 1.0
 */
public class JWTRealm extends AuthorizingRealm {

    @Autowired
    private JwtComponent jwtComponent;

    @Autowired
    private IStaffService staffService;

    /**
     * 表示此Realm只支持JWTToken类型
     */
    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JWTToken;
    }
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (null == staffService){
            this.staffService = SpringContextBean.getBean(IStaffService.class);
        }
        String token = (String)authenticationToken.getCredentials();
        String loginAccount = jwtComponent.getUserAccount(token);
        if (loginAccount == null){
            throw new UnauthorizedException("token invalid");
        }
        Staff staff = staffService.queryUserByAccount(loginAccount);
        if (staff == null){
            throw new UnauthorizedException("Staff didn't existed!");
        }
        if (!jwtComponent.verify(token, loginAccount, staff.getPassword())){
            throw new UnauthorizedException("Staff or PassWord error");
        }

        String userString = JSONObject.toJSONString(staff);

        return new SimpleAuthenticationInfo(userString, token, this.getName());
    }
}
