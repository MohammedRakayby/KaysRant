package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.PostRepository;
import com.rakayby.blog.model.Post;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

/**
 *
 * @author mohammed.rakayby
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void savePost(Post post) throws DynamoDbException {
        this.postRepository.save(post);
    }

    public Post getById(String id) {
        return this.postRepository.getById(id);
    }

    public List<Post> getAll() {
        return this.postRepository.getAll();
    }

    public List<Post> getByTag(String tag) {
        return this.postRepository.getByTag(tag);
    }
}
