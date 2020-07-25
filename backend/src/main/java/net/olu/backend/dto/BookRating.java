package net.olu.backend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BookRating {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@ManyToOne
private User user;
private String title;
private int rating;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}


}
