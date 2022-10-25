package com.ims.security;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionKey = ObjectUtils.toString(request.getSession().getAttribute("sessionKey"));
        if(StringUtils.isEmpty(sessionKey)){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return true;
    }
}
