package by.iba.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;

    public UserDto(){

    }

    public UserDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
