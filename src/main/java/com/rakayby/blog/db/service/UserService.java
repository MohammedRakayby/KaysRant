package com.rakayby.blog.db.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.amazonaws.services.dynamodbv2.util.TableUtils.TableNeverTransitionedToStateException;
import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.UserDTO;
import com.rakayby.blog.util.UserUtils;
import java.util.Arrays;
import java.util.Optional;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rakayby
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AmazonDynamoDB amazonDynamoDB;
    private final UserUtils userUtils;

    @PostConstruct
    private void init() throws InterruptedException, TableNeverTransitionedToStateException {
        TableUtils.createTableIfNotExists(amazonDynamoDB, new CreateTableRequest(Arrays.asList(new AttributeDefinition("username", ScalarAttributeType.S)),
                "User",
                Arrays.asList(new KeySchemaElement("username", KeyType.HASH)),
                new ProvisionedThroughput(5L, 5L)));
        TableUtils.waitUntilActive(amazonDynamoDB, "User");
    }

    public UserDTO create(UserDTO user) {
        try {
            return this.userRepository.save(user);
        } catch (DuplicateKeyException e) {
            throw e;
        }
    }

    @Override
    public User loadUserByUsername(String username) {

        final Optional<UserDTO> user = userRepository.findById(username);
        if (user.isPresent()) {
            return userUtils.createUserFromDTO(user.get());
        }
        throw new BadCredentialsException("Wrong username or password");
    }
}
