package net.olu.backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.olu.backend.dao.AccountDAO;
import net.olu.backend.dto.BookRating;
import net.olu.backend.dto.User;

public class AccountTestCase {
private static AnnotationConfigApplicationContext context;
	
	private static AccountDAO accountDAO;
	
	private User user;
	
	private BookRating bookrating;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.olu.backend");
		context.refresh();
		accountDAO = (AccountDAO)context.getBean("accountDAO");
	}
	
	@Test
	public void testAddUser() {
		
		user = new User();
		user.setFirstName("Olumide");
		user.setLastName("Koyenikan");
		user.setEmail("olumide.koyenikan@gmail.com");
		user.setPassword("123");
		
		assertEquals("failed to add user to table",true, accountDAO.addUser(user));
		
		bookrating = new BookRating();
		bookrating.setTitle("War");
		bookrating.setRating(5);
	
		//link user with bookrating and user
//		bookrating.setUserId(user.getId());
		
		assertEquals("failed to add user to table",true, accountDAO.addBookRating(bookrating));
		
	}
	
	
	
}
