Notes
=====

# Prerrequisites

Download Software
  https://access.redhat.com/jbossnetwork/restricted/listSoftware.html?product=jboss.amq&downloadType=distributions
  
Install JBoss Fuse 6.1

Apply Patch Rollup 2 (or superior) 
  https://access.redhat.com/solutions/1361663

# JBoss Fuse Setup
In both cases it is needed to create a queue called sampleQueue

## JBoss Fuse Standalone
No more special configuration

## JBoss Fuse Fabric
Create new MQ Broker (Master/Slave)

Edit mq/base profile to define a new parameter to set the port number to be used. Edit broker.xml in this profile to change
the transportConnectors section. We define a new openwire uri with a new port:

        <transportConnectors>
		  	<!--
            <transportConnector name="openwire" uri="tcp://${bind.address}:0"/>
			-->
		  	<transportConnector name="openwire" uri="tcp://${bind.address}:${amq.port}"/>
        </transportConnectors>

Edit the profile created for the new MQ broker to define a new parameter with the port number to use.

org.fusesource.mq.fabric.<name>.properties
  # data = ${karaf.base}/data/amq-broker
  # Define a shared folder to store MQ data (Based to Fuse home)
  data = ${karaf.home}/data/amq-broker
  # New port
  amq.port=50000

Finally restart the containers

# JBoss EAP Setup
Install Active-MQ RAR in JBoss EAP.
  https://access.redhat.com/documentation/en-US/Red_Hat_JBoss_A-MQ/6.1/html-single/Integrating_with_JBoss_Enterprise_Application_Platform/
  
Define the following block in standalone-full.xml or standalone-ha.xml:

NOTE: The final uri depends of Fuse topology used (standalone, fabric)

  Standalone: tcp://localhost:61616
  Fabric:     tcp://<local-ip>:<amq.port>,tcp://localhost:<amq.port>

        <subsystem xmlns="urn:jboss:domain:resource-adapters:1.1">
            <resource-adapters>
                <resource-adapter id="activemq­rar.rar">
                    <archive>
                        activemq-rar-5.9.0.redhat-610379.rar
                    </archive>
                    <transaction-support>XATransaction</transaction-support>
                    <config-property name="Password">
                        admin
                    </config-property>
                    <config-property name="UserName">
                        admin
                    </config-property>
                    <!-- Configuration AMQ Standalone -->
                    <!-- 
                    <config-property name="ServerUrl">
                        failover:(tcp://localhost:61616)?jms.rmIdFromConnectionId=true&amp;maxReconnectAttempts=10
                    </config-property>
                    -->
                    <!-- Config AMQ Fabric -->
                    <config-property name="ServerUrl">
                        failover:(tcp://<local-ip>:<amq.port>,tcp://localhost:<amq.port>)?jms.rmIdFromConnectionId=true&amp;backup=true&amp;maxReconnectAttempts=10
                    </config-property>
                    <connection-definitions>
                        <connection-definition class-name="org.apache.activemq.ra.ActiveMQManagedConnectionFactory" 
                        	jndi-name="java:/AMQConnectionFactory" enabled="true" use-java-context="true" 
                        	pool-name="AMQConnectionFactory">
								<xa-pool>  
									<min-pool-size>1</min-pool-size>  
									<max-pool-size>100</max-pool-size>  
									<prefill>false</prefill>  
								</xa-pool>  
                        </connection-definition>
                    </connection-definitions>
                    <admin-objects>
                        <admin-object class-name="org.apache.activemq.command.ActiveMQQueue" jndi-name="amq/queue/sampleQueue" use-java-context="true" pool-name="sampleQueue">
                            <config-property name="PhysicalName">
                                sampleQueue
                            </config-property>
                        </admin-object>
                    </admin-objects>
                </resource-adapter>
            </resource-adapters>
        </subsystem>

# Aplication Test

## Web Browser
Open a browser using the following link: http://localhost:8080/amq-sample

This application sends a test message for each request

## Apache JMeter Test Suite
There is a JMeter Test Suite in src/test/resources/jmeter

This test sends several messages to this application
