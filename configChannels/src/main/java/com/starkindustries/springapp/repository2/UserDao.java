package com.starkindustries.springapp.repository2;

import java.util.List;

import com.starkindustries.springapp.domain2.User;

public interface UserDao {
	
	public User selectById(Integer id);
	public List<User> selectAll();
	public Integer selectNextvalUser();
	public int insertUser(User user);

}
