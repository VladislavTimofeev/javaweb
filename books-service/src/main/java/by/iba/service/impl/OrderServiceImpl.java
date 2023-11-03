package by.iba.service.impl;

import by.iba.dto.OrderDto;
import by.iba.kafka.KafkaProducerService;
import by.iba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Value("${kafka.orders.topic}")
    private String ordersTopic;

    @Override
    public void processOrder(OrderDto orderDto) {
        kafkaProducerService.sendMessage(orderDto, ordersTopic);
    }
}
