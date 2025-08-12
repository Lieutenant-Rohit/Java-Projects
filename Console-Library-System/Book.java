import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String author;
    private boolean isIssued;
    private String issuedTo;

    public Book(){

    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    // Setters
    public void setIssued(boolean issued) { this.isIssued = issued; }

    @Override
    public String toString() {
        return "Book{" +
                "ID='" + id + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Issued=" + isIssued +
                '}';
    }

    public String getIsIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIssuedTo() {
        return issuedTo;
    }
}