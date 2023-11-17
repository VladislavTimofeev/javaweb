package by.iba.controller.impl;

import by.iba.controller.AuthorController;
import by.iba.dto.AuthorDto;
import by.iba.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;

    @Override
    public ResponseEntity<AuthorDto> findAuthorById(@PathVariable Long id) {

        AuthorDto author = authorService.findById(id);
        return ResponseEntity
                .ok()
                .body(author);
    }

    @Override
    public ResponseEntity<List<AuthorDto>> findAll() {

        List<AuthorDto> authors = authorService.findAll();
        return ResponseEntity
                .ok()
                .body(authors);
    }

    @Override
    public ResponseEntity<AuthorDto> save(@RequestBody AuthorDto authorDto) {

        AuthorDto addedAuthor = authorService.save(authorDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/authors/" + addedAuthor.getId())
                .buildAndExpand(addedAuthor.getId()).toUri());
        return new ResponseEntity<>(addedAuthor, httpHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthorDto> deleteAuthorById(@PathVariable Long id) {

        AuthorDto author = authorService.deleteAuthorById(id);
        return ResponseEntity
                .ok()
                .body(author);
    }

    @Override
    public ResponseEntity<AuthorDto> restoreAuthorById(@PathVariable Long id) {

        AuthorDto author = authorService.restoreAuthorById(id);
        return ResponseEntity
                .ok()
                .body(author);
    }
}
