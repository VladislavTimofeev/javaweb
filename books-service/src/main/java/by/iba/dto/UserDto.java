package by.iba.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @NotBlank(message = "The password is required.")
    @Size(min = 6, message = "Password must have at least 6 characters")
    private String password;
    @NotNull(message = "The date of birth is required.")
    @Past(message = "The date of birth must be in the past.")
    private Date dateOfBirth;
}
