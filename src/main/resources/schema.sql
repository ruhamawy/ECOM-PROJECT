CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    descrb VARCHAR(255),
    brand VARCHAR(255),
    category VARCHAR(255),

    price DOUBLE,
    available BOOLEAN,
    quantity INT

);
