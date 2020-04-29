package com.rakayby.blog.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 * @author mohammed.rakayby
 */
@Configuration
@ConfigurationProperties(prefix = "mongo")
@EnableMongoRepositories(basePackages = "com.rakayby.blog.db.repository")
@Getter
@Setter
public class MongoConfig {

    private String host;
    private String dbName;
    private String username;
    private String password;
    private String appName;
    private int port;

    @Bean
    public MongoClient mongo() {
        MongoCredential mongoCredential = MongoCredential.createCredential(username, dbName, password.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().applicationName(appName).build();
        return new MongoClient(new ServerAddress(host), mongoCredential, options);
    }

    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), dbName);
    }
}
