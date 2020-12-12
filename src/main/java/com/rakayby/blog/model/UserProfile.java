package com.rakayby.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDateTime;

/**
 *
 * @author Mohammed.Rakayby
 */
@Getter
@Setter
@NoArgsConstructor
@DynamoDbBean
public class UserProfile {

    private String username;
    private String password;
    private LocalDateTime creationDate;

    @DynamoDbPartitionKey
    public String getUsername() {
        return username;
    }
}
