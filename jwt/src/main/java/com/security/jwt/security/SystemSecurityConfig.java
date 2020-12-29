package com.security.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * 配置Security的拦截路径
 * @author BaryLeo
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//保证post之前的注解可以使用
public class SystemSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler systemAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler systemAuthenticationFailureHandler;

    @Autowired
    private LogoutSuccessHandler systemLogoutSuccessHandler;

    @Autowired
    private SystemLoginUrlAuthenticationEntryPoint systemLoginUrlAuthenticationEntryPoint;

    @Autowired
    private SessionRegistry sessionRegistry;
    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //该路径得页面不需要权限即可访问
                .loginPage("/api/login")
                .usernameParameter("userID")
                .passwordParameter("password")
                .successHandler(systemAuthenticationSuccessHandler)
                .failureHandler(systemAuthenticationFailureHandler)
                .and() //  定义当需要用户登录时候，转到的登录页面。
                .authorizeRequests()// 定义哪些URL需要被保护、哪些不需要被保护
                //该路径得文件不需要权限即可访问
                .antMatchers("/","/api/login","/index","/static/**",
                        "/swagger-ui.html","/webjars/springfox-swagger-ui/**","/swagger-resources","/swagger-resources/**","/v2/api-docs","/csrf",
                        "/api/open/**","/api/error/**","/api/doc","/api/mail/**").permitAll()
                // 任何请求,登录后可以访问
                .anyRequest()
                .authenticated()
                .and()
                .cors()
                .and()
                //关闭跨域请求防护功能,前后端分离必须要有
                .csrf().disable()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessHandler(systemLogoutSuccessHandler)
                //设置未登录状态时的状态码
                .and().exceptionHandling().authenticationEntryPoint(systemLoginUrlAuthenticationEntryPoint)
                //定制我们自己的 session 策略：调整为让 Spring Security 不创建和使用 session
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher(){
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }


    /**
     * 使自己编写的密码加密器生效
     * @return SystemPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new SystemPasswordEncoder();
    }

    /**
     * 允许访问静态资源，并且允许校验本地缓存，防止重新请求静态资源
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");//修改为添加而不是设置，* 最好改为实际的需要，我这是非生产配置，所以粗暴了一点
        configuration.addAllowedMethod("*");//修改为添加而不是设置
        configuration.addAllowedHeader("*");//这里很重要，起码需要允许 Access-Control-Allow-Origin
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    public SessionRegistry getSessionRegistry(){
        return sessionRegistry;
    }
}
