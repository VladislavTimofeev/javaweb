package by.iba.mapper;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto convertToDto(UserEntity userEntity) {

        UserDto userDto = new UserDto();

        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setAge(userEntity.getAge());
        userDto.setEmail(userEntity.getEmail());
        userDto.setDateOfBirth(userEntity.getDateOfBirth());
        userDto.setPassword(userEntity.getPassword());

        return userDto;
    }

    public static UserEntity convertToEntity(UserDto userDto) {

        UserEntity userEntity = new UserEntity();

        userEntity.setId(userDto.getId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setAge(userDto.getAge());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setDateOfBirth(userDto.getDateOfBirth());
        userEntity.setPassword(userDto.getPassword());

        return userEntity;
    }

    public static List<UserDto> convertToList(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(UserMapper::convertToDto)
                .collect(Collectors.toList());
    }

}
