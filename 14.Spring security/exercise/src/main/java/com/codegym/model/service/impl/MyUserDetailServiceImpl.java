package com.codegym.model.service.impl;


import com.codegym.model.entity.MyUserDetail;
import com.codegym.model.entity.User;
import com.codegym.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username);

       if(user==null){
           throw new UsernameNotFoundException("not found user");
       }
       return new MyUserDetail(user);
    }
}
