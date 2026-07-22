package com.example.geektext.repository;

import com.example.geektext.model.WishlistBook;
import java.util.ArrayList;
import java.util.List;

public class WishlistBookRepository {

    private final List<WishlistBook> wishlistBooks = new ArrayList<>();

    public WishlistBook save(WishlistBook wishlistBook) {
        wishlistBooks.add(wishlistBook);
        return wishlistBook;
    }

    public List<WishlistBook> findByWishlistId(Long wishlistId) {
        List<WishlistBook> books = new ArrayList<>();

        for (WishlistBook wishlistBook : wishlistBooks) {
            if (wishlistBook.getWishlistId().equals(wishlistId)) {
                books.add(wishlistBook);
            }
        }

        return books;
    }

    public void delete(Long wishlistId, Long bookId) {
        wishlistBooks.removeIf(book ->
                book.getWishlistId().equals(wishlistId)
                        && book.getBookId().equals(bookId));
    }
}
