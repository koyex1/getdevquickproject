package net.olu.backend;


	import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.olu.backend.dao.BookDAO;
import net.olu.backend.dto.Book;



	public class BookTestCase {

		private static AnnotationConfigApplicationContext context;
		
		private static BookDAO bookDAO;
		
		private Book book;
		
		@BeforeClass
		public static void init() {
			context = new AnnotationConfigApplicationContext();
			context.scan("net.olu.backend");
			context.refresh();
			bookDAO = (BookDAO)context.getBean("bookDAO");
		}
		
//		@Test
//		public void testAddBook() {
//			book = new Book();
//			
//			book.setName("dddd");
//			book.setDescription("ddd");
//			book.setGenreId(6);
//			book.setRating(2);
//			
//			
//			assertEquals("failed to add single Book to table",true, bookDAO.add(book));
//		}
	//	
//		@Test
//		public void testGetBook() {
//			book = bookDAO.getById(14);		
//			assertEquals("failed to get Book from table","ichar", book.getName());
//		}
	//	
//		@Test
//		public void testUpdateBook() {
//			book =bookDAO.getById(14);	
//			book.setName("Murder on Orient");
//			assertEquals("failed to update single Book to table",true, bookDAO.update(book));
//		}
	//	
//		@Test
//		public void testDeleteBook() {
//			book = bookDAO.getById(15);	
//			assertEquals("failed to delete single Book from table",true, bookDAO.delete(book));
//		}
	//	
		@Test
		public void testListBook() {
			assertEquals("failed to fetch list of Book from table",4, bookDAO.list().size());
		}
	}

