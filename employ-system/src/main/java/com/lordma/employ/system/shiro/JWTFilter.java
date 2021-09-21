package com.lordma.employ.system.shiro;

import com.lordma.employ.common.base.component.JwtComponent;
import com.lordma.employ.system.config.SpringContextBean;
import com.lordma.employ.system.entity.Staff;
import com.lordma.employ.system.service.IStaffService;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/5/26 10:13
 * @Version 1.0
 */
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JwtComponent jwtComponent;

    @Autowired
    private IStaffService staffService;

    /**
     * 判断用户是否想要登入。 检测header里面是否包含Authorization字段即可
     */
    @Override
    protected  boolean isLoginAttempt(ServletRequest request, ServletResponse response){
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Employ-Token");
        return authorization != null && !"".equals(authorization);
    }
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception{
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Employ-Token");
        JWTToken token = new JWTToken(authorization);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token);
        // 如果没有抛出异常则代表登入成功，返回true
        setUserBean(request, response, token);
        return true;
    }
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        if(isLoginAttempt(request, response)){
            try{
                // 执行登录
                executeLogin(request, response);
                Subject subject = getSubject(request, response);
                String[] perms = (String[])mappedValue;
                boolean isPermitted = true;
                if (perms != null && perms.length > 0){
                    if (!subject.isPermittedAll(perms)){
                        isPermitted = false;
                    }
                }
                return isPermitted;
            } catch (Exception e){
                e.printStackTrace();
                responseTimeOut(request, response);
            }

        }
        return true;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException{
        response401(request, response);
        return false;
    }


    private void setUserBean(ServletRequest request, ServletResponse response, JWTToken token){
        if(this.staffService == null){
            this.staffService = SpringContextBean.getBean(IStaffService.class);
        }
        String loginAccount = jwtComponent.getUserAccount(String.valueOf(token.getCredentials()));
        Staff staff = staffService.queryUserByAccount(loginAccount);
        request.setAttribute("currentUser", staff);
    }
    /**
     * 将非法请求跳转到 /401
     */
    private void response401(ServletRequest request, ServletResponse response) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("/auth/401");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 超时跳转
     * @param request
     * @param response
     */
    private void responseTimeOut(ServletRequest request, ServletResponse response){
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("/auth/timeout");
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

}
