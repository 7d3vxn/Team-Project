package com.example.geektext;

import com.example.geektext.model.WishlistBook;
import com.example.geektext.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistService wishlistService =
            new WishlistService();

    @PostMapping
    public ResponseEntity<Void> createWishlist(
            @RequestParam("userId") Long userId,
            @RequestParam("wishlistName") String wishlistName) {

        wishlistService.createWishlist(userId, wishlistName);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{wishlistId}/books/{bookId}")
    public ResponseEntity<Void> addBook(
            @PathVariable("wishlistId") Long wishlistId,
            @PathVariable("bookId") Long bookId) {

        wishlistService.addBook(wishlistId, bookId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{wishlistId}/books")
    public List<WishlistBook> getWishlistBooks(
            @PathVariable("wishlistId") Long wishlistId) {

        return wishlistService.getWishlistBooks(wishlistId);
    }

    @DeleteMapping("/{wishlistId}/books/{bookId}")
    public ResponseEntity<Void> removeBook(
            @PathVariable("wishlistId") Long wishlistId,
            @PathVariable("bookId") Long bookId) {

        wishlistService.removeBook(wishlistId, bookId);
        return ResponseEntity.ok().build();
    }
}