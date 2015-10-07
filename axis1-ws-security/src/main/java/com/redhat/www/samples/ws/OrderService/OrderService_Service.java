/**
 * OrderService_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.redhat.www.samples.ws.OrderService;

public interface OrderService_Service extends javax.xml.rpc.Service {
    public java.lang.String getOrderServicePortAddress();

    public com.redhat.www.samples.ws.OrderService.OrderService_PortType getOrderServicePort() throws javax.xml.rpc.ServiceException;

    public com.redhat.www.samples.ws.OrderService.OrderService_PortType getOrderServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
