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
public class UserEntity {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Date dateOfBirth;

}
