package ma.dao;

import java.util.List; 

import ma.entities.User;


public interface UserLocal {

	void create(User t);

	void delteById(User t);

	User update(User t);

	User findById(User t);

	List<User> findAll();

}
