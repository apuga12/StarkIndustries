package com.starkindustries.springapp.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/*
 * VALIDATION FORM:
 * JavaBean muy sencillo que solamente contiene una propiedad, con sus correspondientes m�todos getter y setter. 
 * �ste es el objeto que el formulario rellenar� y desde el que nuestra l�gica de negocio 
 * extraer� el porcentaje de incremento que queremos aplicar a los precios. 
 * La clase PriceIncrease utiliza las anotaciones @Min y @Max para definir el intervalo 
 * de valores v�lido para el incremento de precios del stock.
 * */
public class PriceIncrease {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Min(0)
    @Max(50)
    private int percentage;

    public void setPercentage(int i) {
        percentage = i;
        logger.info("Percentage set to " + i);
    }

    public int getPercentage() {
        return percentage;
    }
}