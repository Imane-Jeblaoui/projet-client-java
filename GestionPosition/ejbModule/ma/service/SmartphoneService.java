package ma.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.dao.SmartphoneLocal;
import ma.dao.SmartphoneRemote;
import ma.entities.SmartPhone;

@Stateless(name = "Smartphone")
public class SmartphoneService implements SmartphoneLocal, SmartphoneRemote{

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(SmartPhone s) {
		em.persist(s);
	}

	@Override
	public void delteById(SmartPhone s) {
		em.remove(em.contains(s) ? s : em.merge(s));
		
	}

	@Override
	public SmartPhone update(SmartPhone s) {
		em.persist(em.contains(s) ? s : em.merge(s));
		return s;
	}

	@Override
	public SmartPhone findById(SmartPhone s) {
		
		return em.find(SmartPhone.class, s.getId());
	}

	@Override
	public List<SmartPhone> findAll() {
		Query q = em.createQuery("from SmartPhone");
		return q.getResultList();
	}
	
}
