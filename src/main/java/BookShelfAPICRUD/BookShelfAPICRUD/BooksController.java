package BookShelfAPICRUD.BookShelfAPICRUD;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookshelf")
public class BooksController {
    private BooksService service;

    public BooksController(BooksService service){
        super();
        this.service = service;
    }
    
    //1. Post REST API 
    @PostMapping
    public ResponseEntity<Books> saveProduct(@RequestBody Books b) throws RecordNotFoundException{

        return new ResponseEntity<Books>(service.addNewBook(b), HttpStatus.CREATED);
    }

    //2. Get REST API
    @GetMapping
    public List<Books> getAllProducts() {
        return service.getAllBooks();
    }

    //3. Get REST API by Id
    @GetMapping("{id}")
    public ResponseEntity<Books> getBookById(@PathVariable("id") Integer Id) throws RecordNotFoundException {
        return new ResponseEntity<Books>(service.getBookById(Id), HttpStatus.OK);
    }

    //4. Update REST API
    @PutMapping("{id}")
    public ResponseEntity<Books> updateProduct(@RequestBody Books b, @PathVariable("id") Integer Id) throws RecordNotFoundException {
        return new ResponseEntity<Books>(service.editBookById(b, Id), HttpStatus.OK);

    }

    //4 Delete REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int Id) {
        service.deleteBookById(Id);
        return new ResponseEntity<String>("Success Deleted Books id : " + Id, HttpStatus.OK);
    }
}
