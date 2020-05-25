package com.rakayby.blog.db.facade;

import com.rakayby.blog.db.service.PostService;
import com.rakayby.blog.model.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohammed.rakayby
 */
@Component
public class PostFacade {

    private final PostService postService;

    public PostFacade(PostService postService) {
        this.postService = postService;
    }

    public Boolean savePost(Post post) {
        return postService.savePost(post);
    }

    public List<Post> getAll() {
        return this.postService.getAll();
    }

    public Optional getById(Long id) {
        return this.postService.getById(id);
    }
}
