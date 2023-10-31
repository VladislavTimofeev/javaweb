package by.iba.repository;

import by.iba.domain.OrderEntity;

import java.util.List;

public interface OrderRepository {

    int save(OrderEntity orderEntity);

    List<OrderEntity> findAll();
}
