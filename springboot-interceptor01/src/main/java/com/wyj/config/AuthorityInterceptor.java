package com.wyj.config;

import com.wyj.session.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wyj
 * @create 2019-06-01 21:54
 */
@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor {

    private static final Set<String> NOT_INTERCEPT_URI = new HashSet<>();//不拦截的URI

    static {
        NOT_INTERCEPT_URI.add("/user/login.html");
        NOT_INTERCEPT_URI.add("/user/login");
    }

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {
        String uri = request.getRequestURI();
        if (NOT_INTERCEPT_URI.contains(uri)) {
            log.info("不拦截" + uri);
            return true;
        }
        log.info("拦截" + uri);
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("user_info_in_the_session");
        if (userInfo == null) {
            throw new RuntimeException("用户未登陆");
        }
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView mv) throws Exception {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
     * （主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object object, Exception ex) throws Exception {
    }
}
