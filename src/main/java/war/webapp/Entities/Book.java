package war.webapp.Entities;

import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Book")
public class Book implements Serializable {

    private static final long serialVersionUID = 3832626162173359411L;

    @Id
    @Column
    @SearchableId
    public Long id;

    @Column
    @SearchableProperty
    public String title;

    @Column
    @SearchableProperty
    public String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
