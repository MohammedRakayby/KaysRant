package com.rakayby.blog.db.repository.impl;

import com.rakayby.blog.constant.DbConstants;
import com.rakayby.blog.db.repository.PostRepository;
import com.rakayby.blog.model.Post;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

/**
 *
 * @author Rakayby
 */
@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final DynamoDbEnhancedClient dbEnhancedClient;

    @PostConstruct
    private void init() throws InterruptedException {
//        CreateTableRequest request = new CreateTableRequest(Arrays.asList(new AttributeDefinition("slug", ScalarAttributeType.S),
//                new AttributeDefinition("date", ScalarAttributeType.N)),
//                "Posts",
//                Arrays.asList(new KeySchemaElement("slug", KeyType.HASH),
//                        new KeySchemaElement("date", KeyType.RANGE)),
//                new ProvisionedThroughput(5L, 5L));
//        GlobalSecondaryIndex gsi = new GlobalSecondaryIndex();
//        gsi.setIndexName("idx_global_tag");
//        gsi.setKeySchema(Arrays.asList(new KeySchemaElement("tag", KeyType.HASH)));
//        gsi.setProvisionedThroughput(new ProvisionedThroughput(2L, 1L));
//        gsi.setProjection();
//        request.setGlobalSecondaryIndexes(Arrays.asList(gsi));
//        final String tableName = "Posts";
//        final DynamoDbWaiter ddbWaiter = dynamoDbClient.waiter();
//        GlobalSecondaryIndex gsi = GlobalSecondaryIndex.builder()
//                .indexName("idx_global_tag")
//                .keySchema(Arrays.asList(KeySchemaElement.builder().attributeName("tag").keyType(KeyType.HASH).build()))
//                .provisionedThroughput(ProvisionedThroughput.builder().readCapacityUnits(2L).writeCapacityUnits(1L).build())
//                .projection(Projection.builder().projectionType(ProjectionType.ALL).build())
//                .build();
//
//        CreateTableRequest request = CreateTableRequest.builder()
//                .attributeDefinitions(
//                        AttributeDefinition.builder()
//                                .attributeName("slug")
//                                .attributeType(ScalarAttributeType.S).build(),
//                        AttributeDefinition.builder()
//                                .attributeName("date")
//                                .attributeType(ScalarAttributeType.N).build())
//                .keySchema(KeySchemaElement.builder()
//                        .attributeName("slug")
//                        .keyType(KeyType.HASH)
//                        .build(),
//                        KeySchemaElement.builder()
//                                .attributeName("date")
//                                .keyType(KeyType.RANGE)
//                                .build())
//                .provisionedThroughput(ProvisionedThroughput.builder()
//                        .readCapacityUnits(new Long(5))
//                        .writeCapacityUnits(new Long(1)).build())
//                .tableName(tableName)
//                .globalSecondaryIndexes(Arrays.asList(gsi))
//                .build();
//
//        try {
//            CreateTableResponse response = dynamoDbClient.createTable(request);
//            DescribeTableRequest tableRequest = DescribeTableRequest.builder()
//                    .tableName(tableName)
//                    .build();
//            WaiterResponse<DescribeTableResponse> waiterResponse = ddbWaiter.waitUntilTableExists(r -> r.tableName(tableName));
//            waiterResponse.matched().response().ifPresent(System.out::println);
////            CreateTableResponse result = dynamoDbClient.createTable(request);
////            String tableId = result.tableDescription().tableId();
//        } catch (ResourceInUseException e) {
//            System.out.println("Table Already Exisits, skipping table creation.");
//        } catch (DynamoDbException e) {
//            System.err.println(e.getMessage());
//        }
//        Post p = new Post();
//        p.setContent("THIS IS CONTENT");
//        p.setSlug("THIS IS A SLUG");
//        p.setSummary("THIS IS A SUMMARY");
//        p.setDate(Instant.now().toEpochMilli());
//        p.setTag("tag1");
//        this.save(p);
    }

    @Override
    public void save(Post p) throws DynamoDbException {
        DynamoDbTable<Post> postsTable = dbEnhancedClient.table(DbConstants.TABLES.POSTS, TableSchema.fromClass(Post.class));
        postsTable.putItem(p);
    }

    @Override
    public Post getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getByTag(String tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
