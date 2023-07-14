package by.iba.service;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import by.iba.exception.ResourceNotFoundException;
import by.iba.mapper.UserMapper;
import by.iba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
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

        UserEntity entityToSave = userMapper.convertToEntity(userDto);
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) throw new RuntimeException("Email already exists!");
//        if (validation by user email already exist)
//                        .orElseThrow(() -> new ServiceException("User exist"));

//        int count = userRepository.save(entityToSave);
        userRepository.save(entityToSave);

//        System.out.println(count);

//        return userDto;

        return userMapper.convertToDto(entityToSave);
    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> users = userRepository.findAll();

        return userMapper.convertToList(users);
    }
}
