package by.iba.domain;

public class BookEntity {

    private Long id;
    private int numberOfPages;
    private String title;

    public BookEntity(){

    }

    public BookEntity(Long id, int numberOfPages, String title) {
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
}
