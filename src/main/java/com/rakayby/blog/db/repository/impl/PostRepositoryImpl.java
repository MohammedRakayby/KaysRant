package com.rakayby.blog.db.repository.impl;

import com.rakayby.blog.constant.DbConstants;
import com.rakayby.blog.db.repository.CustomPostRepository;
import com.rakayby.blog.model.Post;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author Mohammed.Rakayby
 */
@RequiredArgsConstructor
public class PostRepositoryImpl implements CustomPostRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Optional findPostBySlug(String slug) {
        final Post post = this.mongoTemplate.findOne(Query.query(Criteria.where(DbConstants.POST_ATTRIBUTES.SLUG).is(slug)), Post.class);
        return Optional.ofNullable(post);
    }

}
