package ma.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.dao.UserLocal;
import ma.dao.UserRemote;
import ma.entities.User;

@Stateless(name = "User")
public class UserService implements UserLocal, UserRemote{
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public void create(User u) {
		em.persist(u);
	}

	@Override
	public void delteById(User u) {
		
		em.remove(em.contains(u) ? u : em.merge(u));
		
	}

	@Override
	public User update(User u) {
		em.persist(em.contains(u) ? u: em.merge(u));
		return u;
	}

	@Override
	public User findById(User u) {
		return (User) em.find(User.class, u.getId());
	}

	@Override
	public List<User> findAll() {
		Query q = em.createQuery("from User");
		return q.getResultList();
	}
}
