package com.example.geektext.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CommentRequest {

    @NotNull(message = "bookId is required")
    private Integer bookId;

    @NotNull(message = "userId is required")
    private Integer userId;

    @NotBlank(message = "commentText cannot be empty")
    private String commentText;

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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
