package com.geektext.bookbrowsing.Repository;

import com.geektext.bookbrowsing.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * extends JpaRepository<Entity, Primary Key Data Type>
 *     allows for us to perform all query operations
 *     to our database entity
 */
public interface BookRepository extends JpaRepository<BookEntity, String> {
}
