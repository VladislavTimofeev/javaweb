package by.iba.service;

import by.iba.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    UserDto save(UserDto userDto);

    List<UserDto> findAll();
}
