package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.PostRepository;
import com.rakayby.blog.model.Page;
import com.rakayby.blog.model.Post;
import com.rakayby.blog.util.HttpUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    public Page getAll(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey) {
        final ArrayList<Object> posts = new ArrayList(this.postRepository.getAll(pageSize, exclusiveStartKey));
        //log
        final HashMap<String, Object> key = HttpUtils.convertFromAttributeMap(exclusiveStartKey);
        return new Page(key, posts);
    }

    public Page getByTag(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey, String tag) {
        final ArrayList<Object> posts = new ArrayList(this.postRepository.getByTag(pageSize, exclusiveStartKey, tag));
        //log
        final HashMap<String, Object> key = HttpUtils.convertFromAttributeMap(exclusiveStartKey);
        return new Page(key, posts);
    }
}
