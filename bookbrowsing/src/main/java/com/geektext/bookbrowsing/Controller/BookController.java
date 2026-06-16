package com.geektext.bookbrowsing.Controller;


import com.geektext.bookbrowsing.Entity.BookEntity;
import com.geektext.bookbrowsing.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Specifies this is a Controller class
@RestController
public class BookController {

    // This annotation allows to reference our service object
    @Autowired
    private BookService bookService;

    // RequestBody will allow us to request JSON of our book
    // PostMapping denotes this is our POST function
    @PostMapping("/addBook")
    public BookEntity postBookDetails(@RequestBody BookEntity bookEntity) {
        return bookService.saveBookDetails(bookEntity);
    }
}
