package by.iba.service;

import by.iba.domain.BookEntity;

import java.util.List;

public interface BookService {

    List<BookEntity> getAllBooks();

    BookEntity getBookById(Long id);

    void saveBook(BookEntity bookEntity);

    void deleteBook(Long id);

}
