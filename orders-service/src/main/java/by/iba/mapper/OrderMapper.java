package by.iba.mapper;

import by.iba.domain.OrderEntity;
import by.iba.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto convertToDto(OrderEntity orderEntity) {

        OrderDto orderDto = null;//new OrderDto(orderEntity.getId(), orderEntity.getOrderDate(), orderEntity.getOrderCost(), orderEntity.getUserId());

        return orderDto;
    }

    public OrderEntity convertToEntity(OrderDto orderDto) {

        return OrderEntity.builder()
                .userId(orderDto.getUserId())
                .bookId(orderDto.getBookId())
                .build();
    }

    public List<OrderDto> convertToList(List<OrderEntity> orders){
        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public List<OrderEntity> convertToListEntity(List<OrderDto> orders){
        return orders.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

}
