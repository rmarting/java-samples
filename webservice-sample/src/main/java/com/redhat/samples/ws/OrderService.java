package com.redhat.samples.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://www.redhat.com/samples/ws/OrderService/", name = "OrderService")
public interface OrderService {

    @WebResult(name = "out", targetNamespace = "")
    @RequestWrapper(localName = "PlaceOrder", targetNamespace = "http://www.redhat.com/samples/ws/OrderService/", className = "com.redhat.samples.ws.request.PlaceOrderType")
    @WebMethod(operationName = "PlaceOrder", action = "http://www.redhat.com/samples/ws/PlaceOrder")
    @ResponseWrapper(localName = "PlaceOrderResponse", targetNamespace = "http://www.redhat.com/samples/ws/OrderService/", className = "com.redhat.samples.ws.resonse.PlaceOrderResponseType")
    String placeOrder(@WebParam(name = "in", targetNamespace = "") String in);

}
