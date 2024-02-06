package by.iba.service.impl;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import by.iba.repository.UserRepository;
import by.iba.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity loginUser(UserDto userDto) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(userDto.getPassword())) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @Override
    public UserEntity registerUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("User with current email already exist");
        }

        UserEntity newUser = new UserEntity();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());

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
