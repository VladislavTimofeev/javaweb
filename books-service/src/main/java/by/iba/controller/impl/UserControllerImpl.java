package by.iba.controller.impl;

import by.iba.controller.UserController;
import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import by.iba.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Validated
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> registerUser(UserDto userDto) {
        UserDto newUser = userService.registerUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDto> loginUser(UserDto userDto) {
        UserDto user = userService.loginUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userService.saveUser(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
