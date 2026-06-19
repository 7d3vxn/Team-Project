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

    @Query("SELECT b FROM BookEntity b WHERE " +
            "LOWER(b.genre) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BookEntity> findBooksByGenre(@Param("keyword") String keyword);
}
