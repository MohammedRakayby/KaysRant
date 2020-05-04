package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rakayby
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean create(User user) {
        return userRepository.insert(user) != null;
    }

    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
