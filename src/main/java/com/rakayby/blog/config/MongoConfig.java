package com.rakayby.blog.config;

import com.mongodb.MongoClient;
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
    private int port;

    @Bean
    public MongoClient mongo() {
        return new MongoClient(host);
    }

    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), dbName);
    }
}
