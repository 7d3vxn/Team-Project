package com.example.geektext.model;

public class Wishlist {

    private Long wishlistId;
    private Long userId;
    private String wishlistName;

    public Wishlist() {
    }

    public Wishlist(Long wishlistId, Long userId, String wishlistName) {
        this.wishlistId = wishlistId;
        this.userId = userId;
        this.wishlistName = wishlistName;
    }

    public Long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}