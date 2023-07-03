package by.iba.service;

import by.iba.domain.AuthorEntity;
import by.iba.dto.AuthorDto;
import by.iba.exception.ResourceNotFoundException;
import by.iba.mapper.AuthorMapper;
import by.iba.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorMapper authorMapper, AuthorRepository authorRepository) {
        this.authorMapper = authorMapper;
        this.authorRepository = authorRepository;
    }

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
}