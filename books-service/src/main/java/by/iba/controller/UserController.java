package by.iba.controller;

import by.iba.domain.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path="/api/v1/users")
public interface UserController {

    @GetMapping
    List<UserEntity> getAllUsers();

    @GetMapping("/{id}")
    UserEntity getUserById(@PathVariable Long id);

    @PostMapping
    void saveUser(@RequestBody UserEntity userEntity);

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id);

}
