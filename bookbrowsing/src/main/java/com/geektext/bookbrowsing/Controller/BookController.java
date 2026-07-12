package com.geektext.bookbrowsing.Controller;

import com.geektext.bookbrowsing.Entity.BookEntity;
import com.geektext.bookbrowsing.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Specifies this is a Controller class
// Main purpose of Controller is to define the
// path and Rest API action
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

    /**
     * GET function to retrieve books with input rating and higher
     * @param rating
     * @return JSON data of books with input rating and higher
     */
    @GetMapping("/rated")
    public List<BookEntity> getBooksRatedOver(@RequestParam double rating) {
        return bookService.searchBooksByRatingAndOver(rating);
    }

    /**
     * Top 10
     * @return
     */
    @GetMapping("/topsellers")
    public List<BookEntity> getTopSellers() {
        return bookService.getTopSellers();
    }

    /**
     * Discount
     */
//    @PutMapping("/publisher/{publisher}/discount")
//    public void applyDiscount(@PathVariable String publisher,
//                              @RequestParam Double discountPercent) {
//        bookService.applyDiscountByPublisher(discountPercent, publisher);
//    }


}
