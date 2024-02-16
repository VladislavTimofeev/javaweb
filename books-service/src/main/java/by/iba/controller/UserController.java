package by.iba.controller;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "/")
public interface UserController {
    @PostMapping("/register")
    ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserDto userDto);

    @PostMapping("/login")
    ResponseEntity<UserDto> loginUser(@RequestBody @Valid UserDto userDto);

    @GetMapping("/id")
    UserEntity getUserById(@PathVariable Long id);

    @PostMapping("/users")
    void saveUser(@RequestBody UserEntity userEntity);

    @DeleteMapping("/id")
    void deleteUser(@PathVariable Long id);

}
