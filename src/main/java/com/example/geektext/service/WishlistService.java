package com.example.geektext.service;

import com.example.geektext.model.Wishlist;
import com.example.geektext.model.WishlistBook;
import com.example.geektext.repository.WishlistBookRepository;
import com.example.geektext.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final WishlistBookRepository wishlistBookRepository;

    private final AtomicLong wishlistIdCounter = new AtomicLong(1);
    private final AtomicLong wishlistBookIdCounter = new AtomicLong(1);

    public WishlistService(
            WishlistRepository wishlistRepository,
            WishlistBookRepository wishlistBookRepository
    ) {
        this.wishlistRepository = wishlistRepository;
        this.wishlistBookRepository = wishlistBookRepository;
    }

    public Wishlist createWishlist(Long userId, String wishlistName) {
        Wishlist wishlist = new Wishlist(
                wishlistIdCounter.getAndIncrement(),
                userId,
                wishlistName
        );

        return wishlistRepository.save(wishlist);
    }

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    public WishlistBook addBook(Long wishlistId, Long bookId) {
        WishlistBook wishlistBook = new WishlistBook(
                wishlistBookIdCounter.getAndIncrement(),
                wishlistId,
                bookId
        );

        return wishlistBookRepository.save(wishlistBook);
    }

    public List<WishlistBook> getBooks(Long wishlistId) {
        return wishlistBookRepository.findByWishlistId(wishlistId);
    }

    public boolean removeBook(Long wishlistId, Long bookId) {
        return wishlistBookRepository
                .deleteByWishlistIdAndBookId(wishlistId, bookId);
    }
}