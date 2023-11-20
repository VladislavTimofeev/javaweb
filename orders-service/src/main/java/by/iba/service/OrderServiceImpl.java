package by.iba.service;

import by.iba.domain.OrderEntity;
import by.iba.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderEntity saveOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
