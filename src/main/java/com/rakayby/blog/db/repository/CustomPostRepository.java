package com.rakayby.blog.db.repository;

import java.util.Optional;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface CustomPostRepository {

    public Optional findPostBySlug(String slug);
}
