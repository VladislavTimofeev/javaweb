package by.iba.mapper;

import by.iba.domain.UserEntity;
import by.iba.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserDto convertToDto(UserEntity user) {

        UserDto userDto = new UserDto(user.getId());

        return userDto;
    }

}
