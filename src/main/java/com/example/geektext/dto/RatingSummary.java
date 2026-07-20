package com.example.geektext.dto;

public class RatingSummary {

    private Integer bookId;
    private double averageRating;
    private long totalRatings;

    public RatingSummary() {
    }

    public RatingSummary(Integer bookId, double averageRating, long totalRatings) {
        this.bookId = bookId;
        this.averageRating = averageRating;
        this.totalRatings = totalRatings;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public long getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(long totalRatings) {
        this.totalRatings = totalRatings;
    }
}
