package by.iba.mapper;

import by.iba.domain.BookEntity;
import by.iba.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookDto convertToDto(BookEntity book) {

        BookDto bookDto = new BookDto(book.getId(), book.getNumberOfPages(), book.getTitle());

        return bookDto;

    }

    public BookEntity convertToEntity(BookDto bookDto) {

        BookEntity bookEntity = new BookEntity(bookDto.getId(), bookDto.getNumberOfPages(), bookDto.getTitle());

        return bookEntity;
    }

    public List<BookDto> convertToList(List<BookEntity> books) {
        return books.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
