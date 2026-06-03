
USE geektext;
DESCRIBE users;

INSERT INTO users
(username,password,name,email)
VALUES
    ('eric', 'test123', 'Eric Rowland', 'eric@test.com');

SELECT * FROM users;

CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR (100) NOT NULL,
                       name VARCHAR(100),
                       email VARCHAR(100),
                       address VARCHAR(200)
);

CREATE TABLE credit_cards (
                              card_id INT AUTO_INCREMENT PRIMARY KEY,
                              card_number VARCHAR(20) NOT NULL,
                              expiration_date VARCHAR(10) NOT NULL,
                              cvv VARCHAR(4) NOT NULL,
                              user_id INT NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(user_id)
);
