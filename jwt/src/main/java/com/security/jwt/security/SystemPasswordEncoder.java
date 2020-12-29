package com.security.jwt.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 重写密码加密器，不对密码进行加密
 * @author BaryLeo
 */
public class SystemPasswordEncoder extends BCryptPasswordEncoder {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 去除加密处理
     * @param charSequence
     * @return String
     */
    @Override
    public String encode(CharSequence charSequence) {
        //不做任何加密处理
        return charSequence.toString();
    }

    /**
     * 将前端传来的登录密码与数据库查询到的密码进行对比
     * @param charSequence
     * @param s
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        //charSequence是前端传过来的密码，s是数据库中查到的密码
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean result = charSequence.toString().equals(s);
        return result;
    }
}
