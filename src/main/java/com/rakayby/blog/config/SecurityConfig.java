package com.rakayby.blog.config;

import com.rakayby.blog.db.facade.UserFacade;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Mohammed.Rakayby
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserFacade userFacade;

    public SecurityConfig(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userFacade);
    }

}
