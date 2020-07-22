package net.olu.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.olu.backend.dao.GenreDAO;
import net.olu.backend.dto.Genre;


@Repository("genreDAO")
@Transactional
public class GenreDAOImpl implements GenreDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//Declaration of a list of Genres
	private static List<Genre> genres =new ArrayList<Genre>();
	
//	static {
//		//declaration of a single genre
//		Genre genre= new Genre();
//		//adding first genre
//		genre.setId(1);
//		genre.setName("Romance");
//		
//		genres.add(genre);
//		
//		//second genre
//		genre= new Genre();
//		genre.setId(2);
//		genre.setName("Comedy");
//		
//		genres.add(genre);
//	}
//	
	@Override
	public List<Genre> list() {
		String selectAllGenre= "FROM Genre";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllGenre);
		
		return query.getResultList();
//		return genres;
	}

	@Override
	public Genre getById(int id) {
		
			return sessionFactory.getCurrentSession().get(Genre.class, Integer.valueOf(id));			
			
		
//		for(Genre item: genres) {
//			if (item.getId()== id) return item;
//		}
//		return null;
	}

	@Override
	public boolean add(Genre genre) {
		try {
			sessionFactory.getCurrentSession().persist(genre);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Genre genre) {
		try {
			sessionFactory.getCurrentSession().update(genre);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Genre genre) {
		try {
			sessionFactory.getCurrentSession().delete(genre);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
