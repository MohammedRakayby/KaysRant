package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.PostRepository;
import com.rakayby.blog.model.Post;
import java.util.Iterator;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohammed.rakayby
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Boolean savePost(Post post) {
        return this.postRepository.save(post) != null;
    }

    public Iterator<Post> getAll() {
        return this.postRepository.findAll().iterator();
    }

    public Optional getById(Long id) {
        return this.postRepository.findById(id);
    }

//    public Optional getBySlug(String slug) {
//        return this.postRepository.findPostBySlug(slug);
//    }
}
