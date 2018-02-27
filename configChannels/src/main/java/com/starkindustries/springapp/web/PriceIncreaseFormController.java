package com.starkindustries.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starkindustries.springapp.service.PriceIncrease;
import com.starkindustries.springapp.service.ProductManager;


/*
 * Clase PriceIncreaseFormController que actuará como controlador de las peticiones de incremento 
 * de precio realizadas desde el formulario. 
 * Spring inyectará automáticamente al controlador del formulario la referencia al servicio ProductManager 
 * gracias a la anotació @Autowired. 
 * 
 * El método formBackingObject(..) será invocado antes de que el formulario se muestre al usuario 
 * (petición GET) y rellenará el campo con un incremento por defecto de un 15%. 
 * 
 * El método onSubmit(..) será invocado cuando el usuario envíe del formulario a través del método POST.
 * El uso de la anotación @Valid permitirá validar el incremento introducido y volverá a mostrar 
 * el formulario en caso de que éste no sea válido (valores 0 - 50).
 * */


@Controller
@RequestMapping(value="/priceincrease.htm")
public class PriceIncreaseFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result)
    {
        if (result.hasErrors()) {
            return "priceincrease";
        }
		
        int increase = priceIncrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        productManager.increasePrice(increase);

        return "redirect:/hello.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected PriceIncrease formBackingObject(HttpServletRequest request) throws ServletException {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(15);
        return priceIncrease;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}
