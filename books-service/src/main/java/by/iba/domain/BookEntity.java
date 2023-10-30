package by.iba.domain;

import java.util.ArrayList;
import java.util.List;

public class BookEntity {
    private Long id;
    private int numberOfPages;
    private String title;
    private int releaseYear;

    private List<AuthorEntity> authors = new ArrayList<>();

    public BookEntity() {

    }

    public BookEntity(Long id, int numberOfPages, String title, int releaseYear) {
        this.id = id;
        this.numberOfPages = numberOfPages;
        this.title = title;
        this.releaseYear = releaseYear;
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

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }
}
