CREATE DATABASE `sparringdb`;

CREATE TABLE `sparringdb`.articles (
  id INT(8) NOT NULL,
  category VARCHAR(255) NOT NULL,
  description text,
  image VARCHAR(255),
  price INT(8),
  title VARCHAR(255),
  PRIMARY KEY(id) 
 );
