package com.rakayby.blog.util;

import com.rakayby.blog.model.User;

/**
 *
 * @author Mohammed.Rakayby
 */
public class UserUtils {


    public static Boolean isValidUser(User user) {
        return !((user.getUsername() == null || user.getUsername().isEmpty()
                || (user.getPassword() == null || user.getPassword().isEmpty())));
    }
}
