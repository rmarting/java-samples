/**
 * OrderServiceSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.redhat.www.samples.ws.OrderService;

public class OrderServiceSoapBindingImpl implements com.redhat.www.samples.ws.OrderService.OrderService_PortType{
    public java.lang.String placeOrder(java.lang.String in) throws java.rmi.RemoteException {
        return "Order " + in + " placed";
    }

}
