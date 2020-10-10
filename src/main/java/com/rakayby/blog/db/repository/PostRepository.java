package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mohammed.rakayby
 */
public interface PostRepository extends CrudRepository<Post, Long> {

}
