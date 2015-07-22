package com.tw.core.interceptor;

import com.tw.core.util.Utils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) {

        if (request.getServletPath().startsWith("/login")) {
            return true;
        }

        if (Utils.isLogin(request)) {
            return true;
        }

        try {
            Cookie cookie = new Cookie("previous_page", request.getServletPath());
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() + "/login");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
