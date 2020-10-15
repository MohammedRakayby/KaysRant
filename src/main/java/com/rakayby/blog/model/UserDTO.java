package com.rakayby.blog.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Mohammed.Rakayby
 */
@Getter
@Setter
@NoArgsConstructor
@DynamoDBTable(tableName = "User")
public class UserDTO {

    @DynamoDBHashKey
    private String username;
    @DynamoDBAttribute
    private String password;
}
