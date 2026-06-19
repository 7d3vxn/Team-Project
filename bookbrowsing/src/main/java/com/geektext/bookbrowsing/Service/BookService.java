package com.geektext.bookbrowsing.Service;

import com.geektext.bookbrowsing.Entity.BookEntity;
import com.geektext.bookbrowsing.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service allows us to access our Entity through
 * the Repository (We cannot access Entity directly)
 */
@Service
public class BookService {
    //This annotation allows us to reference our repository
    @Autowired
    private BookRepository bookRepo;
    public BookEntity saveBookDetails(BookEntity bookEntity){
        //.save() saves the data to our table
        return bookRepo.save(bookEntity);
    }

    // Fetches all Books
    public List<BookEntity>getBooks() {
        return bookRepo.findAll();
    }

    public List<BookEntity> searchBooksByGenre(String keyword) {
        return bookRepo.findBooksByGenre(keyword);
    }

}
