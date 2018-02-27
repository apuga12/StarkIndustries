/**
 * ConsultaEquiposIzziApp_Output.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.starkindustries.springapp.webserviceclient.CustomUI;

public class ConsultaEquiposIzziApp_Output  implements java.io.Serializable {
    private java.lang.String account_spcNumber;

    private java.lang.String error_spcCode;

    private java.lang.String error_spcMessage;

    private com.starkindustries.springapp.webserviceclient.CustomUI.TtConsultaEquipos[] listOfTtConsultaEquipos;

    public ConsultaEquiposIzziApp_Output() {
    }

    public ConsultaEquiposIzziApp_Output(
           java.lang.String account_spcNumber,
           java.lang.String error_spcCode,
           java.lang.String error_spcMessage,
           com.starkindustries.springapp.webserviceclient.CustomUI.TtConsultaEquipos[] listOfTtConsultaEquipos) {
           this.account_spcNumber = account_spcNumber;
           this.error_spcCode = error_spcCode;
           this.error_spcMessage = error_spcMessage;
           this.listOfTtConsultaEquipos = listOfTtConsultaEquipos;
    }


    /**
     * Gets the account_spcNumber value for this ConsultaEquiposIzziApp_Output.
     * 
     * @return account_spcNumber
     */
    public java.lang.String getAccount_spcNumber() {
        return account_spcNumber;
    }


    /**
     * Sets the account_spcNumber value for this ConsultaEquiposIzziApp_Output.
     * 
     * @param account_spcNumber
     */
    public void setAccount_spcNumber(java.lang.String account_spcNumber) {
        this.account_spcNumber = account_spcNumber;
    }


    /**
     * Gets the error_spcCode value for this ConsultaEquiposIzziApp_Output.
     * 
     * @return error_spcCode
     */
    public java.lang.String getError_spcCode() {
        return error_spcCode;
    }


    /**
     * Sets the error_spcCode value for this ConsultaEquiposIzziApp_Output.
     * 
     * @param error_spcCode
     */
    public void setError_spcCode(java.lang.String error_spcCode) {
        this.error_spcCode = error_spcCode;
    }


    /**
     * Gets the error_spcMessage value for this ConsultaEquiposIzziApp_Output.
     * 
     * @return error_spcMessage
     */
    public java.lang.String getError_spcMessage() {
        return error_spcMessage;
    }


    /**
     * Sets the error_spcMessage value for this ConsultaEquiposIzziApp_Output.
     * 
     * @param error_spcMessage
     */
    public void setError_spcMessage(java.lang.String error_spcMessage) {
        this.error_spcMessage = error_spcMessage;
    }


    /**
     * Gets the listOfTtConsultaEquipos value for this ConsultaEquiposIzziApp_Output.
     * 
     * @return listOfTtConsultaEquipos
     */
    public com.starkindustries.springapp.webserviceclient.CustomUI.TtConsultaEquipos[] getListOfTtConsultaEquipos() {
        return listOfTtConsultaEquipos;
    }


    /**
     * Sets the listOfTtConsultaEquipos value for this ConsultaEquiposIzziApp_Output.
     * 
     * @param listOfTtConsultaEquipos
     */
    public void setListOfTtConsultaEquipos(com.starkindustries.springapp.webserviceclient.CustomUI.TtConsultaEquipos[] listOfTtConsultaEquipos) {
        this.listOfTtConsultaEquipos = listOfTtConsultaEquipos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaEquiposIzziApp_Output)) return false;
        ConsultaEquiposIzziApp_Output other = (ConsultaEquiposIzziApp_Output) obj;
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
              this.account_spcNumber.equals(other.getAccount_spcNumber()))) &&
            ((this.error_spcCode==null && other.getError_spcCode()==null) || 
             (this.error_spcCode!=null &&
              this.error_spcCode.equals(other.getError_spcCode()))) &&
            ((this.error_spcMessage==null && other.getError_spcMessage()==null) || 
             (this.error_spcMessage!=null &&
              this.error_spcMessage.equals(other.getError_spcMessage()))) &&
            ((this.listOfTtConsultaEquipos==null && other.getListOfTtConsultaEquipos()==null) || 
             (this.listOfTtConsultaEquipos!=null &&
              java.util.Arrays.equals(this.listOfTtConsultaEquipos, other.getListOfTtConsultaEquipos())));
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
        if (getError_spcCode() != null) {
            _hashCode += getError_spcCode().hashCode();
        }
        if (getError_spcMessage() != null) {
            _hashCode += getError_spcMessage().hashCode();
        }
        if (getListOfTtConsultaEquipos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListOfTtConsultaEquipos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListOfTtConsultaEquipos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaEquiposIzziApp_Output.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://siebel.com/CustomUI", ">ConsultaEquiposIzziApp_Output"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("account_spcNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siebel.com/CustomUI", "Account_spcNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error_spcCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siebel.com/CustomUI", "Error_spcCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error_spcMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://siebel.com/CustomUI", "Error_spcMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listOfTtConsultaEquipos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.siebel.com/xml/TT%20Consulta%20Equipos", "ListOfTtConsultaEquipos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.siebel.com/xml/TT%20Consulta%20Equipos", "ListOfTtConsultaEquipos"));
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
