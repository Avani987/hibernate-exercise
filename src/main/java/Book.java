package main.java;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Book {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    int bookId;
    private String bookName;
    @ManyToMany(mappedBy = "book")
    Collection<Author> author=new ArrayList<>();

    public Collection<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Collection<Author> author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book Name: "+ getBookName();
    }
}
