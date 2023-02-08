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
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Map<String, Claim> map = JwtUtil.verifyToken(token);
        Integer isAdmin = map.get("isAdmin").asInt();
        if (isAdmin == 0){
            return true;
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("{\"code\":-1, \"msg\":\"permission denied\", \"data\":null}");
            writer.flush();
            return false;
        }
    }
}
