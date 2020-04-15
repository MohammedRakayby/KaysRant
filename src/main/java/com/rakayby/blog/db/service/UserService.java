package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rakayby
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userDao) {
        this.userRepository = userDao;
    }

    public Boolean create(User user) {
        return userRepository.insert(user) != null;
    }
}
