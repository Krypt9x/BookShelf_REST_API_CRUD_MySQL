package BookShelfAPICRUD.BookShelfAPICRUD;

import java.util.List;

public interface BooksService {
    public Books addNewBook(Books B) throws RecordNotFoundException;
    public List<Books> getAllBooks();
    public Books getBookById(Integer Id) throws RecordNotFoundException;
    public Books editBookById(Books b, Integer Id) throws RecordNotFoundException;
    public void deleteBookById(Integer id);

}
