package com.rakayby.blog.util;

import com.rakayby.blog.model.User;
import java.util.Date;

/**
 *
 * @author Mohammed.Rakayby
 */
public class UserUtils {

    public static void loadDefaultUserConfig(User user) {
        if (user.getCreationDate() == null) {
            user.setCreationDate(new Date());
        }
        if (user.getLocked() == null) {
            user.setLocked(Boolean.FALSE);
        }
        if (user.getIsAdmin() == null) {
            user.setIsAdmin(Boolean.FALSE);
        }
        if (user.getExpired() == null) {
            user.setExpired(Boolean.FALSE);
        }
        if (user.getEnabled() == null) {
            user.setEnabled(Boolean.TRUE);
        }
        if (user.getCredentialsExpired() == null) {
            user.setCredentialsExpired(Boolean.FALSE);
        }
    }

    public static Boolean isValidUser(User user) {
        return !((user.getEmail() == null || user.getEmail().isEmpty())
                || (user.getName() == null || user.getName().isEmpty()
                || (user.getPassword() == null || user.getPassword().isEmpty())));
    }
}
