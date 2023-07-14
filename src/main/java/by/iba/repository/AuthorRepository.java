package by.iba.repository;

import by.iba.domain.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

    int save(AuthorEntity author);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findById(Long id);

    int deleteAuthorById(Long id);

    int restoreAuthorById(Long id);
}
