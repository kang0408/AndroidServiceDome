package com.langk.android.dome.db.impl;


import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.langk.android.dome.db.dao.UserDao;
import com.langk.android.dome.entity.User;

/**
 * 用户信息操作类
 * 
 * @author K
 *
 */
@Service
public class UserDAOImpl implements UserDao {
	
	@Resource
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findUserByID(String id) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, id);
		return (User)query.uniqueResult();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.openSession().save(user);
	}

	@Override
	public User loginUser(String email, String pass) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.email=? and u.password = ?";
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setString(0, email);
		query.setString(1, pass);
		return (User)query.uniqueResult();
	}

}
