package com.lordma.employ.system.shiro;

import com.lordma.employ.common.annotation.auth.CurrentUser;
import com.lordma.employ.system.entity.Staff;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/6/3 11:06
 * @Version 1.0
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(Staff.class) && methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Staff staff = (Staff)nativeWebRequest.getAttribute("currentUser", RequestAttributes.SCOPE_REQUEST);
        if (staff == null){
            throw new UnauthorizedException("login user info get failed!");
        }
        return staff;
    }
}
