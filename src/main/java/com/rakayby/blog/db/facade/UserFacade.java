package com.rakayby.blog.db.facade;

import com.rakayby.blog.db.service.UserService;
import com.rakayby.blog.model.User;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Rakayby
 */
@Component
public class UserFacade implements UserDetailsService {

    private final UserService userService;

    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    public Boolean create(User user) {
        return userService.create(user);
    }

    @Override
    public User loadUserByUsername(String string) throws UsernameNotFoundException {
        return this.userService.loadUserByUsername(string);
    }
}
