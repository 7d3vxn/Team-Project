package com.example.geektext.service;

import com.example.geektext.model.Wishlist;
import com.example.geektext.model.WishlistBook;
import com.example.geektext.repository.WishlistBookRepository;
import com.example.geektext.repository.WishlistRepository;

import java.util.List;

public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final WishlistBookRepository wishlistBookRepository;
    private long nextWishlistId = 1;

    public WishlistService() {
        this.wishlistRepository = new WishlistRepository();
        this.wishlistBookRepository = new WishlistBookRepository();
    }

    public void createWishlist(Long userId, String wishlistName) {

        if (wishlistRepository.countByUserId(userId) >= 3) {
            throw new IllegalArgumentException(
                    "A user can only have 3 wishlists");
        }

        if (wishlistRepository.existsByUserIdAndWishlistName(
                userId,
                wishlistName)) {

            throw new IllegalArgumentException(
                    "Wishlist name must be unique");
        }

        Wishlist wishlist = new Wishlist(
                nextWishlistId++,
                userId,
                wishlistName
        );

        wishlistRepository.save(wishlist);
    }

    public void addBook(Long wishlistId, Long bookId) {
        WishlistBook wishlistBook =
                new WishlistBook(wishlistId, bookId);

        wishlistBookRepository.save(wishlistBook);
    }

    public List<WishlistBook> getWishlistBooks(Long wishlistId) {
        return wishlistBookRepository.findByWishlistId(wishlistId);
    }

    public void removeBook(Long wishlistId, Long bookId) {
        wishlistBookRepository.delete(wishlistId, bookId);
    }
}