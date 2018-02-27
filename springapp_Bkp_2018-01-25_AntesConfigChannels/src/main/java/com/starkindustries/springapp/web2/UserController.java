package com.starkindustries.springapp.web2;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.starkindustries.springapp.domain2.User;
import com.starkindustries.springapp.service2.UserInterface;

/**
 * Clase Controladora para el flujo User y sus funciones CRUD
 * @author chema
 * @email pugabdk@hotmail.com 
 */
@Controller
public class UserController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserInterface userInterface;
	
	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	/**
	 * Handle /user/id
	 * 
	 * @param model
	 * @return Nombre de la vista a mostrar RequestMapping({"/users"})
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/users"})
	public String showUser(Map<String, Object> model){
		logger.info(" ===> *** ACTION View usuarios : /users");
		
		List<User> users = userInterface.selectAll();
		model.put("users", users);
		
		return "user/users";
	}
	
	/**
	 * Handle /users 
	 * Detalle del user
	 * 
	 * @param model
	 * @return Nombre de la vista a mostrar RequestMapping({"/user/{id}"})
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/user/{id}"})
	public String userDetail(@PathVariable(value = "id")Integer id, Map<String, Object> model){
		logger.info(" ===> *** ACTION Detalle usuario : /user/id");		
		
		User user = userInterface.selectById(id);
		model.put("user", user);
		
		return "user/userDetail";		
	}
	
	/**
	 * Handle /users/new  con GET
	 * Pantalla de captura para un nuevo usuario
	 * 
	 * @return Nombre de la vista a mostrar 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/users/new"})
	public String newUser(Map<String, Object> model){
		logger.info(" ===> *** ACTION Nuevo usuario con GET : /users/new");		
		
		model.put("user", new User()); 
		
		return "user/newUser";		
	}
	
	/**
	 * Handle /users/new  con POST
	 * Action para crear un usuario
	 * 
	 * @return Nombre de la vista de confirmación de usuario creado 
	 * */
	@RequestMapping(method = RequestMethod.POST, value = {"/users/new"})
	public ModelAndView createUser(User user){
		logger.info(" ===> *** ACTION para crear un usuario con POST : /users/new");		
		ModelAndView modelAndView = new ModelAndView();
		
		if(userInterface.insertUser(user) > 0){
			modelAndView.setViewName("user/created");
			modelAndView.addObject("user", user);
		} else {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "Ocurrió un error durante la creación del usuario. Por favor intente nuevamente...");
		}
		
		return modelAndView;
	}
	
	
				
}
