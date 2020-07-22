package net.olu.backend.dao;

import java.util.List;

import net.olu.backend.dto.Genre;

public interface GenreDAO {

   boolean add(Genre genre);
boolean update(Genre genre);
boolean delete(Genre genre);
          List<Genre> list();
          	   Genre getById(int id);
	 
}
