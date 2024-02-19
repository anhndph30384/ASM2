CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    category VARCHAR(250) NOT NULL,
    quantity int NOT NULL,
    price float(53) NOT NULL
);
INSERT INTO
    users (username, password)
VALUES
    ('anhndph30384', 'admin30384'),
    ('thanhndph90001', 'user90001');
INSERT INTO
    products (name, category, quantity, price)
VALUES
    ('iPhone 9', 'Apple', 2, 10000000),
    ('Redmi Note 11', 'Xiaomi', 3, 1200000),
    ('Xiaomi 13T Pro', 'Xiaomi',3, 4300000);