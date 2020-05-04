package com.rakayby.blog.db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rakayby.blog.model.User;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface UserRepository extends CustomUserRepository, MongoRepository<User, String> {

}
