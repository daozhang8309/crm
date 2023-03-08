package com.powernode.crm.settings.web.interceptor;

import com.powernode.crm.commons.contants.Contants;
import com.powernode.crm.settings.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //登录验证
        //没有登录成功
        //重写的方法，session不能通过参数传入
        //从请求里
        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute(Contants.SESSION_USER);
        if (user==null){
            //跳转到登录页面,重定向            动态获取项目路径
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
            //结束执行
            return false;
        }
        //登录成功，继续执行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
