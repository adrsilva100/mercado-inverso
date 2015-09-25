package br.com.mercadoinverso.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mercadoinverso.entities.User;

import br.com.mercadoinverso.interfaces.UserDao;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User findUserByEmail(String email) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.email = :email ", User.class);
		query.setParameter("email", email);
		
		try {
			return query.getSingleResult();
		} catch (NonUniqueResultException|NoResultException e) {
			return null;
		}
	}
}