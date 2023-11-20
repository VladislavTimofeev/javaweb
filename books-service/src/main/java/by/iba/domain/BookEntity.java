package by.iba.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "number_of_pages")
    private int numberOfPages;
    @Column(name = "title")
    private String title;
    @Column(name = "release_year")
    private int releaseYear;
    @Column(name = "price")
    private double price;

    //private List<AuthorEntity> authors = new ArrayList<>();

}
