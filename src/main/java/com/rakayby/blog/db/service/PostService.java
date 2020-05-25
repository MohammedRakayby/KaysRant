package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.PostRepository;
import com.rakayby.blog.model.Post;
import java.util.List;
import java.util.Optional;
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

    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    public Optional getById(String id) {
        return this.postRepository.findById(id);
    }
}
