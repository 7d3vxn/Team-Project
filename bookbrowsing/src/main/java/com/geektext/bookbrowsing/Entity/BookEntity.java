package com.geektext.bookbrowsing.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Allows SpringBoot to recognize this class
// corresponds to a table in the database
@Entity
// Creates setters and getters for each data field
@Data
// Denotes the table name that will be present in MySQL
@Table(name = "Book_Details")
// Constructors
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    // Notes this field as the primary key for this table
    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "authfname")
    private String authfname;

    @Column(name = "authminit")
    private char authminit;

    @Column(name = "authlname")
    private String authlname;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "soldcopies")
    private int soldcopies;

    @Column(name = "price")
    private double price;

    @Column(name = "rating")
    private double rating;
}

