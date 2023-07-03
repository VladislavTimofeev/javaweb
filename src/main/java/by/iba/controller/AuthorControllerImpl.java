package by.iba.controller;

import by.iba.dto.AuthorDto;
import by.iba.service.AuthorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;

    public AuthorControllerImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

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
}
