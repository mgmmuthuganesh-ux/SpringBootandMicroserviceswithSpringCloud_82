package com.training.springhibernatedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public String saveUser(User usr) {
		Session session = sessionFactory.openSession();
		 Transaction tr= session.beginTransaction();
		 session.persist(usr);
		 tr.commit();
		 session.close();
		 return "User Saved";
	}
	
	public User getUserId(int uid) {
		Session session = sessionFactory.openSession();
		 Transaction tr= session.beginTransaction();
		//User temp = session.load(User.class, uid); // retrieve from cache 
		 User u = session.find(User.class, uid); // since load() depricated find() good to sue
		// User temp = session.get(User.class, uid); // hit the DB
		 tr.commit();
		 session.close();
		 return u;
	}
	
	public User updateUser(Integer uid, User user) {
		Session session = sessionFactory.openSession();
		 Transaction tr= session.beginTransaction();
		 
		User existingUser = session.find(User.class, uid);;
		existingUser.setName(user.getName()!=null?user.getName():existingUser.getName());
		existingUser.setAddr(user.getAddr()!=null?user.getAddr():existingUser.getAddr());
		existingUser.setContact(user.getContact()!=null?user.getContact():existingUser.getContact());
		
		tr.commit();
		session.close();
		return existingUser;
		
	}
	
	
	public List<User> getAllUser(){
		Session session = sessionFactory.openSession();
		 //List<User> users= session.createQuery("FROM User").list(); // Depricated
		 List<User> users = session.createSelectionQuery("FROM User",User.class).getResultList();
		 session.close();
		 return users;
	}
	
	public String deleteUser(Integer uid) {
		Session session = sessionFactory.openSession();
		 Transaction tr= session.beginTransaction();
		 User u  = getUserId(uid);
		 //session.delete(u); depricated
		 session.remove(u);
		 tr.commit();
		 session.close();
		 return "User Deleted ";
	}
	
	
}
