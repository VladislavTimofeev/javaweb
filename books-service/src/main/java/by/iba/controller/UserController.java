package by.iba.controller;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path="/api/v1/users")
public interface UserController {

    @PostMapping("/register")
    ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto);

    @PostMapping("/login")
    ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto);

    @GetMapping
    List<UserEntity> getAllUsers();

    @GetMapping("/{id}")
    UserEntity getUserById(@PathVariable Long id);

    @PostMapping
    void saveUser(@RequestBody UserEntity userEntity);

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id);

}
