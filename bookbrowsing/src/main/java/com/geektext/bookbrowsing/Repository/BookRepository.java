package com.geektext.bookbrowsing.Repository;

import com.geektext.bookbrowsing.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * extends JpaRepository<Entity, Primary Key Data Type>
 *     allows for us to perform all query operations
 *     to our database entity
 */
public interface BookRepository extends JpaRepository<BookEntity, String> {

    /**
     * Query equivalent to "SELECT * FROM BOOK_DETAIlS WHERE genre LIKE %keyword%
     * finding genres containing 'keyword'
     * @param keyword search input
     * @return JSON data for books with genre matching keyword input
     */
    @Query("SELECT b FROM BookEntity b WHERE " +
            "LOWER(b.genre) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BookEntity> findBooksByGenre(@Param("keyword") String keyword);

    /**
     * Query equivalent to "SELECT * FROM BOOK_DETAILS WHERE brating >=3"
     * finds books with particular rating and over
     * @param rating book rating score
     * @return JSON data for books containing searched rating and higher
     */
    @Query("SELECT b FROM BookEntity  b WHERE b.rating >= :rating")
    List<BookEntity> findBooksByRatingOver(@Param("rating") double rating);
}
