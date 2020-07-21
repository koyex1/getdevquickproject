package net.olu.getdevquickproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.olu.backend.dao.BookDAO;
import net.olu.backend.dao.GenreDAO;
import net.olu.backend.dto.Book;


@Controller
public class PageController {
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private BookDAO bookDAO;


	@RequestMapping(value= {"/","/home","index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome", true);
		mv.addObject("storename","Dominoe Books");
		mv.addObject("title","Dominoe Books");
		mv.addObject("genres",genreDAO.list());
		mv.addObject("books",bookDAO.list());
		
		return mv;
	}
	
	@RequestMapping(value= "/book/{id}")
	public ModelAndView showBook(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickBook", true);
		//fetch a single book
		Book book=null;
		book = bookDAO.getById(id);
		mv.addObject("title","Books");
		mv.addObject("genres",genreDAO.list());
		mv.addObject("name",book.getName());
		mv.addObject("description",book.getDescription());
		mv.addObject("rating",book.getRating());
		
		return mv;
	}
	
}
