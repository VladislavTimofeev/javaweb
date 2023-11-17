package by.iba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto implements Serializable {

    private Long id;
    private int numberOfPages;
    private String title;
    private int releaseYear;
    private double price;

    private List<AuthorDto> authors = new ArrayList<>();

}
