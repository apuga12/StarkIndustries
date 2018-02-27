package com.starkindustries.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.starkindustries.springapp.service.ProductManager;



@Controller
public class InventoryController {
	
    protected final Log logger = LogFactory.getLog(getClass());
    
    /*
     * Para que almacene una referencia a la clase ProductManager, Anotaremos la referencia con 
     * @Autowired para que Spring la pueda inyectar autom�ticamente cuando detecte el componente.
     * */
    @Autowired
    private ProductManager productManager;
    
    public void setProductManager(ProductManager productManager){
    	this.productManager = productManager;
    }
	

    @RequestMapping(value="/hello.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                
        String now = (new Date()).toString();
        
        logger.info("\n\n ===> *** Returning hello view Now = "+now);

        //return new ModelAndView("views/hello.jsp", "now", now);
        // <== Se sustituye al agregar el viewResolver para mapear la vista (nombre l�gico, no ruta f�sica del JSP en el controlador)
        
        //return new ModelAndView("hello", "now", now);
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("hello", "model", myModel);
    }
    
    
}
