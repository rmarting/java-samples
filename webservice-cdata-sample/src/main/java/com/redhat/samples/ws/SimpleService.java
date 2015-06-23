package com.redhat.samples.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.redhat.samples.ws.model.Entity;

@WebService(targetNamespace = "http://www.redhat.com/samples/ws/SimpleService/", name = "SimpleService")
public interface SimpleService {

    @WebResult(name = "entity", targetNamespace = "")
    @RequestWrapper(localName = "SimpleType", targetNamespace = "http://www.redhat.com/samples/ws/SimpleService/", className = "com.redhat.samples.ws.request.SimpleType")
    @WebMethod(operationName = "test", action = "http://www.redhat.com/samples/ws/SimpleService/test")
    @ResponseWrapper(localName = "SimpleResponseType", targetNamespace = "http://www.redhat.com/samples/ws/SimpleService/", className = "com.redhat.samples.ws.response.SimpleResponseType")
    Entity test(@WebParam(name = "in", targetNamespace = "") String in);

}
