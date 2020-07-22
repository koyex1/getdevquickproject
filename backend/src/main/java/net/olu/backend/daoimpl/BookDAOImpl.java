package net.olu.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.olu.backend.dao.BookDAO;
import net.olu.backend.dto.Book;


@Repository("bookDAO")
@Transactional
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	private static List<Book> books =new ArrayList<Book>();
	
//	static {
//		Book book= new Book();
//		//adding first genre
//		book.setId(1);
//		book.setName("Sanctum");
//		book.setDescription("A priest exorcises demons");
//		//book.setGenreId(1);
//		book.setRating(4);
//		
//		books.add(book);
//		
//		//second genre
//		book = new Book();
//		book.setId(2);
//		book.setName("Angels and Demons");
//		book.setDescription("Robert Lagdon follows the trail to the demons of the Vatican city");
//		//book.setGenreId();
//		book.setRating(5);
//		books.add(book);
//	}




	@Override
	public List<Book> list() {
		String selectAllBook= "FROM Book";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllBook);
		
		return query.getResultList();
//		return books;
	}

	@Override
	public Book getById(int id) {
		
			return sessionFactory.getCurrentSession().get(Book.class, Integer.valueOf(id));			
			
		
//		for(Genre item: books) {
//			if (item.getId()== id) return item;
//		}
//		return null;
	}

	@Override
	public boolean add(Book book) {
		try {
			sessionFactory.getCurrentSession().persist(book);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Book book) {
		try {
			sessionFactory.getCurrentSession().update(book);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Book book) {
		try {
			sessionFactory.getCurrentSession().delete(book);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
}
