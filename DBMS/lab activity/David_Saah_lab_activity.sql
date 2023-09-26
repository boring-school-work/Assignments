DROP DATABASE IF EXISTS StoreDB;

CREATE DATABASE StoreDB;

USE StoreDB;

CREATE TABLE warehouseInventory(
  item_id int,
  item_quantity int DEFAULT 0,
  item_name varchar(30) UNIQUE NOT NULL,
  CHECK ( item_quantity > 0 ),
  PRIMARY KEY(item_id)
);

CREATE TABLE storeInventory (
  item_id int,
  item_quantity int NOT NULL,
  item_unit_price double NOT NULL,
  item_name varchar(30) UNIQUE NOT NULL,
  CHECK ( item_quantity > 0 ),
  PRIMARY KEY(item_id),
  FOREIGN KEY(item_id) REFERENCES warehouseInventory(item_id)
);

CREATE TABLE transactions (
  trans_id int,
  total_cost double NOT NULL,
  customer_name varchar(30),
  trans_time timestamp DEFAULT current_timestamp,
  PRIMARY KEY(trans_id),
);

CREATE TABLE itemsBought (
  trans_id int,
  item_id int,
  FOREIGN KEY(trans_id) REFERENCES transactions(trans_id),
  FOREIGN KEY(item_id) REFERENCES storeInventory(item_id)
);

CREATE TABLE department (
  dept_no int,
  dept_name varchar(15) NOT NULL,
  dept_location varchar(40) NOT NULL,
  PRIMARY KEY(dept_no)
);

CREATE TABLE staff (
  staff_id int,
  fname varchar(15) NOT NULL,
  lname varchar(15),
  dept_no int NOT NULL,
  salary double NOT NULL,
  gender enum('male', 'female'),
  PRIMARY KEY(staff_id),
  FOREIGN KEY(dept_no) REFERENCES department(dept_no)
);

CREATE TABLE auth (
  staff_id int,
  password varchar(100) NOT NULL,
  last_access_time timestamp DEFAULT current_timestamp,
  number_of_logins int DEFAULT 0 NOT NULL,
  PRIMARY KEY(staff_id),
  FOREIGN KEY(staff_id) REFERENCES staff(staff_id)
);
