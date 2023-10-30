package by.iba.controller;

import by.iba.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1/books")
public interface BookController {

    @GetMapping("/{id}")
    ResponseEntity<BookDto> findBookById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<BookDto>> findAll();

    @PostMapping
    ResponseEntity<BookDto> save(@RequestBody BookDto bookDto);

}
