package com.rakayby.blog.validators;

import com.rakayby.blog.model.User;

/**
 *
 * @author Mohammed.Rakayby
 */
public class UserValidator {
    //will be moved to userutils
    public static Boolean isValidUser(User user) {
        return !((user.getUsername() == null || user.getUsername().isEmpty()
                || (user.getPassword() == null || user.getPassword().isEmpty())));
    }
}
