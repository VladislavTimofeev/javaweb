package by.iba.service;

import by.iba.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    AuthorDto save(AuthorDto authorDto);

    List<AuthorDto> findAll();

    AuthorDto findById(Long id);
}
