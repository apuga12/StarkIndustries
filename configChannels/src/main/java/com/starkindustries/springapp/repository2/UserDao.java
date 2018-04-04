package com.starkindustries.springapp.repository2;

import java.util.List;

import mx.book.ajax.vo3.Categoria;

import com.starkindustries.springapp.domain2.User;

public interface UserDao {
	
	public User selectById(Integer id);
	public List<User> selectAll();
	public Integer selectNextvalUser();
	public int insertUser(User user);
	public boolean isRegistered(String log, String pwd);
	public List<Categoria> selectAllCategories();

}
