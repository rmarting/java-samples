package com.redhat.samples.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://www.redhat.com/samples/ws/PaymentService/", name = "PaymentService")
public interface PaymentService {

    @WebResult(name = "out", targetNamespace = "")
    @RequestWrapper(localName = "CheckPaymentType", targetNamespace = "http://www.redhat.com/samples/ws/PaymentService/", className = "com.redhat.samples.ws.request.CheckPaymentType")
    @WebMethod(operationName = "CheckPaymentType", action = "http://www.redhat.com/samples/ws/PaymentService/CheckPaymentType")
    @ResponseWrapper(localName = "CheckPaymentTypeResponse", targetNamespace = "http://www.redhat.com/samples/ws/PaymentService/", className = "com.redhat.samples.ws.response.CheckPaymentResponseType")
    String checkPaymentType(@WebParam(name = "in", targetNamespace = "") String in);

}
