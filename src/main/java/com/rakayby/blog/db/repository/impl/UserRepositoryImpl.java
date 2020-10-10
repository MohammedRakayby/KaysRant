package com.rakayby.blog.db.repository.impl;

import com.rakayby.blog.db.repository.CustomUserRepository;
import com.rakayby.blog.model.User;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/*
    this implementation will be picked up by spring.
    even while not explicitly wiring it, only proper naming
    is essential for it to work.
 */
/**
 *
 * @author Rakayby
 */
@Repository
@RequiredArgsConstructor
class UserRepositoryImpl implements CustomUserRepository {

//    @Override
//    public User findByUsername(String username){
//        return this.mongoTemplate.findOne(Query.query(Criteria.where(DbConstants.USER_ATTRIBUTES.USERNAME).is(username)), User.class);
//    }
    @Override
    public User findByCreationDate(Date creationDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAdminUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
