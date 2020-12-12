package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.UserProfile;

import java.util.Optional;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface UserRepository {

    public Boolean save(UserProfile u);

    public Optional<UserProfile> get(String id);

    public Long getUserCount();
}
