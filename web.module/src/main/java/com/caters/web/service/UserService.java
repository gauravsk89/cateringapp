package com.caters.web.service;

import com.caters.web.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);

}
