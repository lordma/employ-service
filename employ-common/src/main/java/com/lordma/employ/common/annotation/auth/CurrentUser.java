package com.lordma.employ.common.annotation.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @ClassName: CurrentUser
 * @Description: 在Controller的方法参数中使用此注解，该方法在映射时会注入当前登录的Staff对象
 * @author lordma
 * @date 2020年6月3日 上午11:17:43
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}
