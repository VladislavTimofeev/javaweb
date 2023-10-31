package by.iba.service;

import by.iba.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto save(OrderDto orderDto);

    List<OrderDto> findAll();
}
