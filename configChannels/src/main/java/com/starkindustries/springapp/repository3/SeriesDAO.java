package com.starkindustries.springapp.repository3;

import java.util.List;

import com.starkindustries.springapp.domain3.Series;
import com.starkindustries.springapp.domain3.TtcGuiaCanalesLegacy;

public interface SeriesDAO {
	
	public int create(Series series);
	public Series find(Integer id);
	public List<Series> get();
	public void delete(Integer id);
	public Series update(Series series);
	
	// TtcGuiaCanalesLegacy  Test Web
	public List<TtcGuiaCanalesLegacy> getGuiaCanales(String empresa, String ciudad, String paquete);
}
