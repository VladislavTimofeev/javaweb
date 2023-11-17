package by.iba.service.impl;

import by.iba.dto.BookDto;
import by.iba.dto.KafkaOrderDto;
import by.iba.exception.ResourceNotFoundException;
import by.iba.kafka.KafkaProducerService;
import by.iba.service.BookService;
import by.iba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BookService bookService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Value("${kafka.orders.topic}")
    private String ordersTopic;

    @Override
    public void processOrder(KafkaOrderDto orderDto) throws ResourceNotFoundException {

        BookDto bookDto = bookService.findById(orderDto.getBookId());

        orderDto.setBookPrice(bookDto.getPrice());

        System.out.println("Book id : " + orderDto.getBookId() + " and " + "user id : " + orderDto.getUserId() + "processed");

        kafkaProducerService.sendMessage(orderDto, ordersTopic);
    }
}
