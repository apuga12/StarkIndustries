package com.starkindustries.springapp.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.starkindustries.springapp.webserviceclient.CustomUI.*;


@WebService
public class StarkWSService implements StarkWSInterface {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	//@WebMethod(operationName = "StarkWSServiceTest")
	@WebMethod
	public StarkWSServiceTestResponse starkWSServiceTest(StarkWSServiceTestRequest starkWSServiceTestRequest){
		logger.info(" ===> *** Ingreso al WS ==> starkWSServiceTest() : "+starkWSServiceTestRequest.getName());
		
		ConsultaEquiposIzziApp_Input consultaEquiposIzziApp_Input = new ConsultaEquiposIzziApp_Input();
		consultaEquiposIzziApp_Input.setAccount_spcNumber(starkWSServiceTestRequest.getName());
		ConsultaEquiposIzziApp_Output consultaEquiposIzziApp_Output = new ConsultaEquiposIzziApp_Output();
		logger.info(" ===> *** CUENTA = "+consultaEquiposIzziApp_Input.getAccount_spcNumber());
		try{
			
			TT_spcConsulta_spcEquipos_Service consultaEquiposService = new TT_spcConsulta_spcEquipos_ServiceLocator();
			consultaEquiposIzziApp_Output = 
					consultaEquiposService.getTT_spcConsulta_spcEquipos().consultaEquiposIzziApp(consultaEquiposIzziApp_Input);
			
			
			
			logger.info(" ===> Salida Body ***  ==> \n"+consultaEquiposIzziApp_Output.getAccount_spcNumber());
			
			//TT_spcConsulta_spcEquipos_BindingStub tt_spcConsulta_spcEquipos_BindingStub = new TT_spcConsulta_spcEquipos_BindingStub();
			//consultaEquiposIzziApp_Output = tt_spcConsulta_spcEquipos_BindingStub.consultaEquiposIzziApp(consultaEquiposIzziApp_Input);

			//logger.info(" ===> AccountName ***  ==> "+consultaEquiposIzziApp_Output.getAccount_spcNumber());
			
			logger.info(" ===> Description ***  ==> "+consultaEquiposIzziApp_Output.getListOfTtConsultaEquipos()[0].getDescription());
			logger.info(" ===> MACAddress ***  ==> "+consultaEquiposIzziApp_Output.getListOfTtConsultaEquipos()[0].getMACAddress());
			logger.info(" ===> MACAddressEMTA ***  ==> "+consultaEquiposIzziApp_Output.getListOfTtConsultaEquipos()[0].getMACAddressEMTA());
			logger.info(" ===> SerialNumber ***  ==> "+consultaEquiposIzziApp_Output.getListOfTtConsultaEquipos()[0].getSerialNumber());
			
		
		
		
			return new StarkWSServiceTestResponse(consultaEquiposIzziApp_Output.getAccount_spcNumber(),
					consultaEquiposIzziApp_Output.getListOfTtConsultaEquipos()[0].getMACAddressEMTA(), 
					consultaEquiposIzziApp_Output.getListOfTtConsultaEquipos()[0].getDescription());
			//return new StarkWSServiceTestResponse("NULL","0", "OK");
		} catch(Exception e){			
			logger.info(" ===> *** ERROR = \n"+ e.getMessage());
			return new StarkWSServiceTestResponse(starkWSServiceTestRequest.getName(),"-1", "Failure");
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.starkindustries.springapp.webservice.StarkWSInterface#fetchPlants(java.lang.String)
	 */
	@Override
	@WebMethod
	public String fetchPlants(String plantName){
		return "Hello =>"+ plantName;
	}
}
	