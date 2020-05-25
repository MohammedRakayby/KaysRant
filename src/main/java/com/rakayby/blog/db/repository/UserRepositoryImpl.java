package com.rakayby.blog.db.repository;

import com.rakayby.blog.constant.DbConstants;
import com.rakayby.blog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    private final MongoTemplate mongoTemplate;

    @Override
    public User findByUsername(String username) {
        return this.mongoTemplate.findOne(Query.query(Criteria.where(DbConstants.USER_ATTRIBUTES.USERNAME).is(username)), User.class);
    }

}
