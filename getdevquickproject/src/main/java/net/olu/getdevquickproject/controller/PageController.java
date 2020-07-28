package net.olu.getdevquickproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.olu.backend.dao.AccountDAO;
import net.olu.backend.dao.BookDAO;
import net.olu.backend.dao.GenreDAO;
import net.olu.backend.dto.Book;
import net.olu.backend.dto.Genre;

/*
 * 
 * 
 * METHODS PERFORMED IN CONTROLLERS ARE DONE IN THE TEST 
 * getA()---you have to get A by something()
 * addA()-----you have to add A
 * whenever their is something inside the brackets is a database access
 * if nothing it is an class access
 * so the best way to seperated these syntaxes to avoid confusion
 * is using getAbyB() and getA
 * 
 */
@Controller
public class PageController {
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private AccountDAO bookratingDAO;
	
	//contains a combination LIST only
	@RequestMapping(value= {"/","/home","index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome", true);
		mv.addObject("storename","Dominoe Books");
		mv.addObject("title","Dominoe Books");
		//
		
		mv.addObject("genres",genreDAO.list());
		mv.addObject("books",bookDAO.activeList());
		
		return mv;
	}
	@RequestMapping(value= {"/genre/{id}"})
	public ModelAndView showByGenre(@PathVariable("id") int id) {
		//loading page operation
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome", true);
		mv.addObject("storename","Dominoe Books");
		//genre list operation
		Genre genre=null;
		genre=genreDAO.getById(id);
		mv.addObject("genres",genreDAO.list());
		mv.addObject("title",genre.getName());
		//list book operation
		mv.addObject("books",bookDAO.activeListByGenre(id ));
		
		return mv;
	}
	
	//contains a combination LIST and a SINGLE item
	@RequestMapping(value= "/book/{id}")
	public ModelAndView showBook(@PathVariable("id") int id, @RequestParam(name="operation", required=false) String operation) {
		//loading page operation
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickBook", true);
		//single book operation
		Book book=null;
		book = bookDAO.getById(id);
		mv.addObject("title",book.getName());
		mv.addObject("rating",book.getRating());
		mv.addObject("description",book.getDescription());
		mv.addObject("name",book.getName());
		//BEST THING ABOUT CLASSES
		//genre list and single genre operation
		Genre genre;
		genre= genreDAO.getById(book.getGenreId());
		mv.addObject("genres",genreDAO.list());
		mv.addObject("genre", genre.getName());
		//GET single bookrating into form operation
//		BookRating nbookrating= new BookRating();
//		nbookrating.setTitle(book.getName());
//		mv.addObject("bookrating",nbookrating);
		
		
		
		return mv;
	}
//	@PostMapping(value= "/book/{id}")
//	public String handleRatingSubmission(@PathVariable("id")int id, @ModelAttribute("bookrating") BookRating mbookrating) {
//		
//		//Add single bookrating operation ADD UPDATE DELETE GET
//		//are all single operations.
//		bookratingDAO.addBookRating(mbookrating);
//		
//		
//		return "redirect:/book/{id}?operation=rated";
//	}
	//contains a combination LIST and a SINGLE empty item
	@GetMapping(value= "/managebooks")
	public ModelAndView showBook(@RequestParam(name= "operation", required=false) String operation) {
		//loading page operation
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManage", true);
		mv.addObject("title", "Organize/Add to Shelf");
		//genre list operation
		mv.addObject("genres",genreDAO.list());
		//book list operation
		mv.addObject("books",bookDAO.activeList());
		
		//add new-book
		//latched to form field. nbook empty so form field will be
		//empty however with ever with every letter typed it is
		//latched to nbook.. this is how Edit refills field with characters
		//GET single book operation
		Book nbook = new Book();
		mv.addObject("book",nbook);
		
		//message Box operation
		if(operation !=null) {
			if(operation.equals("add")) {
				mv.addObject("operation","Succefully Added Book");
			}
			if(operation.equals("update")) {
				mv.addObject("operation","Succefully Organized Book");
			}
			if(operation.equals("delete")) {
				mv.addObject("operation","Succefully Removed Book");
			}
		}
		
		
		return mv;
	}
	
	//contains a combination LIST and a SINGLE empty item
		@GetMapping(value= "/managebooks/{id}/edit")
		public ModelAndView showUpdate(@PathVariable("id") int id) {
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("userClickManage", true);
			mv.addObject("title", "Organize/Add to Shelf");
			mv.addObject("genres",genreDAO.list());
			mv.addObject("books",bookDAO.activeList());
			//add new-book
			//latched to form field. nbook empty so form field will be
			//empty however with ever with every letter typed it is
			//latched to nbook.. this is how Edit refills field with characters.
			
			//GET single book operation
			Book nbook = new Book();
			nbook = bookDAO.getById(id);
			mv.addObject("book",nbook);
			
			return mv;
		}
		
	//BASICALLY JUST HANDLES SUBMISSION AND NOTHING ELSE REALLY
	@PostMapping(value= "/managebooks")
	//POST HTTP modelattribute to mbook class object
	public String handleSubmission(@ModelAttribute("book") Book mbook) {
		
		if(mbook.getId()==0) {
		//add single book operation ADD UPDATE DELETE GET all single opertions
		bookDAO.add(mbook);
		return "redirect:/managebooks?operation=add";
		}
		else {
		//update single book operation ADD UPDATE DELETE GET all single operations
		bookDAO.update(mbook);
		return "redirect:/managebooks?operation=updated";
		}
	}
		@GetMapping(value= "/managebooks/{id}/delete")
		//POST HTTP modelattribute to mbook class object
		public String handleDelete(@PathVariable("id")int id) {
			
			//update single book operation ADD UPDATE DELETE GET all single operations
			Book book=new Book();
			book=bookDAO.getById(id);
			book.setActive(false);
			bookDAO.update(book);
			return "redirect:/managebooks?operation=delete";
		
	}
//		@RequestMapping(value= {"/signup"})
//		public ModelAndView signup() {
//			ModelAndView mv = new ModelAndView("page");
//			mv.addObject("title", "MVC not Webflow");
//	
//			return mv;
//		}
	
	//to give all mapping in the controller the variable genres
		//getGenres and genres have the same value
//	@ModelAttribute("genres")
//		public List<Genre> getGenres(){
//			
//			return genreDAO.list();
//		}
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name= "operation", required=false) String operation) {
		//loading page operation
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		//other operation not provided spring security handling them
		return mv;
	}
	@RequestMapping(value="/logout")
	public String handlelogout(HttpServletRequest request, HttpServletResponse response) {
		//loading page operation
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		
		//first we are going to fetch the authentication
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		//if statement to logout IF logged in
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		//other operation not provided spring security handling them
		return "redirect:/login?operation=logout";
	}
	
}