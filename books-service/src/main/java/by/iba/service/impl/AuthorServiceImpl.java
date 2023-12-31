package by.iba.service.impl;

import by.iba.domain.AuthorEntity;
import by.iba.dto.AuthorDto;
import by.iba.exception.ResourceNotFoundException;
import by.iba.mapper.AuthorMapper;
import by.iba.repository.AuthorRepository;
import by.iba.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@AllArgsConstructor
@Service
@Validated
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    @Override
    public AuthorDto save(AuthorDto authorDto) {

        AuthorEntity entityToSave = authorMapper.convertToEntity(authorDto);
        authorRepository.save(entityToSave);

        return authorMapper.convertToDto(entityToSave);
    }

    @Override
    public List<AuthorDto> findAll() {
        List<AuthorEntity> authors = authorRepository.findAll();
        return authorMapper.convertToList(authors);
    }

    @Override
    public AuthorDto findById(Long id) {

        AuthorEntity authorEntity = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));

        return authorMapper.convertToDto(authorEntity);
    }

    @Override
    public AuthorDto deleteAuthorById(Long id) {

        AuthorEntity authorEntity = authorRepository.deleteAuthorById(id);

        return authorMapper.convertToDto(authorEntity);
    }

    @Override
    public AuthorDto restoreAuthorById(Long id) {

        AuthorEntity authorEntity = authorRepository.restoreAuthorById(id);

        return authorMapper.convertToDto(authorEntity);
    }
}
