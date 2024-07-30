package com.example.springkafka.controller;

import com.example.springkafka.service.KafkaTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author l1uhang
 * @className TestController.java
 * @description 请简单描述功能
 * @since 2024-07-18 15:46:43
 */
@Component
@Slf4j
@RequestMapping("/test")
public class TestController {


    @Autowired
    private KafkaTestService kafkaTestService;

    @GetMapping("/kafka")
    public void testKafka(@RequestParam("msg") String msg)
    {
        kafkaTestService.send(msg);
        log.info("testKafka");
    }

}
