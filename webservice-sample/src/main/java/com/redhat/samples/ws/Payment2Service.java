package com.redhat.samples.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.redhat.com/samples/ws/Payment2Service/", name = "Payment2Service")
public interface Payment2Service {

    @WebResult(name = "out", targetNamespace = "")
    @WebMethod(operationName = "CheckPaymentType", action = "http://www.redhat.com/samples/ws/Payment2Service/CheckPaymentType")
    String checkPaymentType(@WebParam(name = "in", targetNamespace = "") String in);

}
