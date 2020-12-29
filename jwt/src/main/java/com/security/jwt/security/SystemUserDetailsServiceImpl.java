package com.security.jwt.security;

import com.security.jwt.entity.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BaryLeo
 */
@Component
public class SystemUserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
        SystemUser systemUser = new SystemUser();
        systemUser.setAuth(1);
        systemUser.setUserId("admin");
        systemUser.setPassword("123");
        systemUser.setStatus(1);

        if(systemUser != null){
            if (systemUser.getStatus()==0){
                //如果已被注销，则无法登陆
                return null;
            }

            //权限列表
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            //查库添加权限
            //authorities.add(new SimpleGrantedAuthority(user.getPermTag()));
            logger.info(">>>authorities:{}<<<", authorities);
            //加入权限
            systemUser.setAuthorities(authorities);
            return new SystemUserDetail(systemUser.getUserId(),systemUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(String.valueOf(systemUser.getAuth())),systemUser);
        }
        return null;
    }
}
