package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface CustomUserRepository {

    User findByCreationDate(Date creationDate);

    List<User> findAdminUsers();

}
