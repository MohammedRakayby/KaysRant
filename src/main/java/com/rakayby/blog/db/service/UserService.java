package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rakayby
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public User create(User user) {
        try {
            return this.userRepository.save(user);
        } catch (DuplicateKeyException e) {
            throw e;
        }
    }

    @Override
    public User loadUserByUsername(String username) {

        final Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new BadCredentialsException("Wrong username or password");
    }
}
