<html>
<head>
    <title>Session test App</title>
</head>
<body>
<center>
    <h1>Session Replication test App.</h1>
    <%
         session.setAttribute("SessionKey","SessionKeyValue Set at "+new java.util.Date());
         System.out.println("\n\t index.jsp setAttribute() called on Session with value = "+(String)session.getAttribute("SessionKey"));
    %>
   	<h2>Attribute "SessionKey" is set in the HttpSession</h2>
    session.getAttribute("SessionKey") = <%=session.getAttribute("SessionKey") %>   
    <br/><br/>
    session.getId() = <%= session.getId() %>  
    <br/><br/>
   	<a href="sessionCheck.jsp">Click Here to move to nextPage sessionCheck.jsp</a>
</center>
<br/><br/>
<b><font color="red">NOTE:</font></b> Please check the value of HttpSession Attribute which displays the timestamp when the attribute was created & set inside the HttpSession.
 Which is useful to check whether it's a new HttpSession with new Attribute or the replicated HttpSession with the same attribute.
<br/>
As many times you will refresh the "index.jsp" page a new HttpSession attribute will be added with current TimeStamp.
</body>
</html>
