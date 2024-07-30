package com.example.springkafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author l1uhang
 * @className KafkaTestServiceImpl.java
 * @description 请简单描述功能
 * @since 2024-07-18 15:51:14
 */
@Component
@Slf4j
public class KafkaTestServiceImpl implements KafkaTestService{

    @Value("${spring.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void send(String msg) {
        log.info("==开始向kafka推送信息send msg:{}", msg);
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("==向kafka推送信息失败send msg:{}", msg);
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                log.info("==向kafka推送信息成功send msg:{}", msg);
            }
        });



    }
}
