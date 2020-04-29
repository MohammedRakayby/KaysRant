package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author mohammed.rakayby
 */
public interface PostRepository extends MongoRepository<Post, String> {

}
