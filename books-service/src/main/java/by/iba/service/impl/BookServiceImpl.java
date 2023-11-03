package by.iba.service.impl;

import by.iba.domain.BookAuthorsEntity;
import by.iba.domain.BookEntity;
import by.iba.dto.AuthorDto;
import by.iba.dto.BookDto;
import by.iba.exception.ResourceNotFoundException;
import by.iba.mapper.BookMapper;
import by.iba.repository.AuthorRepository;
import by.iba.repository.BookAuthorRepository;
import by.iba.repository.BookRepository;
import by.iba.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookAuthorRepository bookAuthorRepository;

    public BookServiceImpl(BookMapper bookMapper, BookRepository bookRepository,
                           AuthorRepository authorRepository, BookAuthorRepository bookAuthorRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookAuthorRepository = bookAuthorRepository;
    }

    @Override
    public BookDto save(BookDto bookDto) {

        BookEntity entityToSave = bookMapper.convertToEntity(bookDto);

        long bookId = bookRepository.save(entityToSave);

        entityToSave.setId(bookId);

        for (AuthorDto authorDto : bookDto.getAuthors()) {
            BookAuthorsEntity bookAuthorsEntity = new BookAuthorsEntity(bookId, authorDto.getId());
            bookAuthorRepository.saveBookAuthor(bookAuthorsEntity);
        }

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
