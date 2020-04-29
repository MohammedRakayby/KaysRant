package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.PostRepository;
import com.rakayby.blog.model.Post;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohammed.rakayby
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Boolean savePost(Post post) {
        return this.postRepository.save(post) != null;
    }
}
