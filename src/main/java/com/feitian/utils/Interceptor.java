package com.feitian.utils;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ReflectPermission;

/**
 * @Author: feitian
 * @Date: 2018-05-02  20:08
 * @description:
 */
public class Interceptor implements HandlerInterceptor {
    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    //return false表示拦截，不向下执行
    //return true表示放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
           HandlerMethod handlerMethod = (HandlerMethod)handler;
            //找目标类上NotCheck注解，有就直接放行
           CheckAnnotation checkAnnotation = handlerMethod.getBeanType().getAnnotation(CheckAnnotation.class);
           if (checkAnnotation != null){
               return true;
           }
           checkAnnotation = handlerMethod.getMethod().getAnnotation(CheckAnnotation.class);
           if (checkAnnotation != null){
                return true;
           }
           Object currUser = Tools.getSession(Constraint.USER);
           if(currUser == null){
               String path = Tools.getAppPath();
               response.sendRedirect(path + "login");
               return true;
           }
        }
        return true;
    }
    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //执行Handler完成 执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}