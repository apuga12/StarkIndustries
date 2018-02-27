/**
 * ConsultaEquiposIzziApp_Input.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.starkindustries.springapp.webserviceclient.CustomUI;

public class ConsultaEquiposIzziApp_Input  implements java.io.Serializable {
    private java.lang.String account_spcNumber;

    public ConsultaEquiposIzziApp_Input() {
    }

    public ConsultaEquiposIzziApp_Input(
           java.lang.String account_spcNumber) {
           this.account_spcNumber = account_spcNumber;
    }


    /**
     * Gets the account_spcNumber value for this ConsultaEquiposIzziApp_Input.
     * 
     * @return account_spcNumber
     */
    public java.lang.String getAccount_spcNumber() {
        return account_spcNumber;
    }


    /**
     * Sets the account_spcNumber value for this ConsultaEquiposIzziApp_Input.
     * 
     * @param account_spcNumber
     */
    public void setAccount_spcNumber(java.lang.String account_spcNumber) {
        this.account_spcNumber = account_spcNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaEquiposIzziApp_Input)) return false;
        ConsultaEquiposIzziApp_Input other = (ConsultaEquiposIzziApp_Input) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.account_spcNumber==null && other.getAccount_spcNumber()==null) || 
             (this.account_spcNumber!=null &&
              this.account_spcNumber.equals(other.getAccount_spcNumber())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAccount_spcNumber() != null) {
            _hashCode += getAccount_spcNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaEquiposIzziApp_Input.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siebel.com/CustomUI", ">ConsultaEquiposIzziApp_Input"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("account_spcNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siebel.com/CustomUI", "Account_spcNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
