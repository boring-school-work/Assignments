DROP DATABASE IF EXISTS StoreDB;

CREATE DATABASE StoreDB;

USE StoreDB;

/* TABLE DEFINITIONS */

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
  PRIMARY KEY(trans_id)
);

CREATE TABLE itemsBought (
  trans_id int,
  item_id int,
  item_quantity int DEFAULT 1,
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
  password varchar(64) NOT NULL,
  last_access_time timestamp DEFAULT current_timestamp,
  number_of_logins int DEFAULT 1 NOT NULL,
  PRIMARY KEY(staff_id),
  FOREIGN KEY(staff_id) REFERENCES staff(staff_id)
);


/* POPULATING TABLES WITH ENTRIES */
INSERT INTO warehouseInventory (
  item_id, item_name, item_quantity
) VALUES 
( 1, "Yoghurt", 30 ),
( 2, "Chocolate", 60 ),
( 3, "Malt", 15 ),
( 4, "Cream Crackers", 100 ),
( 5, "Toffees", 300 ),
( 6, "Niche", 20 ),
( 7, "Popcorn", 50 ),
( 8, "Pillow", 12 ),
( 9, "Shirts", 70 ),
( 10, "Slippers", 38 );

INSERT INTO storeInventory (
  item_id, item_name, item_quantity, item_unit_price
) VALUES 
( 1, "Yoghurt", 10, 2.0 ),
( 2, "Chocolate", 23, 10.0 ),
( 3, "Malt", 5, 6.0 ),
( 4, "Cream Crackers", 30, 3.5 ),
( 5, "Toffees", 75, 0.5 ),
( 6, "Niche", 5, 5.0 ),
( 7, "Popcorn", 25, 9.0 ),
( 8, "Pillow", 5, 90.0 ),
( 9, "Shirts", 20, 65.0 ),
( 10, "Slippers", 30, 25 );

INSERT INTO department (
  dept_no, dept_name, dept_location
) VALUES 
( 501, 'warehouse', 'spintex' ),
( 502, 'administration', 'new york' ),
( 503, 'retail', 'kwabenya' ),
( 504, 'logistics', 'kwabenya' ),
( 505, 'cleaning', 'kwabenya' ),
( 506, 'technology', 'spintex' ),
( 507, 'security', 'kwabenya' ),
( 508, 'accounting', 'kwabenya' ),
( 509, 'customer care', 'spintex' ),
( 510, 'marketing', 'accra' );


INSERT INTO staff (
  staff_id, fname, lname, dept_no, salary, gender
) VALUES 
( 200, 'Priscile', 'Nkenmeza', 502, 800000, 'female' ),
( 202, 'Eddy', 'Kummy', 503, 10000, 'male' ),
( 203, 'Nick', 'Fury', 503, 10000, 'male' ),
( 204, 'Abby', 'Nyarko', 509, 8000, 'female' ),
( 205, 'Mabel', 'Owusu', 503, 9000, 'female' ),
( 206, 'Samuel', 'Sowah', 506, 100000, 'male' ),
( 207, 'Jackie', 'Mpaye', 506, 100000, 'female' ),
( 208, 'Cajetan', 'Songwae', 508, 80000, 'male' ),
( 209, 'Faith', 'Rovina', 504, 75000, 'female' ),
( 201, 'David', 'Saah', 510, 200000, 'male' );

/* Insert hashed passwords into auth along with staff_id */
INSERT INTO auth (
  staff_id, password
) VALUES 
( 200, 'BA6FEF13AE52B5FA56CA54911EB7CF79EBD26B0B18F3F364B6FFDF98CE0770B6' ),
( 201, '7C98CE87A050692C5292BEC4546A3BF784EAD497B88E938A5A00B9D5B06970C8' ),
( 202, '4AAD645EDA861056B957867E3B8A1DE94F901F35A4587E4791E5D1AB253DD55C' ),
( 203, '4E076E6DE2B7699F82B3BCBAB0011234C7DD8875E95D3D6173EB7820CB2C6A89' ),
( 204, 'BC723DF9F09F2FADF6CE91210000A510CE1D87CA1B4FDC86FD647C053CB456D3' ),
( 205, 'F71B5DB968E5C51A1AF8974CEB588274B07605213A3DCCACE473E75F2B08F58D' ),
( 206, '2E4CB7FD8E547F028085144FC3276AA735B2F079A23B938A6F3BCE7E0EFA0EB4' ),
( 207, 'FC34B6EBFA7E7A5268ABA79963F8FDFFC7F712B2E49CE00AF030CC693CFC7E46' ),
( 208, '6E1A3E4945896F7C9CAAF0833C7F668B5B72B31B9E84ABEE7D28CEC7E23183E6' ),
( 209, '15416D0996643E857703455A565EE39DED0A9C648AD6E90310DE13CC9E2ACB44' );

INSERT INTO transactions (
  trans_id, total_cost, customer_name
) VALUES 
( 1, 100, "Samuel" ),
( 2, 150, "Dave" ),
( 3, 100, "Ama" );

INSERT INTO itemsBought (
  trans_id, item_id, item_quantity
) VALUES 
( 1, 8, 1),
( 1, 2, 1),
( 2, 7, 5),
( 2, 10, 3),
( 2, 2, 3),
( 3, 8, 1),
( 3, 5, 10);

/* IMPLEMENTING FUNCTIONALITIES */

/* #1 STAFF MANAGEMENT */

/* Check the number of staff in the company */
SELECT count(staff_id) AS total_staff FROM staff;


/* Add 2 new staff and give them access permissions */
INSERT INTO staff (
  staff_id, fname, lname, dept_no, salary, gender
) VALUES 
( 210, 'Nana', 'Benyin', 502, 650000, 'male' ),
( 211, 'George', 'Bush', 503, 7000, 'male' );

INSERT INTO auth (
  staff_id, password
) VALUES
( 210, '27899FDD6A21CC9C75632FE09DB3B334AF739208876CF847E579302B753184EF' ),
( 211, 'D72318BAEC209D4DD10F9976A0973F587DE43AC4C01D4E8EB3CDBFD191570C16' );

/* Report new staff numbers */
SELECT count(staff_id) AS new_total_staff FROM staff;

/* #2 TRANSACTION RECORDING */

/* Record 3 transactions */


/* #3 STOCK ALERTS AND REORDERING */

/* Check warehouse inventory for low stocked items 
 * Assume threshold for item quantity is 5.
 * Reorder low stocked items from partners.
 * */

/* Check if the store has enough stock for the day 
 * Assume it is recommended to have at least 5 items for each product.
 * Contact logistics to bring in new products from the warehouse.
 * */


/* #4 REPORTING AND ANALYTICS */

/* Generate report on sales 
 * How many sales did we make?
 * What was the gross income?
 * */

/* Check staff performance in retail department 
 * How many people work in retail department?
 * List in descending order the number of transactions made by staff
 * */

/* Find top 3 purchased products */
