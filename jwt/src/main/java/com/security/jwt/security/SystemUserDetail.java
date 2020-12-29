package com.security.jwt.security;

import com.security.jwt.entity.SystemUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * @author BaryLeo
 */
public class SystemUserDetail extends User {

    private SystemUser systemUser;

    public SystemUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, SystemUser systemUser) {
        this(username, password, true, true, true, true, authorities);
        this.systemUser = systemUser;
    }

    public SystemUserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }
}
