package com.rakayby.blog.db.service;

import com.rakayby.blog.db.repository.UserRepository;
import com.rakayby.blog.model.UserProfile;
import com.rakayby.blog.util.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
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
    public Boolean create(UserProfile user) {
        if (userRepository.getUserCount() < 1) {
            user.setCreationDate(LocalDateTime.now());
            return this.userRepository.save(user);
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public User loadUserByUsername(String username) {

        final Optional<UserProfile> user = userRepository.get(username);
        if (user.isPresent()) {
            return UserUtils.createUserFromProfile(user.get());
        }
        throw new BadCredentialsException("Wrong username or password");
    }
}
