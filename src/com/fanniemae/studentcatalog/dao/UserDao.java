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

	/**
	 * Get user by username and password.
	 * @param username
	 * @param password
	 * @return
	 */
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

	/**
	 * Get list of users.
	 * @return
	 */
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

	/**
	 * Get list of user by role.
	 * @param role
	 * @return
	 */
	public List<User> listByRole(String role) {

		List<User> userList = new ArrayList<>();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.role = :role", User.class);
			query.setParameter("role", role);
			userList = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null)
				em.close();
		}
		return userList;
	}

	/**
	 * Add an user to the catalog.
	 * @param user
	 */
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

	/**
	 * Remove users from the catalog.
	 * @param username
	 */
	public void remove(String username) {

		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			// Retrieve user to be deleted.
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
			query.setParameter("username", username);
			User user = query.getSingleResult();
			em.remove(user);
			em.getTransaction().commit();

		} catch (NoResultException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null)
				em.close();
		}
	}

	/**
	 * Update user information.
	 * @param user
	 */
	public void update(User user) {

		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			User existUser = em.find(User.class, user.getId());
			em.getTransaction().begin();
			existUser.setUsername(user.getUsername());
			existUser.setPassword(user.getPassword());
			existUser.setFirstName(user.getFirstName());
			existUser.setLastName(user.getLastName());
			existUser.setSsn(user.getSsn());
			existUser.setRole(user.getRole());
			em.getTransaction().commit();

		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null)
				em.close();
		}
	}

}
