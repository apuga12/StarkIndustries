package com.starkindustries.springapp.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface StarkWSInterface {

	@WebMethod
	public  String fetchPlants(String plantName);
	
	@WebMethod
	public  StarkWSServiceTestResponse starkWSServiceTest(StarkWSServiceTestRequest starkWSServiceTestRequest);

}