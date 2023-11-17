package by.iba.controller;

import by.iba.dto.OrderDto;
import by.iba.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    @Override
    public ResponseEntity<List<OrderDto>> findAll() {

        List<OrderDto> orders = orderService.findAll();
        return ResponseEntity
                .ok()
                .body(orders);
    }
}
