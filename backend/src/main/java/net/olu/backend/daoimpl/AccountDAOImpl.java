package net.olu.backend.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.olu.backend.dao.AccountDAO;
import net.olu.backend.dto.Book;
import net.olu.backend.dto.BookRating;
import net.olu.backend.dto.User;

@Repository("accountDAO")
@Transactional
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean addBookRating(BookRating bookrating) {
			try {
				sessionFactory.getCurrentSession().persist(bookrating);			
				return true;
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return false;
			}
			
		}


	@Override
	public User getUserByEmail(String email) {
		
		String selectUserByEmail= "FROM User WHERE email= :email";
		return sessionFactory.getCurrentSession()
				.createQuery(selectUserByEmail, User.class)
					.setParameter("email",email)
						.getSingleResult();
	}
	}

