package by.iba.service.impl;

import by.iba.domain.AuthorEntity;
import by.iba.repository.AuthorRepository;
import by.iba.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<AuthorEntity> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void saveAuthor(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
