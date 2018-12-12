package com.litte;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LitteInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //只有返回true才会继续向下执行，返回false取消当前请求
        if(httpServletRequest.getSession().getAttribute("user") != null) {
            //System.out.println("登录成功");
            return true;
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login");
            return false;
        }


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //httpServletResponse.sendRedirect("/login");
        //System.out.println("myinterc posthandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        //System.out.println("myinterc aftercompletion");
    }

}
