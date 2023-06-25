package by.iba.controller;

import by.iba.dto.UserDto;
import by.iba.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {

        UserDto user = userService.findById(id);

        return ResponseEntity
                .ok()
                .body(user);
    }

}
