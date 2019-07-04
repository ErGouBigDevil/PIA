package com.sust.pia.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Package com.sust.pia.util
 * @Description 权限拦截器
 * @Author Haodong Zhao
 * @Datetime 2019/7/4 16:24
 */
public class AuthorityInterceptor implements HandlerInterceptor {
    // 不需要拦截的请求
    private static final String[] IGNORE_URI = {"/user/login", "/user/logout", "/user/isRegistered", "/user/register", "/index.html"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        /** 默认用户没有登录 */
        boolean flag = false;
        /** 获得请求的ServletPath */
        String servletPath = request.getServletPath();
        /**  判断请求是否需要拦截 */
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            String username = (String) request.getSession().getAttribute("username");
            if (username == null) {
                request.getRequestDispatcher("/index.html").forward(request, response);
                return flag;
            } else {
                flag = true;
            }
        }
        return flag;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
