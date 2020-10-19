package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.UserProfile;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface UserRepository {

    public UserProfile save(UserProfile u);

    public UserProfile get(String id);
}
