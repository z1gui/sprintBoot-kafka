package com.example.springkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.GenericWebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author l1uhang
 * @className TopicAdministrator.java
 * @description 请简单描述功能
 * @since 2024-07-30 14:57:36
 */
@Configuration
public class TopicAdministrator {
    private final TopicConfigurations topicConfigurations;
    private final GenericWebApplicationContext context;
    public TopicAdministrator(TopicConfigurations topicConfigurations, GenericWebApplicationContext context)
    {
        this.topicConfigurations = topicConfigurations;
        this.context = context;
    }

    @PostConstruct
    public void init()
    {
        initializeBeans(topicConfigurations.getTopics());
    }

    private void initializeBeans(List<TopicConfigurations.Topic> topics) {
        topics.forEach(t -> context.registerBean(t.getName(), NewTopic.class, t::newTopic));
    }
}
