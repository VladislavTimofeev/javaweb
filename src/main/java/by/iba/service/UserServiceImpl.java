package by.iba.service;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import by.iba.exception.ResourceNotFoundException;
import by.iba.mapper.UserMapper;
import by.iba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto findById(Long id) {

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userMapper.convertToDto(userEntity);
    }
}
