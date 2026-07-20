package com.example.geektext.repository;

import com.example.geektext.model.WishlistBook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WishlistBookRepository {

    private final List<WishlistBook> wishlistBooks = new ArrayList<>();

    public WishlistBook save(WishlistBook wishlistBook) {
        wishlistBooks.add(wishlistBook);
        return wishlistBook;
    }

    public List<WishlistBook> findByWishlistId(Long wishlistId) {
        List<WishlistBook> results = new ArrayList<>();

        for (WishlistBook wishlistBook : wishlistBooks) {
            if (wishlistBook.getWishlistId().equals(wishlistId)) {
                results.add(wishlistBook);
            }
        }

        return results;
    }

    public boolean deleteByWishlistIdAndBookId(
            Long wishlistId,
            Long bookId
    ) {
        return wishlistBooks.removeIf(
                wishlistBook ->
                        wishlistBook.getWishlistId().equals(wishlistId)
                                && wishlistBook.getBookId().equals(bookId)
        );
    }
}