package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.User;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface CustomUserRepository {

    User findByUsername(String username);
}
