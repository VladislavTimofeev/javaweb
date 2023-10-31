package by.iba.mapper;

import by.iba.domain.AuthorEntity;
import by.iba.domain.OrderEntity;
import by.iba.dto.AuthorDto;
import by.iba.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto convertToDto(OrderEntity orderEntity) {

        OrderDto orderDto = new OrderDto(orderEntity.getId(), orderEntity.getOrderDate(), orderEntity.getOrderCost(), orderEntity.getUserId());

        return orderDto;
    }

    public OrderEntity convertToEntity(OrderDto orderDto) {

        OrderEntity orderEntity = new OrderEntity(orderDto.getId(), orderDto.getOrderDate(), orderDto.getOrderCost(), orderDto.getUserId());

        return orderEntity;
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
