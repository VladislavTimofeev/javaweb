package by.iba.service;

import by.iba.domain.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderEntity saveOrder(OrderEntity orderEntity);

    List<OrderEntity> getAllOrders();

    Optional<OrderEntity> getOrderById(Long id);

    void deleteOrder(Long id);
}
