package by.iba.controller;

import by.iba.domain.OrderEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/api/v1/orders")
public interface OrderController {
    @GetMapping
    List<OrderEntity> getAllOrders();

    @GetMapping("/{id}")
    Optional<OrderEntity> getOrderById(@PathVariable Long id);

    @PostMapping
    void saveOrder(@RequestBody OrderEntity orderEntity);

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Long id);
}
