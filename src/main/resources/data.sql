--DROP TABLE IF EXISTS customer_order;
--DROP TABLE IF EXISTS customer;
--
--CREATE TABLE customer (
-- id int(11) unsigned NOT NULL AUTO_INCREMENT,
-- first_name varchar(300) NOT NULL DEFAULT '',
-- last_name varchar(300) NOT NULL DEFAULT '',
-- email varchar(300) NOT NULL DEFAULT '',
--   status varchar(300) NOT NULL DEFAULT 'REGULAR',
--   PRIMARY KEY (id)
--);
--
--CREATE TABLE customer_order (
-- id int(11) unsigned NOT NULL AUTO_INCREMENT,
-- customer_id int(11) unsigned NOT NULL,
-- item_name varchar(300) NOT NULL DEFAULT '',
-- price DECIMAL(100,2) NOT NULL DEFAULT  0.00,
-- PRIMARY KEY (id),
--FOREIGN KEY (customer_id) REFERENCES customer(id)
--);

DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS student;

CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(300) NOT NULL DEFAULT '',
    last_name VARCHAR(300) NOT NULL DEFAULT '',
    email VARCHAR(300) NOT NULL DEFAULT '',
    status VARCHAR(300) NOT NULL DEFAULT 'REGULAR',
    PRIMARY KEY (id)
);

CREATE TABLE customer_order (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    item_name VARCHAR(300) NOT NULL DEFAULT '',
    price DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    currency  VARCHAR(300) NOT NULL DEFAULT 'USD',
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
--cls ex less62
CREATE TABLE student (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(300) NOT NULL DEFAULT '',
    last_name VARCHAR(300) NOT NULL DEFAULT '',
    email VARCHAR(300) NOT NULL DEFAULT '',
    payment_method VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);
