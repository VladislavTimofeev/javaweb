package by.iba.mapper;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public UserDto convertToDto(UserEntity user) {

        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName());

        return userDto;
    }

    public UserEntity convertToEntity(UserDto userDto) {

        UserEntity userEntity = new UserEntity(userDto.getId(), userDto.getFirstName(), userDto.getLastName());

        return userEntity;
    }

    public List<UserDto> convertToList(List<UserEntity> users) {
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
