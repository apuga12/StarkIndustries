package com.starkindustries.springapp.service2;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starkindustries.springapp.domain2.User;
import com.starkindustries.springapp.repository2.UserDao;

@Component
public class UserImpl implements UserInterface {
	
	private static final long serialVersionUID = 1L;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> selectAll() {
		
		/*
		List<User> listUser = new ArrayList<User>();
		User user1 = new User(1,"sjobs", "Apple CEO", "stewie");
		User user2 = new User(2,"lellison", "Oracle CEO", "larry" );
		User user3 = new User(3,"bgates", "Microsoft CEO", "bill");
		User user4 = new User(4,"mzuckerberg", "Facebook CEO", "selfie");
		User user5 = new User(8,"tonyStark", "Stark Industries CEO", "chema");
		
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);
		listUser.add(user4);
		listUser.add(user5);
				
		return listUser;
		*/
		return userDao.selectAll();
	}
	
	public User selectById(Integer id){		
		return userDao.selectById(id);
	}
	
	public int insertUser(User user){
		user.setId(userDao.selectNextvalUser());
		logger.info(" ===> *** id: selectNextvalUser : "+user.getId());
		logger.info(" ===> *** login: "+user.getLogin());
		logger.info(" ===> *** description: "+user.getDescription());
		logger.info(" ===> *** password: "+user.getPassword());
		userDao.insertUser(user);
		return user.getId();
	}

}
