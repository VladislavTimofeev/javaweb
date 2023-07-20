package by.iba.service;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import by.iba.exception.ResourceNotFoundException;
import by.iba.exception.ServiceException;
import by.iba.mapper.UserMapper;
import by.iba.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

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

    @Override
    public UserDto save(UserDto userDto) {

        userRepository.findByEmail(userDto.getEmail())
                .ifPresent(value -> {
                    throw new ServiceException("This email " + value.getEmail() + " already in use");
                });

        UserEntity entityToSave = userMapper.convertToEntity(userDto);
        userRepository.save(entityToSave);

        return userMapper.convertToDto(entityToSave);
    }

//    @Override
//    public UserDto save(UserDto userDto) {
//
//        UserEntity entityToSave = userMapper.convertToEntity(userDto);
//        if (userRepository.findByEmail(userDto.getEmail()).isPresent())
//            throw new RuntimeException("Email already exists!") {
//            };
//        else {
//            userRepository.save(entityToSave);
//        }
//
////        if (validation by user email already exist)
////                        .orElseThrow(() -> new ServiceException("User exist"));
//
////        int count = userRepository.save(entityToSave);
////        System.out.println(count);
////        return userDto;
//
//        return userMapper.convertToDto(entityToSave);
//    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> users = userRepository.findAll();

        return userMapper.convertToList(users);
    }
}
