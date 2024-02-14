package by.iba.controller.impl;

import by.iba.controller.AuthorController;
import by.iba.domain.AuthorEntity;
import by.iba.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @Override
    public Optional<AuthorEntity> getAuthorById(Long id) {
        return authorService.getAuthorById(id);
    }

    @Override
    public void saveAuthor(AuthorEntity authorEntity) {
        authorService.saveAuthor(authorEntity);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorService.deleteAuthor(id);
    }
}
