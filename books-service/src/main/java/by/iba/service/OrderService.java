package by.iba.service;

import by.iba.dto.KafkaOrderDto;

public interface OrderService {

    void processOrder(KafkaOrderDto orderDto);
}
