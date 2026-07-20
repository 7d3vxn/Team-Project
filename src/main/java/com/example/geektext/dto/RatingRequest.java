package com.example.geektext.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RatingRequest {

    @NotNull(message = "bookId is required")
    private Integer bookId;

    @NotNull(message = "userId is required")
    private Integer userId;

    @NotNull(message = "stars is required")
    @Min(value = 1, message = "stars must be between 1 and 5")
    @Max(value = 5, message = "stars must be between 1 and 5")
    private Integer stars;

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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
