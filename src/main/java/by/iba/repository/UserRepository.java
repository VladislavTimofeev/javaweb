package by.iba.repository;

import by.iba.domain.UserEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findById(Long id);

    int save(UserEntity book);

}
