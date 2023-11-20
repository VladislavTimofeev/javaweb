package by.iba.controller;

import by.iba.domain.OrderEntity;
import by.iba.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Override
    public Optional<OrderEntity> getOrderById(Long id) {
        return orderService.getOrderById(id);
    }

    @Override
    public void saveOrder(OrderEntity orderEntity) {
        orderService.saveOrder(orderEntity);
    }

    @Override
    public void deleteOrder(Long id) {
        orderService.deleteOrder(id);
    }
}
