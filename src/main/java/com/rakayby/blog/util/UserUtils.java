package com.rakayby.blog.util;

import com.rakayby.blog.constant.Constants;
import com.rakayby.blog.model.UserDTO;
import java.util.Arrays;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammed.Rakayby
 */
@Service
public class UserUtils {

    public User createUserFromDTO(UserDTO profile) {
        return new User(profile.getUsername(),
                profile.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority(Constants.ROLES.ADMIN)));
    }

    public UserDTO createDTOFromUser(User user) {
        final UserDTO dto=new UserDTO();
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        return dto;
    }

}
