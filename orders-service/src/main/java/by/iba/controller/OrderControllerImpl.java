package by.iba.controller;

import by.iba.dto.OrderDto;
import by.iba.service.OrderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    public OrderControllerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {

        OrderDto addOrder = orderService.save(orderDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/orders/" + addOrder.getId())
                .buildAndExpand(addOrder.getId()).toUri());

        return new ResponseEntity<>(addOrder, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<OrderDto>> findAll() {

        List<OrderDto> orders = orderService.findAll();
        return ResponseEntity
                .ok()
                .body(orders);
    }
}
