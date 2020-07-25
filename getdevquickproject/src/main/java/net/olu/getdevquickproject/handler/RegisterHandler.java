package net.olu.getdevquickproject.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.olu.backend.dao.AccountDAO;
import net.olu.backend.dto.User;
import net.olu.getdevquickproject.model.RegisterModel;

//the controller where you will set the values and retrieve values 
//either as a single value or a list depending on what you need.
//the xml sheet is also a sub-part of it.
@Component
public class RegisterHandler {
	
	@Autowired
	private AccountDAO accountDAO;

	public RegisterModel start() {
		
		return new RegisterModel();
	}
	
	public void setUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	public String save(RegisterModel model) {
		String transitionValue ="success";
		//Model class of type RegisterModel with a getUser method of 
		//type User.
		User user = model.getUser();
		
		accountDAO.addUser(user);
		
		return transitionValue;
	}
	
}
