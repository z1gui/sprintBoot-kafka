# SpringBoot + Kafka 

## 启动创建Kafka topic

在配置文件 `application.yml` 按需配置 `topics`, Kafka启动自动监控创建 Topic

## 简单消息发送和消费

启动后访问 `http://localhost:8080/test/kafka?msg=` + 消息  即可发布消息，Kafka 消费者监控消费消费
