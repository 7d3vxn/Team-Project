package com.geektext.bookbrowsing.Controller;

import com.geektext.bookbrowsing.Entity.BookEntity;
import com.geektext.bookbrowsing.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Specifies this is a Controller class
@RestController
public class BookController {

    //This annotation allows us to reference our Service object
    @Autowired
    private BookService bookService;
    /**
     * POST function to add books to our database
     * RequestBody will allow us to request JSON of our book
     * @param bookEntity
     * @return JSON with
     */
    @PostMapping("/addBook")
    public BookEntity postBookDetails(@RequestBody BookEntity bookEntity) {
        return bookService.saveBookDetails(bookEntity);
    }

    /**
     * Simple GET function
     * @return All books in database
     */
    @GetMapping("/allBooks")
    public List<BookEntity> getBooks() {
        return bookService.getBooks();
    }

    /**
     * GET function to search books by genre, take multiple
     * word inputs (EX. "Young Adult")
     * @param keyword
     * @return Books with genre matching keyword input
     */
    @GetMapping("/search")
    public ResponseEntity<List<BookEntity>> getBooksByGenre(@RequestParam String keyword) {
        List<BookEntity> foundBooks = bookService.searchBooksByGenre(keyword);
        if (!foundBooks.isEmpty()) {
            return ResponseEntity.ok(foundBooks);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
