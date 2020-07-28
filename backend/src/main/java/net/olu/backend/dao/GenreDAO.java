package net.olu.backend.dao;

import java.util.List;

import net.olu.backend.dto.Genre;

public interface GenreDAO {

	//should have been addGenre
   boolean add(Genre genre);
	//should have been updateGenre
boolean update(Genre genre);
//should have been deleteGenre
boolean delete(Genre genre);
          List<Genre> list();
          //should have been getGenreById
          	   Genre getById(int id);
	 
}
