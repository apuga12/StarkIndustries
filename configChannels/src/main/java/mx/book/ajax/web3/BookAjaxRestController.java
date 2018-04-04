package mx.book.ajax.web3;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.book.ajax.repository3.BookAjaxRestDao;
import mx.book.ajax.vo3.Categoria;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.starkindustries.springapp.repository2.UserDao;
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
	
	@Autowired
	private BookAjaxRestDao bookAjaxRestDao;
	public void setBookAjaxRestDao(BookAjaxRestDao bookAjaxRestDao){
		this.bookAjaxRestDao = bookAjaxRestDao;
	}
	@Autowired
	private UserDao userDao;

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
	
	/**
	 * Handle /bookAjax/4_getPalabraPred
	 * 
	 * @param model
	 * @return String de salida es la palabra predictiva
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/bookAjax/4_getPalabraPred/{dato}"})
	public ResponseEntity<String> getPalabra4(@PathVariable(value = "dato")  String dato){
		logger.info(" ===> *** ACTION  : /bookAjax/4_getPalabraPred/dato");
		try{ 			
			return new ResponseEntity<String>((String)bookAjaxRestDao.selectNextPalabraPredictiva(dato),HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return  new ResponseEntity<String>("ERROR EN LA BD",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Handle /bookAjax/5_listaLigadaCat_1
	 * 
	 * @param model
	 * @return String de salida con un documento XML bien formado
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/bookAjax/5_listaLigadaCat_1"})
	public ResponseEntity<String> listaLigadaCat_1(){
		logger.info(" ===> *** ACTION  : /bookAjax/5_listaLigadaCat_1");		
		try{
			String[] titulos = {"Programación con C#", "ASP.NET", "AJAX en un día", "JAVA EE 8"} ;
			String[] precios = {"23.5","31.4","32.0","27.5"};
						
			// Formación del documento XML de respuesta
			String textoXML = "<?xml version='1.0'?>";
			textoXML += "<listado>";
			for(int i=0; i<titulos.length; i++){
				textoXML += "<libro>";
					textoXML += "<id>"+i+"</id>";
					textoXML += "<titulo>"+titulos[i]+"</titulo>";
					textoXML += "<precio>"+precios[i]+"</precio>";
				textoXML += "</libro>";
			}
			textoXML += "</listado>";
			
			
			return new ResponseEntity<String>(textoXML,HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return  new ResponseEntity<String>("SELECCION INVÁLIDA",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Handle /bookAjax/8_login
	 * @param model
	 * @return String con JSON categorias de libros
	 * */
	@RequestMapping(method = RequestMethod.POST, value = {"/bookAjax/8_login"})
	//public ResponseEntity<String> login8(HttpServletRequest request){
	public ResponseEntity<String> login8(@RequestParam(value="user", required=true) String user, @RequestParam(value="pwd", required=true) String pwd){
		logger.info(" ===> *** ACTION  : /bookAjax/8_login v2 PRO");
		
		try{
//			String user = request.getParameter("user");
//			String pwd = request.getParameter("pwd");
			logger.info(" ===> *** user / pwd = " +user+" / "+pwd);
			String resultado = ""+userDao.isRegistered(user, pwd);
			List<Categoria> categorias = userDao.selectAllCategories();
			for (Iterator iterator = categorias.iterator(); iterator.hasNext();) {
				Categoria categoria = (Categoria) iterator.next();
				logger.info(categoria.toString());
			}
			
			return new ResponseEntity<String>(resultado,HttpStatus.OK);
		} catch(Exception e){
			e.printStackTrace();
			return  new ResponseEntity<String>("ERROR AL PROCESAR EL FORM",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
					
}
