package com.example.demo.service;

import com.example.demo.Mapper.personMapper;
import com.example.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyDetailsService implements UserDetailsService {
    @Autowired   //注入mapper配置信息
    private personMapper personMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person showuser = personMapper.showuser ( username );
        System.out.println (showuser );
        if (showuser==null)
        {
            System.out.println ("不存在该用户");
        }


        List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList ( "vip1" );
        return new User ( showuser.getUsername (),new BCryptPasswordEncoder ().encode ( showuser.getPassword ()),auths );
    }
}
