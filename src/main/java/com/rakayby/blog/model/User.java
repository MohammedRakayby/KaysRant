package com.rakayby.blog.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.rakayby.blog.constant.Constants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author mohammed.rakayby
 */
@Setter
@Getter
@NoArgsConstructor
@DynamoDBTable(tableName = "Users")
public class User implements UserDetails {

    @DynamoDBHashKey
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isAdmin = false;
    private Date creationDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return isAdmin ? Arrays.asList(new SimpleGrantedAuthority(Constants.ROLES.ADMIN))
                : Arrays.asList(new SimpleGrantedAuthority(Constants.ROLES.USER));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
