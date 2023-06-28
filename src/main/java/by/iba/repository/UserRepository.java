package by.iba.repository;

import by.iba.domain.UserEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> addUser();

    int save(UserEntity book);

}
