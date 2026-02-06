package com.training.springhibernatedemo.dao;

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
	
	public UserDto getUserId(Integer uid) {
		UserDto u = new UserDto();
		Session session = sessionFactory.openSession();
		 Transaction tr= session.beginTransaction();
		//User temp = session.load(User.class, uid); // cache
		 
		 User temp = session.get(User.class, uid); // DB
		 u.setUid(temp.getUid());
		 u.setName(temp.getName());
		 u.setAddr(temp.getAddr());
		 u.setContact(temp.getContact());
		 tr.commit();
		 session.close();
		 return u;
	}
	
	
}
