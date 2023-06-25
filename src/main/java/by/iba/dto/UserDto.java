package by.iba.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    private Long id;

    public UserDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
