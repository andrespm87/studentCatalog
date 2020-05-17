package com.fanniemae.studentcatalog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fanniemae.studentcatalog.model.User;

/**
 * This class manages the database operations of the User Class.
 * 
 * @author Andres Pena
 *
 */
public class UserDao {

	/** Defines persistence unit name */
	private static final String PERSISTENCE_UNIT_NAME = "StudentCatalogProject";

	private EntityManagerFactory emf;

	/**
	 * Constructs a UserDao and initializes the Entity Manager Factory.
	 */
	public UserDao() {
		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public User get(String username, String password) {
		User user;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			TypedQuery<User> query = em.createQuery(
					"SELECT u FROM User u WHERE u.username = :username and u.password = :password", User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			user = query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null)
				em.close();
		}
		return user;
	}
	
	public List<User> list() {

		List<User> userList = new ArrayList<>();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			userList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null)
				em.close();
		}
		return userList;
	}
	
	public void add(User user) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null)
				em.close();
		}
	}
}
