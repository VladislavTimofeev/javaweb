package by.iba.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
class KafkaTopicConfig {

    @Value("${kafka.orders.topic}")
    private String ordersTopic;

    @Bean
    public NewTopic ordersTopic(){
        return TopicBuilder.name(ordersTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
