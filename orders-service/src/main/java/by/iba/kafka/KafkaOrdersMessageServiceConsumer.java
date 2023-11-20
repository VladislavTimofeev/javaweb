package by.iba.kafka;

import by.iba.domain.OrderEntity;
import by.iba.dto.KafkaOrderDto;
import by.iba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrdersMessageServiceConsumer {

    @Value("${message.processing.time}")
    private long processingTime;

    @Autowired
    private OrderService orderService;


    @KafkaListener(
            topics = "${kafka.orders.topic}",
            groupId = "${kafka.orders.group-id}}",
            containerFactory = "objectsKafkaListenerContainerFactory"
    )
    public void listener(OrderEntity object) {

        System.out.println("CustomUserListener OrderReceived [{}]" + object);

        orderService.saveOrder(object);
    }
}
