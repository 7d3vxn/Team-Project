package com.example.geektext.service;

import com.example.geektext.dto.CommentRequest;
import com.example.geektext.dto.CommentResponse;
import com.example.geektext.entity.Book;
import com.example.geektext.entity.Comment;
import com.example.geektext.entity.User;
import com.example.geektext.exception.ResourceNotFoundException;
import com.example.geektext.repository.BookRepository;
import com.example.geektext.repository.CommentRepository;
import com.example.geektext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Comment createComment(CommentRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + request.getBookId()));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));

        Comment comment = new Comment();
        comment.setBook(book);
        comment.setUser(user);
        comment.setCommentText(request.getCommentText());

        return commentRepository.save(comment);
    }

    public List<CommentResponse> getCommentsByBook(Integer bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new ResourceNotFoundException("Book not found with id: " + bookId);
        }

        return commentRepository.findByBook_BookIdOrderByCreatedAtDesc(bookId)
                .stream()
                .map(c -> new CommentResponse(
                        c.getCommentId(),
                        c.getBook().getBookId(),
                        c.getUser().getUserId(),
                        c.getUser().getUsername(),
                        c.getCommentText(),
                        c.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
