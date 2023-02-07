package com.sast.woc.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.sast.woc.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            PrintWriter pw = response.getWriter();
            pw.write("{\"code\":-1, \"msg\":\"not login\", \"data\":null}");
            pw.flush();
            return false;
        }
        Map<String, Claim> user = JwtUtil.verifyToken(token);
        if (user == null) {
            PrintWriter pw = response.getWriter();
            pw.write("{\"code\":-1, \"msg\":\"invalid token\", \"data\":null}");
            pw.flush();
            return false;
        }
        return true;

    }
}
