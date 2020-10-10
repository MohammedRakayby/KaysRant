package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface UserRepository extends CrudRepository<User, String> {

}
