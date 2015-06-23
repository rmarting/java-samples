package com.redhat.samples.web;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SenderAMQ {

    /** Context */
    private Context ctx = null;

    /**
     * Default constructor.
     */
    public SenderAMQ() {
        try {
            // Loading Initial Context
            this.ctx = new InitialContext();
        } catch (NamingException e) {
            // throw new ServletException("Unable to get Initial Context", e);
        }
    }

    public Boolean sendMessage(String connectionFactory, String queue, String message) {
        QueueConnectionFactory jmsQueueConnectionFactory = null;
        Queue jmsQueue = null;
        QueueConnection jmsQueueConnection = null;
        QueueSession jmsSession = null;
        QueueSender jmsQueueSender = null;

        try {
            // JNDI Objects
            jmsQueueConnectionFactory = (QueueConnectionFactory) ctx.lookup(connectionFactory);
            jmsQueue = (Queue) ctx.lookup(queue);

            // JMS Objects
            jmsQueueConnection = jmsQueueConnectionFactory.createQueueConnection();
            jmsSession = jmsQueueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            jmsQueueSender = jmsSession.createSender(jmsQueue);

            // Message
            TextMessage msg = jmsSession.createTextMessage();
            msg.setText(message);

            // Send
            jmsQueueSender.send(msg);

            return Boolean.TRUE;
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        } finally {
            if (null != jmsQueueSender) {
                try {
                    jmsQueueSender.close();
                } catch (JMSException e) {
                    // Nothins special
                }
            }
            if (null != jmsSession) {
                try {
                    jmsSession.close();
                } catch (JMSException e) {
                    // Nothins special
                }
            }
            if (null != jmsQueueConnection) {
                try {
                    jmsQueueConnection.close();
                } catch (JMSException e) {
                    // Nothins special
                }
            }
        }
    }

}
