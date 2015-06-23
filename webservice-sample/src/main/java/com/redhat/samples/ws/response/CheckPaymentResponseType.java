package com.redhat.samples.ws.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CheckPaymentResponseType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckPaymentResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="out" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckPaymentResponseType", propOrder = { "out", "outCDATA" })
public class CheckPaymentResponseType {

    @XmlElement(required = true)
    protected String out;

    @XmlElement(required = true)
    protected String outCDATA;

    /**
     * Gets the value of the out property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOut() {
        return this.out;
    }

    /**
     * Sets the value of the out property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setOut(String value) {
        this.out = value;
    }

    /**
     * @return the outCDATA
     */
    public String getOutCDATA() {
        return this.outCDATA;
    }

    /**
     * @param outCDATA
     *            the outCDATA to set
     */
    public void setOutCDATA(String outCDATA) {
        this.outCDATA = outCDATA;
    }

}
