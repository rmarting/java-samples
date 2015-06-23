<html>
<head>
	<title>Testing JMS</title>
</head>
<body>
<h2>Testing JMS !</h2>

<form action="AMQServlet" method="get">
	<label>JMS Connection Factory: </label><input type="text" id="connectionFactory" name="connectionFactory" value="java:/AMQConnectionFactory"/><br/>
	<label>JMS Queue: </label><input type="text" id="queue" name="queue" value="java:/amq/queue/sampleQueue"/><br/>
	<label>JMS Message: </label><input type="text" id="message" name="message" value="Message to send"/><br/>		
	<br/><br/>	

	<input type="submit"/>
</form>
</body>
</html>
