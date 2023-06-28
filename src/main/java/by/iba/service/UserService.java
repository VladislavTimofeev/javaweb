package by.iba.service;

import by.iba.dto.UserDto;

public interface UserService {

    UserDto findById(Long id);

    UserDto addUser(UserDto userDto);

}
