package com.example.geektext.model;

public class WishlistBook {

    private Long wishlistBookId;
    private Long wishlistId;
    private Long bookId;

    public WishlistBook() {
    }

    public WishlistBook(Long wishlistBookId, Long wishlistId, Long bookId) {
        this.wishlistBookId = wishlistBookId;
        this.wishlistId = wishlistId;
        this.bookId = bookId;
    }

    public Long getWishlistBookId() {
        return wishlistBookId;
    }

    public void setWishlistBookId(Long wishlistBookId) {
        this.wishlistBookId = wishlistBookId;
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
