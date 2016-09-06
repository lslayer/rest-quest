package com.gk_software.entertainment.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by vgogilchyn on 06.09.16.
 */
@Configuration
@EnableWebMvc
@EnableMongoRepositories
@ComponentScan(basePackages = "com.gk_software.entertainment.web.api")
public class SpringConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "rest-quest-puzzles";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }
}
