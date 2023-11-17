package by.iba.mapper;

import by.iba.domain.OrderEntity;
import by.iba.dto.KafkaOrderDto;
import by.iba.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto convertToDto(OrderEntity orderEntity) {

        return new OrderDto(orderEntity.getId(), orderEntity.getOrderDate(), orderEntity.getOrderCost(), orderEntity.getUserId(), orderEntity.getBookId());
    }

    public OrderEntity convertToEntity(KafkaOrderDto kafkaOrderDto) {

        return OrderEntity.builder()
                .userId(kafkaOrderDto.getUserId())
                .bookId(kafkaOrderDto.getBookId())
                .orderCost(kafkaOrderDto.getBookPrice())
                .build();
    }

    public List<OrderDto> convertToList(List<OrderEntity> orders) {
        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<OrderEntity> convertToListEntity(List<KafkaOrderDto> orders) {
        return orders.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

}
