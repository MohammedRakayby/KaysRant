package com.rakayby.blog.model;

import com.rakayby.blog.constant.DbConstants;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondaryPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondarySortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

/**
 *
 * @author Rakayby
 */
@Setter
@DynamoDbBean
public class Post {

    private String slug;
    private Long date;
    private String title;
    private String content;
    private String tag;
    private Integer readTime;
    private String summary;

    @DynamoDbPartitionKey
    public String getSlug() {
        return this.slug;
    }

    @DynamoDbSortKey
    @DynamoDbSecondarySortKey(indexNames = DbConstants.TABLES.INDECES.POSTS_INDEX)
    public Long getDate() {
        return this.date;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = DbConstants.TABLES.INDECES.POSTS_INDEX)
    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public String getSummary() {
        return summary;
    }

}
