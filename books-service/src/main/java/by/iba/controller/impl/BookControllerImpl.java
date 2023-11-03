package by.iba.controller.impl;

import by.iba.controller.BookController;
import by.iba.dto.BookDto;
import by.iba.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    public BookControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<BookDto> findBookById(@PathVariable Long id) {

        BookDto book = bookService.findById(id);

        return ResponseEntity
                .ok()
                .body(book);
    }

    @Override
    public ResponseEntity<List<BookDto>> findAll() {

        List<BookDto> books = bookService.findAll();

        return ResponseEntity
                .ok()
                .body(books);
    }

    @Override
    public ResponseEntity<BookDto> save(@RequestBody BookDto bookDto) {

        BookDto addedBook = bookService.save(bookDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/books/" + addedBook.getId())
                .buildAndExpand(addedBook.getId()).toUri());
        return new ResponseEntity<>(addedBook, httpHeaders, HttpStatus.CREATED);
    }

}
