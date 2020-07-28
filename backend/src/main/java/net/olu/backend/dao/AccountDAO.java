package net.olu.backend.dao;

import net.olu.backend.dto.BookRating;
import net.olu.backend.dto.User;

//acually i can seperate out the DAO to be userDAO and movieRatingDAO
//but since joining them isnt much of a hassle It wont be a bad idea
public interface AccountDAO {
//add a user
	boolean addUser(User user);
	boolean addBookRating(BookRating bookrating);
	User getUserByEmail(String email);
}
