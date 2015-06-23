package com.redhat.samples.ws.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PlaceOrderType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlaceOrderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="in" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlaceOrderType", propOrder = { "in" })
public class PlaceOrderType {

    @XmlElement(required = true)
    protected String in;

    /**
     * Gets the value of the in property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getIn() {
        return this.in;
    }

    /**
     * Sets the value of the in property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setIn(String value) {
        this.in = value;
    }

}
