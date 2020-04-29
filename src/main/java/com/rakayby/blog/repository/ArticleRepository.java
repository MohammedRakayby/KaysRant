package com.rakayby.blog.repository;

import com.rakayby.blog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Rakayby
 */
public interface ArticleRepository extends MongoRepository<Post, Integer> {

    public Post findByTitle(String title);

    public Post findByAuthor(String author);
}
