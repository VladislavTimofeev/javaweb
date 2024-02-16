package by.iba.controller.impl;

import by.iba.controller.BookController;
import by.iba.domain.BookEntity;
import by.iba.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @PostMapping(value = "/createbook")
    public String addBook() {
        bookService.saveBook(new BookEntity());
        return "createbook";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<BookEntity> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
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
