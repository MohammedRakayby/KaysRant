package com.rakayby.blog.db.repository.impl;

import com.rakayby.blog.constant.DbConstants;
import com.rakayby.blog.db.repository.PostRepository;
import com.rakayby.blog.model.Post;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

/**
 *
 * @author Rakayby
 */
@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final DynamoDbEnhancedClient dbEnhancedClient;

    @Value("${db.default_page_size}")
    private Integer defaultPageSize;

//    @PostConstruct
//    private void init() throws InterruptedException {
//        Post p = new Post();
//        p.setContent("THIS IS CONTENT");
//        p.setSlug("THIS IS A SLUG");
//        p.setSummary("THIS IS A SUMMARY");
//        p.setDate(Instant.now().toEpochMilli());
//        p.setTag("tag1");
//        this.save(p);
//    }
    @Override
    public void save(Post p) throws DynamoDbException {
        DynamoDbTable<Post> postsTable = dbEnhancedClient.table(DbConstants.TABLES.POSTS, TableSchema.fromClass(Post.class));
        postsTable.putItem(p);
    }

    @Override
    public Post getById(String id, Long range) {
        DynamoDbTable<Post> postsTable = dbEnhancedClient.table(DbConstants.TABLES.POSTS, TableSchema.fromClass(Post.class));
        return postsTable.getItem(Key.builder().partitionValue(id).sortValue(range).build());
    }

    @Override
    public PageIterable<Post> getAll(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey) {
        DynamoDbTable<Post> postsTable = dbEnhancedClient.table(DbConstants.TABLES.POSTS, TableSchema.fromClass(Post.class));
        return postsTable.scan(ScanEnhancedRequest.builder()
                .exclusiveStartKey(exclusiveStartKey.isEmpty() ? null : exclusiveStartKey)
                .limit(pageSize == null ? this.defaultPageSize : pageSize)
                .build());
    }

    @Override
    public SdkIterable<Page<Post>> getByTag(Integer pageSize, Map<String, AttributeValue> exclusiveStartKey, String tag) {
        DynamoDbTable<Post> postsTable = dbEnhancedClient.table(DbConstants.TABLES.POSTS, TableSchema.fromClass(Post.class));
        return postsTable.index(DbConstants.TABLES.INDECES.POSTS_INDEX)
                .query(QueryEnhancedRequest.builder()
                        .queryConditional(QueryConditional.keyEqualTo(Key.builder().sortValue(tag).build()))
                        .exclusiveStartKey(exclusiveStartKey)
                        .limit(pageSize == null ? this.defaultPageSize : pageSize)
                        .build());
    }

}
