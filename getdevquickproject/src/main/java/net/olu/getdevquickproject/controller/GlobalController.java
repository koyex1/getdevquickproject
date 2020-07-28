package net.olu.getdevquickproject.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.olu.backend.dao.AccountDAO;
import net.olu.backend.dto.User;
import net.olu.getdevquickproject.model.UserModel;

/*
 * so the idea behind global controller is that since
 * security hijacked/intercepted our page and took 
 * care of the website accessing by abstracting all of the
 * login process(DAO, DAOimpl) so prepare
 * a controller that uses this DAO interfaces to
 * use to our preference
 */
@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;

	// Implementations are always autowired
	@Autowired
	private AccountDAO accountDAO;
	/*
	 * there are two ways of using modelAttribute. this particular usage is to
	 * return a value with whatever datatype it come with to the argument in the
	 * modelattribute. this variable is what is used on the jsp page. this variable
	 * takes similar form to the variable mv.addobject("variable", var). and it can
	 * be assessed by any requestmapping in the controller.
	 */

	private UserModel userModel = null;

//	userModel.setId(1);
//	userModel.setEmail("olumide.koyenikan@gmail.com");
//	userModel.setFullName("Olumide Koyenikan");
//	
//	@ModelAttribute("userModel")
//	public UserModel getUserDetails() {
//		return userModel;
//	}

	@ModelAttribute("userModel")
	public UserModel getUserDetail() {

		// userModel here is the attribute
		// HAVE BEEN LOGGED IN SINCE. STOPS HERE!!!
		try {
			if (session.getAttribute("userModel") == null) {

				// add the user model
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

				// WHERE OUR ERROR FOR USERS NOT LOGGED IN HAPPENS
				User user = accountDAO.getUserByEmail(authentication.getName());
				// NOT LOGGED IN. STOPS HERE!!!
				// FIRST LOG IN. EXECUTES THE IF STATEMENT.
				if (user != null) {
					// userModel here is a class
					userModel = new UserModel();
					// userModel here is a class
					userModel.setId(user.getId());
					userModel.setEmail(user.getEmail());
					userModel.setFullName(user.getFirstName() + " " + user.getLastName());

				}
				// ("attribute",class)
				session.setAttribute("userModel", userModel);

				return userModel;
			}
		}

		catch (NoResultException e) {
			

			return userModel;
		}

		// userModel here is the attribute
		return (UserModel) session.getAttribute("userModel");
	}
	/*
	 * I RECOMMEND everything that has to do with USER'S CHILD be controlled here.
	 */

}
