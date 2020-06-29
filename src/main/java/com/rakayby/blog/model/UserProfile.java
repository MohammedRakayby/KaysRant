package com.rakayby.blog.model;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Mohammed.Rakayby
 */
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {

    private String userName;
    private String lastName;
    private String firstName;
    private String role;
    private Date creationDate;

    public UserProfile(User user) {
        this.userName = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.role = user.getAuthorities().iterator().next().getAuthority();
        this.creationDate = user.getCreationDate();
    }
}
