package com.geektext.bookbrowsing.Service;

import com.geektext.bookbrowsing.Entity.BookEntity;
import com.geektext.bookbrowsing.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service allows us to access our Entity through the Repository
 * (We cannot access the Entity directly)
 */
@Service
public class BookService {

    // This annotation allows to reference our repository
    @Autowired
    private BookRepo bookRepo;

    public BookEntity saveBookDetails(BookEntity bookEntity){
        // .save() saves the data to our table
        return bookRepo.save(bookEntity);
    }
}
