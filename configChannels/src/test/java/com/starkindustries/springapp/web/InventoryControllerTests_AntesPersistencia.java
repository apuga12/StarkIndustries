package com.starkindustries.springapp.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.starkindustries.springapp.service.SimpleProductManager;


public class InventoryControllerTests_AntesPersistencia {

    @Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        //	assertEquals("hello.jsp", modelAndView.getViewName());
        
        //assertEquals("views/hello.jsp", modelAndView.getViewName()); 
        // <== Se sustituye al agregar el viewResolver para mapear la vista (nombre lógico, no ruta física del JSP en el controlador)
                
        
        assertEquals("hello", modelAndView.getViewName()); // Mapeo contra nombre lógico, no físico =)
        assertNotNull(modelAndView.getModel());
        //String nowValue = (String) modelAndView.getModel().get("now");
        //assertNotNull(nowValue);
        
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }


}
