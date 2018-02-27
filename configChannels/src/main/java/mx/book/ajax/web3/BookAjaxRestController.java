package mx.book.ajax.web3;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starkindustries.springapp.service2.UserInterface;
//import org.springframework.web.servlet.ModelAndView;

/**
 * Clase Controladora soporte para el libro Ajax en J2EE, Ed Rama
 * @author chema
 * @email pugabdk@hotmail.com 
 */
@Controller
public class BookAjaxRestController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private UserInterface userInterface;
	
	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	/**
	 * Handle /bookAjax/1_titulos
	 * 
	 * @param model
	 * @return String de salida
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/bookAjax/1_titulos/{tit}"})
	public ResponseEntity<String> getTitulos1(@PathVariable(value = "tit")  String tit){
		logger.info(" ===> *** ACTION  : /bookAjax/1_titulos");
		/*
		List<User> users = userInterface.selectAll();
		model.put("users", users);		
		return "configChannels/inicio";
		*/		
		// EN CASO DE ERROR
		// return  new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
		try{
			String[] comentarios = {"Requiere conocimientos básicos de POO",
					"Puede construir fácilmente aplicaciones para la Web",
					"Aprenderá rápidamente los principales trucos de Ajax",
					"Introduce las principales tecnologías de la plataforma",
					} ;
			int sel = Integer.parseInt(tit);			
			return new ResponseEntity<String>((String)comentarios[sel],HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return  new ResponseEntity<String>("SELECCION INVÁLIDA",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Handle /bookAjax/2_titulos
	 * 
	 * @param model
	 * @return String de salida con un documento XML bien formado
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/bookAjax/2_titulos/{tit}"})
	public ResponseEntity<String> getTitulos2_xml(@PathVariable(value = "tit")  String tit){
		logger.info(" ===> *** ACTION  : /bookAjax/2_titulos/XMLOutput");		
		try{
			String[] comentarios = {"Requiere conocimientos básicos de POO",
					"Puede construir fácilmente aplicaciones para la Web",
					"Aprenderá rápidamente los principales trucos de Ajax",
					"Introduce las principales tecnologías de la plataforma",
					} ;
			String[] precios = {"23.5","31.4","32.0","27.5"};
			int sel = Integer.parseInt(tit);
			
			// Formación del documento XML de respuesta
			String textoXML = "<?xml version='1.0'?>";
			textoXML += "<libro>";
				textoXML += "<id>"+sel+"</id>";
				textoXML += "<comentario>"+comentarios[sel]+"</comentario>";
				textoXML += "<precio>"+precios[sel]+"</precio>";
			textoXML += "</libro>";
			textoXML += "<libro>";
				textoXML += "<id>"+sel+"</id>";
				textoXML += "<comentario>"+comentarios[sel]+"</comentario>";
				textoXML += "<precio>"+precios[sel]+"</precio>";
			textoXML += "</libro>";
			
			
			return new ResponseEntity<String>(textoXML,HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return  new ResponseEntity<String>("SELECCION INVÁLIDA",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Handle /bookAjax/3_validador
	 * Obtener la colección de controles del form a partir de un HttpServletRequest request
	 * Con esto podemos lanzar FORMS en HTML (Sin usar JSP ni Forms de Spring) ==> Puro HTML y Aiax PURO =)
     * Del lado del HTML se usa encodeURIComponent() => Codificación adecuada para que la cadena de parámetros pueda ser pasada al server
     * Sustituir espacios y caracteres especiales por su equivalente codificación URL.
	 * 
	 * @param model
	 * @return String de salida
	 * */
	@RequestMapping(method = RequestMethod.POST, value = {"/bookAjax/3_validador"})
	public ResponseEntity<String> validador3(HttpServletRequest request){
		logger.info(" ===> *** ACTION  : /bookAjax/3_validador");
		
		try{
			String txtNombre = request.getParameter("txtNombre");
			logger.info(" ===> *** txtNombre = " +txtNombre);
			String resultado = "<b><i> Datos correctos !</i></b>";
			
			return new ResponseEntity<String>(resultado,HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return  new ResponseEntity<String>("ERROR AL PROCESAR EL FORM",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
					
}
