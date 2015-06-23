package com.redhat.samples.ejb;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloWorldTest {

    public static void main(String[] args) throws Exception {
        testRemoteEJB();
    }

    private static void testRemoteEJB() throws NamingException {

        final HelloWorld ejb = lookupRemoteEJB();
        String s = ejb.hi("Frank");
        System.out.println(s);
    }

    private static HelloWorld lookupRemoteEJB() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        // jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        // jndiProperties.put(Context.PROVIDER_URL, "remote://localhost:4447");
        // jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");
        // jndiProperties.put(Context.SECURITY_CREDENTIALS, "RedHat-1");

        final Context context = new InitialContext(jndiProperties);

        final String appName = "";
        final String moduleName = "app";
        final String distinctName = "stateless-ejb-sample";
        final String beanName = HelloWorldBean.class.getSimpleName();

        // ejb:/app//HelloWorldBean!com.redhat.samples.ejb.HelloWorld

        // java:global/stateless-ejb-sample/HelloWorldBean!com.redhat.samples.ejb.HelloWorldBean
        // java:app/stateless-ejb-sample/HelloWorldBean!com.redhat.samples.ejb.HelloWorldBean
        // java:module/HelloWorldBean!com.redhat.samples.ejb.HelloWorldBean
        // java:global/stateless-ejb-sample/HelloWorldBean!com.redhat.samples.ejb.HelloWorld
        // java:app/stateless-ejb-sample/HelloWorldBean!com.redhat.samples.ejb.HelloWorld
        // java:module/HelloWorldBean!com.redhat.samples.ejb.HelloWorld
        // java:jboss/exported/stateless-ejb-sample/HelloWorldBean!com.redhat.samples.ejb.HelloWorld

        final String viewClassName = HelloWorld.class.getName();
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);

        return (HelloWorld) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);

    }

}
