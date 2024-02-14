package by.iba.controller;

import by.iba.domain.BookEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1/books")
public interface BookController {

    @GetMapping
    List<BookEntity> getAllBooks();

    @GetMapping("/{id}")
    BookEntity getBookById(@PathVariable Long id);

    @PostMapping
    void saveBook(@RequestBody BookEntity bookEntity);

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id);

}
