package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rakayby
 */
@Service
public class UserService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public Boolean create(User user) {
        return userRepository.insert(user) != null;
    }
    
    @Override
    public User loadUserByUsername(String username) throws BadCredentialsException {
        final User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("Wrong username or password");
        }
        return user;
    }
}
