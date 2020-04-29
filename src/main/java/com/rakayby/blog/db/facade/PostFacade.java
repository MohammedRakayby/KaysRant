package com.rakayby.blog.db.facade;

import com.rakayby.blog.db.service.PostService;
import com.rakayby.blog.model.Post;
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
}
