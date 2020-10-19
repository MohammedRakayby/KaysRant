package com.rakayby.blog.db.repository.impl;

import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.UserProfile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rakayby
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public UserProfile save(UserProfile u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserProfile get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
