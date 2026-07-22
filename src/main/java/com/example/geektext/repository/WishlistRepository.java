package com.example.geektext.repository;

import com.example.geektext.model.Wishlist;

import java.util.ArrayList;
import java.util.List;

public class WishlistRepository {

    private final List<Wishlist> wishlists = new ArrayList<>();

    public Wishlist save(Wishlist wishlist) {
        wishlists.add(wishlist);
        return wishlist;
    }

    public List<Wishlist> findAll() {
        return new ArrayList<>(wishlists);
    }

    public int countByUserId(Long userId) {
        int count = 0;

        for (Wishlist wishlist : wishlists) {
            if (wishlist.getUserId() != null &&
                    wishlist.getUserId().equals(userId)) {
                count++;
            }
        }

        return count;
    }

    public boolean existsByUserIdAndWishlistName(
            Long userId,
            String wishlistName) {

        for (Wishlist wishlist : wishlists) {
            boolean sameUser =
                    wishlist.getUserId() != null &&
                            wishlist.getUserId().equals(userId);

            boolean sameName =
                    wishlist.getWishlistName() != null &&
                            wishlistName != null &&
                            wishlist.getWishlistName()
                                    .equalsIgnoreCase(wishlistName);

            if (sameUser && sameName) {
                return true;
            }
        }

        return false;
    }
}