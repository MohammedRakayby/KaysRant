package com.rakayby.blog.model;

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

/*
        I could have used spring's implementation of user,
        however, it contained much of unwanted data in my case.
        Plus I had to rename this class which I thought was too much
        for a little gained.
 */
/**
 *
 * @author mohammed.rakayby
 */
@Setter
@Getter
@NoArgsConstructor
public class User implements UserDetails {

    private String name;
    private String email;
    private String password;
    private Date creationDate;
    private Boolean isAdmin;
    private Boolean expired;
    private Boolean locked;
    private Boolean credentialsExpired;
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return isAdmin ? Arrays.asList(new SimpleGrantedAuthority(Constants.ROLES.USER), new SimpleGrantedAuthority(Constants.ROLES.ADMIN))
                : Arrays.asList(new SimpleGrantedAuthority(Constants.ROLES.USER));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
