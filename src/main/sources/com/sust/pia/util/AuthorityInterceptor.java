package com.sust.pia.util;

import com.sust.pia.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Package com.sust.pia.util
 * @Description 权限拦截器
 * @Author Haodong Zhao
 * @Datetime 2019/7/4 16:24
 */
public class AuthorityInterceptor implements HandlerInterceptor {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    // 不需要拦截的请求
    private static final String[] IGNORE_URI = {"/user/login", "/user/logout",
            "/user/isRegistered", "/user/register", "/index.html",
            "/vendor/js", "/register.html", "/vendor/css", "/vendor/img"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {


        boolean flag = false; // 默认用户没有登录
        String servletPath = request.getServletPath(); // 获得请求的ServletPath
        log.debug("SERVER[AuthorityInterceptor] ServletPath: " + servletPath);
        String requestUri = request.getRequestURI(); //请求完整路径，可用于登陆后跳转
        String contextPath = request.getContextPath();  //项目下完整路径
        String url = requestUri.substring(contextPath.length()); //请求页面
        log.debug("SERVER[AuthorityInterceptor] Request Uri: " + requestUri);
        log.debug("SERVER[AuthorityInterceptor] Url: " + url);

        //判断请求是否需要拦截
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                log.debug("SERVER[AuthorityInterceptor] do not intercept");
                return true;
            }
        }

        log.debug("=======SERVER[AuthorityInterceptor] intercept");
        User user = (User) request.getSession().getAttribute("userObj");
        if (user == null) {
            log.debug("SERVER[AuthorityInterceptor] do not find user");
            log.debug("SERVER[AuthorityInterceptor] to " + "index.html");
            //request.getRequestDispatcher("/index.html").forward(request, response);
            response.sendRedirect(contextPath + "/index.html");
        } else {
            log.debug("SERVER[AuthorityInterceptor] Get User: " + user.toString());
            flag = true;
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
