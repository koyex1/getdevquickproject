package net.olu.backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.olu.backend.dao.GenreDAO;
import net.olu.backend.dto.Genre;

public class GenreTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static GenreDAO genreDAO;
	
	private Genre genre;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.olu.backend");
		context.refresh();
		genreDAO = (GenreDAO)context.getBean("genreDAO");
	}
	
//	@Test
//	public void testAddGenre() {
//		genre = new Genre();
//		
//		genre.setName("Sci-Fi");
//		
//		assertEquals("failed to add single Genre to table",true, genreDAO.add(genre));
//	}
//	
//	@Test
//	public void testGetGenre() {
//		genre = genreDAO.getById(3);		
//		assertEquals("failed to get Genre from table","Action", genre.getName());
//	}
//	
//	@Test
//	public void testUpdateGenre() {
//		genre = genreDAO.getById(33);	
//		genre.setName("War");
//		assertEquals("failed to update single Genre to table",true, genreDAO.update(genre));
//	}
//	
//	@Test
//	public void testDeleteGenre() {
//		genre = genreDAO.getById(34);	
//		assertEquals("failed to delete single Genre from table",true, genreDAO.delete(genre));
//	}
//	
	@Test
	public void testListCategory() {
		assertEquals("failed to fetch list of Genre from table",6, genreDAO.list().size());
	}
}
