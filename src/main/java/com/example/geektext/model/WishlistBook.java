package com.example.geektext.model;

public class WishlistBook {

    private Long wishlistId;
    private Long bookId;

    public WishlistBook() {
    }

    public WishlistBook(Long wishlistId, Long bookId) {
        this.wishlistId = wishlistId;
        this.bookId = bookId;
    }

    public Long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}