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
}
