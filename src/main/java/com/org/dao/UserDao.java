package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {
	
	static	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Fani");  
	static  EntityManager eManager =entityManagerFactory.createEntityManager();
	static	EntityTransaction entityTransaction=eManager.getTransaction();  
	
public static void saveAndUpdateUser(User user) {
		entityTransaction.begin();
		eManager.merge(user);
		entityTransaction.commit();
	}
	
public static User fetchUserByEmailAndPassword(String email, String password) {
	Query query = eManager.createQuery("SELECT s FROM User s WHERE s.email=?1 AND s.password=?2");
	query.setParameter(1, email);
	query.setParameter(2, password);
	List<User> list = query.getResultList();
	return list.get(0);
	}

public static User fetchUserById(int id) {
	User user = eManager.find(User.class, id);
	return user;
	}

public static void DeleteUser(int id) {
	User user = eManager.find(User.class, id);
	entityTransaction.begin();
	eManager.remove(user);
	entityTransaction.commit();
	}

public static void updatePassword(int id,String password) {
	User user = eManager.find(User.class, id);
	user.setPassword(password);
	entityTransaction.begin();
	eManager.merge(user); 
	entityTransaction.commit();
	}

}
