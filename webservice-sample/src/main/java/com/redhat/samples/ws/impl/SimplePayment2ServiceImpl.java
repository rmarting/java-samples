package com.redhat.samples.ws.impl;

import javax.jws.WebService;

import com.redhat.samples.ws.Payment2Service;

@WebService(name = "Payment2Service", serviceName = "Payment2Service", endpointInterface = "com.redhat.samples.ws.Payment2Service", targetNamespace = "http://www.redhat.com/samples/ws/Payment2Service/")
public class SimplePayment2ServiceImpl implements Payment2Service {

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
        return response;
    }

}
