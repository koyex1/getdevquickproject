package net.olu.getdevquickproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.olu.backend.dao.BookDAO;
import net.olu.backend.dao.GenreDAO;
import net.olu.backend.dto.Book;
import net.olu.backend.dto.Genre;


@Controller
public class PageController {
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private BookDAO bookDAO;

	//contains a combination LIST only
	@RequestMapping(value= {"/","/home","index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome", true);
		mv.addObject("storename","Dominoe Books");
		mv.addObject("title","Dominoe Books");
		//
		
		mv.addObject("genres",genreDAO.list());
		mv.addObject("books",bookDAO.list());
		
		return mv;
	}
	
	//contains a combination LIST and a SINGLE item
	@RequestMapping(value= "/book/{id}")
	public ModelAndView showBook(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickBook", true);
		//fetch a single book
		Book book=null;
		book = bookDAO.getById(id);
		//BEST THING ABOUT CLASSES
		Genre genre;
		genre= genreDAO.getById(book.getGenreId());
		
		mv.addObject("title",book.getName());
		mv.addObject("genres",genreDAO.list());
		mv.addObject("name",book.getName());
		mv.addObject("description",book.getDescription());
		mv.addObject("rating",book.getRating());
		mv.addObject("genre", genre.getName());
		
		return mv;
	}
	
	//contains a combination LIST and a SINGLE empty item
	@GetMapping(value= "/managebooks")
	public ModelAndView showBook(@RequestParam(name= "operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManage", true);
		mv.addObject("title", "Organize/Add to Shelf");
		mv.addObject("genres",genreDAO.list());
		mv.addObject("books",bookDAO.list());
		
		//add new-book
		Book nbook = new Book();
		//latched to form field. nbook empty so form field will be
		//empty however with ever with every letter typed it is
		//latched to nbook.. this is how Edit refills field with characters
		mv.addObject("book",nbook);
		
		//message box
		if(operation !=null) {
			if(operation.equals("submit")) {
				mv.addObject("operation","Succefully submitted Form");
			}
			if(operation.equals("update")) {
				mv.addObject("operation","Succefully Updated Form");
			}
		}
		
		
		return mv;
	}
	
	//contains a combination LIST and a SINGLE empty item
		@GetMapping(value= "/managebooks/{id}/edit")
		public ModelAndView showUpdate(@PathVariable(name= "id") int id) {
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("userClickManage", true);
			mv.addObject("title", "Organize/Add to Shelf");
			mv.addObject("genres",genreDAO.list());
			mv.addObject("books",bookDAO.list());
			
			//add new-book
			Book nbook = new Book();
			nbook = bookDAO.getById(id);
			//latched to form field. nbook empty so form field will be
			//empty however with ever with every letter typed it is
			//latched to nbook.. this is how Edit refills field with characters
			mv.addObject("book",nbook);
			
			
			return mv;
		}
		
	//BASICALLY JUST HANDLES SUBMISSION AND NOTHING ELSE REALLY
	@PostMapping(value= "/managebooks")
	//POST HTTP modelattribute to mbook class object
	public String handleSubmission(@ModelAttribute("book") Book mbook) {
		
		if(mbook.getId()==0) {
		bookDAO.add(mbook);
		return "redirect:/managebooks?operation=submit";
		}
		else {
		bookDAO.update(mbook);
		return "redirect:/managebooks?operation=update";
		}
		
	}
	
	
	//to give all mapping in the controller the variable genres
//	@ModelAttribute("genres")
//		public List<Genre> getGenres(){
//			
//			return genreDAO.list();
//		}
	
	
}
