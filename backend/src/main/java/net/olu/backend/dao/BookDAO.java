package net.olu.backend.dao;

import java.util.List;

import net.olu.backend.dto.Book;

public interface BookDAO {
	
			  List<Book> activeList();
			  List<Book> activeListByGenre(int genreId);
			  List<Book> list();
	   			   Book getById(int id);
	   boolean add(Book book);
	boolean update(Book book);
	boolean delete(Book book);

}
