package BookShelfAPICRUD.BookShelfAPICRUD;


import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bookshelf")
public class Books{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "read_page")
    private int readPage;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "finished")
    private boolean finished;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "updatedAt")
    private String updateAt;

}
