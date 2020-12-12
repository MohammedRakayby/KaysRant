package com.rakayby.blog.db.repository.impl;

import com.rakayby.blog.constant.DbConstants;
import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.UserProfile;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Optional;

/**
 * @author Rakayby
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final DynamoDbEnhancedClient dbEnhancedClient;
    private final DynamoDbTable<UserProfile> usersTable;

    public UserRepositoryImpl(DynamoDbEnhancedClient dbEnhancedClient) {
        this.dbEnhancedClient = dbEnhancedClient;
        this.usersTable = dbEnhancedClient.table(DbConstants.TABLES.USERS, TableSchema.fromClass(UserProfile.class));
    }

    @Override
    public Boolean save(UserProfile u) {
        try {
            this.usersTable.putItem(u);
            return Boolean.TRUE;
        } catch (Exception e) {
            //Todo: throw custom expection, log
            return Boolean.FALSE;
        }
    }

    @Override
    public Optional<UserProfile> get(String id) {
        try {
            UserProfile user = this.usersTable.getItem(Key.builder().partitionValue(id).build());
            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Long getUserCount() {
        return this.usersTable.scan().items().stream().count();
    }

}
