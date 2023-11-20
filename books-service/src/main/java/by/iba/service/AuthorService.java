package by.iba.service;

import by.iba.domain.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<AuthorEntity> getAllAuthors();

    Optional<AuthorEntity> getAuthorById(Long id);

    void saveAuthor(AuthorEntity authorEntity);

    void deleteAuthor(Long id);

}
