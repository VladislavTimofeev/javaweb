package by.iba.service;

import by.iba.domain.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity getUserById(Long id);

    void saveUser(UserEntity userEntity);

    void deleteUser(Long id);

}
