package by.iba.service.impl;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import by.iba.exception.ServiceException;
import by.iba.mapper.UserMapper;
import by.iba.repository.UserRepository;
import by.iba.service.UserService;
import by.iba.util.PasswordHasher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    @Transactional
    @Override
    public UserDto loginUser(UserDto userDto) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent() && passwordHasher.isPasswordMatched(userDto.getPassword(), optionalUser.get().getPassword())) {
            return UserMapper.convertToDto(optionalUser.get());
        } else {
            throw new ServiceException("Invalid username or password");
        }
    }

    @Transactional
    @Override
    public UserDto registerUser(@Valid UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new ServiceException("User with current email already exist");
        }

        String hashedPassword = passwordHasher.getHashedPassword(userDto.getPassword());
        userDto.setPassword(hashedPassword);

        UserEntity userEntity = UserMapper.convertToEntity(userDto);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return UserMapper.convertToDto(savedUserEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
