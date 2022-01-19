package ma.dao;

import java.util.List; 


import ma.entities.SmartPhone;


public interface SmartphoneLocal {
	
	void create(SmartPhone s);

	void delteById(SmartPhone s);

	SmartPhone update(SmartPhone s);

	SmartPhone findById(SmartPhone s);

	List<SmartPhone> findAll();
}
