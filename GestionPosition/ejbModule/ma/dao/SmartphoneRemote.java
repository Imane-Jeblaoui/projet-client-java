package ma.dao;

import java.util.List;

import javax.ejb.Remote;

import ma.entities.SmartPhone;

@Remote
public interface SmartphoneRemote {

	void create(SmartPhone s);

	void delteById(SmartPhone s);

	SmartPhone update(SmartPhone s);

	SmartPhone findById(SmartPhone s);

	List<SmartPhone> findAll();
}
