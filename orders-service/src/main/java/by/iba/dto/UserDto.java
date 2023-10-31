package by.iba.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class UserDto implements Serializable {

    private Long id;
    @NotBlank(message = "The firstName is required.")
    @Size(min = 3, max = 30)
    private String firstName;
    @NotBlank(message = "The lastName is required.")
    @Size(min = 3, max = 30)
    private String lastName;
    @NotNull(message = "The age is required.")
    @Positive
    private int age;
    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.")
    private String email;
    @NotNull(message = "The date of birth is required.")
    @Past(message = "The date of birth must be in the past.")
    private Date dateOfBirth;


    public UserDto() {

    }

    public UserDto(Long id, String firstName, String lastName, int age, String email, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
