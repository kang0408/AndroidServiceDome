package com.langk.android.dome.db.impl;


import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.langk.android.dome.db.dao.UserDao;
import com.langk.android.dome.entity.User;

/**
 * 用户信息操作类
 * 
 * @author K
 *
 */
public class UserDAOImpl implements UserDao {
	
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findUserByID(String id) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (User)query.uniqueResult();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User loginUser(String email, String pass) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.EMAIL=? and u.PASSWORD = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, email);
		query.setString(0, pass);
		return (User)query.uniqueResult();
	}

}
