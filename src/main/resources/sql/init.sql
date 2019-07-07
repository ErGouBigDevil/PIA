CREATE DATABASE IF NOT EXISTS pia;

USE pia;

CREATE TABLE IF NOT EXISTS user
(
    id            INT(32) PRIMARY KEY AUTO_INCREMENT,
    username      VARCHAR(50) UNIQUE,
    password      VARCHAR(50),
    email_address VARCHAR(50)
);

INSERT INTO `user` (id, `username`, `password`, `email_address`)
VALUES (16200, 'ErGouBigDevil', 'admin', 'kengdad@live.com');
INSERT INTO `user` (`username`, `password`, `email_address`)
VALUES ('admin', 'admin', 'admin@test.com');
INSERT INTO `user` (`username`, `password`, `email_address`)
VALUES ('Colin', '1638062331099', 'nunc.interdum.feugiat@turpisnonenim.ca');
INSERT INTO `user` (`username`, `password`, `email_address`)
VALUES ('Gil', '1677081369099', 'mi@Namconsequatdolor.com');








