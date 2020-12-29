package com.security.jwt.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.jwt.entity.SystemUser;
import com.security.jwt.util.JwtUtils;
import com.security.jwt.util.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 * @author BaryLeo
 */
@Component("systemAuthenticationSuccessHandler")
public class SystemAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SystemUserDetail systemUserDetail = (SystemUserDetail) authentication.getPrincipal();
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setHeader("jwt",jwtUtils.generateJsonWebToken(systemUserDetail));
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(ResultResponse.success("登陆成功")));

    }
}
