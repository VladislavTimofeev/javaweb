package by.iba.service.impl;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import by.iba.exception.ServiceException;
import by.iba.repository.UserRepository;
import by.iba.service.UserService;
import by.iba.util.PasswordHasher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    @Transactional
    @Override
    public UserEntity loginUser(UserDto userDto) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent() && passwordHasher.isPasswordMatched(userDto.getPassword(), optionalUser.get().getPassword())) {
            return optionalUser.get();
        } else {
            throw new ServiceException("Invalid username or password");
        }
    }

    @Transactional
    @Override
    public UserEntity registerUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new ServiceException("User with current email already exist");
        }

        UserEntity newUser = new UserEntity();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordHasher.getHashedPassword(userDto.getPassword()));

        return userRepository.save(newUser);
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
