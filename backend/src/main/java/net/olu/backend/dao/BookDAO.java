package net.olu.backend.dao;

import java.util.List;

import net.olu.backend.dto.Book;

public interface BookDAO {
	
			  List<Book> activeList();
			  List<Book> activeListByGenre(int genreId);
			  List<Book> list();
			  //should have been getBookById
	   			   Book getById(int id);
	   		//should have been addBook
	   boolean add(Book book);
	   //should have been updateBook
	boolean update(Book book);
	//should have been deleteBook
	boolean delete(Book book);

}
