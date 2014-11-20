<html>
<head>
	<title>Testing JBoss DataSources</title>
</head>
<body>
<h2>Testing JBoss DataSources !</h2>

<form action="DataSourceServlet" method="get">
<label>JNDI DataSource Name: </label><input type="text" id="ds" name="ds" value="jboss/datasources/ExampleDS"/><br/>
<label>User: </label><input type="text" id="user" name="user" value="sa" /><br/>
<label>Password: </label><input type="text" id="pwd" name="pwd" value="sa" /><br/>
<br/>
<label>Do you want to close the connection?</label><input type="checkbox" id="close" name="close" value="true" checked="checked" /><br/>
<br/>
<input type="submit"/>
</form>
</body>
</html>
