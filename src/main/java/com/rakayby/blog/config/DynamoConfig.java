package com.rakayby.blog.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import lombok.Setter;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Rakayby
 */
@Configuration
@EnableDynamoDBRepositories(basePackages = "com.rakayby.blog.db.repository")
@ConfigurationProperties(prefix = "amazon")
@Setter
public class DynamoConfig {

    private String dynamodbEndpoint;
    private String awsAccessKey;
    private String awsSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDBClientBuilder dynamoBuilder = AmazonDynamoDBClientBuilder.standard();
        if (dynamodbEndpoint != null && !dynamodbEndpoint.isEmpty()) {
            dynamoBuilder.setEndpointConfiguration(new EndpointConfiguration(dynamodbEndpoint, Region.getRegion(Regions.EU_CENTRAL_1).getName()));
        }
        return dynamoBuilder.build();
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                awsAccessKey, awsSecretKey);
    }
}
