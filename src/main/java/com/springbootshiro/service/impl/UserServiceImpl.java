package com.springbootshiro.service.impl;


import com.springbootshiro.bean.User;
import com.springbootshiro.repository.UserRepository;
import com.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getCurrentUser() {

        Subject currentUser = SecurityUtils.getSubject();
        User user = null;
        if (currentUser.isAuthenticated() || currentUser.isRemembered()) {
            user = (User) currentUser.getPrincipal();
        }

        return user;

    }
}
