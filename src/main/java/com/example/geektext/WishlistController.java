package com.example.geektext;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @GetMapping("/{wishlistId}/books")
    public List<String> getWishlistBooks(@PathVariable("wishlistId") int wishlistId) {
        return Arrays.asList("Harry Potter", "The Hobbit", "Clean Code");
    }

    @PostMapping
    public String createWishlist() {
        return "Wishlist created";
    }

    @PostMapping("/{wishlistId}/books/{bookId}")
    public String addBookToWishlist(@PathVariable("wishlistId") int wishlistId,
                                    @PathVariable("bookId") int bookId) {
        return "Book added to wishlist";
    }

    @DeleteMapping("/{wishlistId}/books/{bookId}")
    public String removeBook(@PathVariable("wishlistId") int wishlistId,
                             @PathVariable("bookId") int bookId){
        return "Book removed from wishlist";
    }
}
