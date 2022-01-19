package ma.dao;

import java.util.List;

import javax.ejb.Remote;

import ma.entities.User;

@Remote
public interface UserRemote {

	void create(User t);

	void delteById(User t);

	User update(User t);

	User findById(User t);

	List<User> findAll();
}
