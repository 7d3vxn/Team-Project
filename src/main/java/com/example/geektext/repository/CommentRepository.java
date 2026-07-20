package com.example.geektext.repository;

import com.example.geektext.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByBook_BookIdOrderByCreatedAtDesc(Integer bookId);
}
