package by.iba.controller;

import by.iba.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1/users")
public interface UserController {

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UserDto>> findAll();


    @PostMapping
    ResponseEntity<UserDto> save(@RequestBody UserDto userDto);

}
