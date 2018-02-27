package mx.izzi.configChannels.web2;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

import com.starkindustries.springapp.domain2.User;
import com.starkindustries.springapp.service2.UserInterface;

/**
 * Clase Controladora para el flujo User y sus funciones CRUD
 * @author chema
 * @email pugabdk@hotmail.com 
 */
@Controller
public class ConfigChannelsController {
	
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
	@RequestMapping(method = RequestMethod.GET, value = {"/inicio"})
	public String showUser(Map<String, Object> model){
		logger.info(" ===> *** ACTION View usuarios : /inicio");
		
		List<User> users = userInterface.selectAll();
		model.put("users", users);
		
		return "configChannels/inicio";
	}
	
					
}
