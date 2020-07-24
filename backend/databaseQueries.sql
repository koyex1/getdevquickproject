CREATE TABLE genre(
id IDENTITY,
name VARCHAR(50),

CONSTRAINT pk_genre_id PRIMARY KEY (id)
);

CREATE TABLE book(
	id IDENTITY,
	name VARCHAR(20),
	description VARCHAR(255),
	genreId INT,
	rating INT DEFAULT 0,
	active BOOLEAN, 
	
	CONSTRAINT pk_book_id PRIMARY KEY (id),
	CONSTRAINT fk_book_genreId FOREIGN KEY (genreId) REFERENCES genre(id),
	
);
INSERT INTO book (name,description,genreid,)VALUES('DaVinci Code','this book is about a lot of things',1)