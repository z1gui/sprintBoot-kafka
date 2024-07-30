package com.example.springkafka.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author l1uhang
 * @className TopicConfiguarations.java
 * @description 请简单描述功能
 * @since 2024-07-30 14:53:02
 */
@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
@Setter
@Getter
@ToString
public class TopicConfigurations {
    private List<Topic> topics;

    @Setter
    @Getter
    @ToString
    public static class Topic {
        private String name;
        private int numPartitions;
        private int replicationFactor;

        NewTopic newTopic() {
            return new NewTopic(name, numPartitions, (short) replicationFactor);
        }
    }
}
