package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;

@EnableWebSecurity // 开启WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override// 请求授权规则
    protected void configure(HttpSecurity http) throws Exception {

        // index所有人可以访问
        //add页面只能具有vip1角色访问
       //update页面只能具有vip2角色访问
        http.authorizeRequests().antMatchers("/index").permitAll()
                .antMatchers("/add").hasRole("vip1")
                .antMatchers ( "/update" ).hasRole ( "vip2" );

        //Security内置的登录页
        http.formLogin ();
        //开启记住我功能
        http.rememberMe();
        //开启注销功能
        http.logout ();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //用数据库验证用户
           auth.userDetailsService ( userDetailsService ).passwordEncoder ( password() );

        //自定义用户
   /*  auth.inMemoryAuthentication().passwordEncoder ( new BCryptPasswordEncoder (  ) )
                .withUser("wang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2");*/

    }

    @Bean
    public PasswordEncoder password(){
        //密码加密
        return  new BCryptPasswordEncoder ( );
    }
}
