package net.olu.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.olu.backend.dao.BookDAO;
import net.olu.backend.dto.Book;


@Repository("BookDAO")
public class BookDAOImpl implements BookDAO {
private static List<Book> books =new ArrayList<Book>();
	
	static {
		Book book= new Book();
		//adding first genre
		book.setId(1);
		book.setName("Sanctum");
		book.setDescription("A priest exorcises demons");
		//book.setGenreId(1);
		book.setRating(4);
		
		books.add(book);
		
		//second genre
		book = new Book();
		book.setId(2);
		book.setName("Angels and Demons");
		book.setDescription("Robert Lagdon follows the trail to the demons of the Vatican city");
		//book.setGenreId();
		book.setRating(5);
		books.add(book);
	}
	
	@Override
	public List<Book> list() {
		
		return books;
	}

	//grabs the current book ID
	@Override
	public Book getById(int id) {
		for(Book item: books) {
			if(item.getId()== id) return item;
		}
		return null;
	}
	
}
