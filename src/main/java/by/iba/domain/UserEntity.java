package by.iba.domain;

public class UserEntity {

    private Long id;
    private String firstName;
    private String lastName;

    public UserEntity(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserEntity(Long id) {
        this.id = id;
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
}
