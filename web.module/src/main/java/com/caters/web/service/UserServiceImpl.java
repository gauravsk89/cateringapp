package com.caters.web.service;

import com.caters.web.domain.User;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public Optional<User> getUser(Long id) {
        User user = new User(id, "gaurav", "singh");
        return Optional.of(user);
    }
}
