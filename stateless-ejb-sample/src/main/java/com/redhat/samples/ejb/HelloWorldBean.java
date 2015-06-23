package com.redhat.samples.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * 
 * @author rmarting@redhat.com
 */
@Stateless
@LocalBean
@Remote(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {

    @Override
    public String hi(String name) {
        return "Hi " + name + "!";
    }

}
