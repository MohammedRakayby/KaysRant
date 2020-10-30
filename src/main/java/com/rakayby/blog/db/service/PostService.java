package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.PostRepository;
import com.rakayby.blog.model.Post;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
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

    public Post getById(String id, Long range) {
        return this.postRepository.getById(id, range);
    }

    public List<Post> getAll(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey) {
        PageIterable<Post> postsPages = this.postRepository.getAll(pageSize, exclusiveStartKey);
        return postsPages.items().stream().collect(Collectors.toList());
    }

    public List<Post> getByTag(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey, String tag) {
        SdkIterable<Page<Post>> postsPages = this.postRepository.getByTag(pageSize, exclusiveStartKey, tag);
        return (List<Post>) postsPages.stream().map(p -> p.items());
    }
}
