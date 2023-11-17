package by.iba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto implements Serializable {

    private Long id;
    @NotBlank(message = "The firstName is required.")
    @Size(min = 3, max = 30)
    private String firstName;
    @NotBlank(message = "The lastName is required.")
    @Size(min = 3, max = 30)
    private String lastName;
    @NotNull(message = "The date of birth is required.")
    @Past(message = "The date of birth must be in the past.")
    private Date dateOfBirth;
    @NotBlank(message = "The country is required.")
    @Size(min = 3, max = 30)
    private String country;
    private boolean isDeleted;

}
