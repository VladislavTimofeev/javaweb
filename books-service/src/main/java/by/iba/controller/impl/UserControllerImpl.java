package by.iba.controller.impl;

import by.iba.controller.UserController;
import by.iba.dto.UserDto;
import by.iba.service.UserService;
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
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {

        UserDto user = userService.findById(id);

        return ResponseEntity
                .ok()
                .body(user);
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll() {

        List<UserDto> users = userService.findAll();

        return ResponseEntity
                .ok()
                .body(users);
    }

    @Override
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {

        UserDto addedUser = userService.save(userDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/users/" + addedUser.getId())
                .buildAndExpand(addedUser.getId()).toUri());

        return new ResponseEntity<>(addedUser, httpHeaders, HttpStatus.CREATED);
    }

}
