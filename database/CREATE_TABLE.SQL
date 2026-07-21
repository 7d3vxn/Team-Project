CREATE DATABASE geektext;

USE geektext;

CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       name VARCHAR(100),
                       email VARCHAR(100),
                       address VARCHAR(200)
);

CREATE TABLE wishlists (
                           wishlist_id INT AUTO_INCREMENT PRIMARY KEY,
                           user_id INT NOT NULL,
                           wishlist_name VARCHAR(100) NOT NULL
);

CREATE TABLE wishlist_books (
                                wishlist_book_id INT AUTO_INCREMENT PRIMARY KEY,
                                wishlist_id INT NOT NULL,
                                book_id INT NOT NULL
);

INSERT INTO users
(username, password, name, email)
VALUES
    ('Migdony', 'Dony2000', 'Migdony Romero', 'migdony07@gmail.com');

SELECT * FROM users;