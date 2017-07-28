package com.surpass.config.security;

import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by surpass.wei@gmail.com on 2017/7/26.
 */
public class CustomUserDetailsService
        //实现UserDetailsService接口，实现loadUserByUsername方法
    /*implements UserDetailsService

    {
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            System.out.println("当前的用户名是："+username);
            //这里我为了方便，就直接返回一个用户信息，实际当中这里修改为查询数据库或者调用服务什么的来获取用户信息
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername("admin");
            userInfo.setName("admin");
            Set<AuthorityInfo> authorities = new HashSet<AuthorityInfo>();
            AuthorityInfo authorityInfo = new AuthorityInfo("TEST");
            authorities.add(authorityInfo);
            userInfo.setAuthorities(authorities);
            return userInfo;
        }*/


        //实现AuthenticationUserDetailsService，实现loadUserDetails方法
        implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

    @Override
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
        System.out.println("当前的用户名是：" + token.getName());
        /*这里我为了方便，就直接返回一个用户信息，实际当中这里修改为查询数据库或者调用服务什么的来获取用户信息*/
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(token.getName());
        userInfo.setName("管理员");
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("R_USER"));
        authorities.add(new SimpleGrantedAuthority("user_read"));
        userInfo.setAuthorities(authorities);
        return userInfo;
    }
}