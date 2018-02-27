package com.starkindustries.springapp.webserviceclient.CustomUI;

public class TT_spcConsulta_spcEquiposProxy implements com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_PortType {
  private String _endpoint = null;
  private com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_PortType tT_spcConsulta_spcEquipos_PortType = null;
  
  public TT_spcConsulta_spcEquiposProxy() {
    _initTT_spcConsulta_spcEquiposProxy();
  }
  
  public TT_spcConsulta_spcEquiposProxy(String endpoint) {
    _endpoint = endpoint;
    _initTT_spcConsulta_spcEquiposProxy();
  }
  
  private void _initTT_spcConsulta_spcEquiposProxy() {
    try {
      tT_spcConsulta_spcEquipos_PortType = (new com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_ServiceLocator()).getTT_spcConsulta_spcEquipos();
      if (tT_spcConsulta_spcEquipos_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tT_spcConsulta_spcEquipos_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tT_spcConsulta_spcEquipos_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tT_spcConsulta_spcEquipos_PortType != null)
      ((javax.xml.rpc.Stub)tT_spcConsulta_spcEquipos_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_PortType getTT_spcConsulta_spcEquipos_PortType() {
    if (tT_spcConsulta_spcEquipos_PortType == null)
      _initTT_spcConsulta_spcEquiposProxy();
    return tT_spcConsulta_spcEquipos_PortType;
  }
  
  public com.starkindustries.springapp.webserviceclient.CustomUI.ConsultaEquiposIzziApp_Output consultaEquiposIzziApp(com.starkindustries.springapp.webserviceclient.CustomUI.ConsultaEquiposIzziApp_Input consultaEquiposIzziApp_Input) throws java.rmi.RemoteException{
    if (tT_spcConsulta_spcEquipos_PortType == null)
      _initTT_spcConsulta_spcEquiposProxy();
    return tT_spcConsulta_spcEquipos_PortType.consultaEquiposIzziApp(consultaEquiposIzziApp_Input);
  }
  
  
}