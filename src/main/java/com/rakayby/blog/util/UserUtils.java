package com.rakayby.blog.util;

import com.rakayby.blog.constant.Constants;
import com.rakayby.blog.model.UserProfile;
import java.util.Arrays;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Mohammed.Rakayby
 */
public class UserUtils {

    public static User createUserFromProfile(UserProfile profile) {
        return new User(profile.getUsername(),
                profile.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority(Constants.ROLES.ADMIN)));
    }

    public static UserProfile createProfileFromUser(User user) {
        final UserProfile profile=new UserProfile();
        profile.setPassword(user.getPassword());
        profile.setUsername(user.getUsername());
        return profile;
    }

}
