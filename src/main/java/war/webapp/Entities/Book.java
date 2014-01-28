package war.webapp.Entities;

import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Book")
public class Book implements Serializable {

    @Id
    @Column(name = "isbn")
    @SearchableId
    public String id;

    @Column
    @SearchableProperty
    public String title;

    @Column
    @SearchableProperty
    public String author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
