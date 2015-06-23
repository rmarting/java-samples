package com.redhat.samples.ws.handler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Node;

public class MyCustomSOAPHandler implements SOAPHandler<SOAPMessageContext> {

    public MyCustomSOAPHandler() {
        System.out.println("MyCustomeSOAPHandler : constructor() ....");
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Server : getHeaders()......");
        return null;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Server : close()......");
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        logToSystemOut(context);
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        logToSystemOut(context);
        return true;
    }

    private void logToSystemOut(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
            System.out.println("\nOutbound message:");
        } else {
            System.out.println("\nInbound message:");
        }

        SOAPMessage message = smc.getMessage();
        try {
            if (outboundProperty.booleanValue()) {
                SOAPMessage msg = smc.getMessage();
                SOAPEnvelope soapEnv = msg.getSOAPPart().getEnvelope();

                SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();

                Node entity = soapBody.getFirstChild().getFirstChild();

                String property = entity.getFirstChild().getFirstChild().getNodeValue();
                System.out.println("Property value: " + property);
                String cdata = entity.getLastChild().getFirstChild().getNodeValue();
                System.out.println("CDATA value: " + cdata);

                // // Conversion
                // cdata = StringEscapeUtils.escapeXml(cdata);
                // System.out.println("CDAta value (escaped): " + cdata);

                // Assigned
                // soapBody.getFirstChild().getFirstChild().getFirstChild().getFirstChild().setNodeValue(cdata);
            }

            message.writeTo(System.out);
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Exception in handler: " + e);
        }
    }

}
