package by.iba.service;

import by.iba.domain.BookEntity;
import by.iba.dto.BookDto;
import by.iba.exception.ResourceNotFoundException;
import by.iba.mapper.BookMapper;
import by.iba.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto save(BookDto bookDto) {

        BookEntity entityToSave = bookMapper.convertToEntity(bookDto);

        bookRepository.save(entityToSave);

        return bookMapper.convertToDto(entityToSave);
    }

    @Override
    public List<BookDto> findAll() {

        List<BookEntity> books = bookRepository.findAll();

        return bookMapper.convertToList(books);
    }

    @Override
    public BookDto findById(Long id) {

        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        return bookMapper.convertToDto(bookEntity);
    }

}
