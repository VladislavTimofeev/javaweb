package by.iba.controller;

import by.iba.domain.BookEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/")
public interface BookController {

    @GetMapping("/{id}")
    BookEntity getBookById(@PathVariable Long id);

    @PostMapping("/books")
    void saveBook(@RequestBody BookEntity bookEntity);

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id);

}
