package by.iba.service;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto loginUser(UserDto userDto);

    UserDto registerUser(UserDto userDto);

    List<UserEntity> getAllUsers();

    UserEntity getUserById(Long id);

    void saveUser(UserEntity userEntity);

    void deleteUser(Long id);

}
