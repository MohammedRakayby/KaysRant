package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.UserDTO;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface UserRepository extends CrudRepository<UserDTO, String> {

}
