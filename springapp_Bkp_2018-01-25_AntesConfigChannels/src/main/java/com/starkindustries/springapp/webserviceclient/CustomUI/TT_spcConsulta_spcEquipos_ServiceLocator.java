/**
 * TT_spcConsulta_spcEquipos_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.starkindustries.springapp.webserviceclient.CustomUI;

public class TT_spcConsulta_spcEquipos_ServiceLocator extends org.apache.axis.client.Service implements com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_Service {

    public TT_spcConsulta_spcEquipos_ServiceLocator() {
    }


    public TT_spcConsulta_spcEquipos_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TT_spcConsulta_spcEquipos_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TT_spcConsulta_spcEquipos
    private java.lang.String TT_spcConsulta_spcEquipos_address = "http://172.21.20.145:8001/izziWeb/WebQueries/ConsultaEquipos/PS/ConsultaEquiposPS";

    public java.lang.String getTT_spcConsulta_spcEquiposAddress() {
        return TT_spcConsulta_spcEquipos_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TT_spcConsulta_spcEquiposWSDDServiceName = "TT_spcConsulta_spcEquipos";

    public java.lang.String getTT_spcConsulta_spcEquiposWSDDServiceName() {
        return TT_spcConsulta_spcEquiposWSDDServiceName;
    }

    public void setTT_spcConsulta_spcEquiposWSDDServiceName(java.lang.String name) {
        TT_spcConsulta_spcEquiposWSDDServiceName = name;
    }

    public com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_PortType getTT_spcConsulta_spcEquipos() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TT_spcConsulta_spcEquipos_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTT_spcConsulta_spcEquipos(endpoint);
    }

    public com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_PortType getTT_spcConsulta_spcEquipos(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_BindingStub _stub = new com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_BindingStub(portAddress, this);
            _stub.setPortName(getTT_spcConsulta_spcEquiposWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTT_spcConsulta_spcEquiposEndpointAddress(java.lang.String address) {
        TT_spcConsulta_spcEquipos_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_BindingStub _stub = new com.starkindustries.springapp.webserviceclient.CustomUI.TT_spcConsulta_spcEquipos_BindingStub(new java.net.URL(TT_spcConsulta_spcEquipos_address), this);
                _stub.setPortName(getTT_spcConsulta_spcEquiposWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TT_spcConsulta_spcEquipos".equals(inputPortName)) {
            return getTT_spcConsulta_spcEquipos();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://siebel.com/CustomUI", "TT_spcConsulta_spcEquipos");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://siebel.com/CustomUI", "TT_spcConsulta_spcEquipos"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TT_spcConsulta_spcEquipos".equals(portName)) {
            setTT_spcConsulta_spcEquiposEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
