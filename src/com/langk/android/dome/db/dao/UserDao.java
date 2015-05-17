package com.langk.android.dome.db.dao;

import com.langk.android.dome.entity.User;
/**
 * 用户信息操作接口
 * @author K
 *
 */
public interface UserDao {
	
	public User findUserByID(String id);
	
	public void saveUser(User user);
	
	public User loginUser(String email,String pass);
	
}
