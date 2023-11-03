package by.iba.kafka.config;

import by.iba.dto.AbstractDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Value("${kafka.general.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${kafka.orders.group-id}")
    private String ordersGroupId;

    public ConsumerFactory<String, AbstractDto> objectsConsumerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, ordersGroupId);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

        return new DefaultKafkaConsumerFactory<>(config,
                new StringDeserializer(),
                new JsonDeserializer<>(AbstractDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AbstractDto>
    objectsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AbstractDto> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(objectsConsumerFactory());
        return factory;
    }

}
