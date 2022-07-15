package BookShelfAPICRUD.BookShelfAPICRUD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Books, Integer> {
}
