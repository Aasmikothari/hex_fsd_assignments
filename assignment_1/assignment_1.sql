-- Create database
CREATE DATABASE fsd_books;

-- use database
USE fsd_books;

-- Create Book table
CREATE TABLE books (
    bid INT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR(255),
    price DOUBLE DEFAULT 0,
    author VARCHAR(255),
    publication_house VARCHAR(255),
    category VARCHAR(255),
    book VARCHAR(255),
    b_count INT DEFAULT 0,
    status VARCHAR(255)
);

-- inserting data
INSERT INTO books (book_title, price, author, publication_house, category, book, b_count, status) VALUES
('The Warrior Path', 450.00, 'John Maxwell', 'Mcgraw Hill', 'WAR', 'B101', 10, 'IN STOCK'),
('Funny Bones', 300.00, 'Sarah Lane', 'DreamFolks', 'COMEDY', 'B102', 5, 'IN STOCK'),
('Fictional Reality', 600.00, 'Amit Verma', 'Warner Bros', 'FICTION', 'B103', 8, 'OUT OF STOCK'),
('Cricket Stars', 550.00, 'Ravi Kumar', 'Mcgraw Hill', 'SPORTS', 'B104', 12, 'IN STOCK'),
('Laugh Out Loud', 320.00, 'Neha Singh', 'DreamFolks', 'COMEDY', 'B105', 7, 'OUT OF STOCK'),
('Battle of Minds', 480.00, 'Karan Mehta', 'Warner Bros', 'WAR', 'B106', 3, 'IN STOCK'),
('The Final Over', 410.00, 'Pooja Desai', 'DreamFolks', 'SPORTS', 'B107', 6, 'IN STOCK');

/*1: Fetch all books that are "IN STOCK" and price is less than a given value*/
delimiter $$
create procedure proc_fetch_books(IN max_price DOUBLE)
BEGIN
    select * from books where status = 'IN STOCK'
    and price < max_price;
END;

-- call
call proc_fetch_books(500);

-- drop
drop procedure proc_fetch_books;

/*2: Delete books from a given publication house.
do not activate safe mode. 
*/
delimiter $$
create procedure proc_delete_books(in pub_name varchar(255))
begin
  declare total int default 0;
  declare i int default 0;
  declare book_id int;

  select count(*) into total 
  from books 
  where publication_house = pub_name;

  while i < total do
    select bid into book_id 
    from books 
    where publication_house = pub_name 
    limit 1;
    
    -- delete
    delete from books where bid = book_id;
    set i = i + 1;
  end while;
end;

-- call
call proc_delete_books('Mcgraw Hill');

-- check
select * from books;

-- drop
drop procedure proc_delete_books;

/*3: Update the price of books by given percent based on given category. 
do not activate safe mode. 
*/
delimiter $$
create procedure proc_update_price(in cat varchar(255), in incr_percent double)
begin
  declare total int default 0;
  declare i int default 0;
  declare book_id int;

  select count(*) into total 
  from books 
  where category = cat;

  while i < total do
    select bid into book_id 
    from books 
    where category = cat 
    limit 1;

	-- update
    update books 
    set price = price + (price * (incr_percent / 100))
    where bid = book_id;

    set i = i + 1;
  end while;
end;

-- call
call proc_update_price('COMEDY', 10);

-- check
select * from books;

-- drop
drop procedure proc_update_price;