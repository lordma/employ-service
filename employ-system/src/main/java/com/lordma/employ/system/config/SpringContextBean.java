package com.lordma.employ.system.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author lordma
 * @Date 2020/5/26 10:47
 * @Version 1.0
 */
@Component
public class SpringContextBean implements ApplicationContextAware {
    private static ApplicationContext context = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    @SuppressWarnings("unchecked")
    public static<T> T getBean(String name){
        T bean = (T)context.getBean(name);
        return bean;
    }
    public static <T> T getBean(Class<T> beanClass) {

        return context.getBean(beanClass);
    }
}
