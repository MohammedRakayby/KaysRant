package com.rakayby.blog.db.repository.impl;

import com.rakayby.blog.db.repository.CustomPostRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author Mohammed.Rakayby
 */
@RequiredArgsConstructor
public class PostRepositoryImpl implements CustomPostRepository {

    @Override
    public Optional findPostBySlug(String slug) {
        throw new UnsupportedOperationException("in progress");
    }

}
