package com.springbootshiro.service;

import com.springbootshiro.bean.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    User getCurrentUser();

}
