package com.geektext.bookbrowsing.Service;

import com.geektext.bookbrowsing.Entity.BookEntity;
import com.geektext.bookbrowsing.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.awt.print.Pageable;
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

    // Searching for books by genre provided by keyword
    public List<BookEntity> searchBooksByGenre(String keyword) {
        return bookRepo.findBooksByGenre(keyword);
    }

    // Searching for books with rating [input] and above
    public List<BookEntity>searchBooksByRatingAndOver(double rating) {
        return bookRepo.findBooksByRatingOver(rating);
    }

    // Find top 10 sellers
    public List<BookEntity> getTopSellers() {
        return bookRepo.findTopSellers();
    }

    // Discount books by publisher
    @Transactional
    public void applyDiscountByPublisher(double discountPercent, String publisher) {
        // Get all books by publisher
        List<BookEntity> booksByPublisher = bookRepo.findBooksByPublisher(publisher);

        // Apply discount to each book
        booksByPublisher.forEach(b -> {
            double originalPrice = b.getPrice();
            double newPrice = originalPrice * (1 - discountPercent/ 100.0);
            b.setPrice(Math.round(newPrice * 100.0) / 100.0);
        });

        // Save changes
        bookRepo.saveAll(booksByPublisher);

    }


}
