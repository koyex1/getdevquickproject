package net.olu.backend.dao;

import java.util.List;

import net.olu.backend.dto.Book;
import net.olu.backend.dto.Genre;

public interface GenreDAO {

	List<Genre> list();
		 Genre getById(int id);
	 
}
