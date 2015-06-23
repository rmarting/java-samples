package com.redhat.samples.ws.impl;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.commons.lang.StringEscapeUtils;

import com.redhat.samples.ws.SimpleService;
import com.redhat.samples.ws.model.Entity;

@WebService(name = "SimpleService", serviceName = "SimpleService", endpointInterface = "com.redhat.samples.ws.SimpleService", targetNamespace = "http://www.redhat.com/samples/ws/SimpleService/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
@HandlerChain(file = "/handler-chain.xml")
public class SimpleServiceImpl implements SimpleService {

    @Override
    public Entity test(String in) {
        Entity response = new Entity();

        response.setProperty("<TICKET>123454</TICKET><VALID>Euro Symbol (€) Ampersand (&) Spanish Characters: áéíóúñ</VALID>");
        response.setCdataProperty(StringEscapeUtils
                .escapeXml("<TICKET>123454</TICKET><VALID>Euro Symbol (€) Ampersand (&) Spanish Characters: áéíóúñ</VALID>"));

        return response;
    }

}
