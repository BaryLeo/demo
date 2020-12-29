package com.security.jwt.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.jwt.util.ResultCode;
import com.security.jwt.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author BaryLeo
 * 设置未登录状态访问其他api时的返回状态码
 */
@Component("systemLoginUrlAuthenticationEntryPoint")
public class SystemLoginUrlAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(996);
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(ResultResponse.failure(httpServletResponse, ResultCode.USER_NOT_LOGGED_IN)));
    }
}
