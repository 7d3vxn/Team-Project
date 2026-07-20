package com.example.geektext.controller;

import com.example.geektext.dto.CommentRequest;
import com.example.geektext.dto.CommentResponse;
import com.example.geektext.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * POST /api/comments
     * Create a comment for a book by a user.
     * Body: { "bookId": 1, "userId": 1, "commentText": "Great book!" }
     */
    @PostMapping("/comments")
    public ResponseEntity<Void> createComment(@Valid @RequestBody CommentRequest request) {
        commentService.createComment(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * GET /api/books/{bookId}/comments
     * Retrieve all comments for a specific book, newest first.
     */
    @GetMapping("/books/{bookId}/comments")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Integer bookId) {
        return ResponseEntity.ok(commentService.getCommentsByBook(bookId));
    }
}
