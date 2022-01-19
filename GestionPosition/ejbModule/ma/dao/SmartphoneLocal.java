package ma.dao;

import java.util.List;

import javax.ejb.Local;

import ma.entities.SmartPhone;

@Local
public interface SmartphoneLocal {
	
	void create(SmartPhone s);

	void delteById(SmartPhone s);

	SmartPhone update(SmartPhone s);

	SmartPhone findById(SmartPhone s);

	List<SmartPhone> findAll();
}
