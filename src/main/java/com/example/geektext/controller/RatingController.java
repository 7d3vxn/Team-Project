package com.example.geektext.controller;

import com.example.geektext.dto.RatingRequest;
import com.example.geektext.dto.RatingSummary;
import com.example.geektext.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    /**
     * POST /api/ratings
     * Create a rating (1-5 stars) for a book by a user.
     * Body: { "bookId": 1, "userId": 1, "stars": 5 }
     */
    @PostMapping("/ratings")
    public ResponseEntity<Void> createRating(@Valid @RequestBody RatingRequest request) {
        ratingService.createRating(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * GET /api/books/{bookId}/rating
     * Get the average star rating (and total count) for a specific book.
     */
    @GetMapping("/books/{bookId}/rating")
    public ResponseEntity<RatingSummary> getAverageRating(@PathVariable Integer bookId) {
        return ResponseEntity.ok(ratingService.getAverageRating(bookId));
    }
}
