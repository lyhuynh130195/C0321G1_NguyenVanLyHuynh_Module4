package com.codegym.model.service.impl;

import com.codegym.model.entity.User;
import com.codegym.model.repository.UserRepository;
import com.codegym.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
