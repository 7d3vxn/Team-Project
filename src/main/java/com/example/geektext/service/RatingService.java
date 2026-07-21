package com.example.geektext.service;

import com.example.geektext.dto.RatingRequest;
import com.example.geektext.dto.RatingSummary;
import com.example.geektext.entity.Book;
import com.example.geektext.entity.Rating;
import com.example.geektext.entity.User;
import com.example.geektext.exception.ResourceNotFoundException;
import com.example.geektext.repository.BookRepository;
import com.example.geektext.repository.RatingRepository;
import com.example.geektext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Rating createRating(RatingRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + request.getBookId()));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));

        Rating rating = new Rating();
        rating.setBook(book);
        rating.setUser(user);
        rating.setStars(request.getStars());

        return ratingRepository.save(rating);
    }

    public RatingSummary getAverageRating(Integer bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new ResourceNotFoundException("Book not found with id: " + bookId);
        }

        Double avg = ratingRepository.findAverageStarsByBookId(bookId);
        long total = ratingRepository.countByBook_BookId(bookId);
        double rounded = (avg == null) ? 0.0 : Math.round(avg * 100.0) / 100.0;

        return new RatingSummary(bookId, rounded, total);
    }
}
