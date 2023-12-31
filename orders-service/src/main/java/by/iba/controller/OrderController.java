package by.iba.controller;

import by.iba.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/orders")
public interface OrderController {
    @GetMapping
    ResponseEntity<List<OrderDto>> findAll();
}
