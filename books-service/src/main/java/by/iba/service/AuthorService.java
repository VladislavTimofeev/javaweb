package by.iba.service;

import by.iba.dto.AuthorDto;

import javax.validation.Valid;
import java.util.List;

public interface AuthorService {

    AuthorDto save(@Valid AuthorDto authorDto);

    List<AuthorDto> findAll();

    AuthorDto findById(Long id);

    AuthorDto deleteAuthorById( Long id);

    AuthorDto restoreAuthorById(Long id);
}
