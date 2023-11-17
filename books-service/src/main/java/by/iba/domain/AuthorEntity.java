package by.iba.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {

    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String country;
    private boolean isDeleted;

}
