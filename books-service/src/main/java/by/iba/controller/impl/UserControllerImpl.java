package by.iba.controller.impl;

import by.iba.controller.UserController;
import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import by.iba.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@Validated
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/register")
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
