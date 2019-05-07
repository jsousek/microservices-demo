CREATE TABLE users( id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(30),
                    hashed_password VARCHAR(45),
                    is_logged BIT);