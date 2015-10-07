/**
 * OrderServiceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.redhat.www.samples.ws.OrderService;

public class OrderServiceSoapBindingSkeleton implements com.redhat.www.samples.ws.OrderService.OrderService_PortType, org.apache.axis.wsdl.Skeleton {
    private com.redhat.www.samples.ws.OrderService.OrderService_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("placeOrder", _params, new javax.xml.namespace.QName("", "out"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.redhat.com/samples/ws/OrderService/", "PlaceOrder"));
        _oper.setSoapAction("http://www.redhat.com/samples/ws/PlaceOrder");
        _myOperationsList.add(_oper);
        if (_myOperations.get("placeOrder") == null) {
            _myOperations.put("placeOrder", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("placeOrder")).add(_oper);
    }

    public OrderServiceSoapBindingSkeleton() {
        this.impl = new com.redhat.www.samples.ws.OrderService.OrderServiceSoapBindingImpl();
    }

    public OrderServiceSoapBindingSkeleton(com.redhat.www.samples.ws.OrderService.OrderService_PortType impl) {
        this.impl = impl;
    }
    public java.lang.String placeOrder(java.lang.String in) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.placeOrder(in);
        return ret;
    }

}
