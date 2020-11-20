package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.Post;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 *
 * @author mohammed.rakayby
 */
public interface PostRepository {

    public void save(Post p);

    public Post getById(String id, Long range);

    public List<Post> getAll(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey);

    public List<Post> getByTag(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey, String tag);
}
