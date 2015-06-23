package com.redhat.samples.ws.impl;

import javax.jws.WebService;

import com.redhat.samples.ws.OrderService;

@WebService(name = "OrderService", serviceName = "OrderService", endpointInterface = "com.redhat.samples.ws.OrderService", targetNamespace = "http://www.redhat.com/samples/ws/OrderService/", wsdlLocation = "WEB-INF/wsdl/simple-order-service.wsdl")
public class SimpleOrderServiceImpl implements OrderService {

    @Override
    public String placeOrder(String in) {
        return "Order '" + in + "' submitted successfully";
    }

}
