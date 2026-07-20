package com.example.geektext.repository;

import com.example.geektext.model.Wishlist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WishlistRepository {

    private final List<Wishlist> wishlists = new ArrayList<>();

    public Wishlist save(Wishlist wishlist) {
        wishlists.add(wishlist);
        return wishlist;
    }

    public List<Wishlist> findAll() {
        return new ArrayList<>(wishlists);
    }

    public Optional<Wishlist> findById(Long wishlistId) {
        return wishlists.stream()
                .filter(wishlist -> wishlist.getWishlistId().equals(wishlistId))
                .findFirst();
    }

    public void deleteById(Long wishlistId) {
        wishlists.removeIf(
                wishlist -> wishlist.getWishlistId().equals(wishlistId)
        );
    }
}