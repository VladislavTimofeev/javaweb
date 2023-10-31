package by.iba.controller;

import by.iba.dto.AuthorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1/authors")
public interface AuthorController {

    @GetMapping("/{id}")
    ResponseEntity<AuthorDto> findAuthorById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<AuthorDto>> findAll();

    @PostMapping
    ResponseEntity<AuthorDto> save(@RequestBody AuthorDto authorDto);

    @DeleteMapping("/{id}")
    ResponseEntity<AuthorDto> deleteAuthorById(@PathVariable Long id);

    @PatchMapping("/{id}")
    ResponseEntity<AuthorDto> restoreAuthorById(@PathVariable Long id);
}
