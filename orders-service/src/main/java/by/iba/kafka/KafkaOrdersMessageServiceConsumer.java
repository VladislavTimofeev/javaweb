package by.iba.kafka;

import by.iba.kafka.dto.OrderDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrdersMessageServiceConsumer {

    @Value("${message.processing.time}")
    private long processingTime;

    @KafkaListener(
            topics = "${kafka.orders.topic}",
            groupId = "${kafka.orders.group-id}}",
            containerFactory = "objectsKafkaListenerContainerFactory"
    )
    void listener(OrderDto object) throws InterruptedException {

        System.out.println("CustomUserListener [{}]" + object);

        Thread.sleep(processingTime);
    }
}
