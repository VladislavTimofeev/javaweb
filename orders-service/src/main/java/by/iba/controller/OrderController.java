package by.iba.controller;

import by.iba.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/orders")
public interface OrderController {
    @PostMapping
    ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto);

    @GetMapping
    ResponseEntity<List<OrderDto>> findAll();
}
