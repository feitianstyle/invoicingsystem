package com.feitian.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: feitian
 * @Date: 2018-04-26  15:44
 * @description:
 */
public class Tools {
    public static void setSession(String name, Object value) {
        RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
        if (ra != null) {
            ra.setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getSession(String name) {
        RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
        if (ra != null) {
            return (T)ra.getAttribute(name, RequestAttributes.SCOPE_SESSION);
        }
        return null;
    }

    public static String getAppPath() {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        if (sra == null) {
            return null;
        }
        HttpServletRequest request = sra.getRequest();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    }
}