package by.iba.service;

import by.iba.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto save(BookDto bookDto);

    List<BookDto> findAll();

    BookDto findById(Long id);
}
