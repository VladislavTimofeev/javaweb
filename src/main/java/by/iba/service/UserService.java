package by.iba.service;

import by.iba.dto.UserDto;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    UserDto save(@Valid UserDto userDto);

    List<UserDto> findAll();
}
