package com.qinweizhao.auth.service.impl;


import com.qinweizhao.auth.entity.MyUserDetails;
import com.qinweizhao.auth.service.MyUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author qinweizhao
 * @since 2022/11/22
 */
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username:" + username);
        return new MyUserDetails();
    }
}
