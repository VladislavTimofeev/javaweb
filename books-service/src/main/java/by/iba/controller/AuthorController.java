package by.iba.controller;

import by.iba.domain.AuthorEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/api/v1/authors")
public interface AuthorController {
    @GetMapping
    List<AuthorEntity> getAllAuthors();

    @GetMapping("/{id}")
    Optional<AuthorEntity> getAuthorById(@PathVariable Long id);

    @PostMapping
    void saveAuthor(@RequestBody AuthorEntity authorEntity);

    @DeleteMapping("/{id}")
    void deleteAuthor(@PathVariable Long id);

}
