package com.rakayby.blog.db.repository;

import com.rakayby.blog.model.Post;
import java.util.Map;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 *
 * @author mohammed.rakayby
 */
public interface PostRepository {

    public void save(Post p);

    public Post getById(String id, Long range);

    public PageIterable<Post> getAll(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey);

    public SdkIterable<Page<Post>> getByTag(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey, String tag);
}
