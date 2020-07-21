package net.olu.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.olu.backend.dao.GenreDAO;
import net.olu.backend.dto.Genre;


@Repository("GenreDAO")
public class GenreDAOImpl implements GenreDAO {
	//Declaration of a list of Genres
	private static List<Genre> genres =new ArrayList<Genre>();
	
	static {
		//declaration of a single genre
		Genre genre= new Genre();
		//adding first genre
		genre.setId(1);
		genre.setName("Romance");
		
		genres.add(genre);
		
		//second genre
		genre= new Genre();
		genre.setId(2);
		genre.setName("Comedy");
		
		genres.add(genre);
	}
	
	@Override
	public List<Genre> list() {
		
		return genres;
	}

	@Override
	public Genre getById(int id) {
		for(Genre item: genres) {
			if (item.getId()== id) return item;
		}
		return null;
	}

}
