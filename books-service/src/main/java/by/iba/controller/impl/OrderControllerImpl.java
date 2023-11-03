package by.iba.controller.impl;

import by.iba.controller.OrderController;
import by.iba.dto.OrderDto;
import by.iba.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OrderControllerImpl implements OrderController {


    private final OrderService orderService;


    @Override
    public ResponseEntity<String> save(OrderDto orderDto) {

        orderService.processOrder(orderDto);

        return ResponseEntity.ok("Order saved for processing");
    }
}
