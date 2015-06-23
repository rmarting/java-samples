package com.redhat.samples.ws.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.redhat.samples.ws.model.Entity;

/**
 * <p>
 * Java class for SimpleResponseType complex type.
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
@XmlType(name = "SimpleResponseType", propOrder = { "entity" })
public class SimpleResponseType {

    @XmlElement(required = true)
    protected Entity entity;

    // @XmlElement(required = true)
    // // @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    // protected String outCDATA;

    public Entity getEntity() {
        return this.entity;
    }

    public void setEntity(Entity value) {
        this.entity = value;
    }

    // /**
    // * @return the outCDATA
    // */
    // public String getOutCDATA() {
    // return this.outCDATA;
    // }
    //
    // /**
    // * @param outCDATA
    // * the outCDATA to set
    // */
    // public void setOutCDATA(String outCDATA) {
    // this.outCDATA = outCDATA;
    // }

}
