package com.rakayby.blog.config;

import java.net.URI;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

/**
 *
 * @author Rakayby
 */
@Configuration
@ConfigurationProperties(prefix = "amazon")
@Setter
public class DynamoConfig {

    private String dynamodbEndpoint;
    private String awsAccessKey;
    private String awsSecretKey;

    @Bean
    public DynamoDbClient amazonDynamoDB() {
        return DynamoDbClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(amazonAWSCredentials()))
                .endpointOverride(URI.create(dynamodbEndpoint))
                .region(Region.EU_CENTRAL_1)
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dbEnhancedClient() {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(amazonDynamoDB())
                .build();
    }

    @Bean
    public AwsBasicCredentials amazonAWSCredentials() {
        return AwsBasicCredentials.create(awsAccessKey, awsSecretKey);
    }
}
