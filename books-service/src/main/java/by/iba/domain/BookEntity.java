package by.iba.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    private Long id;
    private int numberOfPages;
    private String title;
    private int releaseYear;
    private double price;
    private List<AuthorEntity> authors = new ArrayList<>();

    public BookEntity(long id, int numberOfPages, String title, int releaseYear, double price) {
        this.id = id;
        this.numberOfPages = numberOfPages;
        this.title = title;
        this.releaseYear = releaseYear;
        this.price = price;
    }
}
