package by.iba.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookDto implements Serializable {

    private Long id;
    private int numberOfPages;
    private String title;

    private List<AuthorDto> authors = new ArrayList<>();

    public BookDto() {

    }

    public BookDto(Long id, int numberOfPages, String title) {
        this.id = id;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }
}
