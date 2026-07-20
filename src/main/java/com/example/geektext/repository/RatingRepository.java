package com.example.geektext.repository;

import com.example.geektext.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query("SELECT AVG(r.stars) FROM Rating r WHERE r.book.bookId = :bookId")
    Double findAverageStarsByBookId(@Param("bookId") Integer bookId);

    long countByBook_BookId(Integer bookId);
}
