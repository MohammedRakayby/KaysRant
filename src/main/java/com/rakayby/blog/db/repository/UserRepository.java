package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rakayby
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    //any custom methods
}
