package by.iba.repository;

import by.iba.domain.BookEntity;
import by.iba.domain.UserEntity;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    long save(BookEntity book);

    List<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);
}
