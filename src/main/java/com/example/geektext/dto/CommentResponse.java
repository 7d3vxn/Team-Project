package com.example.geektext.dto;

import java.time.LocalDateTime;

/**
 * Returned instead of the raw Comment entity so the nested User (which
 * has a password column) can never be serialized back through this
 * feature's API.
 */
public class CommentResponse {

    private Integer commentId;
    private Integer bookId;
    private Integer userId;
    private String username;
    private String commentText;
    private LocalDateTime createdAt;

    public CommentResponse() {
    }

    public CommentResponse(Integer commentId, Integer bookId, Integer userId,
                            String username, String commentText, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.bookId = bookId;
        this.userId = userId;
        this.username = username;
        this.commentText = commentText;
        this.createdAt = createdAt;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
