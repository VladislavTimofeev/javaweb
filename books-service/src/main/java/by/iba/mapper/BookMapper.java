package by.iba.mapper;

import by.iba.domain.BookEntity;
import by.iba.dto.BookDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class BookMapper {

    @Autowired
    private final AuthorMapper authorMapper;

    public BookDto convertToDto(BookEntity book) {

        BookDto bookDto = new BookDto();

        bookDto.setId(book.getId());
        bookDto.setNumberOfPages(book.getNumberOfPages());
        bookDto.setTitle(book.getTitle());
        bookDto.setReleaseYear(book.getReleaseYear());
        bookDto.setPrice(book.getPrice());
        bookDto.setAuthors(authorMapper.convertToList(book.getAuthors()));

        return bookDto;
    }

    public BookEntity convertToEntity(BookDto bookDto) {

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId(bookDto.getId());
        bookEntity.setNumberOfPages(bookDto.getNumberOfPages());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setReleaseYear(bookDto.getReleaseYear());
        bookEntity.setPrice(bookDto.getPrice());
        bookEntity.setAuthors(authorMapper.convertToListEntity(bookDto.getAuthors()));

        return bookEntity;
    }

    public List<BookDto> convertToList(List<BookEntity> books) {
        return books.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
