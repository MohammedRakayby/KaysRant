package com.rakayby.blog.validators;

import com.rakayby.blog.constant.Constants.UserValidation;
import com.rakayby.blog.model.User;

/**
 *
 * @author Mohammed.Rakayby
 */
public class UserValidator {

    //will be moved to userutils
    public static UserValidation isValidUser(User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            return UserValidation.INVALID_USERNAME;
        } else if (user.getPassword() == null || user.getPassword().isEmpty()) {    
            return UserValidation.INVALID_PASSWORD;
        }
        return UserValidation.SUCCESS;
    }
}
