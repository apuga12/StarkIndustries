package com.starkindustries.springapp.web3;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starkindustries.springapp.domain3.Series;
import com.starkindustries.springapp.domain3.TtcGuiaCanalesLegacy;
import com.starkindustries.springapp.repository3.SeriesDAO;


/**
 * Clase Controladora para exponer servicios REST
 * @author chema
 * @email pugabdk@hotmail.com 
 */
@RestController
@RequestMapping("/series")
public class SeriesRestController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private SeriesDAO seriesDAO;

	public SeriesDAO getSeriesDAO() {
		return seriesDAO;
	}

	public void setSeriesDAO(SeriesDAO seriesDAO) {
		this.seriesDAO = seriesDAO;
	}
	
	/**
	 * Regresa la lista de las series de TV
	 * handles /series
	 * @return Lista de todas las series
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public List<com.starkindustries.springapp.domain3.Series> getAll(){
		return seriesDAO.get();
	}
	
	
	/**
	 * Regresa el show de TV asociado a un ID.
	 * handles /series/id
	 * @param id
	 * @return La serie asociada al ID
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/{id}"})
	public com.starkindustries.springapp.domain3.Series getById(@PathVariable(value = "id") Integer id){
		return seriesDAO.find(id);
	}
	
	/**
	 * Crea un nuevo show de TV.
	 * handles /series by POST	 
	 * @return TRUE si el show se creó exitosamente
	 * */
	@RequestMapping(method = RequestMethod.POST)
	//public boolean create(@RequestBody @Valid com.starkindustries.springapp.domain3.Series series){
	public boolean create(@RequestBody com.starkindustries.springapp.domain3.Series series){
	//public boolean create(@RequestParam com.starkindustries.springapp.domain3.Series series){
		logger.info(" ===> *** Ingreso a ==> create(serie)");
		return seriesDAO.create(series) > 0;
	}
	
	/**
	 * Actualiza un show de TV mediante su ID
	 * handles /series/{id} by PUT
	 * @param id
	 * @param series
	 * @return TRUE si el show se actualizó exitosamente
	 * */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public boolean update(@PathVariable Integer id, @RequestBody @Valid Series series){
		series.setId(id);
		return seriesDAO.update(series) != null;
	}
	
	/**
	 * Elimina un show de TV mediante su ID
	 * handles /series/{id} by DELETE
	 * @param id
	 * */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){ 
		seriesDAO.delete(id);
	}
	
	
	/**
	 * Regresa la lista de las guías de canales
	 * handles /series
	 * @return Lista de todas las series
	 * */
	@RequestMapping(method = RequestMethod.GET, value="/{empresa}/{ciudad}")
			public List<TtcGuiaCanalesLegacy> getGuiaCanales(@PathVariable String empresa, @PathVariable String ciudad){
				return seriesDAO.getGuiaCanales(empresa, ciudad, "miniBasico");
			}
	

}
