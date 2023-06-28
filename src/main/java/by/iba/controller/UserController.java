package by.iba.controller;

import by.iba.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/v1/users")
public interface UserController {

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable Long id);

    @PostMapping("/adding")
    ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto);

}
