package by.iba.service;

import by.iba.dto.KafkaOrderDto;
import by.iba.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto save(KafkaOrderDto kafkaOrderDto);
    List<OrderDto> findAll();
}
