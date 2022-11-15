package net.javaguides.tutorial.service;

import java.util.Arrays;
import java.util.List;

import net.javaguides.tutorial.model.User;

//Service provider class returning list of users to servlet
public class UserService {
	public List<User> getUsers() {
		User user1 = new User(100L, "Ramesh", "Fadatare", "ramesh@gmail.com");
		User user2 = new User(101L, "Tom", "Cruise", "tom@gmail.com");
		User user3 = new User(103L, "John", "Cena", "john@gmail.com");
		
		return Arrays.asList(user1, user2, user3);
	}
}