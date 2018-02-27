package com.starkindustries.springapp.service2;

import java.io.Serializable;
import java.util.List;

import com.starkindustries.springapp.domain2.User;

public interface UserInterface  extends Serializable {
	public List<User> selectAll();
	public User selectById(Integer id);
	public int insertUser(User user);
}
