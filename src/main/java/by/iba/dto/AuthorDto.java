package by.iba.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

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


    public AuthorDto(){

    }

    public AuthorDto(Long id, String firstName, String lastName, Date dateOfBirth, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
