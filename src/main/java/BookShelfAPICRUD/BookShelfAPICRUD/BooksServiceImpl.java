package BookShelfAPICRUD.BookShelfAPICRUD;


import org.aspectj.apache.bcel.classfile.ExceptionTable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService{
    BooksRepo repo;

    public BooksServiceImpl(BooksRepo repo){
        super();
        this.repo = repo;
    }

    @Override
    public Books addNewBook(Books b)throws RecordNotFoundException{
        if(b.getReadPage() > b.getPageCount()){
            throw new RecordNotFoundException("Err");
        }
        if(b.getReadPage() == b.getPageCount()){
            b.setFinished(true);
        }else {
            b.setFinished(false);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        b.setCreatedAt(dtf.format(now));
        b.setUpdateAt(dtf.format(now));
        return repo.save(b);
    }

    @Override
    public List<Books> getAllBooks(){
        return repo.findAll();
    }

    @Override
    public Books getBookById(Integer Id) throws RecordNotFoundException {
        Optional<Books> book = repo.findById(Id);
        if(book.isPresent()) {
            return book.get();
        }else {
            throw new RecordNotFoundException("Not Found");
        }
    }

    public Books editBookById(Books b, Integer Id) throws RecordNotFoundException {
        Books book = repo.findById(Id).get();
        if(book.getId() != 0){
            book.setAuthor(b.getAuthor());
            book.setTitle(b.getTitle());
            book.setPublisher(b.getPublisher());
            book.setReadPage(b.getReadPage());
            book.setPageCount(b.getPageCount());
            if(book.getReadPage() > book.getPageCount()){
                throw new RecordNotFoundException("Read Page tidak boleh lebih besar dari Page Count");
            }
            if(book.getReadPage() == book.getPageCount()){
                book.setFinished(true);
            }else{
                book.setFinished(false);
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            book.setUpdateAt(dtf.format(now));
        }else{
            throw new RecordNotFoundException("Not Found");
        }
        repo.save(book);
        return book;
    }

    @Override
    public void deleteBookById(Integer Id){
        repo.deleteById(Id);
    }

}
