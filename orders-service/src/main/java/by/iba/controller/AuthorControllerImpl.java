package by.iba.controller;

import by.iba.domain.AuthorEntity;
import by.iba.dto.AuthorDto;
import by.iba.repository.AuthorRepository;
import by.iba.service.AuthorService;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

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

//    @Override
//    public ResponseEntity<AuthorDto> deleteAuthorById(@PathVariable Long id) {
//        try {
//            Optional<AuthorEntity> result = authorRepository.deleteAuthorById(id);
//            if (result == 0) {
//                return new ResponseEntity<>(HttpStatus.OK);
//            }
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @Override
//    public ResponseEntity<AuthorDto> restoreAuthorById(Long id, @RequestBody AuthorDto authorDto) {
//         AuthorDto authorDto1 = authorService.findById(id);
//         if (authorDto1 != null){
//             authorDto1.setId(id);
//             authorRepository.restoreAuthorById(id);
//             return new ResponseEntity<>(HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//    }
}
