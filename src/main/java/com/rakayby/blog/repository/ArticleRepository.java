package com.rakayby.blog.repository;

import com.rakayby.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Rakayby
 */
public interface ArticleRepository extends MongoRepository<Article, Integer> {

    public Article findByTitle(String title);

    public Article findByAuthor(String author);
}
