package com.rakayby.blog.db.facade;

import com.rakayby.blog.db.service.UserService;
import com.rakayby.blog.model.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rakayby
 */
@Component
public class UserFacade {

    private final UserService userService;

    public UserFacade(UserService userService) {
        this.userService = userService;

    }

    public Boolean create(User user) {
        return userService.create(user);
    }

    public User loadUserByUsername(String string) {
        return this.userService.loadUserByUsername(string);
    }
}
