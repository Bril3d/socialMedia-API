package com.briled.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"Briled",LocalDate.now().minusYears(20)));
		users.add(new User(++usersCount,"Eve",LocalDate.now().minusYears(22)));
		users.add(new User(++usersCount,"Olaf",LocalDate.now().minusYears(35)));
	}
	
	public List<User> findAll(){
		return users;
	}

	public User findOne(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);	
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
}
