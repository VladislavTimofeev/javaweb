package by.iba.service;

import by.iba.domain.OrderEntity;
import by.iba.dto.OrderDto;
import by.iba.mapper.OrderMapper;
import by.iba.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto save(OrderDto orderDto) {

        OrderEntity entityToSave = orderMapper.convertToEntity(orderDto);
        orderRepository.save(entityToSave);

        return orderMapper.convertToDto(entityToSave);
    }

    @Override
    public List<OrderDto> findAll() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderMapper.convertToList(orderEntities);
    }
}
