package com.example.springkafka.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author l1uhang
 * @className KafkaTestConsumer.java
 * @description 请简单描述功能
 * @since 2024-07-18 17:07:29
 */
@Component
@Slf4j
public class KafkaTestConsumer {




    @KafkaListener(topics = "test",groupId = "testGroup")
    public void testConsumer(String msg, Acknowledgment ack){
       log.info("consumer msg:{}",msg);
       //手动提交，信息已消费
       ack.acknowledge();
    }
}
