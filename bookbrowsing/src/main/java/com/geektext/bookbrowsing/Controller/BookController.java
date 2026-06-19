package com.geektext.bookbrowsing.Controller;

import com.geektext.bookbrowsing.Entity.BookEntity;
import com.geektext.bookbrowsing.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Specifies this is a Controller class
@RestController
public class BookController {

    //This annotation allows us to reference our Service object
    @Autowired
    private BookService bookService;

    // RequestBody will allow us to request JSON of our book
    // POST function
    @PostMapping("/addBook")
    public BookEntity postBookDetails(@RequestBody BookEntity bookEntity) {
        return bookService.saveBookDetails(bookEntity);
    }

    // GET function
    // returns JSON data for all books in database
    @GetMapping("/")
    public List<BookEntity> getBooks() {
        return bookService.getBooks();
    }
}
