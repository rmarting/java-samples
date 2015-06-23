package com.redhat.samples.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Entity", propOrder = { "property", "cdataProperty" })
public class Entity {

    private String property;
    private String cdataProperty;

    public Entity() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the property
     */
    public String getProperty() {
        return property;
    }

    /**
     * @param property
     *            the property to set
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return the cdataProperty
     */
    public String getCdataProperty() {
        return this.cdataProperty;
    }

    /**
     * @param cdataProperty
     * 
     *            the cdataProperty to set
     */
    public void setCdataProperty(String cdataProperty) {
        this.cdataProperty = cdataProperty;
    }

}
