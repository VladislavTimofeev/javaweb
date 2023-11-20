package by.iba.controller.impl;

import by.iba.controller.BookController;
import by.iba.domain.BookEntity;
import by.iba.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @Override
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Override
    public BookEntity getBookById(Long id) {
        return bookService.getBookById(id);
    }

    @Override
    public void saveBook(BookEntity bookEntity) {
        bookService.saveBook(bookEntity);
    }

    @Override
    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }
}
