package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.UserProfile;
import com.rakayby.blog.util.UserUtils;
import lombok.RequiredArgsConstructor;
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
//    private final AmazonDynamoDB amazonDynamoDB;

//    @PostConstruct
//    private void init() throws InterruptedException, TableNeverTransitionedToStateException {
//        TableUtils.createTableIfNotExists(amazonDynamoDB, new CreateTableRequest(Arrays.asList(new AttributeDefinition("username", ScalarAttributeType.S)),
//                "User",
//                Arrays.asList(new KeySchemaElement("username", KeyType.HASH)),
//                new ProvisionedThroughput(5L, 5L)));
//        TableUtils.waitUntilActive(amazonDynamoDB, "User");
//    }
    public UserProfile create(UserProfile user) {

        return this.userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) {

        final UserProfile user = userRepository.get(username);
        if (user != null) {
            return UserUtils.createUserFromProfile(user);
        }
        throw new BadCredentialsException("Wrong username or password");
    }
}
