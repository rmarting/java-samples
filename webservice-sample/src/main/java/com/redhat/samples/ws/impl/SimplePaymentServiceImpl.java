package com.redhat.samples.ws.impl;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.commons.lang.StringEscapeUtils;

import com.redhat.samples.ws.PaymentService;

@WebService(name = "PaymentService", serviceName = "PaymentService", endpointInterface = "com.redhat.samples.ws.PaymentService", targetNamespace = "http://www.redhat.com/samples/ws/PaymentService/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class SimplePaymentServiceImpl implements PaymentService {

    /**
     * Approves payment type when payment type is "VISA".
     * 
     * @param in
     *            the payment type.
     * @return <code>Payment approved</code> or <code>Payment disapproved</code>
     */
    @Override
    public String checkPaymentType(String in) {
        String response = "INVALID";
        if ("VISA".equals(in)) {
            response = "VALID";
        }
        response += "<EURO>€</EURO>";
        // return response += "<SPANISH>áéíóúñ</SPANISH>";
        // return "<RESPONSE>" + response + "</RESPONSE>";
        return response = StringEscapeUtils.escapeXml("VALID € áéíóúñ");
        // return response = "<> & &aacute; VALID € áéíóúñ";
    }

}
